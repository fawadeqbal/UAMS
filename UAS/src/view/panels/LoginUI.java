package view.panels;

import view.Dashboard;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import com.formdev.flatlaf.FlatLightLaf;
import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.UserDTO;
import view.AdminDashboard;

public class LoginUI extends JFrame {

    private JTextField userIDField;
    private JPasswordField passwordField;
    public UASController controllerObj;

    public LoginUI() {
        controllerObj = UASFactory.getUASControllerInstance();
        FlatLightLaf.install();
        setTitle("UAS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
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

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(41, 128, 185));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Email:");
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userIDField = new JTextField(20);
        userIDField.setText("fawadeqbal@yahoo.com");
        userIDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!userIDField.getText().isEmpty()) {
                        passwordField.requestFocusInWindow();
                    }
                }
            }
        });
        mainPanel.add(userIDField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setText("root");
        JButton loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(41, 128, 185));
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.putClientProperty("JButton.buttonType", "roundRect"); // Use roundRect button type
        loginButton.putClientProperty("JButton.selectedBackground", new Color(52, 152, 219));

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick(); // Trigger the login button event
            }
        });
        mainPanel.add(passwordField, gbc);
  
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

// Existing code...
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = userIDField.getText();
                String password = new String(passwordField.getPassword());
                
                // Perform authentication logic here
                UserDTO user = new UserDTO();
                user.setEmail(email);
                user.setPassword(password);
                Response responseObj = UASFactory.getResponseInstance();
                controllerObj.verifyUser(user, responseObj);
                if (responseObj.isSuccessfull()) {
                    if(UASController.objApplicationSession.getUser().getRole().equals("admin")){
                        AdminDashboard admin=new AdminDashboard();
                        admin.setVisible(true);
                        UASController.objApplicationSession.setCurrentScreen(admin);
                        dispose();
                    }else{
                        Dashboard dashboard=new Dashboard();
                        dashboard.setVisible(true);
                        UASController.objApplicationSession.setCurrentScreen(dashboard);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, responseObj.getErrorMessages());
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
}
