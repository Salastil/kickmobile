package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReanimatedSensor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/swmansion/reanimated/sensor/ReanimatedSensor;", "", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "sensorType", "Lcom/swmansion/reanimated/sensor/ReanimatedSensorType;", "interval", "", "setter", "Lcom/swmansion/reanimated/nativeProxy/SensorSetter;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/swmansion/reanimated/sensor/ReanimatedSensorType;ILcom/swmansion/reanimated/nativeProxy/SensorSetter;)V", "getSensorType", "()Lcom/swmansion/reanimated/sensor/ReanimatedSensorType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/swmansion/reanimated/sensor/ReanimatedSensorListener;", "getListener", "()Lcom/swmansion/reanimated/sensor/ReanimatedSensorListener;", "sensorManager", "Landroid/hardware/SensorManager;", "getSensorManager", "()Landroid/hardware/SensorManager;", "sensor", "Landroid/hardware/Sensor;", "getSensor", "()Landroid/hardware/Sensor;", "setSensor", "(Landroid/hardware/Sensor;)V", "getInterval", "()I", "initialize", "", "cancel", "", "Companion", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReanimatedSensor {
    private static final int DEFAULT_INTERVAL = 8;
    private final int interval;
    private final ReanimatedSensorListener listener;
    private Sensor sensor;
    private final SensorManager sensorManager;
    private final ReanimatedSensorType sensorType;

    public ReanimatedSensor(WeakReference<ReactApplicationContext> reactContext, ReanimatedSensorType sensorType, int i, SensorSetter setter) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Intrinsics.checkNotNullParameter(setter, "setter");
        this.sensorType = sensorType;
        ReactApplicationContext reactApplicationContext = reactContext.get();
        Intrinsics.checkNotNull(reactApplicationContext);
        Object systemService = reactApplicationContext.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNull(defaultDisplay);
        this.listener = new ReanimatedSensorListener(setter, i, defaultDisplay);
        ReactApplicationContext reactApplicationContext2 = reactContext.get();
        Intrinsics.checkNotNull(reactApplicationContext2);
        Object systemService2 = reactApplicationContext2.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) systemService2;
        this.interval = i == -1 ? 8 : i;
    }

    public final ReanimatedSensorType getSensorType() {
        return this.sensorType;
    }

    public final ReanimatedSensorListener getListener() {
        return this.listener;
    }

    public final SensorManager getSensorManager() {
        return this.sensorManager;
    }

    public final Sensor getSensor() {
        return this.sensor;
    }

    public final void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final boolean initialize() {
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(this.sensorType.getType());
        this.sensor = defaultSensor;
        if (defaultSensor == null) {
            return false;
        }
        this.sensorManager.registerListener(this.listener, defaultSensor, this.interval * 1000);
        return true;
    }

    public final void cancel() {
        this.sensorManager.unregisterListener(this.listener, this.sensor);
    }
}
