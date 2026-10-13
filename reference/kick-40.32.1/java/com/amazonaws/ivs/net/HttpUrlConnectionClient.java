package com.amazonaws.ivs.net;

import android.util.Log;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
class HttpUrlConnectionClient implements HttpClient {
    private static final int BUFFER_SIZE = 16384;
    private static final int DEFAULT_CONNECT_TIMEOUT_MS = 10000;
    private static final int DEFAULT_READ_TIMEOUT_MS = 10000;
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    HttpUrlConnectionClient() {
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public String description() {
        return "HttpUrlConnection";
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public void release() {
        this.executor.shutdown();
    }

    @Override // com.amazonaws.ivs.net.HttpClient
    public void execute(Request request, ResponseCallback responseCallback) {
        if (((CookieManager) CookieHandler.getDefault()) == null) {
            Log.w("HttpUrlConnClient", "No default CookieManager set; will not send cookies");
        }
        executeAsync(request, responseCallback);
    }

    private void executeAsync(final Request request, final ResponseCallback responseCallback) {
        request.setFuture(this.executor.submit(new Runnable() { // from class: com.amazonaws.ivs.net.HttpUrlConnectionClient.1
            @Override // java.lang.Runnable
            public void run() {
                HttpUrlConnectionClient.this.executeSync(request, responseCallback);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSync(Request request, ResponseCallback responseCallback) {
        HttpURLConnection httpURLConnectionOpenConnection = null;
        try {
            httpURLConnectionOpenConnection = openConnection(request, request.getUrl());
            Response responseBlockingExecute = blockingExecute(httpURLConnectionOpenConnection, request, responseCallback);
            synchronized (request.lock()) {
                if (!request.isCancelled()) {
                    responseCallback.onResponse(responseBlockingExecute);
                }
            }
        } catch (IOException e) {
            disconnect(httpURLConnectionOpenConnection);
            e.printStackTrace();
            synchronized (request.lock()) {
                if (!request.isCancelled()) {
                    responseCallback.onError(e);
                }
            }
        }
    }

    private HttpURLConnection openConnection(Request request, String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private Response blockingExecute(final HttpURLConnection httpURLConnection, Request request, ResponseCallback responseCallback) throws IOException {
        String header;
        httpURLConnection.setRequestMethod(request.getMethod().toString().toUpperCase(Locale.ROOT));
        httpURLConnection.setInstanceFollowRedirects(false);
        if (request.getTimeout() > 0) {
            httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(request.getTimeout()));
            httpURLConnection.setReadTimeout(10000);
        } else {
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
        }
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        writeRequestContent(httpURLConnection, request, responseCallback);
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        Response response = new Response(responseCode, httpURLConnection.getURL().toString());
        for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
            List<String> value = entry2.getValue();
            if (!value.isEmpty()) {
                response.setHeader(entry2.getKey(), UByte$$ExternalSyntheticBackport0.m((CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (Iterable) value));
            }
        }
        if ((responseCode == 302 || responseCode == 301 || responseCode == 307) && (header = response.getHeader("Location")) != null) {
            if (request.getContent() != null) {
                request.getContent().rewind();
            }
            disconnect(httpURLConnection);
            return blockingExecute(openConnection(request, header), request, responseCallback);
        }
        response.setConsumer(this.executor, new InputStreamConsumer(request, new InputStreamConsumer.Provider() { // from class: com.amazonaws.ivs.net.HttpUrlConnectionClient.2
            @Override // com.amazonaws.ivs.net.InputStreamConsumer.Provider
            public InputStream getInputStream(int i) throws IOException {
                if (i > 0) {
                    httpURLConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(i));
                }
                InputStream errorStream = httpURLConnection.getErrorStream();
                return errorStream == null ? httpURLConnection.getInputStream() : errorStream;
            }
        }));
        return response;
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void disconnect(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void writeRequestContent(HttpURLConnection httpURLConnection, Request request, ResponseCallback responseCallback) throws IOException {
        if (request.getContent() != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                try {
                    Channels.newChannel(outputStream).write(request.getContent());
                    close(outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    synchronized (request.lock()) {
                        if (!request.isCancelled()) {
                            responseCallback.onError(e);
                        }
                        close(outputStream);
                    }
                }
            } catch (Throwable th) {
                close(outputStream);
                throw th;
            }
        }
    }
}
