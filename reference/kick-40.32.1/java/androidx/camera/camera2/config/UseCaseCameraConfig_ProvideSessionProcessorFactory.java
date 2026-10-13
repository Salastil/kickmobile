package androidx.camera.camera2.config;

import androidx.camera.core.impl.SessionProcessor;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraConfig_ProvideSessionProcessorFactory implements Factory<SessionProcessor> {
    private final UseCaseCameraConfig module;

    private UseCaseCameraConfig_ProvideSessionProcessorFactory(UseCaseCameraConfig useCaseCameraConfig) {
        this.module = useCaseCameraConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SessionProcessor get() {
        return provideSessionProcessor(this.module);
    }

    public static UseCaseCameraConfig_ProvideSessionProcessorFactory create(UseCaseCameraConfig useCaseCameraConfig) {
        return new UseCaseCameraConfig_ProvideSessionProcessorFactory(useCaseCameraConfig);
    }

    public static SessionProcessor provideSessionProcessor(UseCaseCameraConfig useCaseCameraConfig) {
        return useCaseCameraConfig.provideSessionProcessor();
    }
}
