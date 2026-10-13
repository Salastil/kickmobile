package com.datadog.android.core.internal.system;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.receiver.ThreadSafeReceiver;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BroadcastReceiverSystemInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/core/internal/system/BroadcastReceiverSystemInfoProvider;", "Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "handler", "Landroid/os/Handler;", "(Lcom/datadog/android/api/InternalLogger;Landroid/os/Handler;)V", "systemInfo", "Lcom/datadog/android/core/internal/system/SystemInfo;", "getLatestSystemInfo", "handleBatteryIntent", "", "intent", "Landroid/content/Intent;", "handlePowerSaveIntent", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "onReceive", "register", "registerIntentFilter", "action", "", "unregister", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BroadcastReceiverSystemInfoProvider extends ThreadSafeReceiver implements SystemInfoProvider {
    private static final int BATTERY_LEVEL_UNKNOWN = -1;
    private static final int BATTERY_UNPLUGGED = -1;
    private static final int DEFAULT_BATTERY_SCALE = 100;
    private static final String ERROR_HANDLING_BROADCAST_INTENT = "Error handling system info broadcast intent.";
    private final Handler handler;
    private final InternalLogger internalLogger;
    private volatile SystemInfo systemInfo;
    private static final Set<SystemInfo.BatteryStatus> batteryFullOrChargingStatus = SetsKt.setOf((Object[]) new SystemInfo.BatteryStatus[]{SystemInfo.BatteryStatus.CHARGING, SystemInfo.BatteryStatus.FULL});
    private static final Set<Integer> PLUGGED_IN_STATUS_VALUES = SetsKt.setOf((Object[]) new Integer[]{1, 4, 2});

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverSystemInfoProvider(InternalLogger internalLogger, Handler handler) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.internalLogger = internalLogger;
        this.handler = handler;
        this.systemInfo = new SystemInfo(false, 0, false, false, 15, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final String action;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (RuntimeException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider.onReceive.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return BroadcastReceiverSystemInfoProvider.ERROR_HANDLING_BROADCAST_INTENT;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return;
            }
        } else {
            action = null;
        }
        if (Intrinsics.areEqual(action, "android.intent.action.BATTERY_CHANGED")) {
            handleBatteryIntent(intent);
        } else if (Intrinsics.areEqual(action, "android.os.action.POWER_SAVE_MODE_CHANGED")) {
            handlePowerSaveIntent(context);
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider.onReceive.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received unknown broadcast intent: [" + action + "]";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        registerIntentFilter(context, "android.intent.action.BATTERY_CHANGED");
        registerIntentFilter(context, "android.os.action.POWER_SAVE_MODE_CHANGED");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        unregisterReceiver(context);
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    /* JADX INFO: renamed from: getLatestSystemInfo, reason: from getter */
    public SystemInfo getSystemInfo() {
        return this.systemInfo;
    }

    private final void registerIntentFilter(Context context, String action) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        Intent intentRegisterReceiver = registerReceiver(context, intentFilter, this.handler);
        if (intentRegisterReceiver != null) {
            onReceive(context, intentRegisterReceiver);
        }
    }

    private final void handleBatteryIntent(Intent intent) {
        boolean z = true;
        int intExtra = intent.getIntExtra("status", 1);
        int intExtra2 = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra3 = intent.getIntExtra("scale", 100);
        int intExtra4 = intent.getIntExtra("plugged", -1);
        SystemInfo.BatteryStatus batteryStatusFromAndroidStatus = SystemInfo.BatteryStatus.INSTANCE.fromAndroidStatus(intExtra);
        boolean booleanExtra = intent.getBooleanExtra("present", true);
        int iRoundToInt = MathKt.roundToInt((intExtra2 * 100.0f) / intExtra3);
        if (!PLUGGED_IN_STATUS_VALUES.contains(Integer.valueOf(intExtra4)) && booleanExtra) {
            z = false;
        }
        this.systemInfo = SystemInfo.copy$default(this.systemInfo, batteryFullOrChargingStatus.contains(batteryStatusFromAndroidStatus), iRoundToInt, false, z, 4, null);
    }

    private final void handlePowerSaveIntent(Context context) {
        Object systemService = context.getSystemService("power");
        if (!(systemService instanceof PowerManager)) {
            systemService = null;
        }
        PowerManager powerManager = (PowerManager) systemService;
        this.systemInfo = SystemInfo.copy$default(this.systemInfo, false, 0, powerManager != null ? powerManager.isPowerSaveMode() : false, false, 11, null);
    }
}
