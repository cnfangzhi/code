package com.example.vip_dagger2_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.vip_dagger2_demo1.di.Presenter;
import com.example.vip_dagger2_demo1.object.HttpObject;

import javax.inject.Inject;

public class SecActivity extends AppCompatActivity {

    @Inject
    HttpObject httpObject;
    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

//        DaggerMyComponent.builder()
//                .httpModule(new HttpModule())
//                .databaseModule(new DatabaseModule())
//                .build()
//                //上面的代码初始化了module和component
//                .injectSecActivity(this);
        ((MyApplication)getApplication()).getMyComponent()
                .injectSecActivity(this);
        Log.i("jett",httpObject.hashCode()+"-sec");
        Log.i("jett",presenter.hashCode()+"-sec");

    }
}