package com.datadog.trace.core.propagation;

import androidx.work.WorkInfo;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.Functions;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.TracePropagationStyle;
import com.datadog.trace.api.cache.DDCache;
import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.bootstrap.ActiveSubsystems;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.TagContext;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ContextInterpreter implements AgentPropagation.KeyClassifier {
    protected Map<String, String> baggage;
    protected Map<String, String> baggageMapping;
    private final boolean clientIpResolutionEnabled;
    private final boolean clientIpWithoutAppSec;
    private boolean collectIpHeaders;
    private final String customIpHeaderName;
    protected long endToEndStartTime;
    protected boolean fullContext;
    protected Map<String, String> headerTags;
    private TagContext.HttpHeaders httpHeaders;
    protected CharSequence origin;
    protected PropagationTags propagationTags;
    protected final PropagationTags.Factory propagationTagsFactory;
    private final boolean requestHeaderTagsCommaAllowed;
    protected int samplingPriority;
    protected long spanId;
    protected Map<String, String> tags;
    private TraceConfig traceConfig;
    protected DDTraceId traceId;
    protected boolean valid;
    protected static final boolean LOG_EXTRACT_HEADER_NAMES = Config.get().isLogExtractHeaderNames();
    private static final DDCache<String, String> CACHE = DDCaches.newFixedSizeCache(64);

    public interface Factory {
        ContextInterpreter create();
    }

    protected int defaultSamplingPriority() {
        return WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
    }

    public abstract TracePropagationStyle style();

    protected static String toLowerCase(String str) {
        return CACHE.computeIfAbsent(str, Functions.LowerCase.INSTANCE);
    }

    protected ContextInterpreter(Config config) {
        this.customIpHeaderName = config.getTraceClientIpHeader();
        this.clientIpResolutionEnabled = config.isTraceClientIpResolverEnabled();
        this.clientIpWithoutAppSec = config.isClientIpEnabled();
        this.propagationTagsFactory = PropagationTags.factory(config);
        this.requestHeaderTagsCommaAllowed = config.isRequestHeaderTagsCommaAllowed();
    }

    protected final boolean handledForwarding(String str, String str2) {
        if (str2 != null && this.collectIpHeaders) {
            if ("forwarded".equalsIgnoreCase(str)) {
                getHeaders().forwarded = str2;
                return true;
            }
            if ("forwarded-for".equalsIgnoreCase(str)) {
                getHeaders().forwardedFor = str2;
                return true;
            }
        }
        return false;
    }

    protected final boolean handledXForwarding(String str, String str2) {
        if (str2 != null && this.collectIpHeaders) {
            if ("x-forwarded-proto".equalsIgnoreCase(str)) {
                getHeaders().xForwardedProto = str2;
                return true;
            }
            if ("x-forwarded-host".equalsIgnoreCase(str)) {
                getHeaders().xForwardedHost = str2;
                return true;
            }
            if ("x-forwarded-for".equalsIgnoreCase(str)) {
                getHeaders().xForwardedFor = str2;
                return true;
            }
            if ("x-forwarded-port".equalsIgnoreCase(str)) {
                getHeaders().xForwardedPort = str2;
                return true;
            }
            if ("x-forwarded".equalsIgnoreCase(str)) {
                getHeaders().xForwarded = str2;
                return true;
            }
        }
        return false;
    }

    protected final boolean handledUserAgent(String str, String str2) {
        if (str2 == null || !"user-agent".equalsIgnoreCase(str)) {
            return false;
        }
        getHeaders().userAgent = str2;
        return true;
    }

    protected final boolean handledIpHeaders(String str, String str2) {
        String str3;
        if (str != null && !str.isEmpty()) {
            if (str2 != null && (str3 = this.customIpHeaderName) != null && str3.equalsIgnoreCase(str)) {
                getHeaders().customIpHeader = str2;
                return true;
            }
            if (str2 != null && this.collectIpHeaders) {
                if (Character.toLowerCase(str.charAt(str.length() - 1)) == 'p') {
                    if ("x-cluster-client-ip".equalsIgnoreCase(str)) {
                        getHeaders().xClusterClientIp = str2;
                        return true;
                    }
                    if ("x-real-ip".equalsIgnoreCase(str)) {
                        getHeaders().xRealIp = str2;
                        return true;
                    }
                    if ("x-client-ip".equalsIgnoreCase(str)) {
                        getHeaders().xClientIp = str2;
                        return true;
                    }
                    if ("true-client-ip".equalsIgnoreCase(str)) {
                        getHeaders().trueClientIp = str2;
                        return true;
                    }
                    if ("fastly-client-ip".equalsIgnoreCase(str)) {
                        getHeaders().fastlyClientIp = str2;
                        return true;
                    }
                    if ("cf-connecting-ip".equalsIgnoreCase(str)) {
                        getHeaders().cfConnectingIp = str2;
                        return true;
                    }
                } else if ("cf-connecting-ipv6".equalsIgnoreCase(str)) {
                    getHeaders().cfConnectingIpv6 = str2;
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean handleTags(String str, String str2) {
        if (!this.headerTags.isEmpty() && str2 != null) {
            String str3 = this.headerTags.get(toLowerCase(str));
            if (str3 != null) {
                if (this.tags.isEmpty()) {
                    this.tags = new TreeMap();
                }
                Map<String, String> map = this.tags;
                if (!this.requestHeaderTagsCommaAllowed) {
                    str2 = HttpCodec.firstHeaderValue(str2);
                }
                map.put(str3, HttpCodec.decode(str2));
                return true;
            }
        }
        return false;
    }

    protected final boolean handleMappedBaggage(String str, String str2) {
        if (!this.baggageMapping.isEmpty() && str2 != null) {
            String str3 = this.baggageMapping.get(toLowerCase(str));
            if (str3 != null) {
                if (this.baggage.isEmpty()) {
                    this.baggage = new TreeMap();
                }
                this.baggage.put(str3, HttpCodec.decode(str2));
                return true;
            }
        }
        return false;
    }

    public ContextInterpreter reset(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
        this.traceId = DDTraceId.ZERO;
        this.spanId = 0L;
        this.samplingPriority = WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        this.origin = null;
        this.endToEndStartTime = 0L;
        this.tags = Collections.EMPTY_MAP;
        this.baggage = Collections.EMPTY_MAP;
        boolean z = true;
        this.valid = true;
        this.fullContext = true;
        this.httpHeaders = null;
        if (!this.clientIpWithoutAppSec && (!this.clientIpResolutionEnabled || !ActiveSubsystems.APPSEC_ACTIVE)) {
            z = false;
        }
        this.collectIpHeaders = z;
        this.headerTags = traceConfig.getRequestHeaderTags();
        this.baggageMapping = traceConfig.getBaggageMapping();
        return this;
    }

    protected TagContext build() {
        if (!this.valid) {
            return null;
        }
        if (this.fullContext && !DDTraceId.ZERO.equals(this.traceId)) {
            if (this.propagationTags == null) {
                this.propagationTags = this.propagationTagsFactory.empty();
            }
            DDTraceId dDTraceId = this.traceId;
            return new ExtractedContext(dDTraceId, this.spanId, samplingPriorityOrDefault(dDTraceId, this.samplingPriority), this.origin, this.endToEndStartTime, this.baggage, this.tags, this.httpHeaders, this.propagationTags, this.traceConfig, style());
        }
        if (this.origin == null && this.tags.isEmpty() && this.httpHeaders == null && this.baggage.isEmpty() && this.samplingPriority == -128) {
            return null;
        }
        return new TagContext(this.origin, this.tags, this.httpHeaders, this.baggage, samplingPriorityOrDefault(this.traceId, this.samplingPriority), this.traceConfig, style());
    }

    protected void invalidateContext() {
        this.valid = false;
    }

    protected void onlyTagContext() {
        this.fullContext = false;
    }

    private TagContext.HttpHeaders getHeaders() {
        if (this.httpHeaders == null) {
            this.httpHeaders = new TagContext.HttpHeaders();
        }
        return this.httpHeaders;
    }

    private int samplingPriorityOrDefault(DDTraceId dDTraceId, int i) {
        return (i == -128 || DDTraceId.ZERO.equals(dDTraceId)) ? defaultSamplingPriority() : i;
    }
}
