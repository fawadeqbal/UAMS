package view.components;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ModifyAttendance extends JPanel {

    private JLabel courseLabel;
    private JComboBox<String> courseComboBox;
    private JLabel dateLabel;
    private JDatePicker datePicker;
    private JLabel remarksLabel;
    private JTextField remarksField;
    private JTable attendanceTable;
    private JButton updateAttendanceButton;

    public ModifyAttendance() {

        initializeComponents();
        setupLayout();
        addListeners();

    }

    private void initializeComponents() {
        courseLabel = new JLabel("Course:");
        courseComboBox = new JComboBox<>(new String[]{"Data Structures", "OOSE", "Statistics"});
        dateLabel = new JLabel("Date:");
        datePicker = new JDatePicker(new Date());
        remarksLabel = new JLabel("Remarks:");
        remarksField = new JTextField(20);
        updateAttendanceButton = new JButton("Update Attendance");

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

        // Add remarks label and text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(remarksLabel, gbc);

        gbc.gridx = 1;
        add(remarksField, gbc);

        // Add update attendance button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(updateAttendanceButton, gbc);

        // Add attendance table
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(attendanceTable);
        add(scrollPane, gbc);
    }

    private void addListeners() {
        updateAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                // You can get the selected date in a similar way to the "ViewAttendance" panel
                String remarks = remarksField.getText();

                // Get the updated attendance information from the table
                DefaultTableModel tableModel = (DefaultTableModel) attendanceTable.getModel();
                int rowCount = tableModel.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    String name = (String) tableModel.getValueAt(i, 0);
                    String regNo = (String) tableModel.getValueAt(i, 1);
                    boolean isPresent = (Boolean) tableModel.getValueAt(i, 2);

                    // Perform attendance update logic here
                    System.out.println("Name: " + name + ", RegNo: " + regNo + ", Present: " + isPresent);
                }

                // Clear input fields
                remarksField.setText("");

                // Clear table selection
                attendanceTable.clearSelection();
            }
        });
    }
}
