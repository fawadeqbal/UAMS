package model.employee;

import common.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conn;
import java.util.ArrayList;

/**
 *
 * @author fawad
 */
public class EmployeeModel {
    
    
    private ArrayList<Employee> employeeList=new ArrayList<>();
    public static void main(String[] args) {
        EmployeeModel m=new EmployeeModel();
        ArrayList<Employee> employeeList=m.getEmployees();
        System.out.println(employeeList);
    }

    public ArrayList<Employee> getEmployees() {
        // Establish a database connection
        Connection connection = null;
        try {
            connection = Conn.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
        }

        // Query the database to validate the username and password
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM employees";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            if(!resultSet.next()){
                System.out.println("Data not found.");
                
            } else{
                while (resultSet.next()) {
                Employee emp=new Employee();
                emp.setEmployeeId(resultSet.getInt("employee_id"));
                emp.setFirstName(resultSet.getString("first_name"));
                emp.setLastName(resultSet.getString("last_name"));
                emp.setJobTitle(resultSet.getString("job_title"));
                employeeList.add(emp);
                System.out.println(emp.toString());
            }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
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
        return this.employeeList;
        

    }

}
