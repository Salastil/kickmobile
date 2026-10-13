package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.internal.FrameDistributor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideFrameDistributorFactory implements Factory<FrameDistributor> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideFrameDistributorFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameDistributor get() {
        return provideFrameDistributor(this.module);
    }

    public static FrameGraphConfigModule_ProvideFrameDistributorFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideFrameDistributorFactory(frameGraphConfigModule);
    }

    public static FrameDistributor provideFrameDistributor(FrameGraphConfigModule frameGraphConfigModule) {
        return (FrameDistributor) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideFrameDistributor());
    }
}
