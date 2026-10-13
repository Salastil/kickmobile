package androidx.camera.camera2.pipe.compat;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ErrorProcessor_Factory implements Factory<Camera2ErrorProcessor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2ErrorProcessor get() {
        return newInstance();
    }

    public static Camera2ErrorProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Camera2ErrorProcessor newInstance() {
        return new Camera2ErrorProcessor();
    }

    private static final class InstanceHolder {
        static final Camera2ErrorProcessor_Factory INSTANCE = new Camera2ErrorProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
