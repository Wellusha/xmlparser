package com.wellusha.xmlparser.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "boxes")
public class BoxEntity implements Serializable {
    @Id
    private Integer id;

    @OneToOne
    private BoxEntity box;

    @OneToMany
    private List<ItemEntity> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BoxEntity getBox() {
        return box;
    }

    public void setBox(BoxEntity box) {
        this.box = box;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
