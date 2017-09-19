package com.leo.eventbus.sample2;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Leo on 2017/9/19.
 */

public class EventBusManager {

    public static EventBus ignoreEventInheritanceEventBus = EventBus.builder()
//            .eventInheritance(false)
            .sendSubscriberExceptionEvent(true)
            .build();

    public static EventBus getEventBus(int type) {
        EventBus eventBus = EventBus.getDefault();
        switch (type) {
            case 1:
                eventBus = ignoreEventInheritanceEventBus;
        }

        return eventBus;
    }
}
