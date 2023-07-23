/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.forms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.dto.TeacherCourseViewDTO;

public class AssignTeacherClass extends JPanel {
    private JComboBox<String> teacherCourseComboBox;
    private JComboBox<String> classComboBox;
    
    public AssignTeacherClass() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Create the teacher course combo box
        teacherCourseComboBox = new JComboBox<>();

        // Create the class combo box
        classComboBox = new JComboBox<>();

        // Create the Assign button
        JButton classButton = new JButton("Assign Teacher Course Class");
        classButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the functionality as needed
            }
        });

        // Add components to the right panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Teacher Course: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        add(teacherCourseComboBox, constraints);
        constraints.gridy++;

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        add(new JLabel("Class: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        add(classComboBox, constraints);
        constraints.gridy++;

        constraints.gridx = 2;
        constraints.gridwidth = 2;
        add(classButton, constraints);
    }
}
