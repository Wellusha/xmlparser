package com.wellusha.xmlparser;

import com.wellusha.xmlparser.service.impl.XmlParseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlParserApplication.class, args);
        XmlParseServiceImpl service = new XmlParseServiceImpl();
        service.parse("test.xml");
    }

}
