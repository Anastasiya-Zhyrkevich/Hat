package com.example.nosti.hat;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nosti on 5/25/2016.
 */

public class GameObject implements Serializable {
    private int countPlayers;
    private int timeOfGame;
    private int countWords;

    private List<Team> teams;
    private int currentTeam;

    private ArrayList<WordUnit> gameWords;

    public GameObject( int countPlayers, int timeOfGame, int countWords, List<Team> teams){
        this.countPlayers = countPlayers;
        this.timeOfGame = timeOfGame;
        //this.countWords = countWords;                 //TODO
        this.countWords = 3;
        this.gameWords = new ArrayList<WordUnit>(GenWord.genGameWords(SharedObjects.all_words, this.countWords));
        this.currentTeam = 0;
        this.teams = teams;
    }
    public GameObject() {
    }

    @Override
    public String toString()
    {
        return "" + countWords + " " + timeOfGame + " " + countPlayers;
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(int currentTeam) {
        this.currentTeam = currentTeam;
    }

}
