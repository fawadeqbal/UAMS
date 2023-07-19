/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author fawad
 */
public class StudentDTO {
    private String regNo;
    private String name;
    private String fatherName;
    private Date dob;
    private String cnic;
    private String phoneNumber;
    private String userEmail;
    
    public StudentDTO(){
        
    }

    public StudentDTO(String regNo, String name, String fatherName, Date dob, String cnic, String phoneNumber, String userEmail) {
        this.regNo = regNo;
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.cnic = cnic;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
}
