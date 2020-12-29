package com.polinayantsen.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    private String email;
    private String team;

    public TrackCoach() {
        System.out.println(">> TrackCoach: inside no-arg constructor.");
    }

    public TrackCoach(FortuneService fortuneService) {
        System.out.println(">> TrackCoach: inside constructor.");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println(">> TrackCoach: inside setter method - setEmail.");
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println(">> TrackCoach: inside setter method - setTeam.");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "TrackCoach: Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "TrackCoach: " + fortuneService.getFortune();
    }

    // add an init method
    public void doStartupActions() {
        System.out.println(">> TrackCoach: inside method - doStartupActions.");
    }

    // add a destroy method
    public void doCleanupActions() {
        System.out.println(">> TrackCoach: inside method - doCleanupActions.");
    }
}
