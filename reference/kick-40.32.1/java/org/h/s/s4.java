package org.h.s;

import android.content.Context;
import android.net.TrafficStats;
import io.mobileshield.sdk.ClientCallback;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class s4 {
    public static void a(HttpURLConnection urlConnection, ClientCallback callback, u uVar, r2 protectedConfig) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(protectedConfig, "protectedConfig");
        String host = urlConnection.getURL().getHost();
        if (uVar == null) {
            s3 s3Var = f1.f506a;
            f1.a(w0.U, "Token not available");
            callback.onError("Token not available");
            return;
        }
        if (!uVar.c()) {
            s3 s3Var2 = f1.f506a;
            f1.a(w0.U, "Token not ready");
            callback.onError("Token not ready");
            return;
        }
        String requestMethod = urlConnection.getRequestMethod();
        String host2 = urlConnection.getURL().getHost();
        String path = urlConnection.getURL().getPath();
        Intrinsics.checkNotNull(requestMethod);
        Intrinsics.checkNotNull(host2);
        Intrinsics.checkNotNull(path);
        if (protectedConfig.a(requestMethod, host2, path)) {
            s3 s3Var3 = f1.f506a;
            f1.a(w0.T, host);
            urlConnection.setRequestProperty("x-kpsdk-v", t4.a());
            for (Map.Entry entry : o0.a((Context) null, uVar).entrySet()) {
                urlConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        } else {
            s3 s3Var4 = f1.f506a;
            f1.a(w0.U, "url " + urlConnection.getURL() + " not valid");
        }
        TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
        callback.onComplete(urlConnection);
    }

    public static r a(HttpURLConnection urlConnection, i4 store) {
        int responseCode;
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(store, "store");
        String host = urlConnection.getURL().getHost();
        LocalLogger.log(8, 22006L, host);
        try {
            responseCode = urlConnection.getResponseCode();
        } catch (IOException e) {
            LocalLogger.log(2, 22012L, host + " msg - " + e.getMessage());
            responseCode = 0;
        }
        List<String> list = urlConnection.getHeaderFields().get("x-kpsdk-h");
        String str = list != null ? list.get(0) : null;
        List<String> list2 = urlConnection.getHeaderFields().get("x-kpsdk-fc");
        store.a(str, list2 != null ? list2.get(0) : null);
        List<String> list3 = urlConnection.getHeaderFields().get("x-kpsdk-c");
        String str2 = list3 != null ? (String) CollectionsKt.getOrNull(list3, 0) : null;
        List<String> list4 = urlConnection.getHeaderFields().get("x-kpsdk-ct");
        String str3 = list4 != null ? (String) CollectionsKt.getOrNull(list4, 0) : null;
        List<String> list5 = urlConnection.getHeaderFields().get("x-kpsdk-r");
        return new r(str3, list5 != null ? (String) CollectionsKt.getOrNull(list5, 0) : null, str2, responseCode);
    }
}
