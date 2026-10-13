package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.graph.GraphProcessor;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphRequestListenersImpl_Factory implements Factory<CameraGraphRequestListenersImpl> {
    private final Provider<GraphProcessor> graphProcessorProvider;
    private final Provider<CoroutineScope> graphScopeProvider;
    private final Provider<GraphSessionLock> sessionLockProvider;

    private CameraGraphRequestListenersImpl_Factory(Provider<GraphSessionLock> provider, Provider<GraphProcessor> provider2, Provider<CoroutineScope> provider3) {
        this.sessionLockProvider = provider;
        this.graphProcessorProvider = provider2;
        this.graphScopeProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphRequestListenersImpl get() {
        return newInstance(this.sessionLockProvider.get(), this.graphProcessorProvider.get(), this.graphScopeProvider.get());
    }

    public static CameraGraphRequestListenersImpl_Factory create(Provider<GraphSessionLock> provider, Provider<GraphProcessor> provider2, Provider<CoroutineScope> provider3) {
        return new CameraGraphRequestListenersImpl_Factory(provider, provider2, provider3);
    }

    public static CameraGraphRequestListenersImpl newInstance(GraphSessionLock graphSessionLock, GraphProcessor graphProcessor, CoroutineScope coroutineScope) {
        return new CameraGraphRequestListenersImpl(graphSessionLock, graphProcessor, coroutineScope);
    }
}
