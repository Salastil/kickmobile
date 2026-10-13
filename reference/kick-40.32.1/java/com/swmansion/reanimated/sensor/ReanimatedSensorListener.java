package com.swmansion.reanimated.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import com.facebook.imagepipeline.common.RotationOptions;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReanimatedSensorListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/swmansion/reanimated/sensor/ReanimatedSensorListener;", "Landroid/hardware/SensorEventListener;", "setter", "Lcom/swmansion/reanimated/nativeProxy/SensorSetter;", "interval", "", "display", "Landroid/view/Display;", "<init>", "(Lcom/swmansion/reanimated/nativeProxy/SensorSetter;DLandroid/view/Display;)V", "lastRead", "rotation", "", "orientation", "quaternion", "onSensorChanged", "", "event", "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReanimatedSensorListener implements SensorEventListener {
    private final Display display;
    private final double interval;
    private double lastRead;
    private final float[] orientation;
    private final float[] quaternion;
    private final float[] rotation;
    private final SensorSetter setter;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public ReanimatedSensorListener(SensorSetter setter, double d, Display display) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(display, "display");
        this.setter = setter;
        this.interval = d;
        this.display = display;
        this.lastRead = System.currentTimeMillis();
        this.rotation = new float[9];
        this.orientation = new float[3];
        this.quaternion = new float[4];
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        double dCurrentTimeMillis = System.currentTimeMillis();
        if (dCurrentTimeMillis - this.lastRead < this.interval) {
            return;
        }
        int type = event.sensor.getType();
        this.lastRead = dCurrentTimeMillis;
        int rotation = this.display.getRotation();
        if (rotation == 1) {
            i = 90;
        } else if (rotation != 2) {
            i = rotation != 3 ? 0 : RotationOptions.ROTATE_270;
        } else {
            i = RotationOptions.ROTATE_180;
        }
        if (type == 2 || type == 4) {
            this.setter.sensorSetter(new float[]{event.values[0], event.values[1], event.values[2]}, i);
            return;
        }
        switch (type) {
            case 9:
            case 10:
                this.setter.sensorSetter(new float[]{-event.values[0], -event.values[1], -event.values[2]}, i);
                return;
            case 11:
                SensorManager.getQuaternionFromVector(this.quaternion, event.values);
                SensorManager.getRotationMatrixFromVector(this.rotation, event.values);
                SensorManager.getOrientation(this.rotation, this.orientation);
                float[] fArr = this.quaternion;
                float f = fArr[1];
                float f2 = fArr[3];
                float f3 = -fArr[2];
                float f4 = fArr[0];
                float[] fArr2 = this.orientation;
                this.setter.sensorSetter(new float[]{f, f2, f3, f4, -fArr2[0], -fArr2[1], fArr2[2]}, i);
                return;
            default:
                throw new IllegalArgumentException("[Reanimated] Unknown sensor type.");
        }
    }
}
