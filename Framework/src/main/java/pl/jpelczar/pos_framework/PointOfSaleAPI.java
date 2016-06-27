package pl.jpelczar.pos_framework;

import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;

import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public interface PointOfSaleAPI {

    void scan(ScanCallback callback);

//    void confirmScannedProduct(Product product, int count); //have only one input device - barcode scanner

    void startReceipt();

    Receipt closeReceipt();

    List<Product> getProducts();

    Receipt getReceipt();

    void addProduct(Product product);

}
