package com.example.x.uts290917;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adapter_listview extends ArrayAdapter<String> {

    private final Activity kontek;
    private final String[] list;
    private final Integer[] img;

    public adapter_listview(Activity kontek, String[] lists, Integer[] imgs){

        super(kontek, R.layout.list, lists);

        this.kontek = kontek;
        this.list = lists;
        this.img = imgs;
    }

    public View getView(int posisi, View views, ViewGroup parent){
        LayoutInflater layout = kontek.getLayoutInflater();
        View rowView = layout.inflate(R.layout.list, null, true);
        TextView judul = (TextView) rowView.findViewById(R.id.judul);
        ImageView gambar = (ImageView) rowView.findViewById(R.id.gambar);
        judul.setText(list[posisi]);
        gambar.setImageResource(img[posisi]);

        return rowView;
    }
}
