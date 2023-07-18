/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

/**
 *
 * @author fawad
 */
public class CourseDTO {
    private String courseCode;
    private String courseName;
    private int creditHours;
    public CourseDTO(){
        
    }
    public CourseDTO(String courseCode, String courseName, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }
    

    public int getC_credit_hours() {
        return creditHours;
    }

    public void setC_credit_hours(int c_credit_hours) {
        this.creditHours = c_credit_hours;
    }

    public String getC_Id() {
        return courseCode;
    }

    public void setC_Id(String c_Id) {
        this.courseCode = c_Id;
    }

    public String getC_Name() {
        return courseName;
    }

    public void setC_Name(String c_Name) {
        this.courseName = c_Name;
    }

    
    
}
