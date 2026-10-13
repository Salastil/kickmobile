package com.datadog.trace.core.propagation;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD128bTraceId;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class B3HttpCodec {
    public static final String B3_KEY = "b3";
    private static final String B3_SPAN_ID = "b3.spanid";
    private static final String B3_TRACE_ID = "b3.traceid";
    public static final String SAMPLING_PRIORITY_KEY = "X-B3-Sampled";
    public static final String SPAN_ID_KEY = "X-B3-SpanId";
    public static final String TRACE_ID_KEY = "X-B3-TraceId";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) B3HttpCodec.class);
    private static final String SAMPLING_PRIORITY_ACCEPT = String.valueOf(1);
    private static final String SAMPLING_PRIORITY_DROP = String.valueOf(0);

    private B3HttpCodec() {
    }

    public static HttpCodec.Injector newCombinedInjector(boolean z) {
        return new HttpCodec.CompoundInjector(Arrays.asList(newSingleInjector(z), newMultiInjector(z)));
    }

    public static HttpCodec.Injector newMultiInjector(boolean z) {
        return new B3MultiInjector(z);
    }

    public static HttpCodec.Injector newSingleInjector(boolean z) {
        return new B3SingleInjector(z);
    }

    private static abstract class B3Injector implements HttpCodec.Injector {
        private final boolean paddingEnabled;

        public B3Injector(boolean z) {
            this.paddingEnabled = z;
        }

        protected final String getInjectedTraceId(DDSpanContext dDSpanContext) {
            DDTraceId traceId = dDSpanContext.getTraceId();
            if (this.paddingEnabled || (traceId instanceof DD128bTraceId)) {
                return traceId.toHexString();
            }
            if (traceId instanceof B3TraceId) {
                return ((B3TraceId) traceId).getOriginal();
            }
            return DDSpanId.toHexString(traceId.toLong());
        }

        protected final String getInjectedSpanId(DDSpanContext dDSpanContext) {
            long spanId = dDSpanContext.getSpanId();
            if (this.paddingEnabled) {
                return DDSpanId.toHexStringPadded(spanId);
            }
            return DDSpanId.toHexString(spanId);
        }
    }

    private static final class B3MultiInjector extends B3Injector {
        public B3MultiInjector(boolean z) {
            super(z);
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            String injectedTraceId = getInjectedTraceId(dDSpanContext);
            String injectedSpanId = getInjectedSpanId(dDSpanContext);
            setter.set(c, B3HttpCodec.TRACE_ID_KEY, injectedTraceId);
            setter.set(c, B3HttpCodec.SPAN_ID_KEY, injectedSpanId);
            if (dDSpanContext.lockSamplingPriority()) {
                setter.set(c, B3HttpCodec.SAMPLING_PRIORITY_KEY, B3HttpCodec.convertSamplingPriority(dDSpanContext.getTraceSamplingPriority()));
            }
            B3HttpCodec.log.debug("{} - B3 parent context injected - {} {}", dDSpanContext.getTraceId(), injectedTraceId, injectedSpanId);
        }
    }

    private static final class B3SingleInjector extends B3Injector {
        public B3SingleInjector(boolean z) {
            super(z);
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            String injectedTraceId = getInjectedTraceId(dDSpanContext);
            String injectedSpanId = getInjectedSpanId(dDSpanContext);
            StringBuilder sb = new StringBuilder(100);
            sb.append(injectedTraceId);
            sb.append('-');
            sb.append(injectedSpanId);
            if (dDSpanContext.lockSamplingPriority()) {
                String strConvertSamplingPriority = B3HttpCodec.convertSamplingPriority(dDSpanContext.getTraceSamplingPriority());
                sb.append('-');
                sb.append(strConvertSamplingPriority);
            }
            String string = sb.toString();
            setter.set(c, B3HttpCodec.B3_KEY, string);
            B3HttpCodec.log.debug("{} - B3 parent context injected - {}", dDSpanContext.getTraceId(), string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertSamplingPriority(int i) {
        return i > 0 ? SAMPLING_PRIORITY_ACCEPT : SAMPLING_PRIORITY_DROP;
    }

    static HttpCodec.Extractor newExtractor(Config config, Supplier<TraceConfig> supplier) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(newSingleExtractor(config, supplier));
        arrayList.add(newMultiExtractor(config, supplier));
        return new HttpCodec.CompoundExtractor(arrayList, config.isTracePropagationExtractFirst());
    }

    public static HttpCodec.Extractor newMultiExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.B3HttpCodec$$ExternalSyntheticLambda1
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return B3HttpCodec.lambda$newMultiExtractor$0(config);
            }
        });
    }

    static /* synthetic */ ContextInterpreter lambda$newMultiExtractor$0(Config config) {
        return new B3MultiContextInterpreter(config);
    }

    public static HttpCodec.Extractor newSingleExtractor(final Config config, Supplier<TraceConfig> supplier) {
        return new TagContextExtractor(supplier, new ContextInterpreter.Factory() { // from class: com.datadog.trace.core.propagation.B3HttpCodec$$ExternalSyntheticLambda0
            @Override // com.datadog.trace.core.propagation.ContextInterpreter.Factory
            public final ContextInterpreter create() {
                return B3HttpCodec.lambda$newSingleExtractor$1(config);
            }
        });
    }

    static /* synthetic */ ContextInterpreter lambda$newSingleExtractor$1(Config config) {
        return new B3SingleContextInterpreter(config);
    }

    private static abstract class B3BaseContextInterpreter extends ContextInterpreter {
        public B3BaseContextInterpreter(Config config) {
            super(config);
        }

        protected void setSpanId(String str) {
            this.spanId = DDSpanId.fromHex(str);
            if (this.tags.isEmpty()) {
                this.tags = new TreeMap();
            }
            this.tags.put(B3HttpCodec.B3_SPAN_ID, str);
        }

        protected boolean setTraceId(String str) {
            DDTraceId dDTraceId;
            if (str.length() > 32) {
                B3HttpCodec.log.debug("Header {} exceeded max length of 32: {}", B3HttpCodec.TRACE_ID_KEY, str);
                this.traceId = DDTraceId.ZERO;
                return false;
            }
            B3TraceId b3TraceIdFromHex = B3TraceId.fromHex(str);
            if (b3TraceIdFromHex.toLong() == 0) {
                dDTraceId = b3TraceIdFromHex;
                dDTraceId = DDTraceId.ZERO;
            }
            dDTraceId = b3TraceIdFromHex;
            this.traceId = dDTraceId;
            if (this.tags.isEmpty()) {
                this.tags = new TreeMap();
            }
            this.tags.put(B3HttpCodec.B3_TRACE_ID, str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class B3MultiContextInterpreter extends B3BaseContextInterpreter {
        private B3MultiContextInterpreter(Config config) {
            super(config);
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.B3MULTI;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                return true;
            }
            if (LOG_EXTRACT_HEADER_NAMES) {
                B3HttpCodec.log.debug("Header: {}", str);
            }
            try {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                if (lowerCase != 'f') {
                    if (lowerCase != 'u') {
                        if (lowerCase == 'x') {
                            if (B3HttpCodec.TRACE_ID_KEY.equalsIgnoreCase(str)) {
                                setTraceId(HttpCodec.firstHeaderValue(str2));
                                return true;
                            }
                            if (B3HttpCodec.SPAN_ID_KEY.equalsIgnoreCase(str)) {
                                setSpanId(HttpCodec.firstHeaderValue(str2));
                                return true;
                            }
                            if (B3HttpCodec.SAMPLING_PRIORITY_KEY.equalsIgnoreCase(str)) {
                                this.samplingPriority = B3HttpCodec.convertSamplingPriority(HttpCodec.firstHeaderValue(str2));
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
                return true;
            } catch (RuntimeException e) {
                invalidateContext();
                B3HttpCodec.log.debug("Exception when extracting context", (Throwable) e);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class B3SingleContextInterpreter extends B3BaseContextInterpreter {
        public B3SingleContextInterpreter(Config config) {
            super(config);
        }

        @Override // com.datadog.trace.core.propagation.ContextInterpreter
        public TracePropagationStyle style() {
            return TracePropagationStyle.B3SINGLE;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            if (str != null) {
                try {
                    if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                        if (LOG_EXTRACT_HEADER_NAMES) {
                            B3HttpCodec.log.debug("Header: {}", str);
                        }
                        if (B3HttpCodec.B3_KEY.equals(str)) {
                            return extractB3(HttpCodec.firstHeaderValue(str2));
                        }
                        char lowerCase = Character.toLowerCase(str.charAt(0));
                        if (lowerCase != 'f') {
                            if (lowerCase != 'u') {
                                if (lowerCase == 'x' && handledXForwarding(str, str2)) {
                                    return true;
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
                        return true;
                    }
                } catch (RuntimeException e) {
                    invalidateContext();
                    B3HttpCodec.log.debug("Exception when extracting context", (Throwable) e);
                    return false;
                }
            }
            return true;
        }

        private boolean extractB3(String str) {
            if (str.length() == 1) {
                this.samplingPriority = B3HttpCodec.convertSamplingPriority(str);
            } else {
                int iIndexOf = str.indexOf("-");
                int i = iIndexOf + 1;
                int iIndexOf2 = str.indexOf("-", i);
                if (iIndexOf != -1 && !setTraceId(str.substring(0, iIndexOf))) {
                    return false;
                }
                if (iIndexOf2 == -1) {
                    setSpanId(str.substring(i));
                } else {
                    setSpanId(str.substring(i, iIndexOf2));
                    this.samplingPriority = B3HttpCodec.convertSamplingPriority(str.substring(iIndexOf2 + 1));
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int convertSamplingPriority(String str) {
        return "1".equals(str) ? 1 : 0;
    }
}
