package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.StrictMode;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2Quirks_Factory implements Factory<Camera2Quirks> {
    private final Provider<Camera2MetadataProvider> metadataProvider;
    private final Provider<StrictMode> strictModeProvider;

    private Camera2Quirks_Factory(Provider<Camera2MetadataProvider> provider, Provider<StrictMode> provider2) {
        this.metadataProvider = provider;
        this.strictModeProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2Quirks get() {
        return newInstance(this.metadataProvider.get(), this.strictModeProvider.get());
    }

    public static Camera2Quirks_Factory create(Provider<Camera2MetadataProvider> provider, Provider<StrictMode> provider2) {
        return new Camera2Quirks_Factory(provider, provider2);
    }

    public static Camera2Quirks newInstance(Camera2MetadataProvider camera2MetadataProvider, StrictMode strictMode) {
        return new Camera2Quirks(camera2MetadataProvider, strictMode);
    }
}
