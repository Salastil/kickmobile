package com.datadog.android.rum.internal.instrumentation;

import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainLooperLongTaskStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy;", "Landroid/util/Printer;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "thresholdMs", "", "(J)V", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "state", "Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$DispatcherState;", "getThresholdMs$dd_sdk_android_rum_release", "()J", "thresholdNs", "equals", "", "other", "", "hashCode", "", "println", "", "message", "", "register", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "toString", "unregister", "Companion", "CompositePrinter", "DispatcherState", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MainLooperLongTaskStrategy implements Printer, TrackingStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long NOT_STARTED = Long.MAX_VALUE;
    private static final String PREFIX_END = "<<<<< Finished to ";
    private static final String PREFIX_START = ">>>>> Dispatching to ";
    private SdkCore sdkCore;
    private volatile DispatcherState state;
    private final long thresholdMs;
    private final long thresholdNs;

    public MainLooperLongTaskStrategy(long j) {
        this.thresholdMs = j;
        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
        this.thresholdNs = nanos;
        this.state = new DispatcherState(nanos);
    }

    /* JADX INFO: renamed from: getThresholdMs$dd_sdk_android_rum_release, reason: from getter */
    public final long getThresholdMs() {
        return this.thresholdMs;
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
        this.sdkCore = sdkCore;
        this.state = new DispatcherState(this.thresholdNs);
        CompositePrinter.INSTANCE.addPrinter(this);
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
        CompositePrinter.INSTANCE.removePrinter(this);
    }

    @Override // android.util.Printer
    public void println(String message) {
        SdkCore sdkCore;
        DispatcherState.LongTaskParameters longTaskParametersOnFinish;
        if (message == null || (sdkCore = this.sdkCore) == null) {
            return;
        }
        Companion companion = INSTANCE;
        if (sdkCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
            sdkCore = null;
        }
        Long deviceElapsedTimeNanos = companion.getDeviceElapsedTimeNanos(sdkCore);
        if (deviceElapsedTimeNanos != null) {
            long jLongValue = deviceElapsedTimeNanos.longValue();
            if (StringsKt.startsWith$default(message, PREFIX_START, false, 2, (Object) null)) {
                this.state.onStart(message, jLongValue);
                return;
            }
            if (!StringsKt.startsWith$default(message, PREFIX_END, false, 2, (Object) null) || (longTaskParametersOnFinish = this.state.onFinish(jLongValue)) == null) {
                return;
            }
            SdkCore sdkCore2 = this.sdkCore;
            if (sdkCore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
                sdkCore2 = null;
            }
            RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore2);
            AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
            if (advancedRumMonitor != null) {
                advancedRumMonitor.addLongTask(longTaskParametersOnFinish.getDurationNs(), longTaskParametersOnFinish.getTarget());
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy");
        return this.thresholdMs == ((MainLooperLongTaskStrategy) other).thresholdMs;
    }

    public int hashCode() {
        return Long.hashCode(this.thresholdMs);
    }

    public String toString() {
        return "MainLooperLongTaskStrategy(" + this.thresholdMs + ")";
    }

    /* JADX INFO: compiled from: MainLooperLongTaskStrategy.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0002¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$Companion;", "", "()V", "NOT_STARTED", "", "PREFIX_END", "", "PREFIX_START", "getDeviceElapsedTimeNanos", "Lcom/datadog/android/api/SdkCore;", "(Lcom/datadog/android/api/SdkCore;)Ljava/lang/Long;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Long getDeviceElapsedTimeNanos(SdkCore sdkCore) {
            TimeProvider timeProvider;
            FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
            if (featureSdkCore == null || (timeProvider = featureSdkCore.getTimeProvider()) == null) {
                return null;
            }
            return Long.valueOf(timeProvider.getDeviceElapsedTimeNanos());
        }
    }

    /* JADX INFO: compiled from: MainLooperLongTaskStrategy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$DispatcherState;", "", "thresholdNS", "", "(J)V", "message", "", "startUptimeNs", "onFinish", "Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$DispatcherState$LongTaskParameters;", "nowNs", "onStart", "", "LongTaskParameters", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DispatcherState {
        private String message = "";
        private long startUptimeNs = Long.MAX_VALUE;
        private final long thresholdNS;

        public DispatcherState(long j) {
            this.thresholdNS = j;
        }

        public final void onStart(String message, long nowNs) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            this.startUptimeNs = nowNs;
        }

        public final LongTaskParameters onFinish(long nowNs) {
            long j = this.startUptimeNs;
            if (j == Long.MAX_VALUE) {
                return null;
            }
            long j2 = nowNs - j;
            this.startUptimeNs = Long.MAX_VALUE;
            if (j2 <= this.thresholdNS) {
                return null;
            }
            return new LongTaskParameters(j2, StringsKt.removePrefix(this.message, (CharSequence) MainLooperLongTaskStrategy.PREFIX_START));
        }

        /* JADX INFO: compiled from: MainLooperLongTaskStrategy.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$DispatcherState$LongTaskParameters;", "", "durationNs", "", TypedValues.Attributes.S_TARGET, "", "(JLjava/lang/String;)V", "getDurationNs", "()J", "getTarget", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class LongTaskParameters {
            private final long durationNs;
            private final String target;

            public static /* synthetic */ LongTaskParameters copy$default(LongTaskParameters longTaskParameters, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = longTaskParameters.durationNs;
                }
                if ((i & 2) != 0) {
                    str = longTaskParameters.target;
                }
                return longTaskParameters.copy(j, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getDurationNs() {
                return this.durationNs;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTarget() {
                return this.target;
            }

            public final LongTaskParameters copy(long durationNs, String target) {
                Intrinsics.checkNotNullParameter(target, "target");
                return new LongTaskParameters(durationNs, target);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LongTaskParameters)) {
                    return false;
                }
                LongTaskParameters longTaskParameters = (LongTaskParameters) other;
                return this.durationNs == longTaskParameters.durationNs && Intrinsics.areEqual(this.target, longTaskParameters.target);
            }

            public int hashCode() {
                return (Long.hashCode(this.durationNs) * 31) + this.target.hashCode();
            }

            public String toString() {
                return "LongTaskParameters(durationNs=" + this.durationNs + ", target=" + this.target + ")";
            }

            public LongTaskParameters(long j, String target) {
                Intrinsics.checkNotNullParameter(target, "target");
                this.durationNs = j;
                this.target = target;
            }

            public final long getDurationNs() {
                return this.durationNs;
            }

            public final String getTarget() {
                return this.target;
            }
        }
    }

    /* JADX INFO: compiled from: MainLooperLongTaskStrategy.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$CompositePrinter;", "Landroid/util/Printer;", "()V", "printers", "", "[Landroid/util/Printer;", "registeredPrinters", "", "getRegisteredPrinters$dd_sdk_android_rum_release", "()Ljava/util/List;", "addPrinter", "", "printer", "println", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", "removePrinter", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CompositePrinter implements Printer {
        public static final CompositePrinter INSTANCE = new CompositePrinter();
        private static volatile Printer[] printers = new Printer[0];

        private CompositePrinter() {
        }

        public final List<Printer> getRegisteredPrinters$dd_sdk_android_rum_release() {
            return ArraysKt.toList(printers);
        }

        public final void addPrinter(Printer printer) {
            Intrinsics.checkNotNullParameter(printer, "printer");
            synchronized (this) {
                for (Printer printer2 : printers) {
                    if (printer2 == printer) {
                        return;
                    }
                }
                printers = (Printer[]) ArraysKt.plus(printers, printer);
                if (printers.length == 1) {
                    Looper.getMainLooper().setMessageLogging(this);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void removePrinter(Printer printer) {
            Intrinsics.checkNotNullParameter(printer, "printer");
            synchronized (this) {
                Printer[] printerArr = printers;
                ArrayList arrayList = new ArrayList();
                for (Printer printer2 : printerArr) {
                    if (printer2 != printer) {
                        arrayList.add(printer2);
                    }
                }
                printers = (Printer[]) arrayList.toArray(new Printer[0]);
                if (printers.length == 0) {
                    Looper.getMainLooper().setMessageLogging(null);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.util.Printer
        public void println(String x) {
            for (Printer printer : printers) {
                printer.println(x);
            }
        }
    }
}
