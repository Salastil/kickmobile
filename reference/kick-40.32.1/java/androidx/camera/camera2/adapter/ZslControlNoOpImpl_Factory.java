package androidx.camera.camera2.adapter;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class ZslControlNoOpImpl_Factory implements Factory<ZslControlNoOpImpl> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ZslControlNoOpImpl get() {
        return newInstance();
    }

    public static ZslControlNoOpImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ZslControlNoOpImpl newInstance() {
        return new ZslControlNoOpImpl();
    }

    private static final class InstanceHolder {
        static final ZslControlNoOpImpl_Factory INSTANCE = new ZslControlNoOpImpl_Factory();

        private InstanceHolder() {
        }
    }
}
