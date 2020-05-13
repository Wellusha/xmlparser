package com.wellusha.xmlparser.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wellusha.xmlparser.model.entity.BoxEntity;
import com.wellusha.xmlparser.model.entity.ItemEntity;
import com.wellusha.xmlparser.model.xml.BoxXml;
import com.wellusha.xmlparser.model.xml.ItemXml;
import com.wellusha.xmlparser.model.xml.StorageXml;
import com.wellusha.xmlparser.repository.BoxEntityRepository;
import com.wellusha.xmlparser.repository.ItemEntityRepository;
import com.wellusha.xmlparser.service.ParseAndUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseAndUpdateServiceImpl implements ParseAndUpdateService {
    private final BoxEntityRepository boxEntityRepository;
    private final ItemEntityRepository itemEntityRepository;

    @Autowired
    public ParseAndUpdateServiceImpl(BoxEntityRepository boxEntityRepository, ItemEntityRepository itemEntityRepository) {
        this.boxEntityRepository = boxEntityRepository;
        this.itemEntityRepository = itemEntityRepository;
    }

    @Override
    public void parseAndUpdate(String filename) {
        StorageXml xml = parse(filename);
        mapAndUpdate(xml);
    }

    private StorageXml parse(String filename) {
        ObjectMapper mapper = new XmlMapper();
        StorageXml xml = null;
        try {
            File file = new File(filename);
            xml = mapper.readValue(file, StorageXml.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    private void mapAndUpdate(StorageXml xml) {
        List<BoxEntity> boxes = new ArrayList<>();
        List<ItemEntity> items = new ArrayList<>();

        if (xml.getItems() != null)
            for (ItemXml itemXml : xml.getItems()) {
                ItemEntity item = new ItemEntity();
                item.setContainedIn(null);
                item.setId(itemXml.getId().intValue());
                item.setColor(itemXml.getColor());
                items.add(item);
            }

        recursivelyMap(xml.getBoxes(), boxes, items, null);

        boxEntityRepository.saveAll(boxes);
        itemEntityRepository.saveAll(items);
    }

    private void recursivelyMap(List<BoxXml> xmlBoxes, List<BoxEntity> boxes, List<ItemEntity> items, Integer containerId) {
        ItemEntity item;
        BoxEntity box;

        if (xmlBoxes == null)
            return;

        for (BoxXml boxXml : xmlBoxes) {
            recursivelyMap(boxXml.getBoxes(), boxes, items, boxXml.getId().intValue());

            if (boxXml.getItems() != null)
                for (ItemXml itemXml : boxXml.getItems()) {
                    item = new ItemEntity();
                    item.setContainedIn(boxXml.getId().intValue());
                    item.setColor(itemXml.getColor());
                    item.setId(itemXml.getId().intValue());
                    items.add(item);
                }

            box = new BoxEntity();
            box.setContainedIn(containerId);
            box.setId(boxXml.getId().intValue());
            boxes.add(box);
        }

    }
}
