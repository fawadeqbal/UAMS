package common;

import java.util.Date;

public class ApplicationSession {
    private String UserName;
    private String role;
    private Date sessionStartTime;

    public boolean isSessionExpired() {
        if (sessionStartTime == null) {
            return true;    
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        long sessionDurationMillis = 60 * 1000; // 20 minute in milliseconds
        long sessionEndTimeMillis = sessionStartTime.getTime() + sessionDurationMillis;
        
        return currentTimeMillis > sessionEndTimeMillis;
    }
    public void startSession() {
        
        sessionStartTime = new Date();
        System.out.println("Session Started");
    }

    public String getUserName() {
        return UserName;
    }

    public String getRole() {
        return role;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
