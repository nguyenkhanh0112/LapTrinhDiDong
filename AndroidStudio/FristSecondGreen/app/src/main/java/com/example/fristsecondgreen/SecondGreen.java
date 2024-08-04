package com.example.fristsecondgreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondGreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_green);
//        finish();
//
        Button btn_click = findViewById(R.id.btnClickSecondGreen);
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SecondGreen.this, FristGreen.class);
//                startActivity(intent);
//            }
//        });
        Button btn_click1 = findViewById(R.id.btnClickSecondGreen);
        Bundle extras = getIntent().getExtras();
        String data = extras.getString("value1");
        btn_click1.setText(data);
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("returnkey1","Giá trị trả về thứ nhất ");
        data.putExtra("returnkey2","Giá trị trả về thứ hai");
        setResult(-1,data);
        super.finish();
    }
}