package androidx.camera.camera2.pipe.media;

import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ImageReaderImageSources_Factory implements Factory<ImageReaderImageSources> {
    private final Provider<CameraPipe.Config> cameraPipeConfigProvider;
    private final Provider<Threads> threadsProvider;

    private ImageReaderImageSources_Factory(Provider<Threads> provider, Provider<CameraPipe.Config> provider2) {
        this.threadsProvider = provider;
        this.cameraPipeConfigProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ImageReaderImageSources get() {
        return newInstance(this.threadsProvider.get(), this.cameraPipeConfigProvider.get());
    }

    public static ImageReaderImageSources_Factory create(Provider<Threads> provider, Provider<CameraPipe.Config> provider2) {
        return new ImageReaderImageSources_Factory(provider, provider2);
    }

    public static ImageReaderImageSources newInstance(Threads threads, CameraPipe.Config config) {
        return new ImageReaderImageSources(threads, config);
    }
}
