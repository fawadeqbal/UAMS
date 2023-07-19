package view.panels;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import controller.UASController;
import model.UASFactory;

public class AddAttendance extends JPanel {

    UASController controllerObj = UASFactory.getUASControllerInstance();
    ArrayList<Object> list;
    private JLabel classLabel;
    private JComboBox<String> classComboBox;
    private JLabel dateLabel;
    private JDatePicker datePicker;
    private JLabel timeSlotLabel;
    private JTextField timeSlotField;
    private JLabel remarksLabel;
    private JTextField remarksField;
    private JTable studentTable;
    private JButton addAttendanceButton;
    private JCheckBox checkAllCheckBox;

    public AddAttendance() {
        initializeComponents();
        setupLayout();
        addListeners();
    }

    private void initializeComponents() {

        classLabel = new JLabel("Class:");
//        list=controllerObj.getClasses(UASController.objApplicationSession.getUser(), response);

//         Stack<String> cl=new Stack<>();
//        for(ClassDTO c:list){
//            cl.push(c.getClass_id());
//            System.out.println(c.getClass_id());
//        }
        classComboBox = new JComboBox<>();
        dateLabel = new JLabel("Date:");
        datePicker = new JDatePicker(new Date());

        timeSlotLabel = new JLabel("Time Slot:");
        timeSlotField = new JTextField(10);
        remarksLabel = new JLabel("Remarks:");
        remarksField = new JTextField(20);

        // Set current time slot
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentDate = new Date();
        String timeString = timeFormat.format(currentDate);

        timeSlotField.setText(timeString);
//controllerObj.getStudentsByCourse()
        studentTable = new JTable() {
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
        add(classLabel, gbc);

        gbc.gridx = 1;
        add(classComboBox, gbc);
        //Add course

        // Add date label and date picker
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(dateLabel, gbc);

        gbc.gridx = 1;
        add(datePicker, gbc);

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

        // Add check/uncheck all checkbox
        checkAllCheckBox = new JCheckBox("Check/Uncheck All");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(checkAllCheckBox, gbc);

        // Add student table
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, gbc);

        // Add add attendance button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        add(addAttendanceButton, gbc);
    }

    private void addListeners() {
        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) classComboBox.getSelectedItem();
                //= controllerObj.getStudentsByCourse();
                DefaultTableModel newTableModel = new DefaultTableModel();
                studentTable.setModel(newTableModel);
            }
        });

        checkAllCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = checkAllCheckBox.isSelected();
                DefaultTableModel tableModel = (DefaultTableModel) studentTable.getModel();
                int rowCount = tableModel.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    tableModel.setValueAt(isChecked, i, 2);
                }
            }
        });

        addAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                Date selectedDate = (Date) datePicker.getModel().getValue();
                String timeSlot = timeSlotField.getText();
                String remarks = remarksField.getText();
                System.out.println(selectedDate.toString());

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
                timeSlotField.setText("");
                remarksField.setText("");

                // Clear table selection
                studentTable.clearSelection();
            }
        });
    }

}
