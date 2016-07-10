package com.example.nosti.hat;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nosti on 5/25/2016.
 */

public class GameObject implements Serializable {
    private int countPlayers;
    private int timeOfGame;
    private int countWords;

    private int countOfTours;
    private ArrayList<String> descTours;
    private int currentTour;

    private boolean validGame;
    private boolean startTour;

    private ArrayList<Team> teams;
    private int currentTeam;

    private ArrayList<WordUnit> gameWords;

    public GameObject( int countPlayers, int timeOfGame, int countWords, ArrayList<Team> teams){
        this.countPlayers = countPlayers;
        this.timeOfGame = timeOfGame;
        //this.countWords = countWords;                 //TODO
        this.countWords = 3;
        this.gameWords = new ArrayList<WordUnit>(GenWord.genGameWords(SharedObjects.all_words, this.countWords));
        this.currentTeam = 0;
        this.teams = teams;
        this.countOfTours = 3;
        this.currentTour = 0;
        this.descTours = new ArrayList<>(Arrays.asList("Words only", "Show only", "1 word"));
        for (String u: descTours){
            Log.d("Main", u);
        }
        setStartTour(true);
        this.validGame = true;
    }

    public GameObject() {
    }

    @Override
    public String toString()
    {
        String res = "";
        for(Team team: teams){
            res += team.getName() + " " + team.getScores() + "; ";
        }
        return res;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public void setCountPlayers(int countPlayers) {
        this.countPlayers = countPlayers;
    }

    public int getTimeOfGame() {
        return timeOfGame;
    }

    public void setTimeOfGame(int timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

    public int getCountWords() {
        return countWords;
    }

    public void setCountWords(int countWords) {
        this.countWords = countWords;
    }

    public List<WordUnit> getGameWords() {
        return gameWords;
    }

    public void setGameWords(ArrayList<WordUnit> gameWords) {
        this.gameWords = gameWords;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public int getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(int currentTeam) {
        this.currentTeam = currentTeam;
    }

    public void nextCurrentTeam(){
        this.currentTeam += 1;
        this.currentTeam %= this.countPlayers;
    }

    public int getCountOfTours() {
        return countOfTours;
    }

    public void setCountOfTours(int countOfTours) {
        this.countOfTours = countOfTours;
    }

    public ArrayList<String> getDescTours() {
        return descTours;
    }

    public void setDescTours(ArrayList<String> descTours) {
        this.descTours = descTours;
    }

    public int getCurrentTour() {
        return currentTour;
    }

    public void setCurrentTour(int currentTour) {
        this.currentTour = currentTour;
    }

    public void nextTour(){
        this.currentTour += 1;
        if (currentTour == countOfTours)
            validGame = false;
    }

    public boolean isValidGame() {
        return validGame;
    }

    public void setValidGame(boolean validGame) {
        this.validGame = validGame;
    }

    public boolean isStartTour() {
        return startTour;
    }

    public void setStartTour(boolean startTour) {
        this.startTour = startTour;
        if (startTour == true){
            currentTeam = 0;
        }
    }


}

