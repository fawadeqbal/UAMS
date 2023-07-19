package view.panels;

import controller.UASController;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.TeacherDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AssignCourse extends JPanel {
    private UASController objController;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> teacherComboBox;

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

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Course: "));
        panel.add(courseComboBox);
        panel.add(new JLabel("Teacher: "));
        panel.add(teacherComboBox);
        panel.add(assignButton);

        add(panel, BorderLayout.CENTER);
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
        String teacherId = selectedTeacher.split(" - ")[0];
        CourseDTO course=new CourseDTO();
        course.setCourseCode(courseCode);
        TeacherDTO teacher=new TeacherDTO();
        teacher.setId(Integer.parseInt(teacherId));
        Response response=UASFactory.getResponseInstance();
        objController.assignCourseTeacher(teacher,course,response);
        if(response.isSuccessfull()){
            JOptionPane.showMessageDialog(courseComboBox, response.getInfoMessages());
        }else{
            JOptionPane.showMessageDialog(courseComboBox, response.getErrorMessages());
        }
    }
}
