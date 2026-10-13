package com.datadog.trace.api;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public enum TracePropagationStyle {
    DATADOG,
    B3SINGLE,
    B3MULTI,
    HAYSTACK,
    XRAY,
    TRACECONTEXT,
    NONE;

    private String displayName;

    public static TracePropagationStyle valueOfDisplayName(String str) {
        String strReplace = str.toUpperCase(Locale.US).replace(' ', '_');
        strReplace.hashCode();
        if (strReplace.equals("B3_SINGLE_HEADER")) {
            return B3SINGLE;
        }
        if (strReplace.equals("B3")) {
            return B3MULTI;
        }
        return valueOf(strReplace);
    }

    @Override // java.lang.Enum
    public String toString() {
        String str = this.displayName;
        if (str != null) {
            return str;
        }
        String strReplace = name().toLowerCase(Locale.ROOT).replace('_', ' ');
        this.displayName = strReplace;
        return strReplace;
    }
}
