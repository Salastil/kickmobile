package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.naming.NamingSchema;
import com.datadog.trace.api.naming.v1.PeerServiceNamingV1;

/* JADX INFO: loaded from: classes6.dex */
public class NamingSchemaV0 implements NamingSchema {
    private final boolean allowInferredServices;
    private final NamingSchema.ForCache cacheNaming;
    private final NamingSchema.ForClient clientNaming;
    private final NamingSchema.ForCloud cloudNaming;
    private final NamingSchema.ForDatabase databaseNaming;
    private final NamingSchema.ForMessaging messagingNaming;
    private final NamingSchema.ForPeerService peerServiceNaming;
    private final NamingSchema.ForServer serverNaming;

    public NamingSchemaV0() {
        NamingSchema.ForPeerService peerServiceNamingV0;
        boolean z = !Config.get().isRemoveIntegrationServiceNamesEnabled();
        this.allowInferredServices = z;
        this.cacheNaming = new CacheNamingV0(z);
        this.clientNaming = new ClientNamingV0();
        this.cloudNaming = new CloudNamingV0(z);
        this.databaseNaming = new DatabaseNamingV0(z);
        this.messagingNaming = new MessagingNamingV0(z);
        if (Config.get().isPeerServiceDefaultsEnabled()) {
            peerServiceNamingV0 = new PeerServiceNamingV1(Config.get().getPeerServiceComponentOverrides());
        } else {
            peerServiceNamingV0 = new PeerServiceNamingV0();
        }
        this.peerServiceNaming = peerServiceNamingV0;
        this.serverNaming = new ServerNamingV0();
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
    public NamingSchema.ForServer server() {
        return this.serverNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public NamingSchema.ForPeerService peerService() {
        return this.peerServiceNaming;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema
    public boolean allowInferredServices() {
        return this.allowInferredServices;
    }
}
