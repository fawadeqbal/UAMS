/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author fawad
 */


import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private Faculty faculty;
    private ArrayList<Student> students;

    public Course(String courseCode, String courseName, Faculty faculty) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.faculty = faculty;
        this.students = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}

