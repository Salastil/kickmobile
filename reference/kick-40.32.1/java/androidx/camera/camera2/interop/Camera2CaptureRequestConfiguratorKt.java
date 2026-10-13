package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.Config;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2CaptureRequestConfigurator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0006H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a \u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"OPTION_CAPTURE_REQUEST_CONFIGURATOR", "Landroidx/camera/core/impl/Config$Option;", "Landroidx/camera/camera2/interop/Camera2CaptureRequestConfigurator;", "getOPTION_CAPTURE_REQUEST_CONFIGURATOR", "()Landroidx/camera/core/impl/Config$Option;", "getCamera2CaptureRequestConfigurator", "Landroidx/camera/core/CameraXConfig;", "setCamera2CaptureRequestConfigurator", "Landroidx/camera/core/CameraXConfig$Builder;", "captureRequestConfigurator", "configureWithUnchecked", "", "parameters", "", "", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Camera2CaptureRequestConfiguratorKt {
    private static final Config.Option<Camera2CaptureRequestConfigurator> OPTION_CAPTURE_REQUEST_CONFIGURATOR;

    public static final Config.Option<Camera2CaptureRequestConfigurator> getOPTION_CAPTURE_REQUEST_CONFIGURATOR() {
        return OPTION_CAPTURE_REQUEST_CONFIGURATOR;
    }

    static {
        Config.Option<Camera2CaptureRequestConfigurator> optionCreate = Config.Option.create("camerax.core.appConfig.captureRequestConfigurator", Camera2CaptureRequestConfigurator.class);
        Intrinsics.checkNotNullExpressionValue(optionCreate, "create(...)");
        OPTION_CAPTURE_REQUEST_CONFIGURATOR = optionCreate;
    }

    public static final Camera2CaptureRequestConfigurator getCamera2CaptureRequestConfigurator(CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(cameraXConfig, "<this>");
        return (Camera2CaptureRequestConfigurator) cameraXConfig.getConfig().retrieveOption(OPTION_CAPTURE_REQUEST_CONFIGURATOR, null);
    }

    public static final CameraXConfig.Builder setCamera2CaptureRequestConfigurator(CameraXConfig.Builder builder, Camera2CaptureRequestConfigurator captureRequestConfigurator) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(captureRequestConfigurator, "captureRequestConfigurator");
        builder.getMutableConfig().insertOption(OPTION_CAPTURE_REQUEST_CONFIGURATOR, captureRequestConfigurator);
        return builder;
    }

    public static final void configureWithUnchecked(Camera2CaptureRequestConfigurator camera2CaptureRequestConfigurator, Map<Object, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(camera2CaptureRequestConfigurator, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Object, ? extends Object> entry : parameters.entrySet()) {
            if (entry.getKey() instanceof CaptureRequest.Key) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        camera2CaptureRequestConfigurator.configureWith(linkedHashMap);
    }
}
