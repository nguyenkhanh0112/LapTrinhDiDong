package com.example.chuongtrinhquanlynhanvien.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chuongtrinhquanlynhanvien.model.NhanVien;
import com.example.chuongtrinhquanlynhanvien.model.PhongBan;
import com.example.chuongtrinhquanlynhanvien.R;

import java.util.ArrayList;

public class PhongBanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PhongBan>phongBanArrayList;
    private int layout;

    public PhongBanAdapter(Context context, ArrayList<PhongBan> phongBanArrayList, int layout) {
        this.context = context;
        this.phongBanArrayList = phongBanArrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return phongBanArrayList.size();
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
        private TextView txtTruongPhong;
        private TextView txtPhoPhong,txtMa_TenPhong;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if(view==null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.txtPhoPhong = view.findViewById(R.id.phophong);
            viewHolder.txtTruongPhong = view.findViewById(R.id.truong_phong);
            viewHolder.txtMa_TenPhong = view.findViewById(R.id.txt_ma_ten);
            view.setTag(viewHolder);
        }else {
                viewHolder = (ViewHolder) view.getTag();
        }
        PhongBan phongBan = phongBanArrayList.get(i);
        if(phongBan.getNhanViens().size()>0){
            viewHolder.txtMa_TenPhong.setText(phongBan.getMaPhong()+" - "+phongBan.getTenPhong()+"(Có "+phongBan.getNhanViens().size()+" NV)");
        }
        viewHolder.txtTruongPhong.setText(phongBan.getTruongPhong().getTenNV());
        if(phongBan.getPhoPhongs().size()>0){
            String text ="";
            for(int j=0;j<phongBan.getPhoPhongs().size();j++){
                text =(j+1)+"."+phongBan.getPhoPhongs().get(j).getTenNV()+"\n";
            }
            viewHolder.txtPhoPhong.setText(text);
        }

        return view;
    }
}
