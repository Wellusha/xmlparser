package com.wellusha.xmlparser.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoxXml implements Serializable {
    private Long id;
    @JacksonXmlProperty(localName = "Box")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BoxXml> boxes;
    @JacksonXmlProperty(localName = "Item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ItemXml> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BoxXml> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxXml> boxes) {
        if (this.boxes == null){
            this.boxes = new ArrayList<>(boxes.size());
        }
        this.boxes.addAll(boxes);
    }

    public List<ItemXml> getItems() {
        return items;
    }

    public void setItems(List<ItemXml> items) {
        if (this.items == null){
            this.items = new ArrayList<>(items.size());
        }
        this.items.addAll(items);
    }
}
