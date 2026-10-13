package com.pusher.client.channel.impl;

import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.ChannelState;
import com.pusher.client.channel.PresenceChannel;
import com.pusher.client.channel.PrivateChannel;
import com.pusher.client.channel.PrivateChannelEventListener;
import com.pusher.client.channel.PrivateEncryptedChannel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.util.Factory;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelManager implements ConnectionEventListener {
    private final Map<String, InternalChannel> channelNameToChannelMap = new ConcurrentHashMap();
    private InternalConnection connection;
    private final Factory factory;

    @Override // com.pusher.client.connection.ConnectionEventListener
    public void onError(String str, String str2, Exception exc) {
    }

    public ChannelManager(Factory factory) {
        this.factory = factory;
    }

    public Channel getChannel(String str) {
        if (str.startsWith("private-")) {
            throw new IllegalArgumentException("Please use the getPrivateChannel method");
        }
        if (str.startsWith("presence-")) {
            throw new IllegalArgumentException("Please use the getPresenceChannel method");
        }
        return findChannelInChannelMap(str);
    }

    public PrivateChannel getPrivateChannel(String str) throws IllegalArgumentException {
        if (!str.startsWith("private-")) {
            throw new IllegalArgumentException("Private channels must begin with 'private-'");
        }
        return (PrivateChannel) findChannelInChannelMap(str);
    }

    public PrivateEncryptedChannel getPrivateEncryptedChannel(String str) throws IllegalArgumentException {
        if (!str.startsWith("private-encrypted-")) {
            throw new IllegalArgumentException("Encrypted private channels must begin with 'private-encrypted-'");
        }
        return (PrivateEncryptedChannel) findChannelInChannelMap(str);
    }

    public PresenceChannel getPresenceChannel(String str) throws IllegalArgumentException {
        if (!str.startsWith("presence-")) {
            throw new IllegalArgumentException("Presence channels must begin with 'presence-'");
        }
        return (PresenceChannel) findChannelInChannelMap(str);
    }

    private InternalChannel findChannelInChannelMap(String str) {
        return this.channelNameToChannelMap.get(str);
    }

    public void setConnection(InternalConnection internalConnection) {
        if (internalConnection == null) {
            throw new IllegalArgumentException("Cannot construct ChannelManager with a null connection");
        }
        InternalConnection internalConnection2 = this.connection;
        if (internalConnection2 != null) {
            internalConnection2.unbind(ConnectionState.CONNECTED, this);
        }
        this.connection = internalConnection;
        internalConnection.bind(ConnectionState.CONNECTED, this);
    }

    public void subscribeTo(InternalChannel internalChannel, ChannelEventListener channelEventListener, String... strArr) {
        validateArgumentsAndBindEvents(internalChannel, channelEventListener, strArr);
        this.channelNameToChannelMap.put(internalChannel.getName(), internalChannel);
        sendOrQueueSubscribeMessage(internalChannel);
    }

    public void unsubscribeFrom(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot unsubscribe from null channel");
        }
        InternalChannel internalChannelRemove = this.channelNameToChannelMap.remove(str);
        if (internalChannelRemove != null && this.connection.getState() == ConnectionState.CONNECTED) {
            sendUnsubscribeMessage(internalChannelRemove);
        }
    }

    public void handleEvent(PusherEvent pusherEvent) {
        InternalChannel internalChannel;
        String channelName = pusherEvent.getChannelName();
        if (channelName == null || (internalChannel = this.channelNameToChannelMap.get(channelName)) == null) {
            return;
        }
        internalChannel.handleEvent(pusherEvent);
    }

    @Override // com.pusher.client.connection.ConnectionEventListener
    public void onConnectionStateChange(ConnectionStateChange connectionStateChange) {
        if (connectionStateChange.getCurrentState() == ConnectionState.CONNECTED) {
            Iterator<InternalChannel> it = this.channelNameToChannelMap.values().iterator();
            while (it.hasNext()) {
                sendOrQueueSubscribeMessage(it.next());
            }
        }
    }

    private void sendOrQueueSubscribeMessage(final InternalChannel internalChannel) {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.channel.impl.ChannelManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11729x3513113(internalChannel);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendOrQueueSubscribeMessage$0$com-pusher-client-channel-impl-ChannelManager, reason: not valid java name */
    /* synthetic */ void m11729x3513113(InternalChannel internalChannel) {
        if (this.connection.getState() == ConnectionState.CONNECTED) {
            try {
                this.connection.sendMessage(internalChannel.toSubscribeMessage());
                internalChannel.updateState(ChannelState.SUBSCRIBE_SENT);
            } catch (AuthorizationFailureException e) {
                handleAuthenticationFailure(internalChannel, e);
            }
        }
    }

    private void sendUnsubscribeMessage(final InternalChannel internalChannel) {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.channel.impl.ChannelManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11730xb4e21409(internalChannel);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendUnsubscribeMessage$1$com-pusher-client-channel-impl-ChannelManager, reason: not valid java name */
    /* synthetic */ void m11730xb4e21409(InternalChannel internalChannel) {
        this.connection.sendMessage(internalChannel.toUnsubscribeMessage());
        internalChannel.updateState(ChannelState.UNSUBSCRIBED);
    }

    private void handleAuthenticationFailure(final InternalChannel internalChannel, final Exception exc) {
        this.channelNameToChannelMap.remove(internalChannel.getName());
        internalChannel.updateState(ChannelState.FAILED);
        if (internalChannel.getEventListener() != null) {
            this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.channel.impl.ChannelManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InternalChannel internalChannel2 = internalChannel;
                    Exception exc2 = exc;
                    ((PrivateChannelEventListener) internalChannel2.getEventListener()).onAuthenticationFailure(exc2.getMessage(), exc2);
                }
            });
        }
    }

    private void validateArgumentsAndBindEvents(InternalChannel internalChannel, ChannelEventListener channelEventListener, String... strArr) {
        if (internalChannel == null) {
            throw new IllegalArgumentException("Cannot subscribe to a null channel");
        }
        if (this.channelNameToChannelMap.containsKey(internalChannel.getName())) {
            throw new IllegalArgumentException("Already subscribed to a channel with name " + internalChannel.getName());
        }
        for (String str : strArr) {
            internalChannel.bind(str, channelEventListener);
        }
        internalChannel.setEventListener(channelEventListener);
    }
}
