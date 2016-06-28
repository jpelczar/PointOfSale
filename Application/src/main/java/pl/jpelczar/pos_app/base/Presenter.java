package pl.jpelczar.pos_app.base;

import pl.jpelczar.pos_app.config.Config;
import pl.jpelczar.pos_framework.PointOfSale;

/**
 * Created by jpelczar on 29.06.16.
 */
public abstract class Presenter<T extends MvpView> {

    protected PointOfSale pointOfSale;
    protected T mvpView;

    public Presenter(T mvpView) {
        this.mvpView = mvpView;
        this.pointOfSale = Config.getPointOfSaleInstance();
    }
}
