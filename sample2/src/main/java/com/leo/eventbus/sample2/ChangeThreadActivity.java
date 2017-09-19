package com.leo.eventbus.sample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Leo on 2017/9/18.
 */

public class ChangeThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_thread);
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new ThreadEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onPostingThreadEvent(ThreadEvent event) {
        Log.i("TEST", "POSTING --> I am on Thread " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainThreadEvent(ThreadEvent event) {
        Log.i("TEST", "MAIN --> I am on Thread " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackgroundThreadEvent(ThreadEvent event) {
        Log.i("TEST", "BACKGROUND --> I am on Thread " + Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onAsyncThreadEvent(ThreadEvent event) {
        Log.i("TEST", "ASYNC --> I am on Thread " + Thread.currentThread().getName());
    }

    public class ThreadEvent {

    }
}
