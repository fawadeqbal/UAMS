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
    private String c_Id;
    private String c_Name;
    private int c_credit_hours;
    public CourseDTO(){
        
    }
    public CourseDTO(String c_Id, String c_Name, int c_credit_hours) {
        this.c_Id = c_Id;
        this.c_Name = c_Name;
        this.c_credit_hours = c_credit_hours;
    }
    

    public int getC_credit_hours() {
        return c_credit_hours;
    }

    public void setC_credit_hours(int c_credit_hours) {
        this.c_credit_hours = c_credit_hours;
    }

    public String getC_Id() {
        return c_Id;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    
    
}
