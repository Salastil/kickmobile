package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraphId;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphConfigModule_ProvideCameraGraphIdFactory implements Factory<CameraGraphId> {
    private final CameraGraphConfigModule module;

    private CameraGraphConfigModule_ProvideCameraGraphIdFactory(CameraGraphConfigModule cameraGraphConfigModule) {
        this.module = cameraGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphId get() {
        return provideCameraGraphId(this.module);
    }

    public static CameraGraphConfigModule_ProvideCameraGraphIdFactory create(CameraGraphConfigModule cameraGraphConfigModule) {
        return new CameraGraphConfigModule_ProvideCameraGraphIdFactory(cameraGraphConfigModule);
    }

    public static CameraGraphId provideCameraGraphId(CameraGraphConfigModule cameraGraphConfigModule) {
        return (CameraGraphId) Preconditions.checkNotNullFromProvides(cameraGraphConfigModule.getCameraGraphId());
    }
}
