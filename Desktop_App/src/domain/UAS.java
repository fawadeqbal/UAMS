package domain;
import ui.authenticate.LoginUI;
import javax.swing.*;


public class UAS {
    public static void main(String[] args) {
        
        // Create and display the login form
        SwingUtilities.invokeLater(() -> {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
        });
    }
}



