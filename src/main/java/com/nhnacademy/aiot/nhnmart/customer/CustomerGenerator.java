package com.nhnacademy.aiot.nhnmart.customer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerGenerator implements Iterator<Customer> {

    private static final CustomerGenerator INSTANCE = new CustomerGenerator();

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private CustomerGenerator(){

    }

    public static CustomerGenerator getCustomerGenerator() {
        return INSTANCE;
    }


    // public static Customer getCustomer(){
    // return Customer.of(ID_GENERATOR.incrementAndGet(),"고객"+ID_GENERATOR.get());
    // }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Customer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Customer.of(ID_GENERATOR.incrementAndGet(), "고객" + ID_GENERATOR.get());
    }
}
