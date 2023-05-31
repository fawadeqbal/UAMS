/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author fawad
 */
public class Attendance {
    
    public static JPanel attendance() {
        JPanel attendancePanel = new JPanel();
        attendancePanel.setBackground(Color.WHITE);
        attendancePanel.setLayout(new BorderLayout());

        // Create Attendance Header
        JLabel headerLabel = new JLabel("Attendance");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        attendancePanel.add(headerLabel, BorderLayout.NORTH);

        // Create Attendance Table
        String[] columnNames = {"Student Name", "Registration No.", "Class", "Present"};
        Object[][] data = loadStudentData(); // Load student data from file

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class; // Column "Present" is of Boolean type
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Allow editing only for column "Present"
            }
        };

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.setRowHeight(30);

                JScrollPane scrollPane = new JScrollPane(table);
        attendancePanel.add(scrollPane, BorderLayout.CENTER);

        // Create Toggle Button to Mark All Present
        JButton toggleButton = new JButton("Mark All Present");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean markPresent = !areAllStudentsPresent(model);
                markAllStudentsPresent(model, markPresent);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.add(toggleButton);
        attendancePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Apply Styling
        attendancePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        headerLabel.setForeground(Color.WHITE);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.DARK_GRAY);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        toggleButton.setPreferredSize(new Dimension(150, 30));
        toggleButton.setBackground(Color.WHITE);
        toggleButton.setFont(new Font("Arial", Font.BOLD, 14));
        toggleButton.setFocusPainted(false);

        // Save attendance data when table cell value changes
        model.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 3) {
                    boolean present = (boolean) model.getValueAt(row, column);
                    saveAttendanceData(model);
                }
            }
        }
    });

        return attendancePanel;
    }
    private static Object[][] loadStudentData() {
        try {
            File file = new File("student_data.txt");
            if (!file.exists()) {
                // If the file doesn't exist, return default student data
                return new Object[][]{
                        {"John Doe", "123456", "Class 10", false},
                        {"Jane Smith", "654321", "Class 9", false},
                        {"Tom Johnson", "987654", "Class 11", false}
                        // Add more rows of default student data here
                };
            } else {
                // Read student data from the file
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ArrayList<Object[]> studentDataList = new ArrayList<>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] studentData = line.split(",");
                    String name = studentData[0].trim();
                    String regNo = studentData[1].trim();
                    String className = studentData[2].trim();
                    boolean present = Boolean.parseBoolean(studentData[3].trim());
                    studentDataList.add(new Object[]{name, regNo, className, present});
                }
                bufferedReader.close();
                return studentDataList.toArray(new Object[0][0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Return default student data in case of any error
            return new Object[][]{
                    {"John Doe", "123456", "Class 10", false},
                    {"Jane Smith", "654321", "Class 9", false},
                    {"Tom Johnson", "987654", "Class 11", false}
                    // Add more rows of default student data here
            };
        }
    }
     private static void saveAttendanceData(DefaultTableModel model) {
    try {
        File file = new File("student_data.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < model.getRowCount(); i++) {
            String name = (String) model.getValueAt(i, 0);
            String regNo = (String) model.getValueAt(i, 1);
            String className = (String) model.getValueAt(i, 2);
            boolean isPresent = (boolean) model.getValueAt(i, 3);
            String line = name + "," + regNo + "," + className + "," + isPresent;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private static boolean areAllStudentsPresent(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            boolean present = (boolean) model.getValueAt(i, 3);
            if (!present) {
                return false;
            }
        }
        return true;
    }
    private static void markAllStudentsPresent(DefaultTableModel model, boolean present) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(present, i, 3);
        }
    }
}
