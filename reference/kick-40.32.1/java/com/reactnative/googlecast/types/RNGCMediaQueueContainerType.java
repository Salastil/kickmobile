package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaQueueContainerType {
    public static int fromJson(String str) {
        str.hashCode();
        return !str.equals("audioBook") ? 0 : 1;
    }

    public static String toJson(int i) {
        if (i != 1) {
            return null;
        }
        return "audioBook";
    }
}
