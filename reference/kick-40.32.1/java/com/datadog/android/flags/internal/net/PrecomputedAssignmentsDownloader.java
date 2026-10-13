package com.datadog.android.flags.internal.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: PrecomputedAssignmentsDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsDownloader;", "Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsReader;", "callFactory", "Lokhttp3/Call$Factory;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "requestFactory", "Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsRequestFactory;", "(Lokhttp3/Call$Factory;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsRequestFactory;)V", "executeDownloadRequest", "", "request", "Lokhttp3/Request;", "handleResponse", "response", "Lokhttp3/Response;", "readPrecomputedFlags", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrecomputedAssignmentsDownloader implements PrecomputedAssignmentsReader {
    private final Call.Factory callFactory;
    private final InternalLogger internalLogger;
    private final PrecomputedAssignmentsRequestFactory requestFactory;

    public PrecomputedAssignmentsDownloader(Call.Factory callFactory, InternalLogger internalLogger, PrecomputedAssignmentsRequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.callFactory = callFactory;
        this.internalLogger = internalLogger;
        this.requestFactory = requestFactory;
    }

    @Override // com.datadog.android.flags.internal.net.PrecomputedAssignmentsReader
    public String readPrecomputedFlags(EvaluationContext context, DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Request requestCreate = this.requestFactory.create(context, datadogContext);
        if (requestCreate == null) {
            return null;
        }
        return executeDownloadRequest(requestCreate);
    }

    private final String executeDownloadRequest(Request request) {
        try {
            return handleResponse(this.callFactory.newCall(request).execute());
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.net.PrecomputedAssignmentsDownloader.executeDownloadRequest.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unexpected error while downloading flags";
                }
            }, th, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final String handleResponse(final Response response) {
        if (response.isSuccessful()) {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                return null;
            }
            ResponseBody responseBody = responseBodyBody;
            try {
                String strString = responseBody.string();
                CloseableKt.closeFinally(responseBody, null);
                return strString;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(responseBody, th);
                    throw th2;
                }
            }
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.net.PrecomputedAssignmentsDownloader.handleResponse.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Failed to download flags: " + response.code();
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.net.PrecomputedAssignmentsDownloader.handleResponse.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Flag assignment server returned error (" + response.code() + ")";
            }
        }, (Throwable) null, true, (Map) null, 40, (Object) null);
        ResponseBody responseBodyBody2 = response.body();
        if (responseBodyBody2 != null) {
            responseBodyBody2.close();
        }
        return null;
    }
}
