package com.datadog.reactnative;

import com.datadog.android.Datadog;
import com.datadog.android._InternalProxy;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdTelemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/reactnative/DdTelemetry;", "", "<init>", "()V", "telemetryProxy", "Lcom/datadog/android/_InternalProxy$_TelemetryProxy;", "getTelemetryProxy", "()Lcom/datadog/android/_InternalProxy$_TelemetryProxy;", "sendTelemetryLog", "", "message", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "Lcom/facebook/react/bridge/ReadableMap;", "config", "telemetryDebug", "telemetryError", "stack", "kind", RumFeature.EVENT_THROWABLE_PROPERTY, "", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdTelemetry {
    private _InternalProxy._TelemetryProxy telemetryProxy;

    static final String sendTelemetryLog$lambda$0(String str) {
        return str;
    }

    private final _InternalProxy._TelemetryProxy getTelemetryProxy() {
        if (this.telemetryProxy == null && Datadog.isInitialized$default(null, 1, null)) {
            this.telemetryProxy = Datadog._internalProxy$default(Datadog.INSTANCE, null, 1, null).get_telemetry();
        }
        return this.telemetryProxy;
    }

    public final void sendTelemetryLog(final String message, ReadableMap attributes, ReadableMap config) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(config, "config");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) Datadog.getInstance$default(null, 1, null);
        InternalLogger internalLogger = featureSdkCore != null ? featureSdkCore.getInternalLogger() : null;
        Map<String, Object> map = DdSdkBridgeExtKt.toMap(attributes);
        Map<String, Object> map2 = DdSdkBridgeExtKt.toMap(config);
        if (internalLogger != null) {
            InternalLogger.Level level = InternalLogger.Level.INFO;
            InternalLogger.Target target = InternalLogger.Target.TELEMETRY;
            Function0 function0 = new Function0() { // from class: com.datadog.reactnative.DdTelemetry$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DdTelemetry.sendTelemetryLog$lambda$0(message);
                }
            };
            Object obj = map2.get("onlyOnce");
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            InternalLogger.DefaultImpls.log$default(internalLogger, level, target, function0, (Throwable) null, bool != null ? bool.booleanValue() : true, map, 8, (Object) null);
        }
    }

    public final void telemetryDebug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.debug(message);
        }
    }

    public final void telemetryError(String message, String stack, String kind) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.error(message, stack, kind);
        }
    }

    public final void telemetryError(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        _InternalProxy._TelemetryProxy telemetryProxy = getTelemetryProxy();
        if (telemetryProxy != null) {
            telemetryProxy.error(message, throwable);
        }
    }
}
