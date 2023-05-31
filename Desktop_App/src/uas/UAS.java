package uas;
import ui.signin.LoginUI;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

public class UAS {
    public static void main(String[] args) {
        FlatLightLaf.install();
        // Create and display the login form
        SwingUtilities.invokeLater(() -> {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
        });
    }
}



