package androidx.camera.camera2.pipe.config;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.compat.Camera2CameraStatusMonitor;
import androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessorFactory;
import androidx.camera.camera2.pipe.compat.StandardCamera2CaptureSequenceProcessorFactory;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraStatusMonitor;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: Camera2Component.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2ControllerModule;", "", "<init>", "()V", "bindCamera2RequestProcessorFactory", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessorFactory;", "factoryStandard", "Landroidx/camera/camera2/pipe/compat/StandardCamera2CaptureSequenceProcessorFactory;", "bindCameraController", "Landroidx/camera/camera2/pipe/CameraController;", "camera2CameraController", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public abstract class Camera2ControllerModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract Camera2CaptureSequenceProcessorFactory bindCamera2RequestProcessorFactory(StandardCamera2CaptureSequenceProcessorFactory factoryStandard);

    @Binds
    public abstract CameraController bindCameraController(Camera2CameraController camera2CameraController);

    /* JADX INFO: compiled from: Camera2Component.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J0\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2ControllerModule$Companion;", "", "<init>", "()V", "provideCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "provideCameraStatusMonitor", "Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor;", "cameraManager", "Ljavax/inject/Provider;", "Landroid/hardware/camera2/CameraManager;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Camera2ControllerScope
        public final CoroutineScope provideCoroutineScope(Threads threads, @CameraPipeJob Job cameraPipeJob) {
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
            return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-Camera2Controller"))));
        }

        @Provides
        @Camera2ControllerScope
        public final CameraStatusMonitor provideCameraStatusMonitor(Provider<CameraManager> cameraManager, Threads threads, CameraGraph.Config graphConfig, @CameraPipeJob Job cameraPipeJob) {
            Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
            Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
            return new Camera2CameraStatusMonitor(cameraManager, threads, graphConfig.m385getCameraDz_R5H8(), cameraPipeJob, null);
        }
    }
}
