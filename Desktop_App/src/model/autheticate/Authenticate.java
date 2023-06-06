
package model.autheticate;

import common.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Conn;

/**
 *
 * @author fawad
 */
public class Authenticate {
    

    public boolean authenticate(UserDTO user) {
        // Establish a database connection
        Connection connection = null;
        try {
            connection = Conn.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Query the database to validate the username and password
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
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
