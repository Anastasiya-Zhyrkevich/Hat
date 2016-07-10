package com.example.nosti.hat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
    private Button but;
    private Button finish_game;
    private String DEBUG_TAG = "Debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (Button) findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(MainActivity.this, Game.class);
                startActivityForResult(game, SharedObjects.REQUEST_CODE);
            }
        });

        finish_game = (Button) findViewById(R.id.finish_game);

        finish_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.d("Main", "onCreate");

        ListView lw = (ListView) findViewById(R.id.listView);
        //lw.setAdapter();                                        // strange    //TODO

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null)
            return;
        SharedObjects.getGame().nextCurrentTeam();
        boolean isFinishedTour = data.getBooleanExtra(SharedObjects.TOUR_IS_FINISHED_EARLY, false);
        Log.d("Main", "" + isFinishedTour);
        if (isFinishedTour){
            SharedObjects.getGame().nextTour();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Main", "onResume");
        showResults();
        GameObject game = SharedObjects.getGame();
        if (game.isStartTour() && game.isValidGame()) {
            startTour();
            SharedObjects.getGame().setStartTour(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void startTour(){
        WordManager wm = new WordManager();
        wm.allUnGuessed();
        Intent intent = new Intent(MainActivity.this, DecsTour.class);
        startActivity(intent);
    }

    private void showResults(){
        GameObject game = SharedObjects.getGame();
        Log.d("Main", game.toString());
    }



}
