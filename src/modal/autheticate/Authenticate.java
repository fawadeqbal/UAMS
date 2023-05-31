/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal.autheticate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modal.MySqlConnection;

/**
 *
 * @author fawad
 */
public class Authenticate {

    public static boolean autheticate(String username,String password) {
        // Establish a database connection
        Connection connection = null;
        try {
            connection = MySqlConnection.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Query the database to validate the username and password
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Authentication successful
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

}
