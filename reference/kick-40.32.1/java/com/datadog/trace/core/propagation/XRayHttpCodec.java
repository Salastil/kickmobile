package com.datadog.trace.core.propagation;

import androidx.media3.common.C;
import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD64bTraceId;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
class XRayHttpCodec {
    static final String E2E_START_KEY = "t0";
    static final String E2E_START_PREFIX = "t0=";
    static final int MAX_ADDITIONAL_BYTES = 256;
    static final String ORIGIN_PREFIX = "_dd.origin=";
    static final String PARENT = "Parent";
    static final String PARENT_PREFIX = "Parent=";
    static final String ROOT = "Root";
    static final String ROOT_PREFIX = "Root=1-";
    static final String SAMPLED = "Sampled";
    static final String SAMPLED_PREFIX = "Sampled=";
    static final String SELF = "Self";
    static final String SELF_PREFIX = "Self=";
    static final String TRACE_ID_PADDING = "-00000000";
    static final String X_AMZN_TRACE_ID = "X-Amzn-Trace-Id";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) XRayHttpCodec.class);
    static final int ROOT_PREAMBLE = 15;

    private XRayHttpCodec() {
    }

    public static HttpCodec.Injector newInjector(Map<String, String> map) {
        return new Injector(map);
    }

    private static class Injector implements HttpCodec.Injector {
        private final Map<String, String> invertedBaggageMapping;

        private char convertSamplingPriority(int i) {
            return i > 0 ? '1' : '0';
        }

        public Injector(Map<String, String> map) {
            this.invertedBaggageMapping = map;
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            long currentTimeMillis;
            long endToEndStartTime = dDSpanContext.getEndToEndStartTime();
            StringBuilder sb = new StringBuilder();
            sb.append(XRayHttpCodec.ROOT_PREFIX);
            if (endToEndStartTime > 0) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                currentTimeMillis = endToEndStartTime / C.NANOS_PER_SECOND;
            } else {
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                currentTimeMillis = dDSpanContext.getTrace().getTimeSource().getCurrentTimeMillis() / 1000;
            }
            sb.append(String.format("%08x", Long.valueOf(currentTimeMillis)));
            sb.append(XRayHttpCodec.TRACE_ID_PADDING);
            sb.append(dDSpanContext.getTraceId().toHexStringPadded(16));
            sb.append(";Parent=");
            sb.append(DDSpanId.toHexStringPadded(dDSpanContext.getSpanId()));
            if (dDSpanContext.lockSamplingPriority()) {
                sb.append(";Sampled=");
                sb.append(convertSamplingPriority(dDSpanContext.getTraceSamplingPriority()));
            }
            int length = sb.length() + 256;
            CharSequence origin = dDSpanContext.getOrigin();
            if (origin != null) {
                additionalPart(sb, DDTags.ORIGIN_KEY, origin.toString(), length);
            }
            if (endToEndStartTime > 0) {
                TimeUnit timeUnit3 = TimeUnit.NANOSECONDS;
                additionalPart(sb, "t0", Long.toString(endToEndStartTime / 1000000), length);
            }
            for (Map.Entry<String, String> entry : dDSpanContext.baggageItems()) {
                String key = this.invertedBaggageMapping.get(entry.getKey());
                if (key == null) {
                    key = entry.getKey();
                }
                if (!isReserved(key)) {
                    additionalPart(sb, key, HttpCodec.encode(entry.getValue()), length);
                }
            }
            setter.set(c, XRayHttpCodec.X_AMZN_TRACE_ID, sb.toString());
        }

        private boolean isReserved(String str) {
            return XRayHttpCodec.ROOT.equals(str) || XRayHttpCodec.PARENT.equals(str) || XRayHttpCodec.SAMPLED.equals(str) || XRayHttpCodec.SELF.equals(str);
        }

        private void additionalPart(StringBuilder sb, String str, String str2, int i) {
            if (sb.length() + str.length() + str2.length() + 2 <= i) {
                sb.append(';');
                sb.append(str);
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static /* synthetic */ ContextInterpreter lambda$newExtractor$0(Config config) {
        return new XRayContextInterpreter(config);
    }

    public static HttpCodec.Extractor newExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.XRayHttpCodec$$ExternalSyntheticLambda0
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return XRayHttpCodec.lambda$newExtractor$0(config);
            }
        });
    }

    static class XRayContextInterpreter extends ContextInterpreter {
        private static int convertSamplingPriority(char c) {
            return '1' == c ? 1 : 0;
        }

        private XRayContextInterpreter(Config config) {
            super(config);
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.XRAY;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            String str3;
            if (str == null || str.isEmpty()) {
                return true;
            }
            if (LOG_EXTRACT_HEADER_NAMES) {
                XRayHttpCodec.log.debug("Header: {}", str);
            }
            try {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                if (lowerCase != 'f') {
                    if (lowerCase != 'u') {
                        if (lowerCase == 'x') {
                            if (XRayHttpCodec.X_AMZN_TRACE_ID.equalsIgnoreCase(str)) {
                                handleXRayTraceHeader(this, str2);
                                return true;
                            }
                            if (handledXForwarding(str, str2)) {
                                return true;
                            }
                        }
                    } else if (handledUserAgent(str, str2)) {
                        return true;
                    }
                } else if (handledForwarding(str, str2)) {
                    return true;
                }
                if (handledIpHeaders(str, str2)) {
                    return true;
                }
                handleTags(str, str2);
                if (!this.baggageMapping.isEmpty() && (str3 = this.baggageMapping.get(toLowerCase(str))) != null) {
                    addBaggageItem(this, str3, HttpCodec.decode(str2));
                }
                return true;
            } catch (RuntimeException e) {
                invalidateContext();
                XRayHttpCodec.log.debug("Exception when extracting context", (Throwable) e);
                return false;
            }
        }

        static void handleXRayTraceHeader(ContextInterpreter contextInterpreter, String str) {
            int iIndexOf;
            if (str == null || (iIndexOf = str.indexOf(XRayHttpCodec.ROOT_PREFIX)) < 0 || !str.regionMatches(iIndexOf + XRayHttpCodec.ROOT_PREAMBLE, XRayHttpCodec.TRACE_ID_PADDING, 0, 9)) {
                return;
            }
            int length = str.length();
            int i = 0;
            while (i < length) {
                int iIndexOf2 = str.indexOf(59, i);
                if (iIndexOf2 < 0) {
                    iIndexOf2 = length;
                }
                String strTrim = str.substring(i, iIndexOf2).trim();
                if (strTrim.startsWith(XRayHttpCodec.ROOT_PREFIX)) {
                    if (contextInterpreter.traceId == null || contextInterpreter.traceId == DDTraceId.ZERO) {
                        contextInterpreter.traceId = DD64bTraceId.fromHex(strTrim.substring(XRayHttpCodec.ROOT_PREAMBLE + 9));
                    }
                } else if (strTrim.startsWith(XRayHttpCodec.PARENT_PREFIX)) {
                    if (contextInterpreter.spanId == 0) {
                        contextInterpreter.spanId = DDSpanId.fromHex(strTrim.substring(7));
                    }
                } else if (strTrim.startsWith(XRayHttpCodec.SAMPLED_PREFIX)) {
                    if (contextInterpreter.samplingPriority == -128) {
                        contextInterpreter.samplingPriority = convertSamplingPriority(strTrim.charAt(8));
                    }
                } else if (!strTrim.startsWith(XRayHttpCodec.SELF_PREFIX)) {
                    if (strTrim.startsWith(XRayHttpCodec.ORIGIN_PREFIX)) {
                        contextInterpreter.origin = strTrim.substring(11);
                    } else if (strTrim.startsWith(XRayHttpCodec.E2E_START_PREFIX)) {
                        contextInterpreter.endToEndStartTime = extractEndToEndStartTime(strTrim.substring(3));
                    } else {
                        int iIndexOf3 = strTrim.indexOf(61);
                        if (iIndexOf3 > 0) {
                            addBaggageItem(contextInterpreter, strTrim.substring(0, iIndexOf3), strTrim.substring(iIndexOf3 + 1));
                        }
                    }
                }
                i = iIndexOf2 + 1;
            }
        }

        private static long extractEndToEndStartTime(String str) {
            try {
                return TimeUnit.MILLISECONDS.toNanos(Long.parseLong(str));
            } catch (RuntimeException e) {
                XRayHttpCodec.log.debug("Ignoring invalid end-to-end start time {}", str, e);
                return 0L;
            }
        }

        private static void addBaggageItem(ContextInterpreter contextInterpreter, String str, String str2) {
            if (contextInterpreter.baggage.isEmpty()) {
                contextInterpreter.baggage = new TreeMap();
            }
            contextInterpreter.baggage.put(str, HttpCodec.decode(str2));
        }
    }
}
