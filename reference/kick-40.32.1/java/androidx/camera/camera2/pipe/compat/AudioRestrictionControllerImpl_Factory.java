package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class AudioRestrictionControllerImpl_Factory implements Factory<AudioRestrictionControllerImpl> {
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<CameraPipeLifetime> cameraPipeLifetimeProvider;
    private final Provider<Threads> threadsProvider;

    private AudioRestrictionControllerImpl_Factory(Provider<Threads> provider, Provider<CameraPipeLifetime> provider2, Provider<Job> provider3) {
        this.threadsProvider = provider;
        this.cameraPipeLifetimeProvider = provider2;
        this.cameraPipeJobProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioRestrictionControllerImpl get() {
        return newInstance(this.threadsProvider.get(), this.cameraPipeLifetimeProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static AudioRestrictionControllerImpl_Factory create(Provider<Threads> provider, Provider<CameraPipeLifetime> provider2, Provider<Job> provider3) {
        return new AudioRestrictionControllerImpl_Factory(provider, provider2, provider3);
    }

    public static AudioRestrictionControllerImpl newInstance(Threads threads, CameraPipeLifetime cameraPipeLifetime, Job job) {
        return new AudioRestrictionControllerImpl(threads, cameraPipeLifetime, job);
    }
}
