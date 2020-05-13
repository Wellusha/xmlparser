package com.wellusha.xmlparser.service;

import com.wellusha.xmlparser.model.ItemsInBoxReq;

import java.util.List;

public interface RestService {
    List<Integer> getItems(ItemsInBoxReq requestBody);
}
