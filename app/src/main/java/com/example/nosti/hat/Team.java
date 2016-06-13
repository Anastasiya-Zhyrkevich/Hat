package com.example.nosti.hat;

/**
 * Created by nosti on 6/13/2016.
 */
public class Team {
    private String name;
    private int scores;

    public Team(String name, int scores) {
        this.name = name;
        this.scores = scores;
    }

    public Team(String name) {
        this.name = name;
        this.scores = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public void incScores() {
        this.scores += 1;
    }
}
