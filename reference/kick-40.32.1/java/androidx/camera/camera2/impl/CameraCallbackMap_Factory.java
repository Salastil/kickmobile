package androidx.camera.camera2.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class CameraCallbackMap_Factory implements Factory<CameraCallbackMap> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraCallbackMap get() {
        return newInstance();
    }

    public static CameraCallbackMap_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CameraCallbackMap newInstance() {
        return new CameraCallbackMap();
    }

    private static final class InstanceHolder {
        static final CameraCallbackMap_Factory INSTANCE = new CameraCallbackMap_Factory();

        private InstanceHolder() {
        }
    }
}
