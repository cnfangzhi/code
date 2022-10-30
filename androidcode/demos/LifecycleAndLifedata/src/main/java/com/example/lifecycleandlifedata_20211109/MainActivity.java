package com.example.lifecycleandlifedata_20211109;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static NonStickyMutableLiveData liveData;

    public static MutableLiveData liveData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liveData = new NonStickyMutableLiveData();

//        liveData.observeForever(new Observer() {
//            @Override
//            public void onChanged(Object o) {
//
//            }
//        });

//        liveData.observe(this, new Observer<String>() {
//            //observer.mObserver.onChanged((T) mData);
//            @Override
//            public void onChanged(String s) {
//                Log.i("jett","收到了数据1："+s);
//            }
//        });




        liveData2 = new MutableLiveData<>();

        liveData2.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("jett", "changed1 :" + s);
                if (s.equals("1")) {
                    liveData2.setValue("2");
                }
            }
        });

        liveData2.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("jett", "changed2 :" + s);
            }
        });


    }

    public void mainClick(View view) {
        liveData.setValue("mainClick");
//        liveData2.setValue("1");
    }

    public void threadClick(View view) {
        new Thread() {
            @Override
            public void run() {
//                liveData.postValue("threadClick");
                LiveDataBus.getInstance().with("msg",String.class,true).postValue("threadClick");
            }
        }.start();
    }

    public void newActivityClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}








