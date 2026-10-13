package androidx.camera.camera2.pipe.config;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.Parameters;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestListeners;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.core.SystemClockOffsets;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.CameraGraphImpl;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import androidx.camera.camera2.pipe.graph.GraphProcessorImpl;
import androidx.camera.camera2.pipe.graph.Listener3A;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.graph.SurfaceGraph;
import androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: CameraGraphComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH'J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H'J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH'J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H'¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/config/SharedCameraGraphModules;", "", "<init>", "()V", "bindCameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "Landroidx/camera/camera2/pipe/graph/CameraGraphImpl;", "bindGraphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessorImpl;", "bindGraphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "bindCameraGraphContext", "Landroid/content/Context;", "cameraPipeContext", "bindStreamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "bindSurfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "surfaceGraph", "Landroidx/camera/camera2/pipe/graph/SurfaceGraph;", "bindCameraGraphParameters", "Landroidx/camera/camera2/pipe/Parameters;", "parameters", "Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;", "bindCameraGraphListeners", "Landroidx/camera/camera2/pipe/RequestListeners;", "listeners", "Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public abstract class SharedCameraGraphModules {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract CameraGraph bindCameraGraph(CameraGraphImpl cameraGraph);

    @CameraGraphContext
    @Binds
    public abstract Context bindCameraGraphContext(@CameraPipeContext Context cameraPipeContext);

    @Binds
    public abstract RequestListeners bindCameraGraphListeners(CameraGraphRequestListenersImpl listeners);

    @Binds
    public abstract Parameters bindCameraGraphParameters(CameraGraphParametersImpl parameters);

    @Binds
    public abstract GraphListener bindGraphListener(GraphProcessorImpl graphProcessor);

    @Binds
    public abstract GraphProcessor bindGraphProcessor(GraphProcessorImpl graphProcessor);

    @Binds
    public abstract StreamGraph bindStreamGraph(StreamGraphImpl streamGraph);

    @CameraGraphScope
    @Binds
    public abstract SurfaceTracker bindSurfaceTracker(SurfaceGraph surfaceGraph);

    /* JADX INFO: compiled from: CameraGraphComponent.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J+\u0010\n\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0007¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/config/SharedCameraGraphModules$Companion;", "", "<init>", "()V", "provideCameraGraphCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "provideRequestListeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "Lkotlin/jvm/JvmSuppressWildcards;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "listener3A", "Landroidx/camera/camera2/pipe/graph/Listener3A;", "frameDistributor", "Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "provideSurfaceGraph", "Landroidx/camera/camera2/pipe/graph/SurfaceGraph;", "streamGraphImpl", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "cameraController", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/CameraController;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "provideFrameDistributor", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "systemClockOffsets", "Landroidx/camera/camera2/pipe/core/SystemClockOffsets;", "provideSystemClockOffsets", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @CameraGraphScope
        @ForCameraGraph
        @Provides
        public final CoroutineScope provideCameraGraphCoroutineScope(Threads threads, @CameraPipeJob Job cameraPipeJob) {
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
            return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-Graph"))));
        }

        @CameraGraphScope
        @ForCameraGraph
        @Provides
        public final List<Request.Listener> provideRequestListeners(CameraGraph.Config graphConfig, Listener3A listener3A, FrameDistributor frameDistributor) {
            Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
            Intrinsics.checkNotNullParameter(listener3A, "listener3A");
            Intrinsics.checkNotNullParameter(frameDistributor, "frameDistributor");
            List<Request.Listener> listMutableListOf = CollectionsKt.mutableListOf(listener3A);
            listMutableListOf.add(listener3A);
            listMutableListOf.add(frameDistributor);
            listMutableListOf.addAll(graphConfig.getDefaultListeners());
            return listMutableListOf;
        }

        @CameraGraphScope
        @Provides
        public final SurfaceGraph provideSurfaceGraph(StreamGraphImpl streamGraphImpl, Provider<CameraController> cameraController, CameraSurfaceManager cameraSurfaceManager) {
            Intrinsics.checkNotNullParameter(streamGraphImpl, "streamGraphImpl");
            Intrinsics.checkNotNullParameter(cameraController, "cameraController");
            Intrinsics.checkNotNullParameter(cameraSurfaceManager, "cameraSurfaceManager");
            return new SurfaceGraph(streamGraphImpl, cameraController, cameraSurfaceManager, streamGraphImpl.getImageSourceMap$camera_camera2_pipe());
        }

        /* JADX WARN: Code duplicated, block: B:8:0x002e  */
        @CameraGraphScope
        @Provides
        public final FrameDistributor provideFrameDistributor(StreamGraphImpl streamGraphImpl, FrameCaptureQueue frameCaptureQueue, CameraMetadata cameraMetadata, SystemClockOffsets systemClockOffsets) {
            boolean z;
            Intrinsics.checkNotNullParameter(streamGraphImpl, "streamGraphImpl");
            Intrinsics.checkNotNullParameter(frameCaptureQueue, "frameCaptureQueue");
            Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
            Intrinsics.checkNotNullParameter(systemClockOffsets, "systemClockOffsets");
            CameraCharacteristics.Key SENSOR_INFO_TIMESTAMP_SOURCE = CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE;
            Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_TIMESTAMP_SOURCE, "SENSOR_INFO_TIMESTAMP_SOURCE");
            Integer num = (Integer) cameraMetadata.get(SENSOR_INFO_TIMESTAMP_SOURCE);
            if (num != null) {
                z = num.intValue() == 1;
            }
            return new FrameDistributor(streamGraphImpl, frameCaptureQueue, z, systemClockOffsets.getRealtimeNsToMonotonicNs());
        }

        @CameraGraphScope
        @Provides
        public final SystemClockOffsets provideSystemClockOffsets() {
            return SystemClockOffsets.INSTANCE.estimate();
        }
    }
}
