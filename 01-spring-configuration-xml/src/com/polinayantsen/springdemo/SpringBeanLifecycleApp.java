package com.polinayantsen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-beanLifecycle.xml");

        Coach trackCoach = context.getBean("trackCoach", Coach.class);
        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);

        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(baseballCoach.getDailyWorkout());

        context.close();
    }
}
