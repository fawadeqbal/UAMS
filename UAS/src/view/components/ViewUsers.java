package view.components;

import controller.UASController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.TableCellEditor;
import model.UASFactory;
import model.dto.Response;
import model.dto.UserDTO;

public class ViewUsers extends JPanel {

    private JTable table;
    private JComboBox<String> roleDropdown; // Add the JComboBox
    private UASController objController;

    public ViewUsers() {
        objController = UASFactory.getUASControllerInstance();
        setLayout(new BorderLayout());

        // Create the role label and dropdown panel
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel roleLabel = new JLabel("Filter by Role:");
        roleDropdown = new JComboBox<>(new String[]{"All", "admin", "faculty", "student"}); // Add any other roles here
        roleDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterUsersByRole((String) roleDropdown.getSelectedItem());
            }
        });
        rolePanel.add(roleLabel);
        rolePanel.add(roleDropdown);

        // Add the role panel to the top of the view
        add(rolePanel, BorderLayout.NORTH);

        // Create the table model with column names
        String[] columnNames = {"Email", "Password", "Role", "Action"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Disable editing for all columns except the delete column
                return column == getColumnCount() - 1;
            }
        };

        Response response = UASFactory.getResponseInstance();
        ArrayList<UserDTO> userList = objController.getUsers(response);

        // Add all users to the table model initially
        addUsersToTableModel(tableModel, userList);

        // Create the table with the model
        table = new JTable(tableModel);

        // Create a custom button renderer
        TableCellRenderer buttonRenderer = new TableCellButtonRenderer();

        // Set the button renderer for the delete column
        table.getColumnModel().getColumn(columnNames.length - 1).setCellRenderer(buttonRenderer);

        // Create a custom button editor
        TableCellEditor buttonEditor = new TableCellButtonEditor();

        // Set the button editor for the delete column
        table.getColumnModel().getColumn(columnNames.length - 1).setCellEditor(buttonEditor);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addUsersToTableModel(DefaultTableModel tableModel, ArrayList<UserDTO> userList) {
        for (UserDTO u : userList) {
            tableModel.addRow(new Object[]{
                u.getEmail(),
                u.getPassword(),
                u.getRole(),
                "Delete"
            });
        }
    }

    private class TableCellButtonRenderer extends JButton implements TableCellRenderer {

        public TableCellButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public TableCellButtonRenderer getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }

    private class TableCellButtonEditor extends DefaultCellEditor {

        private JButton button;
        private String label;
        private boolean isPushed;

        public TableCellButtonEditor() {
            super(new JTextField());

            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        fireEditingStopped();
                    }
                }
            });
        }

        public JButton getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;

            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Handle delete button click here

                // Perform the deletion logic for the selected row
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRow = table.getSelectedRow();

                String email = (String) model.getValueAt(selectedRow, 0);
                String password = (String) model.getValueAt(selectedRow, 1);
                String role = (String) model.getValueAt(selectedRow, 2);
                UserDTO userObj = new UserDTO(email, password, role);
                Response responseObj = UASFactory.getResponseInstance();
                objController.deleteUser(userObj, responseObj);
                if (responseObj.isSuccessfull()) {
                    JOptionPane.showMessageDialog(null, responseObj.getInfoMessages());
                    refreshTableData();
                } else {
                    JOptionPane.showMessageDialog(null, responseObj.getErrorMessages());
                }

            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private void refreshTableData() {
        // Clear the existing table data
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        // Retrieve the updated user list from the controller
        Response response = UASFactory.getResponseInstance();
        ArrayList<UserDTO> userList = objController.getUsers(response);

        // Add users based on the selected role from the dropdown
        String selectedRole = (String) roleDropdown.getSelectedItem();
        if ("All".equals(selectedRole)) {
            // Show all users
            addUsersToTableModel(tableModel, userList);
        } else {
            // Show users of the selected role only
            ArrayList<UserDTO> usersToShow = new ArrayList<>();
            for (UserDTO user : userList) {
                if (selectedRole.equals(user.getRole())) {
                    usersToShow.add(user);
                }
            }
            addUsersToTableModel(tableModel, usersToShow);
        }

        // Notify the table model that the data has changed
        tableModel.fireTableDataChanged();
    }

    private void filterUsersByRole(String selectedRole) {
        refreshTableData();
    }
}
