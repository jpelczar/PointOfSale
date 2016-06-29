package pl.jpelczar.pos_app.input;

import pl.jpelczar.pos_app.base.BaseUI;
import pl.jpelczar.pos_app.output.display.LCD;
import pl.jpelczar.pos_app.output.printer.PrinterUI;
import pl.jpelczar.pos_framework.model.Product;
import pl.jpelczar.pos_framework.model.Receipt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jpelczar on 26.06.16.
 */
public class InputUI extends BaseUI implements InputMvpView {

    private InputPresenter presenter;

    private Button scanButton;
    private Button exitButton;
    private PrinterUI printer;
    private LCD lcd;

    private int height = 100;
    private int width = 400;

    public InputUI() throws HeadlessException {
        super("Input");

        presenter = new InputPresenter(this);
        printer = new PrinterUI();
        lcd = new LCD();

        printer.setLocation(getLocation().x, getLocation().y + height + 50);
        lcd.setLocation(getLocation().x + width + 50, getLocation().y);
        printer.setVisible(true);
        lcd.setVisible(true);

        initContainer();

        scanButton = new Button("Scan");
        exitButton = new Button("Print");

        setListeners();

        add(scanButton);
        add(exitButton);
    }

    private void initContainer() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
    }


    private void setListeners() {
        scanButton.addActionListener(e -> presenter.scan());

        exitButton.addActionListener(e -> {
            Receipt receipt = presenter.closeReceipt();
            printer.print(receipt);
            lcd.printMessage("Total price: " + String.format("%10.2f", receipt.getTotalPrice()));
        });
    }

    @Override
    public void onSuccessScan(Product product) {
        lcd.printMessage(product.toString());
    }

    @Override
    public void onProductNotFound(String message) {
        lcd.printMessage(message);
    }

    @Override
    public void onInvalidBarcode(String message) {
        lcd.printMessage(message);
    }
}
