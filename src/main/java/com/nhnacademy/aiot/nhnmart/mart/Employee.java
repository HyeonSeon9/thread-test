package com.nhnacademy.aiot.nhnmart.mart;

import java.util.concurrent.ThreadLocalRandom;

public class Employee implements Runnable {

    private final long id;
    private final String name;
    private Mart mart;
    private Thread thread;

    private Employee(long id, String name) {
        this.id = id;
        this.name = name;
        this.thread = new Thread(this, name + "-" + id);
    }

    public static Employee of(long id, String name) {
        return new Employee(id, name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            mart.employee();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {


        return "{id=" + getId() + ", " + "name=\'" + getName() + "\'" + "}";

    }



}
