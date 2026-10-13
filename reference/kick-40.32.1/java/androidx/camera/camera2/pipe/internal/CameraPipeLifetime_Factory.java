package androidx.camera.camera2.pipe.internal;

import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeLifetime_Factory implements Factory<CameraPipeLifetime> {
    private final Provider<Job> cameraPipeJobProvider;

    private CameraPipeLifetime_Factory(Provider<Job> provider) {
        this.cameraPipeJobProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipeLifetime get() {
        return newInstance(this.cameraPipeJobProvider.get());
    }

    public static CameraPipeLifetime_Factory create(Provider<Job> provider) {
        return new CameraPipeLifetime_Factory(provider);
    }

    public static CameraPipeLifetime newInstance(Job job) {
        return new CameraPipeLifetime(job);
    }
}
