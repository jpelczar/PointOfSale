package pl.jpelczar.pos_framework.database.dao;

import pl.jpelczar.pos_framework.model.IDatabaseModel;

import java.util.List;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDao<T extends IDatabaseModel, ID> {

    void insert(T t);

    void delete(T t);

    void insertOrUpdate(T t);

    T get(ID id);

    List<T> getAll();
}
