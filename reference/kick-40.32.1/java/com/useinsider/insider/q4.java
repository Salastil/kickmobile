package com.useinsider.insider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class q4 implements SensorEventListener {
    private static q4 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f416a;
    private long b;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public interface a {
        void a();
    }

    private q4() {
    }

    public static q4 a() {
        if (c == null) {
            c = new q4();
        }
        return c;
    }

    public synchronized void b(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f416a != null) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0] / 9.80665f;
            float f2 = fArr[1] / 9.80665f;
            float f3 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3))) > 2.7f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.b + 1000 > jCurrentTimeMillis) {
                    return;
                }
                this.b = jCurrentTimeMillis;
                this.f416a.a();
            }
        }
    }

    public void a(a aVar) {
        this.f416a = aVar;
    }

    public synchronized void a(Context context) {
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                return;
            }
            return;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return;
        }
        throw th;
    }
}
