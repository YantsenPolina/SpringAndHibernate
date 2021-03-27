package com.polinayantsen.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean throwException) {
        if (throwException) {
            throw new RuntimeException("Error in getting fortune");
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic";
    }
}
