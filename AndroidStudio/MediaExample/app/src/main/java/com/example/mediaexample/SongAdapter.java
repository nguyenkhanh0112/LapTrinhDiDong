package com.example.mediaexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> arrayListSong ;
    private LayoutInflater songInf;

    public SongAdapter(Context c, ArrayList<Song> arrayList) {
        this.arrayListSong = arrayList;
        this.songInf = LayoutInflater.from(c);
    }


    @Override
    public int getCount() {
        return arrayListSong.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // ánh xạ đến layout mỗi bài
        LinearLayout songLayout = (LinearLayout) songInf.inflate(R.layout.song,viewGroup,false);
        TextView songView =(TextView) songLayout.findViewById(R.id.song_title);
        TextView artistView = (TextView) songLayout.findViewById(R.id.song_artist);
        //lấy bài hát hiện
        Song currentSong = arrayListSong.get(i);
        //lấy tên tiêu đề và tác giả
        songView.setText(currentSong.getTitle());
        artistView.setText(currentSong.getArtist());
        // cài đặt tag cho mỗi bài là vị trí của mỗi
        songLayout.setTag(i);
        return songLayout;
    }
}
