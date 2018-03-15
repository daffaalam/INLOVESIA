package com.example.x.uts290917;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("About Developer");
        getSupportActionBar().setSubtitle("Abiyyu Daffa\' Alam");

    }

//    public void popup(){
//        AlertDialog.Builder alrtbuild = new AlertDialog.Builder(profile.this);
//        alrtbuild
//                .setMessage("Klik data untuk mengetahui lebih lanjut.")
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//        AlertDialog alrt = alrtbuild.create();
//        alrt.show();
//    }

    public void send_mail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "smk_daffa@rbs.sch.id", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback INLOVESIA (build 171002)");
        startActivity(Intent.createChooser(emailIntent, "Feedback"));
    }

    public void maps(View view) {
        Uri url_map = Uri.parse("https://goo.gl/maps/gdJsH8tKQu42");
        Intent open_map = new Intent(Intent.ACTION_VIEW, url_map);
        startActivity(open_map);
    }

    public void call(View view) {
        Uri number = Uri.parse("tel:082299368783");
        Intent calls = new Intent(Intent.ACTION_DIAL, number);
        startActivity(calls);
    }
}
