package com.datadog.android.rum.internal.startup;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumStartupScenario.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"appStartActivityOnCreateGapNs", "", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "getAppStartActivityOnCreateGapNs", "(Lcom/datadog/android/rum/internal/startup/RumStartupScenario;)Ljava/lang/Long;", "name", "", "getName", "(Lcom/datadog/android/rum/internal/startup/RumStartupScenario;)Ljava/lang/String;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RumStartupScenarioKt {
    public static final String getName(RumStartupScenario rumStartupScenario) {
        Intrinsics.checkNotNullParameter(rumStartupScenario, "<this>");
        if (rumStartupScenario instanceof RumStartupScenario.Cold) {
            return "cold";
        }
        if (rumStartupScenario instanceof RumStartupScenario.WarmAfterActivityDestroyed) {
            return "warm_after_activity_destroyed";
        }
        if (rumStartupScenario instanceof RumStartupScenario.WarmFirstActivity) {
            return "warm_first_activity";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Long getAppStartActivityOnCreateGapNs(RumStartupScenario rumStartupScenario) {
        Intrinsics.checkNotNullParameter(rumStartupScenario, "<this>");
        if (rumStartupScenario instanceof RumStartupScenario.Cold) {
            return Long.valueOf(((RumStartupScenario.Cold) rumStartupScenario).getAppStartActivityOnCreateGapNs());
        }
        if (rumStartupScenario instanceof RumStartupScenario.WarmFirstActivity) {
            return Long.valueOf(((RumStartupScenario.WarmFirstActivity) rumStartupScenario).getAppStartActivityOnCreateGapNs());
        }
        if (rumStartupScenario instanceof RumStartupScenario.WarmAfterActivityDestroyed) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
