package pl.jpelczar.pos_app.base;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jpelczar on 29.06.16.
 */
public abstract class BaseUI extends JFrame {
    public BaseUI(String title) throws HeadlessException {
        super(title);
    }
}
