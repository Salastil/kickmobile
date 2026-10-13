package com.datadog.trace.common.sampling;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.TraceConfig;
import com.datadog.trace.api.config.TracerConfig;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import com.datadog.trace.core.CoreSpan;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes6.dex */
public interface Sampler {
    <T extends CoreSpan<T>> boolean sample(T t);

    public static final class Builder {
        private static final Logger log = LoggerFactory.getLogger((Class<?>) Builder.class);

        public static Sampler forConfig(Config config, TraceConfig traceConfig) {
            if (config != null) {
                Map<String, String> traceSamplingServiceRules = config.getTraceSamplingServiceRules();
                Map<String, String> traceSamplingOperationRules = config.getTraceSamplingOperationRules();
                String traceSamplingRules = config.getTraceSamplingRules();
                TraceSamplingRules traceSamplingRulesDeserialize = TraceSamplingRules.EMPTY;
                if (traceSamplingRules != null) {
                    traceSamplingRulesDeserialize = TraceSamplingRules.deserialize(traceSamplingRules);
                }
                boolean z = (traceSamplingServiceRules == null || traceSamplingServiceRules.isEmpty()) ? false : true;
                boolean z2 = (traceSamplingOperationRules == null || traceSamplingOperationRules.isEmpty()) ? false : true;
                boolean zIsEmpty = traceSamplingRulesDeserialize.isEmpty();
                boolean zIsV2CompatibilityEnabled = config.isV2CompatibilityEnabled();
                if ((z || z2) && !zIsEmpty) {
                    log.warn("Both {} and/or {} as well as {} are defined. Only {} will be used for rule-based sampling", TracerConfig.TRACE_SAMPLING_SERVICE_RULES, TracerConfig.TRACE_SAMPLING_OPERATION_RULES, TracerConfig.TRACE_SAMPLING_RULES, TracerConfig.TRACE_SAMPLING_RULES);
                }
                Double traceSampleRate = traceConfig != null ? traceConfig.getTraceSampleRate() : config.getTraceSampleRate();
                if (zIsV2CompatibilityEnabled && (z || z2 || !zIsEmpty || traceSampleRate != null)) {
                    try {
                        return RuleBasedTraceSampler.build(traceSamplingServiceRules, traceSamplingOperationRules, traceSamplingRulesDeserialize, traceSampleRate, config.getTraceRateLimit());
                    } catch (IllegalArgumentException e) {
                        log.error("Invalid sampler configuration. Using AllSampler", (Throwable) e);
                        return new AllSampler();
                    }
                }
                if (traceSampleRate != null) {
                    return new RateByServiceTraceSampler(traceSampleRate);
                }
                if (config.isPrioritySamplingEnabled()) {
                    if (SamplerConstants.KEEP.equalsIgnoreCase(config.getPrioritySamplingForce())) {
                        log.debug("Force Sampling Priority to: SAMPLER_KEEP.");
                        return new ForcePrioritySampler(1, 0);
                    }
                    if (SamplerConstants.DROP.equalsIgnoreCase(config.getPrioritySamplingForce())) {
                        log.debug("Force Sampling Priority to: SAMPLER_DROP.");
                        return new ForcePrioritySampler(0, 0);
                    }
                    return new RateByServiceTraceSampler();
                }
                return new AllSampler();
            }
            return new AllSampler();
        }

        public static Sampler forConfig(Properties properties) {
            return forConfig(Config.get(properties), null);
        }

        private Builder() {
        }
    }
}
