/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.dto.CourseDTO;
import model.dto.Response;

/**
 *
 * @author fawad
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.StudentDTO;
import model.dto.UserDTO;

public class ObjectAdder {

    public void addCourse(CourseDTO course, Connection connection, Response objResponse) {
        try {
            // Prepare the SQL query
            String query = "INSERT INTO Courses (course_code, course_name, credit_hours) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the values for the parameters in the query
            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getCreditHours());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Course added successfully
                objResponse.messagesList.add(new Message("Course added successfully.", MessageType.Information));
            } else {
                // Failed to add the course
                objResponse.messagesList.add(new Message("Failed to add the course.", MessageType.Error));
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            objResponse.messagesList.add(new Message("Course already exists.", MessageType.Error));

        }
    }

    public void addUser(UserDTO userObj, Connection connection, Response objResponse) {
        try {
            // Prepare the SQL query
            String query = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the values for the parameters in the query
            statement.setString(1, userObj.getEmail());
            statement.setString(2, userObj.getPassword());
            statement.setString(3, userObj.getRole());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Course added successfully
                objResponse.messagesList.add(new Message("User added successfully.", MessageType.Information));
            } else {
                // Failed to add the course
                objResponse.messagesList.add(new Message("Failed to add new User.", MessageType.Error));
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            objResponse.messagesList.add(new Message(e.getMessage(), MessageType.Error));

        }
    }

    public void addStudent(StudentDTO studentObj, Connection connection, Response objResponse) {
        try {
            // Prepare the SQL query
            String query = "INSERT INTO Students (regno, student_name, father_name, dob, cnic, phone_number, Users_email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, studentObj.getRegNo());
            statement.setString(2, studentObj.getName());
            statement.setString(3, studentObj.getFatherName());
            statement.setDate(4, new java.sql.Date(studentObj.getDob().getTime()) );
            statement.setString(5, studentObj.getCnic());
            statement.setString(6, studentObj.getPhoneNumber());
            statement.setString(7, studentObj.getUserEmail());

            // Execute the query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Course added successfully
                objResponse.messagesList.add(new Message("User added successfully.", MessageType.Information));
            } else {
                // Failed to add the course
                objResponse.messagesList.add(new Message("Failed to add new User.", MessageType.Error));
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            objResponse.messagesList.add(new Message(e.getMessage(), MessageType.Error));

        }
    }
}
