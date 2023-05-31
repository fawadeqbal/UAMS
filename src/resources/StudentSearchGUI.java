package resources;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

public class StudentSearchGUI extends JFrame {
    private static final String FILE_NAME = "students.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    private JLabel regNoLabel;
    private JTextField regNoTextField;
    private JLabel progLabel;
    private JTextField progTextField;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel fatherNameLabel;
    private JTextField fatherNameTextField;
    private JLabel contactLabel;
    private JTextField contactTextField;
    private JLabel idCardLabel;
    private JTextField idCardTextField;
    private JLabel dobLabel;
    private JTextField dobTextField;
    private JLabel nationalityLabel;
    private JTextField nationalityTextField;
    private JLabel statusLabel;
    private JTextField statusTextField;
    private JLabel groupLabel;
    private JTextField groupTextField;
    private JLabel marksLabel;
    private JTextField marksTextField;
    private JLabel obtLabel;
    private JTextField obtTextField;

    public StudentSearchGUI() {
        setTitle("Student Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        regNoLabel = new JLabel("Registration Number:");
        regNoTextField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String regNo = regNoTextField.getText();
                if (!regNo.isEmpty()) {
                    StudentDetails details = searchStudent(regNo);
                    displayStudentDetails(details);
                }
            }
        });

        progLabel = new JLabel("Program:");
        progTextField = new JTextField(15);
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(15);
        fatherNameLabel = new JLabel("Father Name:");
        fatherNameTextField = new JTextField(15);
        contactLabel = new JLabel("Contact #: ");
        contactTextField = new JTextField(15);
        idCardLabel = new JLabel("ID Card #: ");
        idCardTextField = new JTextField(15);
        dobLabel = new JLabel("Date of Birth:");
        dobTextField = new JTextField(15);
        nationalityLabel = new JLabel("Nationality:");
        nationalityTextField = new JTextField(15);
        statusLabel = new JLabel("Status:");
        statusTextField = new JTextField(15);
        groupLabel = new JLabel("Group:");
        groupTextField = new JTextField(15);
        marksLabel = new JLabel("Marks:");
        marksTextField = new JTextField(15);
        obtLabel = new JLabel("Obt:");
        obtTextField = new JTextField(15);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(regNoLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        add(regNoTextField, c);

        c.gridx = 2;
        c.gridy = 0;
        add(searchButton, c);

        c.gridx = 0;
        c.gridy = 1;
        add(progLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        add(progTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        add(nameTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        add(fatherNameLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        add(fatherNameTextField, c);

        c.gridx = 0;
        c.gridy = 4;
        add(contactLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        add(contactTextField, c);

        c.gridx = 0;
        c.gridy = 5;
        add(idCardLabel, c);

        c.gridx = 1;
        c.gridy = 5;
        add(idCardTextField, c);

        c.gridx = 0;
        c.gridy = 6;
        add(dobLabel, c);

        c.gridx = 1;
        c.gridy = 6;
        add(dobTextField, c);

        c.gridx = 0;
        c.gridy = 7;
        add(nationalityLabel, c);

        c.gridx = 1;
        c.gridy = 7;
        add(nationalityTextField, c);

        c.gridx = 0;
        c.gridy = 8;
        add(statusLabel, c);

        c.gridx = 1;
        c.gridy = 8;
        add(statusTextField, c);

        c.gridx = 0;
        c.gridy = 9;
        add(groupLabel, c);

        c.gridx = 1;
        c.gridy = 9;
        add(groupTextField, c);

        c.gridx = 0;
        c.gridy = 10;
        add(marksLabel, c);

        c.gridx = 1;
        c.gridy = 10;
        add(marksTextField, c);

        c.gridx = 0;
        c.gridy = 11;
        add(obtLabel, c);

        c.gridx = 1;
        c.gridy = 11;
        add(obtTextField, c);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private StudentDetails searchStudent(String regNo) {
        try {
            FileInputStream file = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(SHEET_NAME);

            for (Row row : sheet) {
                Cell regNoCell = row.getCell(1); // Assuming Reg# is in the second column (index 1)
                if (regNoCell != null && regNoCell.getCellTypeEnum() == CellType.STRING) {
                    String cellValue = regNoCell.getStringCellValue();
                    if (cellValue.equalsIgnoreCase(regNo)) {
                        // Student found, retrieve details
                        return getStudentDetails(row);
                    }
                }
            }

            workbook.close();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    private StudentDetails getStudentDetails(Row row) {
        String regNo = getStringValue(row.getCell(1));
        String prog = getStringValue(row.getCell(2));
        String name = getStringValue(row.getCell(3));
        String fatherName = getStringValue(row.getCell(4));
        String contact = getStringValue(row.getCell(5));
        String idCard = getStringValue(row.getCell(6));
        String dob = getStringValue(row.getCell(7));
        String nationality = getStringValue(row.getCell(8));
        String status = getStringValue(row.getCell(9));
        String group = getStringValue(row.getCell(10));
        String marks = getStringValue(row.getCell(11));
        String obt = getStringValue(row.getCell(12));

        return new StudentDetails(regNo, prog, name, fatherName, contact, idCard, dob, nationality, status, group, marks, obt);
    }

    private String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        CellType cellType = cell.getCellTypeEnum();
        if (cellType == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cellType == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue().toString();
            } else {
                return Double.toString(cell.getNumericCellValue());
            }
        } else if (cellType == CellType.BOOLEAN) {
            return Boolean.toString(cell.getBooleanCellValue());
        } else {
            return "";
        }
    }

    private void displayStudentDetails(StudentDetails details) {
        if (details != null) {
            regNoTextField.setText(details.getRegNo());
            progTextField.setText(details.getProg());
            nameTextField.setText(details.getName());
            fatherNameTextField.setText(details.getFatherName());
            contactTextField.setText(details.getContact());
            idCardTextField.setText(details.getIdCard());
            dobTextField.setText(details.getDob());
            nationalityTextField.setText(details.getNationality());
            statusTextField.setText(details.getStatus());
            groupTextField.setText(details.getGroup());
            marksTextField.setText(details.getMarks());
            obtTextField.setText(details.getObt());
        } else {
            regNoTextField.setText("");
            progTextField.setText("");
            nameTextField.setText("");
            fatherNameTextField.setText("");
            contactTextField.setText("");
            idCardTextField.setText("");
            dobTextField.setText("");
            nationalityTextField.setText("");
            statusTextField.setText("");
            groupTextField.setText("");
            marksTextField.setText("");
            obtTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentSearchGUI();
            }
        });
    }
}

class StudentDetails {
    private String regNo;
    private String prog;
    private String name;
    private String fatherName;
    private String contact;
    private String idCard;
    private String dob;
    private String nationality;
    private String status;
    private String group;
    private String marks;
    private String obt;

    public StudentDetails(String regNo, String prog, String name, String fatherName, String contact, String idCard, String dob, String nationality, String status, String group, String marks, String obt) {
        this.regNo = regNo;
        this.prog = prog;
        this.name = name;
        this.fatherName = fatherName;
        this.contact = contact;
        this.idCard = idCard;
        this.dob = dob;
        this.nationality = nationality;
        this.status = status;
        this.group = group;
        this.marks = marks;
        this.obt = obt;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getProg() {
        return prog;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getContact() {
        return contact;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getDob() {
        return dob;
    }

    public String getNationality() {
        return nationality;
    }

    public String getStatus() {
        return status;
    }

    public String getGroup() {
        return group;
    }

    public String getMarks() {
        return marks;
    }

    public String getObt() {
        return obt;
    }
}
