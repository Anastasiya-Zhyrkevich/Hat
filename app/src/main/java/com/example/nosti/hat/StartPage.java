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
    private final static int STATIC_INTEGER_VALUE = 0;
    private static String PUBLIC_STATIC_STRING_IDENTIFIER = "Public";

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
                startActivityForResult(i, STATIC_INTEGER_VALUE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (STATIC_INTEGER_VALUE) : {
                if (resultCode == Activity.RESULT_OK) {
                    gameObject = (GameObject) data.getSerializableExtra(PUBLIC_STATIC_STRING_IDENTIFIER);
                    Log.d("Start", gameObject.toString());
                    // TODO Update your TextView.
                }
                break;
            }
        }
    }
}