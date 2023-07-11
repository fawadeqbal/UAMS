package model;

import common.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentDataApp {

    private static class StudentSenderThread extends Thread {

        private Student student;

        public StudentSenderThread(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            try {
                sendStudentDataToServer(student);
            } catch (IOException e) {
                System.out.println("Error sending student data: " + e.getMessage());
            }
        }
    }

    private static void sendStudentDataToServer(Student student) throws IOException {
        // Set the URL of the Node.js server
        String serverUrl = "http://localhost:3000/student";

        // Create a JSON representation of the student object
        String studentJson = "{\"regNo\":\"" + student.getRegNo() + "\", \"prog\":\"" + student.getProg() + "\", \"name\":\"" + student.getName() + "\", \"fatherName\":\"" + student.getFatherName() + "\", \"nationality\":\"" + student.getNationality() + "\", \"status\":\"" + student.getStatus() + "\", \"group\":\"" + student.getGroup() + "\"}";

        // Create the HTTP connection
        URL url = new URL(serverUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Send the student data to the server
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(studentJson.getBytes());
        outputStream.flush();

        // Read the response from the server
        int responseCode = connection.getResponseCode();

        // Handle the response from the server
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Data sent to server successfully for student: " + student.getRegNo());
        } else {
            System.out.println("Failed to send data to server for student: " + student.getRegNo() + ". Response code: " + responseCode);
        }

        // Close the connection
        connection.disconnect();
    }

    public static ArrayList<Student> getStudents(String excelFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(1);
        ArrayList<Student> studentList = new ArrayList<>();

        for (int rowIndex = 500; rowIndex <= 600; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            
            Student student = new Student();
            //student.setSrNo(""+row.getCell(0).getNumericCellValue());
            student.setRegNo(row.getCell(1).getStringCellValue());
            student.setProg(row.getCell(2).getStringCellValue());
            student.setName(row.getCell(3).getStringCellValue());
            student.setFatherName(row.getCell(4).getStringCellValue());
            student.setNationality(row.getCell(8).getStringCellValue());
            student.setStatus(row.getCell(9).getStringCellValue());
            student.setGroup(row.getCell(10).getStringCellValue());

            studentList.add(student);
            System.out.println(student.toString());
        }

        workbook.close();
        fileInputStream.close();
        return studentList;
    }

    private void createAndShowGUI(ArrayList<Student> students) {
        // Create a JFrame to hold the JTable
        JFrame frame = new JFrame("Student Table");

        // Create a DefaultTableModel to hold the data for the JTable
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Registration Number");
        model.addColumn("Program");
        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("Nationality");
        model.addColumn("Status");
        model.addColumn("Group");

        // Add rows to the model using the data from the ArrayList
        for (Student student : students) {
            model.addRow(new Object[]{
                student.getRegNo(),
                student.getProg(),
                student.getName(),
                student.getFatherName(),
                student.getNationality(),
                student.getStatus(),
                student.getGroup()
            });
        }

        // Create a JTable with the created model
        JTable table = new JTable(model);

        // Create a JScrollPane to hold the JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane);

        // Set JFrame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        String excelFilePath = "/home/fawad/Desktop/students.xlsx";
        ArrayList<Student> students = getStudents(excelFilePath);

        int i = 0;
        for (Student student : students) {
            System.out.println(student.toString() + "\n");
            i++;

            // Create and start a new thread for each student to send the data asynchronously
            StudentSenderThread senderThread = new StudentSenderThread(student);
            senderThread.start();

        }
        System.out.println("Total students: " + i);
    }
}
