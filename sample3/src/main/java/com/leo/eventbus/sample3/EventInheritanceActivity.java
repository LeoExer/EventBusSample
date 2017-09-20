package com.leo.eventbus.sample3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Leo on 2017/9/20.
 */

public class EventInheritanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_inheritance);
        EventBus.getDefault().register(this);
        EventBusManager.getEventBus(EventBusManager.NO_EVENT_INHERITANCE_TYPE).register(this);
    }

    public void post(View view) {
        EventBus.getDefault().post(new ErrMsgEvent("I am a error msg"));
    }

    public void postNoInheritance(View view) {
        EventBusManager.getEventBus(EventBusManager.NO_EVENT_INHERITANCE_TYPE)
                .post(new ErrMsgEvent("I am a error msg"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBusManager.getEventBus(EventBusManager.NO_EVENT_INHERITANCE_TYPE).unregister(this);
    }

    @Subscribe
    public void onMsgEvent(MsgEvent event) {
        Log.i("TEST", "onMsgEvent --> " + event.getMsg());
    }

    @Subscribe
    public static void onErrMsgEvent(ErrMsgEvent event) {
        Log.i("TEST", "onErrMsgEvent --> " + event.getMsg());
    }
}
