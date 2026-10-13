package com.datadog.trace.api.normalize;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
final class AntPathMatcher {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    AntPathMatcher() {
    }

    public boolean isPattern(String str) {
        return (str.indexOf(42) == -1 && str.indexOf(63) == -1) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r16v0, types: [int] */
    /* JADX WARN: Type inference failed for: r16v2, types: [int] */
    /* JADX WARN: Type inference failed for: r18v0, types: [boolean] */
    public boolean match(String str, String str2) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3;
        boolean z3 = false;
        if (str2 == null || str2.startsWith(DomExceptionUtils.SEPARATOR) != str.startsWith(DomExceptionUtils.SEPARATOR)) {
            return false;
        }
        String[] strArr = tokenizeToStringArray(str, DomExceptionUtils.SEPARATOR);
        String[] strArr2 = tokenizeToStringArray(str2, DomExceptionUtils.SEPARATOR);
        int i4 = 1;
        int length = strArr.length - 1;
        int length2 = strArr2.length - 1;
        int i5 = 0;
        int i6 = 0;
        while (i5 <= length && i6 <= length2) {
            String str3 = strArr[i5];
            if ("**".equals(str3)) {
                break;
            }
            if (!matchStrings(str3, strArr2[i6])) {
                return false;
            }
            i5++;
            i6++;
        }
        if (i6 > length2) {
            if (i5 > length) {
                return str.endsWith(DomExceptionUtils.SEPARATOR) == str2.endsWith(DomExceptionUtils.SEPARATOR);
            }
            if (i5 == length && strArr[i5].equals("*") && str2.endsWith(DomExceptionUtils.SEPARATOR)) {
                return true;
            }
            while (i5 <= length) {
                if (!strArr[i5].equals("**")) {
                    return false;
                }
                i5++;
            }
            return true;
        }
        if (i5 > length) {
            return false;
        }
        while (i5 <= length && i6 <= length2) {
            String str4 = strArr[length];
            if (str4.equals("**")) {
                break;
            }
            if (!matchStrings(str4, strArr2[length2])) {
                return false;
            }
            length--;
            length2--;
        }
        if (i6 > length2) {
            while (i5 <= length) {
                if (!strArr[i5].equals("**")) {
                    return false;
                }
                i5++;
            }
            return true;
        }
        while (i5 != length && i6 <= length2) {
            int i7 = i5 + 1;
            int i8 = i7;
            while (true) {
                if (i8 > length) {
                    i8 = -1;
                    break;
                }
                if (strArr[i8].equals("**")) {
                    break;
                }
                i8++;
            }
            if (i8 == i7) {
                i5 = i7;
            } else {
                int i9 = (i8 - i5) - i4;
                int i10 = (length2 - i6) + i4;
                ?? r14 = z3;
                while (true) {
                    if (r14 > i10 - i9) {
                        z = z3;
                        i = i4;
                        i2 = -1;
                        break;
                    }
                    ?? r15 = z3;
                    while (true) {
                        if (r15 >= i9) {
                            z = z3;
                            i = i4;
                            i2 = i6 + r14;
                            break;
                        }
                        z2 = z3;
                        i3 = i4;
                        if (!matchStrings(strArr[i5 + r15 + 1], strArr2[i6 + r14 + r15])) {
                            break;
                        }
                        z3 = z2;
                        i4 = i3;
                        r15++;
                    }
                    z3 = z2;
                    i4 = i3;
                    r14++;
                }
                if (i2 == -1) {
                    return z;
                }
                i6 = i2 + i9;
                i5 = i8;
                z3 = z;
                i4 = i;
            }
        }
        boolean z4 = z3;
        ?? r18 = i4;
        while (i5 <= length) {
            if (!strArr[i5].equals("**")) {
                return z4;
            }
            i5++;
        }
        return r18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r16v0, types: [int] */
    /* JADX WARN: Type inference failed for: r16v2, types: [int] */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v9, types: [int] */
    private boolean matchStrings(String str, String str2) {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i4 = 1;
        int length = charArray.length - 1;
        int length2 = charArray2.length - 1;
        boolean z3 = false;
        for (char c : charArray) {
            if (c == '*') {
                if (length == 0) {
                    return true;
                }
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    char c2 = charArray[i5];
                    if (c2 == '*' || i6 > length2) {
                        break;
                    }
                    if (c2 != '?' && c2 != charArray2[i6]) {
                        return false;
                    }
                    i5++;
                    i6++;
                }
                if (i6 > length2) {
                    while (i5 <= length) {
                        if (charArray[i5] != '*') {
                            return false;
                        }
                        i5++;
                    }
                    return true;
                }
                while (true) {
                    char c3 = charArray[length];
                    if (c3 == '*' || i6 > length2) {
                        break;
                    }
                    if (c3 != '?' && c3 != charArray2[length2]) {
                        return false;
                    }
                    length--;
                    length2--;
                }
                if (i6 > length2) {
                    while (i5 <= length) {
                        if (charArray[i5] != '*') {
                            return false;
                        }
                        i5++;
                    }
                    return true;
                }
                while (i5 != length && i6 <= length2) {
                    int i7 = i5 + 1;
                    int i8 = i7;
                    while (true) {
                        if (i8 > length) {
                            i8 = -1;
                            break;
                        }
                        if (charArray[i8] == '*') {
                            break;
                        }
                        i8++;
                    }
                    if (i8 == i7) {
                        i5 = i7;
                    } else {
                        int i9 = (i8 - i5) - i4;
                        int i10 = (length2 - i6) + i4;
                        ?? r14 = z3;
                        while (true) {
                            if (r14 > i10 - i9) {
                                i = i4;
                                z = z3;
                                i2 = -1;
                                break;
                            }
                            ?? r15 = z3;
                            while (true) {
                                if (r15 >= i9) {
                                    i = i4;
                                    z = z3;
                                    i2 = i6 + r14;
                                    break;
                                }
                                i3 = i4;
                                char c4 = charArray[i5 + r15 + 1];
                                if (c4 != '?') {
                                    z2 = z3;
                                    if (c4 != charArray2[i6 + r14 + r15]) {
                                        break;
                                    }
                                } else {
                                    z2 = z3;
                                }
                                i4 = i3;
                                z3 = z2;
                                r15++;
                            }
                            i4 = i3;
                            z3 = z2;
                            r14++;
                        }
                        if (i2 == -1) {
                            return z;
                        }
                        i6 = i2 + i9;
                        i4 = i;
                        z3 = z;
                        i5 = i8;
                    }
                }
                ?? r17 = i4;
                boolean z4 = z3;
                while (i5 <= length) {
                    if (charArray[i5] != '*') {
                        return z4;
                    }
                    i5++;
                }
                return r17;
            }
        }
        if (length != length2) {
            return false;
        }
        for (int i11 = 0; i11 <= length; i11++) {
            char c5 = charArray[i11];
            if (c5 != '?' && c5 != charArray2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static String[] tokenizeToStringArray(String str, String str2) {
        if (str == null) {
            return EMPTY_STRING_ARRAY;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.length() > 0) {
                arrayList.add(strNextToken);
            }
        }
        return toStringArray(arrayList);
    }

    private static String[] toStringArray(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            return (String[]) collection.toArray(EMPTY_STRING_ARRAY);
        }
        return EMPTY_STRING_ARRAY;
    }
}
