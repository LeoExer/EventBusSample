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

public class IgnoreMethodActivity extends AppCompatActivity {

    private EventBus eventBus = EventBus.builder()
            .strictMethodVerification(true)
            .build();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new View(this));
        eventBus.register(this);
        eventBus.post(new MsgEvent(""));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventBus.unregister(this);
    }

    @Subscribe
    public void onNormalMethod(MsgEvent event) {
        Log.d("TEST", "onNormalMethod");
    }

    @Subscribe
    private void onPrivateMethod(MsgEvent event) {
        Log.d("TEST", "onPrivateMethod");
    }

    @Subscribe
    public static void onStaticMethod(MsgEvent event) {
        Log.d("TEST", "onStaticMethod");
    }
}
