package com.datadog.android.trace.internal;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureScopeExtKt;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanBuilder;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.datadog.trace.core.DDSpan;
import com.datadog.trace.core.propagation.HttpCodec;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumContextPropagator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001f\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u001aH\u0002¢\u0006\u0002\u0010\u001bJ/\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00190\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J$\u0010!\u001a\u0004\u0018\u0001H\u0019\"\u0006\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0017H\u0082\b¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\"\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/datadog/android/trace/internal/RumContextPropagator;", "", "sdkCoreProvider", "Lkotlin/Function0;", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lkotlin/jvm/functions/Function0;)V", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "sdkCore", "getSdkCore", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "extractRumContextInternal", "", "instance", "block", "", "injectRumContext", "builder", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "logError", "message", "", "getOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)Ljava/lang/Object;", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/util/concurrent/Future;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "getTag", "key", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "setTag", "value", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumContextPropagator {
    private static final long CONTEXT_RESOLUTION_TIMEOUT = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DATADOG_INITIAL_CONTEXT = "_dd.datadog_initial_context";
    public static final String ERROR_DATADOG_CONTEXT_RESOLUTION_TIMEOUT = "Datadog context resolution timeout exceeded.";
    public static final String ERROR_FUTURE_GET_FAILED = "Unable to get datadog context.";
    public static final String INITIAL_DATADOG_CONTEXT_NOT_AVAILABLE_ERROR = "Initial span creation Datadog context is not available at the write time.";
    private final Function0<FeatureSdkCore> sdkCoreProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public RumContextPropagator(Function0<? extends FeatureSdkCore> sdkCoreProvider) {
        Intrinsics.checkNotNullParameter(sdkCoreProvider, "sdkCoreProvider");
        this.sdkCoreProvider = sdkCoreProvider;
    }

    private final FeatureSdkCore getSdkCore() {
        return this.sdkCoreProvider.invoke();
    }

    private final InternalLogger getInternalLogger() {
        FeatureSdkCore sdkCore = getSdkCore();
        if (sdkCore != null) {
            return sdkCore.getInternalLogger();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void injectRumContext(DatadogSpanBuilder builder) {
        FeatureScope feature;
        Future<DatadogContext> contextFuture;
        FeatureSdkCore sdkCore = getSdkCore();
        if (sdkCore == null || (feature = sdkCore.getFeature("rum")) == null || (contextFuture = FeatureScopeExtKt.getContextFuture(feature, SetsKt.setOf("rum"))) == null) {
            return;
        }
        builder.withTag(DATADOG_INITIAL_CONTEXT, contextFuture);
    }

    static /* synthetic */ void extractRumContextInternal$default(RumContextPropagator rumContextPropagator, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        rumContextPropagator.extractRumContextInternal(obj, z);
    }

    private final void setTag(Object obj, String str, Object obj2) {
        if (obj instanceof DDSpan) {
            ((DDSpan) obj).mo11193setTag(str, obj2);
        } else if (obj instanceof DatadogSpan) {
            ((DatadogSpan) obj).setTag(str, obj2);
        }
    }

    private final /* synthetic */ <T> T getTag(Object obj, String str) {
        if (obj instanceof DDSpan) {
            T t = (T) ((DDSpan) obj).getTag(str);
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }
        if (!(obj instanceof DatadogSpan)) {
            return null;
        }
        T t2 = (T) ((DatadogSpan) obj).getTag(str);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t2;
    }

    private final <T> T getOrNull(Future<T> future, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (TimeoutException unused) {
            logError(ERROR_DATADOG_CONTEXT_RESOLUTION_TIMEOUT);
            return null;
        } catch (Exception unused2) {
            logError(ERROR_FUTURE_GET_FAILED);
            return null;
        }
    }

    private final <T> T getOrNull(Future<T> future) {
        try {
            return future.get();
        } catch (Exception unused) {
            logError(ERROR_FUTURE_GET_FAILED);
            return null;
        }
    }

    private final void logError(final String message) {
        InternalLogger internalLogger = getInternalLogger();
        if (internalLogger != null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.RumContextPropagator.logError.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return message;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    /* JADX INFO: compiled from: RumContextPropagator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J#\u0010\n\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/trace/internal/RumContextPropagator$Companion;", "", "()V", "CONTEXT_RESOLUTION_TIMEOUT", "", "DATADOG_INITIAL_CONTEXT", "", "ERROR_DATADOG_CONTEXT_RESOLUTION_TIMEOUT", "ERROR_FUTURE_GET_FAILED", "INITIAL_DATADOG_CONTEXT_NOT_AVAILABLE_ERROR", "extractRumContext", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "propagator", "Lcom/datadog/android/trace/internal/RumContextPropagator;", "block", "", "Lcom/datadog/trace/core/DDSpan;", "extractRumContext$dd_sdk_android_trace_release", "injectRumContext", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "injectRumContext$dd_sdk_android_trace_release", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DatadogSpan extractRumContext$default(Companion companion, DatadogSpan datadogSpan, RumContextPropagator rumContextPropagator, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.extractRumContext(datadogSpan, rumContextPropagator, z);
        }

        public final DatadogSpan extractRumContext(DatadogSpan datadogSpan, RumContextPropagator propagator, boolean z) {
            Intrinsics.checkNotNullParameter(datadogSpan, "<this>");
            Intrinsics.checkNotNullParameter(propagator, "propagator");
            propagator.extractRumContextInternal(datadogSpan, z);
            return datadogSpan;
        }

        public static /* synthetic */ DDSpan extractRumContext$dd_sdk_android_trace_release$default(Companion companion, DDSpan dDSpan, RumContextPropagator rumContextPropagator, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.extractRumContext$dd_sdk_android_trace_release(dDSpan, rumContextPropagator, z);
        }

        public final DDSpan extractRumContext$dd_sdk_android_trace_release(DDSpan dDSpan, RumContextPropagator propagator, boolean z) {
            Intrinsics.checkNotNullParameter(dDSpan, "<this>");
            Intrinsics.checkNotNullParameter(propagator, "propagator");
            propagator.extractRumContextInternal(dDSpan, z);
            return dDSpan;
        }

        public final DatadogSpanBuilder injectRumContext$dd_sdk_android_trace_release(DatadogSpanBuilder datadogSpanBuilder, RumContextPropagator propagator) {
            Intrinsics.checkNotNullParameter(datadogSpanBuilder, "<this>");
            Intrinsics.checkNotNullParameter(propagator, "propagator");
            propagator.injectRumContext(datadogSpanBuilder);
            return datadogSpanBuilder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void extractRumContextInternal(Object instance, boolean block) {
        Future future;
        DatadogContext datadogContext;
        if (instance instanceof DDSpan) {
            Object tag = ((DDSpan) instance).getTag(DATADOG_INITIAL_CONTEXT);
            if (!(tag instanceof Future)) {
                tag = null;
            }
            future = (Future) tag;
        } else if (instance instanceof DatadogSpan) {
            Object tag2 = ((DatadogSpan) instance).getTag(DATADOG_INITIAL_CONTEXT);
            if (!(tag2 instanceof Future)) {
                tag2 = null;
            }
            future = (Future) tag2;
        } else {
            future = null;
        }
        if (future != null) {
            if (block) {
                datadogContext = (DatadogContext) getOrNull(future, 1L, TimeUnit.SECONDS);
            } else if (future.isDone()) {
                datadogContext = (DatadogContext) getOrNull(future);
            } else {
                logError(INITIAL_DATADOG_CONTEXT_NOT_AVAILABLE_ERROR);
                datadogContext = null;
            }
            if (datadogContext != null) {
                Map<String, Object> mapEmptyMap = datadogContext.getFeaturesContext().get("rum");
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                setTag(instance, "application_id", mapEmptyMap.get("application_id"));
                setTag(instance, "session_id", mapEmptyMap.get("session_id"));
                setTag(instance, LogAttributes.RUM_VIEW_ID, mapEmptyMap.get("view_id"));
                setTag(instance, LogAttributes.RUM_ACTION_ID, mapEmptyMap.get(RumContext.ACTION_ID));
                setTag(instance, "session_sample_rate", mapEmptyMap.get("session_sample_rate"));
                setTag(instance, HttpCodec.RUM_KEY_USER_ID, datadogContext.getUserInfo().getId());
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                setTag(instance, HttpCodec.RUM_KEY_ACCOUNT_ID, accountInfo != null ? accountInfo.getId() : null);
            }
            setTag(instance, DATADOG_INITIAL_CONTEXT, null);
        }
    }
}
