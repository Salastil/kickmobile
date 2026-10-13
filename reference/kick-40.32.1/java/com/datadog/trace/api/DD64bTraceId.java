package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes6.dex */
public class DD64bTraceId extends DDTraceId {
    public static final DD64bTraceId MAX = new DD64bTraceId(-1, "18446744073709551615");
    private String hexStr;
    private final long id;
    private String str;

    @Override // com.datadog.trace.api.DDTraceId
    public long toHighOrderLong() {
        return 0L;
    }

    DD64bTraceId(long j, String str) {
        this.id = j;
        this.str = str;
    }

    public static DD64bTraceId from(long j) {
        return create(j, null);
    }

    public static DD64bTraceId from(String str) throws NumberFormatException {
        return create(LongStringUtils.parseUnsignedLong(str), str);
    }

    public static DD64bTraceId fromHex(String str) throws NumberFormatException {
        return create(LongStringUtils.parseUnsignedLongHex(str), null);
    }

    static DD64bTraceId create(long j, String str) {
        if (j == 0 && ZERO != null) {
            return (DD64bTraceId) ZERO;
        }
        if (j == -1) {
            return MAX;
        }
        return new DD64bTraceId(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DD64bTraceId) && this.id == ((DD64bTraceId) obj).id;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toString() {
        String str = this.str;
        if (str != null) {
            return str;
        }
        String strM = UByte$$ExternalSyntheticBackport0.m(this.id, 10);
        this.str = strM;
        return strM;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexString() {
        String str = this.hexStr;
        if (str != null) {
            return str;
        }
        String hexStringPadded = LongStringUtils.toHexStringPadded(this.id, 32);
        this.hexStr = hexStringPadded;
        return hexStringPadded;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexStringPadded(int i) {
        if (i > 16) {
            return toHexString();
        }
        return LongStringUtils.toHexStringPadded(this.id, i);
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public long toLong() {
        return this.id;
    }
}
