package com.datadog.trace.api.normalize;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.trace.internal.ApmNetworkInstrumentation;
import com.datadog.trace.api.Config;

/* JADX INFO: loaded from: classes6.dex */
public final class SimpleHttpPathNormalizer extends HttpPathNormalizer {
    private static boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }

    SimpleHttpPathNormalizer() {
    }

    @Override // com.datadog.trace.api.normalize.HttpPathNormalizer
    public String normalize(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return DomExceptionUtils.SEPARATOR;
        }
        boolean z2 = !z && Config.get().isHttpServerDecodedResourcePreserveSpaces();
        StringBuilder sbEnsureStringBuilder = null;
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iIndexOf = str.indexOf(47, i);
            if (iIndexOf != i) {
                int length = iIndexOf == -1 ? str.length() : iIndexOf;
                int i3 = length - i;
                if (i3 > 3 || i3 <= 1 || (str.charAt(i) | ' ') != 118) {
                    int length2 = sbEnsureStringBuilder != null ? sbEnsureStringBuilder.length() : i;
                    boolean z3 = false;
                    while (i < length && !z3) {
                        char cCharAt = str.charAt(i);
                        if (z && cCharAt == '%') {
                            i2 = 3;
                        }
                        i2--;
                        boolean z4 = i2 < 0 && isDigit(cCharAt);
                        if (!z4) {
                            if (Character.isWhitespace(cCharAt)) {
                                sbEnsureStringBuilder = ensureStringBuilder(sbEnsureStringBuilder, str, i);
                                if (z2 && sbEnsureStringBuilder.length() > 0) {
                                    sbEnsureStringBuilder.append(cCharAt);
                                }
                            } else if (sbEnsureStringBuilder != null) {
                                sbEnsureStringBuilder.append(cCharAt);
                            }
                        }
                        i++;
                        z3 = z4;
                    }
                    if (z3) {
                        sbEnsureStringBuilder = ensureStringBuilder(sbEnsureStringBuilder, str, length2);
                        sbEnsureStringBuilder.setLength(length2);
                        sbEnsureStringBuilder.append(ApmNetworkInstrumentation.URL_QUERY_PARAMS_BLOCK_SEPARATOR);
                    }
                } else {
                    boolean zIsDigit = true;
                    for (int i4 = i + 1; i4 < length; i4++) {
                        zIsDigit &= isDigit(str.charAt(i4));
                    }
                    if (!zIsDigit) {
                        sbEnsureStringBuilder = ensureStringBuilder(sbEnsureStringBuilder, str, i);
                        sbEnsureStringBuilder.append(ApmNetworkInstrumentation.URL_QUERY_PARAMS_BLOCK_SEPARATOR);
                    } else if (sbEnsureStringBuilder != null) {
                        sbEnsureStringBuilder.append((CharSequence) str, i, length);
                    }
                }
                i = length + 1;
            } else {
                i++;
            }
            if (iIndexOf != -1 && sbEnsureStringBuilder != null) {
                sbEnsureStringBuilder.append('/');
            }
        }
        if (sbEnsureStringBuilder == null) {
            return str;
        }
        return sbEnsureStringBuilder.length() == 0 ? DomExceptionUtils.SEPARATOR : sbEnsureStringBuilder.toString();
    }

    private static StringBuilder ensureStringBuilder(StringBuilder sb, String str, int i) {
        if (sb != null) {
            return sb;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str, 0, i);
        return sb2;
    }
}
