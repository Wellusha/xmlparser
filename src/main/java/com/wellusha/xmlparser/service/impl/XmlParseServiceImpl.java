package com.wellusha.xmlparser.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wellusha.xmlparser.model.xml.StorageXml;
import com.wellusha.xmlparser.service.XmlParserService;

import java.io.File;

public class XmlParseServiceImpl implements XmlParserService {
    @Override
    public void parse(String filename) {
        ObjectMapper mapper = new XmlMapper();
        StorageXml xml = null;
        try {
            File file = new File(filename);
            xml = mapper.readValue(file, StorageXml.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert xml != null;
    }
}
