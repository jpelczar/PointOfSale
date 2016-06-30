package pl.jpelczar.pos_framework;

import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;

import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public interface PointOfSaleAPI {

    /**
     * Method for invoke barcode scan
     *
     * @param callback - invoke when scanner end work
     */
    void scan(ScanCallback callback);

//    void confirmScannedProduct(Product product, int count); //have only one input device - barcode scanner

    /**
     * Method for begin new receipt
     */
    void startReceipt();

    /**
     * End current receipt. E.g save to database.
     *
     * @return current closed receipt
     */
    Receipt closeReceipt();

    /**
     * @return all persisted products
     */
    List<Product> getProducts();

    /**
     * @return current receipt
     */
    Receipt getReceipt();

    /**
     * Add product int database, storage
     *
     * @param product
     */
    void addProduct(Product product);

}
