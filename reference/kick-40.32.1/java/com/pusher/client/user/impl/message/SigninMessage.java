package com.pusher.client.user.impl.message;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class SigninMessage {
    private final Map<String, String> data;
    private final String event = "pusher:signin";

    public SigninMessage(String str, String str2) {
        HashMap map = new HashMap();
        this.data = map;
        map.put("auth", str);
        map.put("user_data", str2);
    }
}
