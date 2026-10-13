package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class ServerNamingV1 implements NamingSchema.ForServer {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForServer
    public String operationForProtocol(String str) {
        return str + ".server.request";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForServer
    public String operationForComponent(String str) {
        return "http.server.request";
    }
}
