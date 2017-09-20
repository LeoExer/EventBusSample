package com.leo.eventbus.sample3;

/**
 * Created by Leo on 2017/9/20.
 */

public class MsgEvent {

    String msg;

    MsgEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
