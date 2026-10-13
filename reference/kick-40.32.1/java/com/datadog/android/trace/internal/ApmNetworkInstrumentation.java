package com.datadog.android.trace.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.InternalLoggerKt;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder;
import com.datadog.android.api.instrumentation.network.HttpResponseInfo;
import com.datadog.android.api.instrumentation.network.MutableHttpRequestInfo;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.SdkReference;
import com.datadog.android.core.internal.net.DefaultFirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.ApmNetworkTracingScope;
import com.datadog.android.trace.NetworkTracedRequestListener;
import com.datadog.android.trace.TraceContextInjection;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.android.trace.api.DatadogTracingConstants;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.internal.net.ApmNetworkInstrumentationExtKt;
import com.datadog.android.trace.internal.net.RequestTracingState;
import com.datadog.android.trace.internal.net.TracerProvider;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApmNetworkInstrumentation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001[Bk\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EJ\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u00020G2\u0006\u0010H\u001a\u00020C2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020PJ\u0014\u0010Q\u001a\u00020G2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050SJ8\u0010T\u001a\u00020P2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020P2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0003H\u0002J\u0014\u0010X\u001a\u00020\u0003*\u00020\f2\u0006\u0010D\u001a\u00020EH\u0002J\u0014\u0010Y\u001a\u00020\u0003*\u00020E2\u0006\u0010/\u001a\u00020\u001cH\u0002J \u0010Z\u001a\u00020G*\u00020C2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006\\"}, d2 = {"Lcom/datadog/android/trace/internal/ApmNetworkInstrumentation;", "", "canSendSpan", "", "sdkInstanceName", "", "traceOrigin", "tracerProvider", "Lcom/datadog/android/trace/internal/net/TracerProvider;", "redacted404ResourceName", "traceSampler", "Lcom/datadog/android/core/sampling/Sampler;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "injectionType", "Lcom/datadog/android/trace/TraceContextInjection;", "tracedRequestListener", "Lcom/datadog/android/trace/NetworkTracedRequestListener;", "localFirstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;", "networkingLibraryName", "networkTracingScope", "Lcom/datadog/android/trace/ApmNetworkTracingScope;", "(ZLjava/lang/String;Ljava/lang/String;Lcom/datadog/android/trace/internal/net/TracerProvider;ZLcom/datadog/android/core/sampling/Sampler;Lcom/datadog/android/trace/TraceContextInjection;Lcom/datadog/android/trace/NetworkTracedRequestListener;Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;Ljava/lang/String;Lcom/datadog/android/trace/ApmNetworkTracingScope;)V", "getCanSendSpan$dd_sdk_android_trace_release", "()Z", "getInjectionType$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/TraceContextInjection;", "internalSdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "getInternalSdkCore", "()Lcom/datadog/android/core/InternalSdkCore;", "getLocalFirstPartyHostHeaderTypeResolver$dd_sdk_android_trace_release", "()Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;", "localHeaderTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "getLocalHeaderTypes", "()Ljava/util/Set;", "getNetworkTracingScope", "()Lcom/datadog/android/trace/ApmNetworkTracingScope;", "getRedacted404ResourceName$dd_sdk_android_trace_release", "rumContextPropagator", "Lcom/datadog/android/trace/internal/RumContextPropagator;", "sampleRate", "", "getSampleRate", "()Ljava/lang/Float;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "getSdkCore", "()Lcom/datadog/android/api/SdkCore;", "sdkCoreReference", "Lcom/datadog/android/core/SdkReference;", "getSdkCoreReference", "()Lcom/datadog/android/core/SdkReference;", "getSdkInstanceName", "()Ljava/lang/String;", "getTraceOrigin", "getTraceSampler$dd_sdk_android_trace_release", "()Lcom/datadog/android/core/sampling/Sampler;", "getTracedRequestListener$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/NetworkTracedRequestListener;", "getTracerProvider$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/internal/net/TracerProvider;", "getSdkCoreOrNull", ImagesContract.URL, "onRequest", "Lcom/datadog/android/trace/internal/net/RequestTracingState;", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "onResponseFailed", "", "requestTracingState", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onResponseSucceeded", "response", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", "removeTracingHeaders", "requestBuilder", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "reportInstrumentationError", "messageBuilder", "Lkotlin/Function0;", "traceRequest", "tracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "span", "isSampled", "isTraceable", "onRequestIntercepted", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApmNetworkInstrumentation {
    public static final String AGENT_PSR_ATTRIBUTE = "_dd.agent_psr";
    public static final double ALL_IN_SAMPLE_RATE = 100.0d;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_REQUEST_INFO_IS_NOT_MUTABLE = "HttpRequestInfo is not mutable. Your requests won't be traced.";
    public static final String ERROR_STACK_OVERFLOW = "StackOverflowError detected in TracedRequestListener. This is likely caused by retrying the same request within the onRequestIntercepted callback, leading to infinite recursion.";
    public static final String RESOURCE_NAME_404 = "404";
    public static final String SPAN_NAME = "%s.request";
    public static final char URL_QUERY_PARAMS_BLOCK_SEPARATOR = '?';
    public static final String WARNING_TRACING_NO_HOSTS = "You added a ApmNetworkInstrumentation to your %s instrumentation, but you did not specify any first party hosts. Your requests won't be traced.\nTo set a list of known hosts, you can use the Configuration.Builder.setFirstPartyHosts() method.";
    public static final float ZERO_SAMPLE_RATE = 0.0f;
    private final boolean canSendSpan;
    private final TraceContextInjection injectionType;
    private final DefaultFirstPartyHostHeaderTypeResolver localFirstPartyHostHeaderTypeResolver;
    private final ApmNetworkTracingScope networkTracingScope;
    private final String networkingLibraryName;
    private final boolean redacted404ResourceName;
    private final RumContextPropagator rumContextPropagator;
    private final SdkReference sdkCoreReference;
    private final String sdkInstanceName;
    private final String traceOrigin;
    private final Sampler<DatadogSpan> traceSampler;
    private final NetworkTracedRequestListener tracedRequestListener;
    private final TracerProvider tracerProvider;

    public ApmNetworkInstrumentation(boolean z, String str, String str2, TracerProvider tracerProvider, boolean z2, Sampler<DatadogSpan> traceSampler, TraceContextInjection injectionType, NetworkTracedRequestListener tracedRequestListener, DefaultFirstPartyHostHeaderTypeResolver localFirstPartyHostHeaderTypeResolver, String networkingLibraryName, ApmNetworkTracingScope networkTracingScope) {
        Intrinsics.checkNotNullParameter(tracerProvider, "tracerProvider");
        Intrinsics.checkNotNullParameter(traceSampler, "traceSampler");
        Intrinsics.checkNotNullParameter(injectionType, "injectionType");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(localFirstPartyHostHeaderTypeResolver, "localFirstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(networkingLibraryName, "networkingLibraryName");
        Intrinsics.checkNotNullParameter(networkTracingScope, "networkTracingScope");
        this.canSendSpan = z;
        this.sdkInstanceName = str;
        this.traceOrigin = str2;
        this.tracerProvider = tracerProvider;
        this.redacted404ResourceName = z2;
        this.traceSampler = traceSampler;
        this.injectionType = injectionType;
        this.tracedRequestListener = tracedRequestListener;
        this.localFirstPartyHostHeaderTypeResolver = localFirstPartyHostHeaderTypeResolver;
        this.networkingLibraryName = networkingLibraryName;
        this.networkTracingScope = networkTracingScope;
        this.rumContextPropagator = new RumContextPropagator(new Function0<FeatureSdkCore>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation$rumContextPropagator$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeatureSdkCore invoke() {
                return this.this$0.getInternalSdkCore();
            }
        });
        this.sdkCoreReference = new SdkReference(str, new Function1<SdkCore, Unit>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation$sdkCoreReference$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SdkCore sdkCore) {
                invoke2(sdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                InternalSdkCore internalSdkCore = (InternalSdkCore) it;
                if (this.this$0.getLocalFirstPartyHostHeaderTypeResolver().isEmpty() && internalSdkCore.getFirstPartyHostResolver().isEmpty()) {
                    InternalLogger internalLogger = internalSdkCore.getInternalLogger();
                    InternalLogger.Level level = InternalLogger.Level.WARN;
                    final ApmNetworkInstrumentation apmNetworkInstrumentation = this.this$0;
                    InternalLoggerKt.logToUser(internalLogger, level, true, new Function0<String>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation$sdkCoreReference$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str3 = String.format(Locale.US, ApmNetworkInstrumentation.WARNING_TRACING_NO_HOSTS, Arrays.copyOf(new Object[]{apmNetworkInstrumentation.networkingLibraryName}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            return str3;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: renamed from: getCanSendSpan$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getCanSendSpan() {
        return this.canSendSpan;
    }

    public final String getSdkInstanceName() {
        return this.sdkInstanceName;
    }

    public final String getTraceOrigin() {
        return this.traceOrigin;
    }

    /* JADX INFO: renamed from: getTracerProvider$dd_sdk_android_trace_release, reason: from getter */
    public final TracerProvider getTracerProvider() {
        return this.tracerProvider;
    }

    /* JADX INFO: renamed from: getRedacted404ResourceName$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getRedacted404ResourceName() {
        return this.redacted404ResourceName;
    }

    public final Sampler<DatadogSpan> getTraceSampler$dd_sdk_android_trace_release() {
        return this.traceSampler;
    }

    /* JADX INFO: renamed from: getInjectionType$dd_sdk_android_trace_release, reason: from getter */
    public final TraceContextInjection getInjectionType() {
        return this.injectionType;
    }

    /* JADX INFO: renamed from: getTracedRequestListener$dd_sdk_android_trace_release, reason: from getter */
    public final NetworkTracedRequestListener getTracedRequestListener() {
        return this.tracedRequestListener;
    }

    /* JADX INFO: renamed from: getLocalFirstPartyHostHeaderTypeResolver$dd_sdk_android_trace_release, reason: from getter */
    public final DefaultFirstPartyHostHeaderTypeResolver getLocalFirstPartyHostHeaderTypeResolver() {
        return this.localFirstPartyHostHeaderTypeResolver;
    }

    public /* synthetic */ ApmNetworkInstrumentation(boolean z, String str, String str2, TracerProvider tracerProvider, boolean z2, Sampler sampler, TraceContextInjection traceContextInjection, NetworkTracedRequestListener networkTracedRequestListener, DefaultFirstPartyHostHeaderTypeResolver defaultFirstPartyHostHeaderTypeResolver, String str3, ApmNetworkTracingScope apmNetworkTracingScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, tracerProvider, z2, sampler, traceContextInjection, networkTracedRequestListener, defaultFirstPartyHostHeaderTypeResolver, str3, (i & 1024) != 0 ? ApmNetworkTracingScope.ALL : apmNetworkTracingScope);
    }

    public final ApmNetworkTracingScope getNetworkTracingScope() {
        return this.networkTracingScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternalSdkCore getInternalSdkCore() {
        SdkCore sdkCore = this.sdkCoreReference.get();
        if (sdkCore instanceof InternalSdkCore) {
            return (InternalSdkCore) sdkCore;
        }
        return null;
    }

    public final SdkCore getSdkCore() {
        return this.sdkCoreReference.get();
    }

    public final SdkReference getSdkCoreReference() {
        return this.sdkCoreReference;
    }

    public final Float getSampleRate() {
        return this.traceSampler.getSampleRate();
    }

    public final Set<TracingHeaderType> getLocalHeaderTypes() {
        return this.localFirstPartyHostHeaderTypeResolver.getAllHeaderTypes();
    }

    public final RequestTracingState onRequest(HttpRequestInfo request) {
        InternalLogger unbound;
        HttpRequestInfoBuilder httpRequestInfoBuilder;
        DatadogSpan datadogSpan;
        HttpRequestInfoBuilder httpRequestInfoBuilderTraceRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        InternalSdkCore sdkCoreOrNull = getSdkCoreOrNull(request.getUrl());
        Companion companion = INSTANCE;
        if (sdkCoreOrNull == null || (unbound = sdkCoreOrNull.getInternalLogger()) == null) {
            unbound = InternalLogger.INSTANCE.getUNBOUND();
        }
        HttpRequestInfoBuilder httpRequestInfoBuilderNewBuilder = companion.newBuilder(request, unbound);
        if (httpRequestInfoBuilderNewBuilder == null) {
            return null;
        }
        if (sdkCoreOrNull == null) {
            return new RequestTracingState(httpRequestInfoBuilderNewBuilder, false, null, null, 14, null);
        }
        DatadogTracer datadogTracerProvideTracer = this.tracerProvider.provideTracer(sdkCoreOrNull, getLocalHeaderTypes(), this.networkingLibraryName);
        if (datadogTracerProvideTracer == null || !isTraceable(request, sdkCoreOrNull)) {
            return new RequestTracingState(httpRequestInfoBuilderNewBuilder, false, null, null, 14, null);
        }
        DatadogSpan datadogSpanBuildSpan = ApmNetworkInstrumentationExtKt.buildSpan(datadogTracerProvideTracer, request, this.networkingLibraryName, this.traceOrigin, !this.canSendSpan);
        boolean zIsSampled = isSampled(datadogSpanBuildSpan, request);
        if (datadogSpanBuildSpan.getIsRootSpan()) {
            ApmNetworkInstrumentationExtKt.applyPriority(datadogSpanBuildSpan, zIsSampled, this.traceSampler);
        }
        try {
            httpRequestInfoBuilder = httpRequestInfoBuilderNewBuilder;
            datadogSpan = datadogSpanBuildSpan;
            try {
                httpRequestInfoBuilderTraceRequest = traceRequest(request.getUrl(), sdkCoreOrNull, httpRequestInfoBuilder, datadogTracerProvideTracer, datadogSpan, zIsSampled);
            } catch (IllegalStateException e) {
                e = e;
                InternalLogger.DefaultImpls.log$default(sdkCoreOrNull.getInternalLogger(), InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation$onRequest$tracedRequestInfoBuilder$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to update intercepted " + this.this$0.networkingLibraryName + " request";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                httpRequestInfoBuilderTraceRequest = httpRequestInfoBuilder;
            }
        } catch (IllegalStateException e2) {
            e = e2;
            httpRequestInfoBuilder = httpRequestInfoBuilderNewBuilder;
            datadogSpan = datadogSpanBuildSpan;
        }
        return new RequestTracingState(httpRequestInfoBuilderTraceRequest, zIsSampled, datadogSpan, ApmNetworkInstrumentationExtKt.effectiveSampleRate(this.traceSampler, datadogSpan));
    }

    public final void onResponseSucceeded(RequestTracingState requestTracingState, HttpResponseInfo response) {
        DatadogSpan span;
        DatadogSpan span2;
        Intrinsics.checkNotNullParameter(requestTracingState, "requestTracingState");
        Intrinsics.checkNotNullParameter(response, "response");
        if (requestTracingState.isSampled()) {
            DatadogSpan span3 = requestTracingState.getSpan();
            if (span3 != null) {
                span3.setTag("http.status_code", (Number) Integer.valueOf(response.getStatusCode()));
            }
            int statusCode = response.getStatusCode();
            if (400 <= statusCode && statusCode < 500 && (span2 = requestTracingState.getSpan()) != null) {
                span2.setError(true);
            }
            if (response.getStatusCode() == 404 && this.redacted404ResourceName && (span = requestTracingState.getSpan()) != null) {
                span.setResourceName(RESOURCE_NAME_404);
            }
        }
        onRequestIntercepted(requestTracingState, response, null);
        DatadogSpan span4 = requestTracingState.getSpan();
        if (span4 != null) {
            ApmNetworkInstrumentationExtKt.finishRumAware(span4, requestTracingState.isSampled(), this.canSendSpan);
        }
    }

    public final void onResponseFailed(RequestTracingState requestTracingState, Throwable throwable) {
        Intrinsics.checkNotNullParameter(requestTracingState, "requestTracingState");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (requestTracingState.isSampled()) {
            DatadogSpan span = requestTracingState.getSpan();
            if (span != null) {
                span.setError(true);
            }
            DatadogSpan span2 = requestTracingState.getSpan();
            if (span2 != null) {
                span2.setTag(DatadogTracingConstants.Tags.KEY_ERROR_MSG, throwable.getMessage());
            }
            DatadogSpan span3 = requestTracingState.getSpan();
            if (span3 != null) {
                span3.setTag("error.type", throwable.getClass().getName());
            }
            DatadogSpan span4 = requestTracingState.getSpan();
            if (span4 != null) {
                span4.setTag("error.stack", ThrowableExtKt.loggableStackTrace(throwable));
            }
        }
        onRequestIntercepted(requestTracingState, null, throwable);
        DatadogSpan span5 = requestTracingState.getSpan();
        if (span5 != null) {
            ApmNetworkInstrumentationExtKt.finishRumAware(span5, requestTracingState.isSampled(), this.canSendSpan);
        }
    }

    public final void removeTracingHeaders(HttpRequestInfoBuilder requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        _TraceInternalProxy.INSTANCE.getPropagationHelper().removeAllTracingHeaders(requestBuilder);
    }

    public final void reportInstrumentationError(Function0<String> messageBuilder) {
        InternalLogger internalLogger;
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        InternalSdkCore internalSdkCore = getInternalSdkCore();
        if (internalSdkCore == null || (internalLogger = internalSdkCore.getInternalLogger()) == null) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) messageBuilder, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final boolean isSampled(DatadogSpan datadogSpan, HttpRequestInfo httpRequestInfo) {
        return ApmNetworkInstrumentationExtKt.sample(RumContextPropagator.INSTANCE.extractRumContext(datadogSpan, this.rumContextPropagator, true), httpRequestInfo, this.traceSampler, !this.canSendSpan);
    }

    private final void onRequestIntercepted(RequestTracingState requestTracingState, HttpResponseInfo httpResponseInfo, Throwable th) {
        InternalLogger internalLogger;
        if (requestTracingState.getSpan() == null) {
            return;
        }
        final HttpRequestInfo httpRequestInfoCreateRequestInfo = requestTracingState.createRequestInfo();
        try {
            this.tracedRequestListener.onRequestIntercepted(httpRequestInfoCreateRequestInfo, requestTracingState.getSpan(), httpResponseInfo, th);
        } catch (StackOverflowError e) {
            InternalSdkCore internalSdkCore = getInternalSdkCore();
            if (internalSdkCore != null && (internalLogger = internalSdkCore.getInternalLogger()) != null) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation.onRequestIntercepted.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "StackOverflowError detected in TracedRequestListener. This is likely caused by retrying the same request within the onRequestIntercepted callback, leading to infinite recursion.\nRequest: " + httpRequestInfoCreateRequestInfo.getMethod() + ServerSentEventKt.COLON + httpRequestInfoCreateRequestInfo.getUrl();
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                throw e;
            }
            throw e;
        }
    }

    private final HttpRequestInfoBuilder traceRequest(String url, InternalSdkCore sdkCore, HttpRequestInfoBuilder requestBuilder, DatadogTracer tracer, DatadogSpan span, boolean isSampled) {
        Set<TracingHeaderType> setHeaderTypesForUrl = this.localFirstPartyHostHeaderTypeResolver.headerTypesForUrl(url);
        if (setHeaderTypesForUrl.isEmpty()) {
            setHeaderTypesForUrl = sdkCore.getFirstPartyHostResolver().headerTypesForUrl(url);
        }
        Set<TracingHeaderType> set = setHeaderTypesForUrl;
        if (isSampled) {
            _TraceInternalProxy.INSTANCE.getPropagationHelper().propagateSampledHeaders(requestBuilder, tracer, span, set);
            return requestBuilder;
        }
        _TraceInternalProxy.INSTANCE.getPropagationHelper().propagateNotSampledHeaders(requestBuilder, tracer, span, set, this.injectionType, this.traceOrigin);
        return requestBuilder;
    }

    private final boolean isTraceable(HttpRequestInfo httpRequestInfo, InternalSdkCore internalSdkCore) {
        return internalSdkCore.getFirstPartyHostResolver().isFirstPartyUrl(httpRequestInfo.getUrl()) || this.localFirstPartyHostHeaderTypeResolver.isFirstPartyUrl(httpRequestInfo.getUrl());
    }

    static /* synthetic */ InternalSdkCore getSdkCoreOrNull$default(ApmNetworkInstrumentation apmNetworkInstrumentation, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return apmNetworkInstrumentation.getSdkCoreOrNull(str);
    }

    private final InternalSdkCore getSdkCoreOrNull(final String url) {
        if (getInternalSdkCore() == null) {
            InternalLoggerKt.logToUser$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.INFO, false, new Function0<String>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation.getSdkCoreOrNull.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str;
                    ApmNetworkInstrumentation apmNetworkInstrumentation = ApmNetworkInstrumentation.this;
                    String str2 = url;
                    StringBuilder sb = new StringBuilder();
                    if (apmNetworkInstrumentation.getSdkInstanceName() == null) {
                        str = "Default SDK instance";
                    } else {
                        str = "SDK instance with name=" + apmNetworkInstrumentation.getSdkInstanceName();
                    }
                    sb.append(str);
                    sb.append(" for ");
                    sb.append(apmNetworkInstrumentation.networkingLibraryName);
                    sb.append(" instrumentation is not found");
                    if (str2 != null) {
                        sb.append(", skipping tracking of request with url=");
                        sb.append(str2);
                    }
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            }, 2, null);
        }
        return getInternalSdkCore();
    }

    /* JADX INFO: compiled from: ApmNetworkInstrumentation.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/trace/internal/ApmNetworkInstrumentation$Companion;", "", "()V", "AGENT_PSR_ATTRIBUTE", "", "ALL_IN_SAMPLE_RATE", "", "ERROR_REQUEST_INFO_IS_NOT_MUTABLE", "ERROR_STACK_OVERFLOW", "RESOURCE_NAME_404", "SPAN_NAME", "URL_QUERY_PARAMS_BLOCK_SEPARATOR", "", "WARNING_TRACING_NO_HOSTS", "ZERO_SAMPLE_RATE", "", "newBuilder", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HttpRequestInfoBuilder newBuilder(HttpRequestInfo httpRequestInfo, InternalLogger internalLogger) {
            if (httpRequestInfo instanceof MutableHttpRequestInfo) {
                return ((MutableHttpRequestInfo) httpRequestInfo).newBuilder();
            }
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.ApmNetworkInstrumentation$Companion$newBuilder$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ApmNetworkInstrumentation.ERROR_REQUEST_INFO_IS_NOT_MUTABLE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
    }
}
