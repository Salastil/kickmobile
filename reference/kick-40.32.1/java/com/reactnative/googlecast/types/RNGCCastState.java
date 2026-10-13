package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCCastState {
    public static String toJson(int i) {
        if (i == 1) {
            return "noDevicesAvailable";
        }
        if (i == 2) {
            return "notConnected";
        }
        if (i == 3) {
            return "connecting";
        }
        if (i != 4) {
            return null;
        }
        return "connected";
    }
}
