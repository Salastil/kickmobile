package androidx.camera.camera2.config;

import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.adapter.CameraControlAdapter;
import androidx.camera.camera2.adapter.CameraControlStateAdapter;
import androidx.camera.camera2.adapter.CameraInfoAdapter;
import androidx.camera.camera2.adapter.CameraInternalAdapter;
import androidx.camera.camera2.adapter.CameraStateAdapter;
import androidx.camera.camera2.adapter.CaptureConfigAdapter;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.compat.Camera2CameraControlCompatImpl;
import androidx.camera.camera2.compat.EvCompImpl;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.ZoomCompat;
import androidx.camera.camera2.compat.ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.compat.workaround.AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory;
import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser;
import androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory;
import androidx.camera.camera2.compat.workaround.MeteringRegionCorrection;
import androidx.camera.camera2.compat.workaround.MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory;
import androidx.camera.camera2.compat.workaround.OutputSizesCorrector;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory;
import androidx.camera.camera2.compat.workaround.UseFlashModeTorchFor3aUpdate;
import androidx.camera.camera2.compat.workaround.UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory;
import androidx.camera.camera2.impl.CameraCallbackMap;
import androidx.camera.camera2.impl.CameraGraphConfigProvider;
import androidx.camera.camera2.impl.CameraPipeCameraProperties;
import androidx.camera.camera2.impl.CapturePipeline;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl;
import androidx.camera.camera2.impl.DisplayInfoManager;
import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.State3AControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseCamera;
import androidx.camera.camera2.impl.UseCaseCameraControl;
import androidx.camera.camera2.impl.UseCaseCameraImpl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.camera2.impl.UseCaseCameraState;
import androidx.camera.camera2.impl.UseCaseManager;
import androidx.camera.camera2.impl.UseCaseSurfaceManager;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.impl.VideoUsageControl;
import androidx.camera.camera2.impl.ZoomControl;
import androidx.camera.camera2.internal.IntrinsicZoomCalculatorImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.internal.StreamSpecsCalculator;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerCameraAppComponent {
    private DaggerCameraAppComponent() {
    }

    public static CameraAppComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements CameraAppComponent.Builder {
        private CameraAppConfig cameraAppConfig;

        private Builder() {
        }

        @Override // androidx.camera.camera2.config.CameraAppComponent.Builder
        public Builder config(CameraAppConfig cameraAppConfig) {
            this.cameraAppConfig = (CameraAppConfig) Preconditions.checkNotNull(cameraAppConfig);
            return this;
        }

        @Override // androidx.camera.camera2.config.CameraAppComponent.Builder
        public CameraAppComponent build() {
            Preconditions.checkBuilderRequirement(this.cameraAppConfig, CameraAppConfig.class);
            return new CameraAppComponentImpl(this.cameraAppConfig);
        }
    }

    private static final class CameraComponentBuilder implements CameraComponent.Builder {
        private final CameraAppComponentImpl cameraAppComponentImpl;
        private CameraConfig cameraConfig;
        private StreamSpecsCalculator streamSpecsCalculator;

        private CameraComponentBuilder(CameraAppComponentImpl cameraAppComponentImpl) {
            this.cameraAppComponentImpl = cameraAppComponentImpl;
        }

        @Override // androidx.camera.camera2.config.CameraComponent.Builder
        public CameraComponentBuilder config(CameraConfig cameraConfig) {
            this.cameraConfig = (CameraConfig) Preconditions.checkNotNull(cameraConfig);
            return this;
        }

        @Override // androidx.camera.camera2.config.CameraComponent.Builder
        public CameraComponentBuilder streamSpecsCalculator(StreamSpecsCalculator streamSpecsCalculator) {
            this.streamSpecsCalculator = (StreamSpecsCalculator) Preconditions.checkNotNull(streamSpecsCalculator);
            return this;
        }

        @Override // androidx.camera.camera2.config.CameraComponent.Builder
        public CameraComponent build() {
            Preconditions.checkBuilderRequirement(this.cameraConfig, CameraConfig.class);
            Preconditions.checkBuilderRequirement(this.streamSpecsCalculator, StreamSpecsCalculator.class);
            return new CameraComponentImpl(this.cameraAppComponentImpl, this.cameraConfig, this.streamSpecsCalculator);
        }
    }

    private static final class UseCaseCameraComponentBuilder implements UseCaseCameraComponent.Builder {
        private final CameraAppComponentImpl cameraAppComponentImpl;
        private final CameraComponentImpl cameraComponentImpl;
        private UseCaseCameraConfig useCaseCameraConfig;

        private UseCaseCameraComponentBuilder(CameraAppComponentImpl cameraAppComponentImpl, CameraComponentImpl cameraComponentImpl) {
            this.cameraAppComponentImpl = cameraAppComponentImpl;
            this.cameraComponentImpl = cameraComponentImpl;
        }

        @Override // androidx.camera.camera2.config.UseCaseCameraComponent.Builder
        public UseCaseCameraComponentBuilder config(UseCaseCameraConfig useCaseCameraConfig) {
            this.useCaseCameraConfig = (UseCaseCameraConfig) Preconditions.checkNotNull(useCaseCameraConfig);
            return this;
        }

        @Override // androidx.camera.camera2.config.UseCaseCameraComponent.Builder
        public UseCaseCameraComponent build() {
            Preconditions.checkBuilderRequirement(this.useCaseCameraConfig, UseCaseCameraConfig.class);
            return new UseCaseCameraComponentImpl(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraConfig);
        }
    }

    private static final class UseCaseCameraComponentImpl implements UseCaseCameraComponent {
        private final CameraAppComponentImpl cameraAppComponentImpl;
        private final CameraComponentImpl cameraComponentImpl;
        Provider<CaptureConfigAdapter> captureConfigAdapterProvider;
        Provider<CapturePipelineImpl> capturePipelineImplProvider;
        Provider<CapturePipelineTorchCorrection> capturePipelineTorchCorrectionProvider;
        Provider<DeferredUseCaseCameraRequestControl> deferredUseCaseCameraRequestControlProvider;
        Provider<CapturePipeline> provideCapturePipelineProvider;
        Provider<SessionConfigAdapter> provideSessionConfigAdapterProvider;
        Provider<SessionProcessor> provideSessionProcessorProvider;
        Provider<UseCaseGraphContext> provideUseCaseGraphContextProvider;
        private final UseCaseCameraComponentImpl useCaseCameraComponentImpl = this;
        private final UseCaseCameraConfig useCaseCameraConfig;
        Provider<UseCaseCameraImpl> useCaseCameraImplProvider;
        Provider<UseCaseCameraRequestControlImpl> useCaseCameraRequestControlImplProvider;
        Provider<UseCaseCameraState> useCaseCameraStateProvider;
        Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

        UseCaseCameraComponentImpl(CameraAppComponentImpl cameraAppComponentImpl, CameraComponentImpl cameraComponentImpl, UseCaseCameraConfig useCaseCameraConfig) {
            this.cameraAppComponentImpl = cameraAppComponentImpl;
            this.cameraComponentImpl = cameraComponentImpl;
            this.useCaseCameraConfig = useCaseCameraConfig;
            initialize(useCaseCameraConfig);
        }

        private void initialize(UseCaseCameraConfig useCaseCameraConfig) {
            this.provideUseCaseGraphContextProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 1));
            this.provideSessionProcessorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 2));
            this.captureConfigAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 7));
            this.useCaseCameraStateProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 8));
            this.capturePipelineImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 6));
            this.capturePipelineTorchCorrectionProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 9));
            this.provideCapturePipelineProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 5));
            this.provideSessionConfigAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 11));
            this.useCaseSurfaceManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 10));
            this.useCaseCameraRequestControlImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 4));
            this.deferredUseCaseCameraRequestControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 3));
            this.useCaseCameraImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, this.useCaseCameraComponentImpl, 0));
        }

        @Override // androidx.camera.camera2.config.UseCaseCameraComponent
        public UseCaseCamera getUseCaseCamera() {
            return this.useCaseCameraImplProvider.get();
        }

        @Override // androidx.camera.camera2.config.UseCaseCameraComponent
        public UseCaseGraphContext getUseCaseGraphContext() {
            return this.provideUseCaseGraphContextProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final CameraAppComponentImpl cameraAppComponentImpl;
            private final CameraComponentImpl cameraComponentImpl;
            private final int id;
            private final UseCaseCameraComponentImpl useCaseCameraComponentImpl;

            SwitchingProvider(CameraAppComponentImpl cameraAppComponentImpl, CameraComponentImpl cameraComponentImpl, UseCaseCameraComponentImpl useCaseCameraComponentImpl, int i) {
                this.cameraAppComponentImpl = cameraAppComponentImpl;
                this.cameraComponentImpl = cameraComponentImpl;
                this.useCaseCameraComponentImpl = useCaseCameraComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new UseCaseCameraImpl(this.useCaseCameraComponentImpl.provideUseCaseGraphContextProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.useCaseCameraComponentImpl.provideSessionProcessorProvider.get(), this.useCaseCameraComponentImpl.deferredUseCaseCameraRequestControlProvider.get(), this.useCaseCameraComponentImpl.useCaseSurfaceManagerProvider, this.useCaseCameraComponentImpl.provideSessionConfigAdapterProvider, this.useCaseCameraComponentImpl.provideCapturePipelineProvider);
                    case 1:
                        return (T) UseCaseCameraConfig_ProvideUseCaseGraphContextFactory.provideUseCaseGraphContext(this.useCaseCameraComponentImpl.useCaseCameraConfig, this.cameraComponentImpl.cameraStateAdapterProvider.get());
                    case 2:
                        return (T) this.useCaseCameraComponentImpl.useCaseCameraConfig.provideSessionProcessor();
                    case 3:
                        return (T) new DeferredUseCaseCameraRequestControl(this.useCaseCameraComponentImpl.useCaseCameraRequestControlImplProvider, this.cameraComponentImpl.provideUseCaseThreadsProvider.get());
                    case 4:
                        return (T) new UseCaseCameraRequestControlImpl(this.useCaseCameraComponentImpl.provideCapturePipelineProvider, this.useCaseCameraComponentImpl.useCaseCameraStateProvider, this.useCaseCameraComponentImpl.provideUseCaseGraphContextProvider.get(), this.useCaseCameraComponentImpl.useCaseSurfaceManagerProvider, this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), CameraAppConfig_ProvideCameraXConfigFactory.provideCameraXConfig(this.cameraAppComponentImpl.cameraAppConfig));
                    case 5:
                        return (T) UseCaseCameraModule_Companion_ProvideCapturePipelineFactory.provideCapturePipeline(this.useCaseCameraComponentImpl.capturePipelineImplProvider, this.useCaseCameraComponentImpl.capturePipelineTorchCorrectionProvider);
                    case 6:
                        return (T) new CapturePipelineImpl(this.useCaseCameraComponentImpl.captureConfigAdapterProvider.get(), this.cameraComponentImpl.flashControlProvider.get(), this.cameraComponentImpl.torchControlProvider.get(), this.cameraComponentImpl.videoUsageControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.comboRequestListenerProvider.get(), this.cameraComponentImpl.useTorchAsFlash(), this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.useCaseCameraComponentImpl.useCaseCameraStateProvider, this.useCaseCameraComponentImpl.provideUseCaseGraphContextProvider.get());
                    case 7:
                        return (T) new CaptureConfigAdapter(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.useCaseCameraComponentImpl.provideUseCaseGraphContextProvider.get(), this.cameraComponentImpl.provideZslControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.templateParamsOverride());
                    case 8:
                        return (T) new UseCaseCameraState(this.useCaseCameraComponentImpl.provideUseCaseGraphContextProvider.get(), this.cameraComponentImpl.templateParamsOverride());
                    case 9:
                        return (T) new CapturePipelineTorchCorrection(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.useCaseCameraComponentImpl.capturePipelineImplProvider, this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.torchControlProvider.get());
                    case 10:
                        return (T) new UseCaseSurfaceManager(this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), CameraAppConfig_ProvideCameraPipeFactory.provideCameraPipe(this.cameraAppComponentImpl.cameraAppConfig), this.cameraComponentImpl.inactiveSurfaceCloser(), this.useCaseCameraComponentImpl.provideSessionConfigAdapterProvider.get());
                    case 11:
                        return (T) UseCaseCameraConfig_ProvideSessionConfigAdapterFactory.provideSessionConfigAdapter(this.useCaseCameraComponentImpl.useCaseCameraConfig);
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class CameraComponentImpl implements CameraComponent {
        Provider<Camera2CameraControlCompatImpl> camera2CameraControlCompatImplProvider;
        private final CameraAppComponentImpl cameraAppComponentImpl;
        Provider<CameraCallbackMap> cameraCallbackMapProvider;
        private final CameraComponentImpl cameraComponentImpl = this;
        private final CameraConfig cameraConfig;
        Provider<CameraControlAdapter> cameraControlAdapterProvider;
        Provider<CameraControlStateAdapter> cameraControlStateAdapterProvider;
        Provider<CameraGraphConfigProvider> cameraGraphConfigProvider;
        Provider<CameraInfoAdapter> cameraInfoAdapterProvider;
        Provider<CameraInternalAdapter> cameraInternalAdapterProvider;
        Provider<CameraPipeCameraProperties> cameraPipeCameraPropertiesProvider;
        Provider<CameraQuirks> cameraQuirksProvider;
        Provider<CameraStateAdapter> cameraStateAdapterProvider;
        Provider<ComboRequestListener> comboRequestListenerProvider;
        Provider<EvCompControl> evCompControlProvider;
        Provider<EvCompImpl> evCompImplProvider;
        Provider<FlashControl> flashControlProvider;
        Provider<FocusMeteringControl> focusMeteringControlProvider;
        Provider<IntrinsicZoomCalculatorImpl> intrinsicZoomCalculatorImplProvider;
        Provider<LowLightBoostControl> lowLightBoostControlProvider;
        Provider<OutputSizesCorrector> outputSizesCorrectorProvider;
        Provider<Camera2CameraControl> provideCamera2CameraControlProvider;
        Provider<String> provideCameraIdStringProvider;
        Provider<CameraMetadata> provideCameraMetadataProvider;
        Provider<EncoderProfilesProvider> provideEncoderProfilesProvider;
        Provider<StreamConfigurationMap> provideStreamConfigurationMapProvider;
        Provider<UseCaseThreads> provideUseCaseThreadsProvider;
        Provider<ZslControl> provideZslControlProvider;
        Provider<State3AControl> state3AControlProvider;
        Provider<StillCaptureRequestControl> stillCaptureRequestControlProvider;
        Provider<StreamConfigurationMapCompat> streamConfigurationMapCompatProvider;
        private final StreamSpecsCalculator streamSpecsCalculator;
        Provider<TorchControl> torchControlProvider;
        Provider<UseCaseManager> useCaseManagerProvider;
        Provider<VideoUsageControl> videoUsageControlProvider;
        Provider<ZoomControl> zoomControlProvider;

        CameraComponentImpl(CameraAppComponentImpl cameraAppComponentImpl, CameraConfig cameraConfig, StreamSpecsCalculator streamSpecsCalculator) {
            this.cameraAppComponentImpl = cameraAppComponentImpl;
            this.cameraConfig = cameraConfig;
            this.streamSpecsCalculator = streamSpecsCalculator;
            initialize(cameraConfig, streamSpecsCalculator);
            initialize2(cameraConfig, streamSpecsCalculator);
        }

        AutoFlashAEModeDisabler autoFlashAEModeDisabler() {
            return AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory.provideAEModeDisabler(this.cameraQuirksProvider.get());
        }

        UseFlashModeTorchFor3aUpdate useFlashModeTorchFor3aUpdate() {
            return UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory.provideUseFlashModeTorchFor3aUpdate(this.cameraQuirksProvider.get());
        }

        MeteringRegionCorrection meteringRegionCorrection() {
            return MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory.provideMeteringRegionCorrection(this.cameraQuirksProvider.get());
        }

        ZoomCompat zoomCompat() {
            return ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory.provideZoomCompat(this.cameraPipeCameraPropertiesProvider.get());
        }

        Set setOfUseCaseCameraControlBuilder() {
            SetBuilder setBuilderNewSetBuilder = SetBuilder.newSetBuilder(9);
            setBuilderNewSetBuilder.add(this.evCompControlProvider.get());
            setBuilderNewSetBuilder.add(this.flashControlProvider.get());
            setBuilderNewSetBuilder.add(this.focusMeteringControlProvider.get());
            setBuilderNewSetBuilder.add(this.state3AControlProvider.get());
            setBuilderNewSetBuilder.add(this.stillCaptureRequestControlProvider.get());
            setBuilderNewSetBuilder.add(this.torchControlProvider.get());
            setBuilderNewSetBuilder.add(this.lowLightBoostControlProvider.get());
            setBuilderNewSetBuilder.add(this.videoUsageControlProvider.get());
            setBuilderNewSetBuilder.add(this.zoomControlProvider.get());
            return setBuilderNewSetBuilder.build();
        }

        Set<UseCaseCameraControl> setOfUseCaseCameraControl() {
            return setOfUseCaseCameraControlBuilder();
        }

        TemplateParamsOverride templateParamsOverride() {
            return TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory.provideTemplateParamsOverride(this.cameraQuirksProvider.get());
        }

        UseTorchAsFlash useTorchAsFlash() {
            return UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory.provideUseTorchAsFlash(this.cameraQuirksProvider.get(), this.cameraAppComponentImpl.getCameraDevices(), this.intrinsicZoomCalculatorImplProvider.get());
        }

        InactiveSurfaceCloser inactiveSurfaceCloser() {
            return InactiveSurfaceCloser_Bindings_Companion_ProvideInactiveSurfaceCloserFactory.provideInactiveSurfaceCloser(this.cameraQuirksProvider.get());
        }

        private void initialize(CameraConfig cameraConfig, StreamSpecsCalculator streamSpecsCalculator) {
            this.provideCameraMetadataProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 4));
            this.cameraPipeCameraPropertiesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 3));
            this.provideZslControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 2));
            this.provideStreamConfigurationMapProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 9));
            this.outputSizesCorrectorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 10));
            this.streamConfigurationMapCompatProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 8));
            this.cameraQuirksProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 7));
            this.provideUseCaseThreadsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 11));
            this.state3AControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 6));
            this.comboRequestListenerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 12));
            this.lowLightBoostControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 5));
            this.evCompImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 14));
            this.evCompControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 13));
            this.torchControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 16));
            this.flashControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 15));
            this.focusMeteringControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 17));
            this.stillCaptureRequestControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 18));
            this.videoUsageControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 19));
            this.zoomControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 20));
            this.camera2CameraControlCompatImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 22));
            this.provideCamera2CameraControlProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 21));
            this.cameraStateAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 23));
            this.cameraInternalAdapterProvider = new DelegateFactory();
            this.cameraControlStateAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 25));
            this.cameraCallbackMapProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 26));
        }

        private void initialize2(CameraConfig cameraConfig, StreamSpecsCalculator streamSpecsCalculator) {
            this.provideCameraIdStringProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 28));
            this.provideEncoderProfilesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 27));
            this.intrinsicZoomCalculatorImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 29));
            this.cameraInfoAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 24));
            this.cameraGraphConfigProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 30));
            this.useCaseManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 1));
            this.cameraControlAdapterProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 31));
            DelegateFactory.setDelegate((Provider) this.cameraInternalAdapterProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraAppComponentImpl, this.cameraComponentImpl, 0)));
        }

        @Override // androidx.camera.camera2.config.CameraComponent
        public CameraInternal getCameraInternal() {
            return this.cameraInternalAdapterProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final CameraAppComponentImpl cameraAppComponentImpl;
            private final CameraComponentImpl cameraComponentImpl;
            private final int id;

            SwitchingProvider(CameraAppComponentImpl cameraAppComponentImpl, CameraComponentImpl cameraComponentImpl, int i) {
                this.cameraAppComponentImpl = cameraAppComponentImpl;
                this.cameraComponentImpl = cameraComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new CameraInternalAdapter(CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig), this.cameraComponentImpl.useCaseManagerProvider.get(), this.cameraComponentImpl.cameraInfoAdapterProvider.get(), this.cameraComponentImpl.cameraControlAdapterProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.cameraStateAdapterProvider.get());
                    case 1:
                        return (T) new UseCaseManager(CameraAppConfig_ProvideCameraPipeFactory.provideCameraPipe(this.cameraAppComponentImpl.cameraAppConfig), CameraAppConfig_ProvideCameraCoordinatorFactory.provideCameraCoordinator(this.cameraAppComponentImpl.cameraAppConfig), new UseCaseCameraComponentBuilder(this.cameraAppComponentImpl, this.cameraComponentImpl), this.cameraComponentImpl.provideZslControlProvider.get(), this.cameraComponentImpl.lowLightBoostControlProvider.get(), this.cameraComponentImpl.setOfUseCaseCameraControl(), this.cameraComponentImpl.provideCamera2CameraControlProvider.get(), this.cameraComponentImpl.cameraStateAdapterProvider.get(), this.cameraComponentImpl.cameraInternalAdapterProvider, this.cameraComponentImpl.provideUseCaseThreadsProvider, this.cameraComponentImpl.cameraInfoAdapterProvider, this.cameraComponentImpl.provideEncoderProfilesProvider.get(), this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), CameraAppConfig_ProvideCameraXConfigFactory.provideCameraXConfig(this.cameraAppComponentImpl.cameraAppConfig), this.cameraComponentImpl.cameraGraphConfigProvider.get(), CameraAppConfig_ProvideContextFactory.provideContext(this.cameraAppComponentImpl.cameraAppConfig), this.cameraAppComponentImpl.displayInfoManager());
                    case 2:
                        return (T) CameraModule_Companion_ProvideZslControlFactory.provideZslControl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get());
                    case 3:
                        return (T) new CameraPipeCameraProperties(CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig), this.cameraComponentImpl.provideCameraMetadataProvider.get());
                    case 4:
                        return (T) CameraModule.INSTANCE.provideCameraMetadata(CameraAppConfig_ProvideCameraPipeFactory.provideCameraPipe(this.cameraAppComponentImpl.cameraAppConfig), CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig));
                    case 5:
                        return (T) new LowLightBoostControl(this.cameraComponentImpl.provideCameraMetadataProvider.get(), this.cameraComponentImpl.state3AControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.comboRequestListenerProvider.get());
                    case 6:
                        return (T) new State3AControl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.autoFlashAEModeDisabler(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get());
                    case 7:
                        return (T) new CameraQuirks(this.cameraComponentImpl.provideCameraMetadataProvider.get(), this.cameraComponentImpl.streamConfigurationMapCompatProvider.get());
                    case 8:
                        return (T) new StreamConfigurationMapCompat(this.cameraComponentImpl.provideStreamConfigurationMapProvider.get(), this.cameraComponentImpl.outputSizesCorrectorProvider.get());
                    case 9:
                        return (T) CameraModule.INSTANCE.provideStreamConfigurationMap(this.cameraComponentImpl.provideCameraMetadataProvider.get());
                    case 10:
                        return (T) new OutputSizesCorrector(this.cameraComponentImpl.provideCameraMetadataProvider.get(), this.cameraComponentImpl.provideStreamConfigurationMapProvider.get());
                    case 11:
                        return (T) CameraModule_Companion_ProvideUseCaseThreadsFactory.provideUseCaseThreads(CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig), CameraAppConfig_ProvideCameraThreadConfigFactory.provideCameraThreadConfig(this.cameraAppComponentImpl.cameraAppConfig));
                    case 12:
                        return (T) new ComboRequestListener();
                    case 13:
                        return (T) new EvCompControl(this.cameraComponentImpl.evCompImplProvider.get());
                    case 14:
                        return (T) new EvCompImpl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.comboRequestListenerProvider.get());
                    case 15:
                        return (T) new FlashControl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.state3AControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.torchControlProvider.get(), this.cameraComponentImpl.useFlashModeTorchFor3aUpdate());
                    case 16:
                        return (T) new TorchControl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.state3AControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get());
                    case 17:
                        return (T) new FocusMeteringControl(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.meteringRegionCorrection(), this.cameraComponentImpl.state3AControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.zoomCompat());
                    case 18:
                        return (T) new StillCaptureRequestControl(this.cameraComponentImpl.flashControlProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get());
                    case 19:
                        return (T) new VideoUsageControl();
                    case 20:
                        return (T) new ZoomControl(this.cameraComponentImpl.zoomCompat());
                    case 21:
                        return (T) CameraModule_Companion_ProvideCamera2CameraControlFactory.provideCamera2CameraControl(this.cameraComponentImpl.camera2CameraControlCompatImplProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.comboRequestListenerProvider.get());
                    case 22:
                        return (T) new Camera2CameraControlCompatImpl();
                    case 23:
                        return (T) new CameraStateAdapter();
                    case 24:
                        return (T) new CameraInfoAdapter(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig), this.cameraComponentImpl.cameraStateAdapterProvider.get(), this.cameraComponentImpl.cameraControlStateAdapterProvider.get(), this.cameraComponentImpl.cameraCallbackMapProvider.get(), this.cameraComponentImpl.focusMeteringControlProvider.get(), this.cameraComponentImpl.cameraQuirksProvider.get(), this.cameraComponentImpl.provideEncoderProfilesProvider.get(), this.cameraComponentImpl.streamConfigurationMapCompatProvider.get(), this.cameraComponentImpl.intrinsicZoomCalculatorImplProvider.get(), this.cameraComponentImpl.streamSpecsCalculator);
                    case 25:
                        return (T) new CameraControlStateAdapter(this.cameraComponentImpl.zoomControlProvider.get(), this.cameraComponentImpl.evCompControlProvider.get(), this.cameraComponentImpl.torchControlProvider.get(), this.cameraComponentImpl.lowLightBoostControlProvider.get());
                    case 26:
                        return (T) new CameraCallbackMap();
                    case 27:
                        return (T) CameraModule_Companion_ProvideEncoderProfilesProviderFactory.provideEncoderProfilesProvider(this.cameraComponentImpl.provideCameraIdStringProvider.get(), this.cameraComponentImpl.cameraQuirksProvider.get());
                    case 28:
                        return (T) CameraModule_Companion_ProvideCameraIdStringFactory.provideCameraIdString(CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig));
                    case 29:
                        return (T) new IntrinsicZoomCalculatorImpl(this.cameraAppComponentImpl.getCameraDevices());
                    case 30:
                        return (T) new CameraGraphConfigProvider(this.cameraComponentImpl.cameraCallbackMapProvider.get(), this.cameraComponentImpl.comboRequestListenerProvider.get(), CameraConfig_ProvideCameraConfigFactory.provideCameraConfig(this.cameraComponentImpl.cameraConfig), this.cameraComponentImpl.cameraQuirksProvider.get(), this.cameraComponentImpl.provideZslControlProvider.get(), this.cameraComponentImpl.templateParamsOverride(), this.cameraComponentImpl.provideCameraMetadataProvider.get(), CameraAppConfig_ProvideCameraXConfigFactory.provideCameraXConfig(this.cameraAppComponentImpl.cameraAppConfig), CameraAppConfig_ProvideCamera2InteropCallbacksFactory.provideCamera2InteropCallbacks(this.cameraAppComponentImpl.cameraAppConfig));
                    case 31:
                        return (T) new CameraControlAdapter(this.cameraComponentImpl.cameraPipeCameraPropertiesProvider.get(), this.cameraComponentImpl.evCompControlProvider.get(), this.cameraComponentImpl.flashControlProvider.get(), this.cameraComponentImpl.focusMeteringControlProvider.get(), this.cameraComponentImpl.stillCaptureRequestControlProvider.get(), this.cameraComponentImpl.torchControlProvider.get(), this.cameraComponentImpl.lowLightBoostControlProvider.get(), this.cameraComponentImpl.zoomControlProvider.get(), this.cameraComponentImpl.provideZslControlProvider.get(), this.cameraComponentImpl.provideCamera2CameraControlProvider.get(), this.cameraComponentImpl.useCaseManagerProvider.get(), this.cameraComponentImpl.provideUseCaseThreadsProvider.get(), this.cameraComponentImpl.videoUsageControlProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class CameraAppComponentImpl implements CameraAppComponent {
        private final CameraAppComponentImpl cameraAppComponentImpl = this;
        private final CameraAppConfig cameraAppConfig;

        CameraAppComponentImpl(CameraAppConfig cameraAppConfig) {
            this.cameraAppConfig = cameraAppConfig;
        }

        DisplayInfoManager displayInfoManager() {
            CameraAppConfig cameraAppConfig = this.cameraAppConfig;
            return CameraAppConfig_ProvideDisplayInfoManagerFactory.provideDisplayInfoManager(cameraAppConfig, CameraAppConfig_ProvideContextFactory.provideContext(cameraAppConfig));
        }

        @Override // androidx.camera.camera2.config.CameraAppComponent
        public CameraComponent.Builder cameraBuilder() {
            return new CameraComponentBuilder(this.cameraAppComponentImpl);
        }

        @Override // androidx.camera.camera2.config.CameraAppComponent
        public CameraPipe getCameraPipe() {
            return CameraAppConfig_ProvideCameraPipeFactory.provideCameraPipe(this.cameraAppConfig);
        }

        @Override // androidx.camera.camera2.config.CameraAppComponent
        public CameraDevices getCameraDevices() {
            return CameraAppModule_Companion_ProvideCameraDevicesFactory.provideCameraDevices(CameraAppConfig_ProvideCameraPipeFactory.provideCameraPipe(this.cameraAppConfig));
        }
    }
}
