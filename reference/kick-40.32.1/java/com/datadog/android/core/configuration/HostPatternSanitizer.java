package com.datadog.android.core.configuration;

import com.datadog.android.api.InternalLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: HostPatternSanitizer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/configuration/HostPatternSanitizer;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "targetsSubdomainOfDomain", "", "lowercased", "", "validate", "", "patterns", "feature", "validatePattern", "pattern", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HostPatternSanitizer {
    public static final String ERROR_INVALID_CHARACTERS = "You are using a malformed host pattern \"%s\" to setup %s tracking. It will be dropped. A host pattern may only contain lowercase letters, digits, '.', '-' and a single '*' wildcard.";
    public static final String ERROR_MULTIPLE_WILDCARDS = "You are using a host pattern \"%s\" with more than one wildcard to setup %s tracking. It will be dropped. A host pattern may contain at most one '*' wildcard.";
    public static final String ERROR_WILDCARD_NOT_SUBDOMAIN = "You are using a host pattern \"%s\" to setup %s tracking, but a wildcard may only match subdomains of a registrable domain. It will be dropped. Patterns such as '*', '*.com', '*.co.uk' or '*example.com' are too broad; use a pattern like '*.example.com' instead.";
    private static final String LABEL_SEPARATOR = ".";
    private static final char WILDCARD = '*';
    private final InternalLogger internalLogger;
    private static final Regex INVALID_CHARACTER = new Regex("[^a-z0-9.*-]");

    public HostPatternSanitizer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final List<String> validate(List<String> patterns, String feature) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        Intrinsics.checkNotNullParameter(feature, "feature");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = patterns.iterator();
        while (it.hasNext()) {
            String strValidatePattern = validatePattern((String) it.next(), feature);
            if (strValidatePattern != null) {
                arrayList.add(strValidatePattern);
            }
        }
        return arrayList;
    }

    private final String validatePattern(final String pattern, final String feature) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = pattern.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        if (INVALID_CHARACTER.containsMatchIn(str)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostPatternSanitizer.validatePattern.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, HostPatternSanitizer.ERROR_INVALID_CHARACTERS, Arrays.copyOf(new Object[]{pattern, feature}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '*') {
                i++;
            }
        }
        if (i > 1) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostPatternSanitizer.validatePattern.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, HostPatternSanitizer.ERROR_MULTIPLE_WILDCARDS, Arrays.copyOf(new Object[]{pattern, feature}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (!StringsKt.contains$default((CharSequence) str, '*', false, 2, (Object) null) || targetsSubdomainOfDomain(lowerCase)) {
            return pattern;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostPatternSanitizer.validatePattern.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str2 = String.format(Locale.US, HostPatternSanitizer.ERROR_WILDCARD_NOT_SUBDOMAIN, Arrays.copyOf(new Object[]{pattern, feature}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    private final boolean targetsSubdomainOfDomain(String lowercased) {
        String strSubstringAfter$default = StringsKt.substringAfter$default(lowercased, '*', (String) null, 2, (Object) null);
        if (!StringsKt.startsWith$default(strSubstringAfter$default, LABEL_SEPARATOR, false, 2, (Object) null)) {
            return false;
        }
        String strRemovePrefix = StringsKt.removePrefix(strSubstringAfter$default, (CharSequence) LABEL_SEPARATOR);
        HttpUrl httpUrl = HttpUrl.INSTANCE.parse("https://" + strRemovePrefix);
        return (httpUrl != null ? httpUrl.topPrivateDomain() : null) != null;
    }
}
