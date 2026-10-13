package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CaptureConfigAdapter;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.config.UseCaseGraphContext;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CapturePipelineImpl_Factory implements Factory<CapturePipelineImpl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<CaptureConfigAdapter> configAdapterProvider;
    private final Provider<FlashControl> flashControlProvider;
    private final Provider<ComboRequestListener> requestListenerProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<TorchControl> torchControlProvider;
    private final Provider<UseCaseCameraState> useCaseCameraStateProvider;
    private final Provider<UseCaseGraphContext> useCaseGraphContextProvider;
    private final Provider<UseTorchAsFlash> useTorchAsFlashProvider;
    private final Provider<VideoUsageControl> videoUsageControlProvider;

    private CapturePipelineImpl_Factory(Provider<CaptureConfigAdapter> provider, Provider<FlashControl> provider2, Provider<TorchControl> provider3, Provider<VideoUsageControl> provider4, Provider<UseCaseThreads> provider5, Provider<ComboRequestListener> provider6, Provider<UseTorchAsFlash> provider7, Provider<CameraProperties> provider8, Provider<UseCaseCameraState> provider9, Provider<UseCaseGraphContext> provider10) {
        this.configAdapterProvider = provider;
        this.flashControlProvider = provider2;
        this.torchControlProvider = provider3;
        this.videoUsageControlProvider = provider4;
        this.threadsProvider = provider5;
        this.requestListenerProvider = provider6;
        this.useTorchAsFlashProvider = provider7;
        this.cameraPropertiesProvider = provider8;
        this.useCaseCameraStateProvider = provider9;
        this.useCaseGraphContextProvider = provider10;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CapturePipelineImpl get() {
        return newInstance(this.configAdapterProvider.get(), this.flashControlProvider.get(), this.torchControlProvider.get(), this.videoUsageControlProvider.get(), this.threadsProvider.get(), this.requestListenerProvider.get(), this.useTorchAsFlashProvider.get(), this.cameraPropertiesProvider.get(), this.useCaseCameraStateProvider, this.useCaseGraphContextProvider.get());
    }

    public static CapturePipelineImpl_Factory create(Provider<CaptureConfigAdapter> provider, Provider<FlashControl> provider2, Provider<TorchControl> provider3, Provider<VideoUsageControl> provider4, Provider<UseCaseThreads> provider5, Provider<ComboRequestListener> provider6, Provider<UseTorchAsFlash> provider7, Provider<CameraProperties> provider8, Provider<UseCaseCameraState> provider9, Provider<UseCaseGraphContext> provider10) {
        return new CapturePipelineImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static CapturePipelineImpl newInstance(CaptureConfigAdapter captureConfigAdapter, FlashControl flashControl, TorchControl torchControl, VideoUsageControl videoUsageControl, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener, UseTorchAsFlash useTorchAsFlash, CameraProperties cameraProperties, javax.inject.Provider<UseCaseCameraState> provider, UseCaseGraphContext useCaseGraphContext) {
        return new CapturePipelineImpl(captureConfigAdapter, flashControl, torchControl, videoUsageControl, useCaseThreads, comboRequestListener, useTorchAsFlash, cameraProperties, provider, useCaseGraphContext);
    }
}
