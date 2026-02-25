package com.payment;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }

    @PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }
}