package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.core.impl.SessionProcessor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraImpl_Factory implements Factory<UseCaseCameraImpl> {
    private final Provider<CapturePipeline> capturePipelineProvider;
    private final Provider<UseCaseCameraRequestControl> requestControlProvider;
    private final Provider<SessionConfigAdapter> sessionConfigAdapterProvider;
    private final Provider<SessionProcessor> sessionProcessorProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<UseCaseGraphContext> useCaseGraphContextProvider;
    private final Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    private UseCaseCameraImpl_Factory(Provider<UseCaseGraphContext> provider, Provider<UseCaseThreads> provider2, Provider<SessionProcessor> provider3, Provider<UseCaseCameraRequestControl> provider4, Provider<UseCaseSurfaceManager> provider5, Provider<SessionConfigAdapter> provider6, Provider<CapturePipeline> provider7) {
        this.useCaseGraphContextProvider = provider;
        this.threadsProvider = provider2;
        this.sessionProcessorProvider = provider3;
        this.requestControlProvider = provider4;
        this.useCaseSurfaceManagerProvider = provider5;
        this.sessionConfigAdapterProvider = provider6;
        this.capturePipelineProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseCameraImpl get() {
        return newInstance(this.useCaseGraphContextProvider.get(), this.threadsProvider.get(), this.sessionProcessorProvider.get(), this.requestControlProvider.get(), this.useCaseSurfaceManagerProvider, this.sessionConfigAdapterProvider, this.capturePipelineProvider);
    }

    public static UseCaseCameraImpl_Factory create(Provider<UseCaseGraphContext> provider, Provider<UseCaseThreads> provider2, Provider<SessionProcessor> provider3, Provider<UseCaseCameraRequestControl> provider4, Provider<UseCaseSurfaceManager> provider5, Provider<SessionConfigAdapter> provider6, Provider<CapturePipeline> provider7) {
        return new UseCaseCameraImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static UseCaseCameraImpl newInstance(UseCaseGraphContext useCaseGraphContext, UseCaseThreads useCaseThreads, SessionProcessor sessionProcessor, UseCaseCameraRequestControl useCaseCameraRequestControl, javax.inject.Provider<UseCaseSurfaceManager> provider, javax.inject.Provider<SessionConfigAdapter> provider2, javax.inject.Provider<CapturePipeline> provider3) {
        return new UseCaseCameraImpl(useCaseGraphContext, useCaseThreads, sessionProcessor, useCaseCameraRequestControl, provider, provider2, provider3);
    }
}
