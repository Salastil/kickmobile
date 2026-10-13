package com.datadog.trace.bootstrap.instrumentation.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class SpanLinkAttributes implements AgentSpanLink.Attributes {
    public static final AgentSpanLink.Attributes EMPTY = new SpanLinkAttributes(Collections.EMPTY_MAP);
    private final Map<String, String> attributes;

    protected SpanLinkAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SpanLinkAttributes fromMap(Map<String, String> map) {
        return new SpanLinkAttributes(new HashMap(map));
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink.Attributes
    public Map<String, String> asMap() {
        return this.attributes;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink.Attributes
    public boolean isEmpty() {
        return this.attributes.isEmpty();
    }

    public String toString() {
        return "SpanLinkAttributes{" + this.attributes + AbstractJsonLexerKt.END_OBJ;
    }

    public static class Builder {
        private final Map<String, String> attributes = new HashMap();

        protected Builder() {
        }

        public Builder put(String str, String str2) {
            Objects.requireNonNull(str, "key must not be null");
            if (str2 != null) {
                this.attributes.put(str, str2);
            }
            return this;
        }

        public Builder put(String str, boolean z) {
            Objects.requireNonNull(str, "key must not be null");
            this.attributes.put(str, Boolean.toString(z));
            return this;
        }

        public Builder put(String str, long j) {
            Objects.requireNonNull(str, "key must not be null");
            this.attributes.put(str, Long.toString(j));
            return this;
        }

        public Builder put(String str, double d) {
            Objects.requireNonNull(str, "key must not be null");
            this.attributes.put(str, Double.toString(d));
            return this;
        }

        public Builder putStringArray(String str, List<String> list) {
            return putArray(str, list);
        }

        public Builder putBooleanArray(String str, List<Boolean> list) {
            return putArray(str, list);
        }

        public Builder putLongArray(String str, List<Long> list) {
            return putArray(str, list);
        }

        public Builder putDoubleArray(String str, List<Double> list) {
            return putArray(str, list);
        }

        protected <T> Builder putArray(String str, List<T> list) {
            Objects.requireNonNull(str, "key must not be null");
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    T t = list.get(i);
                    if (t != null) {
                        this.attributes.put(str + "." + i, t.toString());
                    }
                }
            }
            return this;
        }

        public AgentSpanLink.Attributes build() {
            return new SpanLinkAttributes(this.attributes);
        }
    }
}
