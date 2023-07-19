/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.dto.CourseDTO;
import java.sql.ResultSet;
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

}
