package com.reactnative.googlecast.types;

import com.google.android.gms.cast.HlsVideoSegmentFormat;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCHlsVideoSegmentFormat {
    public static String fromJson(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        if (str.equals("FMP4")) {
            return "fmp4";
        }
        if (str.equals("MPEG2-TS")) {
            return HlsVideoSegmentFormat.MPEG2_TS;
        }
        return null;
    }

    public static String toJson(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        if (str.equals("fmp4")) {
            return "FMP4";
        }
        if (str.equals(HlsVideoSegmentFormat.MPEG2_TS)) {
            return "MPEG2-TS";
        }
        return null;
    }
}
