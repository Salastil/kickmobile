package com.datadog.trace.api;

/* JADX INFO: loaded from: classes6.dex */
final class NoOpStatsDClient implements StatsDClient {
    @Override // com.datadog.trace.api.StatsDClient, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void count(String str, long j, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void distribution(String str, double d, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void distribution(String str, long j, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void error(Exception exc) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void gauge(String str, double d, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void gauge(String str, long j, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public int getErrorCount() {
        return 0;
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void histogram(String str, double d, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void histogram(String str, long j, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void incrementCounter(String str, String... strArr) {
    }

    @Override // com.datadog.trace.api.StatsDClient
    public void serviceCheck(String str, String str2, String str3, String... strArr) {
    }

    NoOpStatsDClient() {
    }
}
