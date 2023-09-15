package com.nhnacademy.aiot.nhnmart.thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Channel {

    private final Queue<Request> queue;
    private final int queueMaxSize;

    public Channel(int queueMaxSize) {
        this.queueMaxSize = queueMaxSize;
        this.queue = new LinkedBlockingQueue<>(queueMaxSize);
    }

    public synchronized Request takeRequest(){
        while(queue.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        notifyAll();
        return queue.poll();
    }

    public synchronized void addRequest(Request request) {
        while (queue.size() >= this.queueMaxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("add queue",e);
            }
        }
        queue.add(request);
        notifyAll();
    }


}
