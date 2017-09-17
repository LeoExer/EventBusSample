package com.leo.eventbus.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Leo on 2017/9/16.
 */

public class Fragment1 extends Fragment {

    private final static String[] BOOKS = new String[] {
            "第一行代码",
            "Java编程思想",
            "Android开发艺术探索",
            "Android源码设计模式",
            "算法",
            "研磨设计模式"
    };

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        listView = (ListView) view.findViewById(R.id.lv_catalogue);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, BOOKS);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 回调
//                if (listener != null) {
//                    listener.onCLickBook(BOOKS[position]);
//                }
                EventBus.getDefault().post(new ReadBookEvent(BOOKS[position]));
            }
        });
        return view;
    }

//    private OnClickBookListener listener;
//
//    public void setOnClickBookListener(OnClickBookListener listener) {
//        this.listener = listener;
//    }
//
//    /**
//     * 点击书籍监听接口
//     */
//    public interface OnClickBookListener {
//        void onCLickBook(String book);
//    }
}
