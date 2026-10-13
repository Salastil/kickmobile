package com.datadog.trace.common.sampling;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.config.TracerConfig;
import com.datadog.trace.core.CoreSpan;
import com.datadog.trace.core.util.SimpleRateLimiter;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface SingleSpanSampler {
    <T extends CoreSpan<T>> boolean setSamplingPriority(T t);

    public static final class Builder {
        private static final Logger log = LoggerFactory.getLogger((Class<?>) Builder.class);

        public static SingleSpanSampler forConfig(Config config) {
            String spanSamplingRules = config.getSpanSamplingRules();
            String spanSamplingRulesFile = config.getSpanSamplingRulesFile();
            boolean z = (spanSamplingRules == null || spanSamplingRules.isEmpty()) ? false : true;
            boolean z2 = (spanSamplingRulesFile == null || spanSamplingRulesFile.isEmpty()) ? false : true;
            if (z && z2) {
                log.warn("Both {} and {} defined. {} will be ignored.", TracerConfig.SPAN_SAMPLING_RULES, TracerConfig.SPAN_SAMPLING_RULES_FILE, TracerConfig.SPAN_SAMPLING_RULES_FILE);
            }
            if (z) {
                SpanSamplingRules spanSamplingRulesDeserialize = SpanSamplingRules.deserialize(spanSamplingRules);
                if (spanSamplingRulesDeserialize.isEmpty()) {
                    return null;
                }
                return new RuleBasedSingleSpanSampler(spanSamplingRulesDeserialize);
            }
            if (!z2) {
                return null;
            }
            SpanSamplingRules spanSamplingRulesDeserializeFile = SpanSamplingRules.deserializeFile(spanSamplingRulesFile);
            if (spanSamplingRulesDeserializeFile.isEmpty()) {
                return null;
            }
            return new RuleBasedSingleSpanSampler(spanSamplingRulesDeserializeFile);
        }

        private Builder() {
        }
    }

    public static final class RuleBasedSingleSpanSampler implements SingleSpanSampler {
        private final List<SamplingRule.SpanSamplingRule> spanSamplingRules;

        public RuleBasedSingleSpanSampler(SpanSamplingRules spanSamplingRules) {
            if (spanSamplingRules == null) {
                throw new NullPointerException("SpanSamplingRules can't be null.");
            }
            this.spanSamplingRules = new ArrayList();
            for (SpanSamplingRules.Rule rule : spanSamplingRules.getRules()) {
                this.spanSamplingRules.add(new SamplingRule.SpanSamplingRule(rule.getService(), rule.getName(), new DeterministicSampler.SpanSampler(rule.getSampleRate()), rule.getMaxPerSecond() == Integer.MAX_VALUE ? null : new SimpleRateLimiter(rule.getMaxPerSecond())));
            }
        }

        @Override // com.datadog.trace.common.sampling.SingleSpanSampler
        public <T extends CoreSpan<T>> boolean setSamplingPriority(T t) {
            for (SamplingRule.SpanSamplingRule spanSamplingRule : this.spanSamplingRules) {
                if (spanSamplingRule.matches(t)) {
                    if (!spanSamplingRule.sample(t)) {
                        return false;
                    }
                    double sampleRate = spanSamplingRule.getSampler().getSampleRate();
                    SimpleRateLimiter rateLimiter = spanSamplingRule.getRateLimiter();
                    t.setSpanSamplingPriority(sampleRate, rateLimiter == null ? Integer.MAX_VALUE : rateLimiter.getCapacity());
                    return true;
                }
            }
            return false;
        }
    }
}
