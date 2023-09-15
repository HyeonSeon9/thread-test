package com.nhnacademy.aiot.nhnmart.coupon;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CouponGenerator implements Iterator<Coupon>{
    
    private static final int COUPON_MAX_SIZE=50;
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    private static final CouponGenerator INSTANCE = new CouponGenerator();

    private CouponGenerator(){
    }

    public static CouponGenerator getCouponGenerator(){
        return INSTANCE;
    }

    @Override
    public synchronized boolean hasNext() {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public synchronized Coupon next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return Coupon.ofDiscount(ID_GENERATOR.incrementAndGet(),10_000);
    }

    
}
