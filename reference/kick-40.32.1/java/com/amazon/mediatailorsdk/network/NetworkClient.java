package com.amazon.mediatailorsdk.network;

import com.amazon.mediatailorsdk.Platform_androidKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\u00020\u00058@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/amazon/mediatailorsdk/network/NetworkClient;", "", "<init>", "()V", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient$annotations", "getHttpClient", "()Lio/ktor/client/HttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetworkClient {
    public static final int MAX_RETRY = 7;
    public static final long REQUEST_TIMEOUT = 30000;

    /* JADX INFO: renamed from: httpClient$delegate, reason: from kotlin metadata */
    private final Lazy httpClient = LazyKt.lazy(new Function0() { // from class: com.amazon.mediatailorsdk.network.NetworkClient$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Network_androidKt.httpClient(new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClient$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NetworkClient.httpClient_delegate$lambda$0$0((HttpClientConfig) obj);
                }
            });
        }
    });

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String userAgent = "MediaTailorSDK/" + Platform_androidKt.getPlatform().getName();

    public static /* synthetic */ void getHttpClient$annotations() {
    }

    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/amazon/mediatailorsdk/network/NetworkClient$Companion;", "", "<init>", "()V", "REQUEST_TIMEOUT", "", "MAX_RETRY", "Lkotlin/UInt;", "I", "userAgent", "", "getUserAgent", "()Ljava/lang/String;", "setUserAgent", "(Ljava/lang/String;)V", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getUserAgent() {
            return NetworkClient.userAgent;
        }

        public final void setUserAgent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            NetworkClient.userAgent = str;
        }
    }

    public final HttpClient getHttpClient() {
        return (HttpClient) this.httpClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0(HttpClientConfig httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "$this$httpClient");
        httpClient.install(ContentNegotiationKt.getContentNegotiation(), new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClient$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$0((ContentNegotiationConfig) obj);
            }
        });
        httpClient.install(DefaultRequest.INSTANCE, new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClient$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$1((DefaultRequest.DefaultRequestBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$0(ContentNegotiationConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        JsonSupportKt.json$default(install, JsonKt.Json$default(null, new Function1() { // from class: com.amazon.mediatailorsdk.network.NetworkClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkClient.httpClient_delegate$lambda$0$0$0$0((JsonBuilder) obj);
            }
        }, 1, null), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$0$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setPrettyPrint(true);
        Json.setLenient(true);
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$1(DefaultRequest.DefaultRequestBuilder install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        UtilsKt.header(install, "Content-Type", ContentType.Application.INSTANCE.getAny());
        return Unit.INSTANCE;
    }
}
