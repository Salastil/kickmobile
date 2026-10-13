package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.compat.AudioRestrictionController;
import androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphImpl_Factory implements Factory<CameraGraphImpl> {
    private final Provider<AudioRestrictionController> audioRestrictionControllerProvider;
    private final Provider<CameraController> cameraControllerProvider;
    private final Provider<Controller3A> controller3AProvider;
    private final Provider<FrameCaptureQueue> frameCaptureQueueProvider;
    private final Provider<FrameDistributor> frameDistributorProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<GraphListener> graphListenerProvider;
    private final Provider<GraphProcessor> graphProcessorProvider;
    private final Provider<CoroutineScope> graphScopeProvider;
    private final Provider<CameraGraphId> idProvider;
    private final Provider<CameraGraphRequestListenersImpl> listenersProvider;
    private final Provider<CameraMetadata> metadataProvider;
    private final Provider<CameraGraphParametersImpl> parametersProvider;
    private final Provider<GraphSessionLock> sessionLockProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<SurfaceGraph> surfaceGraphProvider;

    private CameraGraphImpl_Factory(Provider<CameraGraph.Config> provider, Provider<CameraMetadata> provider2, Provider<GraphProcessor> provider3, Provider<GraphListener> provider4, Provider<StreamGraphImpl> provider5, Provider<SurfaceGraph> provider6, Provider<CameraController> provider7, Provider<FrameDistributor> provider8, Provider<FrameCaptureQueue> provider9, Provider<AudioRestrictionController> provider10, Provider<CameraGraphId> provider11, Provider<CameraGraphParametersImpl> provider12, Provider<CameraGraphRequestListenersImpl> provider13, Provider<GraphSessionLock> provider14, Provider<CoroutineScope> provider15, Provider<Controller3A> provider16) {
        this.graphConfigProvider = provider;
        this.metadataProvider = provider2;
        this.graphProcessorProvider = provider3;
        this.graphListenerProvider = provider4;
        this.streamGraphProvider = provider5;
        this.surfaceGraphProvider = provider6;
        this.cameraControllerProvider = provider7;
        this.frameDistributorProvider = provider8;
        this.frameCaptureQueueProvider = provider9;
        this.audioRestrictionControllerProvider = provider10;
        this.idProvider = provider11;
        this.parametersProvider = provider12;
        this.listenersProvider = provider13;
        this.sessionLockProvider = provider14;
        this.graphScopeProvider = provider15;
        this.controller3AProvider = provider16;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphImpl get() {
        return newInstance(this.graphConfigProvider.get(), this.metadataProvider.get(), this.graphProcessorProvider.get(), this.graphListenerProvider.get(), this.streamGraphProvider.get(), this.surfaceGraphProvider.get(), this.cameraControllerProvider.get(), this.frameDistributorProvider.get(), this.frameCaptureQueueProvider.get(), this.audioRestrictionControllerProvider.get(), this.idProvider.get(), this.parametersProvider.get(), this.listenersProvider.get(), this.sessionLockProvider.get(), this.graphScopeProvider.get(), this.controller3AProvider.get());
    }

    public static CameraGraphImpl_Factory create(Provider<CameraGraph.Config> provider, Provider<CameraMetadata> provider2, Provider<GraphProcessor> provider3, Provider<GraphListener> provider4, Provider<StreamGraphImpl> provider5, Provider<SurfaceGraph> provider6, Provider<CameraController> provider7, Provider<FrameDistributor> provider8, Provider<FrameCaptureQueue> provider9, Provider<AudioRestrictionController> provider10, Provider<CameraGraphId> provider11, Provider<CameraGraphParametersImpl> provider12, Provider<CameraGraphRequestListenersImpl> provider13, Provider<GraphSessionLock> provider14, Provider<CoroutineScope> provider15, Provider<Controller3A> provider16) {
        return new CameraGraphImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static CameraGraphImpl newInstance(CameraGraph.Config config, CameraMetadata cameraMetadata, GraphProcessor graphProcessor, GraphListener graphListener, StreamGraphImpl streamGraphImpl, SurfaceGraph surfaceGraph, CameraController cameraController, FrameDistributor frameDistributor, FrameCaptureQueue frameCaptureQueue, AudioRestrictionController audioRestrictionController, CameraGraphId cameraGraphId, CameraGraphParametersImpl cameraGraphParametersImpl, CameraGraphRequestListenersImpl cameraGraphRequestListenersImpl, GraphSessionLock graphSessionLock, CoroutineScope coroutineScope, Controller3A controller3A) {
        return new CameraGraphImpl(config, cameraMetadata, graphProcessor, graphListener, streamGraphImpl, surfaceGraph, cameraController, frameDistributor, frameCaptureQueue, audioRestrictionController, cameraGraphId, cameraGraphParametersImpl, cameraGraphRequestListenersImpl, graphSessionLock, coroutineScope, controller3A);
    }
}
