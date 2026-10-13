package com.datadog.android.rum.internal.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.net.Request;
import com.datadog.android.api.net.RequestExecutionContext;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.event.RumViewEventFilter;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: RumRequestFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/net/RumRequestFactory;", "Lcom/datadog/android/api/net/RequestFactory;", "customEndpointUrl", "", "viewEventFilter", "Lcom/datadog/android/rum/internal/domain/event/RumViewEventFilter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/event/RumViewEventFilter;Lcom/datadog/android/api/InternalLogger;)V", "getCustomEndpointUrl$dd_sdk_android_rum_release", "()Ljava/lang/String;", "buildHeaders", "", "requestId", "idempotencyKey", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "buildTags", "executionContext", "Lcom/datadog/android/api/net/RequestExecutionContext;", "buildUrl", "create", "Lcom/datadog/android/api/net/Request;", "batchData", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", "", "byteArray", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumRequestFactory implements RequestFactory {
    private static final byte[] PAYLOAD_SEPARATOR;
    public static final String RETRY_AFTER_KEY = "retry_after";
    public static final String RETRY_COUNT_KEY = "retry_count";
    private static final String SHA1_GENERATION_ERROR_MESSAGE = "Cannot generate SHA-1 hash for rum request idempotency key.";
    private static final String SHA1_NO_SUCH_ALGORITHM_EXCEPTION = "SHA-1 algorithm could not be found in MessageDigest.";
    private final String customEndpointUrl;
    private final InternalLogger internalLogger;
    private final RumViewEventFilter viewEventFilter;

    public RumRequestFactory(String str, RumViewEventFilter viewEventFilter, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(viewEventFilter, "viewEventFilter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.customEndpointUrl = str;
        this.viewEventFilter = viewEventFilter;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getCustomEndpointUrl$dd_sdk_android_rum_release, reason: from getter */
    public final String getCustomEndpointUrl() {
        return this.customEndpointUrl;
    }

    @Override // com.datadog.android.api.net.RequestFactory
    public Request create(DatadogContext context, RequestExecutionContext executionContext, List<RawBatchEvent> batchData, byte[] batchMetadata) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(batchData, "batchData");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        List<RawBatchEvent> listFilterOutRedundantViewEvents = this.viewEventFilter.filterOutRedundantViewEvents(batchData);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterOutRedundantViewEvents, 10));
        Iterator<T> it = listFilterOutRedundantViewEvents.iterator();
        while (it.hasNext()) {
            arrayList.add(((RawBatchEvent) it.next()).getData());
        }
        byte[] bArrJoin$default = ByteArrayExtKt.join$default(arrayList, PAYLOAD_SEPARATOR, null, null, this.internalLogger, 6, null);
        return new Request(string, "RUM Request", buildUrl(context, executionContext), buildHeaders(string, idempotencyKey(bArrJoin$default), context), bArrJoin$default, "text/plain;charset=UTF-8");
    }

    private final String buildUrl(DatadogContext context, RequestExecutionContext executionContext) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("ddsource", context.getSource());
        String strBuildTags = buildTags(executionContext);
        if (strBuildTags.length() > 0) {
            mapCreateMapBuilder.put("ddtags", strBuildTags);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        String str = this.customEndpointUrl;
        if (str == null) {
            str = context.getSite().getIntakeEndpoint() + "/api/v2/rum";
        }
        ArrayList arrayList = new ArrayList(mapBuild.size());
        for (Map.Entry entry : mapBuild.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return str + CollectionsKt.joinToString$default(arrayList, "&", "?", null, 0, null, null, 60, null);
    }

    private final Map<String, String> buildHeaders(String requestId, String idempotencyKey, DatadogContext context) {
        Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("DD-API-KEY", context.getClientToken()), TuplesKt.to("DD-EVP-ORIGIN", context.getSource()), TuplesKt.to("DD-EVP-ORIGIN-VERSION", context.getSdkVersion()), TuplesKt.to("DD-REQUEST-ID", requestId));
        if (idempotencyKey != null) {
            mapMutableMapOf.put("DD-IDEMPOTENCY-KEY", idempotencyKey);
        }
        return mapMutableMapOf;
    }

    private final String buildTags(RequestExecutionContext executionContext) {
        StringBuilder sb = new StringBuilder();
        if (executionContext.getPreviousResponseCode() != null) {
            sb.append("retry_count:" + executionContext.getAttemptNumber());
            sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
            sb.append("retry_after:" + executionContext.getPreviousResponseCode());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String idempotencyKey(byte[] byteArray) {
        try {
            byte[] hashBytes = MessageDigest.getInstance("SHA-1").digest(byteArray);
            Intrinsics.checkNotNullExpressionValue(hashBytes, "hashBytes");
            return com.datadog.android.internal.utils.ByteArrayExtKt.toHexString(hashBytes);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumRequestFactory.SHA1_GENERATION_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NullPointerException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumRequestFactory.SHA1_GENERATION_ERROR_MESSAGE;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        } catch (DigestException e3) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumRequestFactory.SHA1_GENERATION_ERROR_MESSAGE;
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NoSuchAlgorithmException e4) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumRequestFactory.SHA1_NO_SUCH_ALGORITHM_EXCEPTION;
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    static {
        byte[] bytes = "\n".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        PAYLOAD_SEPARATOR = bytes;
    }
}
