package androidx.camera.camera2.config;

import androidx.camera.camera2.adapter.SessionConfigAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraConfig_ProvideSessionConfigAdapterFactory implements Factory<SessionConfigAdapter> {
    private final UseCaseCameraConfig module;

    private UseCaseCameraConfig_ProvideSessionConfigAdapterFactory(UseCaseCameraConfig useCaseCameraConfig) {
        this.module = useCaseCameraConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SessionConfigAdapter get() {
        return provideSessionConfigAdapter(this.module);
    }

    public static UseCaseCameraConfig_ProvideSessionConfigAdapterFactory create(UseCaseCameraConfig useCaseCameraConfig) {
        return new UseCaseCameraConfig_ProvideSessionConfigAdapterFactory(useCaseCameraConfig);
    }

    public static SessionConfigAdapter provideSessionConfigAdapter(UseCaseCameraConfig useCaseCameraConfig) {
        return (SessionConfigAdapter) Preconditions.checkNotNullFromProvides(useCaseCameraConfig.provideSessionConfigAdapter());
    }
}
