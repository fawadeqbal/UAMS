/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import common.UserDTO;
import model.autheticate.Authenticate;

/**
 *
 * @author fawad
 */
public class AuthController {
    
    public static boolean authenticate(UserDTO user){
        Authenticate auth=new Authenticate();
        return auth.authenticate(user);
    }
}
