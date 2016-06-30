package pl.jpelczar.pos_framework.scanner;

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

    public Barcode scan() throws Exception {
        productList = DatabaseManager.getRepositoryInstance().getProductDao().getAll();
        Random random = new Random();
        if (random.nextFloat() < 0.8f) {

            int productPosition = random.nextInt(productList.size());
            Product product = productList.get(productPosition);
            return new UPC_A(product.getId(), randomDigitsForBarcode()); //mock

        }
        if (random.nextBoolean()) {
            return null;
        }
        return new UPC_A(randomDigitsForBarcode(), randomDigitsForBarcode()); //mock
    }

    private int randomDigitsForBarcode() {
        return new Random().nextInt(900000) + 100000;
    }

}
