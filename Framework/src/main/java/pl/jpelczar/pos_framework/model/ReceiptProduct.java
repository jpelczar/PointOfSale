package pl.jpelczar.pos_framework.model;

import java.io.Serializable;

/**
 * Created by jpelczar on 26.06.16.
 */
public class ReceiptProduct implements Serializable {
    private Product product;
    private int quantity;
    private float totalPrice;

    public ReceiptProduct() {
    }

    public ReceiptProduct(Product product, int quantity) {
        setProduct(product, quantity);
    }

    public void setProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
