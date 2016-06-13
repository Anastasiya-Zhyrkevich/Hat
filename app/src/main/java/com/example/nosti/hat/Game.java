package com.example.nosti.hat;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by nosti on 5/24/2016.
 */
public class Game extends Activity {
    private int timeOfGame;
    private TextView mTextField;
    private ProgressBar mProgressBar;
    private TextView word;

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
                mProgressBar.setProgress((int)(millisUntilFinished));

            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, timeOfGame);

        word = (TextView)findViewById(R.id.word);

        word.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeDown() {
                Log.d("Swipe", "Down");
                word.setText("Down");

            }

            @Override
            public void onSwipeUp() {
                Log.d("Swipe", "Up");
                word.setText("Up");
            }
        });


    }







}
