package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidMHighSpeedSessionFactory_Factory implements Factory<AndroidMHighSpeedSessionFactory> {
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<Threads> threadsProvider;

    private AndroidMHighSpeedSessionFactory_Factory(Provider<StreamGraphImpl> provider, Provider<Threads> provider2) {
        this.streamGraphProvider = provider;
        this.threadsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidMHighSpeedSessionFactory get() {
        return newInstance(this.streamGraphProvider.get(), this.threadsProvider.get());
    }

    public static AndroidMHighSpeedSessionFactory_Factory create(Provider<StreamGraphImpl> provider, Provider<Threads> provider2) {
        return new AndroidMHighSpeedSessionFactory_Factory(provider, provider2);
    }

    public static AndroidMHighSpeedSessionFactory newInstance(StreamGraphImpl streamGraphImpl, Threads threads) {
        return new AndroidMHighSpeedSessionFactory(streamGraphImpl, threads);
    }
}
