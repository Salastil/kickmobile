package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class ClientNamingV1 implements NamingSchema.ForClient {
    private String normalizeProtocol(String str) {
        str.hashCode();
        switch (str) {
            case "ftp":
            case "ftps":
                return "ftp";
            case "http":
            case "https":
                return "http";
            default:
                return str;
        }
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForClient
    public String operationForProtocol(String str) {
        return normalizeProtocol(str) + ".client.request";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForClient
    public String operationForComponent(String str) {
        return "http.client.request";
    }
}
