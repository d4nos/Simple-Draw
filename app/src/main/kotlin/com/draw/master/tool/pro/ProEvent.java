package com.draw.master.tool.pro;


import org.greenrobot.eventbus.EventBus;

public class ProEvent {
    public static void sendEvent() {
        EventBus.getDefault().post(new ProEvent());
    }
}
