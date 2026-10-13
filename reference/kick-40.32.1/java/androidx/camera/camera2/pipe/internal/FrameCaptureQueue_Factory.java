package androidx.camera.camera2.pipe.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class FrameCaptureQueue_Factory implements Factory<FrameCaptureQueue> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameCaptureQueue get() {
        return newInstance();
    }

    public static FrameCaptureQueue_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FrameCaptureQueue newInstance() {
        return new FrameCaptureQueue();
    }

    private static final class InstanceHolder {
        static final FrameCaptureQueue_Factory INSTANCE = new FrameCaptureQueue_Factory();

        private InstanceHolder() {
        }
    }
}
