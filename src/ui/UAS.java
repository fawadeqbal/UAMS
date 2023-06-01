package ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ui.signin.LoginUI;

public class UAS {
    public static void main(String[] args) {
        // Create and display the login form
        try{
        UIManager.setLookAndFeel(new FlatLightLaf());
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
        SwingUtilities.invokeLater(() -> {
            LoginUI loginScreen = new LoginUI();
            loginScreen.setVisible(true);
        });
    }
}



