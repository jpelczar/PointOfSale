package pl.jpelczar.pos_framework;

import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.barcode.Barcode;

/**
 * Created by jpelczar on 27.06.16.
 */
public interface ScanCallback {

    void onSuccess(Product product, Barcode barcode);

    void onNotFound(Barcode barcode, String message);

    void invalidBarcode(String message);
}
