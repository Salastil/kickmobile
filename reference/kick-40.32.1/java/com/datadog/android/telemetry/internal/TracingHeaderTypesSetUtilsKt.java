package com.datadog.android.telemetry.internal;

import com.datadog.android.internal.telemetry.TracingHeaderType;
import com.datadog.android.internal.telemetry.TracingHeaderTypesSet;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TracingHeaderTypesSetUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"toSelectedTracingPropagator", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SelectedTracingPropagator;", "Lcom/datadog/android/internal/telemetry/TracingHeaderType;", "toSelectedTracingPropagators", "", "Lcom/datadog/android/internal/telemetry/TracingHeaderTypesSet;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TracingHeaderTypesSetUtilsKt {

    /* JADX INFO: compiled from: TracingHeaderTypesSetUtils.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TracingHeaderType.values().length];
            try {
                iArr[TracingHeaderType.DATADOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TracingHeaderType.B3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TracingHeaderType.B3MULTI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TracingHeaderType.TRACECONTEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<TelemetryConfigurationEvent.SelectedTracingPropagator> toSelectedTracingPropagators(TracingHeaderTypesSet tracingHeaderTypesSet) {
        Intrinsics.checkNotNullParameter(tracingHeaderTypesSet, "<this>");
        Set<TracingHeaderType> types = tracingHeaderTypesSet.getTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(toSelectedTracingPropagator((TracingHeaderType) it.next()));
        }
        return arrayList;
    }

    private static final TelemetryConfigurationEvent.SelectedTracingPropagator toSelectedTracingPropagator(TracingHeaderType tracingHeaderType) {
        int i = WhenMappings.$EnumSwitchMapping$0[tracingHeaderType.ordinal()];
        if (i == 1) {
            return TelemetryConfigurationEvent.SelectedTracingPropagator.DATADOG;
        }
        if (i == 2) {
            return TelemetryConfigurationEvent.SelectedTracingPropagator.B3;
        }
        if (i == 3) {
            return TelemetryConfigurationEvent.SelectedTracingPropagator.B3MULTI;
        }
        if (i == 4) {
            return TelemetryConfigurationEvent.SelectedTracingPropagator.TRACECONTEXT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
