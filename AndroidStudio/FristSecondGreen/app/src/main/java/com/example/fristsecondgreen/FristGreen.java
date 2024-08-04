package com.example.fristsecondgreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FristGreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_green);
//        Intent i = new Intent(FristGreen.this,SecondGreen.class);
//        i.putExtra("value1","This value one for activity Second");
//        i.putExtra("value2","This value true for activity Second");
//        int REQUEST_CODE = 9;
//        startActivityForResult(i,REQUEST_CODE);
//        Button btn_click = findViewById(R.id.btnClick);
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FristGreen.this, SecondGreen.class);
//                startActivity(intent);
//            }
//        });
//        Intent serive = new Intent(this,SericeExamper.class);
//        startService(serive);
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://howkteam.vn"));
//        startActivity(intent);
//        Button btn = (Button) findViewById(R.id.btnClickMepro);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Overridex
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://translate.google.com/?hl=vi&sl=en&tl=vi&op=translate"));
//                intent.putExtra("key","");
//                startActivity(intent);
//            }
//        });
        Button btn = (Button) findViewById(R.id.btnClickMepro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FristGreen.this,SecondGreen.class);
                i.putExtra("value1","This value one for activity Second");
                i.putExtra("value2","This value true for activity Second");
                int REQUEST_CODE = 9;
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 9) {
            if (data.hasExtra("returnkey2")) {
                Toast.makeText(this, data.getExtras().getString("returnkey2"), Toast.LENGTH_LONG).show();
            }
        }
    }
}