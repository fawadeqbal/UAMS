/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.forms;

import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.TeacherCourseViewDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewAssignedCoursesToTeacher extends JPanel {
    private UASController objController;
    private JTable assignmentTable;
    private DefaultTableModel tableModel;

    public ViewAssignedCoursesToTeacher() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Credit Hours");
        tableModel.addColumn("Teacher Name");

        loadTableData();

        // Create the assignment table
        assignmentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(assignmentTable);

        // Add the table to the panel
        add(tableScrollPane, BorderLayout.CENTER);
    }

    private void loadTableData() {
        Response response = UASFactory.getResponseInstance();
        List<TeacherCourseViewDTO> assignCourseList = objController.getAssignCourseTeacher(response);
        for (TeacherCourseViewDTO assignCourse : assignCourseList) {
            tableModel.addRow(new Object[]{assignCourse.getCourseName(), assignCourse.getCreditHours(), assignCourse.getTeacherName()});
        }
    }
}
