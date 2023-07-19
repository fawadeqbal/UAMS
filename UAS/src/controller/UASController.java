/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.ApplicationSession;
import java.util.ArrayList;
import dal.DALManager;
import model.UASFactory;
import model.dto.CourseDTO;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherDTO;
import model.dto.UserDTO;
import model.validators.CommonValidator;

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
    
    public static void initializeSession() {
        objApplicationSession = new ApplicationSession();
        objApplicationSession.startSession();
    }
    
    public static boolean isSessionExpired() {
        return objApplicationSession.isSessionExpired();
    }
    
    public static void expireSession() {
        objApplicationSession = null;
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
        
        dalManagerObj.deleteUser(userObj, reponseObj);
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
    
}
