package com.example.activitylifecyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String STATE = "Trạng Thái";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(STATE,"onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(STATE,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(STATE,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(STATE,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(STATE,"onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(STATE,"onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(STATE,"onSaveInstanceState");
    }
}