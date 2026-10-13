package com.kick.centrifugo;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CentrifugoAuthHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002JN\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032:\u0010\u0016\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00140\u0017J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/kick/centrifugo/CentrifugoAuthHandler;", "", "clientId", "", "connectionAuthUrl", "Lokhttp3/HttpUrl;", "channelAuthUrl", "baseHeaders", "", "<init>", "(Ljava/lang/String;Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;Ljava/util/Map;)V", "httpClient", "Lokhttp3/OkHttpClient;", "buildRequest", "Lokhttp3/Request;", "type", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lorg/json/JSONObject;", "parseResponse", "authorize", "", "channel", "completion", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "error", "token", "getBaseHeaders", "Companion", "kickcentrifugo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CentrifugoAuthHandler {
    private static final MediaType JSON_MEDIA_TYPE = MediaType.INSTANCE.get("application/json");
    private final Map<String, String> baseHeaders;
    private final HttpUrl channelAuthUrl;
    private final String clientId;
    private final HttpUrl connectionAuthUrl;
    private final OkHttpClient httpClient;

    public CentrifugoAuthHandler(String clientId, HttpUrl connectionAuthUrl, HttpUrl channelAuthUrl, Map<String, String> baseHeaders) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(connectionAuthUrl, "connectionAuthUrl");
        Intrinsics.checkNotNullParameter(channelAuthUrl, "channelAuthUrl");
        Intrinsics.checkNotNullParameter(baseHeaders, "baseHeaders");
        this.clientId = clientId;
        this.connectionAuthUrl = connectionAuthUrl;
        this.channelAuthUrl = channelAuthUrl;
        this.baseHeaders = baseHeaders;
        this.httpClient = new OkHttpClient();
    }

    private final Request buildRequest(String type, JSONObject body) {
        Request.Builder builderUrl = new Request.Builder().url(Intrinsics.areEqual(type, "connection") ? this.connectionAuthUrl : this.channelAuthUrl);
        for (Map.Entry<String, String> entry : this.baseHeaders.entrySet()) {
            builderUrl.header(entry.getKey(), entry.getValue());
        }
        builderUrl.header("Content-Type", "application/json");
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String string = body.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        builderUrl.post(companion.create(string, JSON_MEDIA_TYPE));
        return builderUrl.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseResponse(String body) throws JSONException {
        String string = new JSONObject(body).getJSONObject("data").getString("token");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static /* synthetic */ void authorize$default(CentrifugoAuthHandler centrifugoAuthHandler, String str, Function2 function2, int i, Object obj) throws JSONException {
        if ((i & 1) != 0) {
            str = null;
        }
        centrifugoAuthHandler.authorize(str, function2);
    }

    public final void authorize(String channel, final Function2<? super Throwable, ? super String, Unit> completion) throws JSONException {
        String str;
        Intrinsics.checkNotNullParameter(completion, "completion");
        JSONObject jSONObjectPut = new JSONObject().put("client_id", this.clientId);
        if (channel == null) {
            str = "connection";
        } else {
            str = "channel";
            jSONObjectPut.put("channel", channel);
        }
        Intrinsics.checkNotNull(jSONObjectPut);
        this.httpClient.newCall(buildRequest(str, jSONObjectPut)).enqueue(new Callback() { // from class: com.kick.centrifugo.CentrifugoAuthHandler.authorize.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                completion.invoke(e, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Response response2 = response;
                Function2<Throwable, String, Unit> function2 = completion;
                CentrifugoAuthHandler centrifugoAuthHandler = this;
                try {
                    Response response3 = response2;
                    if (!response3.isSuccessful()) {
                        function2.invoke(new Exception("BAD_RESPONSE_FROM_API"), null);
                        CloseableKt.closeFinally(response2, null);
                        return;
                    }
                    try {
                        ResponseBody responseBodyBody = response3.body();
                        String strString = responseBodyBody != null ? responseBodyBody.string() : null;
                        if (strString == null) {
                            strString = "";
                        }
                        function2.invoke(null, centrifugoAuthHandler.parseResponse(strString));
                    } catch (Exception e) {
                        function2.invoke(e, null);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(response2, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(response2, th);
                        throw th2;
                    }
                }
            }
        });
    }

    public final Map<String, String> getBaseHeaders() {
        return this.baseHeaders;
    }
}
