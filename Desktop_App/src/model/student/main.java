package model.student;

import java.util.ArrayList;
import model.student.StudentModal.Student;

public class main {
    public static void main(String[] args) {
        ArrayList<Student> studentList=new StudentModal().getStudentMarks();
        System.out.println(studentList);
    }  
}
