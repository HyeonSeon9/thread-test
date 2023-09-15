package com.nhnacademy.aiot.nhnmart.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private final Map<Integer,String> userMap = new HashMap<>();

    public UserStore(){
        userMap.put(1, "hyeonSeon9");
        userMap.put(2, "현성");
    }

    public String getUserNameByUserId(Integer userId){
        return userMap.get(userId).toString();
    }
    
}
