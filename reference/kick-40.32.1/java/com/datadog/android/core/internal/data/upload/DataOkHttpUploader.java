package com.datadog.android.core.internal.data.upload;

import android.net.TrafficStats;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.net.Request;
import com.datadog.android.api.net.RequestExecutionContext;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.core.internal.system.AndroidInfoProvider;
import com.datadog.android.internal.profiler.ExecutionTimer;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: compiled from: DataOkHttpUploader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u00105\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002J2\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010\u001cH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\"\u0010 ¨\u0006@"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DataOkHttpUploader;", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "callFactory", "Lokhttp3/Call$Factory;", "sdkVersion", "", "androidInfoProvider", "Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "executionTimer", "Lcom/datadog/android/internal/profiler/ExecutionTimer;", "(Lcom/datadog/android/api/net/RequestFactory;Lcom/datadog/android/api/InternalLogger;Lokhttp3/Call$Factory;Ljava/lang/String;Lcom/datadog/android/core/internal/system/AndroidInfoProvider;Lcom/datadog/android/internal/profiler/ExecutionTimer;)V", "getAndroidInfoProvider", "()Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "attempts", "", "getCallFactory", "()Lokhttp3/Call$Factory;", "getExecutionTimer", "()Lcom/datadog/android/internal/profiler/ExecutionTimer;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "previousUploadStatus", "Lcom/datadog/android/core/internal/data/upload/UploadStatus;", "previousUploadedBatchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "getSdkVersion", "()Ljava/lang/String;", "userAgent", "getUserAgent", "userAgent$delegate", "Lkotlin/Lazy;", "buildOkHttpRequest", "Lokhttp3/Request;", "request", "Lcom/datadog/android/api/net/Request;", "executeUploadRequest", "isValidHeaderValue", "", "value", "isValidHeaderValueChar", "c", "", "resolveExecutionContext", "Lcom/datadog/android/api/net/RequestExecutionContext;", "batchID", "responseCodeToUploadStatus", "code", "sanitizeHeaderValue", "upload", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "batch", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMeta", "", "batchId", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataOkHttpUploader implements DataUploader {
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_INSUFFICIENT_STORAGE = 507;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final String SYSTEM_UA = "http.agent";
    public static final String WARNING_USER_AGENT_HEADER_RESERVED = "Ignoring provided User-Agent header, because it is reserved.";
    private final AndroidInfoProvider androidInfoProvider;
    private volatile int attempts;
    private final Call.Factory callFactory;
    private final ExecutionTimer executionTimer;
    private final InternalLogger internalLogger;
    private volatile UploadStatus previousUploadStatus;
    private volatile BatchId previousUploadedBatchId;
    private final RequestFactory requestFactory;
    private final String sdkVersion;

    /* JADX INFO: renamed from: userAgent$delegate, reason: from kotlin metadata */
    private final Lazy userAgent;

    private final boolean isValidHeaderValueChar(char c) {
        if (c != '\t') {
            return ' ' <= c && c < 127;
        }
        return true;
    }

    public DataOkHttpUploader(RequestFactory requestFactory, InternalLogger internalLogger, Call.Factory callFactory, String sdkVersion, AndroidInfoProvider androidInfoProvider, ExecutionTimer executionTimer) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(androidInfoProvider, "androidInfoProvider");
        Intrinsics.checkNotNullParameter(executionTimer, "executionTimer");
        this.requestFactory = requestFactory;
        this.internalLogger = internalLogger;
        this.callFactory = callFactory;
        this.sdkVersion = sdkVersion;
        this.androidInfoProvider = androidInfoProvider;
        this.executionTimer = executionTimer;
        this.attempts = 1;
        this.userAgent = LazyKt.lazy(new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$userAgent$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() throws IOException {
                String strSanitizeHeaderValue = this.this$0.sanitizeHeaderValue(System.getProperty(DataOkHttpUploader.SYSTEM_UA));
                DataOkHttpUploader dataOkHttpUploader = this.this$0;
                if (StringsKt.isBlank(strSanitizeHeaderValue)) {
                    strSanitizeHeaderValue = "Datadog/" + dataOkHttpUploader.getSdkVersion() + " (Linux; U; Android " + dataOkHttpUploader.getAndroidInfoProvider().getOsVersion() + "; " + dataOkHttpUploader.getAndroidInfoProvider().getDeviceModel() + " Build/" + dataOkHttpUploader.getAndroidInfoProvider().getDeviceBuildId() + ")";
                }
                return strSanitizeHeaderValue;
            }
        });
    }

    public final RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    public final Call.Factory getCallFactory() {
        return this.callFactory;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final AndroidInfoProvider getAndroidInfoProvider() {
        return this.androidInfoProvider;
    }

    public final ExecutionTimer getExecutionTimer() {
        return this.executionTimer;
    }

    @Override // com.datadog.android.core.internal.data.upload.DataUploader
    public UploadStatus upload(final DatadogContext context, List<RawBatchEvent> batch, byte[] batchMeta, BatchId batchId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(batch, "batch");
        RequestExecutionContext requestExecutionContextResolveExecutionContext = resolveExecutionContext(batchId);
        try {
            final Request requestCreate = this.requestFactory.create(context, requestExecutionContextResolveExecutionContext, batch, batchMeta);
            if (requestCreate == null) {
                return new UploadStatus.RequestCreationError(null);
            }
            UploadStatus uploadStatus = (UploadStatus) this.executionTimer.measure(new Function0<UploadStatus>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$upload$uploadStatus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final UploadStatus invoke() {
                    try {
                        return this.this$0.executeUploadRequest(requestCreate);
                    } catch (UnknownHostException e) {
                        InternalLogger internalLogger = this.this$0.getInternalLogger();
                        InternalLogger.Level level = InternalLogger.Level.ERROR;
                        InternalLogger.Target target = InternalLogger.Target.USER;
                        final DatadogContext datadogContext = context;
                        UnknownHostException unknownHostException = e;
                        InternalLogger.DefaultImpls.log$default(internalLogger, level, target, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$upload$uploadStatus$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Unable to find host for site " + datadogContext.getSite() + "; we will retry later.";
                            }
                        }, (Throwable) unknownHostException, false, (Map) null, 48, (Object) null);
                        return new UploadStatus.DNSError(unknownHostException);
                    } catch (IOException e2) {
                        IOException iOException = e2;
                        InternalLogger.DefaultImpls.log$default(this.this$0.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$upload$uploadStatus$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Unable to execute the request; we will retry later.";
                            }
                        }, (Throwable) iOException, false, (Map) null, 48, (Object) null);
                        return new UploadStatus.NetworkError(iOException);
                    } catch (Throwable th) {
                        InternalLogger.DefaultImpls.log$default(this.this$0.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$upload$uploadStatus$1.3
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Unable to execute the request; we will retry later.";
                            }
                        }, th, false, (Map) null, 48, (Object) null);
                        return new UploadStatus.UnknownException(th);
                    }
                }
            });
            uploadStatus.logStatus(requestCreate.getDescription(), requestCreate.getBody().length, this.internalLogger, requestExecutionContextResolveExecutionContext.getAttemptNumber(), requestCreate.getId());
            this.previousUploadStatus = uploadStatus;
            return uploadStatus;
        } catch (Exception e) {
            Exception exc = e;
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader$upload$request$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to create the request, probably due to bad data format. The batch will be dropped.";
                }
            }, (Throwable) exc, false, (Map) null, 48, (Object) null);
            return new UploadStatus.RequestCreationError(exc);
        }
    }

    private final String getUserAgent() {
        return (String) this.userAgent.getValue();
    }

    private final RequestExecutionContext resolveExecutionContext(BatchId batchID) {
        Integer numValueOf = null;
        if (batchID != null && this.previousUploadedBatchId != null && Intrinsics.areEqual(this.previousUploadedBatchId, batchID)) {
            this.attempts++;
            UploadStatus uploadStatus = this.previousUploadStatus;
            if (uploadStatus != null) {
                numValueOf = Integer.valueOf(uploadStatus.getCode());
            }
        } else {
            this.attempts = 1;
        }
        this.previousUploadedBatchId = batchID;
        return new RequestExecutionContext(this.attempts, numValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadStatus executeUploadRequest(Request request) throws IOException {
        Object next;
        Iterator<T> it = request.getHeaders().entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.equals((String) ((Map.Entry) next).getKey(), "DD-API-KEY", true));
        Map.Entry entry = (Map.Entry) next;
        String str = entry != null ? (String) entry.getValue() : null;
        if (str != null && (str.length() == 0 || !isValidHeaderValue(str))) {
            return new UploadStatus.InvalidTokenError(0);
        }
        okhttp3.Request requestBuildOkHttpRequest = buildOkHttpRequest(request);
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "currentThread()");
        TrafficStats.setThreadStatsTag((int) ThreadExtKt.safeGetThreadId(threadCurrentThread));
        Response responseExecute = this.callFactory.newCall(requestBuildOkHttpRequest).execute();
        responseExecute.close();
        return responseCodeToUploadStatus(responseExecute.code(), request);
    }

    private final okhttp3.Request buildOkHttpRequest(Request request) {
        okhttp3.Request.Builder builderPost = new okhttp3.Request.Builder().url(request.getUrl()).post(RequestBody.Companion.create$default(RequestBody.INSTANCE, request.getBody(), request.getContentType() == null ? null : MediaType.INSTANCE.parse(request.getContentType()), 0, 0, 6, (Object) null));
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = key.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "user-agent")) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader.buildOkHttpRequest.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DataOkHttpUploader.WARNING_USER_AGENT_HEADER_RESERVED;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else {
                builderPost.addHeader(key, value);
            }
        }
        builderPost.addHeader("User-Agent", getUserAgent());
        return builderPost.build();
    }

    private final boolean isValidHeaderValue(String value) {
        String str = value;
        for (int i = 0; i < str.length(); i++) {
            if (!isValidHeaderValueChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private final UploadStatus responseCodeToUploadStatus(final int code, final Request request) {
        if (code == 202) {
            return new UploadStatus.Success(code);
        }
        if (code != 403) {
            if (code != 408) {
                if (code != 413) {
                    if (code != 429) {
                        if (code != 500 && code != 507) {
                            if (code != 400) {
                                if (code != 401) {
                                    switch (code) {
                                        case 502:
                                        case 503:
                                        case 504:
                                            break;
                                        default:
                                            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.data.upload.DataOkHttpUploader.responseCodeToUploadStatus.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    return "Unexpected status code " + code + " on upload request: " + request.getDescription();
                                                }
                                            }, (Throwable) null, false, (Map) null, 56, (Object) null);
                                            return new UploadStatus.UnknownHttpError(code);
                                    }
                                }
                            }
                        }
                        return new UploadStatus.HttpServerError(code);
                    }
                }
                return new UploadStatus.HttpClientError(code);
            }
            return new UploadStatus.HttpClientRateLimiting(code);
        }
        return new UploadStatus.InvalidTokenError(code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String sanitizeHeaderValue(String value) throws IOException {
        String string;
        if (value != null) {
            String str = value;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (isValidHeaderValueChar(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = null;
        }
        return string == null ? "" : string;
    }
}
