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
    
    ResultSet getUser(Response responseObj,UserDTO user,Connection connection){
       PreparedStatement statement = null;
     
        try {
            String query = "SELECT * FROM user WHERE user_id = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUserID());
            statement.setString(2, user.getPassword());
            return statement.executeQuery();
        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } 
        return null;
    }
    
    ResultSet getClasses(Response responseObj,UserDTO user,Connection connection){
       PreparedStatement statement = null;
       ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM Classes WHERE teacher_id=? ";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUserID());
            return statement.executeQuery();

            
        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } 
        return null;
    }

    ResultSet getRecords(String dblQuery,Connection conn) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(dblQuery);            
        }
        catch (Exception e) {
            System.out.println("Error Trace in getRecords() : " + e.getMessage());
        }
        return null;
    }
    
}
