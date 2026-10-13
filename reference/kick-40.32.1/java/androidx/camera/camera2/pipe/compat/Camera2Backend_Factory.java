package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import androidx.camera.camera2.pipe.config.Camera2ControllerComponent;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2Backend_Factory implements Factory<Camera2Backend> {
    private final Provider<Camera2ControllerComponent.Builder> camera2CameraControllerComponentProvider;
    private final Provider<Camera2DeviceCache> camera2DeviceCacheProvider;
    private final Provider<Camera2DeviceManager> camera2DeviceManagerProvider;
    private final Provider<Camera2MetadataCache> camera2MetadataCacheProvider;
    private final Provider<Context> cameraPipeContextProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2Backend_Factory(Provider<Threads> provider, Provider<Camera2DeviceCache> provider2, Provider<Camera2MetadataCache> provider3, Provider<Camera2DeviceManager> provider4, Provider<Camera2ControllerComponent.Builder> provider5, Provider<Context> provider6) {
        this.threadsProvider = provider;
        this.camera2DeviceCacheProvider = provider2;
        this.camera2MetadataCacheProvider = provider3;
        this.camera2DeviceManagerProvider = provider4;
        this.camera2CameraControllerComponentProvider = provider5;
        this.cameraPipeContextProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2Backend get() {
        return newInstance(this.threadsProvider.get(), this.camera2DeviceCacheProvider.get(), this.camera2MetadataCacheProvider.get(), this.camera2DeviceManagerProvider.get(), this.camera2CameraControllerComponentProvider.get(), this.cameraPipeContextProvider.get());
    }

    public static Camera2Backend_Factory create(Provider<Threads> provider, Provider<Camera2DeviceCache> provider2, Provider<Camera2MetadataCache> provider3, Provider<Camera2DeviceManager> provider4, Provider<Camera2ControllerComponent.Builder> provider5, Provider<Context> provider6) {
        return new Camera2Backend_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Camera2Backend newInstance(Threads threads, Camera2DeviceCache camera2DeviceCache, Camera2MetadataCache camera2MetadataCache, Camera2DeviceManager camera2DeviceManager, Camera2ControllerComponent.Builder builder, Context context) {
        return new Camera2Backend(threads, camera2DeviceCache, camera2MetadataCache, camera2DeviceManager, builder, context);
    }
}
