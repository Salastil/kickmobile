package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;
import java.util.Locale;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes6.dex */
public class DD128bTraceId extends DDTraceId {
    public static final DD128bTraceId ZERO = new DD128bTraceId(0, 0, "00000000000000000000000000000000");
    private String hexStr;
    private final long highOrderBits;
    private final long lowOrderBits;
    private String str;

    private DD128bTraceId(long j, long j2, String str) {
        this.highOrderBits = j;
        this.lowOrderBits = j2;
        this.hexStr = str;
    }

    public static DD128bTraceId from(long j, long j2) {
        return new DD128bTraceId(j, j2, null);
    }

    public static DD128bTraceId fromHex(String str) throws NumberFormatException {
        return fromHex(str, 0, str == null ? 0 : str.length(), true);
    }

    public static DD128bTraceId fromHex(String str, int i, int i2, boolean z) throws NumberFormatException {
        long unsignedLongHex;
        long unsignedLongHex2;
        String lowerCase = str;
        if (lowerCase == null) {
            throw new NumberFormatException("s can't be null");
        }
        int length = lowerCase.length();
        if (i < 0 || i2 <= 0 || i2 > 32 || i + i2 > length) {
            throw new NumberFormatException("Illegal start or length");
        }
        if (i2 > 16) {
            int i3 = i2 - 16;
            unsignedLongHex2 = LongStringUtils.parseUnsignedLongHex(lowerCase, i, i3, z);
            unsignedLongHex = LongStringUtils.parseUnsignedLongHex(lowerCase, i3 + i, 16, z);
        } else {
            unsignedLongHex = LongStringUtils.parseUnsignedLongHex(str, i, i2, z);
            unsignedLongHex2 = 0;
        }
        long j = unsignedLongHex2;
        long j2 = unsignedLongHex;
        if (i2 == 32) {
            if (i != 0) {
                lowerCase = lowerCase.substring(i, i + 32);
            }
            if (!z) {
                lowerCase = lowerCase.toLowerCase(Locale.ROOT);
            }
        } else {
            lowerCase = null;
        }
        return new DD128bTraceId(j, j2, lowerCase);
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexString() {
        String str = this.hexStr;
        if (str != null) {
            return str;
        }
        String hexStringPadded = LongStringUtils.toHexStringPadded(this.highOrderBits, this.lowOrderBits, 32);
        this.hexStr = hexStringPadded;
        return hexStringPadded;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexStringPadded(int i) {
        if (i <= 16) {
            return LongStringUtils.toHexStringPadded(this.lowOrderBits, 16);
        }
        return toHexString();
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public long toLong() {
        return this.lowOrderBits;
    }

    @Override // com.datadog.trace.api.DDTraceId
    public long toHighOrderLong() {
        return this.highOrderBits;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DD128bTraceId)) {
            return false;
        }
        DD128bTraceId dD128bTraceId = (DD128bTraceId) obj;
        return this.highOrderBits == dD128bTraceId.highOrderBits && this.lowOrderBits == dD128bTraceId.lowOrderBits;
    }

    public int hashCode() {
        long j = this.highOrderBits;
        long j2 = j ^ (j >>> 32);
        long j3 = this.lowOrderBits;
        return (int) ((j2 ^ j3) ^ (j3 >>> 32));
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toString() {
        String str = this.str;
        if (str != null) {
            return str;
        }
        String strM = UByte$$ExternalSyntheticBackport0.m(this.lowOrderBits, 10);
        this.str = strM;
        return strM;
    }
}
