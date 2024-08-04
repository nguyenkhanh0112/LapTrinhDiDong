package com.example.quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioButton btn_nam,btn_nu;
    private Button btn_click;
    private EditText tenNV,maNV;
    private TextView textView;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        ArrayList<String> arrayList = new ArrayList<String>();
        listView = (ListView)findViewById(R.id.list_item);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        btn_click = (Button) findViewById(R.id.btn_click);
        tenNV = findViewById(R.id.editText_tenNV);
        maNV = findViewById(R.id.editText_manv);
        btn_nam = (RadioButton) findViewById(R.id.button_Nam);
        btn_nu = (RadioButton) findViewById(R.id.button_Nu);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn_nam.isChecked()==true){
                    arrayList.add(maNV.getText().toString()+" - "+tenNV.getText().toString()+" - "+btn_nam.getText().toString());
                    adapter.notifyDataSetChanged();
                }else {
                    arrayList.add(maNV.getText().toString()+" - "+tenNV.getText().toString()+" - "+btn_nu.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView =(TextView)findViewById(R.id.text_ViewList);
                String textlist = arrayList.get(i);
                textView.setText(textlist+"");
            }
        });
    }
}