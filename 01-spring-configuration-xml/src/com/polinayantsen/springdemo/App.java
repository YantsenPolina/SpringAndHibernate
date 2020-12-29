package com.polinayantsen.springdemo;

public class App {

    public static void main(String[] args) {
        Coach coach = new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
