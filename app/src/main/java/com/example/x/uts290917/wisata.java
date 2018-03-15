package com.example.x.uts290917;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class wisata extends AppCompatActivity {

    String[] list_wisata = {
            "Kebun Binatang Ragunan",
            "Museum Nasional 'Gajah'",
            "Taman Impian Jaya Ancol",
            "Taman Mini Indonesia Indah",
            "Museum Satria Mandala",
            "Gedung Joang '45",
            "Museum Bank Mandiri",
            "Museum Bank Indonesia",
            "Museum Sejarah Jakarta",
            "Monas",
            "Museum Tekstil",
            "Museum Wayang",
            "Pulau Tidung"
    };
    Integer[] img_wisata = {
            R.drawable.ragunan,
            R.drawable.museum_nasional_gajah,
            R.drawable.ancol,
            R.drawable.tmii,
            R.drawable.museum_satria_mandala,
            R.drawable.gedung_joang_45,
            R.drawable.museum_bank_mandiri,
            R.drawable.museum_bank_indonesia,
            R.drawable.museum_sejarah_jakarta,
            R.drawable.monas,
            R.drawable.museum_tekstil,
            R.drawable.museum_wayang,
            R.drawable.pulau_tidung
    };
    String[] link_wisata = {
            "https://id.wikipedia.org/wiki/Kebun_Binatang_Ragunan",
            "https://id.wikipedia.org/wiki/Museum_Gajah",
            "https://id.wikipedia.org/wiki/Taman_Impian_Jaya_Ancol",
            "https://id.wikipedia.org/wiki/Taman_Mini_Indonesia_Indah",
            "https://id.wikipedia.org/wiki/Museum_Satria_Mandala",
            "https://id.wikipedia.org/wiki/Gedung_Joang_%2745",
            "https://id.wikipedia.org/wiki/Museum_Bank_Mandiri",
            "https://id.wikipedia.org/wiki/Museum_Bank_Indonesia",
            "https://id.wikipedia.org/wiki/Museum_Sejarah_Jakarta",
            "https://id.wikipedia.org/wiki/Monas",
            "https://id.wikipedia.org/wiki/Museum_Tekstil",
            "https://id.wikipedia.org/wiki/Museum_Wayang",
            "https://id.wikipedia.org/wiki/Pulau_Tidung"
    };
    AlertDialog.Builder alert_build;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        adapter_listview adp = new adapter_listview(this, list_wisata, img_wisata);
        final ListView list_view = (ListView) findViewById(R.id.list_wisata_xml);
        list_view.setAdapter(adp);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posisi, long l) {

                alert_build = new AlertDialog.Builder(wisata.this);
                alert_build
                        .setMessage("Apakah Anda yakin memilih Wisata " + list_wisata[posisi] + " sebagai pilihan Anda?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle datas = new Bundle();
                                datas.putString("judul", list_wisata[posisi]);
                                datas.putInt("image", img_wisata[posisi]);
                                datas.putString("link_url", link_wisata[posisi]);
                                Intent send = new Intent(wisata.this, details.class);
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
