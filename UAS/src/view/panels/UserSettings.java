/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.UASController;
import java.util.Arrays;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.UASFactory;
import model.dto.Response;
import model.dto.UserDTO;

public class UserSettings extends JPanel {
    UASController objController;

    private JTextField emailField;
    private JPasswordField currentPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
   // private JCheckBox notificationsCheckbox;
    private JButton saveButton;
    JLabel emailLabel;
    JLabel currentPasswordLabel;
    JLabel newPasswordLabel;
    JLabel confirmPasswordLabel;
    private JLabel passwordMatchIndicatorLabel; // New label for the indicator

    private boolean passwordsMatch = false; 

    public UserSettings() {
         objController=UASFactory.getUASControllerInstance();
            initializeComponents();
            setupLayout();
            setupListeners();
        
    }

    private void initializeComponents() {
        emailLabel = new JLabel("Email:");
        currentPasswordLabel = new JLabel("Current Password:");
        newPasswordLabel = new JLabel("New Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        emailField = new JTextField(20);
        currentPasswordField = new JPasswordField(20);
        newPasswordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        //notificationsCheckbox = new JCheckBox("Agree");
        saveButton = new JButton("Save");
        passwordMatchIndicatorLabel = new JLabel();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("User Settings"), gbc);

        gbc.gridy++;
        add(new JLabel("______________________________"), gbc);

        gbc.gridy++;
        add(new JLabel(" "), gbc);


        gbc.gridy++;
        add(emailLabel, gbc);
        emailField.setText(UASController.objApplicationSession.getUser().getEmail());
        emailField.setEditable(false);
        gbc.gridy++;
        add(emailField, gbc);
        
        gbc.gridy++;
        add(currentPasswordLabel, gbc);

        gbc.gridy++;
        add(currentPasswordField, gbc);
        
        gbc.gridy++;
        add(newPasswordLabel, gbc);

        gbc.gridy++;
        add(newPasswordField, gbc);

        gbc.gridy++;
        add(confirmPasswordLabel, gbc);

        gbc.gridy++;
        add(confirmPasswordField, gbc);
        gbc.gridy++;
        add(passwordMatchIndicatorLabel, gbc);

//        gbc.gridy++;
//        add(notificationsCheckbox, gbc);

        gbc.gridy++;
        add(saveButton, gbc);
    }

    private void setupListeners() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String currentPassword = new String(currentPasswordField.getPassword());
                boolean notificationsEnabled = true;
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                // Save the user settings
                saveUserSettings(username, currentPassword,newPassword,confirmPassword, notificationsEnabled);
}
        });
        
        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }

            public void removeUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }

            public void changedUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }
        };

        newPasswordField.getDocument().addDocumentListener(documentListener);
        confirmPasswordField.getDocument().addDocumentListener(documentListener);
    
    }

    private void saveUserSettings(String username, String currPassword,String newPass,String confirmPass, boolean notificationsEnabled) {
        // Implement the logic to save user settings here
        // This is just a placeholder method
        Response responseObj=UASFactory.getResponseInstance();
        UserDTO userObj=new UserDTO();
        if(newPass.equals(confirmPass)){
            userObj.setPassword(newPass);
            userObj.setEmail(username);
        }else{
            JOptionPane.showMessageDialog(saveButton,"Password does not match.");
            return;
        }
        if(notificationsEnabled){
            if(currPassword.equals(UASController.objApplicationSession.getUser().getPassword())){
                objController.updatePassword(userObj, responseObj);
                if(responseObj.isSuccessfull()){
                    JOptionPane.showMessageDialog(emailField, responseObj.getInfoMessages());
                }else{
                    JOptionPane.showMessageDialog(emailField, responseObj.getErrorMessages());
               
                }
            }else{
                JOptionPane.showMessageDialog(emailField, "Your current password incorrect");
            }
        }
    }
    private void checkPasswordMatch() {
        char[] newPassword = newPasswordField.getPassword();
        char[] confirmPassword = confirmPasswordField.getPassword();

        if (newPassword.length == 0 || confirmPassword.length == 0) {
            passwordsMatch = false;
        } else {
            passwordsMatch = Arrays.equals(newPassword, confirmPassword);
        }

        updatePasswordMatchIndicator();
    }

    private void updatePasswordMatchIndicator() {
        SwingUtilities.invokeLater(() -> {
            if (passwordsMatch) {
                passwordMatchIndicatorLabel.setText("\u2714"+" Password Matched"); // Set a checkmark symbol for matching passwords
                passwordMatchIndicatorLabel.setForeground(Color.GREEN);
            } else {
                passwordMatchIndicatorLabel.setText("\u2718"+" Password not Matched"); // Set a cross symbol for non-matching passwords
                passwordMatchIndicatorLabel.setForeground(Color.RED);
            }
        });
    }
}
