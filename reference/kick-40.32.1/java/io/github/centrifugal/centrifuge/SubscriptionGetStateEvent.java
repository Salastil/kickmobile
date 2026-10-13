package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class SubscriptionGetStateEvent {
    private final String channel;

    public SubscriptionGetStateEvent(String str) {
        this.channel = str;
    }

    public String getChannel() {
        return this.channel;
    }
}
