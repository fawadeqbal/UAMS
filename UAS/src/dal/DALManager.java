package dal;

import dal.db.MySQLConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import model.UASFactory;
import model.dto.ClassDTO;
import model.dto.CourseDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherCourseDTO;
import model.dto.TeacherCourseViewDTO;
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
        mySQL = new MySQLConnection("jdbc:mysql://localhost:3306/uas", "root", "Admin123$");
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = mySQL.getConnection();
        ResultSet resultSet = null;
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
        } else {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
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
        String query = "SELECT * FROM courses";
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
        String query = "SELECT * FROM users";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getUsers(resultSet);
    }

    public CourseDTO getCoursebyId(CourseDTO course, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM courses WHERE course_code=?";
        resultSet = objReader.getCourse(course, connection, response, query);
        return objMapper.getCourseById(resultSet);
    }

    public TeacherDTO getTeacherbyId(TeacherDTO teacher, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM teachers WHERE teacher_id=?";
        resultSet = objReader.getTeacher(teacher, connection, response, query);
        return objMapper.getTeacher(resultSet);
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
        String query = "SELECT * FROM students";
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
        String query = "SELECT * FROM teachers";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getTeachers(resultSet);
    }

   

    public void addTeacher(TeacherDTO teacher, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        } else {
            objAdder.addTeacher(teacher, connection, response);
        }
    }

    public void assignCourseTeacher(TeacherDTO teacher, CourseDTO course, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        } else {
            objAdder.assignCourseTeacher(teacher, course, connection, response);
        }
    }

    public ArrayList<TeacherCourseViewDTO> getAssignCourseTeacher(Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM TeacherCourseView;";
        resultSet = objReader.getRecords(connection, response, query);
        return objMapper.getAssignCourseTeacher(resultSet);
    }
    public TeacherDTO getTeacherByEmail(UserDTO user,Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
            return new TeacherDTO();
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM teachers WHERE Users_email=?;";
        resultSet = objReader.getTeacherEmail(user,connection, response, query);
        return objMapper.getTeacher(resultSet);
    }
    public ArrayList<ClassDTO> getClassesByTeacherID(TeacherDTO teacher,Response response){
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT DISTINCT class_id FROM TeacherClassView WHERE teacher_id = ?;";
        resultSet = objReader.getTeacher(teacher, connection, response, query);
        return objMapper.getClasses(resultSet);
        
    }

    

    public ArrayList<TeacherCourseViewDTO> getCoursesByClassIDTeacherID(ClassDTO classObj, TeacherDTO teacher, Response response) {
        Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM course_details_view WHERE faculty_id=? AND class_id=?";
        resultSet = objReader.getCourses(classObj,teacher, connection, response, query);
        return objMapper.getCoursesofTecher(resultSet);
    }

    public ArrayList<StudentDTO> getStudentByClassIDCourseCode(ClassDTO classObj, CourseDTO course, Response response) {
       Connection connection = mySQL.getConnection();
        if (connection == null) {
            Message message = new Message("Database Connection issue please contact customer services.", MessageType.Exception);
            response.messagesList.add((message));
        }
        ResultSet resultSet = null;
        String query = "SELECT student_name,student_regno FROM view_students_by_class_and_course WHERE class_id=? AND course_code=?;";
        resultSet = objReader.getStudentResult(classObj,course, connection, response, query);
        return objMapper.getStudentList(resultSet);
    }
  
}
