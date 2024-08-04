package com.example.quanlynhanvien;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPham extends AppCompatActivity {
    private Spinner spinnerDanhMuc;
    private EditText maSP,tenSP;
    private Button btn_click;
    private TextView textView;
    private ListView listViewSP;
    private Map<String, List<String>> productData;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private void initPreferences(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanpham_items);


        maSP = (EditText) findViewById(R.id.sanpham);
        tenSP = (EditText) findViewById(R.id.tensp);
        btn_click = (Button) findViewById(R.id.btn_click);
        spinnerDanhMuc = (Spinner) findViewById(R.id.spinnerDM);
        listViewSP = (ListView) findViewById(R.id.listViewDS);
        productData = new HashMap<String, List<String>>();
        productData.put("Iphone",new ArrayList<>(Arrays.asList()));
        productData.put("SamSung",new ArrayList<>(Arrays.asList()));
        productData.put("Oppo",new ArrayList<>(Arrays.asList()));
        

        // khởi tạo adapter cho spinner
        ArrayList<String> item = new ArrayList<String>(productData.keySet());
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,item);
        spinnerDanhMuc.setAdapter(adapterSpinner);

        //khởi tạo adapter cho listview
        ArrayAdapter<String>adapterList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listViewSP.setAdapter(adapterList);

        spinnerDanhMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedProduct = item.get(i);
                List arraylist = productData.get(selectedProduct);
                if(arraylist!=null){
                    adapterList.clear();
                    adapterList.addAll(arraylist);
                    adapterList.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectGroup = spinnerDanhMuc.getSelectedItem().toString();
                String text = maSP.getText() + " - " +tenSP.getText();
                if(!(maSP.getText().toString().isEmpty()&&tenSP.getText().toString().isEmpty())){
                    ArrayList<String> listitem = (ArrayList<String>) productData.get(selectGroup);
                    if(listitem!=null){
                        listitem.add(text);
                        adapterList.clear();
                        adapterList.addAll(listitem);
                        adapterList.notifyDataSetChanged();
                        maSP.setText("");
                        tenSP.setText("");
                    }
                }

            }
        });
    }

}
