package com.example.x.uts290917;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        font();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), home.class));
                finish();
            }
        }, 3000);
    }

    public void font() {

        TextView txt_in = (TextView) findViewById(R.id.tx_in);
        TextView txt_love = (TextView) findViewById(R.id.tx_love);
        TextView txt_sia = (TextView) findViewById(R.id.tx_sia);

        Typeface style = Typeface.createFromAsset(getAssets(), "indonesiana sketch book serif.ttf");

        txt_in.setTypeface(style);
        txt_love.setTypeface(style);
        txt_sia.setTypeface(style);

    }
}
