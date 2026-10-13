package expo.modules.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SensorProxy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012%\u0010\u0006\u001a!\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\fJ\u0006\u0010)\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0006\u001a!\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00050\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lexpo/modules/sensors/SensorProxy;", "Landroid/hardware/SensorEventListener2;", "sensorType", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "onNewEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "Lkotlin/ParameterName;", "name", "event", "", "Lexpo/modules/sensors/OnNewEvent;", "<init>", "(ILexpo/modules/kotlin/AppContext;Lkotlin/jvm/functions/Function1;)V", "getOnNewEvent", "()Lkotlin/jvm/functions/Function1;", "appContextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "sensorKernelServiceSubscription", "Lexpo/modules/sensors/SensorSubscription;", "getSensorKernelServiceSubscription", "()Lexpo/modules/sensors/SensorSubscription;", "sensorKernelServiceSubscription$delegate", "Lkotlin/Lazy;", "isObserving", "", "onSensorChanged", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onFlushCompleted", "setUpdateInterval", "updateInterval", "startObserving", "stopObserving", "onHostResume", "onHostPause", "onHostDestroy", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SensorProxy implements SensorEventListener2 {
    private final WeakReference<AppContext> appContextHolder;
    private boolean isObserving;
    private final Function1<SensorEvent, Unit> onNewEvent;

    /* JADX INFO: renamed from: sensorKernelServiceSubscription$delegate, reason: from kotlin metadata */
    private final Lazy sensorKernelServiceSubscription;
    private final int sensorType;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener2
    public void onFlushCompleted(Sensor sensor) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SensorProxy(int i, AppContext appContext, Function1<? super SensorEvent, Unit> onNewEvent) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(onNewEvent, "onNewEvent");
        this.sensorType = i;
        this.onNewEvent = onNewEvent;
        this.appContextHolder = new WeakReference<>(appContext);
        this.sensorKernelServiceSubscription = LazyKt.lazy(new Function0() { // from class: expo.modules.sensors.SensorProxy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SensorProxy.sensorKernelServiceSubscription_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Function1<SensorEvent, Unit> getOnNewEvent() {
        return this.onNewEvent;
    }

    private final SensorSubscription getSensorKernelServiceSubscription() {
        return (SensorSubscription) this.sensorKernelServiceSubscription.getValue();
    }

    static final SensorSubscription sensorKernelServiceSubscription_delegate$lambda$0(SensorProxy sensorProxy) throws Exceptions.ReactContextLost {
        Context reactContext;
        AppContext appContext = sensorProxy.appContextHolder.get();
        if (appContext == null || (reactContext = appContext.getReactContext()) == null) {
            throw new Exceptions.ReactContextLost();
        }
        return new SensorSubscription(reactContext, sensorProxy.sensorType, sensorProxy, 0L, 8, null);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.onNewEvent.invoke(event);
    }

    public final void setUpdateInterval(int updateInterval) {
        getSensorKernelServiceSubscription().setUpdateInterval(updateInterval);
    }

    public final void startObserving() {
        this.isObserving = true;
        getSensorKernelServiceSubscription().startObserving();
    }

    public final void stopObserving() {
        if (this.isObserving) {
            this.isObserving = false;
            getSensorKernelServiceSubscription().stopObserving();
        }
    }

    public final void onHostResume() {
        if (this.isObserving) {
            getSensorKernelServiceSubscription().startObserving();
        }
    }

    public final void onHostPause() {
        if (this.isObserving) {
            getSensorKernelServiceSubscription().stopObserving();
        }
    }

    public final void onHostDestroy() {
        if (this.isObserving) {
            getSensorKernelServiceSubscription().stopObserving();
            this.isObserving = false;
        }
    }
}
