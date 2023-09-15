package com.nhnacademy.aiot;

public class Consumer implements Runnable {
    Thread thread;
    PCManager pcManager;

    public Consumer(PCManager pcManager) {
        this.thread = new Thread(this);
        this.pcManager = pcManager;

    }

    void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        // while (!thread.currentThread().isInterrupted()) {
        //     try {
        //         synchronized (pcManager) {
        //             pcManager.consume();
        //         }
        //         Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
        //     } catch (InterruptedException e) {
        //         thread.currentThread().interrupt();
        //     }
        // }
        try {
            pcManager.consume();
        } catch (InterruptedException e) {
            thread.currentThread().interrupt();
        }
    }

}
