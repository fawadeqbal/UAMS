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
import java.sql.Statement;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
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

    ResultSet getCourses(Connection connection, Response responseObj,String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            responseObj.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
        return null;
    }

    ResultSet getUsers(Connection connection, Response responseObj,String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            responseObj.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
        return null;
    }

    ResultSet getStudents(Connection connection, Response responseObj,String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            responseObj.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
        return null;
    }

    ResultSet getClasses(Response responseObj, UserDTO user, Connection connection) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Classes WHERE teacher_id=? ";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            return statement.executeQuery();

        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        }
        return null;
    }

}
