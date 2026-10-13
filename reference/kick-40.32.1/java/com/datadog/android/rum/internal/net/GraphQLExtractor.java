package com.datadog.android.rum.internal.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.internal.network.GraphQLHeaders;
import com.datadog.android.internal.utils.StringExtKt;
import com.datadog.android.rum.RumAttributes;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GraphQLExtractor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J$\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/internal/net/GraphQLExtractor;", "", "()V", "extractGraphQLAttributes", "", "", "requestInfo", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "extractGraphQLErrors", "contentType", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "normalizeErrorCode", "", "error", "Lorg/json/JSONObject;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphQLExtractor {
    private static final String CODE_KEY = "code";
    private static final String ERRORS_KEY = "errors";
    public static final String ERROR_EXTRACT_GRAPHQL_ERRORS = "Failed to extract GraphQL errors from response body.";
    private static final String EXTENSIONS_KEY = "extensions";
    public static final long MAX_GRAPHQL_BODY_PEEK = 524288;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<GraphQLHeaders, String> GRAPHQL_HEADER_TO_ATTRIBUTE = MapsKt.mapOf(TuplesKt.to(GraphQLHeaders.DD_GRAPHQL_NAME_HEADER, RumAttributes.GRAPHQL_OPERATION_NAME), TuplesKt.to(GraphQLHeaders.DD_GRAPHQL_TYPE_HEADER, RumAttributes.GRAPHQL_OPERATION_TYPE), TuplesKt.to(GraphQLHeaders.DD_GRAPHQL_VARIABLES_HEADER, RumAttributes.GRAPHQL_VARIABLES), TuplesKt.to(GraphQLHeaders.DD_GRAPHQL_PAYLOAD_HEADER, RumAttributes.GRAPHQL_PAYLOAD));
    private static final Set<String> JSON_CONTENT_TYPES = SetsKt.setOf((Object[]) new String[]{"application/json", "application/graphql+json", "application/graphql-response+json"});

    public final Map<String, Object> extractGraphQLAttributes(HttpRequestInfo requestInfo) {
        String str;
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (Map.Entry<GraphQLHeaders, String> entry : GRAPHQL_HEADER_TO_ATTRIBUTE.entrySet()) {
            GraphQLHeaders key = entry.getKey();
            String value = entry.getValue();
            List<String> list = requestInfo.getHeaders().get(key.getHeaderValue());
            if (list != null && (str = (String) CollectionsKt.firstOrNull((List) list)) != null) {
                mapCreateMapBuilder.put(value, StringExtKt.fromBase64(str));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final String extractGraphQLErrors(String contentType, String body, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (body != null && contentType != null) {
            Set<String> set = JSON_CONTENT_TYPES;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (StringsKt.startsWith$default(contentType, (String) it.next(), false, 2, (Object) null)) {
                        try {
                            JSONObject jSONObject = new JSONObject(body);
                            JSONArray jSONArray = jSONObject.has("errors") ? jSONObject.getJSONArray("errors") : null;
                            if (jSONArray != null && jSONArray.length() != 0) {
                                JSONArray jSONArray2 = new JSONArray();
                                int length = jSONArray.length();
                                for (int i = 0; i < length; i++) {
                                    JSONObject error = jSONArray.getJSONObject(i);
                                    Intrinsics.checkNotNullExpressionValue(error, "error");
                                    normalizeErrorCode(error);
                                    jSONArray2.put(error);
                                }
                                return jSONArray2.toString();
                            }
                            return null;
                        } catch (JSONException e) {
                            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.GraphQLExtractor.extractGraphQLErrors.2
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return GraphQLExtractor.ERROR_EXTRACT_GRAPHQL_ERRORS;
                                }
                            }, (Throwable) e, false, (Map) null, 48, (Object) null);
                        }
                    }
                }
            }
        }
        return null;
    }

    private final void normalizeErrorCode(JSONObject error) throws JSONException {
        if (error.has(CODE_KEY)) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = error.optJSONObject(EXTENSIONS_KEY);
        Object objOpt = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt(CODE_KEY) : null;
        if (objOpt != null) {
            error.put(CODE_KEY, objOpt);
        }
    }

    /* JADX INFO: compiled from: GraphQLExtractor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/net/GraphQLExtractor$Companion;", "", "()V", "CODE_KEY", "", "ERRORS_KEY", "ERROR_EXTRACT_GRAPHQL_ERRORS", "EXTENSIONS_KEY", "GRAPHQL_HEADER_TO_ATTRIBUTE", "", "Lcom/datadog/android/internal/network/GraphQLHeaders;", "JSON_CONTENT_TYPES", "", "getJSON_CONTENT_TYPES$dd_sdk_android_rum_release", "()Ljava/util/Set;", "MAX_GRAPHQL_BODY_PEEK", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getJSON_CONTENT_TYPES$dd_sdk_android_rum_release() {
            return GraphQLExtractor.JSON_CONTENT_TYPES;
        }
    }
}
