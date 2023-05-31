/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.Dashboard;
import modal.autheticate.Authenticate;

public class LoginUIP extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JCheckBox rememberCheckBox;
    private JButton loginButton;

    public LoginUIP() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Set a light gray background color

        // Logo Panel
        JPanel logoPanel = new JPanel();
        JLabel logoLabel = new JLabel("Your Logo");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoPanel.setBackground(new Color(34, 47, 62)); // Set a blue background color
        logoPanel.add(logoLabel);
        logoPanel.setForeground(Color.red);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Role Selection
        JLabel roleLabel = new JLabel("Select Role");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        String[] roles = {"Admin", "Faculty", "Student"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Align components to the center
        gbc.weighty = 1.0;
        formPanel.add(roleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(roleComboBox, gbc);

        // Username Field
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(usernameLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(usernameField, gbc);

        // Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(passwordField, gbc);

        // Remember Me
        rememberCheckBox = new JCheckBox("Remember Me");
        rememberCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        formPanel.add(rememberCheckBox, gbc);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.PAGE_END; // Align the button to the bottom
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean authenticated = Authenticate.autheticate(username, password);
                if (authenticated) {
                    // Open the Dashboard
                    dispose(); // Close the login window
                    new Dashboard().setVisible(true);
                    // Continue with your logic for successful authentication
                } else {
                    // Authentication failed
                    JOptionPane.showMessageDialog(LoginUIP.this, "Invalid username or password", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        formPanel.add(loginButton, gbc);

        // Add components to the frame
        add(logoPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
