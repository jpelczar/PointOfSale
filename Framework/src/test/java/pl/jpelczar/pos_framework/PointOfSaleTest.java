package pl.jpelczar.pos_framework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.jpelczar.pos_framework.database.DatabaseManager;
import pl.jpelczar.pos_framework.database.IDatabase;
import pl.jpelczar.pos_framework.database.dao.IProductDao;
import pl.jpelczar.pos_framework.database.dao.IReceiptDao;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;
import pl.jpelczar.pos_framework.model.ReceiptProduct;
import pl.jpelczar.pos_framework.model.barcode.Barcode;
import pl.jpelczar.pos_framework.model.barcode.UPC_A;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public class PointOfSaleTest {

    private PointOfSale pointOfSale;
    private Product testProduct;

    @Before
    public void setUp() throws Exception {
        DatabaseManager.setRepositoryInstance(new IDatabase() {

            IProductDao productDao = new IProductDao() {
                private final List<Product> products = new ArrayList<>();

                @Override
                public void insert(Product product) {
                    products.add(product);
                }

                @Override
                public void delete(Product product) {
                    products.remove(product);
                }

                @Override
                public void insertOrUpdate(Product product) {
                    products.remove(product);
                    products.add(product);
                }

                @Override
                public Product get(Integer integer) {
                    for (Product p : products) {
                        if (p.getId().equals(integer)) {
                            return p;
                        }
                    }
                    return null;
                }

                @Override
                public List<Product> getAll() {
                    return products;
                }
            };

            IReceiptDao receiptDao = new IReceiptDao() {
                private final List<Receipt> receipts = new ArrayList<>();

                @Override
                public void insert(Receipt product) {
                    receipts.add(product);
                }

                @Override
                public void delete(Receipt product) {
                    receipts.remove(product);
                }

                @Override
                public void insertOrUpdate(Receipt product) {
                    receipts.remove(product);
                    receipts.add(product);
                }

                @Override
                public Receipt get(Long id) {
                    for (Receipt p : receipts) {
                        if (p.getId().equals(id)) {
                            return p;
                        }
                    }
                    return null;
                }

                @Override
                public List<Receipt> getAll() {
                    return receipts;
                }
            };

            @Override
            public IProductDao getProductDao() {
                return productDao;
            }

            @Override
            public IReceiptDao getReceiptDao() {
                return receiptDao;
            }
        });

        pointOfSale = new PointOfSale();
        testProduct = new Product(123456, "Product", 13);
        pointOfSale.addProduct(testProduct);
    }

    @Test
    public void addProductTest() throws Exception {
        Assert.assertTrue(pointOfSale.getProducts().size() == 1);
    }

    @Test
    public void receiptTest() throws Exception {
        int count = 3;
        pointOfSale.startReceipt();
        pointOfSale.getReceipt().addProduct(new ReceiptProduct(testProduct, count));
        Assert.assertTrue(pointOfSale.getReceipt().getTotalPrice() == testProduct.getPrice() * count);
        Assert.assertTrue(pointOfSale.closeReceipt().getProductList().size() == 1);
    }

    @Test
    public void scanTest() throws Exception {
        pointOfSale.scan(new ScanCallback() {
            @Override
            public void onSuccess(Product product, Barcode barcode) {
                if (barcode instanceof UPC_A)
                    Assert.assertTrue(product.getId().equals(((UPC_A) barcode).getLeftNumericalDigit())); //according to Product id description
            }

            @Override
            public void onNotFound(Barcode barcode, String message) {
                Assert.assertNotNull(message, barcode);
            }

            @Override
            public void invalidBarcode(String message) {
                Assert.assertTrue(true);
            }
        });
    }
}