package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import ui.authenticate.LoginUI;
import javax.swing.*;

public class UAS {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        LoginUI loginScreen = new LoginUI();
        loginScreen.setVisible(true); 

    }
}
