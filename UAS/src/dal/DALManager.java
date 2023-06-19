package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.UserDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fawad
 */
public class DALManager {
    MySQLConnection mySQL;
    
    public DALManager(){
        mySQL=new MySQLConnection("jdbc:mysql://localhost:3306/attendance","root","fawad321");
    }
    
    public void verifyUser(UserDTO user,Response responseObj){
        Connection connection=mySQL.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                responseObj.messagesList.add(new Message("Successfully Login",MessageType.Information));
            }else{
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password",MessageType.Error));
            }
        } catch (Exception ex) {
                responseObj.messagesList.add(new Message(ex.getMessage(),MessageType.Exception));
            
        } finally {
            
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if(connection !=null){
                    connection.close();
                }
            
            } catch (Exception ex) {
                responseObj.messagesList.add(new Message(ex.getMessage(),MessageType.Exception));
            }
        }
    }
    
}
