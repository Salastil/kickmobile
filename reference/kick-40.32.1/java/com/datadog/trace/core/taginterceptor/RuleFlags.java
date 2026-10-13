package com.datadog.trace.core.taginterceptor;

import com.datadog.trace.api.Config;

/* JADX INFO: loaded from: classes6.dex */
public class RuleFlags {
    private final boolean[] flags;

    public enum Feature {
        RESOURCE_NAME("ResourceNameRule"),
        URL_AS_RESOURCE_NAME("URLAsResourceNameRule"),
        STATUS_404("Status404Rule"),
        STATUS_404_DECORATOR("Status404Decorator"),
        DB_STATEMENT("DBStatementRule"),
        FORCE_MANUAL_DROP("ForceManualDropTagInterceptor"),
        FORCE_MANUAL_KEEP("ForceManualKeepTagInterceptor"),
        PEER_SERVICE("PeerServiceTagInterceptor", false),
        SERVICE_NAME("ServiceNameTagInterceptor"),
        SERVLET_CONTEXT("ServletContextTagInterceptor");

        private final boolean defaultEnabled;
        private final String name;

        Feature(String str) {
            this.name = str;
            this.defaultEnabled = true;
        }

        Feature(String str, boolean z) {
            this.name = str;
            this.defaultEnabled = z;
        }
    }

    public RuleFlags() {
        this(Config.get());
    }

    public RuleFlags(Config config) {
        Feature[] featureArrValues = Feature.values();
        this.flags = new boolean[featureArrValues.length];
        for (Feature feature : featureArrValues) {
            if (config.isRuleEnabled(feature.name, feature.defaultEnabled)) {
                this.flags[feature.ordinal()] = true;
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.flags[feature.ordinal()];
    }
}
