package com.mux.stats.sdk.core.model;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class TrackingURL {
    public String host;
    public String protocol;
    public ConcurrentHashMap<String, String> query = new ConcurrentHashMap<>();
}
