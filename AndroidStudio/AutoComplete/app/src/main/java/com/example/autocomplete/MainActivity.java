package com.example.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_clickNhapSV,btl_clickNgaysinh;
    private EditText editText_Ma,editText_Ten,editText_Ngaysinh;
    private AutoCompleteTextView autoCompleteTextView_Noisinh;
    private CheckBox checkBox_yes;
    private ListView lv_dsSv;
    public void extend(){
        btl_clickNgaysinh = (Button)findViewById(R.id.btn_clickNgaySinh);
        btn_clickNhapSV =(Button)findViewById(R.id.btn_clickNhapSV);
        editText_Ma = findViewById(R.id.editText_Ma);
        editText_Ten = findViewById(R.id.editText_Ten);
        editText_Ngaysinh= findViewById(R.id.editText_Ngaysinh);
        autoCompleteTextView_Noisinh = (AutoCompleteTextView)findViewById(R.id.autoComplete_noisinh);
        checkBox_yes =(CheckBox) findViewById(R.id.check_yes);
        lv_dsSv =(ListView) findViewById(R.id.lv_dsSV);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extend();
        ArrayList<String> listSV = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listSV);
        lv_dsSv.setAdapter(adapter);
        ArrayList<String> listAutocompleteTextView = new ArrayList<String>();
        listAutocompleteTextView.add("TP Ha Noi");
        listAutocompleteTextView.add("TP HCM");
        listAutocompleteTextView.add("TP Lai Chau");
        listAutocompleteTextView.add("TP Nam Dinh");
        ArrayAdapter AdapterAuto = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listAutocompleteTextView);
        autoCompleteTextView_Noisinh.setAdapter(AdapterAuto);
        btl_clickNgaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editText_Ngaysinh.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },2003,8,2);
                dpd.show();
            }
        });

        btn_clickNhapSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gt="";
                if(checkBox_yes.isChecked()==true)
                    gt = "Nữ";
                else
                    gt = "Nam";
                listSV.add(editText_Ma.getText() + "-" +editText_Ten.getText() + "-" +gt +"-"+editText_Ngaysinh.getText()+"-"+autoCompleteTextView_Noisinh.getText());
                adapter.notifyDataSetChanged();
            }
        });

    }
}