package pl.jpelczar.pos_app.ui;

import pl.jpelczar.pos_app.config.Config;
import pl.jpelczar.pos_framework.PointOfSale;
import pl.jpelczar.pos_framework.ScanCallback;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.barcode.Barcode;

import javax.swing.*;
import java.awt.*;

import static pl.jpelczar.pos_app.utils.Log.echo;

/**
 * Created by jpelczar on 26.06.16.
 */
public class InputUi extends JFrame {

    PointOfSale pointOfSale;
    ScanCallback scanCallback;

    Button scanButton;
    Button exitButton;

    boolean isReceiptStarted = false;

    public InputUi() throws HeadlessException {
        super("Input");
        pointOfSale = Config.getPointOfSaleInstance();

        initContainer();

        scanButton = new Button("Scan");
        exitButton = new Button("Print");

        scanCallback = new ScanCallback() {
            @Override
            public void onSuccess(Product product, Barcode barcode) {
                echo(product.toString());
            }

            @Override
            public void onNotFound(Barcode barcode, String message) {
                echo(message);
            }

            @Override
            public void invalidBarcode(String message) {
                echo(message);
            }
        };

        setListeners();

        add(scanButton);
        add(exitButton);
    }

    private void initContainer() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 100);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
    }


    private void setListeners() {
        scanButton.addActionListener(e -> {
            if (!isReceiptStarted) {
                pointOfSale.startReceipt();
                isReceiptStarted = true;
            }
            pointOfSale.scan(scanCallback);
        });

        exitButton.addActionListener(e -> {
            echo(pointOfSale.closeReceipt().toString());
            isReceiptStarted = false;
        });
    }
}
