package com.reactnative.googlecast.types;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCStandbyState {
    public static String toJson(int i) {
        if (i == -1) {
            return ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        if (i == 0) {
            return "Inactive";
        }
        if (i != 1) {
            return null;
        }
        return "Active";
    }
}
