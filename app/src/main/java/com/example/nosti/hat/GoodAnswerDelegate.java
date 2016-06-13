package com.example.nosti.hat;

/**
 * Created by nosti on 6/13/2016.
 */
public class GoodAnswerDelegate {
    private static void goodAnswer(int wordIndex, int teamIndex){
        SharedObjects.getGame().getGameWords().get(wordIndex).setGuessed(true);
        SharedObjects.getGame().getTeams().get(teamIndex).incScores();
    }
    public static void goodAnswer(int wordIndex){
       goodAnswer(wordIndex, SharedObjects.getGame().getCurrentTeam());
    }
}
