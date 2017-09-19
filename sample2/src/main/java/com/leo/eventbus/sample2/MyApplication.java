package com.leo.eventbus.sample2;

import android.app.Application;

import com.leo.eventbus.sample.SampleBusIndex;

import org.greenrobot.eventbus.EventBus;

//import com.leo.test.SampleBusIndex;

/**
 * Created by Leo on 2017/9/14.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 加载索引，添加到默认配置的EventBus
        EventBus.builder().addIndex(new SampleBusIndex()).installDefaultEventBus();
    }
}
