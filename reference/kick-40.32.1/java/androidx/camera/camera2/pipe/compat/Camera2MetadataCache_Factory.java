package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2MetadataCache_Factory implements Factory<Camera2MetadataCache> {
    private final Provider<CameraPipe.CameraMetadataConfig> cameraMetadataConfigProvider;
    private final Provider<Context> cameraPipeContextProvider;
    private final Provider<Permissions> permissionsProvider;
    private final Provider<Threads> threadsProvider;
    private final Provider<TimeSource> timeSourceProvider;

    private Camera2MetadataCache_Factory(Provider<Context> provider, Provider<Threads> provider2, Provider<Permissions> provider3, Provider<CameraPipe.CameraMetadataConfig> provider4, Provider<TimeSource> provider5) {
        this.cameraPipeContextProvider = provider;
        this.threadsProvider = provider2;
        this.permissionsProvider = provider3;
        this.cameraMetadataConfigProvider = provider4;
        this.timeSourceProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2MetadataCache get() {
        return newInstance(this.cameraPipeContextProvider.get(), this.threadsProvider.get(), this.permissionsProvider.get(), this.cameraMetadataConfigProvider.get(), this.timeSourceProvider.get());
    }

    public static Camera2MetadataCache_Factory create(Provider<Context> provider, Provider<Threads> provider2, Provider<Permissions> provider3, Provider<CameraPipe.CameraMetadataConfig> provider4, Provider<TimeSource> provider5) {
        return new Camera2MetadataCache_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static Camera2MetadataCache newInstance(Context context, Threads threads, Permissions permissions, CameraPipe.CameraMetadataConfig cameraMetadataConfig, TimeSource timeSource) {
        return new Camera2MetadataCache(context, threads, permissions, cameraMetadataConfig, timeSource);
    }
}
