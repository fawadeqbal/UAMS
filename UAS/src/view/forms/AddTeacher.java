package view.forms;

import controller.UASController;
import java.awt.Color;
import model.UASFactory;
import model.dto.Response;
import model.dto.TeacherDTO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class AddTeacher extends JPanel {

    private UASController controllerObj;

    private JTextField idField;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    public AddTeacher() {
        
        controllerObj = UASFactory.getUASControllerInstance();
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Add Teacher");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(titleLabel, constraints);
        
        //Description Label
        JLabel descriptionLabel = new JLabel("Please fill out the following details to add a new Teacher:");
        constraints.gridy++;
        constraints.gridwidth = 2;
        add(descriptionLabel, constraints);
        constraints.gridy++;
        constraints.gridwidth = 1;
        
        
        // ID label and text field
        JLabel idLabel = new JLabel("ID:");
        constraints.gridx=0;
        add(idLabel, constraints);

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, idField.getPreferredSize().height));
        constraints.gridx=1;
        add(idField, constraints);

        // Name label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel, constraints);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, nameField.getPreferredSize().height));
        constraints.gridx++;
        add(nameField, constraints);

        // Phone number label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        add(phoneNumberLabel, constraints);

        phoneNumberField = new JTextField();
        phoneNumberField.setPreferredSize(new Dimension(200, phoneNumberField.getPreferredSize().height));
        constraints.gridx++;
        add(phoneNumberField, constraints);

        // Email label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel, constraints);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, emailField.getPreferredSize().height));
        constraints.gridx++;
        add(emailField, constraints);

        // Add Teacher button
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        JButton addButton = new JButton("Submit");
        addButton.setBackground(new Color(52, 152, 219));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> addTeacher());
        add(addButton, constraints);
    }

    private void addTeacher() {
        //int id = Integer.parseInt(idField.getText());

        String idText  = idField.getText();
        Response responseObj = UASFactory.getResponseInstance();
// Validate the ID field
    int id = 0;
    try {
        id = Integer.parseInt(idText);
    } catch (NumberFormatException e) {
       
    }
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();

        TeacherDTO teacherObj = new TeacherDTO(id, name, phoneNumber, email);
        

        controllerObj.addTeacher(teacherObj, responseObj);
        if (responseObj.isSuccessfull()) {
            JOptionPane.showMessageDialog(nameField, responseObj.getInfoMessages());
            // Clear the text fields after successful addition
            idField.setText("");
            nameField.setText("");
            phoneNumberField.setText("");
            emailField.setText("");
        } else {
            JOptionPane.showMessageDialog(nameField, responseObj.getErrorMessages());
        }
    }
}
