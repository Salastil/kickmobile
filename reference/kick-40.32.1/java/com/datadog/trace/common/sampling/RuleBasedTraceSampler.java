package com.datadog.trace.common.sampling;

import com.datadog.trace.api.config.TracerConfig;
import com.datadog.trace.core.CoreSpan;
import com.datadog.trace.core.util.SimpleRateLimiter;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class RuleBasedTraceSampler<T extends CoreSpan<T>> implements Sampler, PrioritySampler {
    public static final String SAMPLING_LIMIT_RATE = "_dd.limit_psr";
    public static final String SAMPLING_RULE_RATE = "_dd.rule_psr";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) RuleBasedTraceSampler.class);
    private final PrioritySampler fallbackSampler;
    private final long rateLimit;
    private final SimpleRateLimiter rateLimiter;
    private final List<SamplingRule> samplingRules;

    @Override // com.datadog.trace.common.sampling.Sampler
    public <T extends CoreSpan<T>> boolean sample(T t) {
        return true;
    }

    public RuleBasedTraceSampler(List<SamplingRule> list, int i, PrioritySampler prioritySampler) {
        this.samplingRules = list;
        this.fallbackSampler = prioritySampler;
        this.rateLimiter = new SimpleRateLimiter(i);
        this.rateLimit = i;
    }

    public static RuleBasedTraceSampler build(TraceSamplingRules traceSamplingRules, Double d, int i) {
        return build(null, null, traceSamplingRules, d, i);
    }

    public static RuleBasedTraceSampler build(@Deprecated Map<String, String> map, @Deprecated Map<String, String> map2, TraceSamplingRules traceSamplingRules, Double d, int i) {
        ArrayList arrayList = new ArrayList();
        if (traceSamplingRules == null || traceSamplingRules.isEmpty()) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        arrayList.add(new SamplingRule.ServiceSamplingRule(entry.getKey(), new DeterministicSampler.TraceSampler(Double.parseDouble(entry.getValue()))));
                    } catch (NumberFormatException e) {
                        log.error("Unable to parse rate for service: {}", entry, e);
                    }
                }
            }
            if (map2 != null) {
                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                    try {
                        arrayList.add(new SamplingRule.OperationSamplingRule(entry2.getKey(), new DeterministicSampler.TraceSampler(Double.parseDouble(entry2.getValue()))));
                    } catch (NumberFormatException e2) {
                        log.error("Unable to parse rate for operation: {}", entry2, e2);
                    }
                }
            }
        } else {
            if (!map.isEmpty() || !map2.isEmpty()) {
                log.warn("Both {} and/or {} as well as {} are defined. Only {} will be used for rule-based sampling", TracerConfig.TRACE_SAMPLING_SERVICE_RULES, TracerConfig.TRACE_SAMPLING_OPERATION_RULES, TracerConfig.TRACE_SAMPLING_RULES, TracerConfig.TRACE_SAMPLING_RULES);
            }
            for (TraceSamplingRules.Rule rule : traceSamplingRules.getRules()) {
                arrayList.add(new SamplingRule.TraceSamplingRule(rule.getService(), rule.getName(), rule.getResource(), rule.getTags(), new DeterministicSampler.TraceSampler(rule.getSampleRate())));
            }
        }
        if (d != null) {
            arrayList.add(new SamplingRule.AlwaysMatchesSamplingRule(new DeterministicSampler.TraceSampler(d.doubleValue())));
        }
        return new RuleBasedTraceSampler(arrayList, i, new RateByServiceTraceSampler());
    }

    @Override // com.datadog.trace.common.sampling.PrioritySampler
    public <T extends CoreSpan<T>> void setSamplingPriority(T t) {
        SamplingRule next;
        T t2;
        Iterator<SamplingRule> it = this.samplingRules.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.matches(t));
        if (next == null) {
            this.fallbackSampler.setSamplingPriority(t);
            return;
        }
        if (next.sample(t)) {
            if (this.rateLimiter.tryAcquire()) {
                t.setSamplingPriority(2, "_dd.rule_psr", next.getSampler().getSampleRate(), 3);
                t2 = t;
            } else {
                t2 = t;
                t2.setSamplingPriority(-1, "_dd.rule_psr", next.getSampler().getSampleRate(), 3);
            }
            t2.mo11186setMetric(SAMPLING_LIMIT_RATE, this.rateLimit);
            return;
        }
        t.setSamplingPriority(-1, "_dd.rule_psr", next.getSampler().getSampleRate(), 3);
    }
}
