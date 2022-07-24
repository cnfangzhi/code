package com.fz.architect.design10.simple6;

import android.content.Intent;
import android.os.Bundle;

import com.fz.architect.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 一个参数一个参数的获取
       /* String Params1 = getIntent().getStringExtra("Params1");
        String Params2 = getIntent().getStringExtra("Params2");
        String Params3 = getIntent().getStringExtra("Params3");
        // 又 new 一个 intent

        // 把参数传递
        Intent intent = new Intent(this,Activity3.class);

        intent.putExtra("Params1",Params1);
        intent.putExtra("Params2",Params2);
        intent.putExtra("Params3",Params3);*/

        // 原型设计模式（拷贝）
        Intent intent = (Intent) getIntent().clone();
        intent.setClass(this,Activity3.class);
        startActivity(intent);


        ArrayList<String> list = new ArrayList<>();
        // 有很多数据
        ArrayList<String> copyList = (ArrayList<String>) list.clone();

        // OkHttp 的源码，它是没用系统的，但是类似，如果自己写是可以用系统的
        OkHttpClient client = new OkHttpClient();

        client.newBuilder();

    }
}
