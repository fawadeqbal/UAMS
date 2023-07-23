package view;

import view.forms.LoginUI;
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
