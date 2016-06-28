package pl.jpelczar.pos_app.input;

import pl.jpelczar.pos_app.base.Presenter;
import pl.jpelczar.pos_framework.ScanCallback;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;
import pl.jpelczar.pos_framework.model.barcode.Barcode;

/**
 * Created by jpelczar on 29.06.16.
 */
public class InputPresenter extends Presenter<InputMvpView> {

    ScanCallback scanCallback;

    boolean isReceiptStarted = false;

    public InputPresenter(InputMvpView mvpView) {
        super(mvpView);

        scanCallback = new ScanCallback() {
            @Override
            public void onSuccess(Product product, Barcode barcode) {
                mvpView.onSuccessScan(product);
            }

            @Override
            public void onNotFound(Barcode barcode, String message) {
                mvpView.onProductNotFound(message);
            }

            @Override
            public void invalidBarcode(String message) {
                mvpView.onInvalidBarcode(message);
            }
        };

    }

    public void scan() {
        if (!isReceiptStarted) {
            pointOfSale.startReceipt();
            isReceiptStarted = true;
        }
        pointOfSale.scan(scanCallback);
    }


    public Receipt closeReceipt() {
        isReceiptStarted = false;
        return pointOfSale.closeReceipt();
    }
}
