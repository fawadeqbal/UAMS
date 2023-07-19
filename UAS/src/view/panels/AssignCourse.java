package view.panels;

import controller.UASController;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.TeacherDTO;
import model.dto.TeacherCourseDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AssignCourse extends JPanel {
    private UASController objController;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> teacherComboBox;
    private JTable assignmentTable;
    private DefaultTableModel tableModel;

    public AssignCourse() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the course combo box
        courseComboBox = new JComboBox<>();
        loadCourseData();

        // Create the teacher combo box
        teacherComboBox = new JComboBox<>();
        loadTeacherData();

        // Create the Assign button
        JButton assignButton = new JButton("Assign Course");
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignCourseToTeacher();
            }
        });

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Credit Hours");
        tableModel.addColumn("Teacher Name");
        
        loadTableData();
        // Create the assignment table
        assignmentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(assignmentTable);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Course: "));
        panel.add(courseComboBox);
        panel.add(new JLabel("Teacher: "));
        panel.add(teacherComboBox);
        panel.add(assignButton);

        // Add the components to the panel
        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
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

    private void loadTableData() {
        Response response = UASFactory.getResponseInstance();
        List<TeacherCourseDTO> assignCourseList = objController.getAssignCourseTeacher(response);
        for (TeacherCourseDTO assignCourse : assignCourseList) {
            tableModel.addRow(new Object[]{objController.getCourseById(assignCourse.getCourseCode(), response).getCourseName(),objController.getCourseById(assignCourse.getCourseCode(), response).getCreditHours(), objController.getTeacherById(assignCourse.getFacultyId(), response).getName()});
        }
    }

    private void assignCourseToTeacher() {
    String selectedCourse = (String) courseComboBox.getSelectedItem();
    String selectedTeacher = (String) teacherComboBox.getSelectedItem();

    // Extract the course code and teacher ID from the selected values
    String courseCode = selectedCourse.split(" - ")[0];
    String teacherId = selectedTeacher.split(" - ")[0];

    CourseDTO course = new CourseDTO();
    course.setCourseCode(courseCode);
    TeacherDTO teacher = new TeacherDTO();
    teacher.setId(Integer.parseInt(teacherId));
    Response response = UASFactory.getResponseInstance();
    objController.assignCourseTeacher(teacher, course, response);

    if (response.isSuccessfull()) {
        JOptionPane.showMessageDialog(courseComboBox, response.getInfoMessages());
        // Clear the table and reload the data
        tableModel.setRowCount(0); // Clear the table
        loadTableData(); // Reload data from the controller
    } else {
        JOptionPane.showMessageDialog(courseComboBox, response.getErrorMessages());
    }
}

}
