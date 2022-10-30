package com.example.lifecycleandlifedata_20211109;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.i("jett","onCreate");
//        MainActivity.liveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                s+=s;
//                Log.i("jett",s);
//            }
//        });
        LiveDataBus.getInstance().with("msg", String.class,true)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Log.i("jett","bus->"+s);
                    }
                });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("jett","onStart");
    }
//
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("jett","onResume");
    }
}