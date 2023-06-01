/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fawad
 */
public class Student {
    public static DefaultTableModel getStudents(){
        ArrayList<common.Student> studentList = new ArrayList<>();
        studentList.add(new common.Student("John Doe", "123", true));

        // Add more students to the list if needed

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("RegNo");
        columnNames.add("Attendance");

        Vector<Vector<Object>> data = new Vector<>();
        // Create the data vector from the student list
        for (common.Student student : studentList) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(student.getName());
            rowData.add(student.getRegNo());
            rowData.add(student.isAttendance());
            data.add(rowData);
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        return tableModel;
    }
    
}
