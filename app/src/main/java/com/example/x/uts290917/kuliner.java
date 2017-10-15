package com.example.x.uts290917;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class kuliner extends AppCompatActivity {

    String[] list_kuliner = {
            "Bir Pletok",
            "Emping",
            "Gado-Gado",
            "Geplak",
            "Kerak Telor",
            "Ketoprak",
            "Kroket",
            "Nasi Uduk",
            "Onde-Onde",
            "Ongol-Ongol",
            "Pindang Serani",
            "Risoles",
            "Roti Buaya",
            "Semur Jengkol",
            "Soto Betawi"
    };
    Integer[] img_kuliner = {
            R.drawable.bir_pletok,
            R.drawable.emping,
            R.drawable.gado_gado,
            R.drawable.geplak_jakarta,
            R.drawable.kerak_telor,
            R.drawable.ketoprak,
            R.drawable.kroket,
            R.drawable.nasi_uduk,
            R.drawable.onde_onde,
            R.drawable.ongol_ongol,
            R.drawable.pindang_serani,
            R.drawable.risoles,
            R.drawable.roti_buaya,
            R.drawable.semur_jengkol,
            R.drawable.soto_betawi,
    };
    String[] link_kuliner = {
            "https://id.wikipedia.org/wiki/Bir_pletok",
            "https://id.wikipedia.org/wiki/Emping",
            "https://id.wikipedia.org/wiki/Gado-gado",
            "https://id.wikipedia.org/wiki/Geplak",
            "https://id.wikipedia.org/wiki/Kerak_Telor",
            "https://id.wikipedia.org/wiki/Ketoprak_(makanan)",
            "https://id.wikipedia.org/wiki/Kroket",
            "https://id.wikipedia.org/wiki/Nasi_Uduk",
            "https://id.wikipedia.org/wiki/Onde-onde",
            "https://id.wikipedia.org/wiki/Ongol-Ongol",
            "https://id.wikipedia.org/wiki/Pindang_Serani",
            "https://id.wikipedia.org/wiki/Risoles",
            "https://id.wikipedia.org/wiki/Roti_Buaya",
            "https://id.wikipedia.org/wiki/Semur_Jengkol",
            "https://id.wikipedia.org/wiki/Soto_Betawi"
    };
    AlertDialog.Builder alert_build;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        adapter_listview adp = new adapter_listview(this, list_kuliner, img_kuliner);
        ListView list_view = (ListView) findViewById(R.id.list_kuliner_xml);
        list_view.setAdapter(adp);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posisi, long l) {

                alert_build = new AlertDialog.Builder(kuliner.this);
                alert_build
                        .setMessage("Apakah Anda yakin memilih Makanan " + list_kuliner[posisi] + " sebagai pilihan Anda?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle datas = new Bundle();
                                datas.putString("judul", list_kuliner[posisi]);
                                datas.putInt("image", img_kuliner[posisi]);
                                datas.putString("link_url", link_kuliner[posisi]);
                                Intent send = new Intent(kuliner.this, details.class);
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
