package com.datadog.reactnative;

import com.datadog.android.Datadog;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.DatadogTracing;
import com.datadog.android.trace.GlobalDatadogTracer;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdTraceImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001d\u001a\u00020\u0013*\u00020\n2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/datadog/reactnative/DdTraceImplementation;", "", "tracerProvider", "Lkotlin/Function0;", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "spanMap", "", "", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "scopeMap", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "tracer", "getTracer", "()Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "tracer$delegate", "Lkotlin/Lazy;", "startSpan", "", "operation", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReadableMap;", "timestampMs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "finishSpan", "spanId", "setTags", "tags", "", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdTraceImplementation {
    public static final String NAME = "DdTrace";
    private final Map<String, DatadogScope> scopeMap;
    private final Map<String, DatadogSpan> spanMap;

    /* JADX INFO: renamed from: tracer$delegate, reason: from kotlin metadata */
    private final Lazy tracer;
    private final Function0<DatadogTracer> tracerProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public DdTraceImplementation() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DdTraceImplementation(Function0<? extends DatadogTracer> tracerProvider) {
        Intrinsics.checkNotNullParameter(tracerProvider, "tracerProvider");
        this.tracerProvider = tracerProvider;
        this.spanMap = new LinkedHashMap();
        this.scopeMap = new LinkedHashMap();
        this.tracer = LazyKt.lazy(new Function0() { // from class: com.datadog.reactnative.DdTraceImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.tracerProvider.invoke();
            }
        });
    }

    public /* synthetic */ DdTraceImplementation(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.datadog.reactnative.DdTraceImplementation$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdTraceImplementation._init_$lambda$0();
            }
        } : function0);
    }

    static final DatadogTracer _init_$lambda$0() {
        GlobalDatadogTracer.registerIfAbsent(DatadogTracing.newTracerBuilder(Datadog.getInstance$default(null, 1, null)).build());
        return GlobalDatadogTracer.get();
    }

    private final DatadogTracer getTracer() {
        return (DatadogTracer) this.tracer.getValue();
    }

    public final void startSpan(String operation, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DatadogSpan datadogSpanStart = getTracer().buildSpan(operation).withStartTimestamp(TimeUnit.MILLISECONDS.toMicros((long) timestampMs)).start();
        DatadogScope datadogScopeActivateSpan = getTracer().activateSpan(datadogSpanStart);
        DatadogSpanContext datadogSpanContextContext = datadogSpanStart.context();
        setTags(datadogSpanStart, context.toHashMap());
        setTags(datadogSpanStart, GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release());
        String strValueOf = String.valueOf(datadogSpanContextContext.getSpanId());
        this.spanMap.put(strValueOf, datadogSpanStart);
        if (datadogScopeActivateSpan != null) {
            this.scopeMap.put(strValueOf, datadogScopeActivateSpan);
        }
        promise.resolve(strValueOf);
    }

    public final void finishSpan(String spanId, ReadableMap context, double timestampMs, Promise promise) {
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DatadogScope datadogScopeRemove = this.scopeMap.remove(spanId);
        if (datadogScopeRemove != null) {
            datadogScopeRemove.close();
        }
        DatadogSpan datadogSpanRemove = this.spanMap.remove(spanId);
        if (datadogSpanRemove == null) {
            promise.resolve(null);
            return;
        }
        setTags(datadogSpanRemove, context.toHashMap());
        setTags(datadogSpanRemove, GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release());
        datadogSpanRemove.finish(TimeUnit.MILLISECONDS.toMicros((long) timestampMs));
        promise.resolve(null);
    }

    private final void setTags(DatadogSpan datadogSpan, Map<String, ? extends Object> map) {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                datadogSpan.setTag(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Number) {
                datadogSpan.setTag(key, (Number) value);
            } else if (value instanceof String) {
                datadogSpan.setTag(key, (String) value);
            } else {
                datadogSpan.setTag(key, value != null ? value.toString() : null);
            }
        }
    }
}
