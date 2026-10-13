package com.datadog.android.trace;

import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.internal.TracingFeature;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/Trace;", "", "()V", "enable", "", "traceConfiguration", "Lcom/datadog/android/trace/TraceConfiguration;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Trace {
    public static final Trace INSTANCE = new Trace();

    @JvmStatic
    public static final void enable(TraceConfiguration traceConfiguration) {
        Intrinsics.checkNotNullParameter(traceConfiguration, "traceConfiguration");
        enable$default(traceConfiguration, null, 2, null);
    }

    private Trace() {
    }

    public static /* synthetic */ void enable$default(TraceConfiguration traceConfiguration, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(traceConfiguration, sdkCore);
    }

    @JvmStatic
    public static final void enable(TraceConfiguration traceConfiguration, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(traceConfiguration, "traceConfiguration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        featureSdkCore.registerFeature(new TracingFeature(featureSdkCore, traceConfiguration.getCustomEndpointUrl$dd_sdk_android_trace_release(), traceConfiguration.getEventMapper$dd_sdk_android_trace_release(), traceConfiguration.getNetworkInfoEnabled$dd_sdk_android_trace_release()));
    }
}
