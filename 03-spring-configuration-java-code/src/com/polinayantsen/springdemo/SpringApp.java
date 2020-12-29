package com.polinayantsen.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println("email: " + swimCoach.getEmail());
        System.out.println("team: " + swimCoach.getTeam());

        context.close();
    }
}
