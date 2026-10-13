package com.pusher.client;

import com.pusher.client.channel.Channel;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.PresenceChannel;
import com.pusher.client.channel.PresenceChannelEventListener;
import com.pusher.client.channel.PrivateChannel;
import com.pusher.client.channel.PrivateChannelEventListener;
import com.pusher.client.channel.PrivateEncryptedChannel;
import com.pusher.client.channel.PrivateEncryptedChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.impl.ChannelImpl;
import com.pusher.client.channel.impl.ChannelManager;
import com.pusher.client.channel.impl.PresenceChannelImpl;
import com.pusher.client.channel.impl.PrivateChannelImpl;
import com.pusher.client.channel.impl.PrivateEncryptedChannelImpl;
import com.pusher.client.connection.Connection;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.user.User;
import com.pusher.client.user.impl.InternalUser;
import com.pusher.client.util.Factory;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public class Pusher implements Client {
    private final ChannelManager channelManager;
    private final InternalConnection connection;
    private final Factory factory;
    private final PusherOptions pusherOptions;
    private final InternalUser user;

    public Pusher(String str) {
        this(str, new PusherOptions());
    }

    public Pusher(String str, PusherOptions pusherOptions) {
        this(str, pusherOptions, new Factory());
    }

    Pusher(String str, PusherOptions pusherOptions, Factory factory) throws Throwable {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("API Key cannot be null or empty");
        }
        if (pusherOptions == null) {
            throw new IllegalArgumentException("PusherOptions cannot be null");
        }
        this.pusherOptions = pusherOptions;
        this.factory = factory;
        InternalConnection connection = factory.getConnection(str, pusherOptions, new Consumer() { // from class: com.pusher.client.Pusher$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.handleEvent((PusherEvent) obj);
            }
        });
        this.connection = connection;
        ChannelManager channelManager = factory.getChannelManager();
        this.channelManager = channelManager;
        this.user = factory.newUser(connection, pusherOptions.getUserAuthenticator());
        channelManager.setConnection(connection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEvent(PusherEvent pusherEvent) {
        this.user.handleEvent(pusherEvent);
        this.channelManager.handleEvent(pusherEvent);
    }

    @Override // com.pusher.client.Client
    public Connection getConnection() {
        return this.connection;
    }

    @Override // com.pusher.client.Client
    public void connect() {
        connect(null, new ConnectionState[0]);
    }

    @Override // com.pusher.client.Client
    public void connect(ConnectionEventListener connectionEventListener, ConnectionState... connectionStateArr) {
        if (connectionEventListener != null) {
            if (connectionStateArr.length == 0) {
                connectionStateArr = new ConnectionState[]{ConnectionState.ALL};
            }
            for (ConnectionState connectionState : connectionStateArr) {
                this.connection.bind(connectionState, connectionEventListener);
            }
        } else if (connectionStateArr.length > 0) {
            throw new IllegalArgumentException("Cannot bind to connection states with a null connection event listener");
        }
        this.connection.connect();
    }

    @Override // com.pusher.client.Client
    public void disconnect() {
        if (this.connection.getState() == ConnectionState.DISCONNECTING || this.connection.getState() == ConnectionState.DISCONNECTED) {
            return;
        }
        this.connection.disconnect();
    }

    public User user() {
        return this.user;
    }

    public void signin() {
        throwExceptionIfNoUserAuthenticatorHasBeenSet();
        this.user.signin();
    }

    @Override // com.pusher.client.Client
    public Channel subscribe(String str) {
        return subscribe(str, null, new String[0]);
    }

    @Override // com.pusher.client.Client
    public Channel subscribe(String str, ChannelEventListener channelEventListener, String... strArr) {
        ChannelImpl channelImplNewPublicChannel = this.factory.newPublicChannel(str);
        this.channelManager.subscribeTo(channelImplNewPublicChannel, channelEventListener, strArr);
        return channelImplNewPublicChannel;
    }

    @Override // com.pusher.client.Client
    public PrivateChannel subscribePrivate(String str) {
        return subscribePrivate(str, null, new String[0]);
    }

    @Override // com.pusher.client.Client
    public PrivateChannel subscribePrivate(String str, PrivateChannelEventListener privateChannelEventListener, String... strArr) {
        throwExceptionIfNoChannelAuthorizerHasBeenSet();
        PrivateChannelImpl privateChannelImplNewPrivateChannel = this.factory.newPrivateChannel(this.connection, str, this.pusherOptions.getChannelAuthorizer());
        this.channelManager.subscribeTo(privateChannelImplNewPrivateChannel, privateChannelEventListener, strArr);
        return privateChannelImplNewPrivateChannel;
    }

    public PrivateEncryptedChannel subscribePrivateEncrypted(String str, PrivateEncryptedChannelEventListener privateEncryptedChannelEventListener, String... strArr) {
        throwExceptionIfNoChannelAuthorizerHasBeenSet();
        PrivateEncryptedChannelImpl privateEncryptedChannelImplNewPrivateEncryptedChannel = this.factory.newPrivateEncryptedChannel(this.connection, str, this.pusherOptions.getChannelAuthorizer());
        this.channelManager.subscribeTo(privateEncryptedChannelImplNewPrivateEncryptedChannel, privateEncryptedChannelEventListener, strArr);
        return privateEncryptedChannelImplNewPrivateEncryptedChannel;
    }

    @Override // com.pusher.client.Client
    public PresenceChannel subscribePresence(String str) {
        return subscribePresence(str, null, new String[0]);
    }

    @Override // com.pusher.client.Client
    public PresenceChannel subscribePresence(String str, PresenceChannelEventListener presenceChannelEventListener, String... strArr) {
        throwExceptionIfNoChannelAuthorizerHasBeenSet();
        PresenceChannelImpl presenceChannelImplNewPresenceChannel = this.factory.newPresenceChannel(this.connection, str, this.pusherOptions.getChannelAuthorizer());
        this.channelManager.subscribeTo(presenceChannelImplNewPresenceChannel, presenceChannelEventListener, strArr);
        return presenceChannelImplNewPresenceChannel;
    }

    @Override // com.pusher.client.Client
    public void unsubscribe(String str) {
        this.channelManager.unsubscribeFrom(str);
    }

    private void throwExceptionIfNoChannelAuthorizerHasBeenSet() {
        if (this.pusherOptions.getChannelAuthorizer() == null) {
            throw new IllegalStateException("Cannot subscribe to a private or presence channel because no ChannelAuthorizer has been set. Call PusherOptions.setChannelAuthorizer() before connecting to Pusher");
        }
    }

    private void throwExceptionIfNoUserAuthenticatorHasBeenSet() {
        if (this.pusherOptions.getUserAuthenticator() == null) {
            throw new IllegalStateException("Cannot sign in because no UserAuthenticator has been set. Call PusherOptions.setUserAuthenticator() before connecting to Pusher");
        }
    }

    @Override // com.pusher.client.Client
    public Channel getChannel(String str) {
        return this.channelManager.getChannel(str);
    }

    @Override // com.pusher.client.Client
    public PrivateChannel getPrivateChannel(String str) {
        return this.channelManager.getPrivateChannel(str);
    }

    public PrivateEncryptedChannel getPrivateEncryptedChannel(String str) {
        return this.channelManager.getPrivateEncryptedChannel(str);
    }

    @Override // com.pusher.client.Client
    public PresenceChannel getPresenceChannel(String str) {
        return this.channelManager.getPresenceChannel(str);
    }
}
