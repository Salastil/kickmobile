package com.datadog.android.core.internal.system;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpSystemInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/datadog/android/core/internal/system/NoOpSystemInfoProvider;", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "()V", "getLatestSystemInfo", "Lcom/datadog/android/core/internal/system/SystemInfo;", "register", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "unregister", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpSystemInfoProvider implements SystemInfoProvider {
    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public SystemInfo getLatestSystemInfo() {
        return new SystemInfo(false, 0, false, false, 15, null);
    }
}
