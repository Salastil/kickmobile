package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: OkHttpConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eR3\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\nR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "<init>", "()V", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "config", "(Lkotlin/jvm/functions/Function1;)V", "Lokhttp3/Interceptor;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)V", "addNetworkInterceptor", "Lkotlin/jvm/functions/Function1;", "getConfig$ktor_client_okhttp", "()Lkotlin/jvm/functions/Function1;", "setConfig$ktor_client_okhttp", "Lokhttp3/OkHttpClient;", "preconfigured", "Lokhttp3/OkHttpClient;", "getPreconfigured", "()Lokhttp3/OkHttpClient;", "setPreconfigured", "(Lokhttp3/OkHttpClient;)V", "", "clientCacheSize", "I", "getClientCacheSize", "()I", "setClientCacheSize", "(I)V", "Lokhttp3/WebSocket$Factory;", "webSocketFactory", "Lokhttp3/WebSocket$Factory;", "getWebSocketFactory", "()Lokhttp3/WebSocket$Factory;", "setWebSocketFactory", "(Lokhttp3/WebSocket$Factory;)V", "", "duplexStreamingEnabled", "Z", "getDuplexStreamingEnabled", "()Z", "setDuplexStreamingEnabled", "(Z)V", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpConfig extends HttpClientEngineConfig {
    private boolean duplexStreamingEnabled;
    private OkHttpClient preconfigured;
    private WebSocket.Factory webSocketFactory;
    private Function1<? super OkHttpClient.Builder, Unit> config = new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpConfig$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return OkHttpConfig.config$lambda$0((OkHttpClient.Builder) obj);
        }
    };
    private int clientCacheSize = 10;

    public final Function1<OkHttpClient.Builder, Unit> getConfig$ktor_client_okhttp() {
        return this.config;
    }

    public final void setConfig$ktor_client_okhttp(Function1<? super OkHttpClient.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.config = function1;
    }

    static final Unit config$lambda$0(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.followRedirects(false);
        builder.followSslRedirects(false);
        builder.retryOnConnectionFailure(true);
        return Unit.INSTANCE;
    }

    public final OkHttpClient getPreconfigured() {
        return this.preconfigured;
    }

    public final void setPreconfigured(OkHttpClient okHttpClient) {
        this.preconfigured = okHttpClient;
    }

    public final int getClientCacheSize() {
        return this.clientCacheSize;
    }

    public final void setClientCacheSize(int i) {
        this.clientCacheSize = i;
    }

    public final WebSocket.Factory getWebSocketFactory() {
        return this.webSocketFactory;
    }

    public final void setWebSocketFactory(WebSocket.Factory factory) {
        this.webSocketFactory = factory;
    }

    public final boolean getDuplexStreamingEnabled() {
        return this.duplexStreamingEnabled;
    }

    public final void setDuplexStreamingEnabled(boolean z) {
        this.duplexStreamingEnabled = z;
    }

    public final void config(final Function1<? super OkHttpClient.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final Function1<? super OkHttpClient.Builder, Unit> function1 = this.config;
        this.config = new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpConfig$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OkHttpConfig.config$lambda$1(function1, block, (OkHttpClient.Builder) obj);
            }
        };
    }

    static final Unit config$lambda$1(Function1 function1, Function1 function2, OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        function1.invoke(builder);
        function2.invoke(builder);
        return Unit.INSTANCE;
    }

    public final void addInterceptor(final Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        config(new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpConfig$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OkHttpConfig.addInterceptor$lambda$0(interceptor, (OkHttpClient.Builder) obj);
            }
        });
    }

    static final Unit addInterceptor$lambda$0(Interceptor interceptor, OkHttpClient.Builder config) {
        Intrinsics.checkNotNullParameter(config, "$this$config");
        config.addInterceptor(interceptor);
        return Unit.INSTANCE;
    }

    public final void addNetworkInterceptor(final Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        config(new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpConfig$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OkHttpConfig.addNetworkInterceptor$lambda$0(interceptor, (OkHttpClient.Builder) obj);
            }
        });
    }

    static final Unit addNetworkInterceptor$lambda$0(Interceptor interceptor, OkHttpClient.Builder config) {
        Intrinsics.checkNotNullParameter(config, "$this$config");
        config.addNetworkInterceptor(interceptor);
        return Unit.INSTANCE;
    }
}
