package androidx.camera.camera2.pipe.config;

import android.content.Context;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraDeviceSetupCompatFactoryFactory implements Factory<CameraDeviceSetupCompatFactory> {
    private final Provider<Context> cameraPipeContextProvider;

    private CameraPipeModule_Companion_ProvideCameraDeviceSetupCompatFactoryFactory(Provider<Context> provider) {
        this.cameraPipeContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraDeviceSetupCompatFactory get() {
        return provideCameraDeviceSetupCompatFactory(this.cameraPipeContextProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideCameraDeviceSetupCompatFactoryFactory create(Provider<Context> provider) {
        return new CameraPipeModule_Companion_ProvideCameraDeviceSetupCompatFactoryFactory(provider);
    }

    public static CameraDeviceSetupCompatFactory provideCameraDeviceSetupCompatFactory(Context context) {
        return (CameraDeviceSetupCompatFactory) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraDeviceSetupCompatFactory(context));
    }
}
