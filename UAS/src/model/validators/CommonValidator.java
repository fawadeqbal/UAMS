
package model.validators;

import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.UserDTO;

public class CommonValidator {

    public static void validateUser(UserDTO objUser, Response objResponse) {
        isValidUsername(objUser.getUsername(), objResponse);
        
    }

    private static void isValidUsername(String usernameToValidate, Response objResponse) {
        if(usernameToValidate == null || usernameToValidate.length() < 3){
            objResponse.messagesList.add(new Message("Username is not valid, Provide valid username with at least 3 characters.",MessageType.Error));
        }
        
    }
    
    
    
}
