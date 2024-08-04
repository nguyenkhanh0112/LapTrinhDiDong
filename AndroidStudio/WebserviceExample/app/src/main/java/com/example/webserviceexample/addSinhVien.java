package com.example.webserviceexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class addSinhVien extends AppCompatActivity {
    private Button btn_them,btn_huy;
    private EditText edit_hoten,edit_namsinh,edit_diachi;
    String urlInsert ="http://192.168.8.119/androidWebservice/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        btn_them = (Button) findViewById(R.id.btnThem);
        btn_huy = (Button) findViewById(R.id.btnHuy);
        edit_diachi =(EditText) findViewById(R.id.edit_diachi);
        edit_namsinh =(EditText) findViewById(R.id.edit_namsinh);
        edit_hoten = (EditText) findViewById(R.id.edit_hoten);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten =edit_hoten.getText().toString().trim();
                String namsinh =edit_namsinh.getText().toString().trim();
                String diachi= edit_diachi.getText().toString().trim();
                if(hoten.isEmpty()||namsinh.isEmpty()||diachi.isEmpty()){
                    Toast.makeText(addSinhVien.this, "vui lòng nhập đủ thông tin! ", Toast.LENGTH_SHORT).show();
                }else{
                    ThemSV(urlInsert);
                }
            }
        });



        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void ThemSV(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            Toast.makeText(addSinhVien.this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(addSinhVien.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addSinhVien.this, "Xảy ra lỗi !", Toast.LENGTH_SHORT).show();
                        Log.d("aaa","Lỗi!\n"+error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("hotenSV",edit_hoten.getText().toString().trim());
                params.put("namsinhSV",edit_namsinh.getText().toString().trim());
                params.put("diachiSV",edit_diachi.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}