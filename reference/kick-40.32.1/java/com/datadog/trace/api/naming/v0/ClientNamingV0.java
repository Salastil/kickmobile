package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class ClientNamingV0 implements NamingSchema.ForClient {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForClient
    public String operationForProtocol(String str) {
        String str2;
        str.hashCode();
        if (str.equals("rmi")) {
            str2 = ".invoke";
        } else if (str.equals("grpc")) {
            str2 = ".client";
        } else {
            str2 = ".request";
        }
        return str + str2;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForClient
    public String operationForComponent(String str) {
        str.hashCode();
        switch (str) {
            case "okhttp":
            case "play-ws":
                return str + ".request";
            case "pekko-http-client":
                return "pekko-http.client.request";
            case "akka-http-client":
                return "akka-http.client.request";
            case "netty-client":
                return "netty.client.request";
            case "jax-rs.client":
                return "jax-rs.client.call";
            default:
                return "http.request";
        }
    }
}
