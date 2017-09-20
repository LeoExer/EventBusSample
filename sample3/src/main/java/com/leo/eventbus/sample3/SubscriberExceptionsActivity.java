package com.leo.eventbus.sample3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.SubscriberExceptionEvent;

/**
 * Created by Leo on 2017/9/20.
 */

public class SubscriberExceptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber_exceptions);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void post(View view) {
        EventBus.getDefault().post(new MsgEvent(""));
    }

    @Subscribe
    public void onMsgEvent(MsgEvent event) {
        if (TextUtils.isEmpty(event.getMsg())) {
            throw new IllegalArgumentException("Event msg can not be empty");
        }
        Log.i("TEST", "onMsgEvent --> " + event.getMsg());
    }

    @Subscribe
    public void onSubscriberExceptionEvent(SubscriberExceptionEvent event) {
        // 订阅方法抛出异常时, 会到这里
        Log.i("TEST", "onSubscriberExceptionEvent --> " + event.throwable.getMessage());
    }
}
