package com.reactnative.googlecast.types;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCVideoInfoHDRType {
    public static String toJson(int i) {
        if (i == 1) {
            return "SDR";
        }
        if (i == 2) {
            return "HDR";
        }
        if (i == 3) {
            return "DV";
        }
        if (i != 4) {
            return null;
        }
        return "HDR";
    }
}
