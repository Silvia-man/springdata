package com.damo.modal;

public class Product {
    private Integer id;
    private Double price;

    public Product() {
    }

    public Product(Double price, String name) {
        this.id = -1;
        this.price = price;
        this.name = name;
    }

    public Product(Integer id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Product{ id=" + id + ", price=" + price + ", name='" + name + "'}";
    }
}
