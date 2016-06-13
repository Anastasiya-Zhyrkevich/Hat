package com.example.nosti.hat;

import java.io.Serializable;

/**
 * Created by nosti on 5/25/2016.
 */

public class GameObject implements Serializable {
    private int countPlayers;
    private int timeOfGame;
    private int countWords;

    public GameObject( int countPlayers, int timeOfGame, int countWords){
        this.countPlayers = countPlayers;
        this.timeOfGame = timeOfGame;
        this.countWords = countWords;
    }
    public GameObject() {
    }
    @Override
    public String toString()
    {
        return "" + countWords + " " + timeOfGame + " " + countPlayers;
    }






}
