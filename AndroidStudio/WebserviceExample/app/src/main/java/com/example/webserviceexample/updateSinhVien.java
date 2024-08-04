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

import java.util.HashMap;
import java.util.Map;

public class updateSinhVien extends AppCompatActivity {
    private Button btn_CapNhap,btn_huy1;
    private int id=0;
    String urlUpdate = "http://192.168.8.119/androidWebservice/update.php";
    private EditText edit_hoten1,edit_namsinh1,edit_diachi1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);
        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("dataSinhVien");
        btn_CapNhap = (Button) findViewById(R.id.btnCapNhap);
        btn_huy1 = (Button) findViewById(R.id.btnHuy1);
        edit_diachi1 =(EditText) findViewById(R.id.edit_diachi1);
        edit_namsinh1 =(EditText) findViewById(R.id.edit_namsinh1);
        edit_hoten1 = (EditText) findViewById(R.id.edit_hoten1);

        id = sinhVien.getId();
        edit_hoten1.setText(sinhVien.getHoten());
        edit_diachi1.setText(sinhVien.getDiachi());
        edit_namsinh1.setText(sinhVien.getNamsinh()+"");

        btn_CapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edit_hoten1.getText().toString().trim();
                String namsinh = edit_namsinh1.getText().toString().trim();
                String diachi= edit_diachi1.getText().toString().trim();
                if(hoten.isEmpty()||namsinh.isEmpty()||diachi.isEmpty()){
                    Toast.makeText(updateSinhVien.this, "vui lòng nhập đủ thông tin! ", Toast.LENGTH_SHORT).show();
                }else{
                    CapNhapSV(urlUpdate);
                }
            }
        });
        btn_huy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void CapNhapSV(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(updateSinhVien.this, "Cập nhập thành công!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(updateSinhVien.this, MainActivity.class));
                }else{
                    Toast.makeText(updateSinhVien.this, "Lỗi Thêm!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(updateSinhVien.this, "Xảy ra lỗi vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                Log.d("aaa","Lỗi!\n"+error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params = new HashMap<>();
                params.put("idSV",String.valueOf(id));
                params.put("hotenSV",edit_hoten1.getText().toString().trim());
                params.put("namsinhSV",edit_namsinh1.getText().toString().trim());
                params.put("diachiSV",edit_diachi1.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}