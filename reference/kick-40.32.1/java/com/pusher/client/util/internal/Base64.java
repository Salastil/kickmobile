package com.pusher.client.util.internal;

import io.ktor.util.date.GMTDateParser;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes8.dex */
public class Base64 {
    private static final char[] CHAR_INDEX_TABLE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', GMTDateParser.YEAR, Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final int[] charToIndexSparseMappingArray;

    static {
        int[] iArr = new int[128];
        charToIndexSparseMappingArray = iArr;
        Arrays.fill(iArr, -1);
        int i = 0;
        while (true) {
            char[] cArr = CHAR_INDEX_TABLE;
            if (i >= cArr.length) {
                return;
            }
            charToIndexSparseMappingArray[cArr[i]] = i;
            i++;
        }
    }

    private static int toInt(char c) {
        int i = charToIndexSparseMappingArray[c];
        if (i != -1) {
            return i;
        }
        throw new IllegalArgumentException("invalid char: " + c);
    }

    public static byte[] decode(String str) {
        int length = ((str.length() * 3) / 4) - (str.endsWith("==") ? 2 : str.endsWith("=") ? 1 : 0);
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2 += 4) {
            int i3 = toInt(str.charAt(i2));
            int i4 = toInt(str.charAt(i2 + 1));
            int i5 = i + 1;
            bArr[i] = (byte) (((i3 << 2) | (i4 >> 4)) & 255);
            if (i5 >= length) {
                break;
            }
            int i6 = toInt(str.charAt(i2 + 2));
            int i7 = i + 2;
            bArr[i5] = (byte) (((i4 << 4) | (i6 >> 2)) & 255);
            if (i7 >= length) {
                break;
            }
            i += 3;
            bArr[i7] = (byte) (((i6 << 6) | toInt(str.charAt(i2 + 3))) & 255);
        }
        return bArr;
    }
}
