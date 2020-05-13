package com.wellusha.xmlparser.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StorageXml implements Serializable {
    @JacksonXmlProperty(localName = "Box")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BoxXml> boxes;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Item")
    private List<ItemXml> items;

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
