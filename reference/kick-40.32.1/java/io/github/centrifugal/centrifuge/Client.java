package io.github.centrifugal.centrifuge;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.protobuf.ByteString;
import io.github.centrifugal.centrifuge.internal.backoff.Backoff;
import io.github.centrifugal.centrifuge.internal.protocol.Protocol;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java8.util.concurrent.CompletableFuture;
import java8.util.function.Consumer;
import java8.util.function.Function;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: loaded from: classes9.dex */
public class Client {
    static final int CONNECTING_CONNECT_CALLED = 0;
    static final int CONNECTING_NO_PING = 2;
    static final int CONNECTING_SUBSCRIBE_TIMEOUT = 3;
    static final int CONNECTING_TRANSPORT_CLOSED = 1;
    static final int CONNECTING_UNSUBSCRIBE_ERROR = 4;
    static final int DISCONNECTED_BAD_PROTOCOL = 2;
    static final int DISCONNECTED_DISCONNECT_CALLED = 0;
    static final int DISCONNECTED_MESSAGE_SIZE_LIMIT = 3;
    static final int DISCONNECTED_STATE_INVALIDATED = 3014;
    static final int DISCONNECTED_UNAUTHORIZED = 1;
    static final int ERROR_CODE_UNRECOVERABLE_POSITION = 112;
    private static final int MESSAGE_SIZE_LIMIT_EXCEEDED_STATUS = 1009;
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    static final int SUBSCRIBING_SUBSCRIBE_CALLED = 0;
    static final int SUBSCRIBING_TRANSPORT_CLOSED = 1;
    static final long SUBSCRIPTION_FLAG_CHANNEL_COMPACTION = 1;
    static final long SUBSCRIPTION_FLAG_REJECT_UNRECOVERED = 2;
    static final int UNSUBSCRIBED_CLIENT_CLOSED = 2;
    static final int UNSUBSCRIBED_STATE_INVALIDATED = 2502;
    static final int UNSUBSCRIBED_UNAUTHORIZED = 1;
    static final int UNSUBSCRIBED_UNSUBSCRIBE_CALLED = 0;
    private ByteString data;
    private final String endpoint;
    private OkHttpClient httpClient;
    private boolean httpClientOwned;
    private final EventListener listener;
    private final Options opts;
    private int pingInterval;
    private ScheduledFuture<?> pingTask;
    private ScheduledFuture<?> reconnectTask;
    private ScheduledFuture<?> refreshTask;
    private boolean sendPong;
    private String token;
    private WebSocket ws;
    private final Map<Integer, CompletableFuture<Protocol.Reply>> futures = new ConcurrentHashMap();
    private final Map<Integer, Protocol.Command> connectCommands = new ConcurrentHashMap();
    private final Map<Integer, Protocol.Command> connectAsyncCommands = new ConcurrentHashMap();
    private volatile ClientState state = ClientState.DISCONNECTED;
    private final Map<String, Subscription> subs = new ConcurrentHashMap();
    private final Map<Long, Subscription> subsById = new ConcurrentHashMap();
    private final Map<String, ServerSubscription> serverSubs = new ConcurrentHashMap();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int reconnectAttempts = 0;
    private boolean refreshRequired = false;
    private int _id = 0;
    private final Backoff backoff = new Backoff();

    Options getOpts() {
        return this.opts;
    }

    ExecutorService getExecutor() {
        return this.executor;
    }

    ScheduledExecutorService getScheduler() {
        return this.scheduler;
    }

    public Client(String str, Options options, EventListener eventListener) {
        this.endpoint = str;
        this.opts = options;
        this.listener = eventListener;
        this.token = options.getToken();
        if (options.getData() != null) {
            this.data = ByteString.copyFrom(options.getData());
        }
    }

    void setState(ClientState clientState) {
        this.state = clientState;
    }

    public ClientState getState() {
        return this.state;
    }

    private int getNextId() {
        int i = this._id + 1;
        this._id = i;
        return i;
    }

    public void connect() {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12163lambda$connect$0$iogithubcentrifugalcentrifugeClient();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$connect$0$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12163lambda$connect$0$iogithubcentrifugalcentrifugeClient() {
        if (getState() == ClientState.CONNECTED || getState() == ClientState.CONNECTING) {
            return;
        }
        this.reconnectAttempts = 0;
        setState(ClientState.CONNECTING);
        this.listener.onConnecting(this, new ConnectingEvent(0, "connect called"));
        _connect();
    }

    public void disconnect() {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12164lambda$disconnect$1$iogithubcentrifugalcentrifugeClient();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$disconnect$1$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12164lambda$disconnect$1$iogithubcentrifugalcentrifugeClient() {
        processDisconnect(0, "disconnect called", false);
    }

    public void setToken(final String str) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12206lambda$setToken$2$iogithubcentrifugalcentrifugeClient(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setToken$2$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12206lambda$setToken$2$iogithubcentrifugalcentrifugeClient(String str) {
        this.token = str;
    }

    public boolean close(long j) throws InterruptedException {
        try {
            this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m12162lambda$close$3$iogithubcentrifugalcentrifugeClient();
                }
            });
        } catch (RejectedExecutionException unused) {
        }
        if (j > 0) {
            return this.executor.awaitTermination(j, TimeUnit.MILLISECONDS);
        }
        return false;
    }

