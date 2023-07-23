package view.components;

import controller.UASController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.UASFactory;
import model.dto.Response;
import model.dto.StudentDTO;

public class ViewStudents extends JPanel {

    private final JTable table;
    private final DefaultTableModel tableModel;
    private final UASController objController;
    private final JTextField searchField;

    public ViewStudents() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create a search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        JLabel searchLabel = new JLabel("Search Reg No#:");
        searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regNo = searchField.getText();
                if (!regNo.isEmpty()) {
                    searchStudentByRegNo(regNo);
                } else {
                    // If the search field is empty, display all students
                    refreshTableData();
                }
            }
        });
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(Box.createHorizontalStrut(5));
        searchPanel.add(searchButton);

        // Create the table model with column names
        String[] columnNames = {"Reg No#", "Name", "Father Name", "DOB", "CNIC", "Phone No", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        Response response = UASFactory.getResponseInstance();
        ArrayList<StudentDTO> studentList = objController.getStudents(response);
        for (StudentDTO s : studentList) {
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

        // Add components to the main panel
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void searchStudentByRegNo(String regNo) {
        // Clear the existing table data
        tableModel.setRowCount(0);

        // Retrieve the student with the specified regNo from the controller
        Response response = UASFactory.getResponseInstance();
        StudentDTO s=new StudentDTO();
        s.setRegNo(regNo);
        StudentDTO student = objController.getStudentbyId(s, response);

        if (student != null) {
            // Add the found student to the table model
            tableModel.addRow(new Object[]{
                student.getRegNo(),
                student.getName(),
                student.getFatherName(),
                student.getDob(),
                student.getCnic(),
                student.getPhoneNumber(),
                student.getUserEmail()
            });
        } else {
            // Show a message if no student is found with the specified regNo
            JOptionPane.showMessageDialog(this, "No student found with Reg No#: " + regNo, "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refreshTableData() {
        // Clear the existing table data
        tableModel.setRowCount(0);

        // Retrieve the updated student list from the controller
        Response response = UASFactory.getResponseInstance();
        ArrayList<StudentDTO> studentList = objController.getStudents(response);

        // Add all students to the table model
        for (StudentDTO s : studentList) {
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

        // Notify the table model that the data has changed
        tableModel.fireTableDataChanged();
    }
}
