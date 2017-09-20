package com.leo.eventbus.sample3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSubscriberExceptionsActivity(View view) {
        startActivity(new Intent(this, SubscriberExceptionsActivity.class));
    }

    public void startNoSubscriberActivity(View view) {
        startActivity(new Intent(this, NoSubscriberActivity.class));
    }

    public void startEventInheritanceActivity(View view) {
        startActivity(new Intent(this, EventInheritanceActivity.class));
    }

    public void startIgnoreMethodActivity(View view) {
        startActivity(new Intent(this, IgnoreMethodActivity.class));
    }

}
