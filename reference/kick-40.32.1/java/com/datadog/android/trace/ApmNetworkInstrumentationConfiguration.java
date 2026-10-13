package com.datadog.android.trace;

import com.datadog.android.api.SdkCore;
import com.datadog.android.core.configuration.HostsSanitizer;
import com.datadog.android.core.internal.net.DefaultFirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.internal.ApmNetworkInstrumentation;
import com.datadog.android.trace.internal.net.SessionRebasedSampler;
import com.datadog.android.trace.internal.net.TracerProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ApmNetworkInstrumentationConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B!\b\u0016\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0002\u0010\nB¯\u0001\b\u0000\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00120\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r¢\u0006\u0002\u0010\u001fJ\u0006\u0010F\u001a\u00020\u0000J\b\u0010G\u001a\u0004\u0018\u00010\u0004J\u0006\u0010H\u001a\u00020\rJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\rJ\u001d\u0010K\u001a\u00020\u00002\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001bH\u0000¢\u0006\u0002\b\"J\u0006\u0010L\u001a\u00020\u0000J-\u0010M\u001a\u00020\u00002\u001e\u0010N\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00120\u0010H\u0000¢\u0006\u0002\b*J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010Q\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010R\u001a\u00020\rH\u0007J\u0010\u0010S\u001a\u00020\u00002\b\b\u0001\u0010T\u001a\u00020UJ\u0014\u0010V\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u001e\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R2\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006Z"}, d2 = {"Lcom/datadog/android/trace/ApmNetworkInstrumentationConfiguration;", "", "tracedHosts", "", "", "(Ljava/util/List;)V", "tracedHostsWithHeaderType", "", "", "Lcom/datadog/android/trace/TracingHeaderType;", "(Ljava/util/Map;)V", "traceOrigin", "redacted404ResourceName", "", "sdkInstanceName", "localTracerFactory", "Lkotlin/Function2;", "Lcom/datadog/android/api/SdkCore;", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "traceContextInjection", "Lcom/datadog/android/trace/TraceContextInjection;", "tracedRequestListener", "Lcom/datadog/android/trace/NetworkTracedRequestListener;", "traceSampler", "Lcom/datadog/android/core/sampling/Sampler;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "globalTracerProvider", "Lkotlin/Function0;", "networkTracingScope", "Lcom/datadog/android/trace/ApmNetworkTracingScope;", "headerPropagationOnly", "(Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/datadog/android/trace/TraceContextInjection;Lcom/datadog/android/trace/NetworkTracedRequestListener;Lcom/datadog/android/core/sampling/Sampler;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/trace/ApmNetworkTracingScope;Z)V", "getGlobalTracerProvider$dd_sdk_android_trace_release", "()Lkotlin/jvm/functions/Function0;", "setGlobalTracerProvider$dd_sdk_android_trace_release", "(Lkotlin/jvm/functions/Function0;)V", "getHeaderPropagationOnly$dd_sdk_android_trace_release", "()Z", "setHeaderPropagationOnly$dd_sdk_android_trace_release", "(Z)V", "getLocalTracerFactory$dd_sdk_android_trace_release", "()Lkotlin/jvm/functions/Function2;", "setLocalTracerFactory$dd_sdk_android_trace_release", "(Lkotlin/jvm/functions/Function2;)V", "getNetworkTracingScope$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/ApmNetworkTracingScope;", "setNetworkTracingScope$dd_sdk_android_trace_release", "(Lcom/datadog/android/trace/ApmNetworkTracingScope;)V", "getRedacted404ResourceName$dd_sdk_android_trace_release", "setRedacted404ResourceName$dd_sdk_android_trace_release", "getSdkInstanceName$dd_sdk_android_trace_release", "()Ljava/lang/String;", "setSdkInstanceName$dd_sdk_android_trace_release", "(Ljava/lang/String;)V", "getTraceContextInjection$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/TraceContextInjection;", "setTraceContextInjection$dd_sdk_android_trace_release", "(Lcom/datadog/android/trace/TraceContextInjection;)V", "getTraceOrigin$dd_sdk_android_trace_release", "setTraceOrigin$dd_sdk_android_trace_release", "getTraceSampler$dd_sdk_android_trace_release", "()Lcom/datadog/android/core/sampling/Sampler;", "setTraceSampler$dd_sdk_android_trace_release", "(Lcom/datadog/android/core/sampling/Sampler;)V", "getTracedHostsWithHeaderType$dd_sdk_android_trace_release", "()Ljava/util/Map;", "getTracedRequestListener$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/NetworkTracedRequestListener;", "setTracedRequestListener$dd_sdk_android_trace_release", "(Lcom/datadog/android/trace/NetworkTracedRequestListener;)V", "copy", "getTraceOrigin", "isHeaderPropagationOnly", "set404ResourcesRedacted", "redacted", "setGlobalTracerProvider", "setHeaderPropagationOnly", "setLocalTracerFactory", "factory", "setSdkInstanceName", "setTraceContextInjection", "setTraceOrigin", "replace", "setTraceSampleRate", "sampleRate", "", "setTraceSampler", "setTraceScope", "setTracedRequestListener", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApmNetworkInstrumentationConfiguration {
    public static final double ALL_IN_SAMPLE_RATE = 100.0d;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<SdkCore, Set<? extends TracingHeaderType>, DatadogTracer> DEFAULT_LOCAL_TRACER_FACTORY = new Function2<SdkCore, Set<? extends TracingHeaderType>, DatadogTracer>() { // from class: com.datadog.android.trace.ApmNetworkInstrumentationConfiguration$Companion$DEFAULT_LOCAL_TRACER_FACTORY$1
        @Override // kotlin.jvm.functions.Function2
        public final DatadogTracer invoke(SdkCore sdkCore, Set<? extends TracingHeaderType> tracingHeaderTypes) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(tracingHeaderTypes, "tracingHeaderTypes");
            return DatadogTracing.newTracerBuilder(sdkCore).withTracingHeadersTypes(tracingHeaderTypes).withSampleRate(100.0d).build();
        }
    };
    public static final float DEFAULT_TRACE_SAMPLE_RATE = 100.0f;
    public static final String NETWORK_REQUESTS_TRACKING_FEATURE_NAME = "Network Requests";
    private Function0<? extends DatadogTracer> globalTracerProvider;
    private boolean headerPropagationOnly;
    private Function2<? super SdkCore, ? super Set<? extends TracingHeaderType>, ? extends DatadogTracer> localTracerFactory;
    private ApmNetworkTracingScope networkTracingScope;
    private boolean redacted404ResourceName;
    private String sdkInstanceName;
    private TraceContextInjection traceContextInjection;
    private String traceOrigin;
    private Sampler<DatadogSpan> traceSampler;
    private final Map<String, Set<TracingHeaderType>> tracedHostsWithHeaderType;
    private NetworkTracedRequestListener tracedRequestListener;

    public final ApmNetworkInstrumentationConfiguration setTraceOrigin(String traceOrigin) {
        Intrinsics.checkNotNullParameter(traceOrigin, "traceOrigin");
        return setTraceOrigin$default(this, traceOrigin, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApmNetworkInstrumentationConfiguration(Map<String, ? extends Set<? extends TracingHeaderType>> tracedHostsWithHeaderType, String str, boolean z, String str2, Function2<? super SdkCore, ? super Set<? extends TracingHeaderType>, ? extends DatadogTracer> localTracerFactory, TraceContextInjection traceContextInjection, NetworkTracedRequestListener tracedRequestListener, Sampler<DatadogSpan> traceSampler, Function0<? extends DatadogTracer> globalTracerProvider, ApmNetworkTracingScope networkTracingScope, boolean z2) {
        Intrinsics.checkNotNullParameter(tracedHostsWithHeaderType, "tracedHostsWithHeaderType");
        Intrinsics.checkNotNullParameter(localTracerFactory, "localTracerFactory");
        Intrinsics.checkNotNullParameter(traceContextInjection, "traceContextInjection");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(traceSampler, "traceSampler");
        Intrinsics.checkNotNullParameter(globalTracerProvider, "globalTracerProvider");
        Intrinsics.checkNotNullParameter(networkTracingScope, "networkTracingScope");
        this.tracedHostsWithHeaderType = tracedHostsWithHeaderType;
        this.traceOrigin = str;
        this.redacted404ResourceName = z;
        this.sdkInstanceName = str2;
        this.localTracerFactory = localTracerFactory;
        this.traceContextInjection = traceContextInjection;
        this.tracedRequestListener = tracedRequestListener;
        this.traceSampler = traceSampler;
        this.globalTracerProvider = globalTracerProvider;
        this.networkTracingScope = networkTracingScope;
        this.headerPropagationOnly = z2;
    }

    public final Map<String, Set<TracingHeaderType>> getTracedHostsWithHeaderType$dd_sdk_android_trace_release() {
        return this.tracedHostsWithHeaderType;
    }

    public final String getTraceOrigin$dd_sdk_android_trace_release() {
        return this.traceOrigin;
    }

    public final void setTraceOrigin$dd_sdk_android_trace_release(String str) {
        this.traceOrigin = str;
    }

    /* JADX INFO: renamed from: getRedacted404ResourceName$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getRedacted404ResourceName() {
        return this.redacted404ResourceName;
    }

    public final void setRedacted404ResourceName$dd_sdk_android_trace_release(boolean z) {
        this.redacted404ResourceName = z;
    }

    /* JADX INFO: renamed from: getSdkInstanceName$dd_sdk_android_trace_release, reason: from getter */
    public final String getSdkInstanceName() {
        return this.sdkInstanceName;
    }

    public final void setSdkInstanceName$dd_sdk_android_trace_release(String str) {
        this.sdkInstanceName = str;
    }

    public /* synthetic */ ApmNetworkInstrumentationConfiguration(Map map, String str, boolean z, String str2, Function2 function2, TraceContextInjection traceContextInjection, NoOpNetworkTracedRequestListener noOpNetworkTracedRequestListener, DeterministicTraceSampler deterministicTraceSampler, AnonymousClass1 anonymousClass1, ApmNetworkTracingScope apmNetworkTracingScope, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? DEFAULT_LOCAL_TRACER_FACTORY : function2, (i & 32) != 0 ? TraceContextInjection.SAMPLED : traceContextInjection, (i & 64) != 0 ? new NoOpNetworkTracedRequestListener() : noOpNetworkTracedRequestListener, (i & 128) != 0 ? new DeterministicTraceSampler(100.0f) : deterministicTraceSampler, (i & 256) != 0 ? new Function0<DatadogTracer>() { // from class: com.datadog.android.trace.ApmNetworkInstrumentationConfiguration.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DatadogTracer invoke() {
                return GlobalDatadogTracer.INSTANCE.getOrNull();
            }
        } : anonymousClass1, (i & 512) != 0 ? ApmNetworkTracingScope.EXCLUDE_INTERNAL_REDIRECTS : apmNetworkTracingScope, (i & 1024) != 0 ? false : z2);
    }

    public final Function2<SdkCore, Set<? extends TracingHeaderType>, DatadogTracer> getLocalTracerFactory$dd_sdk_android_trace_release() {
        return this.localTracerFactory;
    }

    /* JADX INFO: renamed from: setLocalTracerFactory$dd_sdk_android_trace_release, reason: collision with other method in class */
    public final void m11154setLocalTracerFactory$dd_sdk_android_trace_release(Function2<? super SdkCore, ? super Set<? extends TracingHeaderType>, ? extends DatadogTracer> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.localTracerFactory = function2;
    }

    /* JADX INFO: renamed from: getTraceContextInjection$dd_sdk_android_trace_release, reason: from getter */
    public final TraceContextInjection getTraceContextInjection() {
        return this.traceContextInjection;
    }

    public final void setTraceContextInjection$dd_sdk_android_trace_release(TraceContextInjection traceContextInjection) {
        Intrinsics.checkNotNullParameter(traceContextInjection, "<set-?>");
        this.traceContextInjection = traceContextInjection;
    }

    /* JADX INFO: renamed from: getTracedRequestListener$dd_sdk_android_trace_release, reason: from getter */
    public final NetworkTracedRequestListener getTracedRequestListener() {
        return this.tracedRequestListener;
    }

    public final void setTracedRequestListener$dd_sdk_android_trace_release(NetworkTracedRequestListener networkTracedRequestListener) {
        Intrinsics.checkNotNullParameter(networkTracedRequestListener, "<set-?>");
        this.tracedRequestListener = networkTracedRequestListener;
    }

    public final Sampler<DatadogSpan> getTraceSampler$dd_sdk_android_trace_release() {
        return this.traceSampler;
    }

    public final void setTraceSampler$dd_sdk_android_trace_release(Sampler<DatadogSpan> sampler) {
        Intrinsics.checkNotNullParameter(sampler, "<set-?>");
        this.traceSampler = sampler;
    }

    public final Function0<DatadogTracer> getGlobalTracerProvider$dd_sdk_android_trace_release() {
        return this.globalTracerProvider;
    }

    /* JADX INFO: renamed from: setGlobalTracerProvider$dd_sdk_android_trace_release, reason: collision with other method in class */
    public final void m11153setGlobalTracerProvider$dd_sdk_android_trace_release(Function0<? extends DatadogTracer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.globalTracerProvider = function0;
    }

    /* JADX INFO: renamed from: getNetworkTracingScope$dd_sdk_android_trace_release, reason: from getter */
    public final ApmNetworkTracingScope getNetworkTracingScope() {
        return this.networkTracingScope;
    }

    public final void setNetworkTracingScope$dd_sdk_android_trace_release(ApmNetworkTracingScope apmNetworkTracingScope) {
        Intrinsics.checkNotNullParameter(apmNetworkTracingScope, "<set-?>");
        this.networkTracingScope = apmNetworkTracingScope;
    }

    /* JADX INFO: renamed from: getHeaderPropagationOnly$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getHeaderPropagationOnly() {
        return this.headerPropagationOnly;
    }

    public final void setHeaderPropagationOnly$dd_sdk_android_trace_release(boolean z) {
        this.headerPropagationOnly = z;
    }

    public ApmNetworkInstrumentationConfiguration(List<String> tracedHosts) {
        Intrinsics.checkNotNullParameter(tracedHosts, "tracedHosts");
        List<String> list = tracedHosts;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, SetsKt.setOf((Object[]) new TracingHeaderType[]{TracingHeaderType.DATADOG, TracingHeaderType.TRACECONTEXT}));
        }
        this(linkedHashMap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApmNetworkInstrumentationConfiguration(Map<String, ? extends Set<? extends TracingHeaderType>> tracedHostsWithHeaderType) {
        this(tracedHostsWithHeaderType, null, false, null, null, null, null, null, null, null, false, 1022, null);
        Intrinsics.checkNotNullParameter(tracedHostsWithHeaderType, "tracedHostsWithHeaderType");
    }

    public static /* synthetic */ ApmNetworkInstrumentationConfiguration setTraceOrigin$default(ApmNetworkInstrumentationConfiguration apmNetworkInstrumentationConfiguration, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return apmNetworkInstrumentationConfiguration.setTraceOrigin(str, z);
    }

    public final ApmNetworkInstrumentationConfiguration setTraceOrigin(String traceOrigin, boolean replace) {
        Intrinsics.checkNotNullParameter(traceOrigin, "traceOrigin");
        if (!replace && this.traceOrigin != null) {
            return this;
        }
        this.traceOrigin = traceOrigin;
        return this;
    }

    public final String getTraceOrigin() {
        return this.traceOrigin;
    }

    public final ApmNetworkInstrumentationConfiguration setSdkInstanceName(String sdkInstanceName) {
        Intrinsics.checkNotNullParameter(sdkInstanceName, "sdkInstanceName");
        this.sdkInstanceName = sdkInstanceName;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setTracedRequestListener(NetworkTracedRequestListener tracedRequestListener) {
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        this.tracedRequestListener = tracedRequestListener;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setTraceSampleRate(float sampleRate) {
        this.traceSampler = new DeterministicTraceSampler(sampleRate);
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setTraceSampler(Sampler<DatadogSpan> traceSampler) {
        Intrinsics.checkNotNullParameter(traceSampler, "traceSampler");
        this.traceSampler = traceSampler;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setTraceContextInjection(TraceContextInjection traceContextInjection) {
        Intrinsics.checkNotNullParameter(traceContextInjection, "traceContextInjection");
        this.traceContextInjection = traceContextInjection;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration set404ResourcesRedacted(boolean redacted) {
        this.redacted404ResourceName = redacted;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setTraceScope(ApmNetworkTracingScope networkTracingScope) {
        Intrinsics.checkNotNullParameter(networkTracingScope, "networkTracingScope");
        this.networkTracingScope = networkTracingScope;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setHeaderPropagationOnly() {
        this.headerPropagationOnly = true;
        return this;
    }

    public final boolean isHeaderPropagationOnly() {
        return this.headerPropagationOnly;
    }

    public final ApmNetworkInstrumentationConfiguration copy() {
        return new ApmNetworkInstrumentationConfiguration(INSTANCE.deepCopy(this.tracedHostsWithHeaderType), this.traceOrigin, this.redacted404ResourceName, this.sdkInstanceName, this.localTracerFactory, this.traceContextInjection, this.tracedRequestListener, this.traceSampler, this.globalTracerProvider, this.networkTracingScope, this.headerPropagationOnly);
    }

    public final ApmNetworkInstrumentationConfiguration setLocalTracerFactory$dd_sdk_android_trace_release(Function2<? super SdkCore, ? super Set<? extends TracingHeaderType>, ? extends DatadogTracer> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.localTracerFactory = factory;
        return this;
    }

    public final ApmNetworkInstrumentationConfiguration setGlobalTracerProvider$dd_sdk_android_trace_release(Function0<? extends DatadogTracer> globalTracerProvider) {
        Intrinsics.checkNotNullParameter(globalTracerProvider, "globalTracerProvider");
        this.globalTracerProvider = globalTracerProvider;
        return this;
    }

    /* JADX INFO: compiled from: ApmNetworkInstrumentationConfiguration.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010H\u0002J\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J0\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/trace/ApmNetworkInstrumentationConfiguration$Companion;", "", "()V", "ALL_IN_SAMPLE_RATE", "", "DEFAULT_LOCAL_TRACER_FACTORY", "Lkotlin/Function2;", "Lcom/datadog/android/api/SdkCore;", "", "Lcom/datadog/android/trace/TracingHeaderType;", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "DEFAULT_TRACE_SAMPLE_RATE", "", "NETWORK_REQUESTS_TRACKING_FEATURE_NAME", "", "resolveHosts", "", "tracedHosts", "createInstrumentation", "Lcom/datadog/android/trace/internal/ApmNetworkInstrumentation;", "Lcom/datadog/android/trace/ApmNetworkInstrumentationConfiguration;", "instrumentationName", "createInstrumentation$dd_sdk_android_trace_release", "deepCopy", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApmNetworkInstrumentation createInstrumentation$dd_sdk_android_trace_release(ApmNetworkInstrumentationConfiguration apmNetworkInstrumentationConfiguration, String instrumentationName) {
            Intrinsics.checkNotNullParameter(apmNetworkInstrumentationConfiguration, "<this>");
            Intrinsics.checkNotNullParameter(instrumentationName, "instrumentationName");
            DefaultFirstPartyHostHeaderTypeResolver defaultFirstPartyHostHeaderTypeResolver = new DefaultFirstPartyHostHeaderTypeResolver(resolveHosts(apmNetworkInstrumentationConfiguration.getTracedHostsWithHeaderType$dd_sdk_android_trace_release()));
            TracerProvider tracerProvider = new TracerProvider(apmNetworkInstrumentationConfiguration.getLocalTracerFactory$dd_sdk_android_trace_release(), apmNetworkInstrumentationConfiguration.getGlobalTracerProvider$dd_sdk_android_trace_release());
            SessionRebasedSampler traceSampler$dd_sdk_android_trace_release = apmNetworkInstrumentationConfiguration.getTraceSampler$dd_sdk_android_trace_release();
            if (apmNetworkInstrumentationConfiguration.getHeaderPropagationOnly() && traceSampler$dd_sdk_android_trace_release.getClass() == DeterministicTraceSampler.class) {
                Intrinsics.checkNotNull(traceSampler$dd_sdk_android_trace_release, "null cannot be cast to non-null type com.datadog.android.trace.DeterministicTraceSampler");
                traceSampler$dd_sdk_android_trace_release = new SessionRebasedSampler((DeterministicTraceSampler) traceSampler$dd_sdk_android_trace_release);
            }
            Sampler<DatadogSpan> sampler = traceSampler$dd_sdk_android_trace_release;
            boolean z = !apmNetworkInstrumentationConfiguration.getHeaderPropagationOnly();
            String traceOrigin$dd_sdk_android_trace_release = apmNetworkInstrumentationConfiguration.getTraceOrigin$dd_sdk_android_trace_release();
            return new ApmNetworkInstrumentation(z, apmNetworkInstrumentationConfiguration.getSdkInstanceName(), traceOrigin$dd_sdk_android_trace_release, tracerProvider, apmNetworkInstrumentationConfiguration.getRedacted404ResourceName(), sampler, apmNetworkInstrumentationConfiguration.getTraceContextInjection(), apmNetworkInstrumentationConfiguration.getTracedRequestListener(), defaultFirstPartyHostHeaderTypeResolver, instrumentationName, apmNetworkInstrumentationConfiguration.getNetworkTracingScope());
        }

        private final Map<String, Set<TracingHeaderType>> resolveHosts(Map<String, ? extends Set<? extends TracingHeaderType>> tracedHosts) {
            List<String> listSanitizeHosts = new HostsSanitizer(null, 1, null).sanitizeHosts(CollectionsKt.toList(tracedHosts.keySet()), ApmNetworkInstrumentationConfiguration.NETWORK_REQUESTS_TRACKING_FEATURE_NAME);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<? extends TracingHeaderType>> entry : tracedHosts.entrySet()) {
                if (listSanitizeHosts.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Set<TracingHeaderType>> deepCopy(Map<String, ? extends Set<? extends TracingHeaderType>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), CollectionsKt.toSet((Set) entry.getValue()));
            }
            return linkedHashMap;
        }
    }
}
