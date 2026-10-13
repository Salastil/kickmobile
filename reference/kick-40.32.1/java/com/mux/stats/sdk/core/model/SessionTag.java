package com.mux.stats.sdk.core.model;

/* JADX INFO: loaded from: classes8.dex */
public class SessionTag {
    public final String key;
    public final String value;

    public SessionTag(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String toString() {
        return "{ key='" + this.key + "', value='" + this.value + "'}";
    }
}
