package pl.jpelczar.pos_framework.model;

/**
 * Created by jpelczar on 25.06.16.
 */
public class Product implements IDatabaseModel<Integer> {

    private String name;
    private float price;
    private Integer id; //Product id - for UPC-A it is a leftNumericalDigit

    public Product() {
    }

    public Product(int id, String name, float price) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
