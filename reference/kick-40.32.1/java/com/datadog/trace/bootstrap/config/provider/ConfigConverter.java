package com.datadog.trace.bootstrap.config.provider;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.Strings;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
final class ConfigConverter {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ConfigConverter.class);

    ConfigConverter() {
    }

    static <T> T valueOf(String str, Class<T> cls) {
        Objects.requireNonNull(cls, "tClass is marked non-null but is null");
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        try {
            if (cls == Boolean.class) {
                return (T) Boolean.valueOf(str);
            }
            if (cls == Integer.class) {
                return (T) Integer.valueOf(str);
            }
            if (cls == Long.class) {
                return (T) Long.valueOf(str);
            }
            if (cls == Double.class) {
                return (T) Double.valueOf(str);
            }
            if (cls == Float.class) {
                return (T) Float.valueOf(str);
            }
            return null;
        } catch (NumberFormatException e) {
            throw e;
        } catch (Throwable th) {
            log.debug("Can't parse: ", th);
            throw new NumberFormatException(th.toString());
        }
    }

    static List<String> parseList(String str) {
        return parseList(str, WebViewLogEventConsumer.DDTAGS_SEPARATOR);
    }

    static List<String> parseList(String str, String str2) {
        String strTrim = Strings.trim(str);
        if (strTrim.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        String[] strArrSplit = strTrim.split(str2, -1);
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].trim();
        }
        return Collections.unmodifiableList(Arrays.asList(strArrSplit));
    }

    static Map<String, String> parseMap(String str, String str2) {
        return parseMap(str, str2, AbstractJsonLexerKt.COLON);
    }

    static Map<String, String> parseMap(String str, String str2, char c) {
        String strTrim = Strings.trim(str);
        if (strTrim.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        loadMap(map, strTrim, str2, c);
        return map;
    }

    static Map<String, String> parseMapWithOptionalMappings(String str, String str2, String str3, boolean z) {
        String strTrim = Strings.trim(str);
        if (strTrim.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        loadMapWithOptionalMapping(map, strTrim, str2, str3, z);
        return map;
    }

    static Map<String, String> parseOrderedMap(String str, String str2) {
        String strTrim = Strings.trim(str);
        if (strTrim.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loadMap(linkedHashMap, strTrim, str2, AbstractJsonLexerKt.COLON);
        return linkedHashMap;
    }

    private static final class BadFormatException extends Exception {
        public BadFormatException(String str) {
            super(str);
        }
    }

    private static void loadMap(Map<String, String> map, String str, String str2, char c) {
        int i = 0;
        try {
            int iIndexOf = str.indexOf(c, 0);
            while (iIndexOf != -1) {
                int i2 = iIndexOf + 1;
                int iIndexOf2 = str.indexOf(c, i2);
                int iIndexOf3 = str.indexOf(44, i2);
                if (iIndexOf3 == -1) {
                    iIndexOf3 = str.length();
                }
                int iIndexOf4 = str.indexOf(32, i2);
                if (iIndexOf4 == -1) {
                    iIndexOf4 = str.length();
                }
                int i3 = iIndexOf3 < str.length() ? iIndexOf3 : iIndexOf4;
                while (iIndexOf2 != -1 && iIndexOf2 < i3) {
                    iIndexOf2 = str.indexOf(c, iIndexOf2 + 1);
                }
                if (iIndexOf2 == -1) {
                    if (iIndexOf3 < str.length() - 1) {
                        throw new BadFormatException("Non white space characters after trailing ','");
                    }
                } else if (iIndexOf3 >= str.length()) {
                    if (iIndexOf4 >= str.length()) {
                        throw new BadFormatException("Illegal position of split character ':'");
                    }
                    iIndexOf3 = iIndexOf4;
                }
                String strTrim = str.substring(i, iIndexOf).trim();
                if (strTrim.indexOf(44) != -1) {
                    throw new BadFormatException("Illegal ',' character in key '" + strTrim + "'");
                }
                String strTrim2 = str.substring(i2, iIndexOf3).trim();
                if (strTrim2.indexOf(32) != -1) {
                    throw new BadFormatException("Illegal ' ' character in value for key '" + strTrim + "'");
                }
                if (!strTrim.isEmpty() && !strTrim2.isEmpty()) {
                    map.put(strTrim, strTrim2);
                }
                i = iIndexOf3 + 1;
                iIndexOf = iIndexOf2;
            }
        } catch (Throwable th) {
            if (th instanceof BadFormatException) {
                log.warn("Invalid config for {}. {}. Must match 'key1{}value1,key2{}value2' or 'key1{}value1 key2{}value2'.", str2, th.getMessage(), Character.valueOf(c), Character.valueOf(c), Character.valueOf(c), Character.valueOf(c));
            } else {
                log.warn("Unexpected exception during config parsing of {}.", str2, th);
            }
            map.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007d A[Catch: all -> 0x0007, TRY_LEAVE, TryCatch #0 {all -> 0x0007, blocks: (B:7:0x000a, B:9:0x0010, B:11:0x0016, B:12:0x0025, B:17:0x0038, B:36:0x007d, B:41:0x008d, B:43:0x0097, B:46:0x00a2, B:47:0x00bb, B:51:0x00d9, B:53:0x00df, B:48:0x00bc, B:50:0x00c6, B:54:0x00e3, B:55:0x00fc, B:27:0x0054, B:33:0x0064, B:34:0x007a, B:22:0x0049), top: B:64:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bc A[Catch: all -> 0x0007, TryCatch #0 {all -> 0x0007, blocks: (B:7:0x000a, B:9:0x0010, B:11:0x0016, B:12:0x0025, B:17:0x0038, B:36:0x007d, B:41:0x008d, B:43:0x0097, B:46:0x00a2, B:47:0x00bb, B:51:0x00d9, B:53:0x00df, B:48:0x00bc, B:50:0x00c6, B:54:0x00e3, B:55:0x00fc, B:27:0x0054, B:33:0x0064, B:34:0x007a, B:22:0x0049), top: B:64:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6 A[Catch: all -> 0x0007, TryCatch #0 {all -> 0x0007, blocks: (B:7:0x000a, B:9:0x0010, B:11:0x0016, B:12:0x0025, B:17:0x0038, B:36:0x007d, B:41:0x008d, B:43:0x0097, B:46:0x00a2, B:47:0x00bb, B:51:0x00d9, B:53:0x00df, B:48:0x00bc, B:50:0x00c6, B:54:0x00e3, B:55:0x00fc, B:27:0x0054, B:33:0x0064, B:34:0x007a, B:22:0x0049), top: B:64:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00df A[Catch: all -> 0x0007, TryCatch #0 {all -> 0x0007, blocks: (B:7:0x000a, B:9:0x0010, B:11:0x0016, B:12:0x0025, B:17:0x0038, B:36:0x007d, B:41:0x008d, B:43:0x0097, B:46:0x00a2, B:47:0x00bb, B:51:0x00d9, B:53:0x00df, B:48:0x00bc, B:50:0x00c6, B:54:0x00e3, B:55:0x00fc, B:27:0x0054, B:33:0x0064, B:34:0x007a, B:22:0x0049), top: B:64:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x00c6, please report this as an issue */
    private static void loadMapWithOptionalMapping(Map<String, String> map, String str, String str2, String str3, boolean z) {
        int i;
        String strTrimmedHeader;
        String strTrimmedHeader2;
        if (str3 == null) {
            str3 = "";
        }
        try {
            if (!str3.isEmpty() && !str3.endsWith(".")) {
                str3 = str3 + ".";
            }
            int length = str.length();
            int i2 = str.indexOf(44) == -1 ? 32 : 44;
            int i3 = 0;
            while (i3 < length) {
                int iIndexOf = str.indexOf(i2, i3);
                int iIndexOf2 = str.indexOf(58, i3);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf == -1) {
                    iIndexOf = length;
                } else {
                    if (iIndexOf == iIndexOf2) {
                        int iIndexOf3 = str.indexOf(i2, iIndexOf + 1);
                        if (iIndexOf2 == i3) {
                            throw new BadFormatException("Illegal empty key at position " + i3);
                        }
                        if (iIndexOf3 == -1) {
                            iIndexOf3 = length;
                        }
                        int i4 = iIndexOf3;
                        i = iIndexOf;
                        iIndexOf = i4;
                    }
                    if (i3 != iIndexOf) {
                        strTrimmedHeader = trimmedHeader(str, i3, i, z);
                        if (strTrimmedHeader.isEmpty()) {
                            continue;
                        } else {
                            if (i == iIndexOf2) {
                                strTrimmedHeader2 = trimmedHeader(str, i + 1, iIndexOf, false);
                                if (!strTrimmedHeader2.isEmpty() && !Character.isLetter(strTrimmedHeader2.charAt(0))) {
                                    throw new BadFormatException("Illegal tag starting with non letter for key '" + strTrimmedHeader + "'");
                                }
                            } else {
                                if (Character.isLetter(strTrimmedHeader.charAt(0))) {
                                    throw new BadFormatException("Illegal key only tag starting with non letter '" + strTrimmedHeader + "'");
                                }
                                strTrimmedHeader2 = str3 + Strings.normalizedHeaderTag(strTrimmedHeader);
                            }
                            if (!strTrimmedHeader2.isEmpty()) {
                                map.put(strTrimmedHeader, strTrimmedHeader2);
                            }
                        }
                    }
                    i3 = iIndexOf + 1;
                }
                i = iIndexOf;
                if (i3 != iIndexOf) {
                    strTrimmedHeader = trimmedHeader(str, i3, i, z);
                    if (strTrimmedHeader.isEmpty()) {
                        continue;
                    } else {
                        if (i == iIndexOf2) {
                            strTrimmedHeader2 = trimmedHeader(str, i + 1, iIndexOf, false);
                            if (!strTrimmedHeader2.isEmpty()) {
                                throw new BadFormatException("Illegal tag starting with non letter for key '" + strTrimmedHeader + "'");
                            }
                        } else {
                            if (Character.isLetter(strTrimmedHeader.charAt(0))) {
                                throw new BadFormatException("Illegal key only tag starting with non letter '" + strTrimmedHeader + "'");
                            }
                            strTrimmedHeader2 = str3 + Strings.normalizedHeaderTag(strTrimmedHeader);
                        }
                        if (!strTrimmedHeader2.isEmpty()) {
                            map.put(strTrimmedHeader, strTrimmedHeader2);
                        }
                    }
                }
                i3 = iIndexOf + 1;
            }
        } catch (Throwable th) {
            if (th instanceof BadFormatException) {
                log.warn("Invalid config for {}. {}. Must match '(key:value|key)([ ,](key:value|key))*'.", str2, th.getMessage());
            } else {
                log.warn("Unexpected exception during config parsing of {}.", str2, th);
            }
            map.clear();
        }
    }

    private static String trimmedHeader(String str, int i, int i2, boolean z) {
        if (i >= i2) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i2 - i);
        int i3 = -1;
        int i4 = -1;
        for (int i5 = i; i5 < i2; i5++) {
            char cCharAt = str.charAt(i5);
            if (z) {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            if (Character.isWhitespace(cCharAt)) {
                sb.append(' ');
            } else {
                if (i3 == -1) {
                    i3 = i5;
                }
                sb.append(cCharAt);
                i4 = i5;
            }
        }
        if (i3 == -1) {
            return "";
        }
        return sb.substring(i3 - i, (i4 - i) + 1);
    }

    static BitSet parseIntegerRangeSet(String str, String str2) throws NumberFormatException {
        String strReplaceAll = str.replaceAll("\\s", "");
        if (!strReplaceAll.matches("\\d{1,3}(?:-\\d{1,3})?(?:,\\d{1,3}(?:-\\d{1,3})?)*")) {
            log.warn("Invalid config for {}: '{}'. Must be formatted like '400-403,405,410-499'.", str2, strReplaceAll);
            throw new NumberFormatException();
        }
        BitSet bitSet = new BitSet(Integer.parseInt(strReplaceAll.substring(Math.max(strReplaceAll.lastIndexOf(44), strReplaceAll.lastIndexOf(45)) + 1)));
        for (String str3 : strReplaceAll.split(WebViewLogEventConsumer.DDTAGS_SEPARATOR, -1)) {
            int iIndexOf = str3.indexOf(45);
            if (iIndexOf == -1) {
                bitSet.set(Integer.parseInt(str3));
            } else if (iIndexOf > 0) {
                int i = Integer.parseInt(str3.substring(0, iIndexOf));
                int i2 = Integer.parseInt(str3.substring(iIndexOf + 1));
                bitSet.set(Math.min(i, i2), Math.max(i, i2) + 1);
            }
        }
        return bitSet;
    }

    public static Boolean booleanValueOf(String str) {
        if ("1".equals(str)) {
            return Boolean.TRUE;
        }
        return Boolean.valueOf(str);
    }

    public static String renderIntegerRange(BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(i);
            if (iNextSetBit >= 0) {
                int iNextClearBit = bitSet.nextClearBit(iNextSetBit);
                if (sb.length() > 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                if (iNextSetBit < iNextClearBit - 1) {
                    sb.append(iNextSetBit);
                    sb.append('-');
                    sb.append(iNextClearBit);
                } else {
                    sb.append(iNextSetBit);
                }
                i = iNextClearBit;
            } else {
                return sb.toString();
            }
        }
    }
}
