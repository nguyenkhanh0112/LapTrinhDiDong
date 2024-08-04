package com.example.giaipt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Button btnGpt;
    EditText hesoa,hesob,hesoc,kq1;
    SeekBar seekar =findViewById(R.id.seekbar);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGpt = (Button) findViewById(R.id.btnGiaiPT);
        hesoa = findViewById(R.id.hesoa);
        hesob = findViewById(R.id.hesob);
        hesoc = findViewById(R.id.hesoc);
        kq1 = findViewById(R.id.textkq);
        seekar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnGpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double hesoa1 =Double.parseDouble(hesoa.getText().toString());
                double hesob1 = Double.parseDouble(hesob.getText().toString());
                double hesoc1 = Double.parseDouble(hesoc.getText().toString());
                if(hesoa1==0){
                    if(hesob1==0&&hesoc1==0){
                        String content = "Phương trình vô số nghiệm";
                        kq1.setText(content);
                    }
                    else if(hesob1!=0) {
                        String content = "Phương trình có một nghiệm: ";
                        double c1 = hesoc1/hesob1;
                        kq1.setText(content+c1);
                    }else{
                        kq1.setText("Phương trình vô nghiệm");
                    }
                }else{
                    double denta = (Math.pow(hesob1,2)-(4*hesoa1*hesoc1));
                    if(denta>0){
                        double x1 = (-hesob1-Math.sqrt(denta))/(2*hesoa1);
                        double x2 = (-hesob1+Math.sqrt(denta))/(2*hesoa1);
                        kq1.setText("Phương trình có 2 nghiệm: x1 = "+x1+", x2 = "+x2);
                    }else if(denta==0){
                        double x = hesoc1/(2*hesoa1);
                        kq1.setText("Phương trình có 1 nghiệm: x = "+x);
                    }else
                        kq1.setText("Phương trình vô nghiệm");
                }
            }
        });
    }
}