package common;

import java.util.Date;

public class ApplicationSession {
    public String UserName;
    public String role;
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
}
