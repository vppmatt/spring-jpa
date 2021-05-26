package com.multicode.electronics.components.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="description_id")
    private Integer descriptionId;

    @Column(name ="cross_sells")
    private String crossSells;

    @Column(name="up_sells")
    private String upSells;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getCrossSells() {
        return crossSells;
    }

    public void setCrossSells(String crossSells) {
        this.crossSells = crossSells;
    }

    public String getUpSells() {
        return upSells;
    }

    public void setUpSells(String upSells) {
        this.upSells = upSells;
    }
}
