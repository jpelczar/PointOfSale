package pl.jpelczar.pos_app.output.printer;

import pl.jpelczar.pos_app.base.BaseUI;
import pl.jpelczar.pos_framework.model.Receipt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jpelczar on 29.06.16.
 */
public class PrinterUI extends BaseUI implements PrinterMvpView {

    private TextArea receiptTextPrint;
    private PrinterPresenter presenter;

    public PrinterUI() throws HeadlessException {
        super("Printer");
        presenter = new PrinterPresenter(this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setLayout(new GridLayout(1, 1));

        receiptTextPrint = new TextArea("");
        receiptTextPrint.setEditable(false);

        add(receiptTextPrint);
        setVisible(true);
    }

    public void print(Receipt receipt) {
        receiptTextPrint.setText(presenter.convertReceipt(receipt));
    }

}
