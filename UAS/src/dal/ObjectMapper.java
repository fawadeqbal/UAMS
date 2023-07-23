/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.dto.CourseDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dto.ClassDTO;
import model.dto.CourseClassDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.StudentDTO;
import model.dto.TeacherCourseDTO;
import model.dto.TeacherCourseViewDTO;
import model.dto.TeacherDTO;
import model.dto.UserDTO;
/**
 *
 * @author fawad
 */
public class ObjectMapper {
    void verifyUser(ResultSet resultSet,UserDTO user,Response responseObj){
        try {
            if (resultSet.next()) {
                user.setRole(resultSet.getString(3));
                responseObj.messagesList.add(new Message("Successfully Login", MessageType.Information));
            } else {
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password", MessageType.Error));
            }
        } catch (SQLException ex) {
            Message message = new Message("Resultset Issue issue please contact customer services.", MessageType.Exception);
            responseObj.messagesList.add((message));
//            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ArrayList<CourseDTO> getCourses(ResultSet rs) {
        ArrayList<CourseDTO> courselist = new ArrayList<>();
        try{
        while (rs.next())
            {
                CourseDTO objCourse=new CourseDTO();                
                objCourse.setCourseCode(rs.getString(1));
                objCourse.setCourseName(rs.getString(2));
                objCourse.setCreditHours(rs.getInt(3));
                                
                courselist.add(objCourse);
            }
        }catch (Exception e){
        }
        return courselist;
    }
    
    ArrayList<UserDTO> getUsers(ResultSet rs) {
        ArrayList<UserDTO> userList = new ArrayList<>();
        try{
        while (rs.next())
            {
                UserDTO objUser=new UserDTO();                
                objUser.setEmail(rs.getString(1));
                objUser.setPassword(rs.getString(2));
                objUser.setRole(rs.getString(3));
                                
                userList.add(objUser);
            }
        }catch (Exception e){
        }
        return userList;
    }
    
    ArrayList<StudentDTO> getStudents(ResultSet rs) {
        ArrayList<StudentDTO> studentsList = new ArrayList<>();
        try{
        while (rs.next())
            {
                StudentDTO objStudent=new StudentDTO();                
                objStudent.setRegNo(rs.getString(1));
                objStudent.setName(rs.getString(2));
                objStudent.setFatherName(rs.getString(3));
                objStudent.setDob((rs.getDate(4)));
                objStudent.setCnic(rs.getString(5));
                objStudent.setPhoneNumber(rs.getString(6));
                objStudent.setUserEmail(rs.getString(7));
                studentsList.add(objStudent);
            }
        }catch (Exception e){
            
        }
        return studentsList;
    }
    
    ArrayList<TeacherDTO> getTeachers(ResultSet rs) {
        ArrayList<TeacherDTO> teacherList = new ArrayList<>();
        try{
        while (rs.next())
            {
                TeacherDTO objTeacher=new TeacherDTO();
                objTeacher.setId(rs.getInt(1));
                objTeacher.setName(rs.getString(2));
                objTeacher.setPhoneNumber(rs.getString(3));
                objTeacher.setEmail(rs.getString(4));
                
                teacherList.add(objTeacher);
            }
        }catch (Exception e){
        }
        return teacherList;
    }

    TeacherDTO getTeacher(ResultSet rs) {
        TeacherDTO teacher = new TeacherDTO();
        try{
        if (rs.next())
            {
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setPhoneNumber(rs.getString(3));
                teacher.setEmail(rs.getString(4));
            }
        }catch (Exception e){
        }
        return teacher;
    }

    CourseDTO getCourseById(ResultSet rs) {
    CourseDTO course = new CourseDTO();
        try{
        if (rs.next())
            {
                course.setCourseCode(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setCreditHours(rs.getInt(3));
            }
        }catch (Exception e){
        }
        return course;
    }

    ArrayList<TeacherCourseViewDTO> getAssignCourseTeacher(ResultSet rs) {
        ArrayList<TeacherCourseViewDTO> assignCourseList=new ArrayList<>();
        try{
        while (rs.next())
            {
                TeacherCourseViewDTO cf=new TeacherCourseViewDTO();
                
                cf.setTeacherName(rs.getString(2));
                cf.setCourseName(rs.getString(4));
                cf.setCreditHours(rs.getInt(5));
                assignCourseList.add(cf);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return assignCourseList;
    }

    ArrayList<CourseClassDTO> getClasses(ResultSet rs) {
       ArrayList<CourseClassDTO> classList=new ArrayList<>();
        try{
        while (rs.next())
            {
                CourseClassDTO c=new CourseClassDTO();
                c.setCourseCode(rs.getString(1));
                c.setCourseName(rs.getString(2));
                c.setFacultyId(rs.getInt(3));
                c.setClassId(rs.getString(4));
                
                classList.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return classList;
    }

    ArrayList<TeacherCourseViewDTO> getCoursesofTecher(ResultSet rs) {
        ArrayList<TeacherCourseViewDTO> courseList=new ArrayList<>();
        try{
        while (rs.next())
            {
                TeacherCourseViewDTO cf=new TeacherCourseViewDTO();
                cf.setCourseName(rs.getString(1));
                cf.setCourseCode(rs.getString(2));
                courseList.add(cf);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return courseList;
    
    }

    ArrayList<StudentDTO> getStudentList(ResultSet rs) {
       
    ArrayList<StudentDTO> studentsList = new ArrayList<>();
        try{
        while (rs.next())
            {
                StudentDTO objStudent=new StudentDTO();                
                objStudent.setName(rs.getString(1));
                objStudent.setRegNo(rs.getString(2));
                studentsList.add(objStudent);
            }
        }catch (Exception e){
            System.out.println("Error in mapping"+e.getMessage());
        }
        return studentsList;
    }

    StudentDTO getStudent(ResultSet rs) {
        StudentDTO objStudent = new StudentDTO();
        try{
        if (rs.next())
            {
                                
                objStudent.setRegNo(rs.getString(1));
                objStudent.setName(rs.getString(2));
                objStudent.setFatherName(rs.getString(3));
                objStudent.setDob((rs.getDate(4)));
                objStudent.setCnic(rs.getString(5));
                objStudent.setPhoneNumber(rs.getString(6));
                objStudent.setUserEmail(rs.getString(7));
            }
        }catch (Exception e){
        }
        return objStudent;
        
    }

}
