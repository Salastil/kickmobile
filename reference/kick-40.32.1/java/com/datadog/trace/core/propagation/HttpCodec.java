package com.datadog.trace.core.propagation;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DD128bTraceId;
import com.datadog.trace.api.DD64bTraceId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.core.DDSpanLink;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public class HttpCodec {
    static final String BAGGAGE_ACCOUNT_ID = "account.id";
    static final String BAGGAGE_SESSION_ID = "session.id";
    static final String BAGGAGE_USER_ID = "user.id";
    static final String CF_CONNECTING_IP_KEY = "cf-connecting-ip";
    static final String CF_CONNECTING_IP_V6_KEY = "cf-connecting-ipv6";
    static final String FASTLY_CLIENT_IP_KEY = "fastly-client-ip";
    static final String FORWARDED_FOR_KEY = "forwarded-for";
    static final String FORWARDED_KEY = "forwarded";
    public static final String RUM_KEY_ACCOUNT_ID = "account_id";
    static final String RUM_KEY_SESSION_ID = "session_id";
    public static final String RUM_KEY_USER_ID = "user_id";
    static final String TRUE_CLIENT_IP_KEY = "true-client-ip";
    static final String USER_AGENT_KEY = "user-agent";
    static final String X_CLIENT_IP_KEY = "x-client-ip";
    static final String X_CLUSTER_CLIENT_IP_KEY = "x-cluster-client-ip";
    static final String X_FORWARDED_FOR_KEY = "x-forwarded-for";
    static final String X_FORWARDED_HOST_KEY = "x-forwarded-host";
    static final String X_FORWARDED_KEY = "x-forwarded";
    static final String X_FORWARDED_PORT_KEY = "x-forwarded-port";
    static final String X_FORWARDED_PROTO_KEY = "x-forwarded-proto";
    static final String X_REAL_IP_KEY = "x-real-ip";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HttpCodec.class);

    public interface Extractor {
        default void cleanup() {
        }

        <C> TagContext extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor);
    }

    public interface Injector {
        <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter);
    }

    public static Injector createInjector(Config config, Set<TracePropagationStyle> set, Map<String, String> map) {
        return new CompoundInjector(new ArrayList(createInjectors(config, set, map).values()));
    }

    public static Map<TracePropagationStyle, Injector> allInjectorsFor(Config config, Map<String, String> map) {
        return createInjectors(config, EnumSet.allOf(TracePropagationStyle.class), map);
    }

    private static Map<TracePropagationStyle, Injector> createInjectors(Config config, Set<TracePropagationStyle> set, Map<String, String> map) {
        EnumMap enumMap = new EnumMap(TracePropagationStyle.class);
        for (TracePropagationStyle tracePropagationStyle : set) {
            switch (AnonymousClass1.$SwitchMap$com$datadog$trace$api$TracePropagationStyle[tracePropagationStyle.ordinal()]) {
                case 1:
                    enumMap.put(tracePropagationStyle, DatadogHttpCodec.newInjector(map));
                    break;
                case 2:
                    enumMap.put(tracePropagationStyle, B3HttpCodec.newSingleInjector(config.isTracePropagationStyleB3PaddingEnabled()));
                    break;
                case 3:
                    enumMap.put(tracePropagationStyle, B3HttpCodec.newMultiInjector(config.isTracePropagationStyleB3PaddingEnabled()));
                    break;
                case 4:
                    enumMap.put(tracePropagationStyle, HaystackHttpCodec.newInjector(map));
                    break;
                case 5:
                    enumMap.put(tracePropagationStyle, XRayHttpCodec.newInjector(map));
                    break;
                case 6:
                    enumMap.put(tracePropagationStyle, NoneCodec.INJECTOR);
                    break;
                case 7:
                    enumMap.put(tracePropagationStyle, W3CHttpCodec.newInjector(map));
                    break;
                default:
                    log.debug("No implementation found to inject propagation style: {}", tracePropagationStyle);
                    break;
            }
        }
        return enumMap;
    }

    /* JADX INFO: renamed from: com.datadog.trace.core.propagation.HttpCodec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$datadog$trace$api$TracePropagationStyle;

        static {
            int[] iArr = new int[TracePropagationStyle.values().length];
            $SwitchMap$com$datadog$trace$api$TracePropagationStyle = iArr;
            try {
                iArr[TracePropagationStyle.DATADOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.B3SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.B3MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.HAYSTACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.XRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.NONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$datadog$trace$api$TracePropagationStyle[TracePropagationStyle.TRACECONTEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static Extractor createExtractor(Config config, Supplier<TraceConfig> supplier) {
        ArrayList arrayList = new ArrayList();
        for (TracePropagationStyle tracePropagationStyle : config.getTracePropagationStylesToExtract()) {
            switch (AnonymousClass1.$SwitchMap$com$datadog$trace$api$TracePropagationStyle[tracePropagationStyle.ordinal()]) {
                case 1:
                    arrayList.add(DatadogHttpCodec.newExtractor(config, supplier));
                    break;
                case 2:
                    arrayList.add(B3HttpCodec.newSingleExtractor(config, supplier));
                    break;
                case 3:
                    arrayList.add(B3HttpCodec.newMultiExtractor(config, supplier));
                    break;
                case 4:
                    arrayList.add(HaystackHttpCodec.newExtractor(config, supplier));
                    break;
                case 5:
                    arrayList.add(XRayHttpCodec.newExtractor(config, supplier));
                    break;
                case 6:
                    arrayList.add(NoneCodec.EXTRACTOR);
                    break;
                case 7:
                    arrayList.add(W3CHttpCodec.newExtractor(config, supplier));
                    break;
                default:
                    log.debug("No implementation found to extract propagation style: {}", tracePropagationStyle);
                    break;
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return StubExtractor.INSTANCE;
        }
        if (size == 1) {
            return (Extractor) arrayList.get(0);
        }
        return new CompoundExtractor(arrayList, config.isTracePropagationExtractFirst());
    }

    public static class CompoundInjector implements Injector {
        private final List<Injector> injectors;

        public CompoundInjector(List<Injector> list) {
            this.injectors = list;
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Injector
        public <C> void inject(DDSpanContext dDSpanContext, C c, AgentPropagation.Setter<C> setter) {
            HttpCodec.log.debug("Inject context {}", dDSpanContext);
            String str = (String) dDSpanContext.getTags().get("session_id");
            if (str != null) {
                dDSpanContext.getPropagationTags().updateRumSessionId(str);
            }
            Iterator<Injector> it = this.injectors.iterator();
            while (it.hasNext()) {
                it.next().inject(dDSpanContext, c, setter);
            }
        }
    }

    private static class StubExtractor implements Extractor {
        private static final StubExtractor INSTANCE = new StubExtractor();

        @Override // com.datadog.trace.core.propagation.HttpCodec.Extractor
        public <C> TagContext extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
            return null;
        }

        private StubExtractor() {
        }
    }

    public static class CompoundExtractor implements Extractor {
        private final boolean extractFirst;
        private final List<Extractor> extractors;

        public CompoundExtractor(List<Extractor> list, boolean z) {
            this.extractors = list;
            this.extractFirst = z;
        }

        @Override // com.datadog.trace.core.propagation.HttpCodec.Extractor
        public <C> TagContext extract(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
            ExtractionCache extractionCache = new ExtractionCache(c, contextVisitor);
            Iterator<Extractor> it = this.extractors.iterator();
            ExtractedContext extractedContext = null;
            TagContext tagContext = null;
            while (it.hasNext()) {
                TagContext tagContextExtract = it.next().extract(extractionCache, extractionCache);
                if (tagContextExtract instanceof ExtractedContext) {
                    ExtractedContext extractedContext2 = (ExtractedContext) tagContextExtract;
                    if (extractedContext == null) {
                        if (this.extractFirst) {
                            extractedContext = extractedContext2;
                            break;
                        }
                        extractedContext = extractedContext2;
                    } else if (HttpCodec.traceIdMatch(extractedContext.getTraceId(), extractedContext2.getTraceId())) {
                        if (tagContextExtract.getPropagationStyle() == TracePropagationStyle.TRACECONTEXT) {
                            extractedContext.getPropagationTags().updateW3CTracestate(extractedContext2.getPropagationTags().getW3CTracestate());
                        }
                    } else {
                        extractedContext.addTerminatedContextLink(DDSpanLink.from(extractedContext2));
                    }
                } else if (tagContextExtract != null && tagContext == null) {
                    tagContext = tagContextExtract;
                }
            }
            if (extractedContext != null) {
                HttpCodec.log.debug("Extract complete context {}", extractedContext);
                return extractedContext;
            }
            if (tagContext != null) {
                HttpCodec.log.debug("Extract incomplete context {}", tagContext);
                return tagContext;
            }
            HttpCodec.log.debug("Extract no context");
            return null;
        }
    }

    private static class ExtractionCache<C> implements AgentPropagation.KeyClassifier, AgentPropagation.ContextVisitor<ExtractionCache<?>> {
        private final List<String> keysAndValues = new ArrayList(32);

        public ExtractionCache(C c, AgentPropagation.ContextVisitor<C> contextVisitor) {
            contextVisitor.forEachKey(c, this);
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.KeyClassifier
        public boolean accept(String str, String str2) {
            this.keysAndValues.add(str);
            this.keysAndValues.add(str2);
            return true;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.ContextVisitor
        public void forEachKey(ExtractionCache<?> extractionCache, AgentPropagation.KeyClassifier keyClassifier) {
            List<String> list = extractionCache.keysAndValues;
            for (int i = 0; i < list.size(); i += 2) {
                keyClassifier.accept(list.get(i), list.get(i + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean traceIdMatch(DDTraceId dDTraceId, DDTraceId dDTraceId2) {
        if (((dDTraceId instanceof DD128bTraceId) && (dDTraceId2 instanceof DD128bTraceId)) || ((dDTraceId instanceof DD64bTraceId) && (dDTraceId2 instanceof DD64bTraceId))) {
            return dDTraceId.equals(dDTraceId2);
        }
        return dDTraceId.toLong() == dDTraceId2.toLong();
    }

    static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            log.debug("Failed to encode value - {}", str);
            return str;
        }
    }

    static String encodeBaggage(String str) {
        return encode(str).replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }

    static String decode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            log.debug("Failed to decode value - {}", str);
            return str;
        }
    }

    static String firstHeaderValue(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(44);
        return iIndexOf == -1 ? str : str.substring(0, iIndexOf).trim();
    }

    static Baggage composeBaggage(DDSpanContext dDSpanContext) {
        Baggage baggage = new Baggage();
        String str = (String) dDSpanContext.getTags().get("session_id");
        if (str != null) {
            baggage.put(BAGGAGE_SESSION_ID, str);
        }
        String str2 = (String) dDSpanContext.getTags().get(RUM_KEY_USER_ID);
        if (str2 != null) {
            baggage.put(BAGGAGE_USER_ID, str2);
        }
        String str3 = (String) dDSpanContext.getTags().get(RUM_KEY_ACCOUNT_ID);
        if (str3 != null) {
            baggage.put("account.id", str3);
        }
        return baggage;
    }
}
