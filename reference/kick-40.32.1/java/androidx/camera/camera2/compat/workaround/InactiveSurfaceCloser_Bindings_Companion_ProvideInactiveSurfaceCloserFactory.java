package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory implements Factory<InactiveSurfaceCloser> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InactiveSurfaceCloser get() {
        return provideInactiveSurfaceCloser(this.cameraQuirksProvider.get());
    }

    public static InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory create(Provider<CameraQuirks> provider) {
        return new InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory(provider);
    }

    public static InactiveSurfaceCloser provideInactiveSurfaceCloser(CameraQuirks cameraQuirks) {
        return (InactiveSurfaceCloser) Preconditions.checkNotNullFromProvides(InactiveSurfaceCloser.Bindings.INSTANCE.provideInactiveSurfaceCloser(cameraQuirks));
    }
}
