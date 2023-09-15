package com.nhnacademy.aiot.nhnmart.thread;

import com.nhnacademy.aiot.nhnmart.coupon.CouponGenerator;
import com.nhnacademy.aiot.nhnmart.customer.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponRequest extends Request {

    private final Customer customer;



    public CouponRequest(Customer customer) {
        this.customer = customer;
    }



    @Override
    protected void execute() {
        if (CouponGenerator.getCouponGenerator().hasNext()) {
            customer.addCoupon(CouponGenerator.getCouponGenerator().next());
            log.info("thread-id:{}, customer-id:{}, coupon-id:{}", Thread.currentThread().getId(),
                    customer.getId(), customer.getCouponList().get(0).getId());

        } else {
            log.info("thread-id:{}, customer-id:{}, coupon-id:{}", Thread.currentThread().getId(),
                    customer.getId(), "empty");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("sleep",e);
        }
    }

}
