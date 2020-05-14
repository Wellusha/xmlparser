package com.wellusha.xmlparser.model;

import java.io.Serializable;

public class ItemsInBoxReq implements Serializable {
    private Integer box;
    private String color;

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
