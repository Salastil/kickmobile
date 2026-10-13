package com.datadog.android.flags;

import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.flags.internal.EvaluationsFeature;
import com.datadog.android.flags.internal.FlagsFeature;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Flags.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/datadog/android/flags/Flags;", "", "()V", "enable", "", "configuration", "Lcom/datadog/android/flags/FlagsConfiguration;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Flags {
    public static final Flags INSTANCE = new Flags();

    @JvmStatic
    public static final void enable() {
        enable$default(null, null, 3, null);
    }

    @JvmStatic
    public static final void enable(FlagsConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        enable$default(configuration, null, 2, null);
    }

    private Flags() {
    }

    public static /* synthetic */ void enable$default(FlagsConfiguration flagsConfiguration, SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            flagsConfiguration = FlagsConfiguration.INSTANCE.getDefault$dd_sdk_android_flags_release();
        }
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(flagsConfiguration, sdkCore);
    }

    @JvmStatic
    public static final void enable(FlagsConfiguration configuration, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (configuration.getTrackEvaluations$dd_sdk_android_flags_release()) {
            FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
            featureSdkCore.registerFeature(new EvaluationsFeature(featureSdkCore, configuration));
        }
        FeatureSdkCore featureSdkCore2 = (FeatureSdkCore) sdkCore;
        featureSdkCore2.registerFeature(new FlagsFeature(featureSdkCore2, configuration));
    }
}
