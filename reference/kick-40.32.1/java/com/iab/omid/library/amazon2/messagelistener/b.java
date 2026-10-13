package com.iab.omid.library.amazon2.messagelistener;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    String getListenerName();

    void onMessageReceived(String str, JSONObject jSONObject);

    void onWebMessageListenerUnsupported();
}
