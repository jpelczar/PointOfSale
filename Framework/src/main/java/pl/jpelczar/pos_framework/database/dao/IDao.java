package pl.jpelczar.pos_framework.database.dao;

import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDao<T, ID> {

    void insert(T t);

    void delete(T t);

    void insertOrUpdate(T t);

    @Nullable
    T get(ID id);

    List<T> getAll();
}
