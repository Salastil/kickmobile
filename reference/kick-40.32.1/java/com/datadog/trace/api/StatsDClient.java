package com.datadog.trace.api;

import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public interface StatsDClient extends Closeable {
    public static final StatsDClient NO_OP = new NoOpStatsDClient();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void count(String str, long j, String... strArr);

    void distribution(String str, double d, String... strArr);

    void distribution(String str, long j, String... strArr);

    void error(Exception exc);

    void gauge(String str, double d, String... strArr);

    void gauge(String str, long j, String... strArr);

    int getErrorCount();

    void histogram(String str, double d, String... strArr);

    void histogram(String str, long j, String... strArr);

    void incrementCounter(String str, String... strArr);

    void serviceCheck(String str, String str2, String str3, String... strArr);
}
