package com.pusherwebsocketreactnative;

import android.util.Log;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.gson.Gson;
import com.pusher.client.ChannelAuthorizer;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.PresenceChannel;
import com.pusher.client.channel.PresenceChannelEventListener;
import com.pusher.client.channel.PrivateChannelEventListener;
import com.pusher.client.channel.PrivateEncryptedChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.channel.User;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import com.pusher.client.util.HttpChannelAuthorizer;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PusherWebsocketReactNativeModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u000f\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J(\u0010)\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0016J(\u0010.\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0016J\u001c\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00102\n\u00108\u001a\u000609j\u0002`:H\u0016J\"\u0010;\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010\u00102\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=H\u0016J\u001c\u0010?\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u00102\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010A\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010B\u001a\u00020>H\u0016J\u0018\u0010C\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010B\u001a\u00020>H\u0016J*\u0010D\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u00102\u000e\u00108\u001a\n\u0018\u000109j\u0004\u0018\u0001`:H\u0016J\u001c\u0010D\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00102\n\u00108\u001a\u000609j\u0002`:H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/pusherwebsocketreactnative/PusherWebsocketReactNativeModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/pusher/client/connection/ConnectionEventListener;", "Lcom/pusher/client/channel/ChannelEventListener;", "Lcom/pusher/client/channel/SubscriptionEventListener;", "Lcom/pusher/client/channel/PrivateChannelEventListener;", "Lcom/pusher/client/channel/PrivateEncryptedChannelEventListener;", "Lcom/pusher/client/channel/PresenceChannelEventListener;", "Lcom/pusher/client/ChannelAuthorizer;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "pusher", "Lcom/pusher/client/Pusher;", "TAG", "", "authorizerMutex", "", "Ljava/util/concurrent/Semaphore;", "authorizerResult", "Lcom/facebook/react/bridge/ReadableMap;", "pusherEventEmitter", "Lcom/pusherwebsocketreactnative/PusherEventEmitter;", "getName", "addListener", "", "eventName", "removeListeners", "count", "", "(Ljava/lang/Integer;)V", "initialize", "arguments", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "connect", "disconnect", "subscribe", "channelName", "unsubscribe", "trigger", "data", "getSocketId", "authorize", "socketId", "onAuthorizer", "onConnectionStateChange", "change", "Lcom/pusher/client/connection/ConnectionStateChange;", "onSubscriptionSucceeded", "onEvent", "event", "Lcom/pusher/client/channel/PusherEvent;", "onAuthenticationFailure", "message", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUsersInformationReceived", "users", "", "Lcom/pusher/client/channel/User;", "onDecryptionFailure", "reason", "userSubscribed", "user", "userUnsubscribed", "onError", "code", "pusher_pusher-websocket-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PusherWebsocketReactNativeModule extends ReactContextBaseJavaModule implements ConnectionEventListener, ChannelEventListener, SubscriptionEventListener, PrivateChannelEventListener, PrivateEncryptedChannelEventListener, PresenceChannelEventListener, ChannelAuthorizer {
    private final String TAG;
    private final Map<String, Semaphore> authorizerMutex;
    private final Map<String, ReadableMap> authorizerResult;
    private Pusher pusher;
    private final PusherEventEmitter pusherEventEmitter;

    @ReactMethod
    public final void addListener(String eventName) {
    }

    @ReactMethod
    public final void removeListeners(Integer count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PusherWebsocketReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.TAG = "PusherReactNative";
        this.authorizerMutex = new LinkedHashMap();
        this.authorizerResult = new LinkedHashMap();
        this.pusherEventEmitter = new PusherEventEmitter(reactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PusherWebsocketReactNative";
    }

    @ReactMethod
    public final void initialize(ReadableMap arguments, Promise promise) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Pusher pusher = this.pusher;
            if (pusher != null) {
                Intrinsics.checkNotNull(pusher);
                pusher.disconnect();
            }
            PusherOptions pusherOptions = new PusherOptions();
            if (arguments.hasKey("cluster")) {
                pusherOptions.setCluster(arguments.getString("cluster"));
            }
            if (arguments.hasKey("useTLS")) {
                pusherOptions.setUseTLS(arguments.getBoolean("useTLS"));
            }
            if (arguments.hasKey("activityTimeout")) {
                pusherOptions.setActivityTimeout(arguments.getInt("activityTimeout"));
            }
            if (arguments.hasKey("pongTimeout")) {
                pusherOptions.setPongTimeout(arguments.getInt("pongTimeout"));
            }
            if (arguments.hasKey("maxReconnectionAttempts")) {
                pusherOptions.setMaxReconnectionAttempts(arguments.getInt("maxReconnectionAttempts"));
            }
            if (arguments.hasKey("maxReconnectGapInSeconds")) {
                pusherOptions.setMaxReconnectGapInSeconds(arguments.getInt("maxReconnectGapInSeconds"));
            }
            if (arguments.hasKey("authEndpoint")) {
                pusherOptions.setChannelAuthorizer(new HttpChannelAuthorizer(arguments.getString("authEndpoint")));
            }
            if (arguments.hasKey("authorizer") && arguments.getBoolean("authorizer")) {
                pusherOptions.setChannelAuthorizer(this);
            }
            if (arguments.hasKey("proxy")) {
                String string = arguments.getString("proxy");
                Intrinsics.checkNotNull(string);
                List listSplit$default = StringsKt.split$default((CharSequence) string, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
                pusherOptions.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) listSplit$default.get(0), Integer.parseInt((String) listSplit$default.get(1)))));
            }
            Pusher pusher2 = new Pusher(arguments.getString("apiKey"), pusherOptions);
            this.pusher = pusher2;
            Log.i(this.TAG, "Start " + pusher2);
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(this.TAG, e.getMessage(), (Throwable) null);
        }
    }

    @ReactMethod
    public final void connect(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Pusher pusher = this.pusher;
        Intrinsics.checkNotNull(pusher);
        pusher.connect(this, ConnectionState.ALL);
        promise.resolve(null);
    }

    @ReactMethod
    public final void disconnect(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Pusher pusher = this.pusher;
        Intrinsics.checkNotNull(pusher);
        pusher.disconnect();
        promise.resolve(null);
    }

    @ReactMethod
    public final void subscribe(String channelName, Promise promise) {
        PresenceChannel presenceChannelSubscribe;
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (StringsKt.startsWith$default(channelName, "private-encrypted-", false, 2, (Object) null)) {
                Pusher pusher = this.pusher;
                Intrinsics.checkNotNull(pusher);
                presenceChannelSubscribe = pusher.subscribePrivateEncrypted(channelName, this, new String[0]);
            } else if (StringsKt.startsWith$default(channelName, "private-", false, 2, (Object) null)) {
                Pusher pusher2 = this.pusher;
                Intrinsics.checkNotNull(pusher2);
                presenceChannelSubscribe = pusher2.subscribePrivate(channelName, this, new String[0]);
            } else {
                boolean zStartsWith$default = StringsKt.startsWith$default(channelName, "presence-", false, 2, (Object) null);
                Pusher pusher3 = this.pusher;
                if (zStartsWith$default) {
                    Intrinsics.checkNotNull(pusher3);
                    presenceChannelSubscribe = pusher3.subscribePresence(channelName, this, new String[0]);
                } else {
                    Intrinsics.checkNotNull(pusher3);
                    presenceChannelSubscribe = pusher3.subscribe(channelName, this, new String[0]);
                }
            }
            presenceChannelSubscribe.bindGlobal(this);
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject("Error", "Failed to subscribe to channel: " + channelName, e);
        }
    }

    @ReactMethod
    public final void unsubscribe(String channelName, Promise promise) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Pusher pusher = this.pusher;
        Intrinsics.checkNotNull(pusher);
        pusher.unsubscribe(channelName);
        promise.resolve(null);
    }

    @ReactMethod
    public final void trigger(String channelName, String eventName, String data, Promise promise) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (StringsKt.startsWith$default(channelName, "private-encrypted-", false, 2, (Object) null)) {
                throw new Exception("It's not currently possible to send a message using private encrypted channels.");
            }
            if (StringsKt.startsWith$default(channelName, "private-", false, 2, (Object) null)) {
                Pusher pusher = this.pusher;
                Intrinsics.checkNotNull(pusher);
                pusher.getPrivateChannel(channelName).trigger(eventName, data);
            } else if (StringsKt.startsWith$default(channelName, "presence-", false, 2, (Object) null)) {
                Pusher pusher2 = this.pusher;
                Intrinsics.checkNotNull(pusher2);
                pusher2.getPresenceChannel(channelName).trigger(eventName, data);
            } else {
                throw new Exception("Messages can only be sent to private and presence channels.");
            }
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getSocketId(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Pusher pusher = this.pusher;
        Intrinsics.checkNotNull(pusher);
        promise.resolve(pusher.getConnection().getSocketId());
    }

    @Override // com.pusher.client.ChannelAuthorizer
    public String authorize(String channelName, String socketId) throws InterruptedException {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(socketId, "socketId");
        this.pusherEventEmitter.emit("onAuthorizer", MapsKt.mapOf(TuplesKt.to("channelName", channelName), TuplesKt.to("socketId", socketId)));
        String str = channelName + socketId;
        this.authorizerMutex.put(str, new Semaphore(0));
        Semaphore semaphore = this.authorizerMutex.get(str);
        Intrinsics.checkNotNull(semaphore);
        semaphore.acquire();
        ReadableMap readableMapRemove = this.authorizerResult.remove(str);
        Intrinsics.checkNotNull(readableMapRemove);
        return new Gson().toJson(readableMapRemove.toHashMap());
    }

    @ReactMethod
    public final void onAuthorizer(String channelName, String socketId, ReadableMap data, Promise promise) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(socketId, "socketId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String str = channelName + socketId;
        this.authorizerResult.put(str, data);
        Semaphore semaphore = this.authorizerMutex.get(str);
        Intrinsics.checkNotNull(semaphore);
        semaphore.release();
        this.authorizerMutex.remove(str);
        promise.resolve(null);
    }

    @Override // com.pusher.client.connection.ConnectionEventListener
    public void onConnectionStateChange(ConnectionStateChange change) {
        Intrinsics.checkNotNullParameter(change, "change");
        this.pusherEventEmitter.emit("onConnectionStateChange", MapsKt.mapOf(TuplesKt.to("previousState", change.getPreviousState().toString()), TuplesKt.to("currentState", change.getCurrentState().toString())));
    }

    @Override // com.pusher.client.channel.ChannelEventListener
    public void onSubscriptionSucceeded(String channelName) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        if (StringsKt.startsWith$default(channelName, "presence-", false, 2, (Object) null)) {
            return;
        }
        this.pusherEventEmitter.emit("onEvent", MapsKt.mapOf(TuplesKt.to("channelName", channelName), TuplesKt.to("eventName", "pusher_internal:subscription_succeeded"), TuplesKt.to("data", MapsKt.emptyMap())));
    }

    @Override // com.pusher.client.channel.SubscriptionEventListener
    public void onEvent(PusherEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getEventName() == "pusher:subscription_count") {
            event = new PusherEvent("pusher_internal:subscription_count", event.getChannelName(), event.getUserId(), event.getData());
        }
        this.pusherEventEmitter.emit("onEvent", MapsKt.mapOf(TuplesKt.to("channelName", event.getChannelName()), TuplesKt.to("eventName", event.getEventName()), TuplesKt.to("userId", event.getUserId()), TuplesKt.to("data", event.getData())));
    }

    @Override // com.pusher.client.channel.PrivateChannelEventListener
    public void onAuthenticationFailure(String message, Exception e) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(e, "e");
        this.pusherEventEmitter.emit("onSubscriptionError", MapsKt.mapOf(TuplesKt.to("message", message), TuplesKt.to("error", e.toString())));
    }

    @Override // com.pusher.client.channel.PresenceChannelEventListener
    public void onUsersInformationReceived(String channelName, Set<User> users) {
        Gson gson = new Gson();
        Pusher pusher = this.pusher;
        Intrinsics.checkNotNull(pusher);
        PresenceChannel presenceChannel = pusher.getPresenceChannel(channelName);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Intrinsics.checkNotNull(users);
        for (User user : users) {
            linkedHashMap.put(user.getId(), gson.fromJson(user.getInfo(), Map.class));
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("count", Integer.valueOf(users.size()));
        Set<User> set = users;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((User) it.next()).getId());
        }
        pairArr[1] = TuplesKt.to("ids", arrayList);
        pairArr[2] = TuplesKt.to("hash", linkedHashMap);
        this.pusherEventEmitter.emit("onEvent", MapsKt.mapOf(TuplesKt.to("channelName", channelName), TuplesKt.to("eventName", "pusher_internal:subscription_succeeded"), TuplesKt.to("userId", presenceChannel.getMe().getId()), TuplesKt.to("data", MapsKt.mapOf(TuplesKt.to("presence", MapsKt.mapOf(pairArr))))));
    }

    @Override // com.pusher.client.channel.PrivateEncryptedChannelEventListener
    public void onDecryptionFailure(String event, String reason) {
        this.pusherEventEmitter.emit("onDecryptionFailure", MapsKt.mapOf(TuplesKt.to("event", event), TuplesKt.to("reason", reason)));
    }

    @Override // com.pusher.client.channel.PresenceChannelEventListener
    public void userSubscribed(String channelName, User user) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(user, "user");
        this.pusherEventEmitter.emit("onMemberAdded", MapsKt.mapOf(TuplesKt.to("channelName", channelName), TuplesKt.to("user", MapsKt.mapOf(TuplesKt.to("userId", user.getId()), TuplesKt.to("userInfo", new Gson().fromJson(user.getInfo(), Map.class))))));
    }

    @Override // com.pusher.client.channel.PresenceChannelEventListener
    public void userUnsubscribed(String channelName, User user) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(user, "user");
        this.pusherEventEmitter.emit("onMemberRemoved", MapsKt.mapOf(TuplesKt.to("channelName", channelName), TuplesKt.to("user", MapsKt.mapOf(TuplesKt.to("userId", user.getId()), TuplesKt.to("userInfo", new Gson().fromJson(user.getInfo(), Map.class))))));
    }

    @Override // com.pusher.client.connection.ConnectionEventListener
    public void onError(String message, String code, Exception e) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.pusherEventEmitter.emit("onError", MapsKt.mapOf(TuplesKt.to("message", message), TuplesKt.to("code", code), TuplesKt.to("error", String.valueOf(e))));
    }

    @Override // com.pusher.client.channel.SubscriptionEventListener
    public void onError(String message, Exception e) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(e, "e");
        onError(message, "", e);
    }
}
