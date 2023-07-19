package view.panels;

import controller.UASController;
import model.UASFactory;
import model.dto.Response;
import model.dto.TeacherDTO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class ViewTeachers extends JPanel {
    private final JTable table;
    private UASController objController;

    public ViewTeachers() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the table model with column names
        String[] columnNames = {"ID", "Name", "Phone Number", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Response response = UASFactory.getResponseInstance();
        ArrayList<TeacherDTO> teacherList = objController.getTeachers(response);
        for (TeacherDTO teacher : teacherList) {
            tableModel.addRow(new Object[]{
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getPhoneNumber(),
                    teacher.getEmail()
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
