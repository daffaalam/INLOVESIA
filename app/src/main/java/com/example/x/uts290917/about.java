package com.example.x.uts290917;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class about extends AppCompatActivity {

    TextView vers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String versi = BuildConfig.VERSION_NAME;

        font();

        vers = (TextView) findViewById(R.id.versi);

        vers.setText("version : " + versi);

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
