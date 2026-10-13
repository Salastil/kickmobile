package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes6.dex */
public final class DDSpanId {
    public static final long MAX = -1;
    public static final long ZERO = 0;

    private DDSpanId() {
    }

    public static long from(String str) throws NumberFormatException {
        return LongStringUtils.parseUnsignedLong(str);
    }

    public static long fromHex(String str) throws NumberFormatException {
        return LongStringUtils.parseUnsignedLongHex(str);
    }

    public static long fromHexOrDefault(String str, long j) {
        try {
            return fromHex(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static long fromHex(String str, int i, int i2, boolean z) throws NumberFormatException {
        return LongStringUtils.parseUnsignedLongHex(str, i, i2, z);
    }

    public static String toString(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j, 10);
    }

    public static String toHexString(long j) {
        return Long.toHexString(j);
    }

    public static String toHexStringPadded(long j) {
        return LongStringUtils.toHexStringPadded(j, 16);
    }
}
