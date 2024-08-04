package com.example.baikt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AdapterArraylistChatBox adapterArraylistChatBox;
    private ArrayList<chatbox> chatboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatboxes = new ArrayList<>();
        chatboxes.add(new chatbox(R.drawable.nguoi1,"khánh"));
        chatboxes.add(new chatbox(R.drawable.nguoi2,"hà"));
        chatboxes.add(new chatbox(R.drawable.nguoi2,"huy"));
        chatboxes.add(new chatbox(R.drawable.nguoi2,"hiếu"));
        chatboxes.add(new chatbox(R.drawable.nguoi2,"khoa"));
        chatboxes.add(new chatbox(R.drawable.nguoi2,"vũ"));
        listView = findViewById(R.id.listChatBox);
        adapterArraylistChatBox = new AdapterArraylistChatBox(this,R.layout.custom_list,chatboxes);
        listView.setAdapter(adapterArraylistChatBox);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,ActivityChatBox.class);
                startActivity(intent);
            }
        });
    }
}