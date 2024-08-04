package com.example.quanlysach;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ListBooks extends AppCompatActivity {
    private ArrayList<Book> books ;
    private ListView lv;
    private Cursor cursor;
    private ArrayList<Author> authors;
    private DatabaseQLySach databaseQLySach;
    private Button btn_clickDateTimePicker,add_books;
    private EditText edit_TenSach,edit_NgayxuatBan;
    private Spinner spinner_Author;
    private BooksAdapter booksAdapter;
    private EditText edit_maSach;
    private String selectedAuthor;
    private AuthorsAdapter adapter;
    private static final String createTableAuthor = "CREATE TABLE IF NOT EXISTS author (MaTG TEXT PRIMARY KEY,TenTG TEXT);";
    private static final String createTableBook = "CREATE TABLE IF NOT EXISTS book (MaSach TEXT PRIMARY KEY,TenSach TEXT ,  NgayXB TEXT ,author_MaTG TEXT ,FOREIGN KEY (author_MaTG) REFERENCES author(MaTG));";

    private void insertBook(String ma, String ten, String ngayxb, String maTG) {
        String queryBook = "INSERT INTO book (MaSach, TenSach, NgayXB, author_MaTG) VALUES ('" + ma + "', '" + ten + "', '" + ngayxb + "', '" + maTG + "')";
        databaseQLySach.QueryData(queryBook);
    }
    private void CreateTable(){
        databaseQLySach = new DatabaseQLySach(this,"QuanLySach.sqlite",null,1);
        databaseQLySach.QueryData(createTableAuthor);
        databaseQLySach.QueryData(createTableBook);
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qls);
        CreateTable();
        books = new ArrayList<>();
        books = getIntent().getParcelableArrayListExtra("ListBooks");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv =(ListView)findViewById(R.id.list_book);
        booksAdapter = new BooksAdapter(this,R.layout.custom_list_books,books);
        lv.setAdapter(booksAdapter);
        booksAdapter.notifyDataSetChanged();



        btn_clickDateTimePicker = (Button) findViewById(R.id.btn_DatePicker);
        btn_clickDateTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
        edit_maSach =(EditText)findViewById(R.id.Ma_Sach);
        edit_TenSach = (EditText) findViewById(R.id.edit_tensach);
        edit_NgayxuatBan = (EditText) findViewById(R.id.edit_DatePicker);
        spinner_Author =(Spinner) findViewById(R.id.spinner_tg);
        add_books =(Button) findViewById(R.id.btn_addBook);
        authors = new ArrayList<>();
        adapter = new AuthorsAdapter(authors,this,R.layout.custom_list_author);
        GetDataAuthors();
        spinner_Author.setAdapter(adapter);
        spinner_Author.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedAuthor = authors.get(i).getMaTG();
                Toast.makeText(ListBooks.this, selectedAuthor, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        add_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensach = edit_TenSach.getText().toString();
                String masach =edit_maSach.getText().toString();
                if(edit_NgayxuatBan.getText().equals("")){
                    edit_NgayxuatBan.requestFocus();
                    Toast.makeText(ListBooks.this, "Hãy chọn ngày !", Toast.LENGTH_SHORT).show();
                }
                String NgayXB = edit_NgayxuatBan.getText().toString();
                String ma_author = selectedAuthor;
                insertBook(masach,tensach,NgayXB,ma_author);
                booksAdapter.notifyDataSetChanged();
                Toast.makeText(ListBooks.this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String selectDate = i2+"-"+(i1+1) +"-"+i;
                edit_NgayxuatBan.setText(selectDate);
            }
        },2020,1,1);
        datePickerDialog.show();
    }

}
