package com.datadog.android.internal.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultTimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/time/DefaultTimeProvider;", "Lcom/datadog/android/internal/time/BaseTimeProvider;", "()V", "getServerOffsetMillis", "", "getServerOffsetNanos", "getServerTimestampMillis", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultTimeProvider extends BaseTimeProvider {
    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerOffsetMillis() {
        return 0L;
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerOffsetNanos() {
        return 0L;
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerTimestampMillis() {
        return getDeviceTimestampMillis();
    }
}
