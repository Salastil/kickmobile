package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class CloudNamingV0 implements NamingSchema.ForCloud {
    private final boolean allowInferredServices;

    public CloudNamingV0(boolean z) {
        this.allowInferredServices = z;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String operationForRequest(String str, String str2, String str3) {
        return "aws.http";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String serviceForRequest(String str, String str2) {
        if (!this.allowInferredServices) {
            return null;
        }
        if (str2 == null) {
            return "java-aws-sdk";
        }
        str2.hashCode();
        return (str2.equals("sns") || str2.equals("sqs")) ? str2 : "java-aws-sdk";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String operationForFaas(String str) {
        return "dd-tracer-serverless-span";
    }
}
