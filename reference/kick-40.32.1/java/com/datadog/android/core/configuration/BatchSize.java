package com.datadog.android.core.configuration;

import com.datadog.reactnative.DefaultConfiguration;
import kotlin.Metadata;

/* JADX INFO: compiled from: BatchSize.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/datadog/android/core/configuration/BatchSize;", "", "windowDurationMs", "", "(Ljava/lang/String;IJ)V", "getWindowDurationMs$dd_sdk_android_core_release", "()J", "SMALL", DefaultConfiguration.batchSize, "LARGE", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum BatchSize {
    SMALL(3000),
    MEDIUM(10000),
    LARGE(35000);

    private final long windowDurationMs;

    BatchSize(long j) {
        this.windowDurationMs = j;
    }

    /* JADX INFO: renamed from: getWindowDurationMs$dd_sdk_android_core_release, reason: from getter */
    public final long getWindowDurationMs() {
        return this.windowDurationMs;
    }
}
