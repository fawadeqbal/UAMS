package controller;

import common.ApplicationSession;
import java.util.ArrayList;
import dal.DALManager;
import javax.swing.JFrame;
import model.UASFactory;
import model.dto.ClassDTO;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherCourseViewDTO;
import model.dto.TeacherDTO;
import model.dto.UserDTO;
import model.validators.CommonValidator;
import view.panels.LoginUI;

/**
 *
 * @author fawad
 */
public class UASController {

    public static ApplicationSession objApplicationSession;
    public DALManager dalManagerObj;

    public UASController() {
        dalManagerObj = UASFactory.getDALManagerInstance();
    }

    private static void startSessionExpirationThread() {
        Thread sessionExpirationThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(60 * 1000); // Check for session expiration every minute
                    if (objApplicationSession != null && objApplicationSession.isSessionExpired()) {
                        expireSession();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sessionExpirationThread.start();
    }

    public static void initializeSession() {
        objApplicationSession = new ApplicationSession();
        objApplicationSession.startSession();
        startSessionExpirationThread();
    }

    public static boolean isSessionExpired() {
        return objApplicationSession.isSessionExpired();
    }

    public static void expireSession() {
        if (objApplicationSession != null) {
            // Dispose the previous screen (if it exists)
            JFrame currentScreen = objApplicationSession.getCurrentScreen();
            if (currentScreen != null) {
                currentScreen.dispose();
            }
            // Set the ApplicationSession to null to signify session expiration
            objApplicationSession = null;
            // Show the LoginUI
            System.out.println("Expired.");
            new LoginUI().setVisible(true);
        }
    }

    public static boolean isUserLoggedIn() {
        return objApplicationSession != null;
    }

    public void verifyUser(UserDTO user, Response responseObj) {
        CommonValidator.validateUser(user, responseObj);
        if (responseObj.isSuccessfull()) {
            dalManagerObj.verifyUser(user, responseObj);
            if (responseObj.isSuccessfull()) {
                initializeSession();
                objApplicationSession.setUser(user);
            }
        }

    }

    public void addUser(UserDTO userObj, Response responseObj) {
        CommonValidator.validateUser(userObj, responseObj);
        if (responseObj.isSuccessfull()) {
            dalManagerObj.addUser(userObj, responseObj);
        }
    }

    public ArrayList<UserDTO> getUsers(Response response) {
        return dalManagerObj.getUsers(response);
    }

    public void updatePassword(UserDTO userObj, Response responseObj) {
        dalManagerObj.updatePassword(userObj, responseObj);
    }

    public void deleteUser(UserDTO userObj, Response reponseObj) {
        CommonValidator.validateUser(userObj, reponseObj);
        if(reponseObj.isSuccessfull()){
            dalManagerObj.deleteUser(userObj, reponseObj);
        }
    }

    public void addCourse(CourseDTO course, Response responseObj) {
        CommonValidator.validateCourse(course, responseObj);
        if (responseObj.isSuccessfull()) {
            dalManagerObj.addCourse(course, responseObj);
        }

    }

    public ArrayList<CourseDTO> getCourses(Response response) {
        return dalManagerObj.getCourses(response);
    }

    public void addStudent(StudentDTO studentObj, Response responseObj) {
        CommonValidator.validateStudent(studentObj, responseObj);
        if (responseObj.isSuccessfull()) {
            dalManagerObj.addStudent(studentObj, responseObj);
        }
    }

    public ArrayList<StudentDTO> getStudents(Response response) {
        return dalManagerObj.getStudents(response);
    }

    public ArrayList<TeacherDTO> getTeachers(Response response) {

        return dalManagerObj.getTeachers(response);
    }

    public void addTeacher(TeacherDTO teacher, Response response) {
        CommonValidator.validateTeacher(teacher, response);
        if (response.isSuccessfull()) {
            dalManagerObj.addTeacher(teacher, response);
        }
    }

    public void assignCourseTeacher(TeacherDTO teacher, CourseDTO course, Response response) {
        dalManagerObj.assignCourseTeacher(teacher, course, response);
    }

    public ArrayList<TeacherCourseViewDTO> getAssignCourseTeacher(Response response) {
        return dalManagerObj.getAssignCourseTeacher(response);
    }

    public TeacherDTO getTeacherById(int id, Response response) {
        TeacherDTO teacher = new TeacherDTO();
        teacher.setId(id);
        return dalManagerObj.getTeacherbyId(teacher, response);
    }

    public TeacherDTO getTeacherByEmail(Response response) {
        UserDTO user = UASController.objApplicationSession.getUser();
        return dalManagerObj.getTeacherByEmail(user, response);
    }

    public CourseDTO getCourseById(String courseCode, Response response) {
        CourseDTO course = new CourseDTO();
        course.setCourseCode(courseCode);
        return dalManagerObj.getCoursebyId(course, response);
    }
    public ArrayList<ClassDTO> getClassesByTeacherID(Response response) {
        TeacherDTO teacher = getTeacherByEmail(response);
        return dalManagerObj.getClassesByTeacherID(teacher, response);
    }
    
    public ArrayList<TeacherCourseViewDTO> getCoursesByClassIDTeacherID(ClassDTO classObj,Response response) {
        TeacherDTO teacher = getTeacherByEmail(response);
        return dalManagerObj.getCoursesByClassIDTeacherID(classObj,teacher, response);
    }
    
    public ArrayList<StudentDTO> getStudentByClassIDCourseCode(CourseDTO course,ClassDTO classObj,Response response) {
        
        return dalManagerObj.getStudentByClassIDCourseCode(classObj,course, response);
    }
}
