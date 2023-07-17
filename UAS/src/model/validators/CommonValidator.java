
package model.validators;

import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.UserDTO;

public class CommonValidator {

    public static void validateUser(UserDTO objUser, Response objResponse) {
        isValidUserID(objUser.getUserID(), objResponse);
        isValidPassword(objUser.getPassword(), objResponse);
        
    }

    private static void isValidUserID(String usernameToValidate, Response objResponse) {
        if(usernameToValidate == null || usernameToValidate.length() < 3){
            objResponse.messagesList.add(new Message("user_id is not valid, Provide valid user_id with at least 3 characters.",MessageType.Error));
        }
        
    }
    private static void isValidPassword(String passwordToValidate, Response objResponse) {
        if(passwordToValidate == null || passwordToValidate.length() < 3){
            objResponse.messagesList.add(new Message("password is not valid, Provide valid password with at least 3 characters.",MessageType.Error));
        }
        
    }
}
