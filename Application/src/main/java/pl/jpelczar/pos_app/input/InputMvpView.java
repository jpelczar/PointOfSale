package pl.jpelczar.pos_app.input;

import pl.jpelczar.pos_app.base.MvpView;
import pl.jpelczar.pos_framework.model.Product;

/**
 * Created by jpelczar on 29.06.16.
 */
public interface InputMvpView extends MvpView {

    void onSuccessScan(Product product);

    void onProductNotFound(String message);

    void onInvalidBarcode(String message);
}
