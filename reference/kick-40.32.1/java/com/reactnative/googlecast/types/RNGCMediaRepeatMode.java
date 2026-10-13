package com.reactnative.googlecast.types;

import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaRepeatMode {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "allAndShuffle":
                return 3;
            case "single":
                return 2;
            case "all":
                return 1;
            default:
                return 0;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        if (i == 1) {
            return "all";
        }
        if (i == 2) {
            return "single";
        }
        if (i != 3) {
            return null;
        }
        return "allAndShuffle";
    }
}
