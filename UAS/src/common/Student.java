/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author fawad
 */
public class Student {
    private String name;
    private String regNo;
    private boolean attendance;

    public Student(String name, String regNo, boolean attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public boolean isAttendance() {
        return attendance;
    }
}
