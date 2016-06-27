package pl.jpelczar.pos_app.config;

import pl.jpelczar.pos_app.config.database.ProductDao;
import pl.jpelczar.pos_app.config.database.ReceiptDao;
import pl.jpelczar.pos_framework.PointOfSale;
import pl.jpelczar.pos_framework.database.DatabaseManager;
import pl.jpelczar.pos_framework.database.IDatabase;
import pl.jpelczar.pos_framework.database.dao.IProductDao;
import pl.jpelczar.pos_framework.database.dao.IReceiptDao;
import pl.jpelczar.pos_framework.model.Product;

/**
 * Created by jpelczar on 27.06.16.
 */
public class Config {

    private static PointOfSale pointOfSale;

    public static void configure() {
        DatabaseManager.setRepositoryInstance(new IDatabase() {

            ProductDao productDao = new ProductDao();
            ReceiptDao receiptDao = new ReceiptDao();

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

        //Database mock block
        pointOfSale.addProduct(new Product(875219, "Product 1", 12.43f));
        pointOfSale.addProduct(new Product(563121, "Product 2", 2.19f));
        pointOfSale.addProduct(new Product(751561, "Product 3", 89.53f));
        pointOfSale.addProduct(new Product(601562, "Product 4", 9.01f));
        pointOfSale.addProduct(new Product(784526, "Product 5", 142f));
        pointOfSale.addProduct(new Product(315166, "Product 6", 1.99f));
        pointOfSale.addProduct(new Product(469676, "Product 7", 14.50f));
        pointOfSale.addProduct(new Product(457841, "Product 8", 122.34f));
    }

    public static PointOfSale getPointOfSaleInstance() {
        return pointOfSale;
    }

}
