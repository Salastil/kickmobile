package com.pusher.client.channel.impl;

import com.google.gson.JsonSyntaxException;
import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.ChannelAuthorizer;
import com.pusher.client.channel.ChannelState;
import com.pusher.client.channel.PrivateEncryptedChannel;
import com.pusher.client.channel.PrivateEncryptedChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.impl.message.AuthResponse;
import com.pusher.client.channel.impl.message.EncryptedReceivedData;
import com.pusher.client.channel.impl.message.SubscribeMessage;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.crypto.nacl.AuthenticityException;
import com.pusher.client.crypto.nacl.SecretBoxOpener;
import com.pusher.client.crypto.nacl.SecretBoxOpenerFactory;
import com.pusher.client.util.Factory;
import com.pusher.client.util.internal.Base64;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class PrivateEncryptedChannelImpl extends ChannelImpl implements PrivateEncryptedChannel {
    private final ChannelAuthorizer channelAuthorizer;
    private final InternalConnection connection;
    private final ConnectionEventListener disposeSecretBoxOpenerOnDisconnectedListener;
    private SecretBoxOpener secretBoxOpener;
    private final SecretBoxOpenerFactory secretBoxOpenerFactory;

    public PrivateEncryptedChannelImpl(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer, Factory factory, SecretBoxOpenerFactory secretBoxOpenerFactory) {
        super(str, factory);
        this.disposeSecretBoxOpenerOnDisconnectedListener = new ConnectionEventListener() { // from class: com.pusher.client.channel.impl.PrivateEncryptedChannelImpl.1
            @Override // com.pusher.client.connection.ConnectionEventListener
            public void onError(String str2, String str3, Exception exc) {
            }

            @Override // com.pusher.client.connection.ConnectionEventListener
            public void onConnectionStateChange(ConnectionStateChange connectionStateChange) {
                PrivateEncryptedChannelImpl.this.disposeSecretBoxOpener();
            }
        };
        this.connection = internalConnection;
        this.channelAuthorizer = channelAuthorizer;
        this.secretBoxOpenerFactory = secretBoxOpenerFactory;
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.Channel
    public void bind(String str, SubscriptionEventListener subscriptionEventListener) {
        if (!(subscriptionEventListener instanceof PrivateEncryptedChannelEventListener)) {
            throw new IllegalArgumentException("Only instances of PrivateEncryptedChannelEventListener can be bound to a private encrypted channel");
        }
        super.bind(str, subscriptionEventListener);
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public String toSubscribeMessage() {
        return this.GSON.toJson(new SubscribeMessage(this.name, authenticate(), null));
    }

    private String authenticate() {
        try {
            AuthResponse authResponse = (AuthResponse) this.GSON.fromJson(getAuthorizationResponse(), AuthResponse.class);
            if (authResponse.getAuth() == null || authResponse.getSharedSecret() == null) {
                throw new AuthorizationFailureException("Didn't receive all the fields expected from the ChannelAuthorizer, expected an auth and shared_secret.");
            }
            createSecretBoxOpener(Base64.decode(authResponse.getSharedSecret()));
            return authResponse.getAuth();
        } catch (JsonSyntaxException unused) {
            throw new AuthorizationFailureException("Unable to parse response from Authorizer");
        }
    }

    private void createSecretBoxOpener(byte[] bArr) {
        this.secretBoxOpener = this.secretBoxOpenerFactory.create(bArr);
        setListenerToDisposeSecretBoxOpenerOnDisconnected();
    }

    private void setListenerToDisposeSecretBoxOpenerOnDisconnected() {
        this.connection.bind(ConnectionState.DISCONNECTED, this.disposeSecretBoxOpenerOnDisconnectedListener);
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public void updateState(ChannelState channelState) {
        super.updateState(channelState);
        if (channelState == ChannelState.UNSUBSCRIBED) {
            disposeSecretBoxOpener();
        }
    }

    @Override // com.pusher.client.channel.impl.BaseChannel, com.pusher.client.channel.impl.InternalChannel
    public void handleEvent(PusherEvent pusherEvent) {
        try {
            super.handleEvent(decryptMessage(pusherEvent));
        } catch (AuthenticityException unused) {
            disposeSecretBoxOpener();
            authenticate();
            try {
                super.handleEvent(decryptMessage(pusherEvent));
            } catch (AuthenticityException unused2) {
                notifyListenersOfDecryptFailure(pusherEvent.getEventName(), "Failed to decrypt message.");
            }
        }
    }

    private void notifyListenersOfDecryptFailure(String str, String str2) {
        Set<SubscriptionEventListener> interestedListeners = getInterestedListeners(str);
        if (interestedListeners != null) {
            Iterator<SubscriptionEventListener> it = interestedListeners.iterator();
            while (it.hasNext()) {
                ((PrivateEncryptedChannelEventListener) it.next()).onDecryptionFailure(str, str2);
            }
        }
    }

    private PusherEvent decryptMessage(PusherEvent pusherEvent) {
        String strOpen = "{}";
        if (!pusherEvent.getData().equals("{}")) {
            EncryptedReceivedData encryptedReceivedData = (EncryptedReceivedData) this.GSON.fromJson(pusherEvent.getData(), EncryptedReceivedData.class);
            strOpen = this.secretBoxOpener.open(encryptedReceivedData.getCiphertext(), encryptedReceivedData.getNonce());
        }
        return new PusherEvent(pusherEvent.getEventName(), pusherEvent.getChannelName(), pusherEvent.getUserId(), strOpen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeSecretBoxOpener() {
        SecretBoxOpener secretBoxOpener = this.secretBoxOpener;
        if (secretBoxOpener != null) {
            secretBoxOpener.clearKey();
            this.secretBoxOpener = null;
            removeListenerToDisposeSecretBoxOpenerOnDisconnected();
        }
    }

    private void removeListenerToDisposeSecretBoxOpenerOnDisconnected() {
        this.connection.unbind(ConnectionState.DISCONNECTED, this.disposeSecretBoxOpenerOnDisconnectedListener);
    }

    private String getAuthorizationResponse() {
        return this.channelAuthorizer.authorize(getName(), this.connection.getSocketId());
    }

    @Override // com.pusher.client.channel.impl.ChannelImpl
    protected String[] getDisallowedNameExpressions() {
        return new String[]{"^(?!private-encrypted-).*"};
    }

    @Override // com.pusher.client.channel.impl.ChannelImpl, com.pusher.client.channel.impl.BaseChannel
    public String toString() {
        return String.format("[Private Encrypted Channel: name=%s]", this.name);
    }
}
