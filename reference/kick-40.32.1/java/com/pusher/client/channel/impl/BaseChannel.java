package com.pusher.client.channel.impl;

import com.google.gson.Gson;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.ChannelState;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.impl.message.SubscribeMessage;
import com.pusher.client.channel.impl.message.SubscriptionCountData;
import com.pusher.client.channel.impl.message.UnsubscribeMessage;
import com.pusher.client.util.Factory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseChannel implements InternalChannel {
    private static final String INTERNAL_EVENT_PREFIX = "pusher_internal:";
    protected static final String PUBLIC_SUBSCRIPTION_COUNT_EVENT = "pusher:subscription_count";
    protected static final String SUBSCRIPTION_COUNT_EVENT = "pusher_internal:subscription_count";
    protected static final String SUBSCRIPTION_SUCCESS_EVENT = "pusher_internal:subscription_succeeded";
    private ChannelEventListener eventListener;
    private final Factory factory;
    private Integer subscriptionCount;
    protected final Gson GSON = new Gson();
    private final Set<SubscriptionEventListener> globalListeners = new HashSet();
    private final Map<String, Set<SubscriptionEventListener>> eventNameToListenerMap = new HashMap();
    protected volatile ChannelState state = ChannelState.INITIAL;
    private final Object lock = new Object();

    @Override // com.pusher.client.channel.Channel
    public abstract String getName();

    public BaseChannel(Factory factory) {
        this.factory = factory;
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public Integer getCount() {
        return this.subscriptionCount;
    }

    @Override // com.pusher.client.channel.Channel
    public void bind(String str, SubscriptionEventListener subscriptionEventListener) {
        validateArguments(str, subscriptionEventListener);
        synchronized (this.lock) {
            Set<SubscriptionEventListener> hashSet = this.eventNameToListenerMap.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.eventNameToListenerMap.put(str, hashSet);
            }
            hashSet.add(subscriptionEventListener);
        }
    }

    @Override // com.pusher.client.channel.Channel
    public void bindGlobal(SubscriptionEventListener subscriptionEventListener) {
        validateArguments("", subscriptionEventListener);
        synchronized (this.lock) {
            this.globalListeners.add(subscriptionEventListener);
        }
    }

    @Override // com.pusher.client.channel.Channel
    public void unbind(String str, SubscriptionEventListener subscriptionEventListener) {
        validateArguments(str, subscriptionEventListener);
        synchronized (this.lock) {
            Set<SubscriptionEventListener> set = this.eventNameToListenerMap.get(str);
            if (set != null) {
                set.remove(subscriptionEventListener);
                if (set.isEmpty()) {
                    this.eventNameToListenerMap.remove(str);
                }
            }
        }
    }

    @Override // com.pusher.client.channel.Channel
    public void unbindGlobal(SubscriptionEventListener subscriptionEventListener) {
        validateArguments("", subscriptionEventListener);
        synchronized (this.lock) {
            Set<SubscriptionEventListener> set = this.globalListeners;
            if (set != null) {
                set.remove(subscriptionEventListener);
            }
        }
    }

    @Override // com.pusher.client.channel.Channel
    public boolean isSubscribed() {
        return this.state == ChannelState.SUBSCRIBED;
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public String toSubscribeMessage() {
        return this.GSON.toJson(new SubscribeMessage(getName()));
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public String toUnsubscribeMessage() {
        return this.GSON.toJson(new UnsubscribeMessage(getName()));
    }

    public void emit(final PusherEvent pusherEvent) {
        Set<SubscriptionEventListener> interestedListeners = getInterestedListeners(pusherEvent.getEventName());
        if (interestedListeners != null) {
            for (final SubscriptionEventListener subscriptionEventListener : interestedListeners) {
                this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.channel.impl.BaseChannel$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        subscriptionEventListener.onEvent(pusherEvent);
                    }
                });
            }
        }
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public void handleEvent(PusherEvent pusherEvent) {
        if (pusherEvent.getEventName().equals(SUBSCRIPTION_SUCCESS_EVENT)) {
            updateState(ChannelState.SUBSCRIBED);
        } else if (pusherEvent.getEventName().equals(SUBSCRIPTION_COUNT_EVENT)) {
            handleSubscriptionCountEvent(pusherEvent);
        } else {
            emit(pusherEvent);
        }
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public void updateState(ChannelState channelState) {
        this.state = channelState;
        if (channelState != ChannelState.SUBSCRIBED || this.eventListener == null) {
            return;
        }
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.channel.impl.BaseChannel$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11728lambda$updateState$1$compusherclientchannelimplBaseChannel();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateState$1$com-pusher-client-channel-impl-BaseChannel, reason: not valid java name */
    /* synthetic */ void m11728lambda$updateState$1$compusherclientchannelimplBaseChannel() {
        this.eventListener.onSubscriptionSucceeded(getName());
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public void setEventListener(ChannelEventListener channelEventListener) {
        this.eventListener = channelEventListener;
    }

    @Override // com.pusher.client.channel.impl.InternalChannel
    public ChannelEventListener getEventListener() {
        return this.eventListener;
    }

    @Override // java.lang.Comparable
    public int compareTo(InternalChannel internalChannel) {
        return getName().compareTo(internalChannel.getName());
    }

    public String toString() {
        return String.format("[Channel: name=%s]", getName());
    }

    private void validateArguments(String str, SubscriptionEventListener subscriptionEventListener) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot bind or unbind to channel " + getName() + " with a null event name");
        }
        if (subscriptionEventListener == null) {
            throw new IllegalArgumentException("Cannot bind or unbind to channel " + getName() + " with a null listener");
        }
        if (str.startsWith(INTERNAL_EVENT_PREFIX)) {
            throw new IllegalArgumentException("Cannot bind or unbind channel " + getName() + " with an internal event name such as " + str);
        }
    }

    private void handleSubscriptionCountEvent(PusherEvent pusherEvent) {
        this.subscriptionCount = Integer.valueOf(((SubscriptionCountData) this.GSON.fromJson(pusherEvent.getData(), SubscriptionCountData.class)).getCount());
        emit(new PusherEvent(PUBLIC_SUBSCRIPTION_COUNT_EVENT, pusherEvent.getChannelName(), pusherEvent.getUserId(), pusherEvent.getData()));
    }

    protected Set<SubscriptionEventListener> getInterestedListeners(String str) {
        synchronized (this.lock) {
            HashSet hashSet = new HashSet();
            Set<SubscriptionEventListener> set = this.eventNameToListenerMap.get(str);
            if (set != null) {
                hashSet.addAll(set);
            }
            if (!this.globalListeners.isEmpty()) {
                hashSet.addAll(this.globalListeners);
            }
            if (hashSet.isEmpty()) {
                return null;
            }
            return hashSet;
        }
    }
}
