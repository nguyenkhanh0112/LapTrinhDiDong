package com.example.webserviceexample;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private ArrayList<SinhVien> students ;
    private MainActivity context;
    private int layout;

    public SinhVienAdapter( MainActivity context, int layout,ArrayList<SinhVien> students) {
        this.students = students;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return students.size();
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
        TextView txtTen,txtDiaChi,txtNamSinh;
        ImageView imageDelete,imageEdit;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view ==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTen = (TextView) view.findViewById(R.id.hotensv);
            holder.txtNamSinh =(TextView) view.findViewById(R.id.namsinhsv);
            holder.txtDiaChi = view.findViewById(R.id.diachisv);
            holder.imageDelete = (ImageView) view.findViewById(R.id.deletesv);
            holder.imageEdit = (ImageView) view.findViewById(R.id.editsv);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        SinhVien sinhVien = students.get(i);
        holder.txtTen.setText(sinhVien.getHoten());
        holder.txtDiaChi.setText("Địa Chỉ: "+sinhVien.getDiachi());
        holder.txtNamSinh.setText("Năm Sinh: "+sinhVien.getNamsinh());

        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, updateSinhVien.class);
                intent.putExtra("dataSinhVien",sinhVien);
                context.startActivity(intent);
            }
        });
        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_Delete(sinhVien.getHoten(),sinhVien.getId());
            }
        });
        return view;
    }
    private void Dialog_Delete(String ten, int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn xóa sinh viên "+ ten + " này không !");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.DeleteStudent(id);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}
