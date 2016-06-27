package pl.jpelczar.pos_framework.scanner;

import com.sun.istack.internal.Nullable;
import pl.jpelczar.pos_framework.database.DatabaseManager;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.barcode.Barcode;
import pl.jpelczar.pos_framework.model.barcode.UPC_A;

import java.util.List;
import java.util.Random;

/**
 * Created by jpelczar on 28.06.16.
 */
public class Scanner {

    List<Product> productList;

    @Nullable
    public Barcode scan() throws Exception {
        productList = DatabaseManager.getRepositoryInstance().getProductDao().getAll();
        Random random = new Random();
        if (random.nextFloat() < 0.8f) {
            if (random.nextBoolean()) {
                int productPosition = random.nextInt(productList.size());
                Product product = productList.get(productPosition);
                return new UPC_A(product.getId(), (int) random.nextFloat() * 1000000);
            }
            return new UPC_A((int) random.nextFloat() * 1000000, (int) random.nextFloat() * 1000000);
        }
        return null;
    }

}
