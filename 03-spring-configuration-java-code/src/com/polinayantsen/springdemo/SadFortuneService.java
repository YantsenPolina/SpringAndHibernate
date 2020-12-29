package com.polinayantsen.springdemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "SadFortuneService: Today is a sad day!";
    }
}
