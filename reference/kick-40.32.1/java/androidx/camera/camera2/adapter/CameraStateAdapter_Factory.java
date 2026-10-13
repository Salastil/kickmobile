package androidx.camera.camera2.adapter;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class CameraStateAdapter_Factory implements Factory<CameraStateAdapter> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraStateAdapter get() {
        return newInstance();
    }

    public static CameraStateAdapter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CameraStateAdapter newInstance() {
        return new CameraStateAdapter();
    }

    private static final class InstanceHolder {
        static final CameraStateAdapter_Factory INSTANCE = new CameraStateAdapter_Factory();

        private InstanceHolder() {
        }
    }
}
