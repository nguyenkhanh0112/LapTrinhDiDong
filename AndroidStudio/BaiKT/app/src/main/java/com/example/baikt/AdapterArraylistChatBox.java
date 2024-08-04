package com.example.baikt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterArraylistChatBox extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<chatbox> chatboxes;

    public AdapterArraylistChatBox(Context context, int layout, ArrayList<chatbox> chatboxes) {
        this.context = context;
        this.layout = layout;
        this.chatboxes = chatboxes;
    }

    @Override
    public int getCount() {
        return chatboxes.size();
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
        private ImageView imageView;
        private TextView ten;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if(view==null){
            holder = new viewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imageView = (ImageView) view.findViewById(R.id.imge);
            holder.ten = (TextView) view.findViewById(R.id.ten);
            view.setTag(holder);
        }else
          holder=(viewHolder) view.getTag();

        chatbox chatbox1 = chatboxes.get(i);
        holder.ten.setText(chatbox1.getName());
        holder.imageView.setImageResource(chatbox1.getImage());
        return view;

    }
}
