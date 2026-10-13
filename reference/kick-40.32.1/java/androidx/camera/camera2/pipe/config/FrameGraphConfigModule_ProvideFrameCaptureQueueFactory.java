package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideFrameCaptureQueueFactory implements Factory<FrameCaptureQueue> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideFrameCaptureQueueFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameCaptureQueue get() {
        return provideFrameCaptureQueue(this.module);
    }

    public static FrameGraphConfigModule_ProvideFrameCaptureQueueFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideFrameCaptureQueueFactory(frameGraphConfigModule);
    }

    public static FrameCaptureQueue provideFrameCaptureQueue(FrameGraphConfigModule frameGraphConfigModule) {
        return (FrameCaptureQueue) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideFrameCaptureQueue());
    }
}
