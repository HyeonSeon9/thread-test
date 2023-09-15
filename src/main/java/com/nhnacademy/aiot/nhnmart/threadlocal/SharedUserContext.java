package com.nhnacademy.aiot.nhnmart.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedUserContext implements Runnable {

    private static final ThreadLocal<Session> userContext = new ThreadLocal<>();

    private final Integer userId;

    private final UserStore userStore = new UserStore();

    public SharedUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userStore.getUserNameByUserId(userId);
        userContext.set(new Session(userName));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
        log.info("session userId:{}, userName:{}",userId,userContext.get().getUserName());

    }


}
