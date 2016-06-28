package pl.jpelczar.pos_app;

import pl.jpelczar.pos_app.config.Config;
import pl.jpelczar.pos_app.input.InputUi;

/**
 * Created by jpelczar on 25.06.16.
 */
public class Main {
    public static void main(String[] argv) {
        Config.configure();

        InputUi inputUi = new InputUi();
        inputUi.setVisible(true);
    }
}
