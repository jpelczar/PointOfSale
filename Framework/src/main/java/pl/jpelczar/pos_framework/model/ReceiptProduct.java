package pl.jpelczar.pos_framework.model;

import java.io.Serializable;

/**
 * Created by jpelczar on 26.06.16.
 */
public class ReceiptProduct implements Serializable {
    private Product product;
    private int count;
    private float totalPrice;

    public ReceiptProduct() {
    }

    public ReceiptProduct(Product product, int count) {
        setProduct(product, count);
    }

    public void setProduct(Product product, int count) {
        this.product = product;
        this.count = count;
        this.totalPrice = product.getPrice() * count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
