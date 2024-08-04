package com.example.quanlysach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AuthorsAdapter extends BaseAdapter {
    private ArrayList<Author> authors;
    private Context context;
    private int layout;


    public AuthorsAdapter(ArrayList<Author> authors, Context context, int layout) {
        this.authors = authors;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return authors.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class viewHolder{
        private TextView text_ma,text_ten;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if(view ==null){
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.text_ma = view.findViewById(R.id.text_matg);
            holder.text_ten = view.findViewById(R.id.text_tentg);

            view.setTag(holder);
        }else
           holder= (viewHolder) view.getTag();

        Author author = authors.get(i);
        holder.text_ma.setText(author.getMaTG());
        holder.text_ten.setText(author.getTenTG());
        return view;
    }
}
