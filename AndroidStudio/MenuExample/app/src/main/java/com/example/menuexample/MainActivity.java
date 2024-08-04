package com.example.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button btnmenu;
    Button btn_mau;
    ConstraintLayout disPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnmenu =(Button)findViewById(R.id.click_button);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });
        btn_mau = (Button) findViewById(R.id.btn_paint);
        // đăng ký view cho context menu
//        registerForContextMenu(btn_mau);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Chọn màu");
        menu.setHeaderIcon(R.drawable.ic_launcher_foreground);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_item_demo,menu);
       return true;

   }
    public void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btnmenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_btn,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.menuThem){
                    btnmenu.setText("menu Thêm");
                }else if(menuItem.getItemId()==R.id.menuSua){
                    btnmenu.setText("menu Sửa");
                }else if(menuItem.getItemId()==R.id.menuXoa){
                    btnmenu.setText("menu Xóa");
                }
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuSetting){
            Toast.makeText(this,"bạn chọn setting",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.menuSearch){
            Toast.makeText(this,"bạn chọn Search",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}