package com.example.androidshop;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private String imageLink;
    private int price;

    public Product(String name, String description, String imageLink, int price) {
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" +
                "'name':'" + name + '\'' +
                ", 'description':'" + description + '\'' +
                ", 'imageLink':'" + imageLink + '\'' +
                ", 'price':" + price +
                '}';
    }
}
