package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ServerUnsubscribedEvent {
    private final String channel;

    public String getChannel() {
        return this.channel;
    }

    ServerUnsubscribedEvent(String str) {
        this.channel = str;
    }
}
