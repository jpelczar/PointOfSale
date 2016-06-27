package pl.jpelczar.pos_framework.database;

import pl.jpelczar.pos_framework.database.dao.IProductDao;
import pl.jpelczar.pos_framework.database.dao.IReceiptDao;

/**
 * Created by jpelczar on 26.06.16.
 */
public interface IDatabase {

    IProductDao getProductDao();

    IReceiptDao getReceiptDao();

}
