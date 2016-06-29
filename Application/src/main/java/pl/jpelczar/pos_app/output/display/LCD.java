package pl.jpelczar.pos_app.output.display;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jpelczar on 29.06.16.
 */
public class LCD extends JFrame {

    private Label screen;

    public LCD() throws HeadlessException {
        super("LCD");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(400, 100);
        setResizable(false);
        setLayout(new GridLayout(1, 1));

        screen = new Label();
        add(screen);
    }

    public void printMessage(String message) {
        screen.setText(message);
    }
}
