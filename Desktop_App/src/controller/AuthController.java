
package controller;
import common.UserDTO;
import model.autheticate.Authenticate;


public class AuthController {
    
    public static boolean authenticate(UserDTO user){
        Authenticate auth=new Authenticate();
        return auth.authenticate(user);
    }
}
