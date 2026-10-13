package com.pusher.client.connection.websocket;

import com.google.gson.Gson;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.util.Factory;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import org.java_websocket.handshake.ServerHandshake;

/* JADX INFO: loaded from: classes8.dex */
public class WebSocketConnection implements InternalConnection, WebSocketListener {
    private static final String PING_EVENT_SERIALIZED = "{\"event\": \"pusher:ping\"}";
    private final ActivityTimer activityTimer;
    private final Consumer<PusherEvent> eventHandler;
    private final Factory factory;
    private final int maxReconnectionAttempts;
    private final int maxReconnectionGap;
    private final Proxy proxy;
    private String socketId;
    private WebSocketClientWrapper underlyingConnection;
    private final URI webSocketUri;
    private static final Logger log = Logger.getLogger(WebSocketConnection.class.getName());
    private static final Gson GSON = new Gson();
    private final Map<ConnectionState, Set<ConnectionEventListener>> eventListeners = new ConcurrentHashMap();
    private volatile ConnectionState state = ConnectionState.DISCONNECTED;
    private int reconnectAttempts = 0;

    private boolean shouldReconnect(int i) {
        return i < 4000 || i >= 4100;
    }

    @Override // com.pusher.client.connection.websocket.WebSocketListener
    public void onOpen(ServerHandshake serverHandshake) {
    }

    public WebSocketConnection(String str, long j, long j2, int i, int i2, Proxy proxy, Consumer<PusherEvent> consumer, Factory factory) throws URISyntaxException {
        this.webSocketUri = new URI(str);
        this.activityTimer = new ActivityTimer(j, j2);
        this.maxReconnectionAttempts = i;
        this.maxReconnectionGap = i2;
        this.proxy = proxy;
        this.factory = factory;
        this.eventHandler = consumer;
        for (ConnectionState connectionState : ConnectionState.values()) {
            this.eventListeners.put(connectionState, Collections.newSetFromMap(new ConcurrentHashMap()));
        }
    }

