package com.example.quanlysach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainActivity extends AppCompatActivity{
    private Button btn_add,btn_xem,btn_ql;
    private ArrayList<Author> authors ;
    private ArrayList<Book>books;
    private DatabaseQLySach databaseQLySach;
    private Cursor cursor;
    private static final String createTableAuthor = "CREATE TABLE IF NOT EXISTS author (MaTG TEXT PRIMARY KEY,TenTG TEXT);";
    private static final String createTableBook = "CREATE TABLE IF NOT EXISTS book (MaSach TEXT PRIMARY KEY,TenSach TEXT ,  NgayXB TEXT ,author_MaTG TEXT ,FOREIGN KEY (author_MaTG) REFERENCES author(MaTG));";


    private void CreateTable(){
        databaseQLySach = new DatabaseQLySach(this,"QuanLySach.sqlite",null,1);
        databaseQLySach.QueryData(createTableAuthor);
        databaseQLySach.QueryData(createTableBook);
    }
    private void insertAuthor(String ma, String ten) {
        String queryAuthor = "INSERT INTO author VALUES ('" + ma + "', '" + ten + "')";
        databaseQLySach.QueryData(queryAuthor);
    }
//    private void insertBook(String ma, String ten, String ngayxb, String maTG) {
//        String queryBook = "INSERT INTO book (MaSach, TenSach, NgayXB, author_MaTG) VALUES ('" + ma + "', '" + ten + "', '" + ngayxb + "', '" + maTG + "')";
//        databaseQLySach.QueryData(queryBook);
//    }
    public void updateAuthor(String ma,String ten){
        String queryUpdate ="update author set TenTG = '"+ ten + "' where MaTG = '"+ ma +"'";
        databaseQLySach.QueryData(queryUpdate);
    }
    public void updateBook(String ma,String ten,String ngayxb,String maTG){
        String queryUpdate = "update book set TenSach ='" + ten + "', NgayXB ='" + ngayxb + "', author_MaTG='" + maTG + "' where MaSach ='" + ma + "'";
        databaseQLySach.QueryData(queryUpdate);
    }
    public void deleteBook(String ma){
        String queryDelete = "delete from book where MaSach = '"+ma+"'";
        databaseQLySach.QueryData(queryDelete);
    }
    public void GetDataBooks(){
        String query = "select * from book";
        cursor = databaseQLySach.GetData(query);
        if(books!=null)
            books.clear();
        while (cursor.moveToNext()){
            String ma = cursor.getString(0);
            String ten = cursor.getString(1);
            String ngayXB =cursor.getString(2);
            String author_Ma =cursor.getString(3);
            books.add(new Book(ma,ten,ngayXB,author_Ma));
        }
    }
    public void GetDataAuthors(){
        String query ="select * from author";
        cursor = databaseQLySach.GetData(query);
        if(authors!=null)
            authors.clear();
        while (cursor.moveToNext()){
                String ma = cursor.getString(0);
                String ten = cursor.getString(1);
                authors.add(new Author(ma,ten));
            }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateTable();
        authors = new ArrayList<>();
        books = new ArrayList<>();
//        Toolbar toolbar = new Toolbar(this);
//        toolbar = (Toolbar)findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);

        btn_add = (Button) findViewById(R.id.btn_addTG);
        btn_xem =(Button) findViewById(R.id.btn_viewDS);
        btn_ql =(Button) findViewById(R.id.btn_QLS);

        btn_ql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDataBooks();
                Intent intent = new Intent(MainActivity.this,ListBooks.class);
                intent.putParcelableArrayListExtra("ListBooks",books);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogThemAuthor();
            }
        });

        btn_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDataAuthors();
                Intent intent = new Intent(MainActivity.this,ListAuthor.class);
                intent.putParcelableArrayListExtra("authorList",authors);
                startActivity(intent);
            }
        });
        Toast.makeText(this, "'"+books.size()+"'", Toast.LENGTH_SHORT).show();
    }
    public void DialogThemAuthor(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_addtg);

        Button btn_xoaTrang,btn_luuTG;
        EditText edit_matg,edit_tentg;

        edit_tentg = (EditText)dialog.findViewById(R.id.edit_tentg);
        edit_matg = (EditText)dialog.findViewById(R.id.edit_matg);

        btn_xoaTrang = (Button)dialog.findViewById(R.id.btn_XTrang);
        btn_luuTG =(Button) dialog.findViewById(R.id.btn_LuuTG);
        dialog.show();
        btn_xoaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_tentg.setText("");
                edit_matg.setText("");
                edit_matg.requestFocus();
                Toast.makeText(MainActivity.this, "Đã xóa trắng!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_luuTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edit_matg.getText().toString();
                String ten = edit_tentg.getText().toString();
                insertAuthor(ma,ten);
                Toast.makeText(MainActivity.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}