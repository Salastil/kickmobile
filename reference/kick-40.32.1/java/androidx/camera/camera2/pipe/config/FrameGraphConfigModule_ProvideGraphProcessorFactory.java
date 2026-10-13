package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.graph.GraphProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideGraphProcessorFactory implements Factory<GraphProcessor> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideGraphProcessorFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphProcessor get() {
        return provideGraphProcessor(this.module);
    }

    public static FrameGraphConfigModule_ProvideGraphProcessorFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideGraphProcessorFactory(frameGraphConfigModule);
    }

    public static GraphProcessor provideGraphProcessor(FrameGraphConfigModule frameGraphConfigModule) {
        return (GraphProcessor) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideGraphProcessor());
    }
}