    @Override // com.pusher.client.connection.Connection
    public void connect() {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11732x94364e83();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$connect$0$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11732x94364e83() {
        if (canConnect()) {
            tryConnecting();
        }
    }

    private void tryConnecting() {
        try {
            this.underlyingConnection = this.factory.newWebSocketClientWrapper(this.webSocketUri, this.proxy, this);
            updateState(ConnectionState.CONNECTING);
            this.underlyingConnection.connect();
        } catch (SSLException e) {
            sendErrorToAllListeners("Error connecting over SSL", null, e);
        }
    }

    @Override // com.pusher.client.connection.impl.InternalConnection
    public void disconnect() {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11733x3ff1b4d6();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$disconnect$1$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11733x3ff1b4d6() {
        if (canDisconnect()) {
            updateState(ConnectionState.DISCONNECTING);
            this.underlyingConnection.close();
        }
    }

    @Override // com.pusher.client.connection.Connection
    public void bind(ConnectionState connectionState, ConnectionEventListener connectionEventListener) {
        this.eventListeners.get(connectionState).add(connectionEventListener);
    }

    @Override // com.pusher.client.connection.Connection
    public boolean unbind(ConnectionState connectionState, ConnectionEventListener connectionEventListener) {
        return this.eventListeners.get(connectionState).remove(connectionEventListener);
    }

    @Override // com.pusher.client.connection.Connection
    public ConnectionState getState() {
        return this.state;
    }

    @Override // com.pusher.client.connection.impl.InternalConnection
    public void sendMessage(final String str) {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11736xdb96bc6c(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendMessage$2$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11736xdb96bc6c(String str) {
        try {
            if (this.state == ConnectionState.CONNECTED) {
                this.underlyingConnection.send(str);
                return;
            }
            sendErrorToAllListeners("Cannot send a message while in " + this.state + " state", null, null);
        } catch (Exception e) {
            sendErrorToAllListeners("An exception occurred while sending message [" + str + "]", null, e);
        }
    }

    @Override // com.pusher.client.connection.Connection
    public String getSocketId() {
        return this.socketId;
    }

    private void updateState(ConnectionState connectionState) {
        log.fine("State transition requested, current [" + this.state + "], new [" + connectionState + "]");
        final ConnectionStateChange connectionStateChange = new ConnectionStateChange(this.state, connectionState);
        this.state = connectionState;
        HashSet<ConnectionEventListener> hashSet = new HashSet();
        hashSet.addAll(this.eventListeners.get(ConnectionState.ALL));
        hashSet.addAll(this.eventListeners.get(connectionState));
        for (final ConnectionEventListener connectionEventListener : hashSet) {
            this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    connectionEventListener.onConnectionStateChange(connectionStateChange);
                }
            });
        }
    }

    private void handleEvent(PusherEvent pusherEvent) {
        if (pusherEvent.getEventName().equals("pusher:connection_established")) {
            handleConnectihandleEvent(pusherEvent);
        } else if (pusherEvent.getEventName().equals("pusher:error")) {
            handleError(pusherEvent);
        }
        this.eventHandler.accept(pusherEvent);
    }

    private void handleConnectihandleEvent(PusherEvent pusherEvent) {
        this.socketId = (String) ((Map) GSON.fromJson(pusherEvent.getData(), Map.class)).get("socket_id");
        if (this.state != ConnectionState.CONNECTED) {
            updateState(ConnectionState.CONNECTED);
        }
        this.reconnectAttempts = 0;
    }

    private void handleError(PusherEvent pusherEvent) {
        Map map = (Map) GSON.fromJson(pusherEvent.getData(), Map.class);
        String str = (String) map.get("message");
        Object obj = map.get("code");
        sendErrorToAllListeners(str, obj != null ? String.valueOf(Math.round(((Double) obj).doubleValue())) : null, null);
    }

    private void sendErrorToAllListeners(final String str, final String str2, final Exception exc) {
        HashSet<ConnectionEventListener> hashSet = new HashSet();
        Iterator<Set<ConnectionEventListener>> it = this.eventListeners.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next());
        }
        for (final ConnectionEventListener connectionEventListener : hashSet) {
            this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    connectionEventListener.onError(str, str2, exc);
                }
            });
        }
    }

    @Override // com.pusher.client.connection.websocket.WebSocketListener
    public void onMessage(final String str) {
        this.activityTimer.activity();
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11735xa93e0ca0(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onMessage$5$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11735xa93e0ca0(String str) {
        handleEvent(PusherEvent.fromJson(str));
    }

    @Override // com.pusher.client.connection.websocket.WebSocketListener
    public void onClose(int i, String str, boolean z) {
        if (this.state == ConnectionState.DISCONNECTED || this.state == ConnectionState.RECONNECTING) {
            log.warning("Received close from underlying socket when already disconnected.Close code [" + i + "], Reason [" + str + "], Remote [" + z + "]");
            return;
        }
        if (!shouldReconnect(i)) {
            updateState(ConnectionState.DISCONNECTING);
        }
        if (this.state == ConnectionState.CONNECTED || this.state == ConnectionState.CONNECTING) {
            if (this.reconnectAttempts < this.maxReconnectionAttempts) {
                tryReconnecting();
                return;
            } else {
                updateState(ConnectionState.DISCONNECTING);
                cancelTimeoutsAndTransitionToDisconnected();
                return;
            }
        }
        if (this.state == ConnectionState.DISCONNECTING) {
            cancelTimeoutsAndTransitionToDisconnected();
        }
    }

    private void tryReconnecting() {
        this.reconnectAttempts++;
        updateState(ConnectionState.RECONNECTING);
        int i = this.maxReconnectionGap;
        int i2 = this.reconnectAttempts;
        this.factory.getTimers().schedule(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11737x74b7a5a1();
            }
        }, Math.min(i, i2 * i2), TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: lambda$tryReconnecting$6$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11737x74b7a5a1() {
        if (this.state == ConnectionState.RECONNECTING) {
            this.underlyingConnection.removeWebSocketListener();
            tryConnecting();
        }
    }

    private void cancelTimeoutsAndTransitionToDisconnected() {
        this.activityTimer.cancelTimeouts();
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11731xe533cb0();
            }
        });
        this.reconnectAttempts = 0;
    }

    /* JADX INFO: renamed from: lambda$cancelTimeoutsAndTransitionToDisconnected$7$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11731xe533cb0() {
        if (this.state == ConnectionState.DISCONNECTING) {
            updateState(ConnectionState.DISCONNECTED);
            this.factory.shutdownThreads();
        }
    }

    @Override // com.pusher.client.connection.websocket.WebSocketListener
    public void onError(final Exception exc) {
        this.factory.queueOnEventThread(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11734x20469b5c(exc);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onError$8$com-pusher-client-connection-websocket-WebSocketConnection, reason: not valid java name */
    /* synthetic */ void m11734x20469b5c(Exception exc) {
        sendErrorToAllListeners("An exception was thrown by the websocket", null, exc);
    }

    private boolean canConnect() {
        return this.state == ConnectionState.DISCONNECTING || this.state == ConnectionState.DISCONNECTED;
    }

    private boolean canDisconnect() {
        return (this.state == ConnectionState.DISCONNECTING || this.state == ConnectionState.DISCONNECTED) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ActivityTimer {
        private final long activityTimeout;
        private Future<?> pingTimer;
        private final long pongTimeout;
        private Future<?> pongTimer;

        ActivityTimer(long j, long j2) {
            this.activityTimeout = j;
            this.pongTimeout = j2;
        }

        synchronized void activity() {
            Future<?> future = this.pongTimer;
            if (future != null) {
                future.cancel(true);
            }
            Future<?> future2 = this.pingTimer;
            if (future2 != null) {
                future2.cancel(false);
            }
            this.pingTimer = WebSocketConnection.this.factory.getTimers().schedule(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$ActivityTimer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11738x20c3b156();
                }
            }, this.activityTimeout, TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: lambda$activity$0$com-pusher-client-connection-websocket-WebSocketConnection$ActivityTimer, reason: not valid java name */
        /* synthetic */ void m11738x20c3b156() {
            WebSocketConnection.log.fine("Sending ping");
            WebSocketConnection.this.sendMessage(WebSocketConnection.PING_EVENT_SERIALIZED);
            schedulePongCheck();
        }

        synchronized void cancelTimeouts() {
            Future<?> future = this.pingTimer;
            if (future != null) {
                future.cancel(false);
            }
            Future<?> future2 = this.pongTimer;
            if (future2 != null) {
                future2.cancel(false);
            }
        }

        private synchronized void schedulePongCheck() {
            Future<?> future = this.pongTimer;
            if (future != null) {
                future.cancel(false);
            }
            this.pongTimer = WebSocketConnection.this.factory.getTimers().schedule(new Runnable() { // from class: com.pusher.client.connection.websocket.WebSocketConnection$ActivityTimer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11739x3c2f3c45();
                }
            }, this.pongTimeout, TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: lambda$schedulePongCheck$1$com-pusher-client-connection-websocket-WebSocketConnection$ActivityTimer, reason: not valid java name */
        /* synthetic */ void m11739x3c2f3c45() {
            WebSocketConnection.log.fine("Timed out awaiting pong from server - disconnecting");
            WebSocketConnection.this.underlyingConnection.removeWebSocketListener();
            WebSocketConnection.this.underlyingConnection.close();
            WebSocketConnection.this.onClose(-1, "Pong timeout", false);
        }
    }
}
