package com.facebook.common.util;

import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: Hex.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/common/util/Hex;", "", "<init>", "()V", "HEX_DIGITS", "", "FIRST_CHAR", "SECOND_CHAR", "DIGITS", "", "byte2Hex", "", "value", "", "encodeHex", "array", "zeroTerminated", "", "decodeHex", "hexString", "hexStringToByteArray", "s", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Hex {
    private static final byte[] DIGITS;
    public static final Hex INSTANCE = new Hex();
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] FIRST_CHAR = new char[256];
    private static final char[] SECOND_CHAR = new char[256];

    private Hex() {
    }

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(i >> 4) & 15];
            SECOND_CHAR[i] = cArr2[i & 15];
        }
        DIGITS = new byte[103];
        for (int i2 = 0; i2 <= 70; i2++) {
            DIGITS[i2] = -1;
        }
        for (int i3 = 0; i3 < 10; i3++) {
            DIGITS[i3 + 48] = (byte) i3;
        }
        for (int i4 = 0; i4 < 6; i4++) {
            byte[] bArr = DIGITS;
            byte b = (byte) (i4 + 10);
            bArr[i4 + 65] = b;
            bArr[i4 + 97] = b;
        }
    }

    @JvmStatic
    public static final String byte2Hex(int value) {
        if (value > 255 || value < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255".toString());
        }
        char c = FIRST_CHAR[value];
        char c2 = SECOND_CHAR[value];
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(c2);
        return sb.toString();
    }

    @JvmStatic
    public static final String encodeHex(byte[] array, boolean zeroTerminated) {
        Intrinsics.checkNotNullParameter(array, "array");
        char[] cArr = new char[array.length * 2];
        int i = 0;
        for (byte b : array) {
            int i2 = b & 255;
            if (i2 == 0 && zeroTerminated) {
                break;
            }
            int i3 = i + 1;
            cArr[i] = FIRST_CHAR[i2];
            i += 2;
            cArr[i3] = SECOND_CHAR[i2];
        }
        return new String(cArr, 0, i);
    }

    @JvmStatic
    public static final byte[] decodeHex(String hexString) {
        byte[] bArr;
        byte b;
        byte b2;
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        int length = hexString.length();
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.".toString());
        }
        byte[] bArr2 = new byte[length >> 1];
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = hexString.charAt(i);
            if (cCharAt <= 'f' && (b = (bArr = DIGITS)[cCharAt]) != -1) {
                i += 2;
                char cCharAt2 = hexString.charAt(i3);
                if (cCharAt2 <= 'f' && (b2 = bArr[cCharAt2]) != -1) {
                    bArr2[i2] = (byte) (b2 | (b << 4));
                    i2++;
                }
            }
            z = true;
            break;
        }
        if (!z) {
            return bArr2;
        }
        throw new IllegalArgumentException(("Invalid hexadecimal digit: " + hexString).toString());
    }

    @JvmStatic
    public static final byte[] hexStringToByteArray(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return decodeHex(new Regex(ServerSentEventKt.SPACE).replace(s, ""));
    }
}
