package com.example.nosti.hat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nosti on 6/11/2016.
 */
public class GameSettings extends Activity{


    private SeekBar seekBarWords;
    private SeekBar seekBarTime;

    private TextView textViewWords;
    private TextView textViewTime;

    ArrayList<Integer> checkBoxIndexes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_settings);
        controlSeekbars();


        Button settingButton = (Button) findViewById(R.id.game_settings);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SeekBar seekBarWords = (SeekBar) findViewById(R.id.seekBar_words);
                SeekBar seekBarTime = (SeekBar) findViewById(R.id.seekBar_time);
                //Intent resultIntent = new Intent();

                checkBoxIndexes = new ArrayList<Integer>(Arrays.asList(R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4));
                ArrayList<Team> teams = new ArrayList<>();
                for (int i = 0; i < checkBoxIndexes.size(); i++){
                    CheckBox checkBox = (CheckBox) findViewById(checkBoxIndexes.get(i));
                    if (checkBox.isChecked())
                        teams.add(new Team((String)checkBox.getText()));
                }
                GameObject gameObject = new GameObject(
                        teams.size(),
                        seekBarTime.getProgress(),
                        seekBarWords.getProgress(),
                        teams);
                SharedObjects.setGame(gameObject);
                Intent startGame = new Intent(GameSettings.this, MainActivity.class);
                startActivity(startGame);
                //resultIntent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, gameObject);
                //setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }

    private void controlSeekbars(){
        seekBarWords = (SeekBar) findViewById(R.id.seekBar_words);
        seekBarTime = (SeekBar) findViewById(R.id.seekBar_time);
        textViewTime = (TextView) findViewById(R.id.game_time);
        textViewWords = (TextView) findViewById(R.id.count_words);
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
                textViewTime.setText("Seconds of the game : " + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
