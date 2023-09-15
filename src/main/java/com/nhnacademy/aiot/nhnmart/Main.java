package com.nhnacademy.aiot.nhnmart;

import com.nhnacademy.aiot.nhnmart.threadlocal.SharedUserContext;

public class Main {
    public static void main(String[] args) {
        // Channel channel = new Channel(20);
        // WorkerPool workerPool = new WorkerPool(3, channel);
        // workerPool.start();

        // new Thread(new Client(channel)).start();
        // new Thread(new Client(channel)).start();
        // new Thread(new Client(channel)).start();
        
        SharedUserContext user1 = new SharedUserContext(1);
        SharedUserContext user2 = new SharedUserContext(2);

        new Thread(user1).start();
        new Thread(user2).start();
    }
}
