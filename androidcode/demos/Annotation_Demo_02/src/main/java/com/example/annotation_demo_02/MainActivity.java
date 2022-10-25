package com.example.annotation_demo_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn1=findViewById(R.id.btn1);
//        btn2=findViewById(R.id.btn2);
        InjectUtils.inject(this);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }


    @OnClick({R.id.btn1,R.id.btn2})
    public void abc(View view){
        Toast.makeText(this, "按下1", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick({R.id.btn2})
    public boolean longClick(View view){
        Toast.makeText(this, "按下2", Toast.LENGTH_SHORT).show();
        return false;
    }

}