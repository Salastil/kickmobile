package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.rum.model.VitalAppLaunchEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: RumVitalAppLaunchEventHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"vitalName", "", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RumVitalAppLaunchEventHelperKt {

    /* JADX INFO: compiled from: RumVitalAppLaunchEventHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VitalAppLaunchEvent.AppLaunchMetric.values().length];
            try {
                iArr[VitalAppLaunchEvent.AppLaunchMetric.TTID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VitalAppLaunchEvent.AppLaunchMetric.TTFD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String vitalName(VitalAppLaunchEvent.AppLaunchMetric appLaunchMetric) {
        int i = WhenMappings.$EnumSwitchMapping$0[appLaunchMetric.ordinal()];
        if (i == 1) {
            return "time_to_initial_display";
        }
        if (i == 2) {
            return "time_to_full_display";
        }
        throw new NoWhenBranchMatchedException();
    }
}
