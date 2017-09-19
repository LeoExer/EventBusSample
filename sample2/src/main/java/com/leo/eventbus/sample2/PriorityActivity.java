package com.leo.eventbus.sample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Leo on 2017/9/18.
 */

public class PriorityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new PriorityEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(priority = 0) // 指定优先级为0，默认是0
    public void onLowPriorityEvent(PriorityEvent event) {
        Log.i("TEST", "onLowPriorityEvent");
    }

    @Subscribe(priority = 10) // 指定优先级为10
    public void onHighPriorityEvent(PriorityEvent event) {
        Log.i("TEST", "onHighPriorityEvent");
    }
}
