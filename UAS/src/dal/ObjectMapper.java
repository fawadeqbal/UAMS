/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.dto.CourseDTO;
import java.sql.ResultSet;
import model.dto.EnrollStudentsDTO;
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
                objCourse.setC_Id(rs.getInt(1));
                objCourse.setC_Name(rs.getString(2));
                                
                courselist.add(objCourse);
            }
        }catch (Exception e){
        }
        return courselist;
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
    
    ArrayList<EnrollStudentsDTO> getStudentsByCourse(ResultSet rs) {
        ArrayList<EnrollStudentsDTO> studentslist = new ArrayList<>();
        try{
        while (rs.next())
            {
                EnrollStudentsDTO objEnrollStudent=new EnrollStudentsDTO();                
                objEnrollStudent.setCourse_Id(rs.getInt(2));
                objEnrollStudent.setStudent_Id(rs.getInt(1));
                                
                studentslist.add(objEnrollStudent);
            }
        }catch (Exception e){
        }
        return studentslist;
    }
    

}
