package io.ktor.client.engine.okhttp;

import com.facebook.react.uimanager.ViewProps;
import io.ktor.client.plugins.websocket.WebSocketException;
import io.ktor.http.HttpStatusCode;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketChannelsConfig;
import io.ktor.websocket.WebSocketChannelsConfigKt;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: OkHttpWebsocketSession.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u001d\u0010!J'\u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b'\u0010&J)\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010)\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b,\u0010-J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010.J\u000f\u0010/\u001a\u00020\u0012H\u0017¢\u0006\u0004\b/\u0010.R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00101R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b3\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0000058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020\u0017058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00107\u001a\u0004\b9\u0010:R$\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020;8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010D\u001a\u00020;2\u0006\u0010<\u001a\u00020;8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R$\u0010J\u001a\u00020E2\u0006\u0010<\u001a\u00020E8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010M\u001a\u00020;2\u0006\u0010<\u001a\u00020;8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010QR\u001c\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u00107R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020O0U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020O0Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001c\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001e\u0010f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010e¨\u0006g"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpWebsocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lokhttp3/WebSocketListener;", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/WebSocket$Factory;", "webSocketFactory", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/WebSocket$Factory;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/websocket/WebSocketChannelsConfig;)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "", ViewProps.START, "(Ljava/util/List;)V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "Lokio/ByteString;", "bytes", "onMessage", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", "text", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "", "code", "reason", "onClosed", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosing", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()V", "terminate", "Lokhttp3/OkHttpClient;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CompletableDeferred;", "self", "Lkotlinx/coroutines/CompletableDeferred;", "originResponse", "getOriginResponse$ktor_client_okhttp", "()Lkotlinx/coroutines/CompletableDeferred;", "", "_", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "setMaxFrameSize", "maxFrameSize", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "_outgoing", "Lio/ktor/websocket/CloseReason;", "_closeReason", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Job;", "writeJob", "Lkotlinx/coroutines/Job;", "getExtensions", "()Ljava/util/List;", "extensions", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpWebsocketSession extends WebSocketListener implements DefaultWebSocketSession {
    private final CompletableDeferred<CloseReason> _closeReason;
    private final Channel<Frame> _incoming;
    private final Channel<Frame> _outgoing;
    private final CoroutineContext coroutineContext;
    private final OkHttpClient engine;
    private final CompletableDeferred<Response> originResponse;
    private final CompletableDeferred<OkHttpWebsocketSession> self;
    private final WebSocket.Factory webSocketFactory;
    private final Job writeJob;

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return true;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return Long.MAX_VALUE;
    }

    public OkHttpWebsocketSession(OkHttpClient engine, WebSocket.Factory webSocketFactory, Request engineRequest, CoroutineContext coroutineContext, WebSocketChannelsConfig channelsConfig) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(webSocketFactory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(engineRequest, "engineRequest");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channelsConfig, "channelsConfig");
        this.engine = engine;
        this.webSocketFactory = webSocketFactory;
        this.coroutineContext = coroutineContext;
        this.self = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.originResponse = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (!channelsConfig.getIncoming().getCanSuspend()) {
            this._incoming = WebSocketChannelsConfigKt.from(Channel.INSTANCE, channelsConfig.getIncoming());
            this._outgoing = WebSocketChannelsConfigKt.from(Channel.INSTANCE, channelsConfig.getOutgoing());
            this._closeReason = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.writeJob = BuildersKt__Builders_commonKt.launch$default(this, null, null, new OkHttpWebsocketSession$writeJob$1(this, engineRequest, null), 3, null);
            return;
        }
        throw new IllegalArgumentException("OkHttp does not support SUSPEND overflow strategy for incoming channel".toString());
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation<? super Unit> continuation) {
        return super.send(frame, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public /* synthetic */ OkHttpWebsocketSession(OkHttpClient okHttpClient, WebSocket.Factory factory, Request request, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, factory, request, coroutineContext, (i & 16) != 0 ? WebSocketChannelsConfig.INSTANCE.getUNLIMITED() : webSocketChannelsConfig);
    }

    public final CompletableDeferred<Response> getOriginResponse$ktor_client_okhttp() {
        return this.originResponse;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.engine.pingIntervalMillis();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        throw new WebSocketException("OkHttp doesn't support dynamic ping interval. You could switch it in the engine configuration.");
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.engine.readTimeoutMillis();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        throw new WebSocketException("Websocket timeout should be configured in OkHttp engine.");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        throw new WebSocketException("Masking switch is not supported in OkHttp engine.");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        throw new WebSocketException("Max frame size switch is not supported in OkHttp engine.");
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred<CloseReason> getCloseReason() {
        return this._closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!negotiatedExtensions.isEmpty()) {
            throw new IllegalArgumentException("Extensions are not supported.".toString());
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        this.originResponse.complete(response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        super.onMessage(webSocket, bytes);
        this._incoming.mo12563trySendJP2dKIU(new Frame.Binary(true, bytes.toByteArray()));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String text) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(text, "text");
        super.onMessage(webSocket, text);
        Channel<Frame> channel = this._incoming;
        byte[] bytes = text.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        channel.mo12563trySendJP2dKIU(new Frame.Text(true, bytes));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int code, String reason) {
        Object objValueOf;
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.onClosed(webSocket, code, reason);
        short s = (short) code;
        this._closeReason.complete(new CloseReason(s, reason));
        SendChannel.DefaultImpls.close$default(this._incoming, null, 1, null);
        StringBuilder sb = new StringBuilder("WebSocket session closed with code ");
        CloseReason.Codes codesByCode = CloseReason.Codes.INSTANCE.byCode(s);
        if (codesByCode == null || (objValueOf = codesByCode.toString()) == null) {
            objValueOf = Integer.valueOf(code);
        }
        sb.append(objValueOf);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        CancellationException cancellationException = new CancellationException(sb.toString());
        getOutgoing().close(cancellationException);
        this.writeJob.cancel(cancellationException);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int code, String reason) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.onClosing(webSocket, code, reason);
        short s = (short) code;
        this._closeReason.complete(new CloseReason(s, reason));
        getOutgoing().mo12563trySendJP2dKIU(new Frame.Close(new CloseReason(s, reason)));
        SendChannel.DefaultImpls.close$default(this._incoming, null, 1, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(t, "t");
        super.onFailure(webSocket, t, response);
        Integer numValueOf = response != null ? Integer.valueOf(response.code()) : null;
        int value = HttpStatusCode.INSTANCE.getUnauthorized().getValue();
        if (numValueOf != null && numValueOf.intValue() == value) {
            this.originResponse.complete(response);
            SendChannel.DefaultImpls.close$default(this._incoming, null, 1, null);
            SendChannel.DefaultImpls.close$default(getOutgoing(), null, 1, null);
        } else {
            this.originResponse.completeExceptionally(t);
            this._closeReason.completeExceptionally(t);
            this._incoming.close(t);
            getOutgoing().close(t);
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public final void start() {
        this.self.complete(this);
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
