package com.pusher.client.channel.impl.message;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class UnsubscribeMessage {
    private final Map<String, String> data;
    private final String event = "pusher:unsubscribe";

    public UnsubscribeMessage(String str) {
        HashMap map = new HashMap();
        this.data = map;
        map.put("channel", str);
    }
}
