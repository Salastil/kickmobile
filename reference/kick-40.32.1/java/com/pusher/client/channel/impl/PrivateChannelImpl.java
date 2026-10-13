package com.pusher.client.channel.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.ChannelAuthorizer;
import com.pusher.client.channel.ChannelState;
import com.pusher.client.channel.PrivateChannel;
import com.pusher.client.channel.PrivateChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.impl.message.AuthResponse;
import com.pusher.client.channel.impl.message.SubscribeMessage;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.util.Factory;

/* JADX INFO: loaded from: classes8.dex */
public class PrivateChannelImpl extends ChannelImpl implements PrivateChannel {
    private static final String CLIENT_EVENT_PREFIX = "client-";
    private static final Gson GSON = new Gson();
    private final ChannelAuthorizer channelAuthorizer;
    protected String channelData;
    private final InternalConnection connection;

    public PrivateChannelImpl(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer, Factory factory) {
        super(str, factory);
        this.connection = internalConnection;
        this.channelAuthorizer = channelAuthorizer;
    }

    @Override // com.pusher.client.channel.PrivateChannel
    public void trigger(String str, String str2) {
        if (str == null || !str.startsWith(CLIENT_EVENT_PREFIX)) {
            throw new IllegalArgumentException("Cannot trigger event " + str + ": client events must start with \"client-\"");
        }
        if (this.state != ChannelState.SUBSCRIBED) {
            throw new IllegalStateException("Cannot trigger event " + str + " because channel " + this.name + " is in " + this.state.toString() + " state");
        }
        if (this.connection.getState() != ConnectionState.CONNECTED) {
            throw new IllegalStateException("Cannot trigger event " + str + " because connection is in " + this.connection.getState().toString() + " state");
        }
        this.connection.sendMessage(new PusherEvent(str, this.name, (String) null, str2).toJson());
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.Channel
    public void bind(String str, SubscriptionEventListener subscriptionEventListener) {
        if (!(subscriptionEventListener instanceof PrivateChannelEventListener)) {
            throw new IllegalArgumentException("Only instances of PrivateChannelEventListener can be bound to a private channel");
        }
        super.bind(str, subscriptionEventListener);
    }

    private String authorize() {
        try {
            AuthResponse authResponse = (AuthResponse) GSON.fromJson(getAuthorizationResponse(), AuthResponse.class);
            this.channelData = authResponse.getChannelData();
            if (authResponse.getAuth() == null) {
                throw new AuthorizationFailureException("Didn't receive all the fields expected from the ChannelAuthorizer, expected an auth and shared_secret.");
            }
            return authResponse.getAuth();
        } catch (JsonSyntaxException unused) {
            throw new AuthorizationFailureException("Unable to parse response from ChannelAuthorizer");
        }
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public String toSubscribeMessage() {
        return GSON.toJson(new SubscribeMessage(this.name, authorize(), this.channelData));
    }

    @Override // com.pusher.client.channel.impl.ChannelImpl
    protected String[] getDisallowedNameExpressions() {
        return new String[]{"^(?!private-).*", "^private-encrypted-.*"};
    }

    private String getAuthorizationResponse() {
        return this.channelAuthorizer.authorize(getName(), this.connection.getSocketId());
    }

    @Override // com.pusher.client.channel.impl.ChannelImpl, com.pusher.client.channel.impl.BaseChannel
    public String toString() {
        return String.format("[Private Channel: name=%s]", this.name);
    }
}
