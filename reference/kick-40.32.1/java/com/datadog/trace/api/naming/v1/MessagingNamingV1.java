package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class MessagingNamingV1 implements NamingSchema.ForMessaging {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String inboundService(String str, boolean z) {
        return null;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String outboundService(String str, boolean z) {
        return null;
    }

    private String normalizeForCloud(String str) {
        str.hashCode();
        switch (str) {
            case "google-pubsub":
                return "gcp.pubsub";
            case "sns":
            case "sqs":
                return "aws." + str;
            default:
                return str;
        }
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String outboundOperation(String str) {
        return normalizeForCloud(str) + ".send";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String inboundOperation(String str) {
        return normalizeForCloud(str) + ".process";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String timeInQueueService(String str) {
        return str + "-queue";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String timeInQueueOperation(String str) {
        return normalizeForCloud(str) + ".deliver";
    }
}
