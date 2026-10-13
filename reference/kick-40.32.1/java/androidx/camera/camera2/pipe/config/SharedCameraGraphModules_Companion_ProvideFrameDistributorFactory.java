package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.SystemClockOffsets;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class SharedCameraGraphModules_Companion_ProvideFrameDistributorFactory implements Factory<FrameDistributor> {
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<FrameCaptureQueue> frameCaptureQueueProvider;
    private final Provider<StreamGraphImpl> streamGraphImplProvider;
    private final Provider<SystemClockOffsets> systemClockOffsetsProvider;

    private SharedCameraGraphModules_Companion_ProvideFrameDistributorFactory(Provider<StreamGraphImpl> provider, Provider<FrameCaptureQueue> provider2, Provider<CameraMetadata> provider3, Provider<SystemClockOffsets> provider4) {
        this.streamGraphImplProvider = provider;
        this.frameCaptureQueueProvider = provider2;
        this.cameraMetadataProvider = provider3;
        this.systemClockOffsetsProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameDistributor get() {
        return provideFrameDistributor(this.streamGraphImplProvider.get(), this.frameCaptureQueueProvider.get(), this.cameraMetadataProvider.get(), this.systemClockOffsetsProvider.get());
    }

    public static SharedCameraGraphModules_Companion_ProvideFrameDistributorFactory create(Provider<StreamGraphImpl> provider, Provider<FrameCaptureQueue> provider2, Provider<CameraMetadata> provider3, Provider<SystemClockOffsets> provider4) {
        return new SharedCameraGraphModules_Companion_ProvideFrameDistributorFactory(provider, provider2, provider3, provider4);
    }

    public static FrameDistributor provideFrameDistributor(StreamGraphImpl streamGraphImpl, FrameCaptureQueue frameCaptureQueue, CameraMetadata cameraMetadata, SystemClockOffsets systemClockOffsets) {
        return (FrameDistributor) Preconditions.checkNotNullFromProvides(SharedCameraGraphModules.INSTANCE.provideFrameDistributor(streamGraphImpl, frameCaptureQueue, cameraMetadata, systemClockOffsets));
    }
}
