package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class ServerNamingV0 implements NamingSchema.ForServer {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForServer
    public String operationForProtocol(String str) {
        if ("grpc".equals(str)) {
            return "grpc.server";
        }
        return str + ".request";
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForServer
    public String operationForComponent(String str) {
        str.hashCode();
        switch (str) {
            case "spray-http-server":
                str = "spray-http";
                break;
            case "finatra":
            case "netty":
            case "axway-http":
                break;
            case "pekko-http-server":
                str = "pekko-http";
                break;
            case "restlet-http-server":
                str = "restlet-http";
                break;
            case "akka-http-server":
                str = "akka-http";
                break;
            case "undertow-http-server":
                str = "undertow-http";
                break;
            case "synapse-server":
                str = "synapse";
                break;
            default:
                str = "servlet";
                break;
        }
        return str + ".request";
    }
}
