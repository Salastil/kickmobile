package com.datadog.android;

import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.DatadogCore;
import com.datadog.android.core.internal.system.AppVersionProvider;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _InternalProxy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\u0005\u001a\u00020\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/_InternalProxy;", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Lcom/datadog/android/api/SdkCore;)V", "_telemetry", "Lcom/datadog/android/_InternalProxy$_TelemetryProxy;", "get_telemetry$annotations", "()V", "get_telemetry", "()Lcom/datadog/android/_InternalProxy$_TelemetryProxy;", "flushAndShutdownExecutors", "", "setCustomAppVersion", "version", "", "setMetricTelemetrySampleRateBypass", "sampleRate", "", "Companion", "_TelemetryProxy", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class _InternalProxy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final _TelemetryProxy _telemetry;
    private final SdkCore sdkCore;

    public static /* synthetic */ void get_telemetry$annotations() {
    }

    public _InternalProxy(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
        this._telemetry = new _TelemetryProxy(sdkCore);
    }

    /* JADX INFO: compiled from: _InternalProxy.kt */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/_InternalProxy$_TelemetryProxy;", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Lcom/datadog/android/api/SdkCore;)V", "rumFeature", "Lcom/datadog/android/api/feature/FeatureScope;", "getRumFeature", "()Lcom/datadog/android/api/feature/FeatureScope;", "debug", "", "message", "", "error", "stack", "kind", RumFeature.EVENT_THROWABLE_PROPERTY, "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class _TelemetryProxy {
        private final SdkCore sdkCore;

        public _TelemetryProxy(SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            this.sdkCore = sdkCore;
        }

        private final FeatureScope getRumFeature() {
            SdkCore sdkCore = this.sdkCore;
            FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
            if (featureSdkCore != null) {
                return featureSdkCore.getFeature("rum");
            }
            return null;
        }

        public final void debug(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Debug debug = new InternalTelemetryEvent.Log.Debug(message, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(debug);
            }
        }

        public static /* synthetic */ void error$default(_TelemetryProxy _telemetryproxy, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            _telemetryproxy.error(str, th);
        }

        public final void error(String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Error error = new InternalTelemetryEvent.Log.Error(message, null, throwable, null, null, 26, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(error);
            }
        }

        public final void error(String message, String stack, String kind) {
            Intrinsics.checkNotNullParameter(message, "message");
            InternalTelemetryEvent.Log.Error error = new InternalTelemetryEvent.Log.Error(message, null, null, stack, kind, 6, null);
            FeatureScope rumFeature = getRumFeature();
            if (rumFeature != null) {
                rumFeature.sendEvent(error);
            }
        }
    }

    public final _TelemetryProxy get_telemetry() {
        return this._telemetry;
    }

    public final void setMetricTelemetrySampleRateBypass(float sampleRate) {
        SdkCore sdkCore = this.sdkCore;
        DatadogCore datadogCore = sdkCore instanceof DatadogCore ? (DatadogCore) sdkCore : null;
        CoreFeature coreFeature$dd_sdk_android_core_release = datadogCore != null ? datadogCore.getCoreFeature$dd_sdk_android_core_release() : null;
        if (coreFeature$dd_sdk_android_core_release == null) {
            return;
        }
        coreFeature$dd_sdk_android_core_release.setMetricTelemetrySampleRateBypass$dd_sdk_android_core_release(Float.valueOf(sampleRate));
    }

    public final void setCustomAppVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        SdkCore sdkCore = this.sdkCore;
        DatadogCore datadogCore = sdkCore instanceof DatadogCore ? (DatadogCore) sdkCore : null;
        CoreFeature coreFeature$dd_sdk_android_core_release = datadogCore != null ? datadogCore.getCoreFeature$dd_sdk_android_core_release() : null;
        AppVersionProvider packageVersionProvider$dd_sdk_android_core_release = coreFeature$dd_sdk_android_core_release != null ? coreFeature$dd_sdk_android_core_release.getPackageVersionProvider() : null;
        if (packageVersionProvider$dd_sdk_android_core_release == null) {
            return;
        }
        packageVersionProvider$dd_sdk_android_core_release.setVersion(version);
    }

    public final void flushAndShutdownExecutors() {
        Datadog.INSTANCE.flushAndShutdownExecutors$dd_sdk_android_core_release();
    }

    /* JADX INFO: compiled from: _InternalProxy.kt */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/_InternalProxy$Companion;", "", "()V", "allowClearTextHttp", "Lcom/datadog/android/core/configuration/Configuration$Builder;", "builder", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Configuration.Builder allowClearTextHttp(Configuration.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return builder.allowClearTextHttp$dd_sdk_android_core_release();
        }
    }
}
