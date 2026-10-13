package com.google.re2j;

/* JADX INFO: loaded from: classes10.dex */
class Unicode {
    static final int MAX_ASCII = 127;
    static final int MAX_FOLD = 66639;
    static final int MAX_LATIN1 = 255;
    static final int MAX_RUNE = 1114111;
    static final int MIN_FOLD = 65;

    private static boolean is32(int[][] iArr, int i) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = ((length - i2) / 2) + i2;
            int[] iArr2 = iArr[i3];
            int i4 = iArr2[0];
            if (i4 <= i && i <= iArr2[1]) {
                return (i - i4) % iArr2[2] == 0;
            }
            if (i < i4) {
                length = i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return false;
    }

    private static boolean is(int[][] iArr, int i) {
        if (i > 255) {
            return iArr.length > 0 && i >= iArr[0][0] && is32(iArr, i);
        }
        for (int[] iArr2 : iArr) {
            if (i <= iArr2[1]) {
                int i2 = iArr2[0];
                if (i >= i2 && (i - i2) % iArr2[2] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isUpper(int i) {
        if (i <= 255) {
            return Character.isUpperCase((char) i);
        }
        return is(UnicodeTables.Upper, i);
    }

    static boolean isPrint(int i) {
        if (i <= 255) {
            return (i >= 32 && i < 127) || (i >= 161 && i != 173);
        }
        return is(UnicodeTables.L, i) || is(UnicodeTables.M, i) || is(UnicodeTables.N, i) || is(UnicodeTables.P, i) || is(UnicodeTables.S, i);
    }

    static int simpleFold(int i) {
        if (i < UnicodeTables.CASE_ORBIT.length && UnicodeTables.CASE_ORBIT[i] != 0) {
            return UnicodeTables.CASE_ORBIT[i];
        }
        int lowerCase = Characters.toLowerCase(i);
        return lowerCase != i ? lowerCase : Characters.toUpperCase(i);
    }

    private Unicode() {
    }
}
