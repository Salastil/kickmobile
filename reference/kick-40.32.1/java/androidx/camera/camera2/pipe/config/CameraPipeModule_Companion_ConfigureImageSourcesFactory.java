package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.media.ImageReaderImageSources;
import androidx.camera.camera2.pipe.media.ImageSources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ConfigureImageSourcesFactory implements Factory<ImageSources> {
    private final Provider<CameraPipe.Config> cameraPipeConfigProvider;
    private final Provider<ImageReaderImageSources> imageReaderImageSourcesProvider;

    private CameraPipeModule_Companion_ConfigureImageSourcesFactory(Provider<ImageReaderImageSources> provider, Provider<CameraPipe.Config> provider2) {
        this.imageReaderImageSourcesProvider = provider;
        this.cameraPipeConfigProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ImageSources get() {
        return configureImageSources(this.imageReaderImageSourcesProvider.get(), this.cameraPipeConfigProvider.get());
    }

    public static CameraPipeModule_Companion_ConfigureImageSourcesFactory create(Provider<ImageReaderImageSources> provider, Provider<CameraPipe.Config> provider2) {
        return new CameraPipeModule_Companion_ConfigureImageSourcesFactory(provider, provider2);
    }

    public static ImageSources configureImageSources(ImageReaderImageSources imageReaderImageSources, CameraPipe.Config config) {
        return (ImageSources) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.configureImageSources(imageReaderImageSources, config));
    }
}
