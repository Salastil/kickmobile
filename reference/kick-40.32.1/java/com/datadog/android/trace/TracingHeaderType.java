package com.datadog.android.trace;

import kotlin.Metadata;

/* JADX INFO: compiled from: TracingHeaderType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/trace/TracingHeaderType;", "", "headerType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHeaderType", "()Ljava/lang/String;", "DATADOG", "B3", "B3MULTI", "TRACECONTEXT", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum TracingHeaderType {
    DATADOG("DATADOG"),
    B3("B3"),
    B3MULTI("B3MULTI"),
    TRACECONTEXT("TRACECONTEXT");

    private final String headerType;

    TracingHeaderType(String str) {
        this.headerType = str;
    }

    public final String getHeaderType() {
        return this.headerType;
    }
}
