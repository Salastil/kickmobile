package com.datadog.android.trace.internal;

import com.datadog.android.api.instrumentation.network.ExtendedRequestInfoKt;
import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.TraceContextInjection;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import com.datadog.android.trace.internal.net.ApmNetworkInstrumentationExtKt;
import com.datadog.android.trace.internal.net.TraceContext;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.core.propagation.B3HttpCodec;
import com.datadog.trace.core.propagation.DatadogHttpCodec;
import com.datadog.trace.core.propagation.ExtractedContext;
import com.datadog.trace.core.propagation.W3CHttpCodec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DatadogPropagationHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006J,\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ&\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006*"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogPropagationHelper;", "", "()V", "createExtractedContext", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "traceId", "", "spanId", "samplingPriority", "", "extractParentContext", "Lcom/datadog/android/trace/internal/ParentContextSource;", "tracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "extractSamplingDecision", "", "ignoreLocalDroppedParent", "(Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;Z)Ljava/lang/Boolean;", "extractSamplingDecisionFromHeader", "(Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;)Ljava/lang/Boolean;", "extractTraceContext", "isExtractedContext", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "propagateNotSampledHeaders", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "builder", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "tracingHeaderTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "injectionType", "Lcom/datadog/android/trace/TraceContextInjection;", "traceOrigin", "propagateSampledHeaders", "removeAllTracingHeaders", "setTraceContext", "", "requestInfoBuilder", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogPropagationHelper {
    private static final Set<String> ALL_TRACING_HEADERS;
    private static final Set<String> B3M_CODEC_HEADERS;
    public static final String B3M_DROP_SAMPLING_DECISION = "0";
    public static final String B3_DROP_SAMPLING_DECISION = "0";
    public static final int B3_SAMPLING_DECISION_INDEX = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> DATADOG_CODEC_HEADERS;
    public static final String DATADOG_DROP_SAMPLING_DECISION = "0";
    private static final Set<String> W3C_CODEC_HEADERS;
    public static final int W3C_PARENT_ID_LENGTH = 16;
    public static final int W3C_SAMPLING_DECISION_INDEX = 3;
    public static final int W3C_TRACE_ID_LENGTH = 32;
    public static final String W3C_TRACE_PARENT_DROP_SAMPLING_DECISION = "00-%s-%s-00";
    public static final String W3C_TRACE_STATE_DROP_SAMPLING_DECISION = "dd=p:%s;s:0";

    /* JADX INFO: compiled from: DatadogPropagationHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TracingHeaderType.values().length];
            try {
                iArr[TracingHeaderType.DATADOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TracingHeaderType.B3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TracingHeaderType.B3MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TracingHeaderType.TRACECONTEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean isExtractedContext(DatadogSpanContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof DatadogSpanContextAdapter) {
            return ((DatadogSpanContextAdapter) context).getDelegate() instanceof ExtractedContext;
        }
        return false;
    }

    public final void setTraceContext(HttpRequestInfoBuilder requestInfoBuilder, String traceId, String spanId, int samplingPriority) {
        Intrinsics.checkNotNullParameter(requestInfoBuilder, "requestInfoBuilder");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        requestInfoBuilder.addTag(TraceContext.class, new TraceContext(traceId, spanId, samplingPriority));
    }

    public final ParentContextSource extractParentContext(DatadogTracer tracer, HttpRequestInfo request) {
        Intrinsics.checkNotNullParameter(tracer, "tracer");
        Intrinsics.checkNotNullParameter(request, "request");
        DatadogSpanContext datadogSpanContextExtractTraceContext = extractTraceContext(request);
        DatadogSpanContext datadogSpanContextExtract = tracer.propagate().extract(request, new Function2<HttpRequestInfo, Function2<? super String, ? super String, ? extends Boolean>, Unit>() { // from class: com.datadog.android.trace.internal.DatadogPropagationHelper$extractParentContext$headerContext$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestInfo httpRequestInfo, Function2<? super String, ? super String, ? extends Boolean> function2) {
                invoke2(httpRequestInfo, (Function2<? super String, ? super String, Boolean>) function2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestInfo carrier, Function2<? super String, ? super String, Boolean> classifier) {
                Intrinsics.checkNotNullParameter(carrier, "carrier");
                Intrinsics.checkNotNullParameter(classifier, "classifier");
                Map<String, List<String>> headers = carrier.getHeaders();
                ArrayList arrayList = new ArrayList(headers.size());
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    arrayList.add(TuplesKt.to(entry.getKey(), CollectionsKt.joinToString$default(entry.getValue(), ";", null, null, 0, null, null, 62, null)));
                }
                for (Map.Entry entry2 : MapsKt.toMap(arrayList).entrySet()) {
                    classifier.invoke((String) entry2.getKey(), (String) entry2.getValue());
                }
            }
        });
        if (datadogSpanContextExtract != null && isExtractedContext(datadogSpanContextExtract)) {
            return new ParentContextSource.FromHeaders(datadogSpanContextExtract);
        }
        if (datadogSpanContextExtractTraceContext != null) {
            return new ParentContextSource.FromTag(datadogSpanContextExtractTraceContext);
        }
        return null;
    }

    private final DatadogSpanContext extractTraceContext(HttpRequestInfo request) {
        DatadogSpanContext datadogSpanContextContext;
        DatadogSpan datadogSpan = (DatadogSpan) ExtendedRequestInfoKt.tag(request, DatadogSpan.class);
        if (datadogSpan != null && (datadogSpanContextContext = datadogSpan.context()) != null) {
            return datadogSpanContextContext;
        }
        TraceContext traceContext = (TraceContext) ExtendedRequestInfoKt.tag(request, TraceContext.class);
        if (traceContext != null) {
            return createExtractedContext(traceContext.getTraceId(), traceContext.getSpanId(), traceContext.getSamplingPriority());
        }
        return null;
    }

    public final DatadogSpanContext createExtractedContext(String traceId, String spanId, int samplingPriority) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        return new DatadogSpanContextAdapter(new ExtractedContext(DDTraceId.fromHexOrDefault(traceId, DDTraceId.ZERO), DDSpanId.fromHexOrDefault(spanId, 0L), samplingPriority, null, null, null));
    }

    public final HttpRequestInfoBuilder propagateSampledHeaders(HttpRequestInfoBuilder builder, DatadogTracer tracer, DatadogSpan span, final Set<? extends TracingHeaderType> tracingHeaderTypes) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(tracer, "tracer");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(tracingHeaderTypes, "tracingHeaderTypes");
        tracer.propagate().inject(span.context(), builder, new Function3<HttpRequestInfoBuilder, String, String, Unit>() { // from class: com.datadog.android.trace.internal.DatadogPropagationHelper$propagateSampledHeaders$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestInfoBuilder httpRequestInfoBuilder, String str, String str2) {
                invoke2(httpRequestInfoBuilder, str, str2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.DatadogHttpCodec.DATADOG_TAGS_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.W3CHttpCodec.TRACE_PARENT_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.W3CHttpCodec.TRACE_STATE_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
            
                if (r1.contains(com.datadog.android.trace.TracingHeaderType.TRACECONTEXT) == false) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
            
                r2.replaceHeader(r3, r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
            
                r2.removeHeader(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.DatadogHttpCodec.SAMPLING_PRIORITY_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.DatadogHttpCodec.SPAN_ID_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.B3HttpCodec.SPAN_ID_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.B3HttpCodec.TRACE_ID_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x00be, code lost:
            
                if (r1.contains(com.datadog.android.trace.TracingHeaderType.B3MULTI) == false) goto L56;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x00c0, code lost:
            
                r2.replaceHeader(r3, r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
            
                r2.removeHeader(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x00ce, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.DatadogHttpCodec.ORIGIN_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x00d9, code lost:
            
                if (r1.contains(com.datadog.android.trace.TracingHeaderType.DATADOG) == false) goto L65;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x00db, code lost:
            
                r2.replaceHeader(r3, r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
            
                r2.removeHeader(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.B3HttpCodec.SAMPLING_PRIORITY_KEY) == false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
            
                if (r3.equals(com.datadog.trace.core.propagation.DatadogHttpCodec.TRACE_ID_KEY) == false) goto L67;
             */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke2(com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder r2, java.lang.String r3, java.lang.String r4) {
                /*
                    Method dump skipped, instruction units count: 282
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.trace.internal.DatadogPropagationHelper$propagateSampledHeaders$1$1.invoke2(com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder, java.lang.String, java.lang.String):void");
            }
        });
        return builder;
    }

    public final HttpRequestInfoBuilder propagateNotSampledHeaders(HttpRequestInfoBuilder builder, DatadogTracer tracer, DatadogSpan span, Set<? extends TracingHeaderType> tracingHeaderTypes, TraceContextInjection injectionType, String traceOrigin) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(tracer, "tracer");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(tracingHeaderTypes, "tracingHeaderTypes");
        Intrinsics.checkNotNullParameter(injectionType, "injectionType");
        Iterator<? extends TracingHeaderType> it = tracingHeaderTypes.iterator();
        while (it.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[it.next().ordinal()];
            if (i == 1) {
                Iterator<T> it2 = DATADOG_CODEC_HEADERS.iterator();
                while (it2.hasNext()) {
                    builder.removeHeader((String) it2.next());
                }
                if (TraceContextInjection.ALL == injectionType) {
                    INSTANCE.resetDatadogHeaders(builder, span, tracer);
                }
            } else if (i == 2) {
                builder.removeHeader(B3HttpCodec.B3_KEY);
                if (TraceContextInjection.ALL == injectionType) {
                    INSTANCE.resetB3Headers(builder);
                }
            } else if (i == 3) {
                Iterator<T> it3 = B3M_CODEC_HEADERS.iterator();
                while (it3.hasNext()) {
                    builder.removeHeader((String) it3.next());
                }
                if (TraceContextInjection.ALL == injectionType) {
                    INSTANCE.resetB3MultiHeaders(builder);
                }
            } else if (i == 4) {
                Iterator<T> it4 = W3C_CODEC_HEADERS.iterator();
                while (it4.hasNext()) {
                    builder.removeHeader((String) it4.next());
                }
                if (TraceContextInjection.ALL == injectionType) {
                    INSTANCE.resetW3CHeaders(builder, span, traceOrigin);
                }
            }
        }
        return builder;
    }

    public final HttpRequestInfoBuilder removeAllTracingHeaders(HttpRequestInfoBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterator<T> it = ALL_TRACING_HEADERS.iterator();
        while (it.hasNext()) {
            builder.removeHeader((String) it.next());
        }
        return builder;
    }

    public static /* synthetic */ Boolean extractSamplingDecision$default(DatadogPropagationHelper datadogPropagationHelper, HttpRequestInfo httpRequestInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return datadogPropagationHelper.extractSamplingDecision(httpRequestInfo, z);
    }

    public final Boolean extractSamplingDecision(HttpRequestInfo request, boolean ignoreLocalDroppedParent) {
        Intrinsics.checkNotNullParameter(request, "request");
        DatadogSpan datadogSpan = (DatadogSpan) ExtendedRequestInfoKt.tag(request, DatadogSpan.class);
        Boolean boolExtractSamplingDecisionFromHeader = extractSamplingDecisionFromHeader(request);
        TraceContext traceContext = (TraceContext) ExtendedRequestInfoKt.tag(request, TraceContext.class);
        Integer numValueOf = traceContext != null ? Integer.valueOf(traceContext.getSamplingPriority()) : null;
        if (boolExtractSamplingDecisionFromHeader != null) {
            return boolExtractSamplingDecisionFromHeader;
        }
        if (datadogSpan != null) {
            _TraceInternalProxy.INSTANCE.setTracingSamplingPriorityIfNecessary(datadogSpan.context());
            int samplingPriority = datadogSpan.context().getSamplingPriority();
            if (ignoreLocalDroppedParent && ApmNetworkInstrumentationExtKt.isDroppedPriority(Integer.valueOf(samplingPriority))) {
                return null;
            }
            return Boolean.valueOf(samplingPriority > 0);
        }
        if ((numValueOf != null && numValueOf.intValue() == Integer.MIN_VALUE) || numValueOf == null) {
            return null;
        }
        if (ignoreLocalDroppedParent && ApmNetworkInstrumentationExtKt.isDroppedPriority(numValueOf)) {
            return null;
        }
        return Boolean.valueOf(numValueOf.intValue() > 0);
    }

    private final Boolean extractSamplingDecisionFromHeader(HttpRequestInfo request) {
        String str;
        List<String> list = request.getHeaders().get(DatadogHttpCodec.SAMPLING_PRIORITY_KEY);
        Integer intOrNull = (list == null || (str = (String) CollectionsKt.firstOrNull((List) list)) == null) ? null : StringsKt.toIntOrNull(str);
        if (intOrNull != null) {
            if (intOrNull.intValue() == Integer.MIN_VALUE) {
                return null;
            }
            return Boolean.valueOf(intOrNull.intValue() == 2 || intOrNull.intValue() == 1);
        }
        List<String> list2 = request.getHeaders().get(B3HttpCodec.SAMPLING_PRIORITY_KEY);
        String str2 = list2 != null ? (String) CollectionsKt.firstOrNull((List) list2) : null;
        if (str2 != null) {
            if (Intrinsics.areEqual(str2, "1")) {
                return true;
            }
            return Intrinsics.areEqual(str2, "0") ? false : null;
        }
        List<String> list3 = request.getHeaders().get(B3HttpCodec.B3_KEY);
        String str3 = list3 != null ? (String) CollectionsKt.firstOrNull((List) list3) : null;
        if (str3 != null) {
            if (!Intrinsics.areEqual(str3, "0")) {
                List listSplit$default = StringsKt.split$default((CharSequence) str3, new String[]{"-"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() >= 3) {
                    String str4 = (String) listSplit$default.get(2);
                    int iHashCode = str4.hashCode();
                    if (iHashCode != 48) {
                        return iHashCode != 49 ? true : true;
                    }
                    if (str4.equals("0")) {
                        return false;
                    }
                    return null;
                }
            } else {
                return false;
            }
        }
        List<String> list4 = request.getHeaders().get(W3CHttpCodec.TRACE_PARENT_KEY);
        String str5 = list4 != null ? (String) CollectionsKt.firstOrNull((List) list4) : null;
        if (str5 != null) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) str5, new String[]{"-"}, false, 0, 6, (Object) null);
            if (listSplit$default2.size() >= 4) {
                Integer intOrNull2 = StringsKt.toIntOrNull((String) listSplit$default2.get(3));
                if (intOrNull2 != null && intOrNull2.intValue() == 1) {
                    return true;
                }
                if (intOrNull2 != null && intOrNull2.intValue() == 0) {
                    return false;
                }
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: DatadogPropagationHelper.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u0019*\u00020\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001e\u0010!\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010#\u001a\u0004\u0018\u00010\u0005*\u00020\u001aH\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u000e\u0010\u0010\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u000e\u0010\u0013\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogPropagationHelper$Companion;", "", "()V", "ALL_TRACING_HEADERS", "", "", "getALL_TRACING_HEADERS$dd_sdk_android_trace_release", "()Ljava/util/Set;", "B3M_CODEC_HEADERS", "getB3M_CODEC_HEADERS$dd_sdk_android_trace_release", "B3M_DROP_SAMPLING_DECISION", "B3_DROP_SAMPLING_DECISION", "B3_SAMPLING_DECISION_INDEX", "", "DATADOG_CODEC_HEADERS", "getDATADOG_CODEC_HEADERS$dd_sdk_android_trace_release", "DATADOG_DROP_SAMPLING_DECISION", "W3C_CODEC_HEADERS", "getW3C_CODEC_HEADERS$dd_sdk_android_trace_release", "W3C_PARENT_ID_LENGTH", "W3C_SAMPLING_DECISION_INDEX", "W3C_TRACE_ID_LENGTH", "W3C_TRACE_PARENT_DROP_SAMPLING_DECISION", "W3C_TRACE_STATE_DROP_SAMPLING_DECISION", "resetB3Headers", "", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "resetB3MultiHeaders", "resetDatadogHeaders", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "tracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "resetW3CHeaders", "traceOrigin", "resolveExistingBaggageHeaderValue", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getDATADOG_CODEC_HEADERS$dd_sdk_android_trace_release() {
            return DatadogPropagationHelper.DATADOG_CODEC_HEADERS;
        }

        public final Set<String> getB3M_CODEC_HEADERS$dd_sdk_android_trace_release() {
            return DatadogPropagationHelper.B3M_CODEC_HEADERS;
        }

        public final Set<String> getW3C_CODEC_HEADERS$dd_sdk_android_trace_release() {
            return DatadogPropagationHelper.W3C_CODEC_HEADERS;
        }

        public final Set<String> getALL_TRACING_HEADERS$dd_sdk_android_trace_release() {
            return DatadogPropagationHelper.ALL_TRACING_HEADERS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetDatadogHeaders(HttpRequestInfoBuilder httpRequestInfoBuilder, DatadogSpan datadogSpan, DatadogTracer datadogTracer) {
            datadogTracer.propagate().inject(datadogSpan.context(), httpRequestInfoBuilder, new Function3<HttpRequestInfoBuilder, String, String, Unit>() { // from class: com.datadog.android.trace.internal.DatadogPropagationHelper$Companion$resetDatadogHeaders$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestInfoBuilder httpRequestInfoBuilder2, String str, String str2) {
                    invoke2(httpRequestInfoBuilder2, str, str2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestInfoBuilder carrier, String key, String value) {
                    Intrinsics.checkNotNullParameter(carrier, "carrier");
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value, "value");
                    carrier.removeHeader(key);
                    if (DatadogPropagationHelper.INSTANCE.getDATADOG_CODEC_HEADERS$dd_sdk_android_trace_release().contains(key)) {
                        carrier.addHeader(key, value);
                    }
                }
            });
            httpRequestInfoBuilder.replaceHeader(DatadogHttpCodec.SAMPLING_PRIORITY_KEY, "0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetB3Headers(HttpRequestInfoBuilder httpRequestInfoBuilder) {
            httpRequestInfoBuilder.addHeader(B3HttpCodec.B3_KEY, "0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetB3MultiHeaders(HttpRequestInfoBuilder httpRequestInfoBuilder) {
            httpRequestInfoBuilder.addHeader(B3HttpCodec.SAMPLING_PRIORITY_KEY, "0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void resetW3CHeaders(HttpRequestInfoBuilder httpRequestInfoBuilder, DatadogSpan datadogSpan, String str) {
            String hexString = datadogSpan.context().getTraceId().toHexString();
            String strValueOf = String.valueOf(datadogSpan.context().getSpanId());
            String str2 = String.format(DatadogPropagationHelper.W3C_TRACE_PARENT_DROP_SAMPLING_DECISION, Arrays.copyOf(new Object[]{StringsKt.padStart(hexString, 32, '0'), StringsKt.padStart(strValueOf, 16, '0')}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            httpRequestInfoBuilder.addHeader(W3CHttpCodec.TRACE_PARENT_KEY, str2);
            String str3 = String.format(DatadogPropagationHelper.W3C_TRACE_STATE_DROP_SAMPLING_DECISION, Arrays.copyOf(new Object[]{StringsKt.padStart(strValueOf, 16, '0')}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            if (str != null) {
                str3 = str3 + ";o:" + str;
            }
            httpRequestInfoBuilder.addHeader(W3CHttpCodec.TRACE_STATE_KEY, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String resolveExistingBaggageHeaderValue(HttpRequestInfoBuilder httpRequestInfoBuilder) {
            try {
                List<String> listEmptyList = httpRequestInfoBuilder.build().getHeaders().get(W3CHttpCodec.BAGGAGE_KEY);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                Iterator<T> it = listEmptyList.iterator();
                if (!it.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object next = it.next();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    next = _TraceInternalProxy.INSTANCE.mergeBaggage((String) next, str);
                }
                return (String) next;
            } catch (IllegalStateException | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{DatadogHttpCodec.ORIGIN_KEY, DatadogHttpCodec.SPAN_ID_KEY, DatadogHttpCodec.TRACE_ID_KEY, DatadogHttpCodec.DATADOG_TAGS_KEY, DatadogHttpCodec.SAMPLING_PRIORITY_KEY});
        DATADOG_CODEC_HEADERS = of;
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{B3HttpCodec.TRACE_ID_KEY, B3HttpCodec.SPAN_ID_KEY, B3HttpCodec.SAMPLING_PRIORITY_KEY});
        B3M_CODEC_HEADERS = of2;
        Set<String> of3 = SetsKt.setOf((Object[]) new String[]{W3CHttpCodec.TRACE_PARENT_KEY, W3CHttpCodec.TRACE_STATE_KEY});
        W3C_CODEC_HEADERS = of3;
        ALL_TRACING_HEADERS = SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus((Set) of, (Iterable) of2), (Iterable) of3), B3HttpCodec.B3_KEY);
    }
}
