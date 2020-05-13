package com.wellusha.xmlparser.service.impl;

import com.wellusha.xmlparser.model.ItemsInBoxReq;
import com.wellusha.xmlparser.model.entity.BoxEntity;
import com.wellusha.xmlparser.model.entity.ItemEntity;
import com.wellusha.xmlparser.repository.BoxEntityRepository;
import com.wellusha.xmlparser.repository.ItemEntityRepository;
import com.wellusha.xmlparser.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestServiceImpl implements RestService {
    private final ItemEntityRepository itemEntityRepository;
    private final BoxEntityRepository boxEntityRepository;

    @Autowired
    public RestServiceImpl(ItemEntityRepository itemEntityRepository, BoxEntityRepository boxEntityRepository) {
        this.itemEntityRepository = itemEntityRepository;
        this.boxEntityRepository = boxEntityRepository;
    }

    @Override
    public List<Integer> getItems(ItemsInBoxReq requestBody) {
        List<Integer> items = new ArrayList<>();

        List<ItemEntity> itemEntities = itemEntityRepository.findAllByColor(requestBody.getColor());

        // Количество запросов для худшего случая можно уменьшить, если добавить избыточности в БД
        // например, таблицу, где хранятся все ID контейнеров у ITEM'а
        for (ItemEntity item : itemEntities) {
            if (item.getContainedIn().equals(requestBody.getBox()))
                items.add(item.getId());
            else {
                BoxEntity containerBox = boxEntityRepository.findById(item.getContainedIn()).get();
                while (containerBox.getContainedIn() != null) {
                    if (containerBox.getContainedIn().equals(requestBody.getBox())) {
                        items.add(containerBox.getId());
                        break;
                    }
                    containerBox = boxEntityRepository.findById(containerBox.getContainedIn()).get();
                }
            }
        }

        return items;
    }
}
