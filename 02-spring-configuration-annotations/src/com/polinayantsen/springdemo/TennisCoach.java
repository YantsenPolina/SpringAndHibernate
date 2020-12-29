package com.polinayantsen.springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("tennisCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {

    // Field Injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Value("${tennis.email}")
    private String email;

    @Value("${tennis.team}")
    private String team;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside no-arg constructor.");
    }

//    // Constructor Injection with Qualifier
//    @Autowired
//    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService)
//        System.out.println(">> TennisCoach: inside constructor.");
//        this.fortuneService = fortuneService;
//    }

//    // Constructor Injection
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside constructor.");
//        this.fortuneService = fortuneService;
//    }

//    // Setter Injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside setter method - setFortuneService.");
//        this.fortuneService = fortuneService;
//    }

//    // Setter Injection
//    @Autowired
//    public void doSomeStuff(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside setter method - doSomeStuff.");
//        this.fortuneService = fortuneService;
//    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "TennisCoach: Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return "TennisCoach: " + fortuneService.getFortune();
    }

    @PostConstruct
    public void doStartupActions() {
        System.out.println(">> TennisCoach: inside method - doStartupActions.");
    }

//    @PreDestroy
//    public void doCleanupActions() {
//        System.out.println(">> TennisCoach: inside method - doCleanupActions.");
//    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">> TennisCoach: inside method - doCleanupActions.");
    }
}
