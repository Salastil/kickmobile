package com.kick.centrifugo;

import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.centrifugal.centrifuge.Client;
import io.github.centrifugal.centrifuge.ConnectionTokenEvent;
import io.github.centrifugal.centrifuge.ConnectionTokenGetter;
import io.github.centrifugal.centrifuge.Options;
import io.github.centrifugal.centrifuge.Subscription;
import io.github.centrifugal.centrifuge.SubscriptionOptions;
import io.github.centrifugal.centrifuge.SubscriptionTokenEvent;
import io.github.centrifugal.centrifuge.SubscriptionTokenGetter;
import io.github.centrifugal.centrifuge.TokenCallback;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONException;

/* JADX INFO: compiled from: KickcentrifugoModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/kick/centrifugo/KickcentrifugoModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "centrifugoAuthHandler", "Lcom/kick/centrifugo/CentrifugoAuthHandler;", "connectionUrl", "", "client", "Lio/github/centrifugal/centrifuge/Client;", "subsMap", "", "Lio/github/centrifugal/centrifuge/Subscription;", "clientListener", "Lcom/kick/centrifugo/CentrifugoClientListener;", "subscriptionListener", "Lcom/kick/centrifugo/CentrifugoSubscriptionListener;", "connectClient", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kickcentrifugo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickcentrifugoModule extends Module {
    private CentrifugoAuthHandler centrifugoAuthHandler;
    private Client client;
    private String connectionUrl;
    private final Map<String, Subscription> subsMap = new LinkedHashMap();
    private final CentrifugoClientListener clientListener = new CentrifugoClientListener(new Function2() { // from class: com.kick.centrifugo.KickcentrifugoModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return KickcentrifugoModule.clientListener$lambda$0(this.f$0, (String) obj, (Map) obj2);
        }
    });
    private final CentrifugoSubscriptionListener subscriptionListener = new CentrifugoSubscriptionListener(new Function2() { // from class: com.kick.centrifugo.KickcentrifugoModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return KickcentrifugoModule.subscriptionListener$lambda$0(this.f$0, (String) obj, (Map) obj2);
        }
    });

    static final Unit clientListener$lambda$0(KickcentrifugoModule kickcentrifugoModule, String name, Map body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        kickcentrifugoModule.sendEvent(name, (Map<String, ? extends Object>) body);
        return Unit.INSTANCE;
    }

    static final Unit subscriptionListener$lambda$0(KickcentrifugoModule kickcentrifugoModule, String name, Map body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        kickcentrifugoModule.sendEvent(name, (Map<String, ? extends Object>) body);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectClient(Promise promise) {
        Client client = this.client;
        if (client == null) {
            promise.reject("FAILED_TO_CREATE_CLIENT", "Failed to create centrifugo client", null);
        } else {
            client.connect();
            promise.resolve((Object) null);
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        KickcentrifugoModule kickcentrifugoModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickcentrifugoModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickcentrifugoModule);
            moduleDefinitionBuilder.Name("Kickcentrifugo");
            moduleDefinitionBuilder.Events("onConnected", "onDisconnected", "onConnecting", "onSubscribed", "onSubscribing", "onUnsubscribed", "onPublication", "onJoin", "onLeave", "onError", "onClientSubscribed", "onClientSubscribing", "onClientUnsubscribed", "onClientError", "onClientPublication", "onClientJoin", "onClientLeave", "onClientEventParsingError");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(InitializationParams.class), false));
            Object obj = null;
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(InitializationParams.class, false, null)), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(InitializationParams.class);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(InitializationParams.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("initialize", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    InitializationParams initializationParams = (InitializationParams) objArr[0];
                    HttpUrl httpUrl = HttpUrl.INSTANCE.parse(initializationParams.getConnectionAuthUrl());
                    if (httpUrl == null) {
                        promise.reject("INVALID_CONNECTION_AUTH_URL", "Invalid connection auth url", null);
                        return;
                    }
                    HttpUrl httpUrl2 = HttpUrl.INSTANCE.parse(initializationParams.getChannelAuthUrl());
                    if (httpUrl2 == null) {
                        promise.reject("INVALID_CHANNEL_AUTH_URL", "Invalid channel auth url", null);
                        return;
                    }
                    this.this$0.connectionUrl = initializationParams.getConnectionUrl();
                    final CentrifugoAuthHandler centrifugoAuthHandler = new CentrifugoAuthHandler(initializationParams.getClientId(), httpUrl, httpUrl2, initializationParams.getHeaders());
                    this.this$0.centrifugoAuthHandler = centrifugoAuthHandler;
                    Options options = new Options();
                    options.setHeaders(initializationParams.getHeaders());
                    options.setTokenGetter(new ConnectionTokenGetter() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$1$1$1
                        @Override // io.github.centrifugal.centrifuge.ConnectionTokenGetter
                        public void getConnectionToken(ConnectionTokenEvent event, final TokenCallback cb) throws JSONException {
                            Intrinsics.checkNotNullParameter(event, "event");
                            Intrinsics.checkNotNullParameter(cb, "cb");
                            CentrifugoAuthHandler.authorize$default(centrifugoAuthHandler, null, new Function2<Throwable, String, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$1$1$1$getConnectionToken$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2, String str) {
                                    invoke2(th2, str);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th2, String str) {
                                    if (th2 != null) {
                                        cb.Done(th2, null);
                                        return;
                                    }
                                    TokenCallback tokenCallback = cb;
                                    if (str == null) {
                                        tokenCallback.Done(new Exception("MISSING_TOKEN: The API didn't return a token"), null);
                                    } else {
                                        tokenCallback.Done(null, str);
                                    }
                                }
                            }, 1, null);
                        }
                    });
                    this.this$0.client = new Client(initializationParams.getConnectionUrl(), options, this.this$0.clientListener);
                    this.this$0.connectClient(promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("initialize", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("connect", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.connectClient(promise);
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        objM12684constructorimpl2 = null;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                    if (typeDescriptor2 == null) {
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType2 = new AnyType(typeDescriptor2, converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.connectClient((Promise) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("connect", anyTypeArr2, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("connect", anyTypeArr2, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("connect", anyTypeArr2, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("connect", anyTypeArr2, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("connect", anyTypeArr2, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("connect", anyTypeArr2, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("connect", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("disconnect", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Client client = this.this$0.client;
                        if (client != null) {
                            client.disconnect();
                        }
                        promise.resolve((Object) null);
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        objM12684constructorimpl3 = null;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                    if (typeDescriptor3 == null) {
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType3 = new AnyType(typeDescriptor3, converters3);
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        Client client = this.this$0.client;
                        if (client != null) {
                            client.disconnect();
                        }
                        promise.resolve((Object) null);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("disconnect", anyTypeArr3, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("disconnect", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters4);
            }
            anyTypeArr4[0] = anyType4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("subscribe", anyTypeArr4, new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    Client client = this.this$0.client;
                    if (client == null) {
                        promise.reject("FAILED_TO_SUBSCRIBE", "Client is not initialized", null);
                        return;
                    }
                    if (client.getSubscription(str) != null) {
                        promise.resolve((Object) null);
                        return;
                    }
                    try {
                        SubscriptionOptions subscriptionOptions = new SubscriptionOptions();
                        if (StringsKt.startsWith$default(str, "private-", false, 2, (Object) null)) {
                            final KickcentrifugoModule kickcentrifugoModule2 = this.this$0;
                            subscriptionOptions.tokenGetter = new SubscriptionTokenGetter() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$1$4$1
                                @Override // io.github.centrifugal.centrifuge.SubscriptionTokenGetter
                                public void getSubscriptionToken(SubscriptionTokenEvent event, final TokenCallback cb) throws JSONException {
                                    Intrinsics.checkNotNullParameter(event, "event");
                                    Intrinsics.checkNotNullParameter(cb, "cb");
                                    CentrifugoAuthHandler centrifugoAuthHandler = kickcentrifugoModule2.centrifugoAuthHandler;
                                    if (centrifugoAuthHandler != null) {
                                        centrifugoAuthHandler.authorize(event.getChannel(), new Function2<Throwable, String, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$1$4$1$getSubscriptionToken$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5, String str2) {
                                                invoke2(th5, str2);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Throwable th5, String str2) {
                                                if (th5 != null) {
                                                    cb.Done(th5, null);
                                                    return;
                                                }
                                                TokenCallback tokenCallback = cb;
                                                if (str2 == null) {
                                                    tokenCallback.Done(new Exception("MISSING_TOKEN: The API didn't return a token"), null);
                                                } else {
                                                    tokenCallback.Done(null, str2);
                                                }
                                            }
                                        });
                                    }
                                }
                            };
                        }
                        Subscription subscriptionNewSubscription = client.newSubscription(str, subscriptionOptions, this.this$0.subscriptionListener);
                        subscriptionNewSubscription.subscribe();
                        this.this$0.subsMap.put(str, subscriptionNewSubscription);
                        promise.resolve((Object) null);
                    } catch (Exception e) {
                        promise.reject("FAILED_TO_SUBSCRIBE", e.getMessage(), e);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder5.getAsyncFunctions().put("subscribe", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType5 = new AnyType(typeDescriptor5, converters5);
            }
            anyTypeArr5[0] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("unsubscribe", anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    Client client = this.this$0.client;
                    Subscription subscription = client != null ? client.getSubscription(str) : null;
                    KickcentrifugoModule kickcentrifugoModule2 = this.this$0;
                    if (subscription == null) {
                        kickcentrifugoModule2.subsMap.remove(str);
                        promise.resolve((Object) null);
                        return;
                    }
                    Client client2 = kickcentrifugoModule2.client;
                    if (client2 != null) {
                        client2.removeSubscription(subscription);
                    }
                    this.this$0.subsMap.remove(str);
                    promise.resolve((Object) null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("unsubscribe", asyncFunctionWithPromiseComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("unsubscribeAll", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        for (Map.Entry entry : MapsKt.toMap(this.this$0.subsMap).entrySet()) {
                            String str = (String) entry.getKey();
                            Subscription subscription = (Subscription) entry.getValue();
                            Client client = this.this$0.client;
                            if (client != null) {
                                client.removeSubscription(subscription);
                            }
                            this.this$0.subsMap.remove(str);
                        }
                        promise.resolve((Object) null);
                    }
                });
            } else {
                TypeConverterProvider converters6 = moduleDefinitionBuilder7.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType6 == null) {
                    try {
                        Result.Companion companion11 = Result.INSTANCE;
                        objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th6) {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                        obj = objM12684constructorimpl6;
                    }
                    TypeDescriptor typeDescriptor6 = (TypeDescriptor) obj;
                    if (typeDescriptor6 == null) {
                        typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType6 = new AnyType(typeDescriptor6, converters6);
                }
                anyTypeArr6[0] = anyType6;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: com.kick.centrifugo.KickcentrifugoModule$definition$lambda$0$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        for (Map.Entry entry : MapsKt.toMap(this.this$0.subsMap).entrySet()) {
                            String str = (String) entry.getKey();
                            Subscription subscription = (Subscription) entry.getValue();
                            Client client = this.this$0.client;
                            if (client != null) {
                                client.removeSubscription(subscription);
                            }
                            this.this$0.subsMap.remove(str);
                        }
                        promise.resolve((Object) null);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("unsubscribeAll", anyTypeArr6, function3);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent3;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("unsubscribeAll", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th7) {
            Trace.endSection();
            throw th7;
        }
    }
}
