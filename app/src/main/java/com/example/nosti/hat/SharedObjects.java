package com.example.nosti.hat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nosti on 6/13/2016.
 */
public class SharedObjects {
    public static final String TOUR_IS_FINISHED_EARLY = "Tour result";
    public static final int STATIC_INTEGER_TOUR = 111;
    public static final int REQUEST_CODE = 111;

    private static final String s = "I want to see Ireland";
    public static final List<String> all_words = new ArrayList<>(Arrays.asList(s.split("\\s+")));

    private static GameObject game;

    public static GameObject getGame() {
        return game;
    }
    public static void setGame(GameObject game) {
        SharedObjects.game = game;
    }
    /*{
        BufferedReader br = null;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("c:\\Users\\nosti\\Documents\\3\\Hat\\app\\src\\main\\res\\values\\wikiText.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }*/


}
