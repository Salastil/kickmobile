package com.facebook.react.modules.websocket;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.CustomClientBuilder;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.InspectorNetworkReporter;
import com.facebook.react.modules.network.NetworkEventUtil;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "WebSocketModule")
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 92\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00110\u0017H\u0082\bJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u000bJ,\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020'H\u0016J\"\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0016\u0010-\u001a\u00020\u00112\u0006\u0010/\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u00101\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u00102\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0010\u00105\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020'H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule;", "Lcom/facebook/fbreact/specs/NativeWebSocketModuleSpec;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "webSocketConnections", "", "", "Lokhttp3/WebSocket;", "contentHandlers", "Lcom/facebook/react/modules/websocket/WebSocketModule$ContentHandler;", "cookieHandler", "Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "inspectorRequestIds", "", "invalidate", "", "isInspectorNetworkReportingEnabled", "", "reportToInspector", "id", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "requestId", "sendEvent", "eventName", "params", "Lcom/facebook/react/bridge/ReadableMap;", "setContentHandler", "contentHandler", "connect", ImagesContract.URL, "protocols", "Lcom/facebook/react/bridge/ReadableArray;", "options", "socketID", "", "close", "code", "reason", "send", "message", "sendBinary", "base64String", "byteString", "Lokio/ByteString;", "ping", "notifyWebSocketFailed", "getCookie", "uri", "addListener", "removeListeners", "count", "ContentHandler", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebSocketModule extends NativeWebSocketModuleSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "WebSocketModule";
    private static CustomClientBuilder customClientBuilder;
    private final Map<Integer, ContentHandler> contentHandlers;
    private final ForwardingCookieHandler cookieHandler;
    private final Map<Integer, String> inspectorRequestIds;
    private final Map<Integer, WebSocket> webSocketConnections;

    /* JADX INFO: compiled from: WebSocketModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule$ContentHandler;", "", "onMessage", "", "text", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "byteString", "Lokio/ByteString;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ContentHandler {
        void onMessage(String text, WritableMap params);

        void onMessage(ByteString byteString, WritableMap params);
    }

    @JvmStatic
    public static final void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        INSTANCE.setCustomClientBuilder(customClientBuilder2);
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketModule(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webSocketConnections = new ConcurrentHashMap();
        this.contentHandlers = new ConcurrentHashMap();
        this.cookieHandler = new ForwardingCookieHandler();
        this.inspectorRequestIds = new ConcurrentHashMap();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        Iterator<WebSocket> it = this.webSocketConnections.values().iterator();
        while (it.hasNext()) {
            it.next().close(1001, null);
        }
        this.webSocketConnections.clear();
        this.contentHandlers.clear();
        this.inspectorRequestIds.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInspectorNetworkReportingEnabled() {
        return ReactNativeFeatureFlags.fuseboxWebSocketEventsEnabled();
    }

    private final void reportToInspector(int id, Function1<? super String, Unit> block) {
        String str;
        if (!isInspectorNetworkReportingEnabled() || (str = (String) this.inspectorRequestIds.get(Integer.valueOf(id))) == null) {
            return;
        }
        block.invoke(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String eventName, ReadableMap params) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        if (reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(eventName, params);
        }
    }

    public final void setContentHandler(int id, ContentHandler contentHandler) {
        Map<Integer, ContentHandler> map = this.contentHandlers;
        if (contentHandler != null) {
            map.put(Integer.valueOf(id), contentHandler);
        } else {
            map.remove(Integer.valueOf(id));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void connect(String url, ReadableArray protocols, ReadableMap options, double socketID) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        ReadableArray readableArray = protocols;
        Intrinsics.checkNotNullParameter(url, "url");
        final int i3 = (int) socketID;
        OkHttpClient.Builder timeout = OkHttpClientProvider.getOkHttpClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES);
        INSTANCE.applyCustomBuilder(timeout);
        OkHttpClient okHttpClientBuild = timeout.build();
        Request.Builder builderUrl = new Request.Builder().tag(Integer.valueOf(i3)).url(url);
        String cookie = getCookie(url);
        if (cookie != null) {
            builderUrl.addHeader("Cookie", cookie);
        }
        boolean z3 = true;
        if (options != null && options.hasKey("headers") && options.getType("headers") == ReadableType.Map) {
            ReadableMap map = options.getMap("headers");
            if (map == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            z = false;
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                if (ReadableType.String == map.getType(strNextKey)) {
                    if (StringsKt.equals(strNextKey, "origin", true)) {
                        z = true;
                    }
                    String string = map.getString(strNextKey);
                    if (string != null) {
                        builderUrl.addHeader(strNextKey, string);
                    } else {
                        throw new IllegalStateException(("value for name " + strNextKey + " == null").toString());
                    }
                } else {
                    FLog.w(ReactConstants.TAG, "Ignoring: requested " + strNextKey + ", value not a string");
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            builderUrl.addHeader("origin", INSTANCE.getDefaultOrigin(url));
        }
        String string2 = null;
        if (readableArray == null || readableArray.size() <= 0) {
            z2 = true;
        } else {
            StringBuilder sb = new StringBuilder("");
            int size = readableArray.size();
            int i4 = 0;
            while (i4 < size) {
                String string3 = readableArray.getString(i4);
                String string4 = string3 != null ? StringsKt.trim((CharSequence) string3).toString() : null;
                boolean z4 = z3;
                String str = string4;
                if (str == null || str.length() == 0) {
                    i = size;
                    i2 = i4;
                } else {
                    i = size;
                    i2 = i4;
                    if (!StringsKt.contains$default((CharSequence) str, (CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, false, 2, (Object) null)) {
                        sb.append(string4);
                        sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                    }
                }
                z3 = z4;
                i4 = i2 + 1;
                size = i;
                readableArray = protocols;
            }
            z2 = z3;
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                String string5 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                builderUrl.addHeader("Sec-WebSocket-Protocol", string5);
            }
        }
        Request requestBuild = builderUrl.build();
        if (isInspectorNetworkReportingEnabled()) {
            if (options != null && options.hasKey("unstable_devToolsRequestId") == z2 && options.getType("unstable_devToolsRequestId") == ReadableType.String) {
                string2 = options.getString("unstable_devToolsRequestId");
            }
            if (string2 == null) {
                string2 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            }
            this.inspectorRequestIds.put(Integer.valueOf(i3), string2);
            InspectorNetworkReporter.reportWebSocketCreated(string2, url);
            InspectorNetworkReporter.reportWebSocketWillSendHandshakeRequest(string2, NetworkEventUtil.okHttpHeadersToMap(requestBuild.getHeaders()));
        }
        okHttpClientBuild.newWebSocket(requestBuild, new WebSocketListener() { // from class: com.facebook.react.modules.websocket.WebSocketModule.connect.2
            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                String str2;
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(response, "response");
                WebSocketModule.this.webSocketConnections.put(Integer.valueOf(i3), webSocket);
                WebSocketModule webSocketModule = WebSocketModule.this;
                int i5 = i3;
                if (webSocketModule.isInspectorNetworkReportingEnabled() && (str2 = (String) webSocketModule.inspectorRequestIds.get(Integer.valueOf(i5))) != null) {
                    InspectorNetworkReporter.reportWebSocketHandshakeResponseReceived(str2, response.getCode(), NetworkEventUtil.okHttpHeadersToMap(response.getHeaders()));
                }
                int i6 = i3;
                WritableMap writableMapCreateMap = Arguments.createMap();
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                readableMapBuilder.put("id", i6);
                readableMapBuilder.put("protocol", response.header("Sec-WebSocket-Protocol", ""));
                WebSocketModule.this.sendEvent("websocketOpen", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                webSocket.close(code, reason);
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int code, String reason) {
                String str2;
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                WebSocketModule webSocketModule = WebSocketModule.this;
                int i5 = i3;
                if (webSocketModule.isInspectorNetworkReportingEnabled() && (str2 = (String) webSocketModule.inspectorRequestIds.get(Integer.valueOf(i5))) != null) {
                    InspectorNetworkReporter.reportWebSocketClosed(str2);
                }
                WebSocketModule.this.inspectorRequestIds.remove(Integer.valueOf(i3));
                int i6 = i3;
                WritableMap writableMapCreateMap = Arguments.createMap();
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                readableMapBuilder.put("id", i6);
                readableMapBuilder.put("code", code);
                readableMapBuilder.put("reason", reason);
                WebSocketModule.this.sendEvent("websocketClosed", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                String str2;
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(t, "t");
                WebSocketModule webSocketModule = WebSocketModule.this;
                int i5 = i3;
                if (webSocketModule.isInspectorNetworkReportingEnabled() && (str2 = (String) webSocketModule.inspectorRequestIds.get(Integer.valueOf(i5))) != null) {
                    InspectorNetworkReporter.reportWebSocketClosed(str2);
                }
                WebSocketModule.this.inspectorRequestIds.remove(Integer.valueOf(i3));
                WebSocketModule.this.notifyWebSocketFailed(i3, t.getMessage());
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String text) {
                String str2;
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(text, "text");
                WebSocketModule webSocketModule = WebSocketModule.this;
                int i5 = i3;
                if (webSocketModule.isInspectorNetworkReportingEnabled() && (str2 = (String) webSocketModule.inspectorRequestIds.get(Integer.valueOf(i5))) != null) {
                    InspectorNetworkReporter.reportWebSocketMessageReceived(str2, text);
                }
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("id", i3);
                writableMapCreateMap.putString("type", "text");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.contentHandlers.get(Integer.valueOf(i3));
                if (contentHandler != null) {
                    contentHandler.onMessage(text, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString("data", text);
                }
                WebSocketModule.this.sendEvent("websocketMessage", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                String str2;
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                WebSocketModule webSocketModule = WebSocketModule.this;
                int i5 = i3;
                if (webSocketModule.isInspectorNetworkReportingEnabled() && (str2 = (String) webSocketModule.inspectorRequestIds.get(Integer.valueOf(i5))) != null) {
                    InspectorNetworkReporter.reportWebSocketMessageReceived(str2, bytes);
                }
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("id", i3);
                writableMapCreateMap.putString("type", "binary");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.contentHandlers.get(Integer.valueOf(i3));
                if (contentHandler != null) {
                    contentHandler.onMessage(bytes, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString("data", bytes.base64());
                }
                WebSocketModule.this.sendEvent("websocketMessage", writableMapCreateMap);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void close(double code, String reason, double socketID) {
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            return;
        }
        try {
            webSocket.close((int) code, reason);
            this.webSocketConnections.remove(Integer.valueOf(i));
            this.contentHandlers.remove(Integer.valueOf(i));
        } catch (Exception e) {
            FLog.e(ReactConstants.TAG, "Could not close WebSocket connection for id " + i, e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void send(String message, double socketID) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                if (isInspectorNetworkReportingEnabled() && (str = (String) this.inspectorRequestIds.get(Integer.valueOf(i))) != null) {
                    InspectorNetworkReporter.reportWebSocketMessageSent(str, message);
                }
                webSocket.send(message);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
        this.inspectorRequestIds.remove(Integer.valueOf(i));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void sendBinary(String base64String, double socketID) {
        String str;
        Intrinsics.checkNotNullParameter(base64String, "base64String");
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                ByteString byteStringM14488deprecated_decodeBase64 = ByteString.INSTANCE.m14488deprecated_decodeBase64(base64String);
                if (byteStringM14488deprecated_decodeBase64 != null) {
                    if (isInspectorNetworkReportingEnabled() && (str = (String) this.inspectorRequestIds.get(Integer.valueOf(i))) != null) {
                        InspectorNetworkReporter.reportWebSocketMessageSent(str, byteStringM14488deprecated_decodeBase64);
                    }
                    webSocket.send(byteStringM14488deprecated_decodeBase64);
                    return;
                }
                throw new IllegalStateException("bytes == null".toString());
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
        this.inspectorRequestIds.remove(Integer.valueOf(i));
    }

    public final void sendBinary(ByteString byteString, int id) {
        String str;
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(id));
        if (webSocket != null) {
            try {
                if (isInspectorNetworkReportingEnabled() && (str = (String) this.inspectorRequestIds.get(Integer.valueOf(id))) != null) {
                    InspectorNetworkReporter.reportWebSocketMessageSent(str, byteString);
                }
                webSocket.send(byteString);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(id, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", id);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", id);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(id));
        this.contentHandlers.remove(Integer.valueOf(id));
        this.inspectorRequestIds.remove(Integer.valueOf(id));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void ping(double socketID) {
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                webSocket.send(ByteString.EMPTY);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
        this.inspectorRequestIds.remove(Integer.valueOf(i));
    }

    private final String getCookie(String uri) {
        try {
            List<String> list = this.cookieHandler.get(new URI(INSTANCE.getDefaultOrigin(uri)), new HashMap()).get("Cookie");
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                return list.get(0);
            }
            return null;
        } catch (IOException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + uri);
        } catch (URISyntaxException unused2) {
            throw new IllegalArgumentException("Unable to get cookie from " + uri);
        }
    }

    /* JADX INFO: compiled from: WebSocketModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule$Companion;", "", "<init>", "()V", "NAME", "", "customClientBuilder", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "setCustomClientBuilder", "", "ccb", "applyCustomBuilder", "builder", "Lokhttp3/OkHttpClient$Builder;", "getDefaultOrigin", "uri", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setCustomClientBuilder(CustomClientBuilder ccb) {
            WebSocketModule.customClientBuilder = ccb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyCustomBuilder(OkHttpClient.Builder builder) {
            CustomClientBuilder customClientBuilder = WebSocketModule.customClientBuilder;
            if (customClientBuilder != null) {
                customClientBuilder.apply(builder);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:20:0x0035 A[Catch: URISyntaxException -> 0x0092, TryCatch #0 {URISyntaxException -> 0x0092, blocks: (B:2:0x0000, B:4:0x000b, B:14:0x0027, B:20:0x0035, B:28:0x004f, B:31:0x0058, B:33:0x007b, B:17:0x002e, B:21:0x003a, B:25:0x0045), top: B:37:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x004d  */
        public final String getDefaultOrigin(String uri) {
            String scheme;
            try {
                URI uri2 = new URI(uri);
                String scheme2 = uri2.getScheme();
                if (scheme2 != null) {
                    int iHashCode = scheme2.hashCode();
                    scheme = "http";
                    if (iHashCode != 3804) {
                        if (iHashCode != 118039) {
                            if (iHashCode != 3213448) {
                                if (iHashCode == 99617003 && scheme2.equals("https")) {
                                    scheme = uri2.getScheme();
                                } else {
                                    scheme = "";
                                }
                            } else if (scheme2.equals("http")) {
                                scheme = uri2.getScheme();
                            } else {
                                scheme = "";
                            }
                        } else if (scheme2.equals("wss")) {
                            scheme = "https";
                        } else {
                            scheme = "";
                        }
                    } else if (!scheme2.equals("ws")) {
                        scheme = "";
                    }
                } else {
                    scheme = "";
                }
                if (uri2.getPort() != -1) {
                    return scheme + "://" + uri2.getHost() + ServerSentEventKt.COLON + uri2.getPort();
                }
                return scheme + "://" + uri2.getHost();
            } catch (URISyntaxException unused) {
                throw new IllegalArgumentException("Unable to set " + uri + " as default origin header");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyWebSocketFailed(int id, String message) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", id);
        readableMapBuilder.put("message", message);
        sendEvent("websocketFailed", writableMapCreateMap);
    }
}
