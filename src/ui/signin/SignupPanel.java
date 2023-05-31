package ui.signin;
import ui.signin.LoginUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SignupPanel extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField userIDField;
    private JTextField dobField;
    private JTextField phoneField;

    public SignupPanel() {
        setTitle("UAS - Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 650));
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Username:");
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        JLabel firstNameLabel = new JLabel("First Name:");
        mainPanel.add(firstNameLabel, gbc);

        gbc.gridy++;
        JLabel lastNameLabel = new JLabel("Last Name:");
        mainPanel.add(lastNameLabel, gbc);

        gbc.gridy++;
        JLabel userIDLabel = new JLabel("User ID:");
        mainPanel.add(userIDLabel, gbc);

        gbc.gridy++;
        JLabel dobLabel = new JLabel("Date of Birth:");
        mainPanel.add(dobLabel, gbc);

        gbc.gridy++;
        JLabel phoneLabel = new JLabel("Phone Number:");
        mainPanel.add(phoneLabel, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        mainPanel.add(usernameField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        mainPanel.add(passwordField, gbc);

        gbc.gridy++;
        firstNameField = new JTextField(20);
        mainPanel.add(firstNameField, gbc);

        gbc.gridy++;
        lastNameField = new JTextField(20);
        mainPanel.add(lastNameField, gbc);

        gbc.gridy++;
        userIDField = new JTextField(20);
        mainPanel.add(userIDField, gbc);

        gbc.gridy++;
        dobField = new JTextField(20);
        mainPanel.add(dobField, gbc);

        gbc.gridy++;
        phoneField = new JTextField(20);
        mainPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton signupButton = new JButton("Submit");
        signupButton.setBackground(Color.GRAY);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(signupButton, gbc);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String userID = userIDField.getText();
                String dob = dobField.getText();
                String phone = phoneField.getText();

                // Validate the input
                if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() ||
                        lastName.isEmpty() || userID.isEmpty() || dob.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(SignupPanel.this,
                            "Please fill in all the fields.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Save the user information to an Excel sheet
                try {
                    String filePath = "users.xlsx";
                    Workbook workbook;
                    Sheet sheet;
                    Row row;
                    Cell cell;

                    // Check if the Excel file exists
                    File file = new File(filePath);
                    if (!file.exists()) {
                        // Create a new workbook and sheet
                        workbook = new XSSFWorkbook();
                        sheet = workbook.createSheet("Users");

                        // Create column headers
                        row = sheet.createRow(0);
                        cell = row.createCell(0);
                        cell.setCellValue("Username");
                        cell = row.createCell(1);
                        cell.setCellValue("Password");
                        cell = row.createCell(2);
                        cell.setCellValue("First Name");
                        cell = row.createCell(3);
                        cell.setCellValue("Last Name");
                        cell = row.createCell(4);
                        cell.setCellValue("User ID");
                        cell = row.createCell(5);
                        cell.setCellValue("Date of Birth");
                        cell = row.createCell(6);
                        cell.setCellValue("Phone Number");
                    } else {
                        // Load the existing workbook and sheet
                        FileInputStream fileInputStream = new FileInputStream(file);
                        workbook = new XSSFWorkbook(fileInputStream);
                        sheet = workbook.getSheet("Users");
                    }

                    // Get the next available row index
                    int nextRowIndex = sheet.getLastRowNum() + 1;
                    row = sheet.createRow(nextRowIndex);

                    // Write the user information to the row
                    cell = row.createCell(0);
                    cell.setCellValue(username);
                    cell = row.createCell(1);
                    cell.setCellValue(password);
                    cell = row.createCell(2);
                    cell.setCellValue(firstName);
                    cell = row.createCell(3);
                    cell.setCellValue(lastName);
                    cell = row.createCell(4);
                    cell.setCellValue(userID);
                    cell = row.createCell(5);
                    cell.setCellValue(dob);
                    cell = row.createCell(6);
                    cell.setCellValue(phone);

                    // Write the changes to the Excel file
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    workbook.write(fileOutputStream);
                    fileOutputStream.close();

                    JOptionPane.showMessageDialog(SignupPanel.this,
                            "User registered successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(SignupPanel.this,
                            "Error saving user information.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridy++;
        JLabel signinLabel = new JLabel("Already have an account?");
        signinLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(signinLabel, gbc);

        gbc.gridy++;
        JButton signinButton = new JButton("Sign In");
        signinButton.setBackground(Color.LIGHT_GRAY);
        signinButton.setForeground(Color.BLACK);
        signinButton.setFocusPainted(false);
        signinButton.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(signinButton, gbc);

        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI signinForm = new LoginUI();
                signinForm.setVisible(true);
                SignupPanel.this.setVisible(false);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        userIDField.setText("");
        dobField.setText("");
        phoneField.setText("");
    }

}
