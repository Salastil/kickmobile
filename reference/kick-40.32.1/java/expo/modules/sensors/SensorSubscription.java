package expo.modules.sensors;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SensorSubscription.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\b\u0010\u001d\u001a\u00020\u001eH\u0002J!\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n !*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010#\u001a\u00020\u00182\u000e\u0010 \u001a\n !*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/sensors/SensorSubscription;", "Landroid/hardware/SensorEventListener2;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "sensorType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateInterval", "", "<init>", "(Landroid/content/Context;ILandroid/hardware/SensorEventListener2;J)V", "getUpdateInterval", "()J", "setUpdateInterval", "(J)V", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "samplingPeriodUs", "getSamplingPeriodUs", "()I", "lastUpdate", "onSensorChanged", "", "sensorEvent", "Landroid/hardware/SensorEvent;", "startObserving", "stopObserving", "hasHighSamplingRateSensorsPermission", "", "onAccuracyChanged", "p0", "kotlin.jvm.PlatformType", "p1", "onFlushCompleted", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SensorSubscription implements SensorEventListener2 {
    private final Context context;
    private long lastUpdate;
    private final SensorEventListener2 listener;
    private Sensor mSensor;
    private final SensorManager mSensorManager;
    private final int sensorType;
    private long updateInterval;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor p0, int p1) {
        this.listener.onAccuracyChanged(p0, p1);
    }

    @Override // android.hardware.SensorEventListener2
    public void onFlushCompleted(Sensor p0) {
        this.listener.onFlushCompleted(p0);
    }

    public SensorSubscription(Context context, int i, SensorEventListener2 listener, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.sensorType = i;
        this.listener = listener;
        this.updateInterval = j;
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.mSensorManager = (SensorManager) systemService;
    }

    public /* synthetic */ SensorSubscription(Context context, int i, SensorEventListener2 sensorEventListener2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, sensorEventListener2, (i2 & 8) != 0 ? 100L : j);
    }

    public final long getUpdateInterval() {
        return this.updateInterval;
    }

    public final void setUpdateInterval(long j) {
        this.updateInterval = j;
    }

    private final int getSamplingPeriodUs() {
        return hasHighSamplingRateSensorsPermission() ? 0 : 3;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastUpdate > this.updateInterval) {
            this.listener.onSensorChanged(sensorEvent);
            this.lastUpdate = jCurrentTimeMillis;
        }
    }

    public final void startObserving() {
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(this.sensorType);
        this.mSensor = defaultSensor;
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, getSamplingPeriodUs());
        }
    }

    public final void stopObserving() {
        this.mSensorManager.unregisterListener(this);
    }

    private final boolean hasHighSamplingRateSensorsPermission() {
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                Boolean boolValueOf = strArr != null ? Boolean.valueOf(ArraysKt.contains(strArr, "android.permission.HIGH_SAMPLING_RATE_SENSORS")) : null;
                if (boolValueOf != null) {
                    return boolValueOf.booleanValue();
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
