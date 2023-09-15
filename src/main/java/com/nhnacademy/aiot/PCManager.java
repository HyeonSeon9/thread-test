package com.nhnacademy.aiot;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PCManager {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int bufferSize;

    public PCManager(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void produce() throws InterruptedException {
        int data = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() >= bufferSize) {
                    wait();
                }

                buffer.add(++data);
                log.info("생산자 데이터 생성 : " + data);
                notifyAll();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                log.info("소비자 소비 : " + buffer.remove());
                notifyAll();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PCManager pcManager = new PCManager(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcManager.produce();
                } catch (InterruptedException e) {
                    log.error("interruptedException", e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pcManager.consume();
                } catch (InterruptedException e) {
                    log.error("interruptedException", e);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
