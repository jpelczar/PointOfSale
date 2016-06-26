package pl.jpelczar.pos_framework.database;

import pl.jpelczar.pos_framework.database.dao.IProductDao;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDatabase {

    IProductDao getProductDao();

}
