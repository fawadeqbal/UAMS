
package ui.components.attendance;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import controller.Student;

import java.util.Date;


public class AddAttendance extends JPanel {

    private JLabel courseLabel;
    private JComboBox<String> courseComboBox;
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel timeSlotLabel;
    private JTextField timeSlotField;
    private JLabel remarksLabel;
    private JTextField remarksField;
    private JTable studentTable;
    private JButton addAttendanceButton;

    public AddAttendance() {
        initializeComponents();
        setupLayout();
        addListeners();
    }

    private void initializeComponents() {
        courseLabel = new JLabel("Course:");
        courseComboBox = new JComboBox<>(new String[]{"Math", "Physics", "English"});
        dateLabel = new JLabel("Date:");
        dateField = new JTextField(10);
        timeSlotLabel = new JLabel("Time Slot:");
        timeSlotField = new JTextField(10);
        remarksLabel = new JLabel("Remarks:");
        remarksField = new JTextField(20);

        // Set current date and time slot
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentDate = new Date();
        String dateString = dateFormat.format(currentDate);
        String timeString = timeFormat.format(currentDate);
        dateField.setText(dateString);
        timeSlotField.setText(timeString);
        
        
        studentTable = new JTable(Student.getStudents()) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 2) {
                    return Boolean.class; // Set the class of "Attendance" column to Boolean
                }
                return super.getColumnClass(column);
            }
        };
        studentTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((boolean) value);
                checkBox.setHorizontalAlignment(SwingConstants.CENTER);
                return checkBox;
            }
        });

        addAttendanceButton = new JButton("Add Attendance");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        setOpaque(false); // Make the panel transparent

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add course label and combo box
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(courseLabel, gbc);

        gbc.gridx = 1;
        add(courseComboBox, gbc);

        // Add date label and text field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(dateLabel, gbc);

        gbc.gridx = 1;
        add(dateField, gbc);

        // Add time slot label and text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(timeSlotLabel, gbc);

        gbc.gridx = 1;
        add(timeSlotField, gbc);

        // Add remarks label and text field
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(remarksLabel, gbc);

        gbc.gridx = 1;
        add(remarksField, gbc);

        // Add student table
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, gbc);

        // Add add attendance button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(addAttendanceButton, gbc);
    }

    private void addListeners() {
        addAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                String date = dateField.getText();
                String timeSlot = timeSlotField.getText();
                String remarks = remarksField.getText();

                // Get attendance information from the table
                DefaultTableModel tableModel = (DefaultTableModel) studentTable.getModel();
                int rowCount = tableModel.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    String name = (String) tableModel.getValueAt(i, 0);
                    String regNo = (String) tableModel.getValueAt(i, 1);
                    boolean isPresent = (Boolean) tableModel.getValueAt(i, 2);

                    // Perform attendance saving logic here

                    System.out.println("Name: " + name + ", RegNo: " + regNo + ", Present: " + isPresent);
                }

                // Clear input fields
                dateField.setText("");
                timeSlotField.setText("");
                remarksField.setText("");

                // Clear table selection
                studentTable.clearSelection();
            }
        });
    }
}
