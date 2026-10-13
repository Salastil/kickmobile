package com.datadog.trace.api.internal.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class LongStringUtils {
    private static final byte[] HEX_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private static final long MAX_FIRST_PART = 1844674407370955161L;

    private LongStringUtils() {
    }

    public static long parseUnsignedLongHex(CharSequence charSequence) throws NumberFormatException {
        return parseUnsignedLongHex(charSequence, 0, charSequence == null ? 0 : charSequence.length(), false);
    }

    public static long parseUnsignedLongHex(CharSequence charSequence, int i, int i2, boolean z) throws NumberFormatException {
        if (charSequence == null) {
            throw new NumberFormatException(AbstractJsonLexerKt.NULL);
        }
        if (i2 > 0 && i >= 0 && i + i2 <= charSequence.length()) {
            if (i2 > 16 && i2 - firstNonZeroCharacter(charSequence, i) > 16) {
                throw numberFormatOutOfLongRange(charSequence);
            }
            int i3 = 0;
            long j = 0;
            int i4 = 0;
            while (i3 < i2 && i4 >= 0) {
                char cCharAt = charSequence.charAt(i);
                int iDigit = Character.digit(cCharAt, 16);
                if (z && Character.isUpperCase(cCharAt)) {
                    i4 = -1;
                }
                i4 |= iDigit;
                j = (j << 4) | ((long) iDigit);
                i3++;
                i++;
            }
            if (i4 >= 0) {
                return j;
            }
            throw new NumberFormatException("Illegal character in " + ((Object) charSequence.subSequence(i, i2)));
        }
        throw new NumberFormatException("Empty input string");
    }

    private static int firstNonZeroCharacter(CharSequence charSequence, int i) {
        while (i < charSequence.length() && charSequence.charAt(i) == '0') {
            i++;
        }
        return i;
    }

    public static long parseUnsignedLong(String str) throws NumberFormatException {
        int i;
        if (str == null) {
            throw new NumberFormatException("s can't be null");
        }
        int length = str.length();
        if (length > 0) {
            int i2 = 0;
            if (str.charAt(0) == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", str));
            }
            if (length <= 18) {
                return Long.parseLong(str);
            }
            if (length > 20) {
                throw numberFormatOutOfLongRange(str);
            }
            int i3 = 0;
            long j = 0;
            while (true) {
                i = length - 1;
                if (i2 >= i) {
                    break;
                }
                int iDigit = Character.digit(str.charAt(i2), 10);
                i3 |= iDigit;
                j = (j * 10) + ((long) iDigit);
                i2++;
            }
            int iDigit2 = Character.digit(str.charAt(i), 10);
            if ((i3 | iDigit2) < 0) {
                throw new NumberFormatException("Illegal character in " + str);
            }
            if (j > MAX_FIRST_PART) {
                throw numberFormatOutOfLongRange(str);
            }
            long j2 = j * 10;
            long j3 = ((long) iDigit2) + j2;
            if (j2 >= 0 || j3 < 0) {
                return j3;
            }
            throw numberFormatOutOfLongRange(str);
        }
        throw new NumberFormatException("Empty input string");
    }

    public static NumberFormatException numberFormatOutOfLongRange(CharSequence charSequence) {
        return new NumberFormatException(String.format("String value %s exceeds range of unsigned long.", charSequence));
    }

    public static String toHexStringPadded(long j, int i) {
        byte[] bArrAllocatePaddedHexStringBytes = allocatePaddedHexStringBytes(i);
        fillStringBytesWithPaddedHexId(j, 0, bArrAllocatePaddedHexStringBytes.length, bArrAllocatePaddedHexStringBytes);
        return new String(bArrAllocatePaddedHexStringBytes, StandardCharsets.US_ASCII);
    }

    public static String toHexStringPadded(long j, long j2, int i) {
        if (i <= 16) {
            return toHexStringPadded(j2, i);
        }
        byte[] bArrAllocatePaddedHexStringBytes = allocatePaddedHexStringBytes(i);
        fillStringBytesWithPaddedHexId(j, 0, 16, bArrAllocatePaddedHexStringBytes);
        fillStringBytesWithPaddedHexId(j2, 16, 16, bArrAllocatePaddedHexStringBytes);
        return new String(bArrAllocatePaddedHexStringBytes, StandardCharsets.US_ASCII);
    }

    private static byte[] allocatePaddedHexStringBytes(int i) {
        if (i > 16) {
            i = 32;
        } else if (i < 16) {
            i = 16;
        }
        return new byte[i];
    }

    private static void fillStringBytesWithPaddedHexId(long j, int i, int i2, byte[] bArr) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) >>> 2;
        Arrays.fill(bArr, i, (i2 - 16) + i + iNumberOfLeadingZeros, (byte) 48);
        for (int i3 = 0; i3 < 16 - iNumberOfLeadingZeros; i3++) {
            bArr[((i + i2) - 1) - i3] = HEX_DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
    }
}
