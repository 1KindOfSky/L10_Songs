package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context partent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource,ArrayList<Song> objects) {
        super(context,resource,objects);

        partent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                partent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.TVSongName);
        TextView tvYear= rowView.findViewById(R.id.TVYear);
        TextView tvStar = rowView.findViewById(R.id.TVStars);
        TextView tvSinger = rowView.findViewById(R.id.TVSinger);

        Song currentVersion = versionList.get(position);

        tvName.setText(currentVersion.getTitle());
        tvName.setTextColor(Color.BLUE);
        tvYear.setText(currentVersion.toStringYear());
        tvStar.setText(currentVersion.toString());
        tvStar.setTextColor( Color.RED);
        tvSinger.setText(currentVersion.getSingers());
        tvSinger.setTextColor(Color.CYAN);

        return rowView;
    }
}


