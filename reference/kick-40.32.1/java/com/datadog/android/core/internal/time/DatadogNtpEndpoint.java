package com.datadog.android.core.internal.time;

import com.datadog.android.log.LogAttributes;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogNtpEndpoint.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/time/DatadogNtpEndpoint;", "", LogAttributes.HOST, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHost", "()Ljava/lang/String;", "NTP_0", "NTP_1", "NTP_2", "NTP_3", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum DatadogNtpEndpoint {
    NTP_0("0.datadog.pool.ntp.org"),
    NTP_1("1.datadog.pool.ntp.org"),
    NTP_2("2.datadog.pool.ntp.org"),
    NTP_3("3.datadog.pool.ntp.org");

    private final String host;

    DatadogNtpEndpoint(String str) {
        this.host = str;
    }

    public final String getHost() {
        return this.host;
    }
}
