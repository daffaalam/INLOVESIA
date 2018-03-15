package com.example.x.uts290917;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class details extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getIntent().getExtras().getString("judul"));

        TextView judul = (TextView) findViewById(R.id.judul_detail);
        ImageView gambar = (ImageView) findViewById(R.id.img_detail);
        WebView load_text = (WebView) findViewById(R.id.web_text);

        WebSettings web_set = load_text.getSettings();
        web_set.setJavaScriptEnabled(true);
        load_text.setWebViewClient(new WebViewClient());
        load_text.setBackgroundColor(Color.TRANSPARENT);

        Bundle get_bundle = getIntent().getExtras();

        assert get_bundle != null;
        judul.setText(get_bundle.getString("judul"));
        gambar.setImageResource(get_bundle.getInt("image"));
        load_text.loadUrl(get_bundle.getString("link_url"));

        Toast.makeText(details.this, "Anda memilih " + get_bundle.getString("judul"), Toast.LENGTH_SHORT).show();

    }
}
