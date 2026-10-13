package com.pusher.client.channel.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.ChannelAuthorizer;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.PresenceChannel;
import com.pusher.client.channel.PresenceChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.User;
import com.pusher.client.channel.impl.message.ChannelData;
import com.pusher.client.channel.impl.message.PresenceMemberData;
import com.pusher.client.channel.impl.message.PresenceSubscriptionData;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.util.Factory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class PresenceChannelImpl extends PrivateChannelImpl implements PresenceChannel {
    private static final Gson GSON = new Gson();
    private static final String MEMBER_ADDED_EVENT = "pusher_internal:member_added";
    private static final String MEMBER_REMOVED_EVENT = "pusher_internal:member_removed";
    private final Map<String, User> idToUserMap;
    private String myUserID;

    public PresenceChannelImpl(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer, Factory factory) {
        super(internalConnection, str, channelAuthorizer, factory);
        this.idToUserMap = Collections.synchronizedMap(new LinkedHashMap());
    }

    @Override // com.pusher.client.channel.PresenceChannel
    public Set<User> getUsers() {
        return new LinkedHashSet(this.idToUserMap.values());
    }

    @Override // com.pusher.client.channel.PresenceChannel
    public User getMe() {
        return this.idToUserMap.get(this.myUserID);
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public void handleEvent(PusherEvent pusherEvent) {
        super.handleEvent(pusherEvent);
        String eventName = pusherEvent.getEventName();
        eventName.hashCode();
        switch (eventName) {
            case "pusher_internal:subscription_succeeded":
                handleSubscriptionSuccessfulMessage(pusherEvent);
                break;
            case "pusher_internal:member_removed":
                handleMemberRemovedEvent(pusherEvent);
                break;
            case "pusher_internal:member_added":
                handleMemberAddedEvent(pusherEvent);
                break;
        }
    }

    @Override // com.pusher.client.channel.impl.PrivateChannelImpl, com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public String toSubscribeMessage() {
        String subscribeMessage = super.toSubscribeMessage();
        this.myUserID = extractUserIdFromChannelData(this.channelData);
        return subscribeMessage;
    }

    @Override // com.pusher.client.channel.impl.PrivateChannelImpl, com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.Channel
    public void bind(String str, SubscriptionEventListener subscriptionEventListener) {
        if (!(subscriptionEventListener instanceof PresenceChannelEventListener)) {
            throw new IllegalArgumentException("Only instances of PresenceChannelEventListener can be bound to a presence channel");
        }
        super.bind(str, subscriptionEventListener);
    }

    @Override // com.pusher.client.channel.impl.PrivateChannelImpl, com.pusher.client.channel.impl.ChannelImpl
    protected String[] getDisallowedNameExpressions() {
        return new String[]{"^(?!presence-).*"};
    }

    @Override // com.pusher.client.channel.impl.PrivateChannelImpl, com.pusher.client.channel.impl.ChannelImpl, com.pusher.client.channel.impl.BaseChannel
    public String toString() {
        return String.format("[Presence Channel: name=%s]", this.name);
    }

    private void handleSubscriptionSuccessfulMessage(PusherEvent pusherEvent) {
        ChannelEventListener eventListener = getEventListener();
        PresenceSubscriptionData presenceSubscriptionData = (PresenceSubscriptionData) GSON.fromJson(pusherEvent.getData(), PresenceSubscriptionData.class);
        if (presenceSubscriptionData.presence == null) {
            if (eventListener != null) {
                eventListener.onError("Subscription failed: Presence data not found", null);
                return;
            }
            return;
        }
        List<String> ids = presenceSubscriptionData.getIds();
        Map<String, Object> hash = presenceSubscriptionData.getHash();
        if (ids != null && !ids.isEmpty()) {
            for (String str : ids) {
                this.idToUserMap.put(str, new User(str, hash.get(str) != null ? GSON.toJson(hash.get(str)) : null));
            }
        }
        if (eventListener != null) {
            ((PresenceChannelEventListener) eventListener).onUsersInformationReceived(getName(), getUsers());
        }
    }

    private void handleMemberAddedEvent(PusherEvent pusherEvent) {
        Gson gson = GSON;
        PresenceMemberData presenceMemberData = (PresenceMemberData) gson.fromJson(pusherEvent.getData(), PresenceMemberData.class);
        String id = presenceMemberData.getId();
        User user = new User(id, presenceMemberData.getInfo() != null ? gson.toJson(presenceMemberData.getInfo()) : null);
        this.idToUserMap.put(id, user);
        ChannelEventListener eventListener = getEventListener();
        if (eventListener != null) {
            ((PresenceChannelEventListener) eventListener).userSubscribed(getName(), user);
        }
    }

    private void handleMemberRemovedEvent(PusherEvent pusherEvent) {
        User userRemove = this.idToUserMap.remove(((PresenceMemberData) GSON.fromJson(pusherEvent.getData(), PresenceMemberData.class)).getId());
        ChannelEventListener eventListener = getEventListener();
        if (eventListener != null) {
            ((PresenceChannelEventListener) eventListener).userUnsubscribed(getName(), userRemove);
        }
    }

    public String extractUserIdFromChannelData(String str) {
        try {
            ChannelData channelData = (ChannelData) GSON.fromJson(str, ChannelData.class);
            if (channelData.getUserId() == null) {
                throw new AuthorizationFailureException("Invalid response from ChannelAuthorizer: no user_id key in channel_data object: " + str);
            }
            return channelData.getUserId();
        } catch (JsonSyntaxException e) {
            throw new AuthorizationFailureException("Invalid response from ChannelAuthorizer: unable to parse channel_data object: " + str, e);
        } catch (NullPointerException unused) {
            throw new AuthorizationFailureException("Invalid response from ChannelAuthorizer: no user_id key in channel_data object: " + str);
        }
    }
}
