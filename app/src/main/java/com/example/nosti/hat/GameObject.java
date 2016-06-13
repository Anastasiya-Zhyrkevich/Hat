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

    private ArrayList<WordUnit> gameWords;

    public GameObject( int countPlayers, int timeOfGame, int countWords){
        this.countPlayers = countPlayers;
        this.timeOfGame = timeOfGame;
        //this.countWords = countWords;                 //TODO
        this.countWords = 3;
        this.gameWords = new ArrayList<WordUnit>(GenWord.genGameWords(SharedObjects.all_words, this.countWords));
        Log.d("Game", this.gameWords.get(0).getWord());
        Log.d("Game", this.gameWords.get(1).getWord());
        Log.d("Game", this.gameWords.get(2).getWord());
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



}
