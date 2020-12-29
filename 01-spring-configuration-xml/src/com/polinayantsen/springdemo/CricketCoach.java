package com.polinayantsen.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String email;
    private String team;

    public CricketCoach() {
        System.out.println(">> CricketCoach: inside no-arg constructor.");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> CricketCoach: inside setter method - setFortuneService.");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println(">> CricketCoach: inside setter method - setEmail.");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println(">> CricketCoach: inside setter method - setTeam.");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "CricketCoach: Practice fast bowling for 15 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return "CricketCoach: " + fortuneService.getFortune();
    }
}
