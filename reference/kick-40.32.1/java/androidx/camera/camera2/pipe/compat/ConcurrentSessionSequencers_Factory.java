package androidx.camera.camera2.pipe.compat;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class ConcurrentSessionSequencers_Factory implements Factory<ConcurrentSessionSequencers> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ConcurrentSessionSequencers get() {
        return newInstance();
    }

    public static ConcurrentSessionSequencers_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ConcurrentSessionSequencers newInstance() {
        return new ConcurrentSessionSequencers();
    }

    private static final class InstanceHolder {
        static final ConcurrentSessionSequencers_Factory INSTANCE = new ConcurrentSessionSequencers_Factory();

        private InstanceHolder() {
        }
    }
}
