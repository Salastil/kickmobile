package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class SubscriptionStateError extends Exception {
    private final SubscriptionState state;

    SubscriptionStateError(SubscriptionState subscriptionState) {
        this.state = subscriptionState;
    }

    public SubscriptionState getState() {
        return this.state;
    }
}
