package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphModule_Companion_ProvideFrameGraphCoroutineScopeFactory implements Factory<CoroutineScope> {
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<Threads> threadsProvider;

    private FrameGraphModule_Companion_ProvideFrameGraphCoroutineScopeFactory(Provider<Threads> provider, Provider<Job> provider2) {
        this.threadsProvider = provider;
        this.cameraPipeJobProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineScope get() {
        return provideFrameGraphCoroutineScope(this.threadsProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static FrameGraphModule_Companion_ProvideFrameGraphCoroutineScopeFactory create(Provider<Threads> provider, Provider<Job> provider2) {
        return new FrameGraphModule_Companion_ProvideFrameGraphCoroutineScopeFactory(provider, provider2);
    }

    public static CoroutineScope provideFrameGraphCoroutineScope(Threads threads, Job job) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(FrameGraphModule.INSTANCE.provideFrameGraphCoroutineScope(threads, job));
    }
}
