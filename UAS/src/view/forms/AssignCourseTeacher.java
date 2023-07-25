package view.forms;

import controller.UASController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.TeacherDTO;

public class AssignCourseTeacher extends JPanel {
    private UASController objController;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> teacherComboBox;

    public AssignCourseTeacher() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Create the course combo box
        courseComboBox = new JComboBox<>();
        loadCourseData();

        // Create the teacher combo box
        teacherComboBox = new JComboBox<>();
        loadTeacherData();

        // Create the Assign button
        JButton assignButton = new JButton("Assign Course");
        assignButton.setBackground(new Color(52, 152, 219));
        assignButton.setForeground(Color.WHITE);
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignCourseToTeacher();
            }
        });

        // Add components to the left panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Course: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(courseComboBox, constraints);
        constraints.gridy++;

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        add(new JLabel("Teacher: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        add(teacherComboBox, constraints);
        constraints.gridy++;

        constraints.gridx = 2;
        constraints.gridwidth = 2;
        add(assignButton, constraints);

        // Set background color and preferred size to occupy the whole panel
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
    }

    private void loadCourseData() {
        Response response = UASFactory.getResponseInstance();
        List<CourseDTO> courseList = objController.getCourses(response);
        for (CourseDTO course : courseList) {
            courseComboBox.addItem(course.getCourseCode() + " - " + course.getCourseName());
        }
    }

    private void loadTeacherData() {
        Response response = UASFactory.getResponseInstance();
        List<TeacherDTO> teacherList = objController.getTeachers(response);
        for (TeacherDTO teacher : teacherList) {
            teacherComboBox.addItem(teacher.getId() + " - " + teacher.getName());
        }
    }

    private void assignCourseToTeacher() {
    String selectedCourse = (String) courseComboBox.getSelectedItem();
    String selectedTeacher = (String) teacherComboBox.getSelectedItem();

    // Extract the course code and teacher ID from the selected values
    String courseCode = selectedCourse.split(" - ")[0];
    int teacherId = Integer.parseInt(selectedTeacher.split(" - ")[0]);

    CourseDTO course = new CourseDTO();
    course.setCourseCode(courseCode);

    TeacherDTO teacher = new TeacherDTO();
    teacher.setId(teacherId);

    Response response = UASFactory.getResponseInstance();
    objController.assignCourseTeacher(teacher, course, response);

    if (response.isSuccessfull()) {
        JOptionPane.showMessageDialog(this, response.getInfoMessages());
        // Clear the table and reload the data
         // Reload data from the controller
    } else {
        JOptionPane.showMessageDialog(this, response.getErrorMessages());
    }
}

}
