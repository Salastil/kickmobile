package com.datadog.android.flags.internal.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.flags.internal.DatadogSiteExtensionsKt;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrecomputedAssignmentsRequestFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsRequestFactory;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "customFlagEndpoint", "", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/String;)V", "rumApplicationId", "Lcom/datadog/android/api/context/DatadogContext;", "getRumApplicationId", "(Lcom/datadog/android/api/context/DatadogContext;)Ljava/lang/String;", "buildEnvPayload", "Lorg/json/JSONObject;", "datadogContext", "buildHeaders", "Lokhttp3/Headers;", "buildRequestBody", "Lokhttp3/RequestBody;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "buildSourcePayload", "buildStringifiedAttributes", "create", "Lokhttp3/Request;", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrecomputedAssignmentsRequestFactory {
    private static final String CONTENT_TYPE_VND_JSON = "application/vnd.api+json";
    private static final String HEADER_APPLICATION_ID = "dd-application-id";
    private static final String HEADER_CLIENT_TOKEN = "dd-client-token";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String PREVIEW_CUSTOMER_DOMAIN = "preview";
    private static final String SDK_NAME = "dd-sdk-android";
    private final String customFlagEndpoint;
    private final InternalLogger internalLogger;

    public PrecomputedAssignmentsRequestFactory(InternalLogger internalLogger, String str) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.customFlagEndpoint = str;
    }

    public final Request create(EvaluationContext context, DatadogContext datadogContext) {
        Headers headersBuildHeaders;
        RequestBody requestBodyBuildRequestBody;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        String flagsEndpoint = this.customFlagEndpoint;
        if ((flagsEndpoint == null && (flagsEndpoint = DatadogSiteExtensionsKt.getFlagsEndpoint(datadogContext.getSite(), PREVIEW_CUSTOMER_DOMAIN)) == null) || (headersBuildHeaders = buildHeaders(datadogContext)) == null || (requestBodyBuildRequestBody = buildRequestBody(context, datadogContext)) == null) {
            return null;
        }
        return new Request.Builder().url(flagsEndpoint).headers(headersBuildHeaders).post(requestBodyBuildRequestBody).build();
    }

    private final Headers buildHeaders(DatadogContext datadogContext) {
        Headers.Builder builder = new Headers.Builder();
        try {
            builder.add(HEADER_CLIENT_TOKEN, datadogContext.getClientToken()).add("Content-Type", CONTENT_TYPE_VND_JSON);
            String rumApplicationId = getRumApplicationId(datadogContext);
            if (rumApplicationId != null) {
                builder.add(HEADER_APPLICATION_ID, rumApplicationId);
            }
            return builder.build();
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.net.PrecomputedAssignmentsRequestFactory.buildHeaders.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to build HTTP headers: invalid header values";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final RequestBody buildRequestBody(EvaluationContext context, DatadogContext datadogContext) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("targeting_key", context.getTargetingKey()).put("targeting_attributes", buildStringifiedAttributes(context));
            JSONObject jSONObjectBuildEnvPayload = buildEnvPayload(datadogContext);
            JSONObject jSONObjectPut2 = new JSONObject().put("data", new JSONObject().put("type", "precompute-assignments-request").put(RumFeature.EVENT_ATTRIBUTES_PROPERTY, new JSONObject().put("env", jSONObjectBuildEnvPayload).put("source", buildSourcePayload(datadogContext)).put("subject", jSONObjectPut)));
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String string = jSONObjectPut2.toString();
            Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
            return RequestBody.Companion.create$default(companion, string, (MediaType) null, 1, (Object) null);
        } catch (JSONException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.net.PrecomputedAssignmentsRequestFactory.buildRequestBody.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to create request body: JSON error";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final JSONObject buildStringifiedAttributes(EvaluationContext context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : context.getAttributes().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    private final JSONObject buildEnvPayload(DatadogContext datadogContext) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("dd_env", datadogContext.getEnv());
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …env\", datadogContext.env)");
        return jSONObjectPut;
    }

    private final JSONObject buildSourcePayload(DatadogContext datadogContext) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("sdk_name", "dd-sdk-android").put("sdk_version", datadogContext.getSdkVersion());
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …atadogContext.sdkVersion)");
        return jSONObjectPut;
    }

    private final String getRumApplicationId(DatadogContext datadogContext) {
        Map<String, Object> map = datadogContext.getFeaturesContext().get("rum");
        Object obj = map != null ? map.get("application_id") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
