package pl.jpelczar.pos_app.config.database;

import pl.jpelczar.pos_framework.database.dao.IReceiptDao;
import pl.jpelczar.pos_framework.model.Receipt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public class ReceiptDao implements IReceiptDao {
    private final List<Receipt> receipts = new ArrayList<>();

    @Override
    public void insert(Receipt product) {
        receipts.add(product);
    }

    @Override
    public void delete(Receipt product) {
        receipts.remove(product);
    }

    @Override
    public void insertOrUpdate(Receipt product) {
        receipts.remove(product);
        receipts.add(product);
    }

    @Override
    public Receipt get(Long id) {
        for (Receipt p : receipts) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Receipt> getAll() {
        return receipts;
    }
}
