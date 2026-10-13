package com.amazonaws.ivs.net;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Future;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public class Request {
    private Cancellable cancellable;
    private boolean cancelled;
    private ByteBuffer content;
    private Future<?> future;
    private final Method method;
    private WriteCallback streamCallback;
    private final String url;
    private final Map<String, String> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, String> queryParams = new HashMap();
    private int timeoutSeconds = 10;

    public interface Cancellable {
        void cancel();
    }

    Object lock() {
        return this;
    }

    public Request(String str, Method method) {
        this.url = str;
        this.method = method;
    }

    public Request(String str, String str2) {
        this.url = str;
        this.method = stringToMethod(str2);
    }

    public String getUrl() {
        try {
            URL url = new URL(this.url);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.queryParams.entrySet()) {
                arrayList.add(entry.getKey() + "=" + entry.getValue());
            }
            String query = url.getQuery();
            if (query != null) {
                for (String str : query.split("&")) {
                    String[] strArrSplit = str.split("=");
                    if (strArrSplit.length == 2 && !this.queryParams.containsKey(strArrSplit[0])) {
                        arrayList.add(str);
                    }
                }
            }
            String strM = UByte$$ExternalSyntheticBackport0.m((CharSequence) "&", (Iterable) arrayList);
            String path = url.getPath();
            if (!strM.isEmpty()) {
                path = (path + "?") + strM;
            }
            return new URL(url.getProtocol(), url.getHost(), url.getPort(), path).toString();
        } catch (MalformedURLException unused) {
            return this.url;
        }
    }

    public Method getMethod() {
        return this.method;
    }

    public ByteBuffer getContent() {
        return this.content;
    }

    public void setContent(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
        byteBufferAllocateDirect.put(byteBuffer);
        byteBufferAllocateDirect.rewind();
        this.content = byteBufferAllocateDirect;
    }

    public WriteCallback getContentCallback() {
        return this.streamCallback;
    }

    public void setContentCallback(WriteCallback writeCallback) {
        this.streamCallback = writeCallback;
    }

    public void setHeader(String str, String str2) {
        getHeaders().put(str, str2);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setQueryParam(String str, String str2) {
        getQueryParams().put(str, str2);
    }

    public Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public int getTimeout() {
        return this.timeoutSeconds;
    }

    public void setTimeout(int i) {
        this.timeoutSeconds = i;
    }

    void cancel() {
        synchronized (lock()) {
            this.cancelled = true;
            Future<?> future = this.future;
            if (future != null) {
                future.cancel(true);
            }
            Cancellable cancellable = this.cancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
        }
    }

    boolean isCancelled() {
        boolean z;
        synchronized (lock()) {
            z = this.cancelled;
        }
        return z;
    }

    public void setCancellable(Cancellable cancellable) {
        synchronized (lock()) {
            this.cancellable = cancellable;
        }
    }

    public void setFuture(Future<?> future) {
        synchronized (lock()) {
            this.future = future;
        }
    }

    private static Method stringToMethod(String str) {
        try {
            return Method.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return Method.GET;
        }
    }
}
