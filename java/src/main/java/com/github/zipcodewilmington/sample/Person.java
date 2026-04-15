package com.github.zipcodewilmington.sample;

public class Person {
    private String name;
    private int score;
    private int wins;
    private int losses;

    public Person(String name) {
        this.name = name;
        this.score = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses () {
        return losses;
    }

    public void addWin () {
        wins++;
        score++;
    }

    public void addLoss () {
        losses++;
        score--;
    }



}