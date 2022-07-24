package com.fz.androidcode.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.butterknife.ButterKnife;
import com.butterknife.Unbinder;
import com.butterknife.annotations.BindView;
import com.fz.androidcode.R;

public class ButterKnifeTestActivity extends AppCompatActivity {
    @BindView(R.id.tv1)
    TextView textView1;

    @BindView(R.id.tv2)
    TextView textView2;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_test);
        mUnbinder = ButterKnife.bind(this);

        textView1.setText("butterKnife1");

        textView2.setText("butterKnife2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}