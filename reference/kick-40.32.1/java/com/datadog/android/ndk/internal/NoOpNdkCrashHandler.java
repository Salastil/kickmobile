package com.datadog.android.ndk.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpNdkCrashHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/datadog/android/ndk/internal/NoOpNdkCrashHandler;", "Lcom/datadog/android/ndk/internal/NdkCrashHandler;", "()V", "handleNdkCrash", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "prepareData", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpNdkCrashHandler implements NdkCrashHandler {
    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void handleNdkCrash(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void prepareData() {
    }
}
