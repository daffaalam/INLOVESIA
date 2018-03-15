package com.example.x.uts290917;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

public class about extends AppCompatActivity {

    TextView vers;
    WebView tx_about;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About This App");

        String versi = BuildConfig.VERSION_NAME;
        String about = "<http><body style=\"text-align:justify;\">" + R.string.about_app + "</http></body>";

        font();

        vers = (TextView) findViewById(R.id.versi);

        vers.setText("version : " + versi);

        tx_about = (WebView) findViewById(R.id.txt_about);
        tx_about.setBackgroundColor(Color.TRANSPARENT);
        tx_about.loadData(about, "text/html", "UTF-8");

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
