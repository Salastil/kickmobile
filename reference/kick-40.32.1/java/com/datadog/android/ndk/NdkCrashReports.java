package com.datadog.android.ndk;

import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.ndk.internal.NdkCrashReportsFeature;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NdkCrashReports.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/ndk/NdkCrashReports;", "", "()V", "enable", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "dd-sdk-android-ndk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NdkCrashReports {
    public static final NdkCrashReports INSTANCE = new NdkCrashReports();

    @JvmStatic
    public static final void enable() {
        enable$default(null, 1, null);
    }

    private NdkCrashReports() {
    }

    public static /* synthetic */ void enable$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(sdkCore);
    }

    @JvmStatic
    public static final void enable(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        featureSdkCore.registerFeature(new NdkCrashReportsFeature(featureSdkCore));
    }
}
