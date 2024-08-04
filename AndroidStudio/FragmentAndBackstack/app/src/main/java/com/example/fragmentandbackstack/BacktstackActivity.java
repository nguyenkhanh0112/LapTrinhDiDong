package com.example.fragmentandbackstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BacktstackActivity extends AppCompatActivity {
    private Button btn_Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backtstack);
        btn_Fragment = (Button) findViewById(R.id.btn_replace_fragment);
        btn_Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                replaceFragmentContent(new Fragment2());
                addFragment(new Fragment2());
                Log.e("Replaced fragment","2");
            }
        });
//        initFragment();
        replaceFragmentContent(new Fragment1());
    }
    protected void addFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.constraint_body,fragment);
        ft.addToBackStack(fragment.getClass().getName());
        ft.commit();

    }

//    private void initFragment(){
//        Fragment1 fragment1 = new Fragment1();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.constraint_body,fragment1);
//        ft.commit();
//    }
    protected void replaceFragmentContent(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.constraint_body,fragment);
            ft.commit();
        }
    }
}