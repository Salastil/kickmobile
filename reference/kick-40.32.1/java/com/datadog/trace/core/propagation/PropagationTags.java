package com.datadog.trace.core.propagation;

import com.datadog.trace.api.Config;
import com.datadog.trace.core.propagation.ptags.PTagsFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PropagationTags {

    public interface Factory {
        PropagationTags empty();

        PropagationTags fromHeaderValue(HeaderType headerType, String str);
    }

    public abstract void fillTagMap(Map<String, String> map);

    public abstract CharSequence getOrigin();

    public abstract String getRumSessionId();

    public abstract int getSamplingPriority();

    public abstract long getTraceIdHighOrderBits();

    public abstract String getW3CTracestate();

    public abstract String headerValue(HeaderType headerType);

    public abstract void updateRumSessionId(String str);

    public abstract void updateTraceIdHighOrderBits(long j);

    public abstract void updateTraceOrigin(CharSequence charSequence);

    public abstract void updateTraceSamplingPriority(int i, int i2);

    public abstract void updateW3CTracestate(String str);

    public static Factory factory(Config config) {
        return factory(config.getxDatadogTagsMaxLength());
    }

    public static Factory factory(int i) {
        return new PTagsFactory(i);
    }

    public static Factory factory() {
        return factory(512);
    }

    public enum HeaderType {
        DATADOG,
        W3C;

        private static final int numValues = values().length;

        public static int getNumValues() {
            return numValues;
        }
    }

    public HashMap<String, String> createTagMap() {
        HashMap<String, String> map = new HashMap<>();
        fillTagMap(map);
        return map;
    }
}
