package com.example.sqliteexamplevesion;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private List<CongViec> congViecList;
    private MainActivity context;
    private int layout;

    @Override
    public int getCount() {
        return congViecList.size();
    }

    public CongViecAdapter(List<CongViec> congViecList, MainActivity context, int layout) {
        this.congViecList = congViecList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTenCV;
        ImageView imageDelete,imageEdit;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.txtTenCV = (TextView) view.findViewById(R.id.txtTenCV);
            viewHolder.imageDelete = (ImageView) view.findViewById(R.id.imageDelete);
            viewHolder.imageEdit = (ImageView) view.findViewById(R.id.imageEdit);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }
        CongViec congViec = congViecList.get(i);
        viewHolder.txtTenCV.setText(congViec.getTenCV());
        // bắt sự kiện xóa và sửa
        viewHolder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.Dialog_Sua(congViec.getTenCV(),congViec.getIdCV());
            }
        });
        viewHolder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.AlertDialog_Xoa(congViec.getTenCV(),congViec.getIdCV());
            }
        });
        return view;
    }
}
