package com.polinayantsen.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    public BaseballCoach() {
        System.out.println(">> BaseballCoach: inside no-arg constructor.");
    }

    public BaseballCoach(FortuneService fortuneService) {
        System.out.println(">> BaseballCoach: inside constructor.");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "BaseballCoach: Spend 30 minutes on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        return "BaseballCoach: " + fortuneService.getFortune();
    }

    public void doStartupActions() {
        System.out.println(">> BaseballCoach: inside method - doStartupActions.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">> BaseballCoach: inside method - doCleanupActions.");
    }
}
