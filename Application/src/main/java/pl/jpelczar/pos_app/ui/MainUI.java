package pl.jpelczar.pos_app.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jpelczar on 26.06.16.
 */
public class MainUI extends JFrame {

    public MainUI() throws HeadlessException {
        super("Point of Sale");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

    }
}
