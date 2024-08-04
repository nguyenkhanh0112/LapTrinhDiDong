package com.example.quanlysach;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListAuthor extends AppCompatActivity {
    private ArrayList<Author> authors;
    private AuthorsAdapter adapter;
    private ListView listView;
    private DatabaseQLySach databaseQLySach;
    public int index,index1;
    private Cursor cursor;
    private static final String createTableAuthor = "CREATE TABLE IF NOT EXISTS author (MaTG TEXT PRIMARY KEY,TenTG TEXT);";
    private static final String createTableBook = "CREATE TABLE IF NOT EXISTS book (MaSach TEXT PRIMARY KEY,TenSach TEXT ,  NgayXB TEXT ,author_MaTG TEXT ,FOREIGN KEY (author_MaTG) REFERENCES author(MaTG));";

    public void deleteAuthor(String ma){
        if(databaseQLySach!=null) {
            String queryDelete = "delete from author where MaTG = '" + ma + "'";
            databaseQLySach.QueryData(queryDelete);
        }
    }
    private void CreateTable(){
        databaseQLySach = new DatabaseQLySach(this,"QuanLySach.sqlite",null,1);
        databaseQLySach.QueryData(createTableAuthor);
        databaseQLySach.QueryData(createTableBook);
    }

    public void updateAuthor(String ma,String ten){
        if(databaseQLySach!=null){
            String queryUpdate ="update author set TenTG = '"+ ten + "' where MaTG = '"+ ma +"'";
            databaseQLySach.QueryData(queryUpdate);

        }
    }
    public void GetData(){
        String query ="select * from author";
        cursor = databaseQLySach.GetData(query);
        if(authors!=null)
            authors.clear();
        while (cursor.moveToNext()){
            String ma = cursor.getString(0);
            String ten = cursor.getString(1);
            authors.add(new Author(ma,ten));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CreateTable();
        setContentView(R.layout.activity_listds_tg);
        authors = new ArrayList<>();
        authors = getIntent().getParcelableArrayListExtra("authorList");

        listView = (ListView) findViewById(R.id.list_Author);
        adapter = new AuthorsAdapter(authors,this,R.layout.custom_list_author);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                Dialog_update(index);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                index1 = i;
                alertDialog(index1);
                return true;
            }
        });
    }
    public void alertDialog(int index1){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove");
        builder.setMessage("Bạn có chắc muốn xóa '"+authors.get(index1).getMaTG().toString()+" - "+authors.get(index1).getTenTG().toString() +"'");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                deleteAuthor(authors.get(index1).getMaTG().toString().trim());
                GetData();
                Toast.makeText(ListAuthor.this, "Xóa Thành Công!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void Dialog_update(int index){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);
        EditText edit_ma = (EditText) dialog.findViewById(R.id.edit_matg);
        EditText edit_ten =(EditText) dialog.findViewById(R.id.edit_tentg);
        Button btn_xoaTrang = (Button)dialog.findViewById(R.id.btn_focus);
        Button btn_update =(Button) dialog.findViewById(R.id.btn_update);
        String ma =authors.get(index).getMaTG().toString().trim();
        String ten =authors.get(index).getTenTG().toString().trim();
        if(edit_ma.isEnabled())
            edit_ma.setEnabled(false);
        edit_ma.setText(ma);
        edit_ten.setText(ten);
        dialog.show();

        btn_xoaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_ten.setText("");
                edit_ten.requestFocus();
                Toast.makeText(ListAuthor.this, "Đã xóa trắng!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten =edit_ten.getText().toString();
                String ma = edit_ma.getText().toString();
                updateAuthor(ma,ten);
                GetData();
                Toast.makeText(ListAuthor.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
