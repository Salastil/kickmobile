package com.kick.mobile.kickivsplayerv2;

import com.google.android.gms.common.internal.ImagesContract;
import com.mux.stats.sdk.muxstats.INetworkRequest;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002J,\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J<\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J<\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J^\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f20\b\u0002\u0010\u0018\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001c\u0018\u00010\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsNetworkRequest;", "Lcom/mux/stats/sdk/muxstats/INetworkRequest;", "<init>", "()V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "get", "", ImagesContract.URL, "Ljava/net/URL;", "post", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lorg/json/JSONObject;", "headers", "Ljava/util/Hashtable;", "", "postWithCompletion", "domain", "envKey", "callback", "Lcom/mux/stats/sdk/muxstats/INetworkRequest$IMuxNetworkRequestsCompletion;", "Lcom/mux/stats/sdk/muxstats/INetworkRequest$IMuxNetworkRequestsCompletion2;", "createBeaconUrl", "onComplete", "Lkotlin/Function2;", "", "", "", "Companion", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class MuxAnalyticsNetworkRequest implements INetworkRequest {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int NETWORK_TIMEOUT_MS = 10000;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    @Override // com.mux.stats.sdk.muxstats.INetworkRequest
    public void get(final URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.executor.execute(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.MuxAnalyticsNetworkRequest$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                MuxAnalyticsNetworkRequest.get$lambda$0(url);
            }
        });
    }

    static final void get$lambda$0(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.getInputStream().close();
        httpURLConnection.disconnect();
    }

    @Override // com.mux.stats.sdk.muxstats.INetworkRequest
    public void post(URL url, JSONObject body, Hashtable<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String string = body.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        post(url, string, headers, null);
    }

    static final Unit postWithCompletion$lambda$0(INetworkRequest.IMuxNetworkRequestsCompletion iMuxNetworkRequestsCompletion, boolean z, Map map) {
        iMuxNetworkRequestsCompletion.onComplete(z);
        return Unit.INSTANCE;
    }

    @Override // com.mux.stats.sdk.muxstats.INetworkRequest
    public void postWithCompletion(String domain, String envKey, String body, Hashtable<String, String> headers, final INetworkRequest.IMuxNetworkRequestsCompletion callback) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(envKey, "envKey");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        post(createBeaconUrl(domain, envKey), body, headers, new Function2() { // from class: com.kick.mobile.kickivsplayerv2.MuxAnalyticsNetworkRequest$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MuxAnalyticsNetworkRequest.postWithCompletion$lambda$0(callback, ((Boolean) obj).booleanValue(), (Map) obj2);
            }
        });
    }

    @Override // com.mux.stats.sdk.muxstats.INetworkRequest
    public void postWithCompletion(String domain, String envKey, String body, Hashtable<String, String> headers, final INetworkRequest.IMuxNetworkRequestsCompletion2 callback) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(envKey, "envKey");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        post(createBeaconUrl(domain, envKey), body, headers, new Function2() { // from class: com.kick.mobile.kickivsplayerv2.MuxAnalyticsNetworkRequest$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MuxAnalyticsNetworkRequest.postWithCompletion$lambda$1(callback, ((Boolean) obj).booleanValue(), (Map) obj2);
            }
        });
    }

    static final Unit postWithCompletion$lambda$1(INetworkRequest.IMuxNetworkRequestsCompletion2 iMuxNetworkRequestsCompletion2, boolean z, Map map) {
        iMuxNetworkRequestsCompletion2.onComplete(z, map);
        return Unit.INSTANCE;
    }

    private final URL createBeaconUrl(String domain, String envKey) {
        if (StringsKt.startsWith$default(domain, ".", false, 2, (Object) null)) {
            domain = envKey + domain;
        }
        return new URL("https://" + domain + "/e");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void post$default(MuxAnalyticsNetworkRequest muxAnalyticsNetworkRequest, URL url, String str, Hashtable hashtable, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        muxAnalyticsNetworkRequest.post(url, str, hashtable, function2);
    }

    private final void post(final URL url, final String body, final Hashtable<String, String> headers, final Function2<? super Boolean, ? super Map<String, ? extends List<String>>, Unit> onComplete) {
        this.executor.execute(new Runnable() { // from class: com.kick.mobile.kickivsplayerv2.MuxAnalyticsNetworkRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MuxAnalyticsNetworkRequest.post$lambda$0(this.f$0, onComplete, url, headers, body);
            }
        });
    }

    static final void post$lambda$0(MuxAnalyticsNetworkRequest muxAnalyticsNetworkRequest, Function2 function2, URL url, Hashtable hashtable, String str) {
        Object objM12684constructorimpl;
        Map<String, List<String>> headerFields = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            boolean z = true;
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            for (Map.Entry entry : hashtable.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            try {
                outputStreamWriter.write(str);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStreamWriter, null);
                int responseCode = httpURLConnection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    z = false;
                }
                headerFields = httpURLConnection.getHeaderFields();
                httpURLConnection.disconnect();
                objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(z));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStreamWriter, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = false;
        }
        Boolean bool = (Boolean) objM12684constructorimpl;
        bool.booleanValue();
        if (function2 != null) {
            function2.invoke(bool, headerFields);
        }
    }

    /* JADX INFO: compiled from: MuxAnalyticsListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsNetworkRequest$Companion;", "", "<init>", "()V", "NETWORK_TIMEOUT_MS", "", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
