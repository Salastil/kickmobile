package com.amazonaws.ivs.net;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class Response {
    private StreamConsumer consumer;
    private ExecutorService executorService;
    private final Map<String, String> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final int status;
    private final String url;

    Response(int i, String str) {
        this.status = i;
        this.url = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setConsumer(ExecutorService executorService, StreamConsumer streamConsumer) {
        this.executorService = executorService;
        this.consumer = streamConsumer;
    }

    public void setHeader(String str, String str2) {
        if (str != null) {
            this.headers.put(str, str2);
        }
    }

    public String getHeader(String str) {
        return this.headers.get(str);
    }

    public String getUrl() {
        return this.url;
    }

    public void readContent(final ReadCallback readCallback) {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.amazonaws.ivs.net.Response.1
                @Override // java.lang.Runnable
                public void run() {
                    Response.this.consumer.consume(readCallback);
                }
            });
        } else {
            this.consumer.consume(readCallback);
        }
    }
}
