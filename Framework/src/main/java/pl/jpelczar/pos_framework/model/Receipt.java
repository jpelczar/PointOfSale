package pl.jpelczar.pos_framework.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jpelczar on 25.06.16.
 */
public class Receipt implements Serializable {

    private long date;
    private List<Product> productList;
    private float totalPrice;

    public Receipt() {
        this.productList = new ArrayList<>();
        totalPrice = 0;
    }

    public Receipt(List<Product> productList, float totalPrice) {
        this.date = Calendar.getInstance().getTimeInMillis();
        this.productList = productList;
        this.totalPrice = totalPrice;
    }

    public Receipt(long date, List<Product> productList, float totalPrice) {
        this.date = date;
        this.productList = productList;
        this.totalPrice = totalPrice;
    }

    public void addProduct(Product product) {
        productList.add(product);
        totalPrice += product.getPrice();
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
