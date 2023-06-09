package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import model.dto.CourseDTO;
import model.dto.EnrollStudentsDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.UserDTO;

public class DALManager {

    MySQLConnection mySQL;

    public DALManager() {
        mySQL = new MySQLConnection("jdbc:mysql://localhost:3306/attendance", "root", "Admin123$");
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setRole(resultSet.getString(5));
                responseObj.messagesList.add(new Message("Successfully Login", MessageType.Information));
            } else {
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password", MessageType.Error));
            }
        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } finally {

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
                responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));
            }
        }
    }

    public ArrayList<CourseDTO> getCourses(Response response) {
        ArrayList<CourseDTO> coursesList = new ArrayList<>();
        Connection connection = mySQL.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM course";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            ObjectMapper mapper=new ObjectMapper();
            return mapper.getCourses(resultSet);
        } catch (Exception ex) {
            response.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } finally {

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
                response.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));
            }
        }
        return coursesList;
    }
    public ArrayList<EnrollStudentsDTO> getStudentsByCourse(int id){
        Connection connection = mySQL.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM studentenroll where course_cid = "+id;
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            ObjectMapper mapper=new ObjectMapper();
            return mapper.getStudentsByCourse(resultSet);
        } catch (Exception ex) {
            
        } finally {

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
                
            }
        }
        return null;
    }
    
    public StudentDTO getStudent(int id){
        Connection connection = mySQL.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM student where sid = "+id;
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            ObjectMapper mapper=new ObjectMapper();
            return mapper.getStudent(resultSet);
        } catch (Exception ex) {
            
        } finally {

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
                
            }
        }
        return null;
    }
}
