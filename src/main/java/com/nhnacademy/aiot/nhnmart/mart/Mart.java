package com.nhnacademy.aiot.nhnmart.mart;

import java.util.LinkedList;
import com.nhnacademy.aiot.nhnmart.coupon.Coupon;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mart {
    private final LinkedList<Coupon> couponList = new LinkedList<>();
    private final long couponMax;

    public Mart() {
        this.couponMax = 50;
    }

    public void customer() throws InterruptedException {
        synchronized (this) {
            while (couponList.isEmpty()) {
                wait();
            }
            couponList.remove();
            log.info("쿠폰 발급받음");
            notifyAll();
        }
    }


    public void employee() throws InterruptedException {

        synchronized (this) {
            while (couponList.size() >= couponMax) {
                wait();
            }
            log.info("쿠폰생성");
            notifyAll();
        }

    }
}
