package com.pusher.client.user;

import com.pusher.client.channel.SubscriptionEventListener;

/* JADX INFO: loaded from: classes8.dex */
public interface User {
    void bind(String str, SubscriptionEventListener subscriptionEventListener);

    void bindGlobal(SubscriptionEventListener subscriptionEventListener);

    void unbind(String str, SubscriptionEventListener subscriptionEventListener);

    void unbindGlobal(SubscriptionEventListener subscriptionEventListener);

    String userId();
}
