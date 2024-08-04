package com.example.activitylifecyle;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SaveInstanceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_Cong,btn_Tru,btn_Nhan,btn_chia;
    private EditText editText1,editText2;
    private TextView textView;
    private int firsNumber;
    private int secondNumber;
    private double result;
//    private ProgressDialog progressDialog;
//    private  int progressCount=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editTextFistNumber);
        editText2 = (EditText)findViewById(R.id.editTextSecondNumber);
        textView = (TextView)findViewById(R.id.textView6);
        if(savedInstanceState!=null){
            editText1.setText(String.valueOf(savedInstanceState.getInt("SO_THU_NHAT")));
            editText2.setText(String.valueOf(savedInstanceState.getInt("SO_THU_HAI")));
            textView.setText(String.valueOf(savedInstanceState.getInt("KET_QUA")));
        }
        btn_Cong = (Button) findViewById(R.id.btnTinhTong);
        btn_chia = (Button)findViewById(R.id.btn_Thuong);
        btn_Tru = (Button)findViewById(R.id.btn_Tru);
        btn_Nhan = (Button)findViewById(R.id.btn_Tich);
        btn_Nhan.setOnClickListener(this);
        btn_chia.setOnClickListener(this);
        btn_Tru.setOnClickListener(this);
        btn_Cong.setOnClickListener(this);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(!textView.getText().toString().isEmpty()){
            outState.putInt("SO_THU_NHAT",Integer.parseInt(editText1.getText().toString()));
            outState.putInt("SO_THU_HAI",Integer.parseInt(editText2.getText().toString()));
            outState.putInt("KET_QUA",Integer.parseInt(textView.getText().toString()));
        }
    }
    @Override
    public void onClick(View view) {
        if((view==btn_Cong)||(view == btn_chia)||(view==btn_Nhan)||(view == btn_Tru)){
            if(editText1.getText().toString().isEmpty()||editText2.getText().toString().isEmpty()) {
                Toast.makeText(SaveInstanceActivity.this,"Không nhập đủ dữ liệu để tính, bạn hãy nhập thêm",Toast.LENGTH_LONG).show();
//                progressDialog.setTitle("Vui lòng chờ");
//               // progressDialog.setMax(100);
//                progressDialog.setMessage("đang cập nhập");
//                progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
//                progressDialog.setCancelable(true);
//                progressDialog.show();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        while(progressCount<100){
//                            try {
//                                Thread.sleep(100);
//                                progressDialog.setProgress(progressCount);
//                                progressCount++;
//                            }catch (InterruptedException e){
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
            }else if(view == btn_Cong){
                firsNumber = Integer.parseInt(editText1.getText().toString());
                secondNumber = Integer.parseInt(editText2.getText().toString());
                result = firsNumber + secondNumber;
                textView.setText(String.valueOf(result));
            }else if(view ==btn_Tru){
                firsNumber = Integer.parseInt(editText1.getText().toString());
                secondNumber = Integer.parseInt(editText2.getText().toString());
                result = firsNumber - secondNumber;
                textView.setText(String.valueOf(result));
            }else if(view == btn_Nhan){
                firsNumber = Integer.parseInt(editText1.getText().toString());
                secondNumber = Integer.parseInt(editText2.getText().toString());
                result = firsNumber * secondNumber;
                textView.setText(String.valueOf(result));
            }else if(view ==btn_chia){
                firsNumber = Integer.parseInt(editText1.getText().toString());
                secondNumber = Integer.parseInt(editText2.getText().toString());
                result = firsNumber /((1.0)* secondNumber);
                textView.setText(String.valueOf(result));
            }
        }
    }
}
