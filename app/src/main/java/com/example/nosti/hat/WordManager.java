package com.example.nosti.hat;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
        List<WordUnit> ll = new ArrayList<>();
        ll = SharedObjects.getGame().getGameWords();
        for (WordUnit u: ll)
            Log.d("Main", "" + u.getWord() + " " + u.isGuessed());
        Log.d("Main", "nextInd " + this.currentIndex);
    }

    public String getCurrentWord(){
        if (this.currentIndex == -1)
            return null;
        return SharedObjects.getGame().getGameWords().get(this.currentIndex).getWord();
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }

    public void allUnGuessed(){
        for (WordUnit unit: SharedObjects.getGame().getGameWords())
            unit.setGuessed(false);
    }

}
