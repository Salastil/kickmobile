package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumSessionTypeExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000¨\u0006\u0013"}, d2 = {"toAction", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventSessionType;", "Lcom/datadog/android/rum/RumSessionType;", "toError", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSessionType;", "toLongTask", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;", "toResource", "Lcom/datadog/android/rum/model/ResourceEvent$ResourceEventSessionType;", "toTimeseriesCpuSessionType", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$TimeseriesCpuEventSessionType;", "toTimeseriesMemorySessionType", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$TimeseriesMemoryEventSessionType;", "toView", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;", "toVital", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$VitalOperationStepEventSessionType;", "toVitalAppLaunch", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RumSessionTypeExtKt {

    /* JADX INFO: compiled from: RumSessionTypeExt.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RumSessionType.values().length];
            try {
                iArr[RumSessionType.SYNTHETICS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RumSessionType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ActionEvent.ActionEventSessionType toAction(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ActionEvent.ActionEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ActionEvent.ActionEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ResourceEvent.ResourceEventSessionType toResource(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ResourceEvent.ResourceEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ResourceEvent.ResourceEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ErrorEvent.ErrorEventSessionType toError(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ErrorEvent.ErrorEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ErrorEvent.ErrorEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ViewEvent.ViewEventSessionType toView(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ViewEvent.ViewEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ViewEvent.ViewEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final LongTaskEvent.LongTaskEventSessionType toLongTask(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return LongTaskEvent.LongTaskEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return LongTaskEvent.LongTaskEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VitalOperationStepEvent.VitalOperationStepEventSessionType toVital(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return VitalOperationStepEvent.VitalOperationStepEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return VitalOperationStepEvent.VitalOperationStepEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VitalAppLaunchEvent.VitalAppLaunchEventSessionType toVitalAppLaunch(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return VitalAppLaunchEvent.VitalAppLaunchEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return VitalAppLaunchEvent.VitalAppLaunchEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TimeseriesMemoryEvent.TimeseriesMemoryEventSessionType toTimeseriesMemorySessionType(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return TimeseriesMemoryEvent.TimeseriesMemoryEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return TimeseriesMemoryEvent.TimeseriesMemoryEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TimeseriesCpuEvent.TimeseriesCpuEventSessionType toTimeseriesCpuSessionType(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return TimeseriesCpuEvent.TimeseriesCpuEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return TimeseriesCpuEvent.TimeseriesCpuEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }
}
