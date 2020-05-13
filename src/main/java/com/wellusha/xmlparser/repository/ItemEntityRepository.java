package com.wellusha.xmlparser.repository;

import com.wellusha.xmlparser.model.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends CrudRepository<ItemEntity, Integer> {
}
