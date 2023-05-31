/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private String filePath;

    public ExcelUtil(String filePath) {
        this.filePath = filePath;
    }

    public List<User> readUsersFromExcel() {
        List<User> userList = new ArrayList<>();

        try (Workbook workbook = getWorkbook()) {
            if (workbook == null) {
                return userList;
            }

            Sheet sheet = workbook.getSheet("Users");
            if (sheet == null) {
                return userList;
            }

            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the first row (header row)
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell usernameCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);
                Cell roleCell = row.getCell(2);

                if (usernameCell != null && passwordCell != null && roleCell != null) {
                    String username = usernameCell.getStringCellValue();
                    String password = passwordCell.getStringCellValue();
                    String role = roleCell.getStringCellValue();

                    User user = new User(username, password, role);
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUserToExcel(User user) {
        try (Workbook workbook = getWorkbook()) {
            if (workbook == null) {
                return;
            }

            Sheet sheet = workbook.getSheet("Users");
            if (sheet == null) {
                sheet = workbook.createSheet("Users");

                // Create header row
                Row headerRow = sheet.createRow(0);
                Cell usernameHeader = headerRow.createCell(0);
                Cell passwordHeader = headerRow.createCell(1);
                Cell roleHeader = headerRow.createCell(2);

                usernameHeader.setCellValue("Username");
                passwordHeader.setCellValue("Password");
                roleHeader.setCellValue("Role");
            }

            int lastRowNum = sheet.getLastRowNum();

            Row newRow = sheet.createRow(lastRowNum + 1);
            Cell usernameCell = newRow.createCell(0);
            Cell passwordCell = newRow.createCell(1);
            Cell roleCell = newRow.createCell(2);

            usernameCell.setCellValue(user.getUsername());
            passwordCell.setCellValue(user.getPassword());
            roleCell.setCellValue(user.getRole());

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Workbook getWorkbook() throws IOException {
        File file = new File(filePath);
        Workbook workbook = null;

        if (file.exists()) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } else {
            workbook = new XSSFWorkbook();
        }

        return workbook;
    }
    public static void main(String[] args) {
    ExcelUtil excelUtil = new ExcelUtil("users.xlsx");

    // Add a new user to the Excel sheet
    User newUser = new User("john", "password123", "Admin");
    excelUtil.addUserToExcel(newUser);

    // Read users from the Excel sheet
    List<User> userList = excelUtil.readUsersFromExcel();
    for (User user : userList) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());
        System.out.println();
    }
}

}



