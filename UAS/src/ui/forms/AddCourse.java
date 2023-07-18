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

public class AddCourse extends JPanel {

    private JTextField courseCodeField;
    private JTextField courseNameField;
    private JTextField creditHoursField;

    public AddCourse() {
        setLayout(new GridBagLayout());

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

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                // Apply a modern look and feel (e.g., Nimbus)
//                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//            // Create a frame to display the panel
//            JFrame frame = new JFrame("Course Form");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(400, 200);
//            frame.add(new AddCourse());
//            frame.setVisible(true);
//        });
//    }
}
