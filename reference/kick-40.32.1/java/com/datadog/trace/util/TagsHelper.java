package com.datadog.trace.util;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class TagsHelper {
    private static final int MAX_LENGTH = 200;

    static boolean isValid(char c) {
        if (c < 'a' || c > 'z') {
            return (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' || c == '/' || c == ':';
        }
        return true;
    }

    public static String sanitize(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.toLowerCase(Locale.ROOT).trim();
        int iMin = Math.min(strTrim.length(), 200);
        StringBuilder sb = new StringBuilder(iMin);
        for (int i = 0; i < iMin; i++) {
            char cCharAt = strTrim.charAt(i);
            if (isValid(cCharAt)) {
                sb.append(cCharAt);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public static String concatTags(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }
}
