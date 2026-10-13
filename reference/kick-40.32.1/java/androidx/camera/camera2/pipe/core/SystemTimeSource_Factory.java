package androidx.camera.camera2.pipe.core;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SystemTimeSource_Factory implements Factory<SystemTimeSource> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SystemTimeSource get() {
        return newInstance();
    }

    public static SystemTimeSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SystemTimeSource newInstance() {
        return new SystemTimeSource();
    }

    private static final class InstanceHolder {
        static final SystemTimeSource_Factory INSTANCE = new SystemTimeSource_Factory();

        private InstanceHolder() {
        }
    }
}
