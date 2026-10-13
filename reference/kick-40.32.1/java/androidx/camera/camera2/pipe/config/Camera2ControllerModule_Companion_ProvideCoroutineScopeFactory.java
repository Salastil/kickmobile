package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerModule_Companion_ProvideCoroutineScopeFactory implements Factory<CoroutineScope> {
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2ControllerModule_Companion_ProvideCoroutineScopeFactory(Provider<Threads> provider, Provider<Job> provider2) {
        this.threadsProvider = provider;
        this.cameraPipeJobProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineScope get() {
        return provideCoroutineScope(this.threadsProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static Camera2ControllerModule_Companion_ProvideCoroutineScopeFactory create(Provider<Threads> provider, Provider<Job> provider2) {
        return new Camera2ControllerModule_Companion_ProvideCoroutineScopeFactory(provider, provider2);
    }

    public static CoroutineScope provideCoroutineScope(Threads threads, Job job) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(Camera2ControllerModule.INSTANCE.provideCoroutineScope(threads, job));
    }
}
