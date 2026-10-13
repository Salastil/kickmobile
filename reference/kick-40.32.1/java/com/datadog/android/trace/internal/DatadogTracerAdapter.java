package com.datadog.android.trace.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.api.propagation.DatadogPropagation;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.scope.DatadogScopeListener;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanBuilder;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTracer;
import com.datadog.trace.bootstrap.instrumentation.api.ScopeSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogTracerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020'H\u0002J\f\u0010(\u001a\u00020\u001f*\u00020\u001fH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogTracerAdapter;", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$TracerAPI;", "bundleWithRumEnabled", "", "spanLogger", "Lcom/datadog/android/trace/internal/DatadogSpanLogger;", "rumContextPropagator", "Lcom/datadog/android/trace/internal/RumContextPropagator;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$TracerAPI;ZLcom/datadog/android/trace/internal/DatadogSpanLogger;Lcom/datadog/android/trace/internal/RumContextPropagator;)V", "getBundleWithRumEnabled$dd_sdk_android_trace_release", "()Z", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$TracerAPI;", "getSdkCore$dd_sdk_android_trace_release", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "activateSpan", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "asyncPropagating", "activateSpan$dd_sdk_android_trace_release", "activeSpan", "addScopeListener", "", "scopeListener", "Lcom/datadog/android/trace/api/scope/DatadogScopeListener;", "buildSpan", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "spanName", "", "instrumentationName", "", "propagate", "Lcom/datadog/android/trace/api/propagation/DatadogPropagation;", "wrapSpan", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentTracer$SpanBuilder;", "withRumContextIfNeeded", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogTracerAdapter implements DatadogTracer {
    private final boolean bundleWithRumEnabled;
    private final AgentTracer.TracerAPI delegate;
    private final RumContextPropagator rumContextPropagator;
    private final FeatureSdkCore sdkCore;
    private final DatadogSpanLogger spanLogger;

    public DatadogTracerAdapter(FeatureSdkCore sdkCore, AgentTracer.TracerAPI delegate, boolean z, DatadogSpanLogger spanLogger, RumContextPropagator rumContextPropagator) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(spanLogger, "spanLogger");
        Intrinsics.checkNotNullParameter(rumContextPropagator, "rumContextPropagator");
        this.sdkCore = sdkCore;
        this.delegate = delegate;
        this.bundleWithRumEnabled = z;
        this.spanLogger = spanLogger;
        this.rumContextPropagator = rumContextPropagator;
    }

    /* JADX INFO: renamed from: getSdkCore$dd_sdk_android_trace_release, reason: from getter */
    public final FeatureSdkCore getSdkCore() {
        return this.sdkCore;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final AgentTracer.TracerAPI getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: renamed from: getBundleWithRumEnabled$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getBundleWithRumEnabled() {
        return this.bundleWithRumEnabled;
    }

    public /* synthetic */ DatadogTracerAdapter(final FeatureSdkCore featureSdkCore, AgentTracer.TracerAPI tracerAPI, boolean z, DatadogSpanLogger datadogSpanLogger, RumContextPropagator rumContextPropagator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, tracerAPI, z, datadogSpanLogger, (i & 16) != 0 ? new RumContextPropagator(new Function0<FeatureSdkCore>() { // from class: com.datadog.android.trace.internal.DatadogTracerAdapter.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeatureSdkCore invoke() {
                return featureSdkCore;
            }
        }) : rumContextPropagator);
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public DatadogSpanBuilder buildSpan(String instrumentationName, CharSequence spanName) {
        Intrinsics.checkNotNullParameter(instrumentationName, "instrumentationName");
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        AgentTracer.SpanBuilder spanBuilderBuildSpan = this.delegate.buildSpan(instrumentationName, spanName);
        Intrinsics.checkNotNullExpressionValue(spanBuilderBuildSpan, "delegate.buildSpan(instrumentationName, spanName)");
        return wrapSpan(spanBuilderBuildSpan);
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public DatadogSpanBuilder buildSpan(CharSequence spanName) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        AgentTracer.SpanBuilder spanBuilderBuildSpan = this.delegate.buildSpan(spanName);
        Intrinsics.checkNotNullExpressionValue(spanBuilderBuildSpan, "delegate.buildSpan(spanName)");
        return wrapSpan(spanBuilderBuildSpan);
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public void addScopeListener(DatadogScopeListener scopeListener) {
        Intrinsics.checkNotNullParameter(scopeListener, "scopeListener");
        this.delegate.addScopeListener(new DatadogScopeListenerAdapter(scopeListener));
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public DatadogPropagation propagate() {
        InternalLogger internalLogger = this.sdkCore.getInternalLogger();
        AgentPropagation agentPropagationPropagate = this.delegate.propagate();
        Intrinsics.checkNotNullExpressionValue(agentPropagationPropagate, "delegate.propagate()");
        return new DatadogPropagationAdapter(internalLogger, agentPropagationPropagate);
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public DatadogSpan activeSpan() {
        AgentSpan agentSpanActiveSpan = this.delegate.activeSpan();
        return agentSpanActiveSpan != null ? new DatadogSpanAdapter(agentSpanActiveSpan, this.spanLogger) : null;
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracer
    public DatadogScope activateSpan(DatadogSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        DatadogScopeAdapter datadogScopeAdapter = null;
        if ((span instanceof DatadogSpanAdapter ? (DatadogSpanAdapter) span : null) != null) {
            AgentScope agentScopeActivateSpan = this.delegate.activateSpan(((DatadogSpanAdapter) span).getDelegate(), ScopeSource.INSTRUMENTATION);
            if (agentScopeActivateSpan == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(agentScopeActivateSpan, "delegate.activateSpan(sp…MENTATION) ?: return null");
            datadogScopeAdapter = new DatadogScopeAdapter(agentScopeActivateSpan);
        }
        return datadogScopeAdapter;
    }

    public final DatadogScope activateSpan$dd_sdk_android_trace_release(DatadogSpan span, boolean asyncPropagating) {
        AgentScope agentScopeActivateSpan;
        Intrinsics.checkNotNullParameter(span, "span");
        DatadogScopeAdapter datadogScopeAdapter = null;
        DatadogSpanAdapter datadogSpanAdapter = span instanceof DatadogSpanAdapter ? (DatadogSpanAdapter) span : null;
        if (datadogSpanAdapter != null && (agentScopeActivateSpan = this.delegate.activateSpan(datadogSpanAdapter.getDelegate(), ScopeSource.INSTRUMENTATION, asyncPropagating)) != null) {
            datadogScopeAdapter = new DatadogScopeAdapter(agentScopeActivateSpan);
        }
        return datadogScopeAdapter;
    }

    private final DatadogSpanBuilder wrapSpan(AgentTracer.SpanBuilder span) {
        return withRumContextIfNeeded(new DatadogSpanBuilderAdapter(span, this.spanLogger));
    }

    private final DatadogSpanBuilder withRumContextIfNeeded(DatadogSpanBuilder datadogSpanBuilder) {
        if (this.bundleWithRumEnabled) {
            RumContextPropagator.INSTANCE.injectRumContext$dd_sdk_android_trace_release(datadogSpanBuilder, this.rumContextPropagator);
        }
        return datadogSpanBuilder;
    }
}
