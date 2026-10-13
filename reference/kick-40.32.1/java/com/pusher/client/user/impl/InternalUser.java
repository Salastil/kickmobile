package com.pusher.client.user.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pusher.client.AuthenticationFailureException;
import com.pusher.client.UserAuthenticator;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.impl.ChannelManager;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.user.User;
import com.pusher.client.user.impl.message.AuthenticationResponse;
import com.pusher.client.user.impl.message.SigninMessage;
import com.pusher.client.util.Factory;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes8.dex */
public class InternalUser implements User {
    private static final Gson GSON = new Gson();
    private static final Logger log = Logger.getLogger(User.class.getName());
    private final ChannelManager channelManager;
    private final InternalConnection connection;
    private final ServerToUserChannel serverToUserChannel;
    private boolean signinRequested = false;
    private final UserAuthenticator userAuthenticator;
    private String userId;

    private static class ConnectionStateChangeHandler implements ConnectionEventListener {
        private final InternalUser user;

        public ConnectionStateChangeHandler(InternalUser internalUser) {
            this.user = internalUser;
        }

        @Override // com.pusher.client.connection.ConnectionEventListener
        public void onConnectionStateChange(ConnectionStateChange connectionStateChange) {
            int i = AnonymousClass1.$SwitchMap$com$pusher$client$connection$ConnectionState[connectionStateChange.getCurrentState().ordinal()];
            if (i == 1) {
                this.user.attemptSignin();
            } else if (i == 2 || i == 3) {
                this.user.disconnect();
            }
        }

        @Override // com.pusher.client.connection.ConnectionEventListener
        public void onError(String str, String str2, Exception exc) {
            InternalUser.log.warning(str);
        }
    }

    /* JADX INFO: renamed from: com.pusher.client.user.impl.InternalUser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pusher$client$connection$ConnectionState;

        static {
            int[] iArr = new int[ConnectionState.values().length];
            $SwitchMap$com$pusher$client$connection$ConnectionState = iArr;
            try {
                iArr[ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pusher$client$connection$ConnectionState[ConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pusher$client$connection$ConnectionState[ConnectionState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public InternalUser(InternalConnection internalConnection, UserAuthenticator userAuthenticator, Factory factory) {
        this.connection = internalConnection;
        this.userAuthenticator = userAuthenticator;
        this.channelManager = factory.getChannelManager();
        this.serverToUserChannel = new ServerToUserChannel(this, factory);
        internalConnection.bind(ConnectionState.ALL, new ConnectionStateChangeHandler(this));
    }

    public void signin() throws AuthenticationFailureException {
        if (this.signinRequested || this.userId != null) {
            return;
        }
        this.signinRequested = true;
        attemptSignin();
    }

    public void handleEvent(PusherEvent pusherEvent) {
        if (pusherEvent.getEventName().equals("pusher:signin_success")) {
            onSigninSuccess(pusherEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptSignin() throws AuthenticationFailureException {
        if (this.signinRequested && this.userId == null && this.connection.getState() == ConnectionState.CONNECTED) {
            this.connection.sendMessage(authenticationResponseToSigninMessage(getAuthenticationResponse()));
        }
    }

    private static String authenticationResponseToSigninMessage(AuthenticationResponse authenticationResponse) {
        return GSON.toJson(new SigninMessage(authenticationResponse.getAuth(), authenticationResponse.getUserData()));
    }

    private AuthenticationResponse getAuthenticationResponse() throws AuthenticationFailureException {
        try {
            AuthenticationResponse authenticationResponse = (AuthenticationResponse) GSON.fromJson(this.userAuthenticator.authenticate(this.connection.getSocketId()), AuthenticationResponse.class);
            if (authenticationResponse.getAuth() == null || authenticationResponse.getUserData() == null) {
                throw new AuthenticationFailureException("Didn't receive all the fields expected from the UserAuthenticator. Expected auth and user_data");
            }
            return authenticationResponse;
        } catch (JsonSyntaxException unused) {
            throw new AuthenticationFailureException("Unable to parse response from AuthenticationResponse");
        }
    }

    private void onSigninSuccess(PusherEvent pusherEvent) {
        try {
            Gson gson = GSON;
            String str = (String) ((Map) gson.fromJson((String) ((Map) gson.fromJson(pusherEvent.getData(), Map.class)).get("user_data"), Map.class)).get("id");
            this.userId = str;
            if (str == null) {
                log.severe("User data doesn't contain an id");
            } else {
                this.channelManager.subscribeTo(this.serverToUserChannel, null, new String[0]);
            }
        } catch (Exception unused) {
            log.severe("Failed parsing user data after signin");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        if (this.serverToUserChannel.isSubscribed()) {
            this.channelManager.unsubscribeFrom(this.serverToUserChannel.getName());
        }
        this.userId = null;
    }

    @Override // com.pusher.client.user.User
    public String userId() {
        return this.userId;
    }

    @Override // com.pusher.client.user.User
    public void bind(String str, SubscriptionEventListener subscriptionEventListener) {
        this.serverToUserChannel.bind(str, subscriptionEventListener);
    }

    @Override // com.pusher.client.user.User
    public void bindGlobal(SubscriptionEventListener subscriptionEventListener) {
        this.serverToUserChannel.bindGlobal(subscriptionEventListener);
    }

    @Override // com.pusher.client.user.User
    public void unbind(String str, SubscriptionEventListener subscriptionEventListener) {
        this.serverToUserChannel.unbind(str, subscriptionEventListener);
    }

    @Override // com.pusher.client.user.User
    public void unbindGlobal(SubscriptionEventListener subscriptionEventListener) {
        this.serverToUserChannel.unbindGlobal(subscriptionEventListener);
    }
}
