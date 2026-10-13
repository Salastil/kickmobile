package com.reactnative.googlecast.types;

import com.google.android.gms.cast.HlsSegmentFormat;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCHlsSegmentFormat {
    public static String fromJson(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "TS_AAC":
                return HlsSegmentFormat.TS_AAC;
            case "TS":
                return HlsSegmentFormat.TS;
            case "AAC":
                return HlsSegmentFormat.AAC;
            case "AC3":
                return HlsSegmentFormat.AC3;
            case "MP3":
                return HlsSegmentFormat.MP3;
            case "FMP4":
                return "fmp4";
            case "E-AC3":
                return HlsSegmentFormat.E_AC3;
            default:
                return null;
        }
    }

    public static String toJson(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "ts_aac":
                return "TS_AAC";
            case "ts":
                return "TS";
            case "aac":
                return "AAC";
            case "ac3":
                return "AC3";
            case "mp3":
                return "MP3";
            case "fmp4":
                return "FMP4";
            case "e-ac3":
                return "E-AC3";
            default:
                return null;
        }
    }
}
