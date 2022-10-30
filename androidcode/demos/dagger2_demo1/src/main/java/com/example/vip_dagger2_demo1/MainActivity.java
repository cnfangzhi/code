package com.example.vip_dagger2_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vip_dagger2_demo1.di.Presenter;
import com.example.vip_dagger2_demo1.object.DatabaseObject;
import com.example.vip_dagger2_demo1.object.HttpObject;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpObject httpObject;
    //= httpObjectProvider.get();
    //= module.providerHttpObject()
    //= new HttpObject();
    @Inject
    HttpObject httpObject2;

    @Inject
    DatabaseObject databaseObject;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerMyComponent.create().injectMainActivity(this);
//        DaggerMyComponent.builder()
//                .httpModule(new HttpModule())
//                .databaseModule(new DatabaseModule())
//                .build()
                //上面的代码初始化了module和component
//                .injectMainActivity(this);

        //全局单例
        ((MyApplication)getApplication()).getMyComponent()
                .injectMainActivity(this);

        Log.i("jett",httpObject.hashCode()+"");
        Log.i("jett",httpObject2.hashCode()+"");
        Log.i("jett",databaseObject.hashCode()+"");
        Log.i("jett",presenter.hashCode()+"");


    }

    public void click(View view) {
        startActivity(new Intent(this,SecActivity.class));
    }
}


















