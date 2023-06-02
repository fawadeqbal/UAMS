/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.student;

/**
 *
 * @author fawad
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentTableApp extends JFrame {
    private JTable table;

    public StudentTableApp(ArrayList<StudentModal.Student> studentsList) {
        setTitle("Student Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        String[] columnNames = {"Name", "Gender", "Physics", "Maths", "English"};
        Object[][] data = new Object[studentsList.size()][5];
        for (int i = 0; i < studentsList.size(); i++) {
            StudentModal.Student student = studentsList.get(i);
            data[i][0] = student.getName();
            data[i][1] = student.getGender();
            data[i][2] = student.getPhysics();
            data[i][3] = student.getMaths();
            data[i][4] = student.getEnglish();
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        StudentModal studentModal = new StudentModal();
        ArrayList<StudentModal.Student> studentsList = studentModal.getStudentMarks();

        SwingUtilities.invokeLater(() -> {
            StudentTableApp app = new StudentTableApp(studentsList);
            app.setVisible(true);
        });
    }
}
