package com.nhnacademy.aiot.nhnmart.thread;

import com.nhnacademy.aiot.nhnmart.mart.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable{

    private final Channel channel;
    private final Employee employee;

    
    public Worker(Channel channel, Employee employee) {
        this.channel = channel;
        this.employee = employee;
    }


    @Override
    public void run() {
        while(true){
            Request request = this.channel.takeRequest();
            log.info("{}이 쿠폰을 발급했습니다.",employee.getName());
            request.execute();
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.error("sleep", e);
            }
        }
    }
    
}
