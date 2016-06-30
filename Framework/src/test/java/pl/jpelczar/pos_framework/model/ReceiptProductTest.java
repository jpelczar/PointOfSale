package pl.jpelczar.pos_framework.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jpelczar on 26.06.16.
 */
public class ReceiptProductTest {

    private ReceiptProduct product;
    private int count = 5;
    private float price = 12.3f;
    private int id = 342134;

    @Before
    public void setUp() throws Exception {
        product = new ReceiptProduct(new Product(id, "name", price), count);
    }

    @Test
    public void getTotalPriceTest() throws Exception {
        Assert.assertTrue(product.getTotalPrice() == count * price);
    }

}