package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.naming.NamingSchema;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;

/* JADX INFO: loaded from: classes6.dex */
public class MessagingNamingV0 implements NamingSchema.ForMessaging {
    private final boolean allowInferredServices;

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String timeInQueueService(String str) {
        return str;
    }

    public MessagingNamingV0(boolean z) {
        this.allowInferredServices = z;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String outboundOperation(String str) {
        if ("amqp".equals(str)) {
            return InstrumentationTags.AMQP_COMMAND;
        }
        return str + ".produce";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String outboundService(String str, boolean z) {
        return inboundService(str, z);
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String inboundOperation(String str) {
        str.hashCode();
        if (str.equals("sqs")) {
            return "aws.http";
        }
        if (str.equals("amqp")) {
            return InstrumentationTags.AMQP_COMMAND;
        }
        return str + ".consume";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String inboundService(String str, boolean z) {
        if (this.allowInferredServices) {
            return z ? str : Config.get().getServiceName();
        }
        return null;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForMessaging
    public String timeInQueueOperation(String str) {
        if ("sqs".equals(str)) {
            return "aws.http";
        }
        return str + ".deliver";
    }
}
