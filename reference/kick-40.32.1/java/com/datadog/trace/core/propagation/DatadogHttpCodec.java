package com.datadog.trace.core.propagation;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD128bTraceId;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class DatadogHttpCodec {
    public static final String DATADOG_TAGS_KEY = "x-datadog-tags";
    private static final String E2E_START_KEY = "ot-baggage-t0";
    public static final String ORIGIN_KEY = "x-datadog-origin";
    static final String OT_BAGGAGE_PREFIX = "ot-baggage-";
    public static final String SAMPLING_PRIORITY_KEY = "x-datadog-sampling-priority";
    public static final String SPAN_ID_KEY = "x-datadog-parent-id";
    public static final String TRACE_ID_KEY = "x-datadog-trace-id";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) DatadogHttpCodec.class);

    private DatadogHttpCodec() {
    }

    public static HttpCodec.Injector newInjector(Map<String, String> map) {
        return new Injector(map);
    }

    private static class Injector implements HttpCodec.Injector {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Map<String, String> invertedBaggageMapping;

        public Injector(Map<String, String> map) {
            this.invertedBaggageMapping = map;
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            setter.set(c, DatadogHttpCodec.TRACE_ID_KEY, dDSpanContext.getTraceId().toString());
            setter.set(c, DatadogHttpCodec.SPAN_ID_KEY, DDSpanId.toString(dDSpanContext.getSpanId()));
            if (dDSpanContext.lockSamplingPriority()) {
                setter.set(c, DatadogHttpCodec.SAMPLING_PRIORITY_KEY, String.valueOf(dDSpanContext.getTraceSamplingPriority()));
            }
            CharSequence origin = dDSpanContext.getOrigin();
            if (origin != null) {
                setter.set(c, DatadogHttpCodec.ORIGIN_KEY, origin.toString());
            }
            long endToEndStartTime = dDSpanContext.getEndToEndStartTime();
            if (endToEndStartTime > 0) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                setter.set(c, DatadogHttpCodec.E2E_START_KEY, Long.toString(endToEndStartTime / 1000000));
            }
            for (Map.Entry<String, String> entry : dDSpanContext.baggageItems()) {
                String str = this.invertedBaggageMapping.get(entry.getKey());
                if (str == null) {
                    str = DatadogHttpCodec.OT_BAGGAGE_PREFIX + entry.getKey();
                }
                setter.set(c, str, HttpCodec.encodeBaggage(entry.getValue()));
            }
            String strHeaderValue = dDSpanContext.getPropagationTags().headerValue(PropagationTags.HeaderType.DATADOG);
            if (strHeaderValue != null) {
                setter.set(c, DatadogHttpCodec.DATADOG_TAGS_KEY, strHeaderValue);
            }
            Baggage baggageComposeBaggage = HttpCodec.composeBaggage(dDSpanContext);
            if (baggageComposeBaggage.isEmpty()) {
                return;
            }
            setter.set(c, W3CHttpCodec.BAGGAGE_KEY, baggageComposeBaggage.toString());
        }
    }

    public static HttpCodec.Extractor newExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.DatadogHttpCodec$$ExternalSyntheticLambda0
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return DatadogHttpCodec.lambda$newExtractor$0(config);
            }
        });
    }

    static /* synthetic */ ContextInterpreter lambda$newExtractor$0(Config config) {
        return new DatadogContextInterpreter(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DatadogContextInterpreter extends ContextInterpreter {
        private static final int DD_TAGS = 6;
        private static final int E2E_START = 5;
        private static final int IGNORE = -1;
        private static final int ORIGIN = 2;
        private static final int OT_BAGGAGE = 4;
        private static final int SAMPLING_PRIORITY = 3;
        private static final int SPAN_ID = 1;
        private static final int TRACE_ID = 0;
        private final boolean isAwsPropagationEnabled;

        private DatadogContextInterpreter(Config config) {
            super(config);
            this.isAwsPropagationEnabled = config.isAwsPropagationEnabled();
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.DATADOG;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:57:0x00a8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:60:0x00af A[Catch: RuntimeException -> 0x010d, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:61:0x00bb A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:62:0x00c6 A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:64:0x00ce A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:66:0x00e5 A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:67:0x00f0 A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:68:0x00f7 A[Catch: RuntimeException -> 0x010d, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:69:0x0102 A[Catch: RuntimeException -> 0x010d, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x010d, blocks: (B:60:0x00af, B:61:0x00bb, B:62:0x00c6, B:64:0x00ce, B:65:0x00d5, B:66:0x00e5, B:67:0x00f0, B:68:0x00f7, B:69:0x0102), top: B:82:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:74:0x011b  */
        /* JADX WARN: Code duplicated, block: B:82:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            byte b;
            if (str != null && !str.isEmpty()) {
                if (LOG_EXTRACT_HEADER_NAMES) {
                    DatadogHttpCodec.log.debug("Header: {}", str);
                }
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String lowerCase2 = null;
                if (lowerCase != 'f') {
                    if (lowerCase == 'o') {
                        lowerCase2 = toLowerCase(str);
                        if (DatadogHttpCodec.E2E_START_KEY.equals(lowerCase2)) {
                            b = 5;
                        } else if (lowerCase2.startsWith(DatadogHttpCodec.OT_BAGGAGE_PREFIX)) {
                            b = 4;
                        }
                    } else if (lowerCase != 'u') {
                        if (lowerCase == 'x') {
                            if (DatadogHttpCodec.TRACE_ID_KEY.equalsIgnoreCase(str)) {
                                b = 0;
                            } else if (DatadogHttpCodec.SPAN_ID_KEY.equalsIgnoreCase(str)) {
                                b = 1;
                            } else if (DatadogHttpCodec.SAMPLING_PRIORITY_KEY.equalsIgnoreCase(str)) {
                                b = 3;
                            } else if (DatadogHttpCodec.ORIGIN_KEY.equalsIgnoreCase(str)) {
                                b = 2;
                            } else {
                                if (this.isAwsPropagationEnabled && "X-Amzn-Trace-Id".equalsIgnoreCase(str)) {
                                    XRayHttpCodec.XRayContextInterpreter.handleXRayTraceHeader(this, str2);
                                    return true;
                                }
                                if (handledXForwarding(str, str2)) {
                                    return true;
                                }
                                if (DatadogHttpCodec.DATADOG_TAGS_KEY.equalsIgnoreCase(str)) {
                                    b = 6;
                                }
                            }
                        }
                    } else if (handledUserAgent(str, str2)) {
                        return true;
                    }
                    if (b != -1) {
                        if (str2 != null) {
                            try {
                                switch (b) {
                                    case 0:
                                        this.traceId = DDTraceId.from(HttpCodec.firstHeaderValue(str2));
                                        break;
                                    case 1:
                                        this.spanId = DDSpanId.from(HttpCodec.firstHeaderValue(str2));
                                        break;
                                    case 2:
                                        this.origin = HttpCodec.firstHeaderValue(str2);
                                        break;
                                    case 3:
                                        this.samplingPriority = Integer.parseInt(HttpCodec.firstHeaderValue(str2));
                                        break;
                                    case 4:
                                        if (this.baggage.isEmpty()) {
                                            this.baggage = new TreeMap();
                                        }
                                        this.baggage.put(lowerCase2.substring(11), HttpCodec.decode(str2));
                                        break;
                                    case 5:
                                        this.endToEndStartTime = extractEndToEndStartTime(HttpCodec.firstHeaderValue(str2));
                                        break;
                                    case 6:
                                        this.propagationTags = this.propagationTagsFactory.fromHeaderValue(PropagationTags.HeaderType.DATADOG, str2);
                                        break;
                                }
                            } catch (RuntimeException e) {
                                invalidateContext();
                                DatadogHttpCodec.log.debug("Exception when extracting context", (Throwable) e);
                                return false;
                            }
                        }
                    } else {
                        if (!handledIpHeaders(str, str2) || handleTags(str, str2)) {
                            return true;
                        }
                        handleMappedBaggage(str, str2);
                    }
                } else if (handledForwarding(str, str2)) {
                    return true;
                }
                b = -1;
                if (b != -1) {
                    if (str2 != null) {
                        switch (b) {
                            case 0:
                                this.traceId = DDTraceId.from(HttpCodec.firstHeaderValue(str2));
                                break;
                            case 1:
                                this.spanId = DDSpanId.from(HttpCodec.firstHeaderValue(str2));
                                break;
                            case 2:
                                this.origin = HttpCodec.firstHeaderValue(str2);
                                break;
                            case 3:
                                this.samplingPriority = Integer.parseInt(HttpCodec.firstHeaderValue(str2));
                                break;
                            case 4:
                                if (this.baggage.isEmpty()) {
                                    this.baggage = new TreeMap();
                                }
                                this.baggage.put(lowerCase2.substring(11), HttpCodec.decode(str2));
                                break;
                            case 5:
                                this.endToEndStartTime = extractEndToEndStartTime(HttpCodec.firstHeaderValue(str2));
                                break;
                            case 6:
                                this.propagationTags = this.propagationTagsFactory.fromHeaderValue(PropagationTags.HeaderType.DATADOG, str2);
                                break;
                        }
                    }
                } else {
                    if (!handledIpHeaders(str, str2)) {
                        return true;
                    }
                    handleMappedBaggage(str, str2);
                }
            }
            return true;
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        protected TagContext build() {
            restore128bTraceId();
            return super.build();
        }

        private long extractEndToEndStartTime(String str) {
            try {
                return TimeUnit.MILLISECONDS.toNanos(Long.parseLong(str));
            } catch (RuntimeException e) {
                DatadogHttpCodec.log.debug("Ignoring invalid end-to-end start time {}", str, e);
                return 0L;
            }
        }

        private void restore128bTraceId() {
            if (this.traceId == DDTraceId.ZERO || this.propagationTags == null) {
                return;
            }
            long traceIdHighOrderBits = this.propagationTags.getTraceIdHighOrderBits();
            if (traceIdHighOrderBits != 0) {
                this.traceId = DD128bTraceId.from(traceIdHighOrderBits, this.traceId.toLong());
            }
        }
    }
}
