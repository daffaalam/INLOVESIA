package com.example.x.uts290917;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView judul = (TextView) findViewById(R.id.judul_detail);
        ImageView gambar = (ImageView) findViewById(R.id.img_detail);
        WebView load_text = (WebView) findViewById(R.id.web_text);

        WebSettings web_set = load_text.getSettings();
        web_set.setJavaScriptEnabled(true);
        load_text.setWebViewClient(new WebViewClient());

        Bundle get_bundle = getIntent().getExtras();
        judul.setText(get_bundle.getString("judul"));
        gambar.setImageResource(get_bundle.getInt("image"));
        load_text.loadUrl(get_bundle.getString("link_url"));

        Toast.makeText(details.this, "Anda memilih " + get_bundle.getString("judul"), Toast.LENGTH_SHORT).show();

    }
}
