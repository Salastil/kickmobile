package com.datadog.android.core.internal.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppStartTimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/datadog/android/core/internal/time/AppStartTimeProvider;", "", "appStartTimeNs", "", "getAppStartTimeNs", "()J", "appUptimeNs", "getAppUptimeNs", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AppStartTimeProvider {
    long getAppStartTimeNs();

    long getAppUptimeNs();
}
