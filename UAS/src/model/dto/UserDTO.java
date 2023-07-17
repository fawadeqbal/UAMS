/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

/**
 *
 * @author fawad
 */
public class UserDTO {

    private String user_id;
    private String password;
    private String role;
    public UserDTO(){
        
    }
    public UserDTO(String username, String password,String role) {
        this.user_id = username;
        this.password = password;
        this.role=role;
    }

    public String getUserID() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String user_id) {
        this.user_id = user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
