package com.datadog.android.rum.internal.domain.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.InfoProvider;
import expo.modules.notifications.service.NotificationsService;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultBatteryInfoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0019\b\u0000\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u000f\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/datadog/android/rum/internal/domain/battery/DefaultBatteryInfoProvider;", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "applicationContext", "Landroid/content/Context;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "powerManager", "Landroid/os/PowerManager;", "batteryManager", "Landroid/os/BatteryManager;", "batteryLevelPollInterval", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Landroid/content/Context;Lcom/datadog/android/internal/time/TimeProvider;Landroid/os/PowerManager;Landroid/os/BatteryManager;ILcom/datadog/android/api/InternalLogger;)V", "batteryLevel", "", "Ljava/lang/Float;", "lastTimeBatteryLevelChecked", "Ljava/util/concurrent/atomic/AtomicLong;", "lowPowerMode", "", "Ljava/lang/Boolean;", "powerSaveModeReceiver", "com/datadog/android/rum/internal/domain/battery/DefaultBatteryInfoProvider$powerSaveModeReceiver$1", "Lcom/datadog/android/rum/internal/domain/battery/DefaultBatteryInfoProvider$powerSaveModeReceiver$1;", "cleanup", "", "getState", "normalizeBatteryLevel", "registerReceivers", "resolveBatteryLevel", "()Ljava/lang/Float;", "resolveLowPowerMode", "()Ljava/lang/Boolean;", "safeUnregisterReceiver", NotificationsService.RECEIVER_KEY, "Landroid/content/BroadcastReceiver;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultBatteryInfoProvider implements InfoProvider<BatteryInfo> {

    @Deprecated
    public static final int BATTERY_POLL_INTERVAL_MS = 60000;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float FULL_BATTERY_PCT = 100.0f;
    private final Context applicationContext;
    private volatile Float batteryLevel;
    private final int batteryLevelPollInterval;
    private final BatteryManager batteryManager;
    private final InternalLogger internalLogger;
    private final AtomicLong lastTimeBatteryLevelChecked;
    private volatile Boolean lowPowerMode;
    private final PowerManager powerManager;
    private final DefaultBatteryInfoProvider$powerSaveModeReceiver$1 powerSaveModeReceiver;
    private final TimeProvider timeProvider;

    private final float normalizeBatteryLevel(int batteryLevel) {
        return batteryLevel / 100.0f;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider$powerSaveModeReceiver$1] */
    public DefaultBatteryInfoProvider(Context applicationContext, TimeProvider timeProvider, PowerManager powerManager, BatteryManager batteryManager, int i, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.applicationContext = applicationContext;
        this.timeProvider = timeProvider;
        this.powerManager = powerManager;
        this.batteryManager = batteryManager;
        this.batteryLevelPollInterval = i;
        this.internalLogger = internalLogger;
        this.lastTimeBatteryLevelChecked = new AtomicLong(Long.MIN_VALUE);
        this.powerSaveModeReceiver = new BroadcastReceiver() { // from class: com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider$powerSaveModeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                PowerManager powerManager2 = this.this$0.powerManager;
                Boolean boolValueOf = powerManager2 != null ? Boolean.valueOf(powerManager2.isPowerSaveMode()) : null;
                if (boolValueOf != null) {
                    DefaultBatteryInfoProvider defaultBatteryInfoProvider = this.this$0;
                    boolValueOf.booleanValue();
                    defaultBatteryInfoProvider.lowPowerMode = boolValueOf;
                }
            }
        };
        registerReceivers();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultBatteryInfoProvider(Context context, TimeProvider timeProvider, PowerManager powerManager, BatteryManager batteryManager, int i, InternalLogger internalLogger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        PowerManager powerManager2;
        BatteryManager batteryManager2;
        if ((i2 & 4) != 0) {
            Object systemService = context.getSystemService("power");
            powerManager2 = (PowerManager) (systemService instanceof PowerManager ? systemService : null);
        } else {
            powerManager2 = powerManager;
        }
        if ((i2 & 8) != 0) {
            Object systemService2 = context.getSystemService("batterymanager");
            batteryManager2 = (BatteryManager) (systemService2 instanceof BatteryManager ? systemService2 : null);
        } else {
            batteryManager2 = batteryManager;
        }
        this(context, timeProvider, powerManager2, batteryManager2, (i2 & 16) != 0 ? 60000 : i, internalLogger);
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public synchronized BatteryInfo getState() {
        long deviceElapsedRealtimeMillis = this.timeProvider.getDeviceElapsedRealtimeMillis();
        if (deviceElapsedRealtimeMillis - ((long) this.batteryLevelPollInterval) >= this.lastTimeBatteryLevelChecked.get()) {
            this.lastTimeBatteryLevelChecked.set(deviceElapsedRealtimeMillis);
            Float fResolveBatteryLevel = resolveBatteryLevel();
            if (fResolveBatteryLevel != null) {
                this.batteryLevel = Float.valueOf(fResolveBatteryLevel.floatValue());
            }
        }
        if (this.lowPowerMode == null) {
            this.lowPowerMode = resolveLowPowerMode();
        }
        return new BatteryInfo(this.batteryLevel, this.lowPowerMode);
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        safeUnregisterReceiver(this.powerSaveModeReceiver);
    }

    private final void safeUnregisterReceiver(BroadcastReceiver receiver) {
        try {
            this.applicationContext.unregisterReceiver(receiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void registerReceivers() {
        this.applicationContext.registerReceiver(this.powerSaveModeReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
    }

    private final Boolean resolveLowPowerMode() {
        PowerManager powerManager = this.powerManager;
        if (powerManager != null) {
            return Boolean.valueOf(powerManager.isPowerSaveMode());
        }
        return null;
    }

    private final Float resolveBatteryLevel() {
        Integer numValueOf;
        try {
            BatteryManager batteryManager = this.batteryManager;
            numValueOf = batteryManager != null ? Integer.valueOf(batteryManager.getIntProperty(4)) : null;
        } catch (RuntimeException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider$resolveBatteryLevel$batteryLevel$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Problem retrieving battery level value";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
        if (numValueOf == null) {
            return null;
        }
        int iIntValue = numValueOf.intValue();
        if (iIntValue == (this.applicationContext.getApplicationInfo().targetSdkVersion >= 28 ? Integer.MIN_VALUE : 0)) {
            return null;
        }
        return Float.valueOf(normalizeBatteryLevel(iIntValue));
    }

    /* JADX INFO: compiled from: DefaultBatteryInfoProvider.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/battery/DefaultBatteryInfoProvider$Companion;", "", "()V", "BATTERY_POLL_INTERVAL_MS", "", "FULL_BATTERY_PCT", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
