package expo.modules.sensors.modules;

import android.hardware.SensorEvent;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.sensors.SensorProxy;
import expo.modules.sensors.SensorProxyKt;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccelerometerModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lexpo/modules/sensors/modules/AccelerometerModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AccelerometerModule extends Module {

    /* JADX INFO: renamed from: sensorProxy$delegate, reason: from kotlin metadata */
    private final Lazy sensorProxy = LazyKt.lazy(new Function0() { // from class: expo.modules.sensors.modules.AccelerometerModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AccelerometerModule.sensorProxy_delegate$lambda$2(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy.getValue();
    }

    static final SensorProxy sensorProxy_delegate$lambda$2(AccelerometerModule accelerometerModule) {
        AccelerometerModule accelerometerModule2 = accelerometerModule;
        AppContext appContext = accelerometerModule.getAppContext();
        final WeakReference weakReference = new WeakReference(accelerometerModule2);
        final String str = "accelerometerDidUpdate";
        return new SensorProxy(1, appContext, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.modules.AccelerometerModule$sensorProxy_delegate$lambda$2$$inlined$createSensorProxy$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SensorEvent sensorEvent) {
                invoke2(sensorEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SensorEvent sensorEvent) {
                Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                Module module = (Module) weakReference.get();
                if (module != null) {
                    String str2 = str;
                    Bundle bundle = new Bundle();
                    bundle.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, sensorEvent.values[0] / 9.80665f);
                    bundle.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, sensorEvent.values[1] / 9.80665f);
                    bundle.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Z, sensorEvent.values[2] / 9.80665f);
                    bundle.putDouble("timestamp", sensorEvent.timestamp / 1.0E9d);
                    module.sendEvent(str2, bundle);
                }
            }
        });
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AccelerometerModule accelerometerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (accelerometerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(accelerometerModule);
            moduleDefinitionBuilder.Name("ExponentAccelerometer");
            SensorProxyKt.UseSensorProxy$default(moduleDefinitionBuilder, this, 1, "accelerometerDidUpdate", null, new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.AccelerometerModule$definition$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SensorProxy invoke() {
                    return this.this$0.getSensorProxy();
                }
            }, 8, null);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
