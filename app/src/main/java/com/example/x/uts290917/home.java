package com.example.x.uts290917;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        font();

    }

    public void font(){

        TextView txt_in = (TextView) findViewById(R.id.tx_in);
        TextView txt_love = (TextView) findViewById(R.id.tx_love);
        TextView txt_sia = (TextView) findViewById(R.id.tx_sia);

        Typeface style = Typeface.createFromAsset(getAssets(), "indonesiana sketch book serif.ttf");

        txt_in.setTypeface(style);
        txt_love.setTypeface(style);
        txt_sia.setTypeface(style);
    }

    public void provinsi(View view) {
        startActivity(new Intent(this, provinsi.class));
    }

    public void kota(View view) {
        startActivity(new Intent(this, kota.class));
    }

    public void kuliner(View view) {
        startActivity(new Intent(this, kuliner.class));
    }

    public void wisata(View view) {
        startActivity(new Intent(this, wisata.class));
    }

    public void about(View view) {
        startActivity(new Intent(this, about.class));
    }

    public void profile(View view) {
        startActivity(new Intent(this, profile.class));
    }
}
