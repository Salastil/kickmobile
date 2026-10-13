package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DDTraceId {
    public static final DDTraceId ZERO = from(0);
    public static final DDTraceId ONE = from(1);

    public abstract String toHexString();

    public abstract String toHexStringPadded(int i);

    public abstract long toHighOrderLong();

    public abstract long toLong();

    public abstract String toString();

    public static DDTraceId from(long j) {
        return DD64bTraceId.from(j);
    }

    public static DDTraceId from(String str) throws NumberFormatException {
        return DD64bTraceId.create(LongStringUtils.parseUnsignedLong(str), str);
    }

    public static DDTraceId fromHex(String str) throws NumberFormatException {
        if (str != null) {
            return str.length() > 16 ? DD128bTraceId.fromHex(str) : DD64bTraceId.fromHex(str);
        }
        throw new NumberFormatException("s cannot be null");
    }

    public static DDTraceId fromHexOrDefault(String str, DDTraceId dDTraceId) {
        try {
            return fromHex(str);
        } catch (NumberFormatException unused) {
            return dDTraceId;
        }
    }
}
