package com.example.fristsecondgreen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class SericeExamper extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.e("ktem","Service đã được hủy");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.e("","Service đã được khởi tạo");
    }

}
