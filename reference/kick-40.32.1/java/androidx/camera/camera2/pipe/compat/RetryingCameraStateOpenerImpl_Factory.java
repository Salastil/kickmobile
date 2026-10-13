package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class RetryingCameraStateOpenerImpl_Factory implements Factory<RetryingCameraStateOpenerImpl> {
    private final Provider<AudioRestrictionController> audioRestrictionControllerProvider;
    private final Provider<CameraAvailabilityMonitor> cameraAvailabilityMonitorProvider;
    private final Provider<CameraErrorListener> cameraErrorListenerProvider;
    private final Provider<CameraPipe.CameraInteropConfig> cameraInteropConfigProvider;
    private final Provider<CameraStateOpener> cameraStateOpenerProvider;
    private final Provider<DevicePolicyManagerWrapper> devicePolicyManagerProvider;
    private final Provider<Threads> threadsProvider;
    private final Provider<TimeSource> timeSourceProvider;

    private RetryingCameraStateOpenerImpl_Factory(Provider<CameraStateOpener> provider, Provider<CameraErrorListener> provider2, Provider<CameraAvailabilityMonitor> provider3, Provider<TimeSource> provider4, Provider<DevicePolicyManagerWrapper> provider5, Provider<AudioRestrictionController> provider6, Provider<CameraPipe.CameraInteropConfig> provider7, Provider<Threads> provider8) {
        this.cameraStateOpenerProvider = provider;
        this.cameraErrorListenerProvider = provider2;
        this.cameraAvailabilityMonitorProvider = provider3;
        this.timeSourceProvider = provider4;
        this.devicePolicyManagerProvider = provider5;
        this.audioRestrictionControllerProvider = provider6;
        this.cameraInteropConfigProvider = provider7;
        this.threadsProvider = provider8;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RetryingCameraStateOpenerImpl get() {
        return newInstance(this.cameraStateOpenerProvider.get(), this.cameraErrorListenerProvider.get(), this.cameraAvailabilityMonitorProvider.get(), this.timeSourceProvider.get(), this.devicePolicyManagerProvider.get(), this.audioRestrictionControllerProvider.get(), this.cameraInteropConfigProvider.get(), this.threadsProvider.get());
    }

    public static RetryingCameraStateOpenerImpl_Factory create(Provider<CameraStateOpener> provider, Provider<CameraErrorListener> provider2, Provider<CameraAvailabilityMonitor> provider3, Provider<TimeSource> provider4, Provider<DevicePolicyManagerWrapper> provider5, Provider<AudioRestrictionController> provider6, Provider<CameraPipe.CameraInteropConfig> provider7, Provider<Threads> provider8) {
        return new RetryingCameraStateOpenerImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static RetryingCameraStateOpenerImpl newInstance(CameraStateOpener cameraStateOpener, CameraErrorListener cameraErrorListener, CameraAvailabilityMonitor cameraAvailabilityMonitor, TimeSource timeSource, DevicePolicyManagerWrapper devicePolicyManagerWrapper, AudioRestrictionController audioRestrictionController, CameraPipe.CameraInteropConfig cameraInteropConfig, Threads threads) {
        return new RetryingCameraStateOpenerImpl(cameraStateOpener, cameraErrorListener, cameraAvailabilityMonitor, timeSource, devicePolicyManagerWrapper, audioRestrictionController, cameraInteropConfig, threads);
    }
}
