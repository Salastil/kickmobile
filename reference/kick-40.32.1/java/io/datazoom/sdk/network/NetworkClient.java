package io.datazoom.sdk.network;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.HttpRequestRetryConfig;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.plugins.HttpRetryDelayContext;
import io.ktor.client.plugins.HttpRetryShouldRetryContext;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.client.plugins.logging.LogLevel;
import io.ktor.client.plugins.logging.Logger;
import io.ktor.client.plugins.logging.LoggerKt;
import io.ktor.client.plugins.logging.LoggingConfig;
import io.ktor.client.plugins.logging.LoggingKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentType;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR!\u0010\n\u001a\u00020\u000b8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/network/NetworkClient;", "", "<init>", "()V", "brokerUrl", "", "getBrokerUrl", "()Ljava/lang/String;", "setBrokerUrl", "(Ljava/lang/String;)V", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient$annotations", "getHttpClient", "()Lio/ktor/client/HttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetworkClient {
    private String brokerUrl = "";

    /* JADX INFO: renamed from: httpClient$delegate, reason: from kotlin metadata */
    private final Lazy httpClient = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Network_androidKt.httpClient(new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NetworkClient.httpClient_delegate$lambda$0$0((HttpClientConfig) obj);
                }
            });
        }
    });

    public static /* synthetic */ void getHttpClient$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean httpClient_delegate$lambda$0$0$1$2(HttpRetryShouldRetryContext retryOnExceptionIf, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Intrinsics.checkNotNullParameter(retryOnExceptionIf, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "<unused var>");
        return true;
    }

    public final String getBrokerUrl() {
        return this.brokerUrl;
    }

    public final void setBrokerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brokerUrl = str;
    }

    public final HttpClient getHttpClient() {
        return (HttpClient) this.httpClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0(HttpClientConfig httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "$this$httpClient");
        httpClient.install(LoggingKt.getLogging(), new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$0((LoggingConfig) obj);
            }
        });
        httpClient.install(HttpRequestRetryKt.getHttpRequestRetry(), new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$1((HttpRequestRetryConfig) obj);
            }
        });
        httpClient.install(ContentNegotiationKt.getContentNegotiation(), new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$2((ContentNegotiationConfig) obj);
            }
        });
        httpClient.install(DefaultRequest.INSTANCE, new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$3((DefaultRequest.DefaultRequestBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$0(LoggingConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.setLogger(LoggerKt.getEMPTY(Logger.INSTANCE));
        install.setLevel(LogLevel.NONE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$1(HttpRequestRetryConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.setMaxRetries(NetworkClientKt.delays.size());
        HttpRequestRetryConfig.retryIf$default(install, 0, new Function3() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(NetworkClient.httpClient_delegate$lambda$0$0$1$0((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        }, 1, null);
        HttpRequestRetryConfig.delayMillis$default(install, false, new Function2() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(NetworkClient.httpClient_delegate$lambda$0$0$1$1((HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        }, 1, null);
        HttpRequestRetryConfig.retryOnExceptionIf$default(install, 0, new Function3() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(NetworkClient.httpClient_delegate$lambda$0$0$1$2((HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean httpClient_delegate$lambda$0$0$1$0(HttpRetryShouldRetryContext retryIf, HttpRequest httpRequest, HttpResponse response) {
        Intrinsics.checkNotNullParameter(retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getStatus().getValue() == 429) {
            return true;
        }
        int value = response.getStatus().getValue();
        return 500 <= value && value < 600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long httpClient_delegate$lambda$0$0$1$1(HttpRetryDelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        long jLongValue = ((Number) NetworkClientKt.delays.get(i - 1)).longValue() * 1000;
        Logger_androidKt.getLogger().d("Retry Attempt " + i + " with Delay " + jLongValue);
        return jLongValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$2(ContentNegotiationConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        JsonSupportKt.json$default(install, JsonKt.Json$default(null, new Function1() { // from class: io.datazoom.sdk.network.NetworkClient$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$2$0((JsonBuilder) obj);
            }
        }, 1, null), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$2$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setPrettyPrint(true);
        Json.setLenient(true);
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$3(DefaultRequest.DefaultRequestBuilder install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        UtilsKt.header(install, "Content-Type", ContentType.Application.INSTANCE.getAny());
        return Unit.INSTANCE;
    }
}
