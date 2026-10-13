package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class NamingSchemaV1 implements NamingSchema {
    private final NamingSchema.ForCache cacheNaming = new CacheNamingV1();
    private final NamingSchema.ForClient clientNaming = new ClientNamingV1();
    private final NamingSchema.ForCloud cloudNaming = new CloudNamingV1();
    private final NamingSchema.ForDatabase databaseNaming = new DatabaseNamingV1();
    private final NamingSchema.ForMessaging messagingNaming = new MessagingNamingV1();
    private final NamingSchema.ForPeerService peerServiceNaming = new PeerServiceNamingV1(Config.get().getPeerServiceComponentOverrides());
    private final NamingSchema.ForServer serverNaming = new ServerNamingV1();

    @Override // com.datadog.trace.api.naming.NamingSchema
    public boolean allowInferredServices() {
        return false;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForCache cache() {
        return this.cacheNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForClient client() {
        return this.clientNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForCloud cloud() {
        return this.cloudNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForDatabase database() {
        return this.databaseNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForMessaging messaging() {
        return this.messagingNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForPeerService peerService() {
        return this.peerServiceNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForServer server() {
        return this.serverNaming;
    }
}
