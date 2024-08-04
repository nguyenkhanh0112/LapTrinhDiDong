package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;


public class MainActivity extends AppCompatActivity {
    Button btn_XacNhan;
    CheckBox cb_remember;
    EditText edit_username,edit_password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_XacNhan =(Button) findViewById(R.id.btn_XN);
        cb_remember =(CheckBox) findViewById(R.id.cb_remember1);
        edit_password =(EditText) findViewById(R.id.edit_password);
        edit_username =(EditText) findViewById(R.id.edit_username);


        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

         //lấy giá trị  sharedPreferences
        edit_username.setText(sharedPreferences.getString("taikhoan",""));
        edit_password.setText(sharedPreferences.getString("matkhau",""));
        cb_remember.setChecked(sharedPreferences.getBoolean("Checked",false));


        btn_XacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =edit_username.getText().toString().trim();
                String password =edit_password.getText().toString().trim();
                if(username.equals("khanh123")&&password.equals("123456789")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                     //nếu có check thì kiểm tra
                    if(cb_remember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",password);
                        editor.putBoolean("Checked",true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("Checked");
                    }
                }else
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}