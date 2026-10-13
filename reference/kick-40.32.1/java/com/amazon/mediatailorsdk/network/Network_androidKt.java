package com.amazon.mediatailorsdk.network;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: Network.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0002\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"httpClient", "Lio/ktor/client/HttpClient;", "config", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Network_androidKt {
    public static final HttpClient httpClient(final Function1<? super HttpClientConfig<?>, Unit> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return HttpClientKt.HttpClient(OkHttp.INSTANCE, new Function1() { // from class: com.amazon.mediatailorsdk.network.Network_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Network_androidKt.httpClient$lambda$0(config, (HttpClientConfig) obj);
            }
        });
    }

    static final Unit httpClient$lambda$0(Function1 function1, HttpClientConfig HttpClient) {
        Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
        function1.invoke(HttpClient);
        HttpClient.engine(new Function1() { // from class: com.amazon.mediatailorsdk.network.Network_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Network_androidKt.httpClient$lambda$0$0((OkHttpConfig) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient$lambda$0$0(OkHttpConfig engine) {
        Intrinsics.checkNotNullParameter(engine, "$this$engine");
        engine.config(new Function1() { // from class: com.amazon.mediatailorsdk.network.Network_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Network_androidKt.httpClient$lambda$0$0$0((OkHttpClient.Builder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient$lambda$0$0$0(OkHttpClient.Builder config) {
        Intrinsics.checkNotNullParameter(config, "$this$config");
        config.retryOnConnectionFailure(false);
        config.connectTimeout(30L, TimeUnit.SECONDS);
        return Unit.INSTANCE;
    }
}
