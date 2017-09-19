package com.leo.eventbus.sample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startStickyActivity(View view) {
        EventBus.getDefault().postSticky(new StickyEvent("I am args"));
        startActivity(new Intent(this, StickyActivity.class));
    }

    public void startPriorityActivity(View view) {
        startActivity(new Intent(this, PriorityActivity.class));
    }

    public void startChangeThreadActivity(View view) {
        startActivity(new Intent(this, ChangeThreadActivity.class));
    }
}
