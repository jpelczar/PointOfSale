package pl.jpelczar.pos_framework.database.dao;

import java.util.List;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDao<T, ID> {

    void insert(T t);

    void delete(T t);

    void update(T t);

    T get(ID id);

    List<T> getAll();
}
