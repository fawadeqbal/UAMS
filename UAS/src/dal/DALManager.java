package dal;

import dal.db.MySQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UASFactory;
import model.dto.ClassDTO;
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
        objAdder=new ObjectAdder();
        objMapper=new ObjectMapper();
        objReader=new DBReader();
        mySQL = new MySQLConnection("jdbc:mysql://localhost:3306/UAS", "root", "Admin123$");
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        ResultSet resultSet = objReader.getUser(responseObj,user,connection);
        if(resultSet==null){
            System.out.println("Response Error");
            return;
        }
        try {
            if (resultSet.next()) {
                user.setRole(resultSet.getString(4));
                responseObj.messagesList.add(new Message("Successfully Login", MessageType.Information));
            } else {
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password", MessageType.Error));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public ArrayList<ClassDTO> getClasses(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        ResultSet resultSet = objReader.getClasses(responseObj, user, connection);
        
        return objMapper.getClasses(resultSet);
    }
    
    public void addCourse(CourseDTO course,Response responseObj){
        Connection connection=mySQL.getConnection();
        objAdder.addCourse(course, connection, responseObj);
    }
    
//    
//    
//    public static void main(String[] args) {
//        DALManager dal=new DALManager();
//        Response res=UASFactory.getResponseInstance();
//        ArrayList<CourseDTO> list=dal.getCourses(res);
//        if(res.isSuccessfull()){
//            int i=0;
//            for(CourseDTO c:list){
//                i++;
//                System.out.print(""+i+": ");
//                System.out.println(c.getCourseCode()+"\t"+c.getCourseName());
//            }
//            System.out.println("Total: "+i);
//        }
//    }

    public ArrayList<CourseDTO> getCourses(Response response) {
        ArrayList<CourseDTO> coursesList = new ArrayList<>();
        Connection connection = mySQL.getConnection();
        
        ResultSet resultSet = null;
        resultSet=objReader.getCourses(connection, response);
            return objMapper.getCourses(resultSet);
    }
    public ArrayList<Object> getStudentsByCourse(int id){
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
            return objMapper.getStudent(resultSet);
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
