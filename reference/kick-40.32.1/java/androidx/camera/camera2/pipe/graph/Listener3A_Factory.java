package androidx.camera.camera2.pipe.graph;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class Listener3A_Factory implements Factory<Listener3A> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Listener3A get() {
        return newInstance();
    }

    public static Listener3A_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Listener3A newInstance() {
        return new Listener3A();
    }

    private static final class InstanceHolder {
        static final Listener3A_Factory INSTANCE = new Listener3A_Factory();

        private InstanceHolder() {
        }
    }
}
