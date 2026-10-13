package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.compat.AudioRestrictionController;
import androidx.camera.camera2.pipe.compat.ConcurrentSessionSequencers;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: CameraPipeComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Component(modules = {CameraPipeModule.class, CameraPipeConfigModule.class, Camera2Module.class})
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraPipeComponent;", "", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraGraphComponentBuilder", "Landroidx/camera/camera2/pipe/config/CameraGraphComponent$Builder;", "frameGraphComponentBuilder", "Landroidx/camera/camera2/pipe/config/FrameGraphComponent$Builder;", "cameras", "Landroidx/camera/camera2/pipe/CameraDevices;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraBackends;", "cameraContext", "Landroidx/camera/camera2/pipe/CameraContext;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "cameraAudioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "concurrentSessionSequencers", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencers;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraPipeComponent {
    AudioRestrictionController cameraAudioRestrictionController();

    CameraBackends cameraBackends();

    CameraContext cameraContext();

    CameraGraphComponent.Builder cameraGraphComponentBuilder();

    CameraPipeLifetime cameraPipeLifetime();

    CameraSurfaceManager cameraSurfaceManager();

    CameraDevices cameras();

    ConcurrentSessionSequencers concurrentSessionSequencers();

    FrameGraphComponent.Builder frameGraphComponentBuilder();
}
