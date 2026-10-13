package com.datadog.trace.common.sampling;

import com.datadog.trace.core.CoreSpan;
import com.datadog.trace.core.util.Matcher;
import com.datadog.trace.core.util.Matchers;
import com.datadog.trace.core.util.SimpleRateLimiter;
import com.datadog.trace.core.util.TagsMatcher;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SamplingRule {
    private final RateSampler sampler;

    public abstract <T extends CoreSpan<T>> boolean matches(T t);

    public SamplingRule(RateSampler rateSampler) {
        this.sampler = rateSampler;
    }

    public <T extends CoreSpan<T>> boolean sample(T t) {
        return this.sampler.sample(t);
    }

    public RateSampler getSampler() {
        return this.sampler;
    }

    public static class AlwaysMatchesSamplingRule extends SamplingRule {
        @Override // com.datadog.trace.common.sampling.SamplingRule
        public <T extends CoreSpan<T>> boolean matches(T t) {
            return true;
        }

        public AlwaysMatchesSamplingRule(RateSampler rateSampler) {
            super(rateSampler);
        }
    }

    public static abstract class PatternMatchSamplingRule extends SamplingRule {
        private final Pattern pattern;

        protected abstract <T extends CoreSpan<T>> CharSequence getRelevantString(T t);

        public PatternMatchSamplingRule(String str, RateSampler rateSampler) {
            super(rateSampler);
            this.pattern = Pattern.compile(str);
        }

        @Override // com.datadog.trace.common.sampling.SamplingRule
        public <T extends CoreSpan<T>> boolean matches(T t) {
            CharSequence relevantString = getRelevantString(t);
            return relevantString != null && this.pattern.matcher(relevantString).matches();
        }
    }

    public static class ServiceSamplingRule extends PatternMatchSamplingRule {
        public ServiceSamplingRule(String str, RateSampler rateSampler) {
            super(str, rateSampler);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.datadog.trace.common.sampling.SamplingRule.PatternMatchSamplingRule
        public <T extends CoreSpan<T>> String getRelevantString(T t) {
            return t.getServiceName();
        }
    }

    public static class OperationSamplingRule extends PatternMatchSamplingRule {
        public OperationSamplingRule(String str, RateSampler rateSampler) {
            super(str, rateSampler);
        }

        @Override // com.datadog.trace.common.sampling.SamplingRule.PatternMatchSamplingRule
        protected <T extends CoreSpan<T>> CharSequence getRelevantString(T t) {
            return t.getOperationName();
        }
    }

    public static final class TraceSamplingRule extends SamplingRule {
        private final Matcher operationMatcher;
        private final Matcher resourceMatcher;
        private final Matcher serviceMatcher;
        private final TagsMatcher tagsMatcher;

        public TraceSamplingRule(String str, String str2, String str3, Map<String, String> map, RateSampler rateSampler) {
            super(rateSampler);
            this.serviceMatcher = Matchers.compileGlob(str);
            this.operationMatcher = Matchers.compileGlob(str2);
            this.resourceMatcher = Matchers.compileGlob(str3);
            this.tagsMatcher = TagsMatcher.create(map);
        }

        @Override // com.datadog.trace.common.sampling.SamplingRule
        public <T extends CoreSpan<T>> boolean matches(T t) {
            return Matchers.matches(this.serviceMatcher, t.getServiceName()) && Matchers.matches(this.operationMatcher, t.getOperationName()) && Matchers.matches(this.resourceMatcher, t.getResourceName()) && this.tagsMatcher.matches(t);
        }
    }

    public static final class SpanSamplingRule extends SamplingRule {
        private final Matcher operationMatcher;
        private final SimpleRateLimiter rateLimiter;
        private final Matcher serviceMatcher;

        public SpanSamplingRule(String str, String str2, RateSampler rateSampler, SimpleRateLimiter simpleRateLimiter) {
            super(rateSampler);
            this.serviceMatcher = Matchers.compileGlob(str);
            this.operationMatcher = Matchers.compileGlob(str2);
            this.rateLimiter = simpleRateLimiter;
        }

        @Override // com.datadog.trace.common.sampling.SamplingRule
        public <T extends CoreSpan<T>> boolean matches(T t) {
            return Matchers.matches(this.serviceMatcher, t.getServiceName()) && Matchers.matches(this.operationMatcher, t.getOperationName());
        }

        @Override // com.datadog.trace.common.sampling.SamplingRule
        public <T extends CoreSpan<T>> boolean sample(T t) {
            if (!super.sample(t)) {
                return false;
            }
            SimpleRateLimiter simpleRateLimiter = this.rateLimiter;
            return simpleRateLimiter == null || simpleRateLimiter.tryAcquire();
        }

        public SimpleRateLimiter getRateLimiter() {
            return this.rateLimiter;
        }
    }
}
