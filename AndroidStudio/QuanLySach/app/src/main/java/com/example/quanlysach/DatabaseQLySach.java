package com.example.quanlysach;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseQLySach extends SQLiteOpenHelper {

    public DatabaseQLySach(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    public void QueryData(String query){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(query);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase database =getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
