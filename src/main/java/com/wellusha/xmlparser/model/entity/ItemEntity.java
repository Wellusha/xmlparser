package com.wellusha.xmlparser.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class ItemEntity implements Serializable {
    @Id
    private Integer id;

    @Column(name = "contained_in")
    private Integer containedIn;

    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContainedIn() {
        return containedIn;
    }

    public void setContainedIn(Integer containedIn) {
        this.containedIn = containedIn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
