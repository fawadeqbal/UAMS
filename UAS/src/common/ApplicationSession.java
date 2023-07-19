package common;

import java.util.Date;
import model.dto.UserDTO;

public class ApplicationSession {
    private UserDTO user;
    private Date sessionStartTime;

    public boolean isSessionExpired() {
        if (sessionStartTime == null) {
            return true;    
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        long sessionDurationMillis = 20*60 * 1000; // 20 minute in milliseconds
        long sessionEndTimeMillis = sessionStartTime.getTime() + sessionDurationMillis;
        
        return currentTimeMillis > sessionEndTimeMillis;
    }
    public void startSession() {
        
        sessionStartTime = new Date();
        System.out.println("Session Started");
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
