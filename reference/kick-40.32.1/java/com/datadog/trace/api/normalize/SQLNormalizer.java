package com.datadog.trace.api.normalize;

import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLNormalizer {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) SQLNormalizer.class);
    private static final BitSet NUMERIC_LITERAL_PREFIX = new BitSet();
    private static final BitSet SPLITTERS = new BitSet();

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 43, 46};
        for (int i = 0; i < 13; i++) {
            NUMERIC_LITERAL_PREFIX.set(bArr[i] & 255);
        }
        byte[] bArr2 = {44, 40, 41, 124};
        for (int i2 = 0; i2 < 4; i2++) {
            SPLITTERS.set(bArr2[i2] & 255);
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (Character.isWhitespace((char) i3)) {
                SPLITTERS.set(i3);
            }
        }
    }

    public static UTF8BytesString normalizeCharSequence(CharSequence charSequence) {
        return normalize(charSequence.toString());
    }

    public static UTF8BytesString normalize(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        try {
            BitSet bitSetFindSplitterPositions = findSplitterPositions(bytes);
            int length = bytes.length;
            int iPreviousSetBit = length > 0 ? bitSetFindSplitterPositions.previousSetBit(length - 1) : -1;
            boolean z = false;
            int i = length;
            while (length > 0 && iPreviousSetBit > 0) {
                int i2 = iPreviousSetBit + 1;
                int i3 = length - 1;
                if (i3 == i2) {
                    if (Character.isDigit(bytes[i2])) {
                        bytes[i2] = 63;
                        z = true;
                    }
                } else if (i2 < i3 && (isQuoted(bytes, i2, i3) || isNumericLiteralPrefix(bytes, i2) || isHexLiteralPrefix(bytes, i2, i3))) {
                    System.arraycopy(bytes, length, bytes, iPreviousSetBit + 2, i - length);
                    bytes[i2] = 63;
                    i -= i3 - i2;
                    z = true;
                }
                int i4 = iPreviousSetBit;
                iPreviousSetBit = bitSetFindSplitterPositions.previousSetBit(iPreviousSetBit - 1);
                length = i4;
            }
            if (z) {
                return UTF8BytesString.create(Arrays.copyOf(bytes, i));
            }
        } catch (Throwable th) {
            log.debug("Error normalizing sql {}", str, th);
        }
        return UTF8BytesString.create(str, bytes);
    }

    private static boolean isQuoted(byte[] bArr, int i, int i2) {
        return bArr[i] == 39 && bArr[i2] == 39;
    }

    private static boolean isHexLiteralPrefix(byte[] bArr, int i, int i2) {
        int i3;
        return (bArr[i] | 32) == 120 && (i3 = i + 1) < i2 && bArr[i3] == 39;
    }

    private static boolean isNumericLiteralPrefix(byte[] bArr, int i) {
        if (NUMERIC_LITERAL_PREFIX.get(bArr[i] & 255)) {
            return (bArr[i + 1] == 45 && bArr[i] == 45) ? false : true;
        }
        return false;
    }

    private static boolean isSplitter(byte b) {
        return SPLITTERS.get(b & 255);
    }

    private static BitSet findSplitterPositions(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            if (b != 39 || z) {
                z = (!z) & (b == 92);
                bitSet.set(i, isSplitter(b) & (!z2));
            } else {
                z2 = !z2;
            }
        }
        return bitSet;
    }
}
