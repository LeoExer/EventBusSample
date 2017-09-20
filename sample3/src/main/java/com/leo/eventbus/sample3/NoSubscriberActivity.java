package com.leo.eventbus.sample3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Leo on 2017/9/20.
 */

public class NoSubscriberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_subscriber);
        EventBus.getDefault().register(this);
    }

    public void post(View view) {
        EventBus.getDefault().post(new MsgEvent("Hello World"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onNoSubscriberEvent(NoSubscriberEvent event) {
        // 在订阅者中没找到发送的订阅事件, 会到这里
        Log.i("TEST", "onNoSubscriberEvent --> " + ((MsgEvent) event.originalEvent).getMsg());
    }
}
