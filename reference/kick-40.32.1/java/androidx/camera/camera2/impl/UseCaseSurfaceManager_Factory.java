package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser;
import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseSurfaceManager_Factory implements Factory<UseCaseSurfaceManager> {
    private final Provider<CameraPipe> cameraPipeProvider;
    private final Provider<InactiveSurfaceCloser> inactiveSurfaceCloserProvider;
    private final Provider<SessionConfigAdapter> sessionConfigAdapterProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private UseCaseSurfaceManager_Factory(Provider<UseCaseThreads> provider, Provider<CameraPipe> provider2, Provider<InactiveSurfaceCloser> provider3, Provider<SessionConfigAdapter> provider4) {
        this.threadsProvider = provider;
        this.cameraPipeProvider = provider2;
        this.inactiveSurfaceCloserProvider = provider3;
        this.sessionConfigAdapterProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseSurfaceManager get() {
        return newInstance(this.threadsProvider.get(), this.cameraPipeProvider.get(), this.inactiveSurfaceCloserProvider.get(), this.sessionConfigAdapterProvider.get());
    }

    public static UseCaseSurfaceManager_Factory create(Provider<UseCaseThreads> provider, Provider<CameraPipe> provider2, Provider<InactiveSurfaceCloser> provider3, Provider<SessionConfigAdapter> provider4) {
        return new UseCaseSurfaceManager_Factory(provider, provider2, provider3, provider4);
    }

    public static UseCaseSurfaceManager newInstance(UseCaseThreads useCaseThreads, CameraPipe cameraPipe, InactiveSurfaceCloser inactiveSurfaceCloser, SessionConfigAdapter sessionConfigAdapter) {
        return new UseCaseSurfaceManager(useCaseThreads, cameraPipe, inactiveSurfaceCloser, sessionConfigAdapter);
    }
}
