package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class PeerServiceNamingV0 implements NamingSchema.ForPeerService {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForPeerService
    public boolean supports() {
        return false;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForPeerService
    public Map<String, Object> tags(Map<String, Object> map) {
        return Collections.EMPTY_MAP;
    }
}
