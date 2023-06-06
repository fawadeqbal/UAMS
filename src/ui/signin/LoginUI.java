package ui.signin;

import ui.Dashboard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.AuthController;

public class LoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginUI() {
        setTitle("UAS - Login");
        setBackground(new Color(48, 51, 107));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(83, 92, 104));
       
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setForeground(new Color(204, 204, 204));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(new Color(204, 204, 204));
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(204, 204, 204));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!usernameField.getText().isEmpty()) {
                        passwordField.requestFocusInWindow();
                    }
                }
            }
        });
        mainPanel.add(usernameField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        loginButton.putClientProperty("JButton.buttonType", "roundRect");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setForeground(new Color(83, 92, 104));
        loginButton.setBackground(new Color(149, 175, 192));
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick(); // Trigger the login button event
            }
        });
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        
       
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Perform authentication logic here
                boolean authenticate=AuthController.authenticate(username, password);
                if (authenticate) {
                    dispose(); // Close the login window
                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password.");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
}
