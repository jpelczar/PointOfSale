package pl.jpelczar.pos_framework.model;

import java.io.Serializable;

/**
 * Created by jpelczar on 25.06.16.
 */
public class Product implements Serializable{

    private String name;
    private float price;

    public Product() {
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + " have price: " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
