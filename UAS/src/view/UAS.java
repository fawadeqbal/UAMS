package view;

import view.forms.LoginUI;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
public class UAS {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
           
        }

        LoginUI loginScreen = new LoginUI();
        loginScreen.setVisible(true); 

    }
}
