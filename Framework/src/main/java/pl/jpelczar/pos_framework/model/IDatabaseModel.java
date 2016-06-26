package pl.jpelczar.pos_framework.model;

import java.io.Serializable;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDatabaseModel<T> extends Serializable {

    T getId();

}
