package com.datadog.android.rum;

import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.monitor.NoOpAdvancedRumMonitor;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0012\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0007J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\nH\u0003J\u0017\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/GlobalRumMonitor;", "", "()V", "NO_MONITOR_REGISTERED_MESSAGE", "", "registeredMonitors", "", "Lcom/datadog/android/api/SdkCore;", "Lcom/datadog/android/rum/RumMonitor;", "clear", "", "clear$dd_sdk_android_rum_release", "get", "sdkCore", "isRegistered", "", "registerIfAbsent", "monitor", "registerIfAbsent$dd_sdk_android_rum_release", "reset", "unregister", "unregister$dd_sdk_android_rum_release", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalRumMonitor {
    public static final String NO_MONITOR_REGISTERED_MESSAGE = "No RumMonitor for the SDK instance with name %s found, returning no-op implementation.";
    public static final GlobalRumMonitor INSTANCE = new GlobalRumMonitor();
    private static final Map<SdkCore, RumMonitor> registeredMonitors = new LinkedHashMap();

    @JvmStatic
    public static final RumMonitor get() {
        return get$default(null, 1, null);
    }

    @JvmStatic
    public static final boolean isRegistered() {
        return isRegistered$default(null, 1, null);
    }

    private GlobalRumMonitor() {
    }

    public static /* synthetic */ boolean isRegistered$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return isRegistered(sdkCore);
    }

    @JvmStatic
    public static final boolean isRegistered(SdkCore sdkCore) {
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map<SdkCore, RumMonitor> map = registeredMonitors;
        synchronized (map) {
            zContainsKey = map.containsKey(sdkCore);
        }
        return zContainsKey;
    }

    public static /* synthetic */ RumMonitor get$default(SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return get(sdkCore);
    }

    @JvmStatic
    public static final RumMonitor get(final SdkCore sdkCore) {
        NoOpAdvancedRumMonitor noOpAdvancedRumMonitor;
        InternalLogger internalLogger;
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map<SdkCore, RumMonitor> map = registeredMonitors;
        synchronized (map) {
            noOpAdvancedRumMonitor = map.get(sdkCore);
            if (noOpAdvancedRumMonitor == null) {
                FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
                if (featureSdkCore != null && (internalLogger = featureSdkCore.getInternalLogger()) != null) {
                    InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.GlobalRumMonitor$get$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, GlobalRumMonitor.NO_MONITOR_REGISTERED_MESSAGE, Arrays.copyOf(new Object[]{sdkCore.getName()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                }
                noOpAdvancedRumMonitor = new NoOpAdvancedRumMonitor();
            }
        }
        return noOpAdvancedRumMonitor;
    }

    public static /* synthetic */ boolean registerIfAbsent$dd_sdk_android_rum_release$default(GlobalRumMonitor globalRumMonitor, RumMonitor rumMonitor, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return globalRumMonitor.registerIfAbsent$dd_sdk_android_rum_release(rumMonitor, sdkCore);
    }

    public final boolean registerIfAbsent$dd_sdk_android_rum_release(RumMonitor monitor, SdkCore sdkCore) {
        boolean z;
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map<SdkCore, RumMonitor> map = registeredMonitors;
        synchronized (map) {
            if (map.containsKey(sdkCore)) {
                InternalLogger.DefaultImpls.log$default(((FeatureSdkCore) sdkCore).getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.GlobalRumMonitor$registerIfAbsent$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "A RumMonitor has already been registered for this SDK instance";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                z = false;
            } else {
                map.put(sdkCore, monitor);
                z = true;
            }
        }
        return z;
    }

    public static /* synthetic */ void unregister$dd_sdk_android_rum_release$default(GlobalRumMonitor globalRumMonitor, SdkCore sdkCore, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        globalRumMonitor.unregister$dd_sdk_android_rum_release(sdkCore);
    }

    public final void unregister$dd_sdk_android_rum_release(SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Map<SdkCore, RumMonitor> map = registeredMonitors;
        synchronized (map) {
            map.remove(sdkCore);
        }
    }

    public final void clear$dd_sdk_android_rum_release() {
        Map<SdkCore, RumMonitor> map = registeredMonitors;
        synchronized (map) {
            map.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    private static final void reset() {
        INSTANCE.clear$dd_sdk_android_rum_release();
    }
}