    /* JADX INFO: renamed from: lambda$close$3$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12162lambda$close$3$iogithubcentrifugalcentrifugeClient() {
        processDisconnect(0, "client closed", false);
        setState(ClientState.CLOSED);
        WebSocket webSocket = this.ws;
        if (webSocket != null) {
            webSocket.cancel();
        }
        OkHttpClient okHttpClient = this.httpClient;
        if (okHttpClient != null && this.httpClientOwned) {
            okHttpClient.dispatcher().executorService().shutdown();
            this.httpClient.connectionPool().evictAll();
        }
        this.scheduler.shutdownNow();
        this.executor.shutdown();
    }

    void processDisconnect(int i, String str, Boolean bool) {
        boolean z;
        if (getState() == ClientState.DISCONNECTED || getState() == ClientState.CLOSED) {
            return;
        }
        if (i == DISCONNECTED_STATE_INVALIDATED) {
            this.token = "";
            this.refreshRequired = true;
            Iterator<Subscription> it = this.subs.values().iterator();
            while (it.hasNext()) {
                it.next().invalidateState();
            }
        }
        ClientState state = getState();
        ScheduledFuture<?> scheduledFuture = this.pingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.pingTask = null;
        }
        ScheduledFuture<?> scheduledFuture2 = this.refreshTask;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
            this.refreshTask = null;
        }
        ScheduledFuture<?> scheduledFuture3 = this.reconnectTask;
        if (scheduledFuture3 != null) {
            scheduledFuture3.cancel(true);
            this.reconnectTask = null;
        }
        if (bool.booleanValue()) {
            z = state != ClientState.CONNECTING;
            setState(ClientState.CONNECTING);
        } else {
            z = state != ClientState.DISCONNECTED;
            setState(ClientState.DISCONNECTED);
        }
        this.subsById.clear();
        synchronized (this.subs) {
            Iterator<Map.Entry<String, Subscription>> it2 = this.subs.entrySet().iterator();
            while (it2.hasNext()) {
                Subscription value = it2.next().getValue();
                if (value.getState() != SubscriptionState.UNSUBSCRIBED) {
                    value.moveToSubscribing(1, "transport closed");
                }
            }
        }
        Iterator<Map.Entry<Integer, CompletableFuture<Protocol.Reply>>> it3 = this.futures.entrySet().iterator();
        while (it3.hasNext()) {
            it3.next().getValue().completeExceptionally(new IOException());
        }
        if (state == ClientState.CONNECTED) {
            Iterator<Map.Entry<String, ServerSubscription>> it4 = this.serverSubs.entrySet().iterator();
            while (it4.hasNext()) {
                this.listener.onSubscribing(this, new ServerSubscribingEvent(it4.next().getKey()));
            }
        }
        if (z) {
            if (bool.booleanValue()) {
                this.listener.onConnecting(this, new ConnectingEvent(i, str));
            } else {
                this.listener.onDisconnected(this, new DisconnectedEvent(i, str));
            }
        }
        this.ws.close(1000, null);
    }

    private void _connect() {
        OkHttpClient.Builder builder;
        Headers.Builder builder2 = new Headers.Builder();
        if (this.opts.getHeaders() != null) {
            for (Map.Entry<String, String> entry : this.opts.getHeaders().entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
        }
        Request requestBuild = new Request.Builder().url(this.endpoint).headers(builder2.build()).addHeader("Sec-WebSocket-Protocol", "centrifuge-protobuf").build();
        WebSocket webSocket = this.ws;
        if (webSocket != null) {
            webSocket.cancel();
        }
        OkHttpClient okHttpClient = this.httpClient;
        if (okHttpClient == null || !this.httpClientOwned) {
            okHttpClient = null;
        }
        OkHttpClient okHttpClient2 = this.opts.getOkHttpClient();
        if (okHttpClient2 != null) {
            builder = okHttpClient2.newBuilder();
        } else {
            builder = new OkHttpClient.Builder();
        }
        final Dns dns = this.opts.getDns();
        if (dns != null) {
            Objects.requireNonNull(dns);
            builder.dns(new okhttp3.Dns() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda37
                @Override // okhttp3.Dns
                public final List lookup(String str) {
                    return dns.resolve(str);
                }
            });
        }
        SSLSocketFactory sSLSocketFactory = this.opts.getSSLSocketFactory();
        if (sSLSocketFactory != null) {
            X509TrustManager trustManager = this.opts.getTrustManager();
            if (trustManager != null) {
                builder.sslSocketFactory(sSLSocketFactory, trustManager);
            } else {
                builder.setSslSocketFactoryOrNull$okhttp(sSLSocketFactory);
            }
        }
        if (this.opts.getProxy() != null) {
            builder.proxy(this.opts.getProxy());
            if (this.opts.getProxyLogin() != null && this.opts.getProxyPassword() != null) {
                builder.proxyAuthenticator(new Authenticator() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda38
                    @Override // okhttp3.Authenticator
                    public final Request authenticate(Route route, Response response) {
                        return this.f$0.m12161lambda$_connect$4$iogithubcentrifugalcentrifugeClient(route, response);
                    }
                });
            }
        }
        OkHttpClient okHttpClientBuild = builder.build();
        this.httpClient = okHttpClientBuild;
        this.httpClientOwned = okHttpClient2 == null;
        this.ws = okHttpClientBuild.newWebSocket(requestBuild, new AnonymousClass1());
        if (okHttpClient != null) {
            okHttpClient.dispatcher().executorService().shutdown();
            okHttpClient.connectionPool().evictAll();
        }
    }

    /* JADX INFO: renamed from: lambda$_connect$4$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Request m12161lambda$_connect$4$iogithubcentrifugalcentrifugeClient(Route route, Response response) throws IOException {
        return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic(this.opts.getProxyLogin(), this.opts.getProxyPassword())).build();
    }

    /* JADX INFO: renamed from: io.github.centrifugal.centrifuge.Client$1, reason: invalid class name */
    class AnonymousClass1 extends WebSocketListener {
        AnonymousClass1() {
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            try {
                Client.this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m12214lambda$onOpen$0$iogithubcentrifugalcentrifugeClient$1();
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX INFO: renamed from: lambda$onOpen$0$io-github-centrifugal-centrifuge-Client$1, reason: not valid java name */
        /* synthetic */ void m12214lambda$onOpen$0$iogithubcentrifugalcentrifugeClient$1() {
            try {
                Client.this.handleConnectionOpen();
            } catch (Throwable th) {
                th.printStackTrace();
                Client.this.listener.onError(Client.this, new ErrorEvent(new UnclassifiedError(th)));
                Client.this.processDisconnect(2, "bad protocol (open)", false);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, final okio.ByteString byteString) {
            super.onMessage(webSocket, byteString);
            try {
                Client.this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m12213lambda$onMessage$1$iogithubcentrifugalcentrifugeClient$1(byteString);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX INFO: renamed from: lambda$onMessage$1$io-github-centrifugal-centrifuge-Client$1, reason: not valid java name */
        /* synthetic */ void m12213lambda$onMessage$1$iogithubcentrifugalcentrifugeClient$1(okio.ByteString byteString) {
            if (Client.this.getState() == ClientState.CONNECTING || Client.this.getState() == ClientState.CONNECTED) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteString.toByteArray());
                while (byteArrayInputStream.available() > 0) {
                    try {
                        try {
                            Client.this.processReply(Protocol.Reply.parseDelimitedFrom(byteArrayInputStream));
                        } catch (Throwable th) {
                            th.printStackTrace();
                            Client.this.listener.onError(Client.this, new ErrorEvent(new UnclassifiedError(th)));
                            Client.this.processDisconnect(2, "bad protocol (message)", false);
                            return;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        Client.this.listener.onError(Client.this, new ErrorEvent(new UnclassifiedError(e)));
                        Client.this.processDisconnect(2, "bad protocol (proto)", false);
                        return;
                    }
                }
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i, String str) {
            super.onClosing(webSocket, i, str);
            webSocket.close(1000, null);
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, final int i, final String str) {
            super.onClosed(webSocket, i, str);
            try {
                Client.this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m12211lambda$onClosed$2$iogithubcentrifugalcentrifugeClient$1(i, str);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX INFO: renamed from: lambda$onClosed$2$io-github-centrifugal-centrifuge-Client$1, reason: not valid java name */
        /* synthetic */ void m12211lambda$onClosed$2$iogithubcentrifugalcentrifugeClient$1(int i, String str) {
            boolean z = false;
            boolean z2 = i < 3500 || i >= 5000 || (i >= 4000 && i < 4500);
            if (i >= 3000) {
                z = z2;
            } else if (i == 1009) {
                i = 3;
                str = "message size limit exceeded";
            } else {
                str = "transport closed";
                z = z2;
                i = 1;
            }
            if (Client.this.getState() != ClientState.DISCONNECTED) {
                Client.this.processDisconnect(i, str, Boolean.valueOf(z));
            }
            if (Client.this.getState() == ClientState.CONNECTING) {
                Client.this.scheduleReconnect();
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, final Throwable th, final Response response) {
            super.onFailure(webSocket, th, response);
            try {
                Client.this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m12212lambda$onFailure$3$iogithubcentrifugalcentrifugeClient$1(response, th);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX INFO: renamed from: lambda$onFailure$3$io-github-centrifugal-centrifuge-Client$1, reason: not valid java name */
        /* synthetic */ void m12212lambda$onFailure$3$iogithubcentrifugalcentrifugeClient$1(Response response, Throwable th) {
            Client.this.listener.onError(Client.this, new ErrorEvent(th, response != null ? Integer.valueOf(response.code()) : null));
            Client.this.processDisconnect(1, "transport closed", true);
            if (Client.this.getState() == ClientState.CONNECTING) {
                Client.this.scheduleReconnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionOpen() {
        if (getState() != ClientState.CONNECTING) {
            return;
        }
        if (this.refreshRequired || (this.token.equals("") && this.opts.getTokenGetter() != null)) {
            ConnectionTokenEvent connectionTokenEvent = new ConnectionTokenEvent();
            if (this.opts.getTokenGetter() == null) {
                this.listener.onError(this, new ErrorEvent(new ConfigurationError(new Exception("tokenGetter function should be provided in Client options to handle token refresh, see Options.setTokenGetter"))));
                processDisconnect(1, "unauthorized", false);
                return;
            } else {
                final WebSocket webSocket = this.ws;
                this.opts.getTokenGetter().getConnectionToken(connectionTokenEvent, new TokenCallback() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda46
                    @Override // io.github.centrifugal.centrifuge.TokenCallback
                    public final void Done(Throwable th, String str) {
                        this.f$0.m12166x84e418fb(webSocket, th, str);
                    }
                });
                return;
            }
        }
        sendConnect();
    }

    /* JADX INFO: renamed from: lambda$handleConnectionOpen$6$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12166x84e418fb(final WebSocket webSocket, final Throwable th, final String str) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12165xf843edfa(webSocket, th, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleConnectionOpen$5$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12165xf843edfa(WebSocket webSocket, Throwable th, String str) {
        if (this.ws == webSocket && getState() == ClientState.CONNECTING) {
            if (th != null) {
                if (th instanceof UnauthorizedException) {
                    failUnauthorized();
                    return;
                } else {
                    this.listener.onError(this, new ErrorEvent(new TokenError(th)));
                    this.ws.close(1000, "");
                    return;
                }
            }
            if (str == null) {
                processDisconnect(2, "bad protocol (token)", false);
                return;
            }
            this.token = str;
            this.refreshRequired = false;
            sendConnect();
        }
    }

    private void handleConnectionError(Throwable th) {
        this.listener.onError(this, new ErrorEvent(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReconnecting() {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12207x82fa87ff();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startReconnecting$7$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12207x82fa87ff() {
        if (getState() != ClientState.CONNECTING) {
            return;
        }
        _connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleReconnect() {
        if (getState() != ClientState.CONNECTING) {
            return;
        }
        this.reconnectTask = this.scheduler.schedule(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startReconnecting();
            }
        }, this.backoff.duration(this.reconnectAttempts, this.opts.getMinReconnectDelay(), this.opts.getMaxReconnectDelay()), TimeUnit.MILLISECONDS);
        this.reconnectAttempts++;
    }

    private void sendSubscribeSynchronized(final String str, Protocol.SubscribeRequest subscribeRequest) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setSubscribe(subscribeRequest).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        this.futures.put(Integer.valueOf(commandBuild.getId()), completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda20
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12198x11fa7ae9(str, commandBuild, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda21
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12197xb5b929c6(commandBuild, (Throwable) obj);
            }
        });
        this.ws.send(okio.ByteString.of(serializeCommand(commandBuild)));
    }

    /* JADX INFO: renamed from: lambda$sendSubscribeSynchronized$8$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12198x11fa7ae9(String str, Protocol.Command command, Protocol.Reply reply) {
        if (getState() != ClientState.CONNECTED) {
            return;
        }
        try {
            handleSubscribeReply(str, reply);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.futures.remove(Integer.valueOf(command.getId()));
    }

    /* JADX INFO: renamed from: lambda$sendSubscribeSynchronized$10$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12197xb5b929c6(final Protocol.Command command, Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12199x9e9aa5ea(command);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$sendSubscribeSynchronized$9$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12199x9e9aa5ea(Protocol.Command command) {
        if (getState() != ClientState.CONNECTED) {
            return;
        }
        this.futures.remove(Integer.valueOf(command.getId()));
        processDisconnect(3, "subscribe timeout", true);
    }

    void sendSubscribe(Subscription subscription, Protocol.SubscribeRequest subscribeRequest) {
        if (getState() != ClientState.CONNECTED) {
            return;
        }
        sendSubscribeSynchronized(subscription.getChannel(), subscribeRequest);
    }

    void sendUnsubscribe(final String str) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12203x2da455d4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendUnsubscribeSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12203x2da455d4(String str) {
        if (getState() != ClientState.CONNECTED) {
            return;
        }
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setUnsubscribe(Protocol.UnsubscribeRequest.newBuilder().setChannel(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        this.futures.put(Integer.valueOf(commandBuild.getId()), completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda12
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12204x4e74121(commandBuild, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda13
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12205x91876c22(commandBuild, (Throwable) obj);
            }
        });
        this.ws.send(okio.ByteString.of(serializeCommand(commandBuild)));
    }

    /* JADX INFO: renamed from: lambda$sendUnsubscribeSynchronized$12$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12204x4e74121(Protocol.Command command, Protocol.Reply reply) {
        this.futures.remove(Integer.valueOf(command.getId()));
    }

    /* JADX INFO: renamed from: lambda$sendUnsubscribeSynchronized$13$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12205x91876c22(Protocol.Command command, Throwable th) {
        this.futures.remove(Integer.valueOf(command.getId()));
        processDisconnect(4, "unsubscribe error", true);
        return null;
    }

    private byte[] serializeCommand(Protocol.Command command) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            command.writeDelimitedTo(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private Subscription getSub(String str) {
        return this.subs.get(str);
    }

    void updateSubscriptionPushId(Subscription subscription, long j, long j2) {
        if (j > 0) {
            this.subsById.remove(Long.valueOf(j), subscription);
        }
        if (j2 > 0) {
            this.subsById.put(Long.valueOf(j2), subscription);
        }
    }

    private Subscription getSubForPush(String str, long j) {
        if (j > 0) {
            return this.subsById.get(Long.valueOf(j));
        }
        return this.subs.get(str);
    }

    private ServerSubscription getServerSub(String str) {
        return this.serverSubs.get(str);
    }

    public Subscription newSubscription(String str, SubscriptionOptions subscriptionOptions, SubscriptionEventListener subscriptionEventListener) throws DuplicateSubscriptionException {
        Subscription subscription;
        synchronized (this.subs) {
            if (this.subs.get(str) != null) {
                throw new DuplicateSubscriptionException();
            }
            subscription = new Subscription(this, str, subscriptionEventListener, subscriptionOptions);
            this.subs.put(str, subscription);
        }
        return subscription;
    }

    public Subscription newSubscription(String str, SubscriptionEventListener subscriptionEventListener) throws DuplicateSubscriptionException {
        return newSubscription(str, new SubscriptionOptions(), subscriptionEventListener);
    }

    public Subscription getSubscription(String str) {
        Subscription sub;
        synchronized (this.subs) {
            sub = getSub(str);
        }
        return sub;
    }

    public void removeSubscription(Subscription subscription) {
        synchronized (this.subs) {
            subscription.unsubscribe();
            if (this.subs.get(subscription.getChannel()) != null) {
                this.subs.remove(subscription.getChannel());
            }
        }
    }

    private void handleSubscribeReply(String str, Protocol.Reply reply) throws Exception {
        Subscription sub = getSub(str);
        if (sub != null) {
            if (reply.getError().getCode() != 0) {
                sub.subscribeError(new ReplyError(reply.getError().getCode(), reply.getError().getMessage(), reply.getError().getTemporary()));
            } else {
                sub.moveToSubscribed(reply.getSubscribe());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _waitServerPing() {
        if (getState() != ClientState.CONNECTED) {
            return;
        }
        processDisconnect(2, "no ping", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitServerPing() {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0._waitServerPing();
            }
        });
    }

    private void handleConnectReply(Protocol.Reply reply) {
        CompletableFuture<Protocol.Reply> completableFuture;
        ServerSubscription serverSubscription;
        if (getState() != ClientState.CONNECTING) {
            return;
        }
        if (reply.getError().getCode() != 0) {
            handleConnectionError(new ReplyError(reply.getError().getCode(), reply.getError().getMessage(), reply.getError().getTemporary()));
            if (reply.getError().getCode() == 109) {
                this.refreshRequired = true;
                this.ws.close(1000, "");
                return;
            } else if (reply.getError().getTemporary()) {
                this.ws.close(1000, "");
                return;
            } else {
                processDisconnect(reply.getError().getCode(), reply.getError().getMessage(), false);
                return;
            }
        }
        Protocol.ConnectResult connect = reply.getConnect();
        ConnectedEvent connectedEvent = new ConnectedEvent();
        connectedEvent.setClient(connect.getClient());
        connectedEvent.setData(connect.getData().toByteArray());
        setState(ClientState.CONNECTED);
        this.listener.onConnected(this, connectedEvent);
        this.pingInterval = connect.getPing() * 1000;
        this.sendPong = connect.getPong();
        synchronized (this.subs) {
            Iterator<Map.Entry<String, Subscription>> it = this.subs.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().resubscribeIfNecessary();
            }
        }
        Iterator<Map.Entry<String, Protocol.SubscribeResult>> it2 = connect.getSubsMap().entrySet().iterator();
        while (true) {
            StreamPosition streamPosition = null;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, Protocol.SubscribeResult> next = it2.next();
            Protocol.SubscribeResult value = next.getValue();
            String key = next.getKey();
            if (this.serverSubs.containsKey(key)) {
                serverSubscription = this.serverSubs.get(key);
            } else {
                serverSubscription = new ServerSubscription(Boolean.valueOf(value.getRecoverable()), value.getOffset(), value.getEpoch());
                this.serverSubs.put(key, serverSubscription);
            }
            serverSubscription.setRecoverable(Boolean.valueOf(value.getRecoverable()));
            serverSubscription.setLastEpoch(value.getEpoch());
            byte[] byteArray = value.getData() != null ? value.getData().toByteArray() : null;
            EventListener eventListener = this.listener;
            Boolean boolValueOf = Boolean.valueOf(value.getWasRecovering());
            Boolean boolValueOf2 = Boolean.valueOf(value.getRecovered());
            Boolean boolValueOf3 = Boolean.valueOf(value.getPositioned());
            Boolean boolValueOf4 = Boolean.valueOf(value.getRecoverable());
            if (value.getPositioned() || value.getRecoverable()) {
                streamPosition = new StreamPosition(value.getOffset(), value.getEpoch());
            }
            eventListener.onSubscribed(this, new ServerSubscribedEvent(key, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, streamPosition, byteArray));
            if (value.getPublicationsCount() > 0) {
                for (Protocol.Publication publication : value.getPublicationsList()) {
                    ServerPublicationEvent serverPublicationEvent = new ServerPublicationEvent();
                    serverPublicationEvent.setChannel(key);
                    serverPublicationEvent.setData(publication.getData().toByteArray());
                    serverPublicationEvent.setTags(publication.getTagsMap());
                    serverPublicationEvent.setInfo(ClientInfo.fromProtocolClientInfo(publication.getInfo()));
                    serverPublicationEvent.setOffset(publication.getOffset());
                    if (publication.getOffset() > 0) {
                        serverSubscription.setLastOffset(publication.getOffset());
                    }
                    this.listener.onPublication(this, serverPublicationEvent);
                }
            } else {
                serverSubscription.setLastOffset(value.getOffset());
            }
            it2 = it2;
        }
        Iterator<Map.Entry<String, ServerSubscription>> it3 = this.serverSubs.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<String, ServerSubscription> next2 = it3.next();
            if (!connect.getSubsMap().containsKey(next2.getKey())) {
                this.listener.onUnsubscribed(this, new ServerUnsubscribedEvent(next2.getKey()));
                it3.remove();
            }
        }
        this.reconnectAttempts = 0;
        Iterator<Map.Entry<Integer, Protocol.Command>> it4 = this.connectCommands.entrySet().iterator();
        while (it4.hasNext()) {
            Protocol.Command value2 = it4.next().getValue();
            if (!this.ws.send(okio.ByteString.of(serializeCommand(value2))) && (completableFuture = this.futures.get(Integer.valueOf(value2.getId()))) != null) {
                completableFuture.completeExceptionally(new IOException());
            }
        }
        this.connectCommands.clear();
        Iterator<Map.Entry<Integer, Protocol.Command>> it5 = this.connectAsyncCommands.entrySet().iterator();
        while (it5.hasNext()) {
            Protocol.Command value3 = it5.next().getValue();
            CompletableFuture<Protocol.Reply> completableFuture2 = this.futures.get(Integer.valueOf(value3.getId()));
            if (this.ws.send(okio.ByteString.of(serializeCommand(value3)))) {
                if (completableFuture2 != null) {
                    completableFuture2.complete(null);
                }
            } else if (completableFuture2 != null) {
                completableFuture2.completeExceptionally(new IOException());
            }
        }
        this.connectAsyncCommands.clear();
        this.pingTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda35(this), this.pingInterval + this.opts.getMaxServerPingDelay(), TimeUnit.MILLISECONDS);
        if (connect.getExpires()) {
            this.refreshTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda9(this), connect.getTtl(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRefresh() {
        if (this.opts.getTokenGetter() == null) {
            return;
        }
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12196lambda$sendRefresh$17$iogithubcentrifugalcentrifugeClient();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$17$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12196lambda$sendRefresh$17$iogithubcentrifugalcentrifugeClient() {
        final WebSocket webSocket = this.ws;
        this.opts.getTokenGetter().getConnectionToken(new ConnectionTokenEvent(), new TokenCallback() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda26
            @Override // io.github.centrifugal.centrifuge.TokenCallback
            public final void Done(Throwable th, String str) {
                this.f$0.m12195lambda$sendRefresh$16$iogithubcentrifugalcentrifugeClient(webSocket, th, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$16$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12195lambda$sendRefresh$16$iogithubcentrifugalcentrifugeClient(final WebSocket webSocket, final Throwable th, final String str) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12194lambda$sendRefresh$15$iogithubcentrifugalcentrifugeClient(webSocket, th, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$15$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12194lambda$sendRefresh$15$iogithubcentrifugalcentrifugeClient(final WebSocket webSocket, Throwable th, String str) {
        if (this.ws == webSocket && getState() == ClientState.CONNECTED) {
            if (th != null) {
                if (th instanceof UnauthorizedException) {
                    failUnauthorized();
                    return;
                } else {
                    this.listener.onError(this, new ErrorEvent(new TokenError(th)));
                    this.refreshTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda9(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                    return;
                }
            }
            if (str == null || str.equals("")) {
                failUnauthorized();
            } else {
                this.token = str;
                refreshSynchronized(str, new ResultCallback() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda15
                    @Override // io.github.centrifugal.centrifuge.ResultCallback
                    public final void onDone(Throwable th2, Object obj) {
                        this.f$0.m12193lambda$sendRefresh$14$iogithubcentrifugalcentrifugeClient(webSocket, th2, (Protocol.RefreshResult) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$sendRefresh$14$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12193lambda$sendRefresh$14$iogithubcentrifugalcentrifugeClient(WebSocket webSocket, Throwable th, Protocol.RefreshResult refreshResult) {
        if (this.ws == webSocket && getState() == ClientState.CONNECTED) {
            if (th != null) {
                this.listener.onError(this, new ErrorEvent(new RefreshError(th)));
                if (th instanceof ReplyError) {
                    ReplyError replyError = (ReplyError) th;
                    if (replyError.isTemporary()) {
                        this.refreshTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda9(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                        return;
                    } else {
                        processDisconnect(replyError.getCode(), replyError.getMessage(), false);
                        return;
                    }
                }
                this.refreshTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda9(this), this.backoff.duration(0, 10000, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), TimeUnit.MILLISECONDS);
                return;
            }
            if (refreshResult.getExpires()) {
                this.refreshTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda9(this), refreshResult.getTtl(), TimeUnit.SECONDS);
            }
        }
    }

    private void sendConnect() {
        Protocol.ConnectRequest.Builder builderNewBuilder = Protocol.ConnectRequest.newBuilder();
        if (this.token.length() > 0) {
            builderNewBuilder.setToken(this.token);
        }
        if (this.opts.getName().length() > 0) {
            builderNewBuilder.setName(this.opts.getName());
        }
        if (this.opts.getVersion().length() > 0) {
            builderNewBuilder.setVersion(this.opts.getVersion());
        }
        ByteString byteString = this.data;
        if (byteString != null) {
            builderNewBuilder.setData(byteString);
        }
        if (this.serverSubs.size() > 0) {
            for (Map.Entry<String, ServerSubscription> entry : this.serverSubs.entrySet()) {
                Protocol.SubscribeRequest.Builder builderNewBuilder2 = Protocol.SubscribeRequest.newBuilder();
                if (entry.getValue().getRecoverable()) {
                    builderNewBuilder2.setEpoch(entry.getValue().getEpoch());
                    builderNewBuilder2.setOffset(entry.getValue().getOffset());
                    builderNewBuilder2.setRecover(true);
                }
                builderNewBuilder.putSubs(entry.getKey(), builderNewBuilder2.build());
            }
        }
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setConnect(builderNewBuilder.build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        this.futures.put(Integer.valueOf(commandBuild.getId()), completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda40
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12191lambda$sendConnect$18$iogithubcentrifugalcentrifugeClient(commandBuild, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda41
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12192lambda$sendConnect$19$iogithubcentrifugalcentrifugeClient(commandBuild, (Throwable) obj);
            }
        });
        this.ws.send(okio.ByteString.of(serializeCommand(commandBuild)));
    }

    /* JADX INFO: renamed from: lambda$sendConnect$18$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12191lambda$sendConnect$18$iogithubcentrifugalcentrifugeClient(Protocol.Command command, Protocol.Reply reply) {
        this.futures.remove(Integer.valueOf(command.getId()));
        try {
            handleConnectReply(reply);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: lambda$sendConnect$19$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12192lambda$sendConnect$19$iogithubcentrifugalcentrifugeClient(Protocol.Command command, Throwable th) {
        handleConnectionError(th);
        this.futures.remove(Integer.valueOf(command.getId()));
        this.ws.close(1000, "");
        return null;
    }

    private void failUnauthorized() {
        processDisconnect(1, "unauthorized", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReply(Protocol.Reply reply) throws Exception {
        if (reply.getId() > 0) {
            CompletableFuture<Protocol.Reply> completableFuture = this.futures.get(Integer.valueOf(reply.getId()));
            if (completableFuture != null) {
                completableFuture.complete(reply);
                return;
            }
            return;
        }
        if (reply.hasPush()) {
            handlePush(reply.getPush());
        } else {
            handlePing();
        }
    }

    void handlePub(String str, Protocol.Publication publication) throws Exception {
        handlePub(str, publication, 0L);
    }

    void handlePub(String str, Protocol.Publication publication, long j) throws Exception {
        ServerSubscription serverSub;
        ClientInfo clientInfoFromProtocolClientInfo = ClientInfo.fromProtocolClientInfo(publication.getInfo());
        Subscription subForPush = getSubForPush(str, j);
        if (subForPush != null) {
            subForPush.handlePublication(publication);
            return;
        }
        if (j <= 0 && (serverSub = getServerSub(str)) != null) {
            ServerPublicationEvent serverPublicationEvent = new ServerPublicationEvent();
            serverPublicationEvent.setChannel(str);
            serverPublicationEvent.setData(publication.getData().toByteArray());
            serverPublicationEvent.setInfo(clientInfoFromProtocolClientInfo);
            serverPublicationEvent.setOffset(publication.getOffset());
            serverPublicationEvent.setTags(publication.getTagsMap());
            if (publication.getOffset() > 0) {
                serverSub.setLastOffset(publication.getOffset());
            }
            this.listener.onPublication(this, serverPublicationEvent);
        }
    }

    private void handleSubscribe(String str, Protocol.Subscribe subscribe) {
        ServerSubscription serverSubscription = new ServerSubscription(Boolean.valueOf(subscribe.getRecoverable()), subscribe.getOffset(), subscribe.getEpoch());
        this.serverSubs.put(str, serverSubscription);
        serverSubscription.setRecoverable(Boolean.valueOf(subscribe.getRecoverable()));
        serverSubscription.setLastEpoch(subscribe.getEpoch());
        serverSubscription.setLastOffset(subscribe.getOffset());
        this.listener.onSubscribed(this, new ServerSubscribedEvent(str, false, false, Boolean.valueOf(subscribe.getPositioned()), Boolean.valueOf(subscribe.getRecoverable()), (subscribe.getPositioned() || subscribe.getRecoverable()) ? new StreamPosition(subscribe.getOffset(), subscribe.getEpoch()) : null, subscribe.getData() != null ? subscribe.getData().toByteArray() : null));
    }

    private void handleUnsubscribe(String str, Protocol.Unsubscribe unsubscribe) {
        Subscription sub = getSub(str);
        if (sub != null) {
            if (unsubscribe.getCode() < 2500) {
                sub.moveToUnsubscribed(false, unsubscribe.getCode(), unsubscribe.getReason());
                return;
            }
            if (unsubscribe.getCode() == UNSUBSCRIBED_STATE_INVALIDATED) {
                sub.invalidateState();
            }
            sub.moveToSubscribing(unsubscribe.getCode(), unsubscribe.getReason());
            sub.resubscribeIfNecessary();
            return;
        }
        if (getServerSub(str) != null) {
            this.serverSubs.remove(str);
            this.listener.onUnsubscribed(this, new ServerUnsubscribedEvent(str));
        }
    }

    private void handleJoin(String str, Protocol.Join join, long j) {
        ClientInfo clientInfoFromProtocolClientInfo = ClientInfo.fromProtocolClientInfo(join.getInfo());
        Subscription subForPush = getSubForPush(str, j);
        if (subForPush != null) {
            JoinEvent joinEvent = new JoinEvent();
            joinEvent.setInfo(clientInfoFromProtocolClientInfo);
            subForPush.getListener().onJoin(subForPush, joinEvent);
        } else if (j <= 0 && getServerSub(str) != null) {
            this.listener.onJoin(this, new ServerJoinEvent(str, clientInfoFromProtocolClientInfo));
        }
    }

    private void handleLeave(String str, Protocol.Leave leave, long j) {
        LeaveEvent leaveEvent = new LeaveEvent();
        ClientInfo clientInfoFromProtocolClientInfo = ClientInfo.fromProtocolClientInfo(leave.getInfo());
        Subscription subForPush = getSubForPush(str, j);
        if (subForPush != null) {
            leaveEvent.setInfo(clientInfoFromProtocolClientInfo);
            subForPush.getListener().onLeave(subForPush, leaveEvent);
        } else if (j <= 0 && getServerSub(str) != null) {
            this.listener.onLeave(this, new ServerLeaveEvent(str, clientInfoFromProtocolClientInfo));
        }
    }

    private void handleMessage(Protocol.Message message) {
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setData(message.getData().toByteArray());
        this.listener.onMessage(this, messageEvent);
    }

    private void handleDisconnect(Protocol.Disconnect disconnect) {
        int code = disconnect.getCode();
        boolean z = code < 3500 || code >= 5000 || (code >= 4000 && code < 4500);
        if (getState() != ClientState.DISCONNECTED) {
            processDisconnect(code, disconnect.getReason(), Boolean.valueOf(z));
        }
    }

    private void handlePush(Protocol.Push push) throws Exception {
        String channel = push.getChannel();
        long id = push.getId();
        if (push.hasPub()) {
            handlePub(channel, push.getPub(), id);
            return;
        }
        if (push.hasSubscribe()) {
            handleSubscribe(channel, push.getSubscribe());
            return;
        }
        if (push.hasJoin()) {
            handleJoin(channel, push.getJoin(), id);
            return;
        }
        if (push.hasLeave()) {
            handleLeave(channel, push.getLeave(), id);
            return;
        }
        if (push.hasUnsubscribe()) {
            handleUnsubscribe(channel, push.getUnsubscribe());
        } else if (push.hasMessage()) {
            handleMessage(push.getMessage());
        } else if (push.hasDisconnect()) {
            handleDisconnect(push.getDisconnect());
        }
    }

    private void handlePing() {
        ScheduledFuture<?> scheduledFuture = this.pingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.pingTask = this.scheduler.schedule(new Client$$ExternalSyntheticLambda35(this), this.pingInterval + this.opts.getMaxServerPingDelay(), TimeUnit.MILLISECONDS);
        if (this.sendPong) {
            this.ws.send(okio.ByteString.of(serializeCommand(Protocol.Command.newBuilder().build())));
        }
    }

    public void send(final byte[] bArr, final CompletionCallback completionCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12190lambda$send$20$iogithubcentrifugalcentrifugeClient(bArr, completionCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12190lambda$send$20$iogithubcentrifugalcentrifugeClient(byte[] bArr, final CompletionCallback completionCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setSend(Protocol.SendRequest.newBuilder().setData(ByteString.copyFrom(bArr)).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        this.futures.put(Integer.valueOf(commandBuild.getId()), completableFuture);
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda0
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12200xd918b026(commandBuild, completionCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda11
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12202xf2590628(commandBuild, completionCallback, (Throwable) obj);
            }
        });
        if (getState() != ClientState.CONNECTED) {
            this.connectAsyncCommands.put(Integer.valueOf(commandBuild.getId()), commandBuild);
        } else if (!this.ws.send(okio.ByteString.of(serializeCommand(commandBuild)))) {
            completableFuture.completeExceptionally(new IOException());
        } else {
            completableFuture.complete(null);
        }
    }

    /* JADX INFO: renamed from: lambda$sendSynchronized$21$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12200xd918b026(Protocol.Command command, CompletionCallback completionCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        completionCallback.onDone(null);
    }

    /* JADX INFO: renamed from: lambda$sendSynchronized$23$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12202xf2590628(final Protocol.Command command, final CompletionCallback completionCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12201x65b8db27(command, completionCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$sendSynchronized$22$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12201x65b8db27(Protocol.Command command, CompletionCallback completionCallback, Throwable th) {
        cleanCommandFuture(command);
        completionCallback.onDone(th);
    }

    private void enqueueCommandFuture(Protocol.Command command, CompletableFuture<Protocol.Reply> completableFuture) {
        this.futures.put(Integer.valueOf(command.getId()), completableFuture);
        if (getState() != ClientState.CONNECTED) {
            this.connectCommands.put(Integer.valueOf(command.getId()), command);
        } else {
            if (this.ws.send(okio.ByteString.of(serializeCommand(command)))) {
                return;
            }
            completableFuture.completeExceptionally(new IOException());
        }
    }

    ReplyError getReplyError(Protocol.Reply reply) {
        return new ReplyError(reply.getError().getCode(), reply.getError().getMessage(), reply.getError().getTemporary());
    }

    private void cleanCommandFuture(Protocol.Command command) {
        this.futures.remove(Integer.valueOf(command.getId()));
        if (this.connectCommands.get(Integer.valueOf(command.getId())) != null) {
            this.connectCommands.remove(Integer.valueOf(command.getId()));
        }
        if (this.connectAsyncCommands.get(Integer.valueOf(command.getId())) != null) {
            this.connectAsyncCommands.remove(Integer.valueOf(command.getId()));
        }
    }

    public void rpc(final String str, final byte[] bArr, final ResultCallback<RPCResult> resultCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12186lambda$rpc$24$iogithubcentrifugalcentrifugeClient(str, bArr, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: rpcSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12186lambda$rpc$24$iogithubcentrifugalcentrifugeClient(String str, byte[] bArr, final ResultCallback<RPCResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setRpc(Protocol.RPCRequest.newBuilder().setData(ByteString.copyFrom(bArr)).setMethod(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda43
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12187xe111cb87(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda45
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12189xfa522189(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$rpcSynchronized$25$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12187xe111cb87(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
            return;
        }
        Protocol.RPCResult rpc = reply.getRpc();
        RPCResult rPCResult = new RPCResult();
        rPCResult.setData(rpc.getData().toByteArray());
        resultCallback.onDone(null, rPCResult);
    }

    /* JADX INFO: renamed from: lambda$rpcSynchronized$27$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12189xfa522189(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12188x6db1f688(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$rpcSynchronized$26$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12188x6db1f688(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    public void publish(final String str, final byte[] bArr, final ResultCallback<PublishResult> resultCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12179lambda$publish$28$iogithubcentrifugalcentrifugeClient(str, bArr, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: publishSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12179lambda$publish$28$iogithubcentrifugalcentrifugeClient(String str, byte[] bArr, final ResultCallback<PublishResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setPublish(Protocol.PublishRequest.newBuilder().setChannel(str).setData(ByteString.copyFrom(bArr)).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda16
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12180x362806a1(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda17
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12182xd88be3b8(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$publishSynchronized$29$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12180x362806a1(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
        } else {
            resultCallback.onDone(null, new PublishResult());
        }
    }

    /* JADX INFO: renamed from: lambda$publishSynchronized$31$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12182xd88be3b8(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12181x4bebb8b7(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$publishSynchronized$30$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12181x4bebb8b7(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    public void history(final String str, final HistoryOptions historyOptions, final ResultCallback<HistoryResult> resultCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12167lambda$history$32$iogithubcentrifugalcentrifugeClient(str, historyOptions, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: historySynchronized, reason: merged with bridge method [inline-methods] */
    public void m12167lambda$history$32$iogithubcentrifugalcentrifugeClient(String str, HistoryOptions historyOptions, final ResultCallback<HistoryResult> resultCallback) {
        Protocol.HistoryRequest.Builder limit = Protocol.HistoryRequest.newBuilder().setChannel(str).setReverse(historyOptions.getReverse()).setLimit(historyOptions.getLimit());
        if (historyOptions.getSince() != null) {
            limit.setSince(historyOptions.getSince().toProto());
        }
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setHistory(limit.build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda27
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12168xbada2095(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda28
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12170xd41a7697(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$historySynchronized$33$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12168xbada2095(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
            return;
        }
        Protocol.HistoryResult history = reply.getHistory();
        HistoryResult historyResult = new HistoryResult();
        List<Protocol.Publication> publicationsList = history.getPublicationsList();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < publicationsList.size(); i++) {
            Protocol.Publication publication = publicationsList.get(i);
            Publication publication2 = new Publication();
            publication2.setData(publication.getData().toByteArray());
            publication2.setOffset(publication.getOffset());
            publication2.setInfo(ClientInfo.fromProtocolClientInfo(publication.getInfo()));
            arrayList.add(publication2);
        }
        historyResult.setPublications(arrayList);
        historyResult.setOffset(history.getOffset());
        historyResult.setEpoch(history.getEpoch());
        resultCallback.onDone(null, historyResult);
    }

    /* JADX INFO: renamed from: lambda$historySynchronized$35$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12170xd41a7697(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12169x477a4b96(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$historySynchronized$34$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12169x477a4b96(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    public void presence(final String str, final ResultCallback<PresenceResult> resultCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12171lambda$presence$36$iogithubcentrifugalcentrifugeClient(str, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: presenceSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12171lambda$presence$36$iogithubcentrifugalcentrifugeClient(String str, final ResultCallback<PresenceResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setPresence(Protocol.PresenceRequest.newBuilder().setChannel(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda4
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12176x9b12aaf8(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda5
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12178xb45300fa(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$presenceSynchronized$37$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12176x9b12aaf8(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
            return;
        }
        Map<String, Protocol.ClientInfo> presenceMap = reply.getPresence().getPresenceMap();
        HashMap map = new HashMap();
        for (Map.Entry<String, Protocol.ClientInfo> entry : presenceMap.entrySet()) {
            map.put(entry.getKey(), ClientInfo.fromProtocolClientInfo(entry.getValue()));
        }
        resultCallback.onDone(null, new PresenceResult(map));
    }

    /* JADX INFO: renamed from: lambda$presenceSynchronized$39$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12178xb45300fa(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12177x27b2d5f9(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$presenceSynchronized$38$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12177x27b2d5f9(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    public void presenceStats(final String str, final ResultCallback<PresenceStatsResult> resultCallback) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12172lambda$presenceStats$40$iogithubcentrifugalcentrifugeClient(str, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: presenceStatsSynchronized, reason: merged with bridge method [inline-methods] */
    public void m12172lambda$presenceStats$40$iogithubcentrifugalcentrifugeClient(String str, final ResultCallback<PresenceStatsResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setPresenceStats(Protocol.PresenceStatsRequest.newBuilder().setChannel(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda54
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12173x297b2c22(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda1
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12175x42bb8224(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$presenceStatsSynchronized$41$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12173x297b2c22(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
            return;
        }
        Protocol.PresenceStatsResult presenceStats = reply.getPresenceStats();
        PresenceStatsResult presenceStatsResult = new PresenceStatsResult();
        presenceStatsResult.setNumClients(Integer.valueOf(presenceStats.getNumClients()));
        presenceStatsResult.setNumUsers(Integer.valueOf(presenceStats.getNumUsers()));
        resultCallback.onDone(null, presenceStatsResult);
    }

    /* JADX INFO: renamed from: lambda$presenceStatsSynchronized$43$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12175x42bb8224(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12174xb61b5723(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$presenceStatsSynchronized$42$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12174xb61b5723(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    private void refreshSynchronized(String str, final ResultCallback<Protocol.RefreshResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setRefresh(Protocol.RefreshRequest.newBuilder().setToken(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda22
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12183x4f920e8e(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda33
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12185x68d26490(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$refreshSynchronized$44$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12183x4f920e8e(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
        } else {
            resultCallback.onDone(null, reply.getRefresh());
        }
    }

    /* JADX INFO: renamed from: lambda$refreshSynchronized$46$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12185x68d26490(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12184xdc32398f(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$refreshSynchronized$45$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12184xdc32398f(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }

    void subRefreshSynchronized(String str, String str2, final ResultCallback<Protocol.SubRefreshResult> resultCallback) {
        final Protocol.Command commandBuild = Protocol.Command.newBuilder().setId(getNextId()).setSubRefresh(Protocol.SubRefreshRequest.newBuilder().setToken(str2).setChannel(str).build()).build();
        CompletableFuture<Protocol.Reply> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda7
            @Override // java8.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m12208x7e54ebd7(commandBuild, resultCallback, (Protocol.Reply) obj);
            }
        }).orTimeout(this.opts.getTimeout(), TimeUnit.MILLISECONDS).exceptionally(new Function() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda8
            @Override // java8.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m12210x979541d9(commandBuild, resultCallback, (Throwable) obj);
            }
        });
        enqueueCommandFuture(commandBuild, completableFuture);
    }

    /* JADX INFO: renamed from: lambda$subRefreshSynchronized$47$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12208x7e54ebd7(Protocol.Command command, ResultCallback resultCallback, Protocol.Reply reply) {
        cleanCommandFuture(command);
        if (reply.getError().getCode() != 0) {
            resultCallback.onDone(getReplyError(reply), null);
        } else {
            resultCallback.onDone(null, reply.getSubRefresh());
        }
    }

    /* JADX INFO: renamed from: lambda$subRefreshSynchronized$49$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ Void m12210x979541d9(final Protocol.Command command, final ResultCallback resultCallback, final Throwable th) {
        this.executor.submit(new Runnable() { // from class: io.github.centrifugal.centrifuge.Client$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12209xaf516d8(command, resultCallback, th);
            }
        });
        return null;
    }

    /* JADX INFO: renamed from: lambda$subRefreshSynchronized$48$io-github-centrifugal-centrifuge-Client, reason: not valid java name */
    /* synthetic */ void m12209xaf516d8(Protocol.Command command, ResultCallback resultCallback, Throwable th) {
        cleanCommandFuture(command);
        resultCallback.onDone(th, null);
    }
}
