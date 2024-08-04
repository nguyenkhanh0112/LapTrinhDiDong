package com.example.sqliteexamplevesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvCV;
    ArrayList<CongViec> congViecArrayList;
    CongViecAdapter adapter;
    Toolbar toolbar;
    Cursor dataCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar) findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        lvCV =(ListView) findViewById(R.id.lvCV);
        congViecArrayList = new ArrayList<>();
        adapter = new CongViecAdapter(congViecArrayList,this,R.layout.dong_cong_viec);
        lvCV.setAdapter(adapter);

        //tạo database StickNotes
        database = new Database(this,"StickyNotes.sqlite",null,1);
        //tạo bảng
        String CreateTableCV = "CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER primary key autoincrement,TenCV nvarchar(50))";
//        database.QueryData(CreateTableCV);
        //thêm dữ liệu
        String InsertData ="insert into CongViec values (null,'Làm bài tập android studio')";
   //     database.QueryData(InsertData);
        // lấy dữ liệu
        GetDataCongViec();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_add_cv){
            Dialog_Them();

        }
        return super.onOptionsItemSelected(item);
    }
    public void GetDataCongViec(){
        String SelectData = "select * from CongViec";
        dataCV = database.GetData(SelectData);
        congViecArrayList.clear();
        while (dataCV.moveToNext()){
            String ten =  dataCV.getString(1);
            int i = dataCV.getInt(0);
            congViecArrayList.add(new CongViec(i,ten));
        }
        adapter.notifyDataSetChanged();
    }
    public void Dialog_Sua(String ten,int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);
        dialog.setCanceledOnTouchOutside(false);
        EditText editTen = (EditText)dialog.findViewById(R.id.edit_tenCV);
        Button btn_XN = (Button)dialog.findViewById(R.id.xacnhan_btn) ;
        Button btn_huy = (Button)dialog.findViewById(R.id.huy_btn);

        editTen.setText(ten);
        btn_XN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ten.equals("")){
                    Toast.makeText(MainActivity.this, "vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                }else{
                    String tenmoi = editTen.getText().toString().trim();
                    String update ="update CongViec set TenCV = '"+tenmoi+"' where id ='"+id+"'";
                    database.QueryData(update);
                    Toast.makeText(MainActivity.this, "Cập nhập thành công!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });

        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    public void AlertDialog_Xoa(String ten,int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có chắc muốn xóa "+ten+" không");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("delete from CongViec where Id ='"+id+"'");
                Toast.makeText(MainActivity.this, "Xóa Thành công", Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void Dialog_Them(){
        invalidateOptionsMenu();
        Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add);

        dialog.show();

        Button btn_them =(Button) dialog.findViewById(R.id.btn_Them);
        EditText text = (EditText)dialog.findViewById(R.id.textTen);
        Button btn_huy = (Button)dialog.findViewById(R.id.btn_huy);

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                }else{
                    String ten = text.getText().toString().trim();
                    database.QueryData("insert into CongViec values (null,'"+ten+"')");
                    Toast.makeText(MainActivity.this, "Dã Thêm!", Toast.LENGTH_SHORT).show();
                    GetDataCongViec();
                }
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}