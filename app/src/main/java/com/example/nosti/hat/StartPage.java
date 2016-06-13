package com.example.nosti.hat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by nosti on 6/11/2016.
 */
public class StartPage extends AppCompatActivity {

    private GameObject gameObject;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        Button startButton = (Button) findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameObject = new GameObject();
                i = new Intent(getApplicationContext(), GameSettings.class);
                startActivity(i);
            }
        });
    }


}