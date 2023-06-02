/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.student;

import model.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fawad
 */
public class StudentModal {

    class Student {

        String name;
        String gender;
        int physics;
        int maths;
        int english;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n\t{\n");
            sb.append("\tname:").append(name);
            sb.append(",\n\tgender:").append(gender);
            sb.append(",\n\tphysics:").append(physics);
            sb.append(",\n\tmaths:").append(maths);
            sb.append(",\n\tenglish:").append(english);
            sb.append("\n\t"+'}'+"\n");
            return sb.toString();
        }
        
        public Student(String name, String gender, int physics, int maths, int english) {
            this.name = name;
            this.gender = gender;
            this.physics = physics;
            this.maths = maths;
            this.english = english;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }

        public int getMaths() {
            return maths;
        }

        public void setMaths(int maths) {
            this.maths = maths;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }
    }

    public ArrayList<Student> getStudentMarks() {
        ArrayList<Student> studentsList=new ArrayList<Student>();
        Connection connection = null;
        try {
            connection = Conn.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM student";
            statement = connection.prepareStatement(query);
            
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int physics = resultSet.getInt("physics");
                int maths = resultSet.getInt("maths");
                int english = resultSet.getInt("english");
                
                Student student=new Student(name,gender,physics,maths,english);
                studentsList.add(student);
                // You can store the retrieved values in variables or objects as per your requirement
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return studentsList;
    }

}
