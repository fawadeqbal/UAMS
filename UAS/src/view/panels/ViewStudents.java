/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

import controller.UASController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.UASFactory;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.UserDTO;

/**
 *
 * @author Faizan
 */
public class ViewStudents extends JPanel {
    private final JTable table;
    UASController objController;

    public ViewStudents() {
        objController=UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the table model with column names
        String[] columnNames = {"Reg No#", "Name", "Father Name", "DOB", "CNIC", "Phone No", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Response response=UASFactory.getResponseInstance();
        ArrayList<StudentDTO> studentList=objController.getStudents(response);
        for(StudentDTO s:studentList){
            System.out.println(s.toString());
            tableModel.addRow(new Object[]{
               s.getRegNo(), 
                s.getName(),
                s.getFatherName(),
                s.getDob(),
                s.getCnic(),
                s.getPhoneNumber(),
                s.getUserEmail()
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
