package view.panels;

import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.TeacherDTO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JOptionPane;

public class AddTeacher extends JPanel {
    private UASController objController;
    private JTextField idField;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;

    public AddTeacher() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);

        // ID label and text field
        JLabel idLabel = new JLabel("ID:");
        add(idLabel, constraints);

        idField = new JTextField(10);
        constraints.gridx++;
        add(idField, constraints);

        // Name label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel, constraints);

        nameField = new JTextField(20);
        constraints.gridx++;
        add(nameField, constraints);

        // Phone number label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        add(phoneNumberLabel, constraints);

        phoneNumberField = new JTextField(15);
        constraints.gridx++;
        add(phoneNumberField, constraints);

        // Email label and text field
        constraints.gridx = 0;
        constraints.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel, constraints);

        emailField = new JTextField(30);
        constraints.gridx++;
        add(emailField, constraints);

        // Add Teacher button
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        JButton addButton = new JButton("Add Teacher");
        addButton.addActionListener(e -> addTeacher());
        add(addButton, constraints);
    }

    private void addTeacher() {
        int id=0;
        //int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();

        TeacherDTO teacherObj = new TeacherDTO(id, name, phoneNumber, email);
        Response responseObj = UASFactory.getResponseInstance();
        objController.addTeacher(teacherObj, responseObj);
        if(responseObj.isSuccessfull()){
            JOptionPane.showMessageDialog(nameField, responseObj.getInfoMessages());
        }else{
            JOptionPane.showMessageDialog(nameField, responseObj.getErrorMessages());
        }
        // TODO: Handle the response, show success or error message
        // You can update the UI accordingly based on the response received
    }
}
