package pl.jpelczar.pos_app;

import pl.jpelczar.pos_app.config.Config;
import pl.jpelczar.pos_app.ui.MainUI;

/**
 * Created by jpelczar on 25.06.16.
 */
public class Main {
    public static void main(String[] argv) {
        Config.configure();

        MainUI mainUi = new MainUI();
        mainUi.setVisible(true);
    }
}
