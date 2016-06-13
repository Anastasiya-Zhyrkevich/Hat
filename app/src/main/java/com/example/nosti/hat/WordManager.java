package com.example.nosti.hat;

/**
 * Created by nosti on 6/13/2016.
 */
public class WordManager {
    private int currentIndex;

    public WordManager() {
        next();
    }

    public void next(){
        this.currentIndex = GenWord.genIndex(SharedObjects.getGame().getGameWords());
    }

    public String getCurrentWord(){
        return SharedObjects.getGame().getGameWords().get(this.currentIndex).getWord();
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }
}
