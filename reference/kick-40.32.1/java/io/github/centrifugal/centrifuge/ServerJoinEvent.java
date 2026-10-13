package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ServerJoinEvent {
    private final String channel;
    private final ClientInfo info;

    public String getChannel() {
        return this.channel;
    }

    public ClientInfo getInfo() {
        return this.info;
    }

    ServerJoinEvent(String str, ClientInfo clientInfo) {
        this.channel = str;
        this.info = clientInfo;
    }
}
