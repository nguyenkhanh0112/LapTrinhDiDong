package com.example.alertdialogexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvName;
    private ArrayList<String>arrayName;
    private ArrayAdapter adapter;
    private TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        arrayName = new ArrayList<String>();
//        arrayName.add("Android");
//        arrayName.add("ios");
//        arrayName.add("PHP");
//        arrayName.add("ASP.NET");
//        arrayName.add("Unity 3D");
//        arrayName.add("Cocos2dx");
//        arrayName.add("NodeJS");
//        lvName = (ListView) findViewById(R.id.list_item);
//        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayName);
//        adapter.notifyDataSetChanged();
//        lvName.setAdapter(adapter);
//        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                int index = i;
//                xacnhanxoa(index);
//            }
//        });
        txtlogin = (TextView) findViewById(R.id.login);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogLogin();
            }
        });
    }
    private void DialogLogin(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_custom);
        EditText username =(EditText)dialog.findViewById(R.id.edit_Username);
        EditText passwword =(EditText)dialog.findViewById(R.id.edi_Password);
        Button btn_dongy = (Button)dialog.findViewById(R.id.btn_dongy);
        Button btn_huy =(Button)dialog.findViewById(R.id.btn_huy);

        btn_dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username1= username.getText().toString().trim();
                String password = passwword.getText().toString().trim();
                if(username1.equals("khanh123")&&password.equals("123")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Lỗi đăng nhập!",Toast.LENGTH_SHORT).show();
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.cancel();
                dialog.dismiss();
            }
        });
        dialog.show();


    }
    private void xacnhanxoa(int x){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo !");
        alertDialog.setIcon(R.drawable.ic_launcher_foreground);
        alertDialog.setMessage("bạn có chắc muốn xóa nội dung này không !");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayName.remove(x);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }


}