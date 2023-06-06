package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import ui.components.LoginUI;
import javax.swing.*;

public class UAS {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoginUI loginScreen = new LoginUI();
        loginScreen.setVisible(true); 

    }
}
