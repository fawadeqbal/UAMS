/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import model.UASController;
import org.jdatepicker.JDatePicker;

public class DeleteAttendance extends JPanel {

    private JLabel courseLabel;
    private JComboBox<String> courseComboBox;
    private JLabel dateLabel;
    private JDatePicker datePicker;
    private JButton deleteAttendanceButton;
    private JTable attendanceTable;

    public DeleteAttendance() {
        
            initializeComponents();
            setupLayout();
            addListeners();
        
    }

    private void initializeComponents() {
        courseLabel = new JLabel("Course:");
        courseComboBox = new JComboBox<>(new String[]{"Data Structures", "OOSE", "Statistics"});
        dateLabel = new JLabel("Date:");
        datePicker = new JDatePicker(new Date());
        deleteAttendanceButton = new JButton("Delete Attendance");

        attendanceTable = new JTable();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add course label and combo box
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(courseLabel, gbc);

        gbc.gridx = 1;
        add(courseComboBox, gbc);

        // Add date label and date picker
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(dateLabel, gbc);

        gbc.gridx = 1;
        add(datePicker, gbc);

        // Add delete attendance button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(deleteAttendanceButton, gbc);

        // Add attendance table
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(attendanceTable);
        add(scrollPane, gbc);
    }

    private void addListeners() {
        deleteAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                // You can get the selected date in a similar way to the "ViewAttendance" panel

                // Get the selected attendance records to be deleted
                int[] selectedRows = attendanceTable.getSelectedRows();
                DefaultTableModel tableModel = (DefaultTableModel) attendanceTable.getModel();

                // Delete the selected attendance records from the table model
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int selectedRow = selectedRows[i];
                    tableModel.removeRow(selectedRow);
                }
            }
        });
    }
}
