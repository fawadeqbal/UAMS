/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dto.CourseDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.TeacherDTO;
import model.dto.UserDTO;

/**
 *
 * @author fawad
 */
public class DBReader {

    ResultSet getUser(Response responseObj, UserDTO user, Connection connection, String query) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            return statement.executeQuery();
        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        }
        return null;
    }


    ResultSet getRecords(Connection connection, Response responseObj,String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            responseObj.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
        return null;
    }

    

    ResultSet getTeacher(TeacherDTO teacher, Connection connection, Response response, String query) {
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement(query);
            statement.setInt(1, teacher.getId());
            return statement.executeQuery();

        } catch (Exception ex) {
            response.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        }
        return null;
    }

    ResultSet getCourse(CourseDTO course, Connection connection, Response response, String query) {
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement(query);
            statement.setString(1, course.getCourseCode());
            return statement.executeQuery();

        } catch (Exception ex) {
            response.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        }
        return null;
    }

    ResultSet getTeacherEmail(UserDTO user, Connection connection, Response response, String query) {
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            return statement.executeQuery();

        } catch (Exception ex) {
            response.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        }
        return null;
    }

}
