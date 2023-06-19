/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSettings extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox notificationsCheckbox;
    private JButton saveButton;
    JLabel usernameLabel ;
        JLabel passwordLabel ;

    public UserSettings() {
        initializeComponents();
        setupLayout();
        setupListeners();
    }

    private void initializeComponents() {
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        notificationsCheckbox = new JCheckBox("Enable Notifications");
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
        add(usernameLabel, gbc);

        gbc.gridy++;
        add(usernameField, gbc);

        gbc.gridy++;
        add(passwordLabel, gbc);

        gbc.gridy++;
        add(passwordField, gbc);

        gbc.gridy++;
        add(notificationsCheckbox, gbc);

        gbc.gridy++;
        add(saveButton, gbc);
    }

    private void setupListeners() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
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
