/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms;

/**
 *
 * @author Faizan
 */
import controller.UASController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;

public class AddCourse extends JPanel {
    UASController controllerObj;
    private JTextField courseCodeField;
    private JTextField courseNameField;
    private JTextField creditHoursField;

    public AddCourse() {
        setLayout(new GridBagLayout());
        controllerObj = UASFactory.getUASControllerInstance();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Course Code
        JLabel courseCodeLabel = new JLabel("Course Code:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(courseCodeLabel, gbc);

        courseCodeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(courseCodeField, gbc);

        // Course Name
        JLabel courseNameLabel = new JLabel("Course Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(courseNameLabel, gbc);

        courseNameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(courseNameField, gbc);

        // Credit Hours
        JLabel creditHoursLabel = new JLabel("Credit Hours:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(creditHoursLabel, gbc);

        creditHoursField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(creditHoursField, gbc);

        // Submit button (Note: This button won't perform any action in this example)
        JButton submitButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(submitButton, gbc);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String courseCode=courseCodeField.getText();
                String courseName=courseNameField.getText();
                int creditHours=Integer.parseInt(creditHoursField.getText());
                CourseDTO courseObj=new CourseDTO(courseCode,courseName,creditHours);
                Response responseObj=new Response();
                controllerObj.addCourse(courseObj, responseObj);
                if(responseObj.isSuccessfull()){
                    JOptionPane.showMessageDialog(courseCodeField, "Course Added Successfully");
                    
                }else{
                     JOptionPane.showMessageDialog(courseCodeField, "Failed to add course");
                }
                
                
             // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
