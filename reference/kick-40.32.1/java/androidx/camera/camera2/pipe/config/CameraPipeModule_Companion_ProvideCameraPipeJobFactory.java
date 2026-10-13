package androidx.camera.camera2.pipe.config;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraPipeJobFactory implements Factory<Job> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Job get() {
        return provideCameraPipeJob();
    }

    public static CameraPipeModule_Companion_ProvideCameraPipeJobFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Job provideCameraPipeJob() {
        return (Job) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraPipeJob());
    }

    private static final class InstanceHolder {
        static final CameraPipeModule_Companion_ProvideCameraPipeJobFactory INSTANCE = new CameraPipeModule_Companion_ProvideCameraPipeJobFactory();

        private InstanceHolder() {
        }
    }
}
