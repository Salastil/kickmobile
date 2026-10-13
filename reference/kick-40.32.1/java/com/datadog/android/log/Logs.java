package com.datadog.android.log;

import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.log.internal.LogsFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/log/Logs;", "", "()V", "LOGS_NOT_ENABLED_MESSAGE", "", "addAttribute", "", "key", "value", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "enable", "logsConfiguration", "Lcom/datadog/android/log/LogsConfiguration;", "isEnabled", "", "removeAttribute", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Logs {
    public static final Logs INSTANCE = new Logs();
    public static final String LOGS_NOT_ENABLED_MESSAGE = "You're trying to add attributes to logs, but the feature is not enabled. Please enable it first.";

    @JvmStatic
    public static final void addAttribute(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        addAttribute$default(key, obj, null, 4, null);
    }

    @JvmStatic
    public static final void enable(LogsConfiguration logsConfiguration) {
        Intrinsics.checkNotNullParameter(logsConfiguration, "logsConfiguration");
        enable$default(logsConfiguration, null, 2, null);
    }

    @JvmStatic
    public static final boolean isEnabled() {
        return isEnabled$default(null, 1, null);
    }

    @JvmStatic
    public static final void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        removeAttribute$default(key, null, 2, null);
    }

    private Logs() {
    }

    public static /* synthetic */ void enable$default(LogsConfiguration logsConfiguration, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(logsConfiguration, sdkCore);
    }

    @JvmStatic
    public static final void enable(LogsConfiguration logsConfiguration, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(logsConfiguration, "logsConfiguration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        featureSdkCore.registerFeature(new LogsFeature(featureSdkCore, logsConfiguration.getCustomEndpointUrl$dd_sdk_android_logs_release(), logsConfiguration.getEventMapper$dd_sdk_android_logs_release()));
    }

    public static /* synthetic */ boolean isEnabled$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return isEnabled(sdkCore);
    }

    @JvmStatic
    public static final boolean isEnabled(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        return ((FeatureSdkCore) sdkCore).getFeature("logs") != null;
    }

    public static /* synthetic */ void addAttribute$default(String str, Object obj, SdkCore sdkCore, int i, Object obj2) {
        if ((i & 4) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        addAttribute(str, obj, sdkCore);
    }

    @JvmStatic
    public static final void addAttribute(String key, Object value, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        FeatureScope feature = featureSdkCore.getFeature("logs");
        LogsFeature logsFeature = feature != null ? (LogsFeature) feature.unwrap() : null;
        if (logsFeature == null) {
            InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.Logs.addAttribute.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Logs.LOGS_NOT_ENABLED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            logsFeature.addAttribute$dd_sdk_android_logs_release(key, value);
        }
    }

    public static /* synthetic */ void removeAttribute$default(String str, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        removeAttribute(str, sdkCore);
    }

    @JvmStatic
    public static final void removeAttribute(String key, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        FeatureScope feature = featureSdkCore.getFeature("logs");
        LogsFeature logsFeature = feature != null ? (LogsFeature) feature.unwrap() : null;
        if (logsFeature == null) {
            InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.Logs.removeAttribute.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Logs.LOGS_NOT_ENABLED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            logsFeature.removeAttribute$dd_sdk_android_logs_release(key);
        }
    }
}
