package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.graph.GraphProcessor;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphParametersImpl_Factory implements Factory<CameraGraphParametersImpl> {
    private final Provider<GraphProcessor> graphProcessorProvider;
    private final Provider<CoroutineScope> graphScopeProvider;
    private final Provider<GraphSessionLock> sessionLockProvider;

    private CameraGraphParametersImpl_Factory(Provider<GraphSessionLock> provider, Provider<GraphProcessor> provider2, Provider<CoroutineScope> provider3) {
        this.sessionLockProvider = provider;
        this.graphProcessorProvider = provider2;
        this.graphScopeProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphParametersImpl get() {
        return newInstance(this.sessionLockProvider.get(), this.graphProcessorProvider.get(), this.graphScopeProvider.get());
    }

    public static CameraGraphParametersImpl_Factory create(Provider<GraphSessionLock> provider, Provider<GraphProcessor> provider2, Provider<CoroutineScope> provider3) {
        return new CameraGraphParametersImpl_Factory(provider, provider2, provider3);
    }

    public static CameraGraphParametersImpl newInstance(GraphSessionLock graphSessionLock, GraphProcessor graphProcessor, CoroutineScope coroutineScope) {
        return new CameraGraphParametersImpl(graphSessionLock, graphProcessor, coroutineScope);
    }
}
