package dal;

import dal.db.MySQLConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;
import model.dto.UserDTO;

public class DALManager {

    ObjectMapper objMapper;
    MySQLConnection mySQL;
    DBReader objReader;
    ObjectAdder objAdder;
    ObjectModifier objModifier;
    ObjectRemover objRemover;

    public DALManager() {
        objRemover = new ObjectRemover();
        objModifier = new ObjectModifier();
        objAdder = new ObjectAdder();
        objMapper = new ObjectMapper();
        objReader = new DBReader();
        mySQL = new MySQLConnection("jdbc:mysql://localhost:3306/UAS", "root", "Admin123$");
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        ResultSet resultSet = null;
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
            resultSet = objReader.getUser(responseObj, user, connection, query);
        }
        if (responseObj.isSuccessfull()) {
            objMapper.verifyUser(resultSet, user, responseObj);
        }
    }

    public void addCourse(CourseDTO course, Response responseObj) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            objAdder.addCourse(course, connection, responseObj);
        }
    }

    public ArrayList<CourseDTO> getCourses(Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM Courses";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getCourses(resultSet);
    }

    public void addUser(UserDTO userObj, Response responseObj) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            objAdder.addUser(userObj, connection, responseObj);
        }
    }

    public ArrayList<UserDTO> getUsers(Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM Users";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getUsers(resultSet);
    }

    public void updatePassword(UserDTO userObj, Response responseObj) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            objModifier.updatePassword(userObj, connection, responseObj);
        }

    }

    public void deleteUser(UserDTO userObj, Response responseObj) {

        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            objRemover.deleteUser(connection, responseObj, userObj);
        }
    }

    public void addStudent(StudentDTO studentObj, Response responseObj) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            objAdder.addStudent(studentObj, connection, responseObj);
        }
    }

    public ArrayList<StudentDTO> getStudents(Response response) {

        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }

        ResultSet resultSet = null;
        String query = "SELECT * FROM Students";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getStudents(resultSet);
    }

    public ArrayList<TeacherDTO> getTeachers(Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }

        ResultSet resultSet = null;
        String query = "SELECT * FROM Teachers";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getTeachers(resultSet);
    }
    /*
    public static void main(String[] args) {
        DALManager dal=new DALManager();
        Response res=UASFactory.getResponseInstance();
        for(TeacherDTO t:dal.getTeachers(res)){
            System.out.println(t.toString());
        }
    } 
     */

    public void addTeacher(TeacherDTO teacher, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        } else {
            objAdder.addTeacher(teacher, connection, response);
        }
    }
    
    public void assignCourseTeacher(TeacherDTO teacher,CourseDTO course, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        } else {
            objAdder.assignCourseTeacher(teacher, course,connection, response);
        }
    }
    
}
