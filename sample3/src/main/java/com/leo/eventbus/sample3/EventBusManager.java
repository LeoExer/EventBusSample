package com.leo.eventbus.sample3;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * Created by Leo on 2017/9/19.
 */

public class EventBusManager {

    public static final int NO_EVENT_INHERITANCE_TYPE = 1;
    public static final int FIXED_THREAD_TYPE = 2;

    /**
     * 事件非继承订阅EventBus
     */
    private static EventBus noEventInheritanceEventBus;

    /**
     * 固定线程池EventBus
     */
    private static EventBus fixedThreadEventBus;

    public static EventBus getEventBus(int type) {
        EventBus eventBus = EventBus.getDefault();
        switch (type) {
            case NO_EVENT_INHERITANCE_TYPE:
                if (noEventInheritanceEventBus == null) {
                    // lazy
                    synchronized (EventBusManager.class) {
                        if (noEventInheritanceEventBus == null) {
                            noEventInheritanceEventBus = EventBus.builder()
                                    .eventInheritance(false)
                                    .build();
                        }
                    }
                }
                eventBus = noEventInheritanceEventBus;
                break;

            case FIXED_THREAD_TYPE:
                if (fixedThreadEventBus == null) {
                    // lazy
                    synchronized (EventBusManager.class) {
                        if (fixedThreadEventBus == null) {
                            fixedThreadEventBus = EventBus.builder()
                                    .executorService(Executors.newFixedThreadPool(20))
                                    .build();
                        }
                    }
                    eventBus = fixedThreadEventBus;
                }
                break;
        }

        return eventBus;
    }
}
