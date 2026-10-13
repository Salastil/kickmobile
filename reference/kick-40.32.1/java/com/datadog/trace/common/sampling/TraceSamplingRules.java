package com.datadog.trace.common.sampling;

import com.datadog.trace.core.util.JsonObjectUtils;
import com.datadog.trace.core.util.MapUtils;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class TraceSamplingRules {
    public static final TraceSamplingRules EMPTY = new TraceSamplingRules(Collections.EMPTY_LIST);
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TraceSamplingRules.class);
    private final List<Rule> rules;

    public TraceSamplingRules(List<Rule> list) {
        this.rules = Collections.unmodifiableList(list);
    }

    public static TraceSamplingRules deserialize(String str) {
        TraceSamplingRules traceSamplingRules = EMPTY;
        try {
            return filterOutNullRules(deserializeRules(str));
        } catch (Throwable th) {
            log.error("Couldn't parse Trace Sampling Rules from JSON: {}", str, th);
            return traceSamplingRules;
        }
    }

    private static TraceSamplingRules filterOutNullRules(List<Rule> list) {
        if (list == null || list.isEmpty()) {
            return EMPTY;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Rule rule : list) {
            if (rule != null) {
                arrayList.add(rule);
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY;
        }
        return new TraceSamplingRules(arrayList);
    }

    private static List<Rule> deserializeRules(String str) throws IllegalStateException {
        JsonArray asJsonArray = JsonParser.parseString(str).getAsJsonArray();
        if (asJsonArray == null || asJsonArray.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < asJsonArray.size(); i++) {
            linkedList.add(Rule.create(JsonRule.deserializeRule(asJsonArray.get(i).getAsJsonObject())));
        }
        return linkedList;
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public boolean isEmpty() {
        return this.rules.isEmpty();
    }

    public static final class Rule implements com.datadog.trace.api.sampling.SamplingRule.TraceSamplingRule {
        private final String name;
        private final String resource;
        private final double sampleRate;
        private final String service;
        private final Map<String, String> tags;

        private Rule(String str, String str2, String str3, Map<String, String> map, double d) {
            this.service = str;
            this.name = str2;
            this.resource = str3;
            this.tags = map;
            this.sampleRate = d;
        }

        public static Rule create(JsonRule jsonRule) {
            String strNormalizeGlob = com.datadog.trace.api.sampling.SamplingRule.normalizeGlob(jsonRule.service);
            String strNormalizeGlob2 = com.datadog.trace.api.sampling.SamplingRule.normalizeGlob(jsonRule.name);
            String strNormalizeGlob3 = com.datadog.trace.api.sampling.SamplingRule.normalizeGlob(jsonRule.resource);
            Map<String, String> map = jsonRule.tags;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            Map<String, String> map2 = map;
            double d = 1.0d;
            if (jsonRule.sample_rate != null) {
                try {
                    double d2 = Double.parseDouble(jsonRule.sample_rate);
                    if (d2 < 0.0d || d2 > 1.0d) {
                        logRuleError(jsonRule, "sample_rate must be between 0.0 and 1.0");
                        return null;
                    }
                    d = d2;
                } catch (NumberFormatException unused) {
                    logRuleError(jsonRule, "sample_rate must be a number between 0.0 and 1.0");
                    return null;
                }
            }
            return new Rule(strNormalizeGlob, strNormalizeGlob2, strNormalizeGlob3, map2, d);
        }

        private static void logRuleError(JsonRule jsonRule, String str) {
            TraceSamplingRules.log.error("Skipping invalid Trace Sampling Rule: {} - {}", jsonRule, str);
        }

        @Override // com.datadog.trace.api.sampling.SamplingRule
        public String getService() {
            return this.service;
        }

        @Override // com.datadog.trace.api.sampling.SamplingRule
        public String getName() {
            return this.name;
        }

        @Override // com.datadog.trace.api.sampling.SamplingRule
        public String getResource() {
            return this.resource;
        }

        @Override // com.datadog.trace.api.sampling.SamplingRule
        public Map<String, String> getTags() {
            return this.tags;
        }

        @Override // com.datadog.trace.api.sampling.SamplingRule
        public double getSampleRate() {
            return this.sampleRate;
        }

        public String asStringJsonRule() {
            JsonRule jsonRule = new JsonRule();
            jsonRule.service = this.service;
            jsonRule.name = this.name;
            jsonRule.resource = this.resource;
            jsonRule.tags = this.tags;
            jsonRule.sample_rate = String.valueOf(this.sampleRate);
            return jsonRule.toString();
        }
    }

    private static final class JsonRule {
        static final String NAME_KEY = "name";
        static final String RESOURCE_KEY = "resource";
        static final String SAMPLE_RATE_KEY = "sample_rate";
        static final String SERVICE_KEY = "service";
        static final String TAGS_KEY = "tags";
        static final String TARGET_SPAN_KEY = "target_span";
        String name;
        String resource;
        String sample_rate;
        String service;
        Map<String, String> tags;
        String target_span;

        private JsonRule() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static JsonRule deserializeRule(JsonObject jsonObject) {
            JsonRule jsonRule = new JsonRule();
            jsonRule.name = JsonObjectUtils.getAsString(jsonObject, "name");
            jsonRule.resource = JsonObjectUtils.getAsString(jsonObject, "resource");
            jsonRule.sample_rate = JsonObjectUtils.getAsString(jsonObject, SAMPLE_RATE_KEY);
            jsonRule.service = JsonObjectUtils.getAsString(jsonObject, "service");
            jsonRule.target_span = JsonObjectUtils.getAsString(jsonObject, TARGET_SPAN_KEY);
            jsonRule.tags = JsonObjectUtils.safeGetAsMap(jsonObject, "tags");
            return jsonRule;
        }

        public String toString() {
            JsonObject jsonObject = new JsonObject();
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            String str2 = this.resource;
            if (str2 != null) {
                jsonObject.addProperty("resource", str2);
            }
            String str3 = this.sample_rate;
            if (str3 != null) {
                jsonObject.addProperty(SAMPLE_RATE_KEY, str3);
            }
            String str4 = this.service;
            if (str4 != null) {
                jsonObject.addProperty("service", str4);
            }
            String str5 = this.target_span;
            if (str5 != null) {
                jsonObject.addProperty(TARGET_SPAN_KEY, str5);
            }
            Map<String, String> map = this.tags;
            if (map != null) {
                jsonObject.add("tags", MapUtils.getAsJsonObject(map));
            }
            return jsonObject.toString();
        }
    }
}
