package com.example.x.uts290917;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class provinsi extends AppCompatActivity {

    String[] list_provinsi = {
            "Aceh",
            "Bali",
            "Banten",
            "Bengkulu",
            "Gorontalo",
            "Jakarta",
            "Jambi",
            "Jawa Barat",
            "Jawa Tengah",
            "Jawa Timur",
            "Kalimantan Barat",
            "Kalimantan Selatan",
            "Kalimantan Tengah",
            "Kalimantan Timur",
            "Kalimantan Utara"
    };
    Integer[] img_provinsi = {
            R.drawable.aceh,
            R.drawable.bali,
            R.drawable.banten,
            R.drawable.bengkulu,
            R.drawable.gorontalo,
            R.drawable.jakarta,
            R.drawable.jambi,
            R.drawable.jabar,
            R.drawable.jateng,
            R.drawable.jatim,
            R.drawable.kalbar,
            R.drawable.kalsel,
            R.drawable.kalteng,
            R.drawable.kaltim,
            R.drawable.kalut
    };
    String[] link_provinsi = {
            "https://id.wikipedia.org/wiki/Aceh",
            "https://id.wikipedia.org/wiki/Bali",
            "https://id.wikipedia.org/wiki/Banten",
            "https://id.wikipedia.org/wiki/Bengkulu",
            "https://id.wikipedia.org/wiki/Gorontalo",
            "https://id.wikipedia.org/wiki/Daerah_Khusus_Ibukota_Jakarta",
            "https://id.wikipedia.org/wiki/Jambi",
            "https://id.wikipedia.org/wiki/Jawa_Barat",
            "https://id.wikipedia.org/wiki/Jawa_Tengah",
            "https://id.wikipedia.org/wiki/Jawa_Timur",
            "https://id.wikipedia.org/wiki/Kalimantan_Barat",
            "https://id.wikipedia.org/wiki/Kalimantan_Selatan",
            "https://id.wikipedia.org/wiki/Kalimantan_Tengah",
            "https://id.wikipedia.org/wiki/Kalimantan_Timur",
            "https://id.wikipedia.org/wiki/Kalimantan_Utara"
    };
    AlertDialog.Builder alert_build;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);

        adapter_listview adp = new adapter_listview(this, list_provinsi, img_provinsi);
        ListView list_view = (ListView) findViewById(R.id.list_provinsi_xml);
        list_view.setAdapter(adp);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posisi, long l) {

                alert_build = new AlertDialog.Builder(provinsi.this);
                alert_build
                        .setMessage("Apakah Anda yakin memilih Provinsi " + list_provinsi[posisi] + " sebagai pilihan Anda?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle datas = new Bundle();
                                datas.putString("judul", list_provinsi[posisi]);
                                datas.putInt("image", img_provinsi[posisi]);
                                datas.putString("link_url", link_provinsi[posisi]);
                                Intent send = new Intent(provinsi.this, details.class);
                                send.putExtras(datas);
                                startActivity(send);
                            }
                        });
                alert = alert_build.create();
                alert.show();
            }
        });
    }
}
