package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.compat.AudioRestrictionController;
import androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl;
import androidx.camera.camera2.pipe.compat.Camera2Backend;
import androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor;
import androidx.camera.camera2.pipe.compat.Camera2CameraOpener;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCloser;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl;
import androidx.camera.camera2.pipe.compat.Camera2DeviceManager;
import androidx.camera.camera2.pipe.compat.Camera2ErrorProcessor;
import androidx.camera.camera2.pipe.compat.Camera2MetadataCache;
import androidx.camera.camera2.pipe.compat.Camera2MetadataProvider;
import androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor;
import androidx.camera.camera2.pipe.compat.CameraOpener;
import androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager;
import androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener;
import androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera2Component.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH'J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H'J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H'¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2Module;", "", "<init>", "()V", "bindCameraPipeCameraBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "camera2Backend", "Landroidx/camera/camera2/pipe/compat/Camera2Backend;", "bindCamera2DeviceManager", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", "camera2DeviceManager", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager;", "bindCameraOpener", "Landroidx/camera/camera2/pipe/compat/CameraOpener;", "camera2CameraOpener", "Landroidx/camera/camera2/pipe/compat/Camera2CameraOpener;", "bindRetryingCameraStateOpener", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "retryingCameraStateOpenerImpl", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl;", "bindCameraMetadataProvider", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;", "camera2MetadataCache", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "bindCameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "camera2ErrorProcessor", "Landroidx/camera/camera2/pipe/compat/Camera2ErrorProcessor;", "bindCameraAvailabilityMonitor", "Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor;", "camera2CameraAvailabilityMonitor", "Landroidx/camera/camera2/pipe/compat/Camera2CameraAvailabilityMonitor;", "bindCamera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "camera2CameraDeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloserImpl;", "bindAudioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionControllerImpl;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module(subcomponents = {Camera2ControllerComponent.class})
public abstract class Camera2Module {
    @Binds
    public abstract AudioRestrictionController bindAudioRestrictionController(AudioRestrictionControllerImpl audioRestrictionController);

    @Binds
    public abstract Camera2DeviceCloser bindCamera2DeviceCloser(Camera2DeviceCloserImpl camera2CameraDeviceCloser);

    @Binds
    public abstract Camera2DeviceManager bindCamera2DeviceManager(PruningCamera2DeviceManager camera2DeviceManager);

    @Binds
    public abstract CameraAvailabilityMonitor bindCameraAvailabilityMonitor(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor);

    @Binds
    public abstract CameraErrorListener bindCameraErrorListener(Camera2ErrorProcessor camera2ErrorProcessor);

    @Binds
    public abstract Camera2MetadataProvider bindCameraMetadataProvider(Camera2MetadataCache camera2MetadataCache);

    @Binds
    public abstract CameraOpener bindCameraOpener(Camera2CameraOpener camera2CameraOpener);

    @DefaultCameraBackend
    @Binds
    public abstract CameraBackend bindCameraPipeCameraBackend(Camera2Backend camera2Backend);

    @Binds
    public abstract RetryingCameraStateOpener bindRetryingCameraStateOpener(RetryingCameraStateOpenerImpl retryingCameraStateOpenerImpl);
}
