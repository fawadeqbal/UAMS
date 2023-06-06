package ui.signin;

import ui.signin.LoginUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SignupPanel extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField userIDField;
    private JTextField dobField;
    private JTextField phoneField;

    public SignupPanel() {
        setTitle("UAS - Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 650));
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Username:");
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        JLabel firstNameLabel = new JLabel("First Name:");
        mainPanel.add(firstNameLabel, gbc);

        gbc.gridy++;
        JLabel lastNameLabel = new JLabel("Last Name:");
        mainPanel.add(lastNameLabel, gbc);

        gbc.gridy++;
        JLabel userIDLabel = new JLabel("User ID:");
        mainPanel.add(userIDLabel, gbc);

        gbc.gridy++;
        JLabel dobLabel = new JLabel("Date of Birth:");
        mainPanel.add(dobLabel, gbc);

        gbc.gridy++;
        JLabel phoneLabel = new JLabel("Phone Number:");
        mainPanel.add(phoneLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        mainPanel.add(usernameField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        mainPanel.add(passwordField, gbc);

        gbc.gridy++;
        firstNameField = new JTextField(20);
        mainPanel.add(firstNameField, gbc);

        gbc.gridy++;
        lastNameField = new JTextField(20);
        mainPanel.add(lastNameField, gbc);

        gbc.gridy++;
        userIDField = new JTextField(20);
        mainPanel.add(userIDField, gbc);

        gbc.gridy++;
        dobField = new JTextField(20);
        mainPanel.add(dobField, gbc);

        gbc.gridy++;
        phoneField = new JTextField(20);
        mainPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton signupButton = new JButton("Submit");
        signupButton.setBackground(Color.GRAY);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(signupButton, gbc);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String userID = userIDField.getText();
                String dob = dobField.getText();
                String phone = phoneField.getText();

                // Validate the input
                if (username.isEmpty() || password.isEmpty() || firstName.isEmpty()
                        || lastName.isEmpty() || userID.isEmpty() || dob.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(SignupPanel.this,
                            "Please fill in all the fields.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
        });

        gbc.gridy++;
        JLabel signinLabel = new JLabel("Already have an account?");
        signinLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(signinLabel, gbc);

        gbc.gridy++;
        JButton signinButton = new JButton("Sign In");
        signinButton.setBackground(Color.LIGHT_GRAY);
        signinButton.setForeground(Color.BLACK);
        signinButton.setFocusPainted(false);
        signinButton.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(signinButton, gbc);

        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI signinForm = new LoginUI();
                signinForm.setVisible(true);
                SignupPanel.this.setVisible(false);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        userIDField.setText("");
        dobField.setText("");
        phoneField.setText("");
    }

}
