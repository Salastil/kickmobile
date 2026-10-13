package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCActiveInputState {
    public static String toJson(int i) {
        if (i == -1) {
            return "unknown";
        }
        if (i == 0) {
            return "inactive";
        }
        if (i != 1) {
            return null;
        }
        return "active";
    }
}
