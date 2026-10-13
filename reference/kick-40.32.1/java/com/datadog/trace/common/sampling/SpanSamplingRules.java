package com.datadog.trace.common.sampling;

import com.datadog.trace.core.util.JsonObjectUtils;
import com.datadog.trace.core.util.MapUtils;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class SpanSamplingRules {
    public static final SpanSamplingRules EMPTY = new SpanSamplingRules(Collections.EMPTY_LIST);
    private static final Logger log = LoggerFactory.getLogger((Class<?>) SpanSamplingRules.class);
    private final List<Rule> rules;

    public SpanSamplingRules(List<Rule> list) {
        this.rules = Collections.unmodifiableList(list);
    }

    public static SpanSamplingRules deserialize(String str) {
        SpanSamplingRules spanSamplingRules = EMPTY;
        try {
            return filterOutNullRules(deserializeRules(new JsonReader(new StringReader(str))));
        } catch (Throwable th) {
            log.error("Couldn't parse Span Sampling Rules from JSON: {}", str, th);
            return spanSamplingRules;
        }
    }

    public static SpanSamplingRules deserializeFile(String str) {
        SpanSamplingRules spanSamplingRules = EMPTY;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(str));
            try {
                SpanSamplingRules spanSamplingRulesFilterOutNullRules = filterOutNullRules(deserializeRules(jsonReader));
                jsonReader.close();
                return spanSamplingRulesFilterOutNullRules;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            log.warn("Span Sampling Rules file {} doesn't exist", str);
            return spanSamplingRules;
        } catch (IOException e) {
            log.error("Couldn't read Span Sampling Rules file {}.", str, e);
            return spanSamplingRules;
        } catch (Throwable th3) {
            log.error("Couldn't parse Span Sampling Rules from JSON file {}.", str, th3);
            return spanSamplingRules;
        }
    }

    private static List<Rule> deserializeRules(JsonReader jsonReader) throws IllegalStateException {
        JsonArray asJsonArray = JsonParser.parseReader(jsonReader).getAsJsonArray();
        if (asJsonArray == null || asJsonArray.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < asJsonArray.size(); i++) {
            linkedList.add(Rule.create(JsonRule.deserializeRule(asJsonArray.get(i).getAsJsonObject())));
        }
        return linkedList;
    }

    private static SpanSamplingRules filterOutNullRules(List<Rule> list) {
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
        return new SpanSamplingRules(arrayList);
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public boolean isEmpty() {
        return this.rules.isEmpty();
    }

    public static final class Rule implements com.datadog.trace.api.sampling.SamplingRule.SpanSamplingRule {
        private final int maxPerSecond;
        private final String name;
        private final String resource;
        private final double sampleRate;
        private final String service;
        private final Map<String, String> tags;

        private Rule(String str, String str2, String str3, Map<String, String> map, double d, int i) {
            this.service = str;
            this.name = str2;
            this.resource = str3;
            this.tags = map;
            this.sampleRate = d;
            this.maxPerSecond = i;
        }

        public static Rule create(JsonRule jsonRule) {
            int iMax;
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
            if (jsonRule.max_per_second != null) {
                try {
                    double d3 = Double.parseDouble(jsonRule.max_per_second);
                    if (d3 <= 0.0d) {
                        logRuleError(jsonRule, "max_per_second must be greater than 0.0");
                        return null;
                    }
                    iMax = Math.max((int) d3, 1);
                } catch (NumberFormatException unused2) {
                    logRuleError(jsonRule, "max_per_second must be a number greater than 0.0");
                    return null;
                }
            } else {
                iMax = Integer.MAX_VALUE;
            }
            return new Rule(strNormalizeGlob, strNormalizeGlob2, strNormalizeGlob3, map2, d, iMax);
        }

        private static void logRuleError(JsonRule jsonRule, String str) {
            SpanSamplingRules.log.error("Skipping invalid Span Sampling Rule: {} - {}", jsonRule, str);
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

        @Override // com.datadog.trace.api.sampling.SamplingRule.SpanSamplingRule
        public int getMaxPerSecond() {
            return this.maxPerSecond;
        }

        public String asStringJsonRule() {
            JsonRule jsonRule = new JsonRule();
            jsonRule.service = this.service;
            jsonRule.name = this.name;
            jsonRule.resource = this.resource;
            jsonRule.tags = this.tags;
            jsonRule.sample_rate = String.valueOf(this.sampleRate);
            jsonRule.max_per_second = String.valueOf(this.maxPerSecond);
            return jsonRule.toString();
        }
    }

    private static final class JsonRule {
        static final String MAX_PER_SECOND_KEY = "max_per_second";
        static final String NAME_KEY = "name";
        static final String RESOURCE_KEY = "resource";
        static final String SAMPLE_RATE_KEY = "sample_rate";
        static final String SERVICE_KEY = "service";
        static final String TAGS_KEY = "tags";
        String max_per_second;
        String name;
        String resource;
        String sample_rate;
        String service;
        Map<String, String> tags;

        private JsonRule() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static JsonRule deserializeRule(JsonObject jsonObject) {
            JsonRule jsonRule = new JsonRule();
            jsonRule.name = JsonObjectUtils.getAsString(jsonObject, "name");
            jsonRule.resource = JsonObjectUtils.getAsString(jsonObject, "resource");
            jsonRule.sample_rate = JsonObjectUtils.getAsString(jsonObject, SAMPLE_RATE_KEY);
            jsonRule.service = JsonObjectUtils.getAsString(jsonObject, "service");
            jsonRule.max_per_second = JsonObjectUtils.getAsString(jsonObject, MAX_PER_SECOND_KEY);
            jsonRule.tags = JsonObjectUtils.safeGetAsMap(jsonObject, "tags");
            return jsonRule;
        }

        public String toString() {
            JsonObject jsonObject = new JsonObject();
            String str = this.max_per_second;
            if (str != null) {
                jsonObject.addProperty(MAX_PER_SECOND_KEY, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.resource;
            if (str3 != null) {
                jsonObject.addProperty("resource", str3);
            }
            String str4 = this.sample_rate;
            if (str4 != null) {
                jsonObject.addProperty(SAMPLE_RATE_KEY, str4);
            }
            String str5 = this.service;
            if (str5 != null) {
                jsonObject.addProperty("service", str5);
            }
            Map<String, String> map = this.tags;
            if (map != null) {
                jsonObject.add("tags", MapUtils.getAsJsonObject(map));
            }
            return jsonObject.toString();
        }
    }
}
