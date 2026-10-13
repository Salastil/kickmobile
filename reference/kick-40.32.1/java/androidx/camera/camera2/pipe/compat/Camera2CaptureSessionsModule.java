package androidx.camera.camera2.pipe.compat;

import android.os.Build;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.config.Camera2ControllerScope;
import dagger.Module;
import dagger.Provides;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CaptureSessionsModule;", "", "<init>", "()V", "provideSessionFactory", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "androidMProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/compat/AndroidMSessionFactory;", "androidMHighSpeedProvider", "Landroidx/camera/camera2/pipe/compat/AndroidMHighSpeedSessionFactory;", "androidNProvider", "Landroidx/camera/camera2/pipe/compat/AndroidNSessionFactory;", "androidPProvider", "Landroidx/camera/camera2/pipe/compat/AndroidPSessionFactory;", "androidExtensionProvider", "Landroidx/camera/camera2/pipe/compat/AndroidExtensionSessionFactory;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final class Camera2CaptureSessionsModule {
    public static final Camera2CaptureSessionsModule INSTANCE = new Camera2CaptureSessionsModule();

    private Camera2CaptureSessionsModule() {
    }

    @Provides
    @Camera2ControllerScope
    public final CaptureSessionFactory provideSessionFactory(Provider<AndroidMSessionFactory> androidMProvider, Provider<AndroidMHighSpeedSessionFactory> androidMHighSpeedProvider, Provider<AndroidNSessionFactory> androidNProvider, Provider<AndroidPSessionFactory> androidPProvider, Provider<AndroidExtensionSessionFactory> androidExtensionProvider, CameraGraph.Config graphConfig) {
        Intrinsics.checkNotNullParameter(androidMProvider, "androidMProvider");
        Intrinsics.checkNotNullParameter(androidMHighSpeedProvider, "androidMHighSpeedProvider");
        Intrinsics.checkNotNullParameter(androidNProvider, "androidNProvider");
        Intrinsics.checkNotNullParameter(androidPProvider, "androidPProvider");
        Intrinsics.checkNotNullParameter(androidExtensionProvider, "androidExtensionProvider");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        if (CameraGraph.OperatingMode.m410equalsimpl0(graphConfig.m389getSessionMode2uNL3no(), CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no())) {
            if (Build.VERSION.SDK_INT < 31) {
                throw new IllegalStateException("Cannot use Extension sessions below Android S".toString());
            }
            AndroidExtensionSessionFactory androidExtensionSessionFactory = androidExtensionProvider.get();
            Intrinsics.checkNotNullExpressionValue(androidExtensionSessionFactory, "get(...)");
            return androidExtensionSessionFactory;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            AndroidPSessionFactory androidPSessionFactory = androidPProvider.get();
            Intrinsics.checkNotNullExpressionValue(androidPSessionFactory, "get(...)");
            return androidPSessionFactory;
        }
        if (CameraGraph.OperatingMode.m410equalsimpl0(graphConfig.m389getSessionMode2uNL3no(), CameraGraph.OperatingMode.INSTANCE.m416getHIGH_SPEED2uNL3no())) {
            AndroidMHighSpeedSessionFactory androidMHighSpeedSessionFactory = androidMHighSpeedProvider.get();
            Intrinsics.checkNotNullExpressionValue(androidMHighSpeedSessionFactory, "get(...)");
            return androidMHighSpeedSessionFactory;
        }
        AndroidNSessionFactory androidNSessionFactory = androidNProvider.get();
        Intrinsics.checkNotNullExpressionValue(androidNSessionFactory, "get(...)");
        return androidNSessionFactory;
    }
}
