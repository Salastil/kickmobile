package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideSessionLockFactory implements Factory<GraphSessionLock> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideSessionLockFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphSessionLock get() {
        return provideSessionLock(this.module);
    }

    public static FrameGraphConfigModule_ProvideSessionLockFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideSessionLockFactory(frameGraphConfigModule);
    }

    public static GraphSessionLock provideSessionLock(FrameGraphConfigModule frameGraphConfigModule) {
        return (GraphSessionLock) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideSessionLock());
    }
}
