package com.datadog.trace.core.propagation;

import com.datadog.trace.util.PercentEscaper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class Baggage {
    private static final char KEY_VALUE_SEPARATOR = '=';
    private static final char PAIR_SEPARATOR = ',';
    private static final PercentEscaper UTF_ESCAPER = PercentEscaper.create();
    private final HashMap<String, String> values = new HashMap<>();

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public Baggage put(String str, String str2) {
        this.values.put(str, str2);
        return this;
    }

    public Baggage mergeWith(Baggage baggage) {
        if (baggage != null) {
            this.values.putAll(baggage.asMap());
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, String> entry : asMap().entrySet()) {
            if (i > 0) {
                sb.append(',');
            }
            PercentEscaper percentEscaper = UTF_ESCAPER;
            PercentEscaper.Escaped escapedEscapeKey = percentEscaper.escapeKey(entry.getKey());
            PercentEscaper.Escaped escapedEscapeValue = percentEscaper.escapeValue(entry.getValue());
            sb.append(escapedEscapeKey.data);
            sb.append(KEY_VALUE_SEPARATOR);
            sb.append(escapedEscapeValue.data);
            i++;
        }
        return sb.toString();
    }

    public Map<String, String> asMap() {
        return new HashMap(this.values);
    }

    public static Baggage from(String str) {
        if (str == null) {
            return new Baggage();
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        int iIndexOf2 = str.indexOf(61);
        Baggage baggage = new Baggage();
        int i = 0;
        while (iIndexOf2 != -1) {
            if (iIndexOf2 > iIndexOf) {
                return new Baggage();
            }
            String strUrlDecode = urlDecode(str.substring(i, iIndexOf2).trim());
            String strUrlDecode2 = urlDecode(str.substring(iIndexOf2 + 1, iIndexOf).trim());
            if (strUrlDecode.isEmpty() || strUrlDecode2.isEmpty()) {
                return new Baggage();
            }
            baggage.put(strUrlDecode, strUrlDecode2);
            i = iIndexOf + 1;
            iIndexOf2 = str.indexOf(61, i);
            iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
        }
        return baggage;
    }

    private static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return str;
        }
    }
}
