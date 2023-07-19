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

public class UserSettings extends JPanel {

    private JTextField emailField;
    private JPasswordField currentPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JCheckBox notificationsCheckbox;
    private JButton saveButton;
    JLabel emailLabel;
    JLabel currentPasswordLabel;
    JLabel newPasswordLabel;
    JLabel confirmPasswordLabel;

    public UserSettings() {
        
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
        notificationsCheckbox = new JCheckBox("Agree");
        saveButton = new JButton("Save");
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
        add(new JLabel(" "), gbc);

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
        add(notificationsCheckbox, gbc);

        gbc.gridy++;
        add(saveButton, gbc);
    }

    private void setupListeners() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String password = new String(currentPasswordField.getPassword());
                boolean notificationsEnabled = notificationsCheckbox.isSelected();

                // Save the user settings
                saveUserSettings(username, password, notificationsEnabled);

                // Show confirmation message
                JOptionPane.showMessageDialog(UserSettings.this, "User settings saved successfully");
            }
        });
    }

    private void saveUserSettings(String username, String password, boolean notificationsEnabled) {
        // Implement the logic to save user settings here
        // This is just a placeholder method
        System.out.println("Saving user settings:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Notifications Enabled: " + notificationsEnabled);
    }
}
