package com.example.nosti.hat;

/**
 * Created by nosti on 6/13/2016.
 */
public class WordUnit {
    private String word;
    private boolean guessed;

    public WordUnit(String word, boolean guessed) {
        this.word = word;
        this.guessed = guessed;
    }

    public WordUnit(String word) {
        this.word = word;
        this.guessed = false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }



}
