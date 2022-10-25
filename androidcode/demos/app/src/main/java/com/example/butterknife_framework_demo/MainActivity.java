package com.example.butterknife_framework_demo;


import android.os.Bundle;
import android.widget.TextView;

import com.example.annotations.BindView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvText)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JettButterknife.bind(this);
        textView.setText("123456");
    }
}



