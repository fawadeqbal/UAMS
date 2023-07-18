/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.dto.CourseDTO;
import java.sql.ResultSet;
import model.dto.ClassDTO;
import model.dto.StudentDTO;
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
    
    StudentDTO getStudent(ResultSet rs) {
        StudentDTO objCourse=new StudentDTO(); 
        try{
        if (rs.next())
            {
                               
                objCourse.setS_Id(rs.getInt(1));
                objCourse.setF_name(rs.getString(2));
                objCourse.setL_name(rs.getString(3));
               
            }
        }catch (Exception e){
        }
        return objCourse;
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
