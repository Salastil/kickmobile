package com.datadog.android.core.configuration;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import io.ktor.util.date.GMTDateParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HostsSanitizer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0007J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/core/configuration/HostsSanitizer;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "sanitizeHosts", "", "", "hosts", "feature", "sanitizePatterns", "patterns", "sanitizePlainHosts", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HostsSanitizer {
    public static final String ERROR_MALFORMED_HOST_IP_ADDRESS = "You are using a malformed host or ip address \"%s\" to setup %s tracking. It will be dropped.";
    public static final String ERROR_MALFORMED_URL = "You are using a malformed url \"%s\" to setup %s tracking. It will be dropped. Please try using a host name instead, e.g.: \"example.com\"";
    private static final String URL_REGEX = "^(http|https)://(.*)";
    private static final String VALID_DOMAIN_REGEX = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)+([A-Za-z]|[A-Za-z][A-Za-z0-9-]*[A-Za-z0-9])$";
    private static final String VALID_HOSTNAME_REGEX = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$|^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)+([A-Za-z]|[A-Za-z][A-Za-z0-9-]*[A-Za-z0-9])$";
    private static final String VALID_IP_REGEX = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    public static final String WARNING_USING_URL = "You are using a url \"%s\" instead of a host to setup %s tracking. You should use instead a valid host name: \"%s\"";
    private final InternalLogger internalLogger;

    /* JADX WARN: Multi-variable type inference failed */
    public HostsSanitizer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HostsSanitizer(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ HostsSanitizer(InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RuntimeUtilsKt.getUnboundInternalLogger() : internalLogger);
    }

    public final List<String> sanitizeHosts(List<String> hosts, String feature) {
        Intrinsics.checkNotNullParameter(hosts, "hosts");
        Intrinsics.checkNotNullParameter(feature, "feature");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : hosts) {
            if (StringsKt.contains$default((CharSequence) obj, GMTDateParser.ANY, false, 2, (Object) null)) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return CollectionsKt.plus((Collection) sanitizePlainHosts((List) pair.component2(), feature), (Iterable) sanitizePatterns((List) pair.component1(), feature));
    }

    private final List<String> sanitizePlainHosts(List<String> hosts, final String feature) {
        Regex regex = new Regex(VALID_HOSTNAME_REGEX);
        Regex regex2 = new Regex(URL_REGEX);
        ArrayList arrayList = new ArrayList();
        for (final String host : hosts) {
            String str = host;
            if (regex2.matches(str)) {
                try {
                    final URL url = new URL(host);
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizePlainHosts$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str2 = String.format(Locale.US, HostsSanitizer.WARNING_USING_URL, Arrays.copyOf(new Object[]{host, feature, url.getHost()}, 3));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return str2;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    host = url.getHost();
                } catch (MalformedURLException e) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizePlainHosts$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str2 = String.format(Locale.US, HostsSanitizer.ERROR_MALFORMED_URL, Arrays.copyOf(new Object[]{host, feature}, 2));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return str2;
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                    host = null;
                }
            } else if (!regex.matches(str)) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = host.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "localhost")) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizePlainHosts$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str2 = String.format(Locale.US, HostsSanitizer.ERROR_MALFORMED_HOST_IP_ADDRESS, Arrays.copyOf(new Object[]{host, feature}, 2));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return str2;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    host = null;
                }
            }
            if (host != null) {
                arrayList.add(host);
            }
        }
        return arrayList;
    }

    private final List<String> sanitizePatterns(List<String> patterns, String feature) {
        return new HostPatternSanitizer(this.internalLogger).validate(patterns, feature);
    }
}
