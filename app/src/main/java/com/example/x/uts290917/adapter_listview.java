package com.example.x.uts290917;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
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

    adapter_listview(Activity kontek, String[] lists, Integer[] imgs) {

        super(kontek, R.layout.list, lists);

        this.kontek = kontek;
        this.list = lists;
        this.img = imgs;
    }

    @NonNull
    public View getView(int posisi, View views, @NonNull ViewGroup parent) {
        LayoutInflater layout = kontek.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View rowView = layout.inflate(R.layout.list, null, true);
        TextView judul = rowView.findViewById(R.id.judul);
        ImageView gambar = rowView.findViewById(R.id.gambar);
        judul.setText(list[posisi]);
        gambar.setImageResource(img[posisi]);

        return rowView;
    }
}
