package com.example.quanlysach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Book> books;

    public BooksAdapter(Context context, int layout, ArrayList<Book> books) {
        this.context = context;
        this.layout = layout;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class Viewholder{
        TextView id_matg,tenTacPham,ThoiGian;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder;
        if(view==null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewholder.id_matg = view.findViewById(R.id.id_maTG);
            viewholder.tenTacPham = view.findViewById(R.id.tacpham);
            viewholder.ThoiGian = view.findViewById(R.id.dateTime);
            view.setTag(viewholder);
        }else
            viewholder =(Viewholder) view.getTag();

        Book book = books.get(i);
        viewholder.id_matg.setText(book.getAuthor_MaTG());
        viewholder.tenTacPham.setText(book.getTenSach());
        viewholder.ThoiGian.setText(book.getNgayXB());

        return view;
    }
}
