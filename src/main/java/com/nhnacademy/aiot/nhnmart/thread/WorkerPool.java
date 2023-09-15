package com.nhnacademy.aiot.nhnmart.thread;

import com.nhnacademy.aiot.nhnmart.mart.Employee;
import com.nhnacademy.aiot.nhnmart.mart.EmployeeGenerator;

public class WorkerPool {
    private final Worker[] workers;

    public WorkerPool(int poolSize,Channel channel) {
        this.workers=new Worker[poolSize];
        for(int i=0;i<poolSize;i++){
            Employee employee = EmployeeGenerator.getEmployeeGenerator().next();
            workers[i]=new Worker(channel, employee);
        }
    }

    public void start(){
        for(Worker worker: workers){
            new Thread(worker).start();
        }
    }
    
}
