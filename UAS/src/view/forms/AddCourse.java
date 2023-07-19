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
import model.dto.CourseDTO;
import model.dto.Response;

public class AddCourse extends JPanel {
    UASController controllerObj;
    private JTextField courseCodeField;
    private JTextField courseNameField;
    private JComboBox<Integer> creditHoursComboBox; // Use JComboBox for credit hours selection

    public AddCourse() {
        controllerObj=UASFactory.getUASControllerInstance();
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

        // Title: Add Course
        JLabel titleLabel = new JLabel("Add Course");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);
        
        //Description
        JLabel descriptionLabel = new JLabel("Please fill out the following details to add a new course:");
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(descriptionLabel, gbc);

        // Course Code
        JLabel courseCodeLabel = new JLabel("Course Code:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(courseCodeLabel, gbc);

        courseCodeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(courseCodeField, gbc);

        // Course Name
        JLabel courseNameLabel = new JLabel("Course Name:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(courseNameLabel, gbc);

        courseNameField = new JTextField(20);
        gbc.gridx = 1;
        add(courseNameField, gbc);

        // Credit Hours
        JLabel creditHoursLabel = new JLabel("Credit Hours:");
        gbc.gridy++;
        gbc.gridx=0;
        add(creditHoursLabel, gbc);

        // Create the ComboBox for credit hours selection with options "2" and "3"
        Integer[] creditHoursOptions = { 2, 3, 4 };
        creditHoursComboBox = new JComboBox<>(creditHoursOptions);
        gbc.gridx = 1;
        add(creditHoursComboBox, gbc);

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
                String courseCode = courseCodeField.getText();
                String courseName = courseNameField.getText();
                int creditHours = (int) creditHoursComboBox.getSelectedItem();

                // TODO: Handle the course submission here
                // You can use the values entered in the text fields and selected credit hours
                // to add the course
                // For example:
                CourseDTO courseObj = new CourseDTO(courseCode, courseName, creditHours);
                Response responseObj =UASFactory.getResponseInstance();
                controllerObj.addCourse(courseObj, responseObj);
                 if (responseObj.isSuccessfull()) {
                    JOptionPane.showMessageDialog(courseCodeField, responseObj.getInfoMessages());
                     // Clear the text fields after submission
                courseCodeField.setText("");
                courseNameField.setText("");
                } else {
                     JOptionPane.showMessageDialog(courseCodeField, responseObj.getErrorMessages());
                }

               
            }
        });
    }

    // Getter methods to access the text fields if needed
    public JTextField getCourseCodeField() {
        return courseCodeField;
    }

    public JTextField getCourseNameField() {
        return courseNameField;
    }

}


