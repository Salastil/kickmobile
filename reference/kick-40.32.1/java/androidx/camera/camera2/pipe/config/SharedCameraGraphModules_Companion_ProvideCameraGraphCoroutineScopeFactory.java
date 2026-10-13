package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class SharedCameraGraphModules_Companion_ProvideCameraGraphCoroutineScopeFactory implements Factory<CoroutineScope> {
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<Threads> threadsProvider;

    private SharedCameraGraphModules_Companion_ProvideCameraGraphCoroutineScopeFactory(Provider<Threads> provider, Provider<Job> provider2) {
        this.threadsProvider = provider;
        this.cameraPipeJobProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineScope get() {
        return provideCameraGraphCoroutineScope(this.threadsProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static SharedCameraGraphModules_Companion_ProvideCameraGraphCoroutineScopeFactory create(Provider<Threads> provider, Provider<Job> provider2) {
        return new SharedCameraGraphModules_Companion_ProvideCameraGraphCoroutineScopeFactory(provider, provider2);
    }

    public static CoroutineScope provideCameraGraphCoroutineScope(Threads threads, Job job) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(SharedCameraGraphModules.INSTANCE.provideCameraGraphCoroutineScope(threads, job));
    }
}
