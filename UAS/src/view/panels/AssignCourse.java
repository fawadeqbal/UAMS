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
import model.dto.TeacherCourseViewDTO;

public class AssignCourse extends JPanel {

    private UASController objController;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> teacherComboBox;
    private JTable assignmentTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> teacherCourseComboBox;
    private JComboBox<String> classComboBox;

    public AssignCourse() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the course combo box
        courseComboBox = new JComboBox<>();
        loadCourseData();

        // Create the teacher combo box
        teacherComboBox = new JComboBox<>();
        loadTeacherData();

        // Create the course combo box
        teacherCourseComboBox = new JComboBox<>();

        // Create the teacher combo box
        classComboBox = new JComboBox<>();

        // Create the Assign button
        JButton assignButton = new JButton("Assign Course");
        JButton classButton = new JButton("Assign TeacherCourse Class");
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
        JPanel centerPanel=new JPanel(new BorderLayout());
        centerPanel.add(tableScrollPane,BorderLayout.WEST);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

// Left Panel
        JPanel leftPanel = new JPanel(new GridBagLayout());

// First row: Course label and Course combo box
        constraints.gridx = 0;
        constraints.gridy = 0;
        leftPanel.add(new JLabel("Course: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2; // Takes 2 columns
        leftPanel.add(courseComboBox, constraints);
        constraints.gridy++;
// Teacher label and Teacher combo box
        constraints.gridwidth = 1; // Reset to 1 column
        constraints.gridx = 0;
        leftPanel.add(new JLabel("Teacher: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2; // Takes 2 columns
        leftPanel.add(teacherComboBox, constraints);
        constraints.gridy++;
// Assign button
        constraints.gridx = 2;
        constraints.gridwidth = 2; // Reset to 1 column
        leftPanel.add(assignButton, constraints);

// Right Panel
        JPanel rightPanel = new JPanel(new GridBagLayout());

// Next row: Teacher Course label and Teacher Course combo box
        constraints.gridx = 0;
        constraints.gridy = 0; // Takes 2 columns
        rightPanel.add(new JLabel("Teacher Course: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2; // Takes 2 columns
        rightPanel.add(teacherCourseComboBox, constraints);

// Next row: Class label and Class combo box
        constraints.gridy++;
// Teacher label and Teacher combo box
        constraints.gridwidth = 1; // Reset to 1 column
        constraints.gridx = 0;
        // Takes 2 columns
        rightPanel.add(new JLabel("Class: "), constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2; // Takes 2 columns
        rightPanel.add(classComboBox, constraints);

// Next row: Assign button
        constraints.gridy++;
        constraints.gridx = 1;
        constraints.gridwidth = 2; // Takes 2 columns
        rightPanel.add(classButton, constraints);

// Main panel layout
        panel.add(leftPanel, BorderLayout.WEST);

        panel.add(rightPanel, BorderLayout.EAST);

// Add the main panel to the container
        add(panel, BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);
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
        List<TeacherCourseViewDTO> assignCourseList = objController.getAssignCourseTeacher(response);
        for (TeacherCourseViewDTO assignCourse : assignCourseList) {
            tableModel.addRow(new Object[]{assignCourse.getCourseName(), assignCourse.getCreditHours(), assignCourse.getTeacherName()});
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
