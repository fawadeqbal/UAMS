/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fawad
 */
public class DBReader {

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
