package com.amazonaws.ivs.net;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class HttpClientFactory {
    private static final String TAG = "AmazonIVSNet";
    private static HttpClientImplFactory httpClientImplFactory;

    /* JADX INFO: Access modifiers changed from: private */
    interface HttpClientImplFactory {
        HttpClient create();
    }

    public static HttpClient create() {
        return getHttpClientImplFactory().create();
    }

    private static synchronized HttpClientImplFactory getHttpClientImplFactory() {
        if (httpClientImplFactory == null) {
            httpClientImplFactory = loadHttpClient();
        }
        return httpClientImplFactory;
    }

    private static HttpClientImplFactory loadHttpClient() {
        try {
            Class.forName("okhttp3.OkHttpClient", false, HttpClientFactory.class.getClassLoader());
            return new HttpClientImplFactory() { // from class: com.amazonaws.ivs.net.HttpClientFactory$$ExternalSyntheticLambda0
                @Override // com.amazonaws.ivs.net.HttpClientFactory.HttpClientImplFactory
                public final HttpClient create() {
                    return HttpClientFactory.lambda$loadHttpClient$0();
                }
            };
        } catch (ClassNotFoundException unused) {
            return new HttpClientImplFactory() { // from class: com.amazonaws.ivs.net.HttpClientFactory$$ExternalSyntheticLambda1
                @Override // com.amazonaws.ivs.net.HttpClientFactory.HttpClientImplFactory
                public final HttpClient create() {
                    return HttpClientFactory.lambda$loadHttpClient$1();
                }
            };
        }
    }

    static /* synthetic */ HttpClient lambda$loadHttpClient$0() {
        Log.i(TAG, "create OkHttpClient");
        return new OkHttpClient();
    }

    static /* synthetic */ HttpClient lambda$loadHttpClient$1() {
        Log.i(TAG, "create HttpUrlConnectionClient");
        return new HttpUrlConnectionClient();
    }

    private HttpClientFactory() {
    }
}
