package com.datadog.trace.core.propagation;

import androidx.work.WorkInfo;
import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD128bTraceId;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.api.internal.util.LongStringUtils;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class W3CHttpCodec {
    public static final String BAGGAGE_KEY = "baggage";
    private static final String E2E_START_KEY = "ot-baggage-t0";
    static final String OT_BAGGAGE_PREFIX = "ot-baggage-";
    private static final int TRACE_PARENT_FLAGS_SAMPLED = 1;
    private static final int TRACE_PARENT_FLAGS_START = 53;
    public static final String TRACE_PARENT_KEY = "traceparent";
    private static final int TRACE_PARENT_LENGTH = 55;
    private static final int TRACE_PARENT_SID_END = 52;
    private static final int TRACE_PARENT_SID_START = 36;
    private static final int TRACE_PARENT_TID_END = 35;
    private static final int TRACE_PARENT_TID_START = 3;
    public static final String TRACE_STATE_KEY = "tracestate";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) W3CHttpCodec.class);

    private W3CHttpCodec() {
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
            injectTraceParent(dDSpanContext, c, setter);
            injectTraceState(dDSpanContext, c, setter);
            injectBaggage(dDSpanContext, c, setter);
        }

        private <C> void injectTraceParent(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("00-");
            sb.append(dDSpanContext.getTraceId().toHexString());
            sb.append("-");
            sb.append(DDSpanId.toHexStringPadded(dDSpanContext.getSpanId()));
            sb.append(dDSpanContext.getTraceSamplingPriority() > 0 ? "-01" : "-00");
            setter.set(c, W3CHttpCodec.TRACE_PARENT_KEY, sb.toString());
        }

        private <C> void injectTraceState(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            String strHeaderValue = dDSpanContext.getPropagationTags().headerValue(PropagationTags.HeaderType.W3C);
            if (strHeaderValue == null || strHeaderValue.isEmpty()) {
                return;
            }
            setter.set(c, W3CHttpCodec.TRACE_STATE_KEY, strHeaderValue);
        }

        private <C> void injectBaggage(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            long endToEndStartTime = dDSpanContext.getEndToEndStartTime();
            if (endToEndStartTime > 0) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                setter.set(c, W3CHttpCodec.E2E_START_KEY, Long.toString(endToEndStartTime / 1000000));
            }
            for (Map.Entry<String, String> entry : dDSpanContext.baggageItems()) {
                String str = this.invertedBaggageMapping.get(entry.getKey());
                if (str == null) {
                    str = W3CHttpCodec.OT_BAGGAGE_PREFIX + entry.getKey();
                }
                setter.set(c, str, HttpCodec.encodeBaggage(entry.getValue()));
            }
            Baggage baggageComposeBaggage = HttpCodec.composeBaggage(dDSpanContext);
            if (baggageComposeBaggage.isEmpty()) {
                return;
            }
            setter.set(c, W3CHttpCodec.BAGGAGE_KEY, baggageComposeBaggage.toString());
        }
    }

    static /* synthetic */ ContextInterpreter lambda$newExtractor$0(Config config) {
        return new W3CContextInterpreter(config);
    }

    public static HttpCodec.Extractor newExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.W3CHttpCodec$$ExternalSyntheticLambda0
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return W3CHttpCodec.lambda$newExtractor$0(config);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class W3CContextInterpreter extends ContextInterpreter {
        private static final int E2E_START = 3;
        private static final int IGNORE = -1;
        private static final int OT_BAGGAGE = 2;
        private static final int TRACE_PARENT = 0;
        private static final int TRACE_STATE = 1;
        private String traceparentHeader;
        private String tracestateHeader;

        private W3CContextInterpreter(Config config) {
            super(config);
            this.tracestateHeader = null;
            this.traceparentHeader = null;
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.TRACECONTEXT;
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public ContextInterpreter reset(TraceConfig traceConfig) {
            this.tracestateHeader = null;
            this.traceparentHeader = null;
            return super.reset(traceConfig);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x007e A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:46:0x0082 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x0084 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:48:0x0086 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:50:0x0089 A[Catch: RuntimeException -> 0x00bd, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x00bd, blocks: (B:50:0x0089, B:51:0x0094, B:53:0x009c, B:54:0x00a3, B:55:0x00b3, B:57:0x00b8), top: B:70:0x0080 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0094 A[Catch: RuntimeException -> 0x00bd, TryCatch #0 {RuntimeException -> 0x00bd, blocks: (B:50:0x0089, B:51:0x0094, B:53:0x009c, B:54:0x00a3, B:55:0x00b3, B:57:0x00b8), top: B:70:0x0080 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x009c A[Catch: RuntimeException -> 0x00bd, TryCatch #0 {RuntimeException -> 0x00bd, blocks: (B:50:0x0089, B:51:0x0094, B:53:0x009c, B:54:0x00a3, B:55:0x00b3, B:57:0x00b8), top: B:70:0x0080 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x00b3 A[Catch: RuntimeException -> 0x00bd, TryCatch #0 {RuntimeException -> 0x00bd, blocks: (B:50:0x0089, B:51:0x0094, B:53:0x009c, B:54:0x00a3, B:55:0x00b3, B:57:0x00b8), top: B:70:0x0080 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x00b8 A[Catch: RuntimeException -> 0x00bd, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x00bd, blocks: (B:50:0x0089, B:51:0x0094, B:53:0x009c, B:54:0x00a3, B:55:0x00b3, B:57:0x00b8), top: B:70:0x0080 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:70:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            byte b;
            if (str != null && !str.isEmpty()) {
                if (LOG_EXTRACT_HEADER_NAMES) {
                    W3CHttpCodec.log.debug("Header: {}", str);
                }
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String lowerCase2 = null;
                if (lowerCase != 'f') {
                    if (lowerCase == 'o') {
                        lowerCase2 = toLowerCase(str);
                        if (W3CHttpCodec.E2E_START_KEY.equals(lowerCase2)) {
                            b = 3;
                        } else if (lowerCase2.startsWith(W3CHttpCodec.OT_BAGGAGE_PREFIX)) {
                            b = 2;
                        }
                    } else if (lowerCase != 'x') {
                        if (lowerCase == 't') {
                            if (W3CHttpCodec.TRACE_PARENT_KEY.equalsIgnoreCase(str)) {
                                b = 0;
                            } else if (W3CHttpCodec.TRACE_STATE_KEY.equalsIgnoreCase(str)) {
                                b = 1;
                            }
                        } else if (lowerCase == 'u' && handledUserAgent(str, str2)) {
                            return true;
                        }
                    } else if (handledXForwarding(str, str2)) {
                        return true;
                    }
                    if (b != -1) {
                        if (str2 != null) {
                            try {
                                if (b != 0) {
                                    return storeTraceParent(str2);
                                }
                                if (b != 1) {
                                    return storeTraceState(str2);
                                }
                                if (b != 2) {
                                    if (this.baggage.isEmpty()) {
                                        this.baggage = new TreeMap();
                                    }
                                    this.baggage.put(lowerCase2.substring(11), HttpCodec.decode(str2));
                                } else if (b == 3) {
                                    this.endToEndStartTime = extractEndToEndStartTime(HttpCodec.firstHeaderValue(str2));
                                }
                            } catch (RuntimeException e) {
                                invalidateContext();
                                W3CHttpCodec.log.debug("Exception when extracting context", (Throwable) e);
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
                        if (b != 0) {
                            return storeTraceParent(str2);
                        }
                        if (b != 1) {
                            return storeTraceState(str2);
                        }
                        if (b != 2) {
                            if (this.baggage.isEmpty()) {
                                this.baggage = new TreeMap();
                            }
                            this.baggage.put(lowerCase2.substring(11), HttpCodec.decode(str2));
                        } else if (b == 3) {
                            this.endToEndStartTime = extractEndToEndStartTime(HttpCodec.firstHeaderValue(str2));
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

        private long extractEndToEndStartTime(String str) {
            try {
                return TimeUnit.MILLISECONDS.toNanos(Long.parseLong(str));
            } catch (RuntimeException e) {
                W3CHttpCodec.log.debug("Ignoring invalid end-to-end start time {}", str, e);
                return 0L;
            }
        }

        private boolean storeTraceParent(String str) {
            String strTrim = trim(str);
            if (this.traceparentHeader != null) {
                if (W3CHttpCodec.log.isDebugEnabled()) {
                    W3CHttpCodec.log.debug("Multiple traceparent headers. Had '{}' and got '{}'", this.traceparentHeader, strTrim);
                }
                onlyTagContext();
                return true;
            }
            this.traceparentHeader = strTrim;
            return true;
        }

        private boolean storeTraceState(String str) {
            String strTrim = trim(str);
            if (strTrim.isEmpty()) {
                return true;
            }
            if (this.tracestateHeader != null) {
                strTrim = this.tracestateHeader + WebViewLogEventConsumer.DDTAGS_SEPARATOR + strTrim;
            }
            this.tracestateHeader = strTrim;
            return true;
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        protected TagContext build() {
            if (this.traceparentHeader == null && this.tracestateHeader == null) {
                onlyTagContext();
            }
            if (this.valid && this.fullContext) {
                try {
                    String str = this.traceparentHeader;
                    if (str == null && this.tracestateHeader != null) {
                        throw new IllegalStateException("Found no traceparent header but tracestate header '" + this.tracestateHeader + "'");
                    }
                    parseTraceParentHeader(str);
                    parseTraceStateHeader(this.tracestateHeader);
                } catch (RuntimeException e) {
                    onlyTagContext();
                    W3CHttpCodec.log.debug("Exception when building context", (Throwable) e);
                }
            }
            return super.build();
        }

        void parseTraceParentHeader(String str) {
            int length = str == null ? 0 : str.length();
            if (length < 55) {
                throw new IllegalStateException("The length of traceparent '" + str + "' is too short");
            }
            long unsignedLongHex = LongStringUtils.parseUnsignedLongHex(str, 0, 2, true);
            if (unsignedLongHex == 255) {
                throw new IllegalStateException("Illegal version number " + str.substring(0, 2));
            }
            if (unsignedLongHex == 0 && length > 55) {
                throw new IllegalStateException("The length of traceparent '" + str + "' is too long");
            }
            DD128bTraceId dD128bTraceIdFromHex = DD128bTraceId.fromHex(str, 3, 32, true);
            if (dD128bTraceIdFromHex.toLong() == 0) {
                throw new IllegalStateException("Illegal all zero 64 bit trace id " + str.substring(3, 35));
            }
            this.traceId = dD128bTraceIdFromHex;
            this.spanId = DDSpanId.fromHex(str, 36, 16, true);
            if (this.spanId == 0) {
                throw new IllegalStateException("Illegal all zero span id " + str.substring(36, 52));
            }
            if (unsignedLongHex != 0 && length > 55 && str.charAt(55) != '-') {
                throw new IllegalStateException("Illegal character after flags in '" + str + "'");
            }
            if ((LongStringUtils.parseUnsignedLongHex(str, 53, 2, true) & 1) != 0) {
                this.samplingPriority = 1;
            } else {
                this.samplingPriority = 0;
            }
        }

        void parseTraceStateHeader(String str) {
            if (str == null || str.isEmpty()) {
                this.propagationTags = this.propagationTagsFactory.empty();
            } else {
                this.propagationTags = this.propagationTagsFactory.fromHeaderValue(PropagationTags.HeaderType.W3C, str);
            }
            int samplingPriority = this.propagationTags.getSamplingPriority();
            int i = this.samplingPriority;
            if ((i == 0 && samplingPriority > 0) || ((i == 1 && samplingPriority <= 0) || samplingPriority == -128)) {
                this.propagationTags.updateTraceSamplingPriority(i, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT);
            } else {
                this.samplingPriority = samplingPriority;
            }
            this.origin = this.propagationTags.getOrigin();
            this.propagationTags.updateTraceIdHighOrderBits(this.traceId.toHighOrderLong());
        }

        private static String trim(String str) {
            char cCharAt;
            if (str == null) {
                return "";
            }
            int length = str.length() - 1;
            if (length != 0) {
                int i = 0;
                while (i <= length && ((cCharAt = str.charAt(i)) == '\t' || cCharAt == ' ')) {
                    i++;
                }
                int i2 = length;
                while (i2 > i) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 != '\t' && cCharAt2 != ' ') {
                        break;
                    }
                    i2--;
                }
                if (i != 0 || i2 != length) {
                    return str.substring(i, i2 + 1);
                }
            }
            return str;
        }
    }
}
