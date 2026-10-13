package com.datadog.trace.api;

import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class MethodFilterConfigParser {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) MethodFilterConfigParser.class);

    private static Map<String, Set<String>> logWarn(String str, int i, int i2, String str2) {
        log.warn("Invalid trace method config {} in part '{}'. Must match 'package.Class$Name[method1,method2];?' or 'package.Class$Name[*];?'. Config string: '{}'", str, str2.substring(i, i2).trim(), str2);
        return Collections.EMPTY_MAP;
    }

    private static boolean hasIllegalCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '*' || cCharAt == '[' || cCharAt == ']' || cCharAt == ',') {
                return true;
            }
        }
        return false;
    }

    private static boolean isIllegalClassName(String str) {
        return hasIllegalCharacters(str);
    }

    private static boolean isIllegalMethodName(String str) {
        return !str.equals("*") && hasIllegalCharacters(str);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0117 A[PHI: r0 r4
      0x0117: PHI (r0v4 java.util.Map<java.lang.String, java.util.Set<java.lang.String>>) = 
      (r0v3 java.util.Map<java.lang.String, java.util.Set<java.lang.String>>)
      (r0v14 java.util.Map<java.lang.String, java.util.Set<java.lang.String>>)
     binds: [B:12:0x0027, B:65:0x0100] A[DONT_GENERATE, DONT_INLINE]
      0x0117: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:12:0x0027, B:65:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
    public static Map<String, Set<String>> parse(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        Map<String, Set<String>> map = new HashMap<>();
        int i = 0;
        do {
            int i2 = i + 1;
            int iIndexOf = str.indexOf(59, i2);
            int length = iIndexOf == -1 ? str.length() : iIndexOf;
            if (length > i2) {
                int iIndexOf2 = str.indexOf(91, i);
                if (iIndexOf2 != -1) {
                    if (iIndexOf2 >= length) {
                        map = logWarn("with incomplete method definition", i, length, str);
                        break;
                    }
                    int iIndexOf3 = str.indexOf(93, iIndexOf2);
                    if (iIndexOf3 == -1 || iIndexOf3 > length) {
                        map = logWarn("does not contain a ']'", i, length, str);
                        break;
                    }
                    if (iIndexOf3 < length && !str.substring(iIndexOf3 + 1, length).trim().isEmpty()) {
                        map = logWarn("with extra characters after ']'", i, length, str);
                        break;
                    }
                    String strTrim = str.substring(i, iIndexOf2).trim();
                    if (strTrim.isEmpty() || isIllegalClassName(strTrim)) {
                        map = logWarn("with illegal class name", i, length, str);
                        break;
                    }
                    Set<String> hashSet = map.get(strTrim);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(strTrim, hashSet);
                    }
                    int i3 = iIndexOf2 + 1;
                    int i4 = 0;
                    int i5 = 0;
                    boolean z = false;
                    while (true) {
                        if (i3 < iIndexOf3) {
                            int iIndexOf4 = str.indexOf(44, i3);
                            if (iIndexOf4 == -1 || iIndexOf4 >= iIndexOf3) {
                                iIndexOf4 = iIndexOf3;
                            }
                            String strTrim2 = str.substring(i3, iIndexOf4).trim();
                            if (isIllegalMethodName(strTrim2)) {
                                map = logWarn("with illegal method name", i, length, str);
                            } else {
                                if (strTrim2.isEmpty()) {
                                    i5++;
                                    if (i5 > 1) {
                                        map = logWarn("with multiple emtpy method names", i, length, str);
                                    }
                                } else {
                                    i4++;
                                    if (i5 > 0) {
                                        map = logWarn("with method name and emtpy method name", i, length, str);
                                    } else {
                                        z |= strTrim2.indexOf(42) != -1;
                                        if (z && i4 > 1) {
                                            map = logWarn("with both method name and '*'", i, length, str);
                                        } else {
                                            hashSet.add(strTrim2);
                                        }
                                    }
                                    iIndexOf = -1;
                                }
                                i3 = iIndexOf4 + 1;
                            }
                            i4++;
                            iIndexOf = -1;
                        }
                        if (i4 == 0) {
                            map = logWarn("with empty method definition", i, length, str);
                            break;
                        }
                        i = iIndexOf + 1;
                    }
                } else {
                    if (!str.substring(i).trim().isEmpty()) {
                        map = logWarn("with incomplete definition", i, length, str);
                        break;
                    }
                    break;
                }
            } else {
                i = iIndexOf + 1;
            }
        } while (i != 0);
        return Collections.unmodifiableMap(map);
    }
}
