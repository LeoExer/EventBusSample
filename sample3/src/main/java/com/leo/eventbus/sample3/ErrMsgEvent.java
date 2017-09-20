package com.leo.eventbus.sample3;

/**
 * Created by Leo on 2017/9/20.
 */

public class ErrMsgEvent extends MsgEvent {

    ErrMsgEvent(String errMsg) {
        super(errMsg);
    }
}
