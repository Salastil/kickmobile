package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.graph.Controller3A;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideController3AFactory implements Factory<Controller3A> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideController3AFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Controller3A get() {
        return provideController3A(this.module);
    }

    public static FrameGraphConfigModule_ProvideController3AFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideController3AFactory(frameGraphConfigModule);
    }

    public static Controller3A provideController3A(FrameGraphConfigModule frameGraphConfigModule) {
        return (Controller3A) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideController3A());
    }
}
