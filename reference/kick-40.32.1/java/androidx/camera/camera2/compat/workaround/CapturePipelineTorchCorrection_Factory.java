package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseThreads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CapturePipelineTorchCorrection_Factory implements Factory<CapturePipelineTorchCorrection> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<CapturePipelineImpl> capturePipelineImplProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<TorchControl> torchControlProvider;

    private CapturePipelineTorchCorrection_Factory(Provider<CameraProperties> provider, Provider<CapturePipelineImpl> provider2, Provider<UseCaseThreads> provider3, Provider<TorchControl> provider4) {
        this.cameraPropertiesProvider = provider;
        this.capturePipelineImplProvider = provider2;
        this.threadsProvider = provider3;
        this.torchControlProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CapturePipelineTorchCorrection get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.capturePipelineImplProvider, this.threadsProvider.get(), this.torchControlProvider.get());
    }

    public static CapturePipelineTorchCorrection_Factory create(Provider<CameraProperties> provider, Provider<CapturePipelineImpl> provider2, Provider<UseCaseThreads> provider3, Provider<TorchControl> provider4) {
        return new CapturePipelineTorchCorrection_Factory(provider, provider2, provider3, provider4);
    }

    public static CapturePipelineTorchCorrection newInstance(CameraProperties cameraProperties, javax.inject.Provider<CapturePipelineImpl> provider, UseCaseThreads useCaseThreads, TorchControl torchControl) {
        return new CapturePipelineTorchCorrection(cameraProperties, provider, useCaseThreads, torchControl);
    }
}
