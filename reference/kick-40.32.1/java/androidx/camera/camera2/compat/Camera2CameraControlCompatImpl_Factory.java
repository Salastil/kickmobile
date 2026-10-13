package androidx.camera.camera2.compat;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraControlCompatImpl_Factory implements Factory<Camera2CameraControlCompatImpl> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraControlCompatImpl get() {
        return newInstance();
    }

    public static Camera2CameraControlCompatImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Camera2CameraControlCompatImpl newInstance() {
        return new Camera2CameraControlCompatImpl();
    }

    private static final class InstanceHolder {
        static final Camera2CameraControlCompatImpl_Factory INSTANCE = new Camera2CameraControlCompatImpl_Factory();

        private InstanceHolder() {
        }
    }
}
