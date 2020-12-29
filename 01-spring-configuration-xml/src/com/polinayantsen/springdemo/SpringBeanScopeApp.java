package com.polinayantsen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-beanScope.xml");

        Coach baseballCoach_1 = context.getBean("baseballCoach", Coach.class);
        Coach baseballCoach_2 = context.getBean("baseballCoach", Coach.class);

        boolean result = baseballCoach_1 == baseballCoach_2;
        System.out.println("Pointing to the same object: " + result);
        System.out.println("Memory location for the baseballCoach_1: " + baseballCoach_1);
        System.out.println("Memory location for the baseballCoach_2: " + baseballCoach_2);

        context.close();
    }
}
