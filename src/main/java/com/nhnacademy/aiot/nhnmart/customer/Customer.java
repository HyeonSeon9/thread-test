package com.nhnacademy.aiot.nhnmart.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import com.nhnacademy.aiot.nhnmart.coupon.Coupon;
import com.nhnacademy.aiot.nhnmart.mart.Mart;

public class Customer implements Runnable {



    private final long id;
    private final String name;
    private int money;
    private Mart mart;
    private final List<Coupon> couponList = new ArrayList<>();


    private Thread thread;


    

    private Customer(long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.thread = new Thread(this, name + "-" + id);
    }

    public static Customer of(long id, String name) {
        return new Customer(id, name, 100_0000);
    }

    public void addCoupon(Coupon coupon) {
        couponList.add(coupon);
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getMoney() {
        return money;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public Thread getThread() {
        return this.thread;
    }

    void start() {
        this.thread.start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            mart.customer();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

    @Override
    public String toString() {

        return "{id=" + getId() + ", " + "name=\'" + getName() + "\', " + "money=" + getMoney() + ", "
                + "couponList=" + getCouponList()+"}";
    }
}
