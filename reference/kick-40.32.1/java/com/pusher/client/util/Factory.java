package com.pusher.client.util;

import com.pusher.client.ChannelAuthorizer;
import com.pusher.client.PusherOptions;
import com.pusher.client.UserAuthenticator;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.impl.ChannelImpl;
import com.pusher.client.channel.impl.ChannelManager;
import com.pusher.client.channel.impl.PresenceChannelImpl;
import com.pusher.client.channel.impl.PrivateChannelImpl;
import com.pusher.client.channel.impl.PrivateEncryptedChannelImpl;
import com.pusher.client.connection.impl.InternalConnection;
import com.pusher.client.connection.websocket.WebSocketClientWrapper;
import com.pusher.client.connection.websocket.WebSocketConnection;
import com.pusher.client.connection.websocket.WebSocketListener;
import com.pusher.client.crypto.nacl.SecretBoxOpenerFactory;
import com.pusher.client.user.impl.InternalUser;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes8.dex */
public class Factory {
    private static final Object eventLock = new Object();
    private ChannelManager channelManager;
    private InternalConnection connection;
    private ExecutorService eventQueue;
    private ScheduledExecutorService timers;

    public synchronized InternalConnection getConnection(String str, PusherOptions pusherOptions, Consumer<PusherEvent> consumer) throws Throwable {
        Factory factory;
        try {
            try {
                if (this.connection == null) {
                    try {
                        factory = this;
                        try {
                            factory.connection = new WebSocketConnection(pusherOptions.buildUrl(str), pusherOptions.getActivityTimeout(), pusherOptions.getPongTimeout(), pusherOptions.getMaxReconnectionAttempts(), pusherOptions.getMaxReconnectGapInSeconds(), pusherOptions.getProxy(), consumer, factory);
                        } catch (URISyntaxException e) {
                            e = e;
                            throw new IllegalArgumentException("Failed to initialise connection", e);
                        }
                    } catch (URISyntaxException e2) {
                        e = e2;
                    }
                } else {
                    factory = this;
                }
                InternalConnection internalConnection = factory.connection;
                return internalConnection;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public WebSocketClientWrapper newWebSocketClientWrapper(URI uri, Proxy proxy, WebSocketListener webSocketListener) throws SSLException {
        return new WebSocketClientWrapper(uri, proxy, webSocketListener);
    }

    public synchronized ScheduledExecutorService getTimers() {
        if (this.timers == null) {
            this.timers = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory("timers"));
        }
        return this.timers;
    }

    public ChannelImpl newPublicChannel(String str) {
        return new ChannelImpl(str, this);
    }

    public PrivateChannelImpl newPrivateChannel(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer) {
        return new PrivateChannelImpl(internalConnection, str, channelAuthorizer, this);
    }

    public PrivateEncryptedChannelImpl newPrivateEncryptedChannel(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer) {
        return new PrivateEncryptedChannelImpl(internalConnection, str, channelAuthorizer, this, new SecretBoxOpenerFactory());
    }

    public PresenceChannelImpl newPresenceChannel(InternalConnection internalConnection, String str, ChannelAuthorizer channelAuthorizer) {
        return new PresenceChannelImpl(internalConnection, str, channelAuthorizer, this);
    }

    public InternalUser newUser(InternalConnection internalConnection, UserAuthenticator userAuthenticator) {
        return new InternalUser(internalConnection, userAuthenticator, this);
    }

    public synchronized ChannelManager getChannelManager() {
        if (this.channelManager == null) {
            this.channelManager = new ChannelManager(this);
        }
        return this.channelManager;
    }

    public synchronized void queueOnEventThread(final Runnable runnable) {
        if (this.eventQueue == null) {
            this.eventQueue = Executors.newSingleThreadExecutor(new DaemonThreadFactory("eventQueue"));
        }
        this.eventQueue.execute(new Runnable() { // from class: com.pusher.client.util.Factory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Factory.lambda$queueOnEventThread$0(runnable);
            }
        });
    }

    static /* synthetic */ void lambda$queueOnEventThread$0(Runnable runnable) {
        synchronized (eventLock) {
            runnable.run();
        }
    }

    public synchronized void shutdownThreads() {
        ExecutorService executorService = this.eventQueue;
        if (executorService != null) {
            executorService.shutdown();
            this.eventQueue = null;
        }
        ScheduledExecutorService scheduledExecutorService = this.timers;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.timers = null;
        }
    }

    private static class DaemonThreadFactory implements ThreadFactory {
        private final String name;

        public DaemonThreadFactory(String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("pusher-java-client " + this.name);
            return thread;
        }
    }
}
