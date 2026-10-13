package com.datadog.trace.common.sampling;

import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.cache.DDCache;
import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.common.writer.RemoteResponseListener;
import com.datadog.trace.core.CoreSpan;
import com.datadog.trace.core.util.MapUtils;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class RateByServiceTraceSampler implements Sampler, PrioritySampler, RemoteResponseListener {
    private static final double DEFAULT_RATE = 1.0d;
    public static final String SAMPLING_AGENT_RATE = "_dd.agent_psr";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) RateByServiceTraceSampler.class);
    private volatile RateSamplersByEnvAndService serviceRates;

    @Override // com.datadog.trace.common.sampling.Sampler
    public <T extends CoreSpan<T>> boolean sample(T t) {
        return true;
    }

    public RateByServiceTraceSampler() {
        this(Double.valueOf(1.0d));
    }

    public RateByServiceTraceSampler(Double d) {
        this.serviceRates = new RateSamplersByEnvAndService(d.doubleValue());
    }

    @Override // com.datadog.trace.common.sampling.PrioritySampler
    public <T extends CoreSpan<T>> void setSamplingPriority(T t) {
        String serviceName = t.getServiceName();
        RateSampler sampler = this.serviceRates.getSampler(getSpanEnv(t), serviceName);
        if (sampler.sample(t)) {
            t.setSamplingPriority(1, "_dd.agent_psr", sampler.getSampleRate(), 1);
        } else {
            t.setSamplingPriority(0, "_dd.agent_psr", sampler.getSampleRate(), 1);
        }
    }

    private <T extends CoreSpan<T>> String getSpanEnv(T t) {
        return (String) t.getTag("env", "");
    }

    @Override // com.datadog.trace.common.writer.RemoteResponseListener
    public void onResponse(String str, Map<String, Map<String, Number>> map) {
        final Map<String, Number> map2 = map.get("rate_by_service");
        if (map2 != null) {
            log.debug("Update service sampler rates: {} -> {}", str, map);
            HashMap map3 = new HashMap(map2.size() * 2);
            for (final Map.Entry<String, Number> entry : map2.entrySet()) {
                if (entry.getValue() != null) {
                    EnvAndService envAndServiceFromString = EnvAndService.fromString(entry.getKey());
                    MapUtils.computeIfAbsent(envAndServiceFromString.service, (Map) MapUtils.computeIfAbsent(envAndServiceFromString.env, map3, new Function() { // from class: com.datadog.trace.common.sampling.RateByServiceTraceSampler$$ExternalSyntheticLambda0
                        @Override // com.datadog.android.trace.internal.compat.function.Function
                        public final Object apply(Object obj) {
                            return RateByServiceTraceSampler.lambda$onResponse$0(map2, (String) obj);
                        }
                    }), new Function() { // from class: com.datadog.trace.common.sampling.RateByServiceTraceSampler$$ExternalSyntheticLambda1
                        @Override // com.datadog.android.trace.internal.compat.function.Function
                        public final Object apply(Object obj) {
                            return RateByServiceTraceSampler.createRateSampler(((Number) entry.getValue()).doubleValue());
                        }
                    });
                }
            }
            this.serviceRates = new RateSamplersByEnvAndService(map3, this.serviceRates.getSampleRate());
        }
    }

    static /* synthetic */ Map lambda$onResponse$0(Map map, String str) {
        return new HashMap(map.size() * 2);
    }

    public double getSampleRate() {
        return this.serviceRates.getSampleRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RateSampler createRateSampler(double d) {
        if (d < 0.0d) {
            log.error("SampleRate is negative or null, disabling the sampler");
        } else {
            if (d > 1.0d) {
            }
            return new DeterministicSampler.TraceSampler(d);
        }
        d = 1.0d;
        return new DeterministicSampler.TraceSampler(d);
    }

    private static final class RateSamplersByEnvAndService {
        private final RateSampler defaultSampler;
        private final Map<String, Map<String, RateSampler>> envServiceRates;
        private final double sampleRate;

        RateSamplersByEnvAndService(double d) {
            this(new HashMap(0), d);
        }

        RateSamplersByEnvAndService(Map<String, Map<String, RateSampler>> map, double d) {
            this.sampleRate = d;
            this.envServiceRates = map;
            this.defaultSampler = RateByServiceTraceSampler.createRateSampler(d);
        }

        RateSampler getSampler(EnvAndService envAndService) {
            return getSampler(envAndService.env, envAndService.service);
        }

        public RateSampler getSampler(String str, String str2) {
            Map<String, RateSampler> map = this.envServiceRates.get(str);
            if (map == null) {
                return this.defaultSampler;
            }
            RateSampler rateSampler = map.get(str2);
            return rateSampler == null ? this.defaultSampler : rateSampler;
        }

        public double getSampleRate() {
            return this.sampleRate;
        }
    }

    private static final class EnvAndService {
        private final String env;
        private final String service;
        private static final DDCache<String, EnvAndService> CACHE = DDCaches.newFixedSizeCache(32);
        private static final Function<String, EnvAndService> PARSE = new Function<String, EnvAndService>() { // from class: com.datadog.trace.common.sampling.RateByServiceTraceSampler.EnvAndService.1
            @Override // com.datadog.android.trace.internal.compat.function.Function
            public EnvAndService apply(String str) {
                int iIndexOf = str.indexOf(58) + 1;
                int iIndexOf2 = str.indexOf(44, iIndexOf);
                int iIndexOf3 = str.indexOf(58, iIndexOf2) + 1;
                if ((iIndexOf == iIndexOf2 && iIndexOf3 == str.length()) || (iIndexOf | iIndexOf2 | iIndexOf3) < 0) {
                    return EnvAndService.DEFAULT;
                }
                return new EnvAndService(str.substring(iIndexOf3), str.substring(iIndexOf, iIndexOf2));
            }
        };
        static final EnvAndService DEFAULT = new EnvAndService("", "");

        public static EnvAndService fromString(String str) {
            return CACHE.computeIfAbsent(str, PARSE);
        }

        private EnvAndService(String str, String str2) {
            this.env = str;
            this.service = str2;
        }
    }
}
