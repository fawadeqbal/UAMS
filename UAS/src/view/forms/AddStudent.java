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
import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.StudentDTO;
import org.jdatepicker.JDatePicker;

public class AddStudent extends JPanel {

    UASController controllerObj;
    private JTextField regNoField;
    private JTextField nameField;
    private JTextField fatherNameField;
    private JDatePicker dobField;
    private JTextField cnicField;
    private JTextField phoneNumberField;
    private JTextField userEmailField;

    public AddStudent() {
        controllerObj = UASFactory.getUASControllerInstance();
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
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(regNoLabel, gbc);

        regNoField = new JTextField(20);
        regNoField.setText("FA21-BSE-");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(regNoField, gbc);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Father's Name
        JLabel fatherNameLabel = new JLabel("Father's Name:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(fatherNameLabel, gbc);

        fatherNameField = new JTextField(20);
        gbc.gridx = 1;
        add(fatherNameField, gbc);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(dobLabel, gbc);

        dobField=new JDatePicker(new Date());
        gbc.gridx = 1;
        add(dobField, gbc);

        // CNIC
        JLabel cnicLabel = new JLabel("CNIC:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(cnicLabel, gbc);

        cnicField = new JTextField(20);
        gbc.gridx = 1;
        add(cnicField, gbc);

        // Phone Number
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(phoneNumberLabel, gbc);

        phoneNumberField = new JTextField(20);
        gbc.gridx = 1;
        add(phoneNumberField, gbc);

        // User Email
        JLabel userEmailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(userEmailLabel, gbc);

        userEmailField = new JTextField(20);
        userEmailField.setText("@gmail.com");
        gbc.gridx = 1;
        add(userEmailField, gbc);

        // Submit button (Note: This button won't perform any action in this example)
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(52, 152, 219));
        submitButton.setForeground(Color.WHITE);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                //
                Date dob = (Date)dobField.getModel().getValue();
                String cnic = cnicField.getText();
                String phoneNumber = phoneNumberField.getText();
                String userEmail = userEmailField.getText();

                StudentDTO userDetails = new StudentDTO(regNo, name, fatherName, dob, cnic, phoneNumber, userEmail);
                Response responseObj = UASFactory.getResponseInstance();
                controllerObj.addStudent(userDetails, responseObj);
                if (responseObj.isSuccessfull()) {
                    JOptionPane.showMessageDialog(regNoField, responseObj.getInfoMessages());
                    // Clear the text fields after submission
                    regNoField.setText("FA21-BSE-");
                    nameField.setText("");
                    fatherNameField.setText("");
                    //dobField.se(new Date());
                    cnicField.setText("");
                    phoneNumberField.setText("");
                    userEmailField.setText("@gmail.com");
                } else {
                    JOptionPane.showMessageDialog(regNoField, responseObj.getErrorMessages());
                }

            }
        });
    }
}
