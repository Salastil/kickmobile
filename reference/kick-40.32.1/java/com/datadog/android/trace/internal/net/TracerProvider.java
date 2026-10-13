package com.datadog.android.trace.internal.net;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.InternalLoggerKt;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TracerProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B7\b\u0000\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0012R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/trace/internal/net/TracerProvider;", "", "localTracerFactory", "Lkotlin/Function2;", "Lcom/datadog/android/api/SdkCore;", "", "Lcom/datadog/android/trace/TracingHeaderType;", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "globalTracerProvider", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "localTracerReference", "Ljava/util/concurrent/atomic/AtomicReference;", "provideTracer", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "localHeaderTypes", "networkingLibraryName", "", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TracerProvider {
    public static final String WARNING_DEFAULT_TRACER = "You added a ApmNetworkInstrumentation to your %s instrumentation, but you didn't register any DatadogTracer. We automatically created a local tracer for you.";
    public static final String WARNING_TRACING_DISABLED = "You added a ApmNetworkInstrumentation to your %s, but you did not enable the TracingFeature. Your requests won't be traced.";
    private final Function0<DatadogTracer> globalTracerProvider;
    private final Function2<SdkCore, Set<? extends TracingHeaderType>, DatadogTracer> localTracerFactory;
    private final AtomicReference<DatadogTracer> localTracerReference;

    /* JADX WARN: Multi-variable type inference failed */
    public TracerProvider(Function2<? super SdkCore, ? super Set<? extends TracingHeaderType>, ? extends DatadogTracer> localTracerFactory, Function0<? extends DatadogTracer> globalTracerProvider) {
        Intrinsics.checkNotNullParameter(localTracerFactory, "localTracerFactory");
        Intrinsics.checkNotNullParameter(globalTracerProvider, "globalTracerProvider");
        this.localTracerFactory = localTracerFactory;
        this.globalTracerProvider = globalTracerProvider;
        this.localTracerReference = new AtomicReference<>();
    }

    public final synchronized DatadogTracer provideTracer(InternalSdkCore sdkCore, Set<? extends TracingHeaderType> localHeaderTypes, final String networkingLibraryName) {
        DatadogTracer datadogTracerInvoke;
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(localHeaderTypes, "localHeaderTypes");
        Intrinsics.checkNotNullParameter(networkingLibraryName, "networkingLibraryName");
        FeatureScope feature = sdkCore.getFeature("tracing");
        datadogTracerInvoke = this.globalTracerProvider.invoke();
        if (feature == null) {
            InternalLoggerKt.logToUser(sdkCore.getInternalLogger(), InternalLogger.Level.WARN, true, new Function0<String>() { // from class: com.datadog.android.trace.internal.net.TracerProvider.provideTracer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, TracerProvider.WARNING_TRACING_DISABLED, Arrays.copyOf(new Object[]{networkingLibraryName}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            });
            datadogTracerInvoke = null;
        } else {
            AtomicReference<DatadogTracer> atomicReference = this.localTracerReference;
            if (datadogTracerInvoke != null) {
                atomicReference.set(null);
            } else {
                if (atomicReference.get() == null) {
                    PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.localTracerReference, null, this.localTracerFactory.invoke(sdkCore, SetsKt.plus((Set) localHeaderTypes, (Iterable) sdkCore.getFirstPartyHostResolver().getAllHeaderTypes())));
                    InternalLoggerKt.logToUser$default(sdkCore.getInternalLogger(), InternalLogger.Level.WARN, false, new Function0<String>() { // from class: com.datadog.android.trace.internal.net.TracerProvider.provideTracer.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, TracerProvider.WARNING_DEFAULT_TRACER, Arrays.copyOf(new Object[]{networkingLibraryName}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, 2, null);
                }
                datadogTracerInvoke = this.localTracerReference.get();
            }
        }
        return datadogTracerInvoke;
    }
}
