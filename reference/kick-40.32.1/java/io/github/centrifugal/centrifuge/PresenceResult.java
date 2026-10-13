package io.github.centrifugal.centrifuge;

import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class PresenceResult {
    private final Map<String, ClientInfo> clients;

    public PresenceResult(Map<String, ClientInfo> map) {
        this.clients = map;
    }

    public Map<String, ClientInfo> getClients() {
        return this.clients;
    }
}
