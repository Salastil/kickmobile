package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.naming.NamingSchema;
import com.datadog.trace.api.naming.SpanNaming;
import com.datadog.trace.util.Strings;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class CloudNamingV1 implements NamingSchema.ForCloud {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String serviceForRequest(String str, String str2) {
        return null;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String operationForRequest(String str, String str2, String str3) {
        str3.hashCode();
        switch (str3) {
            case "SNS.Publish":
            case "Sns.Publish":
                return SpanNaming.instance().namingSchema().messaging().outboundOperation("sns");
            case "SQS.ReceiveMessage":
            case "Sqs.ReceiveMessage":
                return SpanNaming.instance().namingSchema().messaging().inboundOperation("sqs");
            case "SQS.SendMessage":
            case "Sqs.SendMessage":
            case "SQS.SendMessageBatch":
            case "Sqs.SendMessageBatch":
                return SpanNaming.instance().namingSchema().messaging().outboundOperation("sqs");
            default:
                return Strings.join(".", str, str2.toLowerCase(Locale.ROOT), "request");
        }
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCloud
    public String operationForFaas(String str) {
        return "aws.lambda.invoke";
    }
}
