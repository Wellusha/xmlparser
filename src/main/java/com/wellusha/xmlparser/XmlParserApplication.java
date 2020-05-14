package com.wellusha.xmlparser;

import com.wellusha.xmlparser.service.ParseAndUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class XmlParserApplication implements CommandLineRunner {

    private final ParseAndUpdateService parseAndUpdateService;

    @Autowired
    public XmlParserApplication(ParseAndUpdateService parseAndUpdateService) {
        this.parseAndUpdateService = parseAndUpdateService;
    }

    public static void main(String[] args) {
        SpringApplication.run(XmlParserApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Предполагаем, что имя файла в первом параметре
        if (args.length > 0)
            parseAndUpdateService.parseAndUpdate(args[0]);
        else
            parseAndUpdateService.parseAndUpdate("test.xml");
    }
}
