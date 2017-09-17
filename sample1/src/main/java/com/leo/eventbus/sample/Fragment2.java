package com.leo.eventbus.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Leo on 2017/9/16.
 */

public class Fragment2 extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        textView = (TextView) view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

//    /**
//     * 需要暴露接口给外部来交互
//     */
//    public void readBook(String book) {
//        textView.setText(book);
//    }

    @Subscribe
    public void onReadBook(ReadBookEvent event) {
        textView.setText(String.format("我正在阅读%s", event.getBook()));
    }
}
