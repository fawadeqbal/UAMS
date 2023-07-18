/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.dto.CourseDTO;
import model.dto.Response;
import java.sql.Connection;

/**
 *
 * @author fawad
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;

public class ObjectAdder {
    public void addCourse(CourseDTO course, Connection connection, Response objResponse) {
        try {
            // Prepare the SQL query
            String query = "INSERT INTO Courses (course_code, course_name, credit_hours) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            // Set the values for the parameters in the query
            statement.setString(1, course.getC_Id());
            statement.setString(2, course.getC_Name());
            statement.setInt(3, course.getC_credit_hours());
            
            // Execute the query
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                // Course added successfully
                objResponse.messagesList.add(new Message("Course added successfully.",MessageType.Information));
            } else {
                // Failed to add the course
                objResponse.messagesList.add(new Message("Failed to add the course.",MessageType.Error));
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            objResponse.messagesList.add(new Message(e.getMessage(),MessageType.Exception));
            //objResponse.setMessage("An error occurred while adding the course: " + e.getMessage());
        }
    }
}

