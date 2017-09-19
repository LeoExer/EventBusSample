package com.leo.eventbus.sample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Leo on 2017/9/18.
 */

public class StickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        EventBus.getDefault().register(this);

//        EventBus.getDefault().postSticky(new StickyEvent("sticky event 1")); // 注意，是调用“postSticky”而不是“post”
//        EventBus.getDefault().postSticky(new StickyEvent("sticky event 2"));
//        EventBus.getDefault().postSticky(new StickyEvent("sticky event 3"));
//        EventBus.getDefault().register(this); // 一注册订阅者，就会调用上面的订阅方法
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true) // 粘性事件
    public void onStickyEvent(StickyEvent event) {
        Log.d("Test", event.args);
        init(event.args);
    }

    private void init(String args) {
        // do init
        Toast.makeText(this, "init, args=" + args, Toast.LENGTH_SHORT).show();
    }
}
