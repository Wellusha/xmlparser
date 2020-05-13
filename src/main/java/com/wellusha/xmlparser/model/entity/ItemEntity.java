package com.wellusha.xmlparser.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "items")
public class ItemEntity implements Serializable {
    @Id
    private Long id;
    @OneToOne
    private BoxEntity box;
    private String color;

    public BoxEntity getBox() {
        return box;
    }

    public void setBox(BoxEntity box) {
        this.box = box;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
