/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.dto.CourseDTO;
import java.sql.ResultSet;
import java.util.Date;
import model.dto.ClassDTO;
import model.dto.StudentDTO;
import model.dto.UserDTO;
/**
 *
 * @author fawad
 */
public class ObjectMapper {
    
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
    
    ArrayList<ClassDTO> getClasses(ResultSet rs) {
        ArrayList<ClassDTO> classlist = new ArrayList<>();
        try{
        while (rs.next())
            {
                ClassDTO objClass=new ClassDTO();                
                objClass.setClass_id(rs.getString(1));
                objClass.setEnroll(rs.getInt(6));
                objClass.setStart_time(rs.getString(4));
                objClass.setEnd_time(rs.getString(5));
                classlist.add(objClass);
            }
        }catch (Exception e){
            System.out.println("Error in mapper");
        }
        return classlist;
    }
    
    
    ArrayList<Object> getStudentsByCourse(ResultSet rs) {
        ArrayList<Object> studentslist = new ArrayList<>();
        try{
        while (rs.next())
            {
                Object objEnrollStudent=new Object();                
//                objEnrollStudent.setCourse_Id(rs.getInt(2));
//                objEnrollStudent.setStudent_Id(rs.getInt(1));
                                
                studentslist.add(objEnrollStudent);
            }
        }catch (Exception e){
        }
        return studentslist;
    }
    

}
