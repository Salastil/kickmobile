package com.datadog.trace.util;

import com.datadog.trace.api.Config;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class Strings {
    public static String toEnvVar(String str) {
        return str.replace(FilenameUtils.EXTENSION_SEPARATOR, '_').replace('-', '_').toUpperCase(Locale.US);
    }

    public static String join(CharSequence charSequence, CharSequence... charSequenceArr) {
        int length = charSequenceArr.length;
        if (length <= 0) {
            return "";
        }
        if (length == 1) {
            return charSequenceArr[0].toString();
        }
        StringBuilder sb = new StringBuilder(charSequenceArr[0]);
        for (int i = 1; i < length; i++) {
            sb.append(charSequence);
            sb.append(charSequenceArr[i]);
        }
        return sb.toString();
    }

    public static String replace(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        int length = 0;
        while (true) {
            int iIndexOf = sb.indexOf(str2, length);
            if (iIndexOf != -1) {
                sb.replace(iIndexOf, str2.length() + iIndexOf, str3);
                length = iIndexOf + str3.length();
            } else {
                return sb.toString();
            }
        }
    }

    public static String replaceFirst(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        int iIndexOf = sb.indexOf(str2);
        if (iIndexOf != -1) {
            sb.replace(iIndexOf, str2.length() + iIndexOf, str3);
        }
        return sb.toString();
    }

    public static String propertyNameToEnvironmentVariableName(String str) {
        return "DD_" + toEnvVar(str);
    }

    public static String systemPropertyNameToEnvironmentVariableName(String str) {
        return str.replace(FilenameUtils.EXTENSION_SEPARATOR, '_').replace('-', '_').toUpperCase(Locale.US);
    }

    public static String propertyNameToSystemPropertyName(String str) {
        return Config.PREFIX + str;
    }

    public static String normalizedHeaderTag(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isWhitespace(cCharAt)) {
                sb.append('_');
            } else {
                if (i == -1) {
                    i = i3;
                }
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '_' || cCharAt == '-' || cCharAt == '/') {
                    sb.append(Character.toLowerCase(cCharAt));
                } else {
                    sb.append('_');
                }
                i2 = i3;
            }
        }
        return i == -1 ? "" : sb.substring(i, i2 + 1);
    }

    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    private static String hex(char c) {
        return Integer.toHexString(c).toUpperCase(Locale.US);
    }

    public static String sha256(String str) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        for (byte b : bArrDigest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String random(int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) (ThreadLocalRandom.current().nextInt(26) + 97);
        }
        return new String(cArr);
    }
}
