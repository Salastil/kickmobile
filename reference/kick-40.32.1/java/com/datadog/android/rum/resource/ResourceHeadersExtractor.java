package com.datadog.android.rum.resource;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.internal.utils.StringExtKt;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: compiled from: ResourceHeadersExtractor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006JD\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002JU\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0013R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "", "allowedRequestHeaders", "", "", "allowedResponseHeaders", "(Ljava/util/List;Ljava/util/List;)V", "getAllowedRequestHeaders$dd_sdk_android_rum_release", "()Ljava/util/List;", "getAllowedResponseHeaders$dd_sdk_android_rum_release", "extractHeaders", "", "rawHeaders", "allowedHeaders", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "toResourceAttributes", "rawRequestHeaders", "rawResponseHeaders", "toResourceAttributes$dd_sdk_android_rum_release", "Builder", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceHeadersExtractor {
    public static final int HEADER_SIZE_LIMIT_BYTES = 2048;
    public static final int MAX_HEADERS_COUNT = 100;
    public static final int MAX_HEADER_VALUE_BYTES = 128;
    public static final String NO_HEADERS_WARNING = "ResourceHeadersExtractor was built with no headers to capture. Did you mean to use includeDefaults = true or call captureHeaders()?";
    public static final String SENSITIVE_HEADER_WARNING = "The following headers were requested but match the security pattern and will not be captured: %s. See ResourceHeadersExtractor.SECURITY_PATTERN for details.";
    private final List<String> allowedRequestHeaders;
    private final List<String> allowedResponseHeaders;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> DEFAULT_REQUEST_HEADERS = CollectionsKt.listOf((Object[]) new String[]{"cache-control", "content-type"});
    private static final List<String> DEFAULT_RESPONSE_HEADERS = CollectionsKt.listOf((Object[]) new String[]{"cache-control", "etag", "age", PermissionsResponse.EXPIRES_KEY, "content-type", "content-encoding", "vary", "content-length", "server-timing", "x-cache", "cf-cache-status", "x-vercel-cache"});
    private static final Regex SECURITY_PATTERN = new Regex("(token|cookie|secret|authorization|password|credential|bearer|(api|secret|access|app).?key|forwarded|real.?ip|connecting.?ip|client.?ip)", RegexOption.IGNORE_CASE);

    public /* synthetic */ ResourceHeadersExtractor(List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2);
    }

    private ResourceHeadersExtractor(List<String> list, List<String> list2) {
        this.allowedRequestHeaders = list;
        this.allowedResponseHeaders = list2;
    }

    public final List<String> getAllowedRequestHeaders$dd_sdk_android_rum_release() {
        return this.allowedRequestHeaders;
    }

    public final List<String> getAllowedResponseHeaders$dd_sdk_android_rum_release() {
        return this.allowedResponseHeaders;
    }

    /* JADX INFO: compiled from: ResourceHeadersExtractor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u001f\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000e\"\u00020\u0007¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/resource/ResourceHeadersExtractor$Builder;", "", "includeDefaults", "", "(Z)V", "customHeaders", "", "", "logger", "Lcom/datadog/android/api/InternalLogger;", "build", "Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "captureHeaders", "headers", "", "([Ljava/lang/String;)Lcom/datadog/android/rum/resource/ResourceHeadersExtractor$Builder;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final List<String> customHeaders;
        private final boolean includeDefaults;
        private final InternalLogger logger;

        public Builder() {
            this(false, 1, null);
        }

        public Builder(boolean z) {
            this.includeDefaults = z;
            this.logger = InternalLogger.INSTANCE.getUNBOUND();
            this.customHeaders = new ArrayList();
        }

        public /* synthetic */ Builder(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final Builder captureHeaders(String... headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> list = this.customHeaders;
            ArrayList arrayList = new ArrayList(headers.length);
            for (String str : headers) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                arrayList.add(lowerCase);
            }
            list.addAll(arrayList);
            return this;
        }

        public final ResourceHeadersExtractor build() {
            List listDistinct;
            List listDistinct2;
            List<String> list = this.customHeaders;
            Regex security_pattern = ResourceHeadersExtractor.INSTANCE.getSECURITY_PATTERN();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (security_pattern.containsMatchIn((CharSequence) obj)) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            final List list2 = (List) pair.component1();
            List list3 = (List) pair.component2();
            if (!list2.isEmpty()) {
                InternalLogger.DefaultImpls.log$default(this.logger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.resource.ResourceHeadersExtractor$Builder$build$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, ResourceHeadersExtractor.SENSITIVE_HEADER_WARNING, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(list2, ", ", null, null, 0, null, null, 62, null)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            if (this.includeDefaults) {
                listDistinct = CollectionsKt.distinct(CollectionsKt.plus((Collection) ResourceHeadersExtractor.INSTANCE.getDEFAULT_REQUEST_HEADERS(), (Iterable) list3));
            } else {
                listDistinct = CollectionsKt.distinct(list3);
            }
            if (this.includeDefaults) {
                listDistinct2 = CollectionsKt.distinct(CollectionsKt.plus((Collection) ResourceHeadersExtractor.INSTANCE.getDEFAULT_RESPONSE_HEADERS(), (Iterable) list3));
            } else {
                listDistinct2 = CollectionsKt.distinct(list3);
            }
            if (listDistinct.isEmpty() && listDistinct2.isEmpty()) {
                InternalLogger.DefaultImpls.log$default(this.logger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.resource.ResourceHeadersExtractor$Builder$build$3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return ResourceHeadersExtractor.NO_HEADERS_WARNING;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            return new ResourceHeadersExtractor(listDistinct, listDistinct2, null);
        }
    }

    public final Map<String, Object> toResourceAttributes$dd_sdk_android_rum_release(Map<String, ? extends List<String>> rawRequestHeaders, Map<String, ? extends List<String>> rawResponseHeaders, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(rawRequestHeaders, "rawRequestHeaders");
        Intrinsics.checkNotNullParameter(rawResponseHeaders, "rawResponseHeaders");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Map<String, String> mapExtractHeaders = extractHeaders(rawRequestHeaders, this.allowedRequestHeaders, internalLogger);
        Map<String, String> mapExtractHeaders2 = extractHeaders(rawResponseHeaders, this.allowedResponseHeaders, internalLogger);
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (!mapExtractHeaders.isEmpty()) {
            mapCreateMapBuilder.put(RumAttributes.REQUEST_HEADERS, mapExtractHeaders);
        }
        if (!mapExtractHeaders2.isEmpty()) {
            mapCreateMapBuilder.put(RumAttributes.RESPONSE_HEADERS, mapExtractHeaders2);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map<String, String> extractHeaders(Map<String, ? extends List<String>> rawHeaders, List<String> allowedHeaders, InternalLogger internalLogger) {
        if (rawHeaders.isEmpty() || allowedHeaders.isEmpty()) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(rawHeaders.size()));
        Iterator<T> it = rawHeaders.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, entry.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i = 0;
        for (final String str2 : allowedHeaders) {
            if (linkedHashMap2.size() >= 100) {
                break;
            }
            List list = (List) linkedHashMap.get(str2);
            if (list != null) {
                Pair pairTruncateToUtf8ByteSize$default = StringExtKt.truncateToUtf8ByteSize$default(CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null), 128, null, 2, null);
                String str3 = (String) pairTruncateToUtf8ByteSize$default.component1();
                int length = str2.length() + 1 + ((Number) pairTruncateToUtf8ByteSize$default.component2()).intValue() + i;
                if (length > 2048) {
                    InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.resource.ResourceHeadersExtractor$extractHeaders$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Skipping header '" + str2 + "': adding it would exceed the 2048 byte limit.";
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                } else {
                    linkedHashMap2.put(str2, str3);
                    i = length;
                }
            }
        }
        return linkedHashMap2;
    }

    /* JADX INFO: compiled from: ResourceHeadersExtractor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/resource/ResourceHeadersExtractor$Companion;", "", "()V", "DEFAULT_REQUEST_HEADERS", "", "", "getDEFAULT_REQUEST_HEADERS", "()Ljava/util/List;", "DEFAULT_RESPONSE_HEADERS", "getDEFAULT_RESPONSE_HEADERS", "HEADER_SIZE_LIMIT_BYTES", "", "MAX_HEADERS_COUNT", "MAX_HEADER_VALUE_BYTES", "NO_HEADERS_WARNING", "SECURITY_PATTERN", "Lkotlin/text/Regex;", "getSECURITY_PATTERN", "()Lkotlin/text/Regex;", "SENSITIVE_HEADER_WARNING", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getDEFAULT_REQUEST_HEADERS() {
            return ResourceHeadersExtractor.DEFAULT_REQUEST_HEADERS;
        }

        public final List<String> getDEFAULT_RESPONSE_HEADERS() {
            return ResourceHeadersExtractor.DEFAULT_RESPONSE_HEADERS;
        }

        public final Regex getSECURITY_PATTERN() {
            return ResourceHeadersExtractor.SECURITY_PATTERN;
        }
    }
}
