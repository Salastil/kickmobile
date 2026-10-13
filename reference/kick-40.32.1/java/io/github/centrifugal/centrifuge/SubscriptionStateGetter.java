package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public abstract class SubscriptionStateGetter {
    public void getSubscriptionState(SubscriptionGetStateEvent subscriptionGetStateEvent, StateCallback stateCallback) {
        stateCallback.Done(null, null);
    }
}
