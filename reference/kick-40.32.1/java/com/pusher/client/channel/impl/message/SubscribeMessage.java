package com.pusher.client.channel.impl.message;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class SubscribeMessage {
    private final Map<String, String> data;
    private final String event = "pusher:subscribe";

    public SubscribeMessage(String str) {
        HashMap map = new HashMap();
        this.data = map;
        map.put("channel", str);
    }

    public SubscribeMessage(String str, String str2, String str3) {
        HashMap map = new HashMap();
        this.data = map;
        map.put("auth", str2);
        map.put("channel", str);
        if (str3 != null) {
            map.put("channel_data", str3);
        }
    }
}
