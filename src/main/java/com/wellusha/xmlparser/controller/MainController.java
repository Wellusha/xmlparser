package com.wellusha.xmlparser.controller;

import com.wellusha.xmlparser.model.ItemsInBoxReq;
import com.wellusha.xmlparser.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("")
public class MainController {
    private final RestService restService;

    @Autowired
    public MainController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping
    public List<Integer> getItems(@RequestBody ItemsInBoxReq requestBody) {
        return restService.getItems(requestBody);
    }
}
