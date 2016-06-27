package pl.jpelczar.pos_app.config.database;

import pl.jpelczar.pos_framework.database.dao.IProductDao;
import pl.jpelczar.pos_framework.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public class ProductDao implements IProductDao {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void insert(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public void insertOrUpdate(Product product) {
        products.remove(product);
        products.add(product);
    }

    @Override
    public Product get(Integer integer) {
        for (Product p : products) {
            if (p.getId().equals(integer)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
