/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

/**
 *
 * @author Faizan
 */
import controller.UASController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.UserDTO;

public class ViewUsers extends JPanel {
    private JTable table;
    UASController objController;

    public ViewUsers() {
        objController=UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the table model with column names
        String[] columnNames = {"Email", "Password", "Role"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Response response=UASFactory.getResponseInstance();
        ArrayList<UserDTO> userList=objController.getUsers(response);
        for(UserDTO u:userList){
            tableModel.addRow(new Object[]{
                u.getEmail(), 
                u.getPassword(),
                u.getRole()
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
