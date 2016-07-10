package com.example.nosti.hat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by nosti on 5/24/2016.
 */
public class Game extends Activity {
    private int timeOfGame;
    private TextView mTextField;
    private ProgressBar mProgressBar;
    private TextView word;
    private WordManager wordManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        mTextField = (TextView) findViewById(R.id.textView2);
        timeOfGame = 10000;
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setMax(timeOfGame);


        new CountDownTimer(timeOfGame, 10) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                mProgressBar.setProgress((int) (millisUntilFinished));

            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finishEarly(false);
            }
        }, timeOfGame);

        word = (TextView) findViewById(R.id.word);
        wordManager = new WordManager();
        word.setText(wordManager.getCurrentWord());

        word.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeDown() {
                Log.d("Swipe", "Down");
                wordManager.next();
                if (wordManager.getCurrentWord() == null) {
                    Log.d("Main", "Null words");
                    finishEarly(true);
                }
                word.setText(wordManager.getCurrentWord());
            }

            @Override
            public void onSwipeUp() {
                Log.d("Swipe", "Up");
                GoodAnswerDelegate.goodAnswer(wordManager.getCurrentIndex());
                wordManager.next();
                if (wordManager.getCurrentWord() == null) {
                    Log.d("Main", "Null words");
                    finishEarly(true);
                }
                word.setText(wordManager.getCurrentWord());
            }
        });
    }


    private void finishEarly(boolean isEarly){
        Intent intent = new Intent();
        intent.putExtra(SharedObjects.TOUR_IS_FINISHED_EARLY, isEarly);
        setResult(RESULT_OK, intent);
        finish();
    }


}
