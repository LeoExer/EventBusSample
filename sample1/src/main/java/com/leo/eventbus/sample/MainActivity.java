package com.leo.eventbus.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    Fragment1 fragment1;
//    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
//        // 设置监听
//        fragment1.setOnClickBookListener(new Fragment1.OnClickBookListener() {
//            @Override
//            public void onCLickBook(String book) {
//                // 更新fragment2的阅读书籍
//                fragment2.readBook(String.format("我正在阅读%s", book));
//            }
//        });
//        fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
    }
}
