package com.polinayantsen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
        TrackCoach trackCoach = context.getBean("trackCoach", TrackCoach.class);
        CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(baseballCoach.getDailyFortune());

        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(trackCoach.getEmail());
        System.out.println(trackCoach.getTeam());

        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getEmail());
        System.out.println(cricketCoach.getTeam());

        context.close();
    }
}
