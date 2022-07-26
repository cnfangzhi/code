package com.fz.architect.design11.simple3;

import android.os.Bundle;

import com.fz.architect.R;
import com.fz.architect.design11.simple3.bottomtab.TabBottomNavigation;
import com.fz.architect.design11.simple3.bottomtab.iterator.TabListIterator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by fz on 2017/10/22.
 */
public class TabActivity extends AppCompatActivity {
    private TabBottomNavigation mTabBottomNavigation;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main11);

        mTabBottomNavigation = findViewById(R.id.tab_bottom);

        TabListIterator<MainBottomTabItem> listIterator = new TabListIterator<>();
        listIterator.addItem(new MainBottomTabItem.Builder(this)
                .resIcon(R.drawable.main_tab_item).text("text1").create());
        listIterator.addItem(new MainBottomTabItem.Builder(this)
                .resIcon(R.drawable.main_tab_item).text("text2").create());
        listIterator.addItem(new MainBottomTabItem.Builder(this)
                .resIcon(R.drawable.main_tab_item).text("text3").create());

        // 还可以写灵活一些什么意思
        // 第一个刚刚看到我报错了
        // 有可能我们不传 List Array[]怎么办法呢？
        mTabBottomNavigation.addTabItem(listIterator);

        // 运行
    }


}
