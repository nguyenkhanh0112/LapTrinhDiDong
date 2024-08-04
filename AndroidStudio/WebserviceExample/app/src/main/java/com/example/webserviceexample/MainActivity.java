package com.example.webserviceexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private ListView listViewSV;
    String urlDelete ="http://192.168.8.119/androidWebservice/delete.php";
    private SinhVienAdapter adapter;
    String urlSelect = "http://192.168.8.119/androidWebservice/getdatabase.php";
    private ArrayList<SinhVien> arrayList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar)findViewById(R.id.ToolBar);
        setSupportActionBar(toolbar);

        listViewSV = findViewById(R.id.listView);
        arrayList = new ArrayList<SinhVien>();
        adapter = new SinhVienAdapter(this,R.layout.dong_sinh_vien,arrayList);
        listViewSV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ReadJson(urlSelect);
    }
    public void DeleteStudent(final int index){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(MainActivity.this, "Xóa Thành Công!", Toast.LENGTH_SHORT).show();
                            ReadJson(urlSelect);
                        }else{
                            Toast.makeText(MainActivity.this, "Lỗi Xóa!", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Xảy ra lỗi!", Toast.LENGTH_SHORT).show();
                }
            }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("idSV",String.valueOf(index));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void  ReadJson(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayList.clear();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                arrayList.add(new SinhVien( jsonObject.getInt("ID"),
                                                            jsonObject.getString("Hoten"),
                                                            jsonObject.getInt("Namsinh"),
                                                            jsonObject.getString("DiaChi")));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuAddStudent){
            startActivity(new Intent(MainActivity.this, addSinhVien.class));
        }
        return super.onOptionsItemSelected(item);
    }
}