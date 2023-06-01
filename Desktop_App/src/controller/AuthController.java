/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import common.User;
import modal.autheticate.Authenticate;

/**
 *
 * @author fawad
 */
public class AuthController {
    
    public static boolean authenticate(String username,String password){
        
        User user=new User(username,password);
        
        return Authenticate.authUser(user);
    }
}
