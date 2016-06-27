package pl.jpelczar.pos_framework;

import com.sun.istack.internal.Nullable;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.barcode.Barcode;

/**
 * Created by jpelczar on 27.06.16.
 */
public interface ScanCallback {

    void onSuccess(Product product, Barcode barcode);

    void onNotFound(Barcode barcode, @Nullable String message);

    void invalidBarcode(@Nullable String message);
}
