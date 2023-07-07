/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.dto.UserDTO;

/**
 *
 * @author fawad
 */
public class DBReader {

    ResultSet getUser(String dblQuery,UserDTO user,Connection conn) {
        Statement statement = conn.createStatement();
        try {
            
            
            statement = conn.prepareStatement(dblQuery);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
                   
        }
        catch (Exception e) {
            System.out.println("Error Trace in getRecords() : " + e.getMessage());
        }
        return null;
    }
    
}
