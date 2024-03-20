package com.example.springcoredemo.common;

public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Cricket Coach...!!!";
    }
}
