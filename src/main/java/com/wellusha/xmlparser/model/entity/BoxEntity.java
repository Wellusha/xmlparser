package com.wellusha.xmlparser.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "box")
public class BoxEntity implements Serializable {
    @Id
    private Integer id;

    @Column(name = "contained_in")
    private Integer containedIn;

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
}
