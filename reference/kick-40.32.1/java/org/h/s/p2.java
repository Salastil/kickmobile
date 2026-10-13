package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.MobileShield;
import io.mobileshield.sdk.config.Config;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes9.dex */
public final class p2 {
    public static void a(String url, String str, Map map, Callback responseHandler, int i) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        OkHttpClient clientCall = (i & 16) != 0 ? new OkHttpClient.Builder().addNetworkInterceptor(MobileShield.obtainInterceptor()).build() : null;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
        Intrinsics.checkNotNullParameter(clientCall, "clientCall");
        try {
            Request.Builder builderUrl = new Request.Builder().url(url);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    builderUrl.header((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (str != null) {
                builderUrl.post(RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json; charset=utf-8")));
            }
            clientCall.newCall(builderUrl.build()).enqueue(responseHandler);
        } catch (Exception unused) {
        }
    }

    public static String a(Config config, String str) {
        String str2;
        String domain = config.getDomain();
        int port = config.getPort();
        String formattedProtocol = config.getFormattedProtocol();
        if (port > 0) {
            str2 = ServerSentEventKt.COLON + port;
        } else {
            str2 = "";
        }
        return formattedProtocol + domain + str2 + str;
    }
}
