package com.datadog.trace.api.naming;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface NamingSchema {

    public interface ForCache {
        String operation(String str);

        String service(String str);
    }

    public interface ForClient {
        String operationForComponent(String str);

        String operationForProtocol(String str);
    }

    public interface ForCloud {
        String operationForFaas(String str);

        String operationForRequest(String str, String str2, String str3);

        String serviceForRequest(String str, String str2);
    }

    public interface ForDatabase {
        String normalizedName(String str);

        String operation(String str);

        String service(String str);
    }

    public interface ForMessaging {
        String inboundOperation(String str);

        String inboundService(String str, boolean z);

        String outboundOperation(String str);

        String outboundService(String str, boolean z);

        String timeInQueueOperation(String str);

        String timeInQueueService(String str);
    }

    public interface ForPeerService {
        boolean supports();

        Map<String, Object> tags(Map<String, Object> map);
    }

    public interface ForServer {
        String operationForComponent(String str);

        String operationForProtocol(String str);
    }

    boolean allowInferredServices();

    ForCache cache();

    ForClient client();

    ForCloud cloud();

    ForDatabase database();

    ForMessaging messaging();

    ForPeerService peerService();

    ForServer server();
}
