/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.ApplicationSession;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import common.Student;
import dal.DALManager;
import java.util.Vector;
import model.dto.Response;
import model.dto.UserDTO;
import model.validators.CommonValidator;

/**
 *
 * @author fawad
 */
public class UASController {

    public static ApplicationSession objApplicationSession;
    public DALManager dalManagerObj;

    public UASController() {
        dalManagerObj = UASFactory.getDALManagerInstance();
    }

    public static void initializeSession() {
        objApplicationSession = new ApplicationSession();
        objApplicationSession.setUserName("");
        objApplicationSession.startSession();
    }

    public static boolean isSessionExpired() {
        return objApplicationSession.isSessionExpired();
    }
    public static void expireSession(){
        objApplicationSession=null;
        System.out.println("Session Expired.");
    }

    public static boolean isUserLoggedIn() {
        return objApplicationSession != null;
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        CommonValidator.validateUser(user, responseObj);
        if (responseObj.isSuccessfull()) {
            dalManagerObj.verifyUser(user, responseObj);

            if (responseObj.isSuccessfull()) {
                initializeSession();
                objApplicationSession.setUserName(user.getUsername()); 
                objApplicationSession.setRole(user.getRole());
            }
        }

    }

    public DefaultTableModel getStudentsByCourse(String selectedCourse) {
        ArrayList<Student> studentList = new ArrayList<>();

        // Add students to the list for the selected course
        for (int j = 1; j <= 30; j++) {
            Student student;
            String name = "Student " + j + " - " + selectedCourse;
            String regNo = "FA21/BSE/" + String.format("%03d", j);
            boolean attendance = false;
            student = new Student(name, regNo, attendance);

            studentList.add(student);
        }

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("RegNo");
        columnNames.add("Attendance");

        Vector<Vector<Object>> data = new Vector<>();
        // Create the data vector from the student list
        for (Student student : studentList) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(student.getName());
            rowData.add(student.getRegNo());
            rowData.add(student.isAttendance());
            data.add(rowData);
        }

        // Create a custom TableModel that makes all cells non-editable except for the "Attendance" column
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable except for the "Attendance" column (index 2)
                return column == 2;
            }
        };

        return tableModel;
    }

}
