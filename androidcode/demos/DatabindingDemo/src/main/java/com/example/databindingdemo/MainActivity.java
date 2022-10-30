package com.example.databindingdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databindingdemo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    //从model层来的数据
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //这一行就是完成XML布局的初始化
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        //数据是从网络或是数据库拿来的
        user=new User("jett","123");

        binding.setUser(user);//view.setText(text);

//        binding.setVariable(BR.name,"jett");
//
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        user.setName(user.getName()+"1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
