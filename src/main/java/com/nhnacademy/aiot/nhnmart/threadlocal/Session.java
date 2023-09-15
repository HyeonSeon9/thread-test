package com.nhnacademy.aiot.nhnmart.threadlocal;

public class Session {
    
    private final String userName;


    public String getUserName() {
        return userName;
    }


    public Session(String userName) {
        this.userName = userName;
    }


}
