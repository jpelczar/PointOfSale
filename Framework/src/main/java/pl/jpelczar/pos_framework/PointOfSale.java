package pl.jpelczar.pos_framework;

import pl.jpelczar.pos_framework.database.DatabaseManager;
import pl.jpelczar.pos_framework.database.IDatabase;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;
import pl.jpelczar.pos_framework.model.ReceiptProduct;
import pl.jpelczar.pos_framework.model.barcode.Barcode;
import pl.jpelczar.pos_framework.model.barcode.UPC_A;
import pl.jpelczar.pos_framework.scanner.Scanner;

import java.util.Calendar;
import java.util.List;

/**
 * Created by jpelczar on 27.06.16.
 */
public class PointOfSale implements PointOfSaleAPI {

    private IDatabase database;
    private Scanner scanner;
    private Receipt receipt;

    public PointOfSale() {
        database = DatabaseManager.getRepositoryInstance();
        scanner = new Scanner();
        receipt = new Receipt();
    }

    @Override
    public void scan(ScanCallback callback) { //it is a mock, normally it should be connected with barcode scanner
        try {
            Barcode barcode = scanner.scan();
            if (barcode == null) {
                callback.invalidBarcode("Invalid barcode");
            } else {
                if (barcode instanceof UPC_A) {
                    Product product = database.getProductDao().get(((UPC_A) barcode).getLeftNumericalDigit()); //according to Product id description
                    if (product != null) {
                        receipt.addProduct(new ReceiptProduct(product, 1));
                        callback.onSuccess(product, barcode);
                    } else {
                        callback.onNotFound(barcode, "Product not found");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startReceipt() {
        receipt = new Receipt();
    }

    @Override
    public Receipt closeReceipt() {
        if (receipt.getProductList().size() > 0) {
            receipt.setDate(Calendar.getInstance().getTimeInMillis());
            database.getReceiptDao().insert(receipt);
        }
        return getReceipt();
    }

    @Override
    public List<Product> getProducts() {
        return database.getProductDao().getAll();
    }

    @Override
    public Receipt getReceipt() {
        return receipt;
    }

    @Override
    public void addProduct(Product product) {
        database.getProductDao().insert(product);
    }

}
