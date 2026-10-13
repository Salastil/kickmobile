package com.datadog.trace.core.propagation;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD64bTraceId;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
class HaystackHttpCodec {
    public static final String DATADOG = "44617461-646f-6721";
    private static final String DD_PARENT_ID_BAGGAGE_KEY = "Baggage-Datadog-Parent-Id";
    private static final String DD_SPAN_ID_BAGGAGE_KEY = "Baggage-Datadog-Span-Id";
    private static final String DD_TRACE_ID_BAGGAGE_KEY = "Baggage-Datadog-Trace-Id";
    private static final String HAYSTACK_PARENT_ID_BAGGAGE_KEY = "Haystack-Parent-ID";
    private static final String HAYSTACK_SPAN_ID_BAGGAGE_KEY = "Haystack-Span-ID";
    private static final String HAYSTACK_TRACE_ID_BAGGAGE_KEY = "Haystack-Trace-ID";
    private static final String OT_BAGGAGE_PREFIX = "Baggage-";
    private static final String PARENT_ID_KEY = "Parent-ID";
    private static final String SPAN_ID_KEY = "Span-ID";
    private static final String TRACE_ID_KEY = "Trace-ID";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HaystackHttpCodec.class);

    private HaystackHttpCodec() {
    }

    public static HttpCodec.Injector newInjector(Map<String, String> map) {
        return new Injector(map);
    }

    private static class Injector implements HttpCodec.Injector {
        private final Map<String, String> invertedBaggageMapping;

        public Injector(Map<String, String> map) {
            this.invertedBaggageMapping = map;
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            try {
                String baggageItemIgnoreCase = getBaggageItemIgnoreCase(dDSpanContext.getBaggageItems(), HaystackHttpCodec.HAYSTACK_TRACE_ID_BAGGAGE_KEY);
                if (baggageItemIgnoreCase == null || !DDTraceId.fromHex(HaystackHttpCodec.convertUUIDToHexString(baggageItemIgnoreCase)).equals(dDSpanContext.getTraceId())) {
                    baggageItemIgnoreCase = HaystackHttpCodec.convertLongToUUID(dDSpanContext.getTraceId().toLong());
                }
                setter.set(c, HaystackHttpCodec.TRACE_ID_KEY, baggageItemIgnoreCase);
                dDSpanContext.setTag(HaystackHttpCodec.HAYSTACK_TRACE_ID_BAGGAGE_KEY, baggageItemIgnoreCase);
                setter.set(c, HaystackHttpCodec.DD_TRACE_ID_BAGGAGE_KEY, HttpCodec.encode(dDSpanContext.getTraceId().toString()));
                setter.set(c, HaystackHttpCodec.SPAN_ID_KEY, HaystackHttpCodec.convertLongToUUID(dDSpanContext.getSpanId()));
                setter.set(c, HaystackHttpCodec.DD_SPAN_ID_BAGGAGE_KEY, HttpCodec.encode(DDSpanId.toString(dDSpanContext.getSpanId())));
                setter.set(c, HaystackHttpCodec.PARENT_ID_KEY, HaystackHttpCodec.convertLongToUUID(dDSpanContext.getParentId()));
                setter.set(c, HaystackHttpCodec.DD_PARENT_ID_BAGGAGE_KEY, HttpCodec.encode(DDSpanId.toString(dDSpanContext.getParentId())));
                for (Map.Entry<String, String> entry : dDSpanContext.baggageItems()) {
                    String str = this.invertedBaggageMapping.get(entry.getKey());
                    if (str == null) {
                        str = HaystackHttpCodec.OT_BAGGAGE_PREFIX + entry.getKey();
                    }
                    setter.set(c, str, HttpCodec.encodeBaggage(entry.getValue()));
                }
                HaystackHttpCodec.log.debug("{} - Haystack parent context injected - {}", dDSpanContext.getTraceId(), baggageItemIgnoreCase);
            } catch (NumberFormatException e) {
                HaystackHttpCodec.log.debug("Cannot parse context id(s): {} {}", dDSpanContext.getTraceId(), Long.valueOf(dDSpanContext.getSpanId()), e);
            }
        }

        private String getBaggageItemIgnoreCase(Map<String, String> map, String str) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    public static HttpCodec.Extractor newExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.HaystackHttpCodec$$ExternalSyntheticLambda0
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return HaystackHttpCodec.lambda$newExtractor$0(config);
            }
        });
    }

    static /* synthetic */ ContextInterpreter lambda$newExtractor$0(Config config) {
        return new HaystackContextInterpreter(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class HaystackContextInterpreter extends ContextInterpreter {
        private static final int BAGGAGE = 3;
        private static final String BAGGAGE_PREFIX_LC = "baggage-";
        private static final int IGNORE = -1;
        private static final int PARENT_ID = 2;
        private static final int SPAN_ID = 1;
        private static final int TRACE_ID = 0;

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        protected int defaultSamplingPriority() {
            return 1;
        }

        private HaystackContextInterpreter(Config config) {
            super(config);
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.HAYSTACK;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            String lowerCase;
            byte b;
            if (str != null && !str.isEmpty()) {
                if (LOG_EXTRACT_HEADER_NAMES) {
                    HaystackHttpCodec.log.debug("Header: {}", str);
                }
                char lowerCase2 = Character.toLowerCase(str.charAt(0));
                if (lowerCase2 != 'b') {
                    lowerCase = null;
                    if (lowerCase2 == 'f') {
                        if (handledForwarding(str, str2)) {
                            return true;
                        }
                        b = -1;
                    } else if (lowerCase2 == 'p') {
                        b = HaystackHttpCodec.PARENT_ID_KEY.equalsIgnoreCase(str) ? (byte) 2 : (byte) -1;
                    } else if (lowerCase2 != 'x') {
                        switch (lowerCase2) {
                            case 's':
                                b = !HaystackHttpCodec.SPAN_ID_KEY.equalsIgnoreCase(str) ? (byte) -1 : (byte) 1;
                                break;
                            case 't':
                                b = !HaystackHttpCodec.TRACE_ID_KEY.equalsIgnoreCase(str) ? (byte) -1 : (byte) 0;
                                break;
                            case 'u':
                                if (handledUserAgent(str, str2)) {
                                    return true;
                                }
                                b = -1;
                                break;
                            default:
                                b = -1;
                                break;
                        }
                    } else {
                        if (handledXForwarding(str, str2)) {
                            return true;
                        }
                        b = -1;
                    }
                } else {
                    lowerCase = toLowerCase(str);
                    b = lowerCase.startsWith(BAGGAGE_PREFIX_LC) ? (byte) 3 : (byte) -1;
                }
                if (-1 != b) {
                    try {
                        if (HttpCodec.firstHeaderValue(str2) != null) {
                            if (b == 0) {
                                this.traceId = DD64bTraceId.fromHex(HaystackHttpCodec.convertUUIDToHexString(str2));
                                addBaggageItem(HaystackHttpCodec.HAYSTACK_TRACE_ID_BAGGAGE_KEY, str2);
                            } else if (b == 1) {
                                this.spanId = DDSpanId.fromHex(HaystackHttpCodec.convertUUIDToHexString(str2));
                                addBaggageItem(HaystackHttpCodec.HAYSTACK_SPAN_ID_BAGGAGE_KEY, str2);
                            } else if (b == 2) {
                                addBaggageItem(HaystackHttpCodec.HAYSTACK_PARENT_ID_BAGGAGE_KEY, str2);
                            } else if (b == 3) {
                                addBaggageItem(lowerCase.substring(8), str2);
                            }
                        }
                    } catch (RuntimeException e) {
                        invalidateContext();
                        HaystackHttpCodec.log.debug("Exception when extracting context", (Throwable) e);
                        return false;
                    }
                } else {
                    if (handledIpHeaders(str, str2) || handleTags(str, str2)) {
                        return true;
                    }
                    handleMappedBaggage(str, str2);
                }
            }
            return true;
        }

        private void addBaggageItem(String str, String str2) {
            if (this.baggage.isEmpty()) {
                this.baggage = new TreeMap();
            }
            this.baggage.put(str, HttpCodec.decode(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertLongToUUID(long j) {
        String str = String.format("%016x", Long.valueOf(j));
        return "44617461-646f-6721-" + str.substring(0, 4) + "-" + str.substring(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertUUIDToHexString(String str) {
        try {
            if (!str.contains("-")) {
                return str.length() == 32 ? str.substring(16) : str;
            }
            String[] strArrSplit = str.split("-");
            if (strArrSplit.length != 5) {
                throw new NumberFormatException("Invalid UUID format: " + str);
            }
            return strArrSplit[3] + strArrSplit[4];
        } catch (Exception e) {
            throw new IllegalArgumentException("Exception when converting UUID to BigInteger: " + str, e);
        }
    }
}
