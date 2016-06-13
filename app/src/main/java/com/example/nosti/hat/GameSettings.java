package com.example.nosti.hat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by nosti on 6/11/2016.
 */
public class GameSettings extends Activity{

    private static String PUBLIC_STATIC_STRING_IDENTIFIER = "Public";

    private SeekBar seekBarWords;
    private SeekBar seekBarTime;

    private TextView textViewWords;
    private TextView textViewTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_settings);
        seekBarWords = (SeekBar) findViewById(R.id.seekBar_words);
        seekBarTime = (SeekBar) findViewById(R.id.seekBar_time);
        textViewWords = (TextView) findViewById(R.id.game_time);
        textViewTime= (TextView) findViewById(R.id.count_words);

        seekBarWords.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewWords.setText("Count of the words : " + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewTime.setText("Time of the game : " + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button settingButton = (Button) findViewById(R.id.game_settings);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeekBar seekBarWords = (SeekBar) findViewById(R.id.seekBar_words);
                SeekBar seekBarTime = (SeekBar) findViewById(R.id.seekBar_time);
                Intent resultIntent = new Intent();
                GameObject gameObject = new GameObject(
                        2,
                        seekBarTime.getProgress(),
                        seekBarWords.getProgress());
                resultIntent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, gameObject);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
