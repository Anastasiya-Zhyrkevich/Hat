package com.example.nosti.hat;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by nosti on 5/25/2016.
 */
public class GenWord {

    static public int genIndex(List<WordUnit> wordUnitArrayList){
        List<Integer> indexes = new ArrayList<>(wordUnitArrayList.size());
        int ind = 0;
        for (int i = 0; i< wordUnitArrayList.size(); i++)
        {
            if (!wordUnitArrayList.get(i).isGuessed()) {
                indexes.add(ind, i);
                ind++;
            }
        }
        if (ind == 0)
            return -1;
        int randomIndex = (new Random()).nextInt(ind);
        return indexes.get(randomIndex);
    }

    static public List<WordUnit> genGameWords(List<String> words, int count){
        List <String> local_words = new ArrayList<>(words);
        Log.d("Words", "" + local_words.size());
        Log.d("Words", "" + count);
        Collections.shuffle(local_words);
        List<WordUnit> wordsForGame = new ArrayList<>(count);
        for (int i =0; i< count; i++){
            wordsForGame.add(i, new WordUnit(local_words.get(i)));
        }
        return wordsForGame;
    }
}
