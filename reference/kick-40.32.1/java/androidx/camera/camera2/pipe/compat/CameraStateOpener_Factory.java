package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraStateOpener_Factory implements Factory<CameraStateOpener> {
    private final Provider<Camera2MetadataProvider> camera2MetadataProvider;
    private final Provider<Camera2Quirks> camera2QuirksProvider;
    private final Provider<CameraErrorListener> cameraErrorListenerProvider;
    private final Provider<CameraPipe.CameraInteropConfig> cameraInteropConfigProvider;
    private final Provider<CameraOpener> cameraOpenerProvider;
    private final Provider<Threads> threadsProvider;
    private final Provider<TimeSource> timeSourceProvider;

    private CameraStateOpener_Factory(Provider<CameraOpener> provider, Provider<Camera2MetadataProvider> provider2, Provider<CameraErrorListener> provider3, Provider<Camera2Quirks> provider4, Provider<TimeSource> provider5, Provider<CameraPipe.CameraInteropConfig> provider6, Provider<Threads> provider7) {
        this.cameraOpenerProvider = provider;
        this.camera2MetadataProvider = provider2;
        this.cameraErrorListenerProvider = provider3;
        this.camera2QuirksProvider = provider4;
        this.timeSourceProvider = provider5;
        this.cameraInteropConfigProvider = provider6;
        this.threadsProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraStateOpener get() {
        return newInstance(this.cameraOpenerProvider.get(), this.camera2MetadataProvider.get(), this.cameraErrorListenerProvider.get(), this.camera2QuirksProvider.get(), this.timeSourceProvider.get(), this.cameraInteropConfigProvider.get(), this.threadsProvider.get());
    }

    public static CameraStateOpener_Factory create(Provider<CameraOpener> provider, Provider<Camera2MetadataProvider> provider2, Provider<CameraErrorListener> provider3, Provider<Camera2Quirks> provider4, Provider<TimeSource> provider5, Provider<CameraPipe.CameraInteropConfig> provider6, Provider<Threads> provider7) {
        return new CameraStateOpener_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CameraStateOpener newInstance(CameraOpener cameraOpener, Camera2MetadataProvider camera2MetadataProvider, CameraErrorListener cameraErrorListener, Camera2Quirks camera2Quirks, TimeSource timeSource, CameraPipe.CameraInteropConfig cameraInteropConfig, Threads threads) {
        return new CameraStateOpener(cameraOpener, camera2MetadataProvider, cameraErrorListener, camera2Quirks, timeSource, cameraInteropConfig, threads);
    }
}
