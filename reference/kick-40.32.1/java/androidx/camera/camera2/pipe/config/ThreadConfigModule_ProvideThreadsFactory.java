package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadConfigModule_ProvideThreadsFactory implements Factory<Threads> {
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<CameraPipeLifetime> cameraPipeLifetimeProvider;
    private final ThreadConfigModule module;

    private ThreadConfigModule_ProvideThreadsFactory(ThreadConfigModule threadConfigModule, Provider<CameraPipeLifetime> provider, Provider<Job> provider2) {
        this.module = threadConfigModule;
        this.cameraPipeLifetimeProvider = provider;
        this.cameraPipeJobProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Threads get() {
        return provideThreads(this.module, this.cameraPipeLifetimeProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static ThreadConfigModule_ProvideThreadsFactory create(ThreadConfigModule threadConfigModule, Provider<CameraPipeLifetime> provider, Provider<Job> provider2) {
        return new ThreadConfigModule_ProvideThreadsFactory(threadConfigModule, provider, provider2);
    }

    public static Threads provideThreads(ThreadConfigModule threadConfigModule, CameraPipeLifetime cameraPipeLifetime, Job job) {
        return (Threads) Preconditions.checkNotNullFromProvides(threadConfigModule.provideThreads(cameraPipeLifetime, job));
    }
}
