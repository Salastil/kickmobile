package com.datadog.trace.util;

/* JADX INFO: loaded from: classes8.dex */
public final class PercentEscaper {
    private static final int DEST_PAD = 32;
    private static final char[] UPPER_HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String UNSAFE_CHARACTERS_KEY = "\",;\\()/:<=>?@[]{} ";
    private static final boolean[] unsafeKeyOctets = createUnsafeOctets(UNSAFE_CHARACTERS_KEY);
    private static final String UNSAFE_CHARACTERS_VALUE = "\",;\\ ";
    private static final boolean[] unsafeValOctets = createUnsafeOctets(UNSAFE_CHARACTERS_VALUE);

    public static PercentEscaper create() {
        return new PercentEscaper();
    }

    private static boolean[] createUnsafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int iMax = -1;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    public Escaped escapeKey(String str) {
        return escape(str, unsafeKeyOctets);
    }

    public Escaped escapeValue(String str) {
        return escape(str, unsafeValOctets);
    }

    private boolean needsEncoding(char c, boolean[] zArr) {
        if (c > '~' || c <= ' ') {
            return true;
        }
        return c < zArr.length && zArr[c];
    }

    private boolean needsEncoding(String str, boolean[] zArr) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (needsEncoding(str.charAt(i), zArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean keyNeedsEncoding(String str) {
        return needsEncoding(str, unsafeKeyOctets);
    }

    public boolean valNeedsEncoding(String str) {
        return needsEncoding(str, unsafeValOctets);
    }

    public Escaped escape(String str, boolean[] zArr) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (needsEncoding(str.charAt(i), zArr)) {
                return escapeSlow(str, i, zArr);
            }
        }
        return new Escaped(str, length);
    }

    private static Escaped escapeSlow(String str, int i, boolean[] zArr) {
        int length = str.length();
        char[] cArrGrowBuffer = new char[1024];
        Escaped escaped = new Escaped("", i);
        int i2 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt, escaped, zArr);
            int i3 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            if (cArrEscape != null) {
                int i4 = i - i2;
                int i5 = length2 + i4;
                int length3 = cArrEscape.length + i5;
                if (cArrGrowBuffer.length < length3) {
                    cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, length3 + (length - i) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArrGrowBuffer, length2);
                    length2 = i5;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrGrowBuffer, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i2 = i3;
            }
            i = nextEscapeIndex(str, i3, length, zArr);
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = length2 + i6;
            if (cArrGrowBuffer.length < i7) {
                cArrGrowBuffer = growBuffer(cArrGrowBuffer, length2, i7);
            }
            str.getChars(i2, length, cArrGrowBuffer, length2);
            length2 = i7;
        }
        escaped.size += i6;
        escaped.data = new String(cArrGrowBuffer, 0, length2);
        return escaped;
    }

    private static int nextEscapeIndex(CharSequence charSequence, int i, int i2, boolean[] zArr) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < zArr.length && zArr[cCharAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    private static char[] escape(int i, Escaped escaped, boolean[] zArr) {
        if (i < zArr.length && !zArr[i]) {
            return null;
        }
        if (i <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            char[] cArr2 = {'%', cArr[i >>> 4], cArr[i & 15]};
            escaped.size++;
            return cArr2;
        }
        if (i <= 2047) {
            char[] cArr3 = UPPER_HEX_DIGITS;
            char[] cArr4 = {'%', cArr3[(i >>> 10) | 12], cArr3[(i >>> 6) & 15], '%', cArr3[((i >>> 4) & 3) | 8], cArr3[i & 15]};
            escaped.size += 2;
            return cArr4;
        }
        if (i <= 65535) {
            char[] cArr5 = UPPER_HEX_DIGITS;
            char[] cArr6 = {'%', 'E', cArr5[i >>> 12], '%', cArr5[((i >>> 10) & 3) | 8], cArr5[(i >>> 6) & 15], '%', cArr5[((i >>> 4) & 3) | 8], cArr5[i & 15]};
            escaped.size += 3;
            return cArr6;
        }
        if (i <= 1114111) {
            char[] cArr7 = UPPER_HEX_DIGITS;
            char[] cArr8 = {'%', 'F', cArr7[(i >>> 18) & 7], '%', cArr7[((i >>> 16) & 3) | 8], cArr7[(i >>> 12) & 15], '%', cArr7[((i >>> 10) & 3) | 8], cArr7[(i >>> 6) & 15], '%', cArr7[((i >>> 4) & 3) | 8], cArr7[i & 15]};
            escaped.size += 4;
            return cArr8;
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i);
    }

    private static int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 55296 || cCharAt > 57343) {
                return cCharAt;
            }
            if (cCharAt > 56319) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i + " in '" + ((Object) charSequence) + "'");
            }
            if (i3 == i2) {
                return -cCharAt;
            }
            char cCharAt2 = charSequence.charAt(i3);
            if (!Character.isLowSurrogate(cCharAt2)) {
                throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i3 + " in '" + ((Object) charSequence) + "'");
            }
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    public static class Escaped {
        public String data;
        public int size;

        public Escaped(String str, int i) {
            this.data = str;
            this.size = i;
        }
    }
}
