package com.polinayantsen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach_1 = context.getBean("tennisCoach", Coach.class);
        Coach tennisCoach_2 = context.getBean("tennisCoach", Coach.class);

        boolean result = tennisCoach_1 == tennisCoach_2;
        System.out.println("Pointing to the same object: " + result);
        System.out.println("Memory location for the tennisCoach_1: " + tennisCoach_1);
        System.out.println("Memory location for the tennisCoach_2: " + tennisCoach_2);

        context.close();
    }
}
