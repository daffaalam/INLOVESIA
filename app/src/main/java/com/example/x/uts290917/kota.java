package com.example.x.uts290917;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class kota extends AppCompatActivity {


    String[] list_kota = {
            "Cilegon",
            "Serang",
            "Tangerang Selatan",
            "Tangerang",
            "Bandung",
            "Bekasi",
            "Bogor",
            "Cimahi",
            "Cirebon",
            "Depok",
            "Sukabumi",
            "Tasikmalaya"
    };
    Integer[] img_kota = {
            R.drawable.kota_cilegon,
            R.drawable.kota_serang,
            R.drawable.kota_tangsel,
            R.drawable.kota_tangerang,
            R.drawable.kota_bandung,
            R.drawable.kota_bekasi,
            R.drawable.kota_bogor,
            R.drawable.kota_cimahi,
            R.drawable.kota_cirebon,
            R.drawable.kota_depok,
            R.drawable.kota_sukabumi,
            R.drawable.kota_tasikmalaya
    };
    String[] link_kota = {
            "https://id.wikipedia.org/wiki/Kota_Cilegon",
            "https://id.wikipedia.org/wiki/Kota_Serang",
            "https://id.wikipedia.org/wiki/Kota_Tangerang_Selatan",
            "https://id.wikipedia.org/wiki/Kota_Tangerang",
            "https://id.wikipedia.org/wiki/Kota_Bandung",
            "https://id.wikipedia.org/wiki/Kota_Bekasi",
            "https://id.wikipedia.org/wiki/Kota_Bogor",
            "https://id.wikipedia.org/wiki/Kota_Cimahi",
            "https://id.wikipedia.org/wiki/Kota_Cirebon",
            "https://id.wikipedia.org/wiki/Kota_Depok",
            "https://id.wikipedia.org/wiki/Kota_Sukabumi",
            "https://id.wikipedia.org/wiki/Kota_Tasikmalaya"
    };
    AlertDialog.Builder alert_build;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota);

        adapter_listview adp = new adapter_listview(this, list_kota, img_kota);
        ListView list_view = (ListView) findViewById(R.id.list_kota_xml);
        list_view.setAdapter(adp);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posisi, long l) {

                alert_build = new AlertDialog.Builder(kota.this);
                alert_build
                        .setMessage("Apakah Anda yakin memilih Kota " + list_kota[posisi] + " sebagai pilihan Anda?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle datas = new Bundle();
                                datas.putString("judul", list_kota[posisi]);
                                datas.putInt("image", img_kota[posisi]);
                                datas.putString("link_url", link_kota[posisi]);
                                Intent send = new Intent(kota.this, details.class);
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
