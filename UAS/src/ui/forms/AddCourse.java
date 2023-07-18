/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms;

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
import model.dto.CourseDTO;
import model.dto.Response;

public class AddCourse extends JPanel {

    UASController controllerObj;
    private JTextField courseCodeField;
    private JTextField courseNameField;
    private JTextField creditHoursField;

    public AddCourse() {
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

        // Course Code
        JLabel courseCodeLabel = new JLabel("Course Code:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Set anchor to EAST for labels
        add(courseCodeLabel, gbc);

        courseCodeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST; // Reset anchor to WEST for text fields
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

        creditHoursField = new JTextField(20);
        gbc.gridx = 1;
        add(creditHoursField, gbc);

        // Submit button (Note: This button won't perform any action in this example)
        JButton submitButton = new JButton("Submit");
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String courseCode = courseCodeField.getText();
                String courseName = courseNameField.getText();
                int creditHours = Integer.parseInt(creditHoursField.getText());
                CourseDTO courseObj = new CourseDTO(courseCode, courseName, creditHours);
                Response responseObj = new Response();
                controllerObj.addCourse(courseObj, responseObj);
                if(responseObj.isSuccessfull()){
                    JOptionPane.showMessageDialog(courseCodeField, "Course Added Successfully");
                    
                }else{
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

    public JTextField getCreditHoursField() {
        return creditHoursField;
    }
    
}

