package androidx.camera.camera2.impl;

import android.content.Context;
import androidx.camera.camera2.adapter.CameraStateAdapter;
import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.config.UseCaseCameraComponent;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseManager_Factory implements Factory<UseCaseManager> {
    private final Provider<UseCaseCameraComponent.Builder> builderProvider;
    private final Provider<Camera2CameraControl> camera2CameraControlProvider;
    private final Provider<CameraCoordinator> cameraCoordinatorProvider;
    private final Provider<CameraGraphConfigProvider> cameraGraphConfigProvider;
    private final Provider<CameraInfoInternal> cameraInfoInternalProvider;
    private final Provider<CameraInternal> cameraInternalProvider;
    private final Provider<CameraPipe> cameraPipeProvider;
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<CameraStateAdapter> cameraStateAdapterProvider;
    private final Provider<CameraXConfig> cameraXConfigProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Set<UseCaseCameraControl>> controlsProvider;
    private final Provider<DisplayInfoManager> displayInfoManagerProvider;
    private final Provider<EncoderProfilesProvider> encoderProfilesProvider;
    private final Provider<LowLightBoostControl> lowLightBoostControlProvider;
    private final Provider<UseCaseThreads> useCaseThreadsProvider;
    private final Provider<ZslControl> zslControlProvider;

    private UseCaseManager_Factory(Provider<CameraPipe> provider, Provider<CameraCoordinator> provider2, Provider<UseCaseCameraComponent.Builder> provider3, Provider<ZslControl> provider4, Provider<LowLightBoostControl> provider5, Provider<Set<UseCaseCameraControl>> provider6, Provider<Camera2CameraControl> provider7, Provider<CameraStateAdapter> provider8, Provider<CameraInternal> provider9, Provider<UseCaseThreads> provider10, Provider<CameraInfoInternal> provider11, Provider<EncoderProfilesProvider> provider12, Provider<CameraProperties> provider13, Provider<CameraXConfig> provider14, Provider<CameraGraphConfigProvider> provider15, Provider<Context> provider16, Provider<DisplayInfoManager> provider17) {
        this.cameraPipeProvider = provider;
        this.cameraCoordinatorProvider = provider2;
        this.builderProvider = provider3;
        this.zslControlProvider = provider4;
        this.lowLightBoostControlProvider = provider5;
        this.controlsProvider = provider6;
        this.camera2CameraControlProvider = provider7;
        this.cameraStateAdapterProvider = provider8;
        this.cameraInternalProvider = provider9;
        this.useCaseThreadsProvider = provider10;
        this.cameraInfoInternalProvider = provider11;
        this.encoderProfilesProvider = provider12;
        this.cameraPropertiesProvider = provider13;
        this.cameraXConfigProvider = provider14;
        this.cameraGraphConfigProvider = provider15;
        this.contextProvider = provider16;
        this.displayInfoManagerProvider = provider17;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseManager get() {
        return newInstance(this.cameraPipeProvider.get(), this.cameraCoordinatorProvider.get(), this.builderProvider.get(), this.zslControlProvider.get(), this.lowLightBoostControlProvider.get(), this.controlsProvider.get(), this.camera2CameraControlProvider.get(), this.cameraStateAdapterProvider.get(), this.cameraInternalProvider, this.useCaseThreadsProvider, this.cameraInfoInternalProvider, this.encoderProfilesProvider.get(), this.cameraPropertiesProvider.get(), this.cameraXConfigProvider.get(), this.cameraGraphConfigProvider.get(), this.contextProvider.get(), this.displayInfoManagerProvider.get());
    }

    public static UseCaseManager_Factory create(Provider<CameraPipe> provider, Provider<CameraCoordinator> provider2, Provider<UseCaseCameraComponent.Builder> provider3, Provider<ZslControl> provider4, Provider<LowLightBoostControl> provider5, Provider<Set<UseCaseCameraControl>> provider6, Provider<Camera2CameraControl> provider7, Provider<CameraStateAdapter> provider8, Provider<CameraInternal> provider9, Provider<UseCaseThreads> provider10, Provider<CameraInfoInternal> provider11, Provider<EncoderProfilesProvider> provider12, Provider<CameraProperties> provider13, Provider<CameraXConfig> provider14, Provider<CameraGraphConfigProvider> provider15, Provider<Context> provider16, Provider<DisplayInfoManager> provider17) {
        return new UseCaseManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static UseCaseManager newInstance(CameraPipe cameraPipe, CameraCoordinator cameraCoordinator, UseCaseCameraComponent.Builder builder, ZslControl zslControl, LowLightBoostControl lowLightBoostControl, Set<UseCaseCameraControl> set, Camera2CameraControl camera2CameraControl, CameraStateAdapter cameraStateAdapter, javax.inject.Provider<CameraInternal> provider, javax.inject.Provider<UseCaseThreads> provider2, javax.inject.Provider<CameraInfoInternal> provider3, EncoderProfilesProvider encoderProfilesProvider, CameraProperties cameraProperties, CameraXConfig cameraXConfig, CameraGraphConfigProvider cameraGraphConfigProvider, Context context, DisplayInfoManager displayInfoManager) {
        return new UseCaseManager(cameraPipe, cameraCoordinator, builder, zslControl, lowLightBoostControl, set, camera2CameraControl, cameraStateAdapter, provider, provider2, provider3, encoderProfilesProvider, cameraProperties, cameraXConfig, cameraGraphConfigProvider, context, displayInfoManager);
    }
}
