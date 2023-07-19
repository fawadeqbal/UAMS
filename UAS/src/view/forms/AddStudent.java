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
import java.util.Date;
import com.formdev.flatlaf.FlatLightLaf;

public class AddStudent extends JPanel {
    private JTextField regNoField;
    private JTextField nameField;
    private JTextField fatherNameField;
    private JFormattedTextField dobField;
    private JTextField cnicField;
    private JTextField phoneNumberField;
    private JTextField userEmailField;

    public AddStudent() {
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

        // Title: Add User Details
        JLabel titleLabel = new JLabel("Add Student Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Registration Number
        JLabel regNoLabel = new JLabel("Registration No:");
        gbc.gridx=0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(regNoLabel, gbc);

        regNoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(regNoField, gbc);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx=0;
        gbc.gridy++;
        add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Father's Name
        JLabel fatherNameLabel = new JLabel("Father's Name:");
        gbc.gridx=0;
        gbc.gridy++;
        add(fatherNameLabel, gbc);

        fatherNameField = new JTextField(20);
        gbc.gridx = 1;
        add(fatherNameField, gbc);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:");
        gbc.gridx=0;
        gbc.gridy++;
        add(dobLabel, gbc);

        dobField = new JFormattedTextField(new Date());
        gbc.gridx = 1;
        add(dobField, gbc);

        // CNIC
        JLabel cnicLabel = new JLabel("CNIC:");
        gbc.gridx=0;
        gbc.gridy++;
        add(cnicLabel, gbc);

        cnicField = new JTextField(20);
        gbc.gridx = 1;
        add(cnicField, gbc);

        // Phone Number
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        gbc.gridx=0;
        gbc.gridy++;
        add(phoneNumberLabel, gbc);

        phoneNumberField = new JTextField(20);
        gbc.gridx = 1;
        add(phoneNumberField, gbc);

        // User Email
        JLabel userEmailLabel = new JLabel("Email:");
        gbc.gridx=0;
        gbc.gridy++;
        add(userEmailLabel, gbc);

        userEmailField = new JTextField(20);
        gbc.gridx = 1;
        add(userEmailField, gbc);

        // Submit button (Note: This button won't perform any action in this example)
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(52, 152, 219));
        submitButton.setForeground(Color.WHITE);
        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String regNo = regNoField.getText();
                String name = nameField.getText();
                String fatherName = fatherNameField.getText();
                Date dob = (Date) dobField.getValue();
                String cnic = cnicField.getText();
                String phoneNumber = phoneNumberField.getText();
                String userEmail = userEmailField.getText();

                // TODO: Handle the user details submission here
                // You can use the values entered in the text fields and date field
                // to add the user details
                // For example:
                // UserDetailsDTO userDetails = new UserDetailsDTO(regNo, name, fatherName, dob, cnic, phoneNumber, userEmail);
                // controllerObj.addUserDetails(userDetails, responseObj);
                // if (responseObj.isSuccessfull()) {
                //     JOptionPane.showMessageDialog(regNoField, "User Details Added Successfully");
                // } else {
                //     JOptionPane.showMessageDialog(regNoField, "Failed to add user details");
                // }

                // Clear the text fields after submission
                regNoField.setText("");
                nameField.setText("");
                fatherNameField.setText("");
                dobField.setValue(new Date());
                cnicField.setText("");
                phoneNumberField.setText("");
                userEmailField.setText("");
            }
        });
    }

    // Getter methods to access the text fields if needed
    public JTextField getRegNoField() {
        return regNoField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getFatherNameField() {
        return fatherNameField;
    }

    public JFormattedTextField getDobField() {
        return dobField;
    }

    public JTextField getCnicField() {
        return cnicField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getUserEmailField() {
        return userEmailField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User Details Form");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.add(new AddStudent());
            frame.setVisible(true);
        });
    }
}
