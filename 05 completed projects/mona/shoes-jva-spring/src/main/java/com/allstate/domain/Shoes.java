package com.allstate.domain;
import javax.persistence.*;

@Entity
@Table(name = "shoeinfo")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;

    private String colour;
    private Double price;
    private String size;

    public Shoes (){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "Id=" + id +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
