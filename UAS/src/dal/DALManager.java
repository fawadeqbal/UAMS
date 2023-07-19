package dal;

import dal.db.MySQLConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.UserDTO;

public class DALManager {

    ObjectMapper objMapper;
    MySQLConnection mySQL;
    DBReader objReader;
    ObjectAdder objAdder;

    public DALManager() {
        objAdder = new ObjectAdder();
        objMapper = new ObjectMapper();
        objReader = new DBReader();
        mySQL = new MySQLConnection("jdbc:mysql://localhost:3306/UAS", "root", "Admin123$");
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        ResultSet resultSet = objReader.getUser(responseObj, user, connection);
        if (resultSet == null) {
            System.out.println("Response Error");
            return;
        }
        try {
            if (resultSet.next()) {
                user.setRole(resultSet.getString(3));
                responseObj.messagesList.add(new Message("Successfully Login", MessageType.Information));
            } else {
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password", MessageType.Error));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCourse(CourseDTO course, Response responseObj) {
        Connection connection = mySQL.getConnection();
        objAdder.addCourse(course, connection, responseObj);
    }

    public ArrayList<CourseDTO> getCourses(Response response) {
        ArrayList<CourseDTO> coursesList = new ArrayList<>();
        Connection connection = mySQL.getConnection();

        ResultSet resultSet = null;
        resultSet = objReader.getCourses(connection, response);
        return objMapper.getCourses(resultSet);
    }

    public void addUser(UserDTO userObj, Response responseObj) {
        Connection connection = mySQL.getConnection();
        objAdder.addUser(userObj, connection, responseObj);
    }

    public ArrayList<UserDTO> getUsers(Response response) {
        ArrayList<UserDTO> userList = new ArrayList<>();
        Connection connection = mySQL.getConnection();

        ResultSet resultSet = null;
        resultSet = objReader.getUsers(connection, response);
        return objMapper.getUsers(resultSet);
    }
    
    public void addStudent(StudentDTO studentObj, Response responseObj) {
        Connection connection = mySQL.getConnection();
        objAdder.addStudent(studentObj, connection, responseObj);
    }
    
    public ArrayList<StudentDTO> getStudents(Response response) {
        Connection connection = mySQL.getConnection();

        ResultSet resultSet = null;
        resultSet = objReader.getStudents(connection, response);
        return objMapper.getStudents(resultSet);
    }

   
//    public static void main(String[] args) {
//        DALManager dal=new DALManager();
//        Response res=UASFactory.getResponseInstance();
//        
//        dal.getStudents(res);
//        if(res.isSuccessfull()){
//            System.out.println("yes");
//        }else{
//            System.out.println("no");
//        }
//    }
}
