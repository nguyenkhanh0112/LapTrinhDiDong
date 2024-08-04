package com.example.chuongtrinhquanlynhanvien.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.chuongtrinhquanlynhanvien.Adapter.PhongBanAdapter;
import com.example.chuongtrinhquanlynhanvien.model.NhanVien;
import com.example.chuongtrinhquanlynhanvien.model.PhongBan;
import com.example.chuongtrinhquanlynhanvien.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText TenPB,MaPB,tenNV,maNV;
    private ListView list_item;
    private Button Click_Luu,Click_LuuNhanVien,Click_XoaTrang;
    private RadioButton btn_Nam,btn_Nu;
    private ArrayList<PhongBan> list_PB;
    private PhongBanAdapter adapter;
    private ArrayList<NhanVien> phoPhongs;
    private ArrayList<NhanVien>nhanViens;
    private NhanVien truongPhong;
    public void impostData_PP_NV(){
        truongPhong = new NhanVien("TP001", "Nguyễn văn khánh", "Nam", true, "Truong phong");
        phoPhongs = new ArrayList<NhanVien>();
        nhanViens = new ArrayList<NhanVien>();
        phoPhongs.add(new NhanVien("PP001", "Tran Van X", "Nam", true, "Pho phong"));
        phoPhongs.add(new NhanVien("PP002", "Nguyen Thi Y", "Nu", false, "Pho phong"));
        nhanViens.add(new NhanVien("NV001", "Nguyen Van A", "Nam", true, "Nhan vien"));
        nhanViens.add(new NhanVien("NV002", "Tran Thi B", "Nu", false, "Nhan vien"));
        nhanViens.add(new NhanVien("NV003", "Ho Van C", "Nam", true, "Nhan vien"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_PB = new ArrayList<PhongBan>();
        impostData_PP_NV();
        Click_Luu =(Button)findViewById(R.id.btn_clickLuu);
        list_item = (ListView)findViewById(R.id.list_item);
        TenPB = findViewById(R.id.TenPB);
        MaPB = findViewById(R.id.MaPB);
        adapter = new PhongBanAdapter(this,list_PB,R.layout.list_item_dspb);
        list_item.setAdapter(adapter);
        String Ten = TenPB.getText().toString();
        String Ma = MaPB.getText().toString();
        list_PB.add(new PhongBan(Ma,Ten,truongPhong,phoPhongs,nhanViens));
        Click_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        this.registerForContextMenu(list_item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        if(item.getItemId()==R.id.add_NV){

            return true;
        }else if(item.getItemId()==R.id.list_item){
            return true;
        }else if(item.getItemId()==R.id.permission){
            return true;
        }else if(item.getItemId()==R.id.delte){
            return true;
        }else {
            return super.onContextItemSelected(item);
        }
    }
}