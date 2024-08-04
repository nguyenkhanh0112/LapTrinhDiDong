package com.example.baikt;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityChatBox extends AppCompatActivity {
    private ArrayList<chatbox> chatboxes;
    private AdapterArraylistChatBox adapterArraylistChatBox;
    private TextView header;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbox);

    }
}
