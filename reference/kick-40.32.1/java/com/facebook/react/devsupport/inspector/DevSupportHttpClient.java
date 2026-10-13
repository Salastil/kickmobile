package com.facebook.react.devsupport.inspector;

import com.datadog.android.log.LogAttributes;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: DevSupportHttpClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/devsupport/inspector/DevSupportHttpClient;", "", "<init>", "()V", "MAX_CONCURRENT_REQUESTS", "", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient$ReactAndroid", "()Lokhttp3/OkHttpClient;", "websocketClient", "getWebsocketClient$ReactAndroid", "httpScheme", "", LogAttributes.HOST, "httpScheme$ReactAndroid", "wsScheme", "wsScheme$ReactAndroid", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DevSupportHttpClient {
    public static final DevSupportHttpClient INSTANCE = new DevSupportHttpClient();
    private static final int MAX_CONCURRENT_REQUESTS = 32;
    private static final OkHttpClient httpClient;
    private static final OkHttpClient websocketClient;

    private DevSupportHttpClient() {
    }

    public final OkHttpClient getHttpClient$ReactAndroid() {
        return httpClient;
    }

    static {
        OkHttpClient.Builder builderNewBuilder = OkHttpClientProvider.getOkHttpClient().newBuilder();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(32);
        dispatcher.setMaxRequestsPerHost(32);
        OkHttpClient okHttpClientBuild = builderNewBuilder.dispatcher(dispatcher).connectionPool(new ConnectionPool()).connectTimeout(5L, TimeUnit.SECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
        httpClient = okHttpClientBuild;
        websocketClient = okHttpClientBuild.newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
    }

    public final OkHttpClient getWebsocketClient$ReactAndroid() {
        return websocketClient;
    }

    public final String httpScheme$ReactAndroid(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? "https" : "http";
    }

    public final String wsScheme$ReactAndroid(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? "wss" : "ws";
    }
}
