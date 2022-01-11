package com.example.androidshop;
import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;
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

    public Product(JSONObject jsonObject) throws JSONException {

        this.name = jsonObject.get(Constance.JsonHeaders.PRODUCT_NAME_HEADER).toString();
        this.description = jsonObject.get(Constance.JsonHeaders.PRODUCT_DESCRIPTION_HEADER).toString();
        this.imageLink = jsonObject.get(Constance.JsonHeaders.PRODUCT_IMAGE_LINK_HEADER).toString();
        this.price = tryParseInt(jsonObject.get(Constance.JsonHeaders.PRODUCT_PRICE_HEADER).toString());
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

    public Integer tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", price=" + price +
                '}';
    }

}
