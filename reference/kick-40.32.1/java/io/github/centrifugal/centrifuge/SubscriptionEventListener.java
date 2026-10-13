package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public abstract class SubscriptionEventListener {
    public void onError(Subscription subscription, SubscriptionErrorEvent subscriptionErrorEvent) {
    }

    public void onJoin(Subscription subscription, JoinEvent joinEvent) {
    }

    public void onLeave(Subscription subscription, LeaveEvent leaveEvent) {
    }

    public void onPublication(Subscription subscription, PublicationEvent publicationEvent) {
    }

    public void onSubscribed(Subscription subscription, SubscribedEvent subscribedEvent) {
    }

    public void onSubscribing(Subscription subscription, SubscribingEvent subscribingEvent) {
    }

    public void onUnsubscribed(Subscription subscription, UnsubscribedEvent unsubscribedEvent) {
    }
}
