package pl.jpelczar.pos_app.input;

import pl.jpelczar.pos_app.base.BaseUI;
import pl.jpelczar.pos_framework.model.Product;

import javax.swing.*;
import java.awt.*;

import static pl.jpelczar.pos_app.utils.Log.echo;

/**
 * Created by jpelczar on 26.06.16.
 */
public class InputUi extends BaseUI implements InputMvpView {

    InputPresenter presenter;

    Button scanButton;
    Button exitButton;

    public InputUi() throws HeadlessException {
        super("Input");

        presenter = new InputPresenter(this);

        initContainer();

        scanButton = new Button("Scan");
        exitButton = new Button("Print");

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
        scanButton.addActionListener(e -> presenter.scan());

        exitButton.addActionListener(e -> echo(presenter.closeReceipt().toString()));
    }

    @Override
    public void onSuccessScan(Product product) {
        echo(product.toString());
    }

    @Override
    public void onProductNotFound(String message) {
        echo(message);
    }

    @Override
    public void onInvalidBarcode(String message) {
        echo(message);
    }
}
