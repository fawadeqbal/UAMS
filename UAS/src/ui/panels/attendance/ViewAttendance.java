/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.panels.attendance;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.GridBagConstraints;
import org.jdatepicker.JDatePicker;

public class ViewAttendance extends JPanel {

    private JLabel courseLabel;
    private JComboBox<String> courseComboBox;
    private JLabel dateLabel;
    private JDatePicker datePicker;
    private JButton viewAttendanceButton;
    private JTable attendanceTable;

    public ViewAttendance() {
        initializeComponents();
        setupLayout();
        addListeners();
    }

    private void initializeComponents() {
        courseLabel = new JLabel("Course:");
        courseComboBox = new JComboBox<>(new String[]{"Data Structures", "OOSE", "Statistics"});
        dateLabel = new JLabel("Date:");
        datePicker = new JDatePicker(new Date());
        viewAttendanceButton = new JButton("View Attendance");

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

        // Add view attendance button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(viewAttendanceButton, gbc);

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
        viewAttendanceButton.addActionListener(e -> {
            String selectedCourse = (String) courseComboBox.getSelectedItem();
            Date selectedDate = (Date) datePicker.getModel().getValue();
            System.out.println("Selected Course: " + selectedCourse);
            System.out.println("Selected Date: " + selectedDate);

            // Query attendance records based on selected course and date
            // Update the attendanceTable with the retrieved data
            DefaultTableModel tableModel = new DefaultTableModel();
            // Populate the table model with the retrieved attendance records
            // tableModel.addColumn("Column Name"); // Add columns to the table model
            // tableModel.addRow(new Object[]{"Value 1", "Value 2", ...}); // Add rows to the table model
            attendanceTable.setModel(tableModel);
        });
    }
}
