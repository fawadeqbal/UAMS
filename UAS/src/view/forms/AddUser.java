/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.forms;

/**
 *
 * @author Faizan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.formdev.flatlaf.FlatLightLaf;
import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.UserDTO;

public class AddUser extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    UASController controllerObj;

    public AddUser() {
        controllerObj=new UASController();
        // Set FlatLaf for a modern look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Title: Add User
        JLabel titleLabel = new JLabel("Add User");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx=0;
        gbc.gridy++;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Role
        JLabel roleLabel = new JLabel("Role:");
        gbc.gridx=0;
        gbc.gridy++;
        add(roleLabel, gbc);

        // Create the ComboBox for role selection with options "Faculty," "Student," and "Admin"
        String[] roleOptions = { "faculty", "student", "admin" };
        roleComboBox = new JComboBox<>(roleOptions);
        gbc.gridx = 1;
        add(roleComboBox, gbc);

        // Submit button (Note: This button won't perform any action in this example)
        JButton submitButton = new JButton("Submit");
        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                // TODO: Handle the user submission here
                // You can use the values entered in the text fields and selected role
                // to add the user
                // For example:
                UserDTO userObj = new UserDTO(email, password, role);
                Response responseObj=UASFactory.getResponseInstance();
                controllerObj.addUser(userObj, responseObj);
                if (responseObj.isSuccessfull()) {
                     JOptionPane.showMessageDialog(emailField, "User Added Successfully");
                 } else {
                     JOptionPane.showMessageDialog(emailField, "Failed to add user");
                 }

                // Clear the text fields after submission
                emailField.setText("");
                passwordField.setText("");
            }
        });
    }

    // Getter methods to access the text fields if needed
    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User Form");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new AddUser());
            frame.setVisible(true);
        });
    }
}




