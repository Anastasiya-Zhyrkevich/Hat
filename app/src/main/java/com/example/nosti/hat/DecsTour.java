package com.example.nosti.hat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nosti on 6/17/2016.
 */
public class DecsTour extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_tour);


        TextView tv = (TextView) findViewById(R.id.desc_tour_text);
        int currentTour = SharedObjects.getGame().getCurrentTour();
        Log.d("Main", "" + currentTour + " size " + SharedObjects.getGame().getDescTours().size());
        if(tv == null)
            Log.d("Main", "nul TextView");
        Log.d("Main", "SET   "+ SharedObjects.getGame().getDescTours().get(currentTour));
        tv.setText(SharedObjects.getGame().getDescTours().get(currentTour));

        Button ok = (Button) findViewById(R.id.desc_tour_button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
