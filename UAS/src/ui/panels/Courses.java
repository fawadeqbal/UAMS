/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.panels;

/**
 *
 * @author fawad
 */
import controller.UASController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;

public class Courses extends JPanel {
    private JTable table;
    UASController objController;

    public Courses() {
        objController=UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the table model with column names
        String[] columnNames = {"Course Code", "Course Name", "Credit Hours"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Response response=UASFactory.getResponseInstance();
        ArrayList<CourseDTO> courseList=objController.getCourses(response);
        for(CourseDTO c:courseList){
            tableModel.addRow(new Object[]{
                c.getCourseCode(), 
                c.getCourseName(),
                c.getCreditHours()
            });
        }

        // Create the table with the model
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel
        add(scrollPane, BorderLayout.CENTER);
    }
}

