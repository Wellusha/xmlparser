package com.wellusha.xmlparser.repository;

import com.wellusha.xmlparser.model.entity.BoxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxEntityRepository extends CrudRepository<BoxEntity, Integer> {
}
