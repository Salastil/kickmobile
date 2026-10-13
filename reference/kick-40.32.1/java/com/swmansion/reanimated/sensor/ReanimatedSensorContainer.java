package com.swmansion.reanimated.sensor;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import com.swmansion.reanimated.pseudoSelectors.ExtraWindowObserverBridge;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReanimatedSensorContainer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/reanimated/sensor/ReanimatedSensorContainer;", "", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "nextSensorId", "", "sensors", "Ljava/util/HashMap;", "Lcom/swmansion/reanimated/sensor/ReanimatedSensor;", "Lkotlin/collections/HashMap;", "registerSensor", "sensorType", "Lcom/swmansion/reanimated/sensor/ReanimatedSensorType;", "interval", "setter", "Lcom/swmansion/reanimated/nativeProxy/SensorSetter;", "unregisterSensor", "", "sensorId", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReanimatedSensorContainer {
    private int nextSensorId;
    private final WeakReference<ReactApplicationContext> reactContext;
    private final HashMap<Integer, ReanimatedSensor> sensors;

    public ReanimatedSensorContainer(WeakReference<ReactApplicationContext> reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.sensors = new HashMap<>();
    }

    public final int registerSensor(ReanimatedSensorType sensorType, int interval, SensorSetter setter) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Intrinsics.checkNotNullParameter(setter, "setter");
        ReanimatedSensor reanimatedSensor = new ReanimatedSensor(this.reactContext, sensorType, interval, setter);
        if (!reanimatedSensor.initialize()) {
            return -1;
        }
        int i = this.nextSensorId;
        this.nextSensorId = i + 1;
        this.sensors.put(Integer.valueOf(i), reanimatedSensor);
        return i;
    }

    public final void unregisterSensor(int sensorId) {
        ReanimatedSensor reanimatedSensor = this.sensors.get(Integer.valueOf(sensorId));
        if (reanimatedSensor != null) {
            reanimatedSensor.cancel();
            this.sensors.remove(Integer.valueOf(sensorId));
        } else {
            Integer.valueOf(Log.e(ExtraWindowObserverBridge.TAG, "Tried to unregister nonexistent sensor"));
        }
    }
}
