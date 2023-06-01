package ui;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import ui.authenticate.LoginUI;
import javax.swing.*;


public class UAS {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Create and display the login form
        SwingUtilities.invokeLater(() -> {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
        });
    }
}



