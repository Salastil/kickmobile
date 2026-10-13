package androidx.camera.camera2.pipe.config;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.FrameGraph;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.compat.AndroidExtensionSessionFactory;
import androidx.camera.camera2.pipe.compat.AndroidMHighSpeedSessionFactory;
import androidx.camera.camera2.pipe.compat.AndroidMSessionFactory;
import androidx.camera.camera2.pipe.compat.AndroidNSessionFactory;
import androidx.camera.camera2.pipe.compat.AndroidPSessionFactory;
import androidx.camera.camera2.pipe.compat.AudioRestrictionController;
import androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl;
import androidx.camera.camera2.pipe.compat.Camera2Backend;
import androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.compat.Camera2CameraOpener;
import androidx.camera.camera2.pipe.compat.Camera2CaptureSessionsModule_ProvideSessionFactoryFactory;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCache;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl;
import androidx.camera.camera2.pipe.compat.Camera2ErrorProcessor;
import androidx.camera.camera2.pipe.compat.Camera2MetadataCache;
import androidx.camera.camera2.pipe.compat.Camera2Quirks;
import androidx.camera.camera2.pipe.compat.CameraStateOpener;
import androidx.camera.camera2.pipe.compat.CaptureSessionFactory;
import androidx.camera.camera2.pipe.compat.ConcurrentSessionSequencers;
import androidx.camera.camera2.pipe.compat.DevicePolicyManagerWrapper;
import androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager;
import androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl;
import androidx.camera.camera2.pipe.compat.StandardCamera2CaptureSequenceProcessorFactory;
import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.SystemClockOffsets;
import androidx.camera.camera2.pipe.core.SystemTimeSource;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.framegraph.FrameGraphBuffers;
import androidx.camera.camera2.pipe.framegraph.FrameGraphImpl;
import androidx.camera.camera2.pipe.graph.CameraGraphImpl;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import androidx.camera.camera2.pipe.graph.GraphProcessorImpl;
import androidx.camera.camera2.pipe.graph.GraphState3A;
import androidx.camera.camera2.pipe.graph.Listener3A;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.graph.SurfaceGraph;
import androidx.camera.camera2.pipe.internal.CameraDevicesImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.camera.camera2.pipe.internal.CameraStatusMonitor;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.camera.camera2.pipe.media.ImageReaderImageSources;
import androidx.camera.camera2.pipe.media.ImageSources;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerCameraPipeComponent {
    private DaggerCameraPipeComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CameraPipeConfigModule cameraPipeConfigModule;
        private ThreadConfigModule threadConfigModule;

        private Builder() {
        }

        public Builder cameraPipeConfigModule(CameraPipeConfigModule cameraPipeConfigModule) {
            this.cameraPipeConfigModule = (CameraPipeConfigModule) Preconditions.checkNotNull(cameraPipeConfigModule);
            return this;
        }

        public Builder threadConfigModule(ThreadConfigModule threadConfigModule) {
            this.threadConfigModule = (ThreadConfigModule) Preconditions.checkNotNull(threadConfigModule);
            return this;
        }

        public CameraPipeComponent build() {
            Preconditions.checkBuilderRequirement(this.cameraPipeConfigModule, CameraPipeConfigModule.class);
            Preconditions.checkBuilderRequirement(this.threadConfigModule, ThreadConfigModule.class);
            return new CameraPipeComponentImpl(this.cameraPipeConfigModule, this.threadConfigModule);
        }
    }

    private static final class CameraGraphComponentBuilder implements CameraGraphComponent.Builder {
        private CameraGraphConfigModule cameraGraphConfigModule;
        private final CameraPipeComponentImpl cameraPipeComponentImpl;

        private CameraGraphComponentBuilder(CameraPipeComponentImpl cameraPipeComponentImpl) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent.Builder
        public CameraGraphComponentBuilder cameraGraphConfigModule(CameraGraphConfigModule cameraGraphConfigModule) {
            this.cameraGraphConfigModule = (CameraGraphConfigModule) Preconditions.checkNotNull(cameraGraphConfigModule);
            return this;
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent.Builder
        public CameraGraphComponent build() {
            Preconditions.checkBuilderRequirement(this.cameraGraphConfigModule, CameraGraphConfigModule.class);
            return new CameraGraphComponentImpl(this.cameraPipeComponentImpl, this.cameraGraphConfigModule);
        }
    }

    private static final class FrameGraphComponentBuilder implements FrameGraphComponent.Builder {
        private final CameraPipeComponentImpl cameraPipeComponentImpl;
        private FrameGraphConfigModule frameGraphConfigModule;

        private FrameGraphComponentBuilder(CameraPipeComponentImpl cameraPipeComponentImpl) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
        }

        @Override // androidx.camera.camera2.pipe.config.FrameGraphComponent.Builder
        public FrameGraphComponentBuilder frameGraphConfigModule(FrameGraphConfigModule frameGraphConfigModule) {
            this.frameGraphConfigModule = (FrameGraphConfigModule) Preconditions.checkNotNull(frameGraphConfigModule);
            return this;
        }

        @Override // androidx.camera.camera2.pipe.config.FrameGraphComponent.Builder
        public FrameGraphComponent build() {
            Preconditions.checkBuilderRequirement(this.frameGraphConfigModule, FrameGraphConfigModule.class);
            return new FrameGraphComponentImpl(this.cameraPipeComponentImpl, this.frameGraphConfigModule);
        }
    }

    private static final class Camera2ControllerComponentBuilder implements Camera2ControllerComponent.Builder {
        private Camera2ControllerConfig camera2ControllerConfig;
        private final CameraPipeComponentImpl cameraPipeComponentImpl;

        private Camera2ControllerComponentBuilder(CameraPipeComponentImpl cameraPipeComponentImpl) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
        }

        @Override // androidx.camera.camera2.pipe.config.Camera2ControllerComponent.Builder
        public Camera2ControllerComponentBuilder camera2ControllerConfig(Camera2ControllerConfig camera2ControllerConfig) {
            this.camera2ControllerConfig = (Camera2ControllerConfig) Preconditions.checkNotNull(camera2ControllerConfig);
            return this;
        }

        @Override // androidx.camera.camera2.pipe.config.Camera2ControllerComponent.Builder
        public Camera2ControllerComponent build() {
            Preconditions.checkBuilderRequirement(this.camera2ControllerConfig, Camera2ControllerConfig.class);
            return new Camera2ControllerComponentImpl(this.cameraPipeComponentImpl, this.camera2ControllerConfig);
        }
    }

    private static final class CameraGraphComponentImpl implements CameraGraphComponent {
        private final CameraGraphComponentImpl cameraGraphComponentImpl = this;
        private final CameraGraphConfigModule cameraGraphConfigModule;
        Provider<CameraGraphImpl> cameraGraphImplProvider;
        Provider<CameraGraphParametersImpl> cameraGraphParametersImplProvider;
        Provider<CameraGraphRequestListenersImpl> cameraGraphRequestListenersImplProvider;
        private final CameraPipeComponentImpl cameraPipeComponentImpl;
        Provider<Controller3A> controller3AProvider;
        Provider<FrameCaptureQueue> frameCaptureQueueProvider;
        Provider<GraphProcessorImpl> graphProcessorImplProvider;
        Provider<GraphSessionLock> graphSessionLockProvider;
        Provider<GraphState3A> graphState3AProvider;
        Provider<Listener3A> listener3AProvider;
        Provider<CameraBackend> provideCameraBackendProvider;
        Provider<CameraController> provideCameraControllerProvider;
        Provider<CoroutineScope> provideCameraGraphCoroutineScopeProvider;
        Provider<CameraMetadata> provideCameraMetadataProvider;
        Provider<FrameDistributor> provideFrameDistributorProvider;
        Provider<List<Request.Listener>> provideRequestListenersProvider;
        Provider<SurfaceGraph> provideSurfaceGraphProvider;
        Provider<SystemClockOffsets> provideSystemClockOffsetsProvider;
        Provider<StreamGraphImpl> streamGraphImplProvider;

        CameraGraphComponentImpl(CameraPipeComponentImpl cameraPipeComponentImpl, CameraGraphConfigModule cameraGraphConfigModule) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
            this.cameraGraphConfigModule = cameraGraphConfigModule;
            initialize(cameraGraphConfigModule);
        }

        private void initialize(CameraGraphConfigModule cameraGraphConfigModule) {
            this.provideCameraBackendProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 2));
            this.provideCameraMetadataProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 1));
            this.listener3AProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 4));
            this.graphProcessorImplProvider = new DelegateFactory();
            this.streamGraphImplProvider = new DelegateFactory();
            this.provideCameraControllerProvider = new DelegateFactory();
            this.provideSurfaceGraphProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 9));
            DelegateFactory.setDelegate((Provider) this.provideCameraControllerProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 8)));
            DelegateFactory.setDelegate((Provider) this.streamGraphImplProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 7)));
            this.frameCaptureQueueProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 10));
            this.provideSystemClockOffsetsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 11));
            this.provideFrameDistributorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 6));
            this.provideRequestListenersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 5));
            DelegateFactory.setDelegate((Provider) this.graphProcessorImplProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 3)));
            this.graphSessionLockProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 13));
            this.provideCameraGraphCoroutineScopeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 14));
            this.cameraGraphParametersImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 12));
            this.cameraGraphRequestListenersImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 15));
            this.graphState3AProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 17));
            this.controller3AProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 16));
            this.cameraGraphImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.cameraGraphComponentImpl, 0));
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public CameraGraph cameraGraph() {
            return this.cameraGraphImplProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public GraphProcessor graphProcessor() {
            return this.graphProcessorImplProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public FrameCaptureQueue frameCaptureQueue() {
            return this.frameCaptureQueueProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public GraphSessionLock sessionLock() {
            return this.graphSessionLockProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public FrameDistributor frameDistributor() {
            return this.provideFrameDistributorProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraGraphComponent
        public Controller3A controller3A() {
            return this.controller3AProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final CameraGraphComponentImpl cameraGraphComponentImpl;
            private final CameraPipeComponentImpl cameraPipeComponentImpl;
            private final int id;

            SwitchingProvider(CameraPipeComponentImpl cameraPipeComponentImpl, CameraGraphComponentImpl cameraGraphComponentImpl, int i) {
                this.cameraPipeComponentImpl = cameraPipeComponentImpl;
                this.cameraGraphComponentImpl = cameraGraphComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new CameraGraphImpl(CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.provideCameraMetadataProvider.get(), this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.streamGraphImplProvider.get(), this.cameraGraphComponentImpl.provideSurfaceGraphProvider.get(), this.cameraGraphComponentImpl.provideCameraControllerProvider.get(), this.cameraGraphComponentImpl.provideFrameDistributorProvider.get(), this.cameraGraphComponentImpl.frameCaptureQueueProvider.get(), this.cameraPipeComponentImpl.audioRestrictionControllerImplProvider.get(), CameraGraphConfigModule_ProvideCameraGraphIdFactory.provideCameraGraphId(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.cameraGraphParametersImplProvider.get(), this.cameraGraphComponentImpl.cameraGraphRequestListenersImplProvider.get(), this.cameraGraphComponentImpl.graphSessionLockProvider.get(), this.cameraGraphComponentImpl.provideCameraGraphCoroutineScopeProvider.get(), this.cameraGraphComponentImpl.controller3AProvider.get());
                    case 1:
                        return (T) InternalCameraGraphModules_Companion_ProvideCameraMetadataFactory.provideCameraMetadata(CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.provideCameraBackendProvider.get());
                    case 2:
                        return (T) InternalCameraGraphModules_Companion_ProvideCameraBackendFactory.provideCameraBackend(this.cameraPipeComponentImpl.provideCameraBackendsProvider.get(), CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraPipeComponentImpl.provideCameraContextProvider.get());
                    case 3:
                        return (T) new GraphProcessorImpl(this.cameraPipeComponentImpl.provideThreadsProvider.get(), CameraGraphConfigModule_ProvideCameraGraphIdFactory.provideCameraGraphId(this.cameraGraphComponentImpl.cameraGraphConfigModule), CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.listener3AProvider.get(), this.cameraGraphComponentImpl.provideRequestListenersProvider.get(), this.cameraPipeComponentImpl.camera2QuirksProvider.get());
                    case 4:
                        return (T) new Listener3A();
                    case 5:
                        return (T) SharedCameraGraphModules_Companion_ProvideRequestListenersFactory.provideRequestListeners(CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.listener3AProvider.get(), this.cameraGraphComponentImpl.provideFrameDistributorProvider.get());
                    case 6:
                        return (T) SharedCameraGraphModules_Companion_ProvideFrameDistributorFactory.provideFrameDistributor(this.cameraGraphComponentImpl.streamGraphImplProvider.get(), this.cameraGraphComponentImpl.frameCaptureQueueProvider.get(), this.cameraGraphComponentImpl.provideCameraMetadataProvider.get(), this.cameraGraphComponentImpl.provideSystemClockOffsetsProvider.get());
                    case 7:
                        return (T) new StreamGraphImpl(this.cameraGraphComponentImpl.provideCameraMetadataProvider.get(), CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraPipeComponentImpl.imageSources(), this.cameraGraphComponentImpl.provideCameraControllerProvider);
                    case 8:
                        return (T) InternalCameraGraphModules_Companion_ProvideCameraControllerFactory.provideCameraController(CameraGraphConfigModule_ProvideCameraGraphIdFactory.provideCameraGraphId(this.cameraGraphComponentImpl.cameraGraphConfigModule), CameraGraphConfigModule_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.cameraGraphComponentImpl.cameraGraphConfigModule), this.cameraGraphComponentImpl.provideCameraBackendProvider.get(), this.cameraPipeComponentImpl.provideCameraContextProvider.get(), this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.streamGraphImplProvider.get(), this.cameraGraphComponentImpl.provideSurfaceGraphProvider.get());
                    case 9:
                        return (T) SharedCameraGraphModules_Companion_ProvideSurfaceGraphFactory.provideSurfaceGraph(this.cameraGraphComponentImpl.streamGraphImplProvider.get(), this.cameraGraphComponentImpl.provideCameraControllerProvider, this.cameraPipeComponentImpl.provideCameraSurfaceManagerProvider.get());
                    case 10:
                        return (T) new FrameCaptureQueue();
                    case 11:
                        return (T) SharedCameraGraphModules_Companion_ProvideSystemClockOffsetsFactory.provideSystemClockOffsets();
                    case 12:
                        return (T) new CameraGraphParametersImpl(this.cameraGraphComponentImpl.graphSessionLockProvider.get(), this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.provideCameraGraphCoroutineScopeProvider.get());
                    case 13:
                        return (T) new GraphSessionLock();
                    case 14:
                        return (T) SharedCameraGraphModules_Companion_ProvideCameraGraphCoroutineScopeFactory.provideCameraGraphCoroutineScope(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 15:
                        return (T) new CameraGraphRequestListenersImpl(this.cameraGraphComponentImpl.graphSessionLockProvider.get(), this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.provideCameraGraphCoroutineScopeProvider.get());
                    case 16:
                        return (T) new Controller3A(this.cameraGraphComponentImpl.graphProcessorImplProvider.get(), this.cameraGraphComponentImpl.provideCameraMetadataProvider.get(), this.cameraGraphComponentImpl.graphState3AProvider.get(), this.cameraGraphComponentImpl.listener3AProvider.get());
                    case 17:
                        return (T) new GraphState3A();
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class FrameGraphComponentImpl implements FrameGraphComponent {
        private final CameraPipeComponentImpl cameraPipeComponentImpl;
        Provider<FrameGraphBuffers> frameGraphBuffersProvider;
        private final FrameGraphComponentImpl frameGraphComponentImpl = this;
        private final FrameGraphConfigModule frameGraphConfigModule;
        Provider<FrameGraphImpl> frameGraphImplProvider;
        Provider<CoroutineScope> provideFrameGraphCoroutineScopeProvider;

        FrameGraphComponentImpl(CameraPipeComponentImpl cameraPipeComponentImpl, FrameGraphConfigModule frameGraphConfigModule) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
            this.frameGraphConfigModule = frameGraphConfigModule;
            initialize(frameGraphConfigModule);
        }

        private void initialize(FrameGraphConfigModule frameGraphConfigModule) {
            this.provideFrameGraphCoroutineScopeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.frameGraphComponentImpl, 2));
            this.frameGraphBuffersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.frameGraphComponentImpl, 1));
            this.frameGraphImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.frameGraphComponentImpl, 0));
        }

        @Override // androidx.camera.camera2.pipe.config.FrameGraphComponent
        public FrameGraph frameGraph() {
            return this.frameGraphImplProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final CameraPipeComponentImpl cameraPipeComponentImpl;
            private final FrameGraphComponentImpl frameGraphComponentImpl;
            private final int id;

            SwitchingProvider(CameraPipeComponentImpl cameraPipeComponentImpl, FrameGraphComponentImpl frameGraphComponentImpl, int i) {
                this.cameraPipeComponentImpl = cameraPipeComponentImpl;
                this.frameGraphComponentImpl = frameGraphComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                int i = this.id;
                if (i == 0) {
                    return (T) new FrameGraphImpl(FrameGraphConfigModule_ProvideCameraGraphFactory.provideCameraGraph(this.frameGraphComponentImpl.frameGraphConfigModule), FrameGraphConfigModule_ProvideFrameDistributorFactory.provideFrameDistributor(this.frameGraphComponentImpl.frameGraphConfigModule), this.frameGraphComponentImpl.frameGraphBuffersProvider.get(), this.frameGraphComponentImpl.provideFrameGraphCoroutineScopeProvider.get(), FrameGraphConfigModule_ProvideController3AFactory.provideController3A(this.frameGraphComponentImpl.frameGraphConfigModule));
                }
                if (i == 1) {
                    return (T) new FrameGraphBuffers(FrameGraphConfigModule_ProvideCameraGraphFactory.provideCameraGraph(this.frameGraphComponentImpl.frameGraphConfigModule), this.frameGraphComponentImpl.provideFrameGraphCoroutineScopeProvider.get());
                }
                if (i == 2) {
                    return (T) FrameGraphModule_Companion_ProvideFrameGraphCoroutineScopeFactory.provideFrameGraphCoroutineScope(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class Camera2ControllerComponentImpl implements Camera2ControllerComponent {
        Provider<AndroidExtensionSessionFactory> androidExtensionSessionFactoryProvider;
        Provider<AndroidMHighSpeedSessionFactory> androidMHighSpeedSessionFactoryProvider;
        Provider<AndroidMSessionFactory> androidMSessionFactoryProvider;
        Provider<AndroidNSessionFactory> androidNSessionFactoryProvider;
        Provider<AndroidPSessionFactory> androidPSessionFactoryProvider;
        Provider<Camera2CameraController> camera2CameraControllerProvider;
        private final Camera2ControllerComponentImpl camera2ControllerComponentImpl = this;
        private final Camera2ControllerConfig camera2ControllerConfig;
        private final CameraPipeComponentImpl cameraPipeComponentImpl;
        Provider<CameraStatusMonitor> provideCameraStatusMonitorProvider;
        Provider<CoroutineScope> provideCoroutineScopeProvider;
        Provider<CaptureSessionFactory> provideSessionFactoryProvider;

        Camera2ControllerComponentImpl(CameraPipeComponentImpl cameraPipeComponentImpl, Camera2ControllerConfig camera2ControllerConfig) {
            this.cameraPipeComponentImpl = cameraPipeComponentImpl;
            this.camera2ControllerConfig = camera2ControllerConfig;
            initialize(camera2ControllerConfig);
        }

        StandardCamera2CaptureSequenceProcessorFactory standardCamera2CaptureSequenceProcessorFactory() {
            return new StandardCamera2CaptureSequenceProcessorFactory(this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerConfig), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerConfig), this.cameraPipeComponentImpl.camera2QuirksProvider.get(), this.cameraPipeComponentImpl.provideStrictModeProvider.get());
        }

        private void initialize(Camera2ControllerConfig camera2ControllerConfig) {
            this.provideCoroutineScopeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 1));
            this.provideCameraStatusMonitorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 2));
            this.androidMSessionFactoryProvider = new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 4);
            this.androidMHighSpeedSessionFactoryProvider = new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 5);
            this.androidNSessionFactoryProvider = new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 6);
            this.androidPSessionFactoryProvider = new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 7);
            this.androidExtensionSessionFactoryProvider = new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 8);
            this.provideSessionFactoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 3));
            this.camera2CameraControllerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, this.camera2ControllerComponentImpl, 0));
        }

        @Override // androidx.camera.camera2.pipe.config.Camera2ControllerComponent
        public CameraController cameraController() {
            return this.camera2CameraControllerProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final Camera2ControllerComponentImpl camera2ControllerComponentImpl;
            private final CameraPipeComponentImpl cameraPipeComponentImpl;
            private final int id;

            SwitchingProvider(CameraPipeComponentImpl cameraPipeComponentImpl, Camera2ControllerComponentImpl camera2ControllerComponentImpl, int i) {
                this.cameraPipeComponentImpl = cameraPipeComponentImpl;
                this.camera2ControllerComponentImpl = camera2ControllerComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new Camera2CameraController(this.camera2ControllerComponentImpl.provideCoroutineScopeProvider.get(), this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.provideStrictModeProvider.get(), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideGraphListenerFactory.provideGraphListener(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideSurfaceGraphFactory.provideSurfaceGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), this.camera2ControllerComponentImpl.provideCameraStatusMonitorProvider.get(), this.camera2ControllerComponentImpl.provideSessionFactoryProvider.get(), this.camera2ControllerComponentImpl.standardCamera2CaptureSequenceProcessorFactory(), this.cameraPipeComponentImpl.pruningCamera2DeviceManagerProvider.get(), this.cameraPipeComponentImpl.provideCameraSurfaceManagerProvider.get(), this.cameraPipeComponentImpl.camera2QuirksProvider.get(), this.cameraPipeComponentImpl.systemTimeSourceProvider.get(), Camera2ControllerConfig_ProvideCameraGraphIdFactory.provideCameraGraphId(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideShutdownListenerFactory.provideShutdownListener(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), this.cameraPipeComponentImpl.concurrentSessionSequencersProvider.get());
                    case 1:
                        return (T) Camera2ControllerModule_Companion_ProvideCoroutineScopeFactory.provideCoroutineScope(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 2:
                        return (T) Camera2ControllerModule_Companion_ProvideCameraStatusMonitorFactory.provideCameraStatusMonitor(this.cameraPipeComponentImpl.provideCameraManagerProvider, this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 3:
                        return (T) Camera2CaptureSessionsModule_ProvideSessionFactoryFactory.provideSessionFactory(this.camera2ControllerComponentImpl.androidMSessionFactoryProvider, this.camera2ControllerComponentImpl.androidMHighSpeedSessionFactoryProvider, this.camera2ControllerComponentImpl.androidNSessionFactoryProvider, this.camera2ControllerComponentImpl.androidPSessionFactoryProvider, this.camera2ControllerComponentImpl.androidExtensionSessionFactoryProvider, Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig));
                    case 4:
                        return (T) new AndroidMSessionFactory(this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig));
                    case 5:
                        return (T) new AndroidMHighSpeedSessionFactory(Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), this.cameraPipeComponentImpl.provideThreadsProvider.get());
                    case 6:
                        return (T) new AndroidNSessionFactory(this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig));
                    case 7:
                        return (T) new AndroidPSessionFactory(this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig));
                    case 8:
                        return (T) new AndroidExtensionSessionFactory(this.cameraPipeComponentImpl.provideThreadsProvider.get(), Camera2ControllerConfig_ProvideCameraGraphConfigFactory.provideCameraGraphConfig(this.camera2ControllerComponentImpl.camera2ControllerConfig), Camera2ControllerConfig_ProvideStreamGraphFactory.provideStreamGraph(this.camera2ControllerComponentImpl.camera2ControllerConfig), this.cameraPipeComponentImpl.camera2MetadataCacheProvider.get(), this.cameraPipeComponentImpl.provideStrictModeProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class CameraPipeComponentImpl implements CameraPipeComponent {
        Provider<AudioRestrictionControllerImpl> audioRestrictionControllerImplProvider;
        Provider<Camera2Backend> camera2BackendProvider;
        Provider<Camera2DeviceCache> camera2DeviceCacheProvider;
        Provider<Camera2DeviceCloserImpl> camera2DeviceCloserImplProvider;
        Provider<Camera2ErrorProcessor> camera2ErrorProcessorProvider;
        Provider<Camera2MetadataCache> camera2MetadataCacheProvider;
        Provider<Camera2Quirks> camera2QuirksProvider;
        Provider<CameraDevicesImpl> cameraDevicesImplProvider;
        private final CameraPipeComponentImpl cameraPipeComponentImpl = this;
        private final CameraPipeConfigModule cameraPipeConfigModule;
        Provider<CameraPipeLifetime> cameraPipeLifetimeProvider;
        Provider<ConcurrentSessionSequencers> concurrentSessionSequencersProvider;
        Provider<Permissions> permissionsProvider;
        Provider<CameraBackends> provideCameraBackendsProvider;
        Provider<CameraContext> provideCameraContextProvider;
        Provider<CameraDeviceSetupCompatFactory> provideCameraDeviceSetupCompatFactoryProvider;
        Provider<CameraManager> provideCameraManagerProvider;
        Provider<Job> provideCameraPipeJobProvider;
        Provider<CameraSurfaceManager> provideCameraSurfaceManagerProvider;
        Provider<DevicePolicyManagerWrapper> provideDevicePolicyManagerWrapperProvider;
        Provider<PackageManager> providePackageManagerProvider;
        Provider<StrictMode> provideStrictModeProvider;
        Provider<Threads> provideThreadsProvider;
        Provider<PruningCamera2DeviceManager> pruningCamera2DeviceManagerProvider;
        Provider<RetryingCameraStateOpenerImpl> retryingCameraStateOpenerImplProvider;
        Provider<SystemTimeSource> systemTimeSourceProvider;
        private final ThreadConfigModule threadConfigModule;

        CameraPipeComponentImpl(CameraPipeConfigModule cameraPipeConfigModule, ThreadConfigModule threadConfigModule) {
            this.cameraPipeConfigModule = cameraPipeConfigModule;
            this.threadConfigModule = threadConfigModule;
            initialize(cameraPipeConfigModule, threadConfigModule);
        }

        Context cameraPipeContextContext() {
            return CameraPipeModule_Companion_ProvideContextFactory.provideContext(CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(this.cameraPipeConfigModule));
        }

        CameraPipe.CameraMetadataConfig cameraMetadataConfig() {
            return CameraPipeModule_Companion_ProvideCameraMetadataConfigFactory.provideCameraMetadataConfig(CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(this.cameraPipeConfigModule));
        }

        Camera2CameraOpener camera2CameraOpener() {
            return new Camera2CameraOpener(this.provideCameraManagerProvider, this.provideThreadsProvider.get());
        }

        CameraPipe.CameraInteropConfig cameraInteropConfig() {
            CameraPipeConfigModule cameraPipeConfigModule = this.cameraPipeConfigModule;
            return CameraPipeConfigModule_ProvideCameraInteropConfigFactory.provideCameraInteropConfig(cameraPipeConfigModule, CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(cameraPipeConfigModule));
        }

        CameraStateOpener cameraStateOpener() {
            return new CameraStateOpener(camera2CameraOpener(), this.camera2MetadataCacheProvider.get(), this.camera2ErrorProcessorProvider.get(), this.camera2QuirksProvider.get(), this.systemTimeSourceProvider.get(), cameraInteropConfig(), this.provideThreadsProvider.get());
        }

        Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor() {
            return new Camera2CameraAvailabilityMonitor(this.provideCameraManagerProvider, this.provideThreadsProvider.get(), this.provideCameraPipeJobProvider.get());
        }

        ImageReaderImageSources imageReaderImageSources() {
            return new ImageReaderImageSources(this.provideThreadsProvider.get(), CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(this.cameraPipeConfigModule));
        }

        ImageSources imageSources() {
            return CameraPipeModule_Companion_ConfigureImageSourcesFactory.configureImageSources(imageReaderImageSources(), CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(this.cameraPipeConfigModule));
        }

        private void initialize(CameraPipeConfigModule cameraPipeConfigModule, ThreadConfigModule threadConfigModule) {
            this.provideCameraPipeJobProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 1));
            this.cameraPipeLifetimeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 0));
            this.provideThreadsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 5));
            this.provideCameraManagerProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 7));
            this.providePackageManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 8));
            this.camera2ErrorProcessorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 9));
            this.provideCameraDeviceSetupCompatFactoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 10));
            this.camera2DeviceCacheProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 6));
            this.permissionsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 12));
            this.systemTimeSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 13));
            this.camera2MetadataCacheProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 11));
            this.provideStrictModeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 17));
            this.camera2QuirksProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 16));
            this.provideDevicePolicyManagerWrapperProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 18));
            this.audioRestrictionControllerImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 19));
            this.retryingCameraStateOpenerImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 15));
            this.camera2DeviceCloserImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 20));
            this.pruningCamera2DeviceManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 14));
            this.camera2BackendProvider = new SwitchingProvider(this.cameraPipeComponentImpl, 4);
            this.provideCameraBackendsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 3));
            this.cameraDevicesImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 2));
            this.provideCameraContextProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 21));
            this.provideCameraSurfaceManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 22));
            this.concurrentSessionSequencersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.cameraPipeComponentImpl, 23));
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraPipeLifetime cameraPipeLifetime() {
            return this.cameraPipeLifetimeProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraGraphComponent.Builder cameraGraphComponentBuilder() {
            return new CameraGraphComponentBuilder(this.cameraPipeComponentImpl);
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public FrameGraphComponent.Builder frameGraphComponentBuilder() {
            return new FrameGraphComponentBuilder(this.cameraPipeComponentImpl);
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraDevices cameras() {
            return this.cameraDevicesImplProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraBackends cameraBackends() {
            return this.provideCameraBackendsProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraContext cameraContext() {
            return this.provideCameraContextProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public CameraSurfaceManager cameraSurfaceManager() {
            return this.provideCameraSurfaceManagerProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public AudioRestrictionController cameraAudioRestrictionController() {
            return this.audioRestrictionControllerImplProvider.get();
        }

        @Override // androidx.camera.camera2.pipe.config.CameraPipeComponent
        public ConcurrentSessionSequencers concurrentSessionSequencers() {
            return this.concurrentSessionSequencersProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final CameraPipeComponentImpl cameraPipeComponentImpl;
            private final int id;

            SwitchingProvider(CameraPipeComponentImpl cameraPipeComponentImpl, int i) {
                this.cameraPipeComponentImpl = cameraPipeComponentImpl;
                this.id = i;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new CameraPipeLifetime(this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 1:
                        return (T) CameraPipeModule_Companion_ProvideCameraPipeJobFactory.provideCameraPipeJob();
                    case 2:
                        return (T) new CameraDevicesImpl(this.cameraPipeComponentImpl.provideCameraBackendsProvider.get());
                    case 3:
                        return (T) CameraPipeModule_Companion_ProvideCameraBackendsFactory.provideCameraBackends(CameraPipeConfigModule_ProvideCameraPipeConfigFactory.provideCameraPipeConfig(this.cameraPipeComponentImpl.cameraPipeConfigModule), this.cameraPipeComponentImpl.camera2BackendProvider, this.cameraPipeComponentImpl.cameraPipeContextContext(), this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.cameraPipeLifetimeProvider.get());
                    case 4:
                        return (T) new Camera2Backend(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.camera2DeviceCacheProvider.get(), this.cameraPipeComponentImpl.camera2MetadataCacheProvider.get(), this.cameraPipeComponentImpl.pruningCamera2DeviceManagerProvider.get(), new Camera2ControllerComponentBuilder(this.cameraPipeComponentImpl), this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 5:
                        return (T) ThreadConfigModule_ProvideThreadsFactory.provideThreads(this.cameraPipeComponentImpl.threadConfigModule, this.cameraPipeComponentImpl.cameraPipeLifetimeProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 6:
                        return (T) new Camera2DeviceCache(this.cameraPipeComponentImpl.provideCameraManagerProvider, this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.cameraPipeContextContext(), this.cameraPipeComponentImpl.providePackageManagerProvider.get(), this.cameraPipeComponentImpl.camera2ErrorProcessorProvider.get(), this.cameraPipeComponentImpl.provideCameraDeviceSetupCompatFactoryProvider, this.cameraPipeComponentImpl.cameraPipeLifetimeProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 7:
                        return (T) CameraPipeModule_Companion_ProvideCameraManagerFactory.provideCameraManager(this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 8:
                        return (T) CameraPipeModule_Companion_ProvidePackageManagerFactory.providePackageManager(this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 9:
                        return (T) new Camera2ErrorProcessor();
                    case 10:
                        return (T) CameraPipeModule_Companion_ProvideCameraDeviceSetupCompatFactoryFactory.provideCameraDeviceSetupCompatFactory(this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 11:
                        return (T) new Camera2MetadataCache(this.cameraPipeComponentImpl.cameraPipeContextContext(), this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.permissionsProvider.get(), this.cameraPipeComponentImpl.cameraMetadataConfig(), this.cameraPipeComponentImpl.systemTimeSourceProvider.get());
                    case 12:
                        return (T) new Permissions(this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 13:
                        return (T) new SystemTimeSource();
                    case 14:
                        return (T) new PruningCamera2DeviceManager(this.cameraPipeComponentImpl.permissionsProvider.get(), this.cameraPipeComponentImpl.retryingCameraStateOpenerImplProvider.get(), this.cameraPipeComponentImpl.camera2DeviceCloserImplProvider.get(), this.cameraPipeComponentImpl.camera2ErrorProcessorProvider.get(), this.cameraPipeComponentImpl.provideThreadsProvider.get());
                    case 15:
                        return (T) new RetryingCameraStateOpenerImpl(this.cameraPipeComponentImpl.cameraStateOpener(), this.cameraPipeComponentImpl.camera2ErrorProcessorProvider.get(), this.cameraPipeComponentImpl.camera2CameraAvailabilityMonitor(), this.cameraPipeComponentImpl.systemTimeSourceProvider.get(), this.cameraPipeComponentImpl.provideDevicePolicyManagerWrapperProvider.get(), this.cameraPipeComponentImpl.audioRestrictionControllerImplProvider.get(), this.cameraPipeComponentImpl.cameraInteropConfig(), this.cameraPipeComponentImpl.provideThreadsProvider.get());
                    case 16:
                        return (T) new Camera2Quirks(this.cameraPipeComponentImpl.camera2MetadataCacheProvider.get(), this.cameraPipeComponentImpl.provideStrictModeProvider.get());
                    case 17:
                        return (T) CameraPipeModule_Companion_ProvideStrictModeFactory.provideStrictMode(CameraPipeConfigModule_ProvideCameraPipeFlagsFactory.provideCameraPipeFlags(this.cameraPipeComponentImpl.cameraPipeConfigModule));
                    case 18:
                        return (T) CameraPipeModule_Companion_ProvideDevicePolicyManagerWrapperFactory.provideDevicePolicyManagerWrapper(this.cameraPipeComponentImpl.cameraPipeContextContext());
                    case 19:
                        return (T) new AudioRestrictionControllerImpl(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.cameraPipeLifetimeProvider.get(), this.cameraPipeComponentImpl.provideCameraPipeJobProvider.get());
                    case 20:
                        return (T) new Camera2DeviceCloserImpl(this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.camera2QuirksProvider.get(), this.cameraPipeComponentImpl.retryingCameraStateOpenerImplProvider.get());
                    case 21:
                        return (T) CameraPipeModule_Companion_ProvideCameraContextFactory.provideCameraContext(this.cameraPipeComponentImpl.cameraPipeContextContext(), this.cameraPipeComponentImpl.provideThreadsProvider.get(), this.cameraPipeComponentImpl.provideCameraBackendsProvider.get());
                    case 22:
                        return (T) CameraPipeModule_Companion_ProvideCameraSurfaceManagerFactory.provideCameraSurfaceManager();
                    case 23:
                        return (T) new ConcurrentSessionSequencers();
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }
}
