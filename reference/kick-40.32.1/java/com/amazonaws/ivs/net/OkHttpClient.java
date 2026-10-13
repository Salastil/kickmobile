package com.amazonaws.ivs.net;

import android.util.Log;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.UByte$$ExternalSyntheticBackport0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes5.dex */
class OkHttpClient implements HttpClient {
    private static boolean isHttpRedirectCode(int i) {
        return i == 301 || i == 302 || i == 307;
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public void release() {
    }

    OkHttpClient() {
    }

    private static class Holder {
        static final okhttp3.OkHttpClient client = createClient();
        private static String description = detectOkHttp3Version();

        private Holder() {
        }

        private static okhttp3.OkHttpClient createClient() {
            okhttp3.OkHttpClient.Builder builderFollowRedirects = new okhttp3.OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).protocols(Collections.singletonList(Protocol.HTTP_1_1)).followRedirects(false);
            try {
                CookieHandler cookieHandler = CookieHandler.getDefault();
                if (!(cookieHandler instanceof CookieManager)) {
                    Log.w("OkHttpClient", "No default CookieManager set; will not send cookies");
                } else {
                    Object objNewInstance = Class.forName("okhttp3.JavaNetCookieJar").getConstructor(CookieHandler.class).newInstance(cookieHandler);
                    builderFollowRedirects.getClass().getMethod("cookieJar", Class.forName("okhttp3.CookieJar")).invoke(builderFollowRedirects, objNewInstance);
                }
            } catch (Exception unused) {
                Log.w("OkHttpClient", "Cannot set up cookies with okhttp; Cookies will not be automatically sent");
            }
            return builderFollowRedirects.build();
        }

        private static String detectOkHttp3Version() {
            try {
                return Class.forName("okhttp3.internal.Version", false, HttpClientFactory.class.getClassLoader()).getMethod("userAgent", null).invoke(null, null).toString();
            } catch (ClassNotFoundException unused) {
                return "okhttp3/4.12.0";
            } catch (Exception unused2) {
                return "okhttp3/unknown";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static okhttp3.OkHttpClient client() {
        return Holder.client;
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public String description() {
        return Holder.description;
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public void execute(Request request, ResponseCallback responseCallback) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        RequestBody requestBodyCreate = null;
        if (request.getContent() != null) {
            ByteBuffer content = request.getContent();
            byte[] bArr = new byte[content.remaining()];
            content.get(bArr);
            requestBodyCreate = RequestBody.create((MediaType) null, bArr);
        } else if (request.getMethod() == Method.POST) {
            requestBodyCreate = RequestBody.create((MediaType) null, new byte[0]);
        }
        builder.url(request.getUrl());
        builder.method(request.getMethod().toString().toUpperCase(Locale.ROOT), requestBodyCreate);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        execute(request, builder.build(), responseCallback);
    }

    private void execute(Request request, okhttp3.Request request2, ResponseCallback responseCallback) {
        final Call callNewCall = client().newCall(request2);
        request.setCancellable(new Request.Cancellable() { // from class: com.amazonaws.ivs.net.OkHttpClient.1
            @Override // com.amazonaws.ivs.net.Request.Cancellable
            public void cancel() {
                callNewCall.cancel();
            }
        });
        callNewCall.enqueue(new OkHttpResponseCallback(request, responseCallback));
    }

    class OkHttpResponseCallback implements Callback {
        private final ResponseCallback callback;
        private final Request request;

        OkHttpResponseCallback(Request request, ResponseCallback responseCallback) {
            this.request = request;
            this.callback = responseCallback;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
            synchronized (this.request.lock()) {
                if (!this.request.isCancelled()) {
                    this.callback.onError(iOException);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, final okhttp3.Response response) {
            synchronized (this.request.lock()) {
                if (!this.request.isCancelled()) {
                    Response response2 = new Response(response.code(), response.request().url().getUrl());
                    for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
                        List<String> value = entry.getValue();
                        if (!value.isEmpty()) {
                            response2.setHeader(entry.getKey(), UByte$$ExternalSyntheticBackport0.m((CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (Iterable) value));
                        }
                    }
                    if (OkHttpClient.this.handleRedirect(this.request, response, this.callback)) {
                        return;
                    }
                    response2.setConsumer(OkHttpClient.client().dispatcher().executorService(), new ByteBufferConsumer(this.request, new ByteBufferConsumer.Provider() { // from class: com.amazonaws.ivs.net.OkHttpClient.OkHttpResponseCallback.1
                        private BufferedSource source = null;

                        @Override // com.amazonaws.ivs.net.ByteBufferConsumer.Provider
                        public int writeTo(ByteBuffer byteBuffer) throws IOException {
                            return getSource().read(byteBuffer);
                        }

                        private BufferedSource getSource() throws IOException {
                            if (this.source == null) {
                                ResponseBody responseBodyBody = response.body();
                                if (responseBodyBody == null) {
                                    throw new IOException("No body");
                                }
                                this.source = responseBodyBody.source();
                            }
                            return this.source;
                        }
                    }));
                    this.callback.onResponse(response2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleRedirect(Request request, okhttp3.Response response, ResponseCallback responseCallback) {
        String strHeader;
        if (!isHttpRedirectCode(response.code())) {
            response = response.code() == 403 ? response.priorResponse() : null;
        }
        if (response == null || !isHttpRedirectCode(response.code()) || (strHeader = response.header("Location")) == null) {
            return false;
        }
        execute(request, response.request().newBuilder().url(HttpUrl.parse(strHeader)).build(), responseCallback);
        return true;
    }
}
