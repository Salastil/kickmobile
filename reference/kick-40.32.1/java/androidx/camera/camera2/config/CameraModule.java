package androidx.camera.camera2.config;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.adapter.CameraControlAdapter;
import androidx.camera.camera2.adapter.CameraInfoAdapter;
import androidx.camera.camera2.adapter.CameraInternalAdapter;
import androidx.camera.camera2.adapter.EncoderProfilesProviderAdapter;
import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.adapter.ZslControlImpl;
import androidx.camera.camera2.compat.Camera2CameraControlCompat;
import androidx.camera.camera2.compat.EvCompCompat;
import androidx.camera.camera2.compat.ZoomCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraPipeCameraProperties;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.State3AControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.impl.VideoUsageControl;
import androidx.camera.camera2.impl.ZoomControl;
import androidx.camera.camera2.internal.IntrinsicZoomCalculator;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: CameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0011H'¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/config/CameraModule;", "", "<init>", "()V", "bindCameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "impl", "Landroidx/camera/camera2/impl/CameraPipeCameraProperties;", "bindCameraInternal", "Landroidx/camera/core/impl/CameraInternal;", "adapter", "Landroidx/camera/camera2/adapter/CameraInternalAdapter;", "bindCameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "Landroidx/camera/camera2/adapter/CameraInfoAdapter;", "bindCameraControlInternal", "Landroidx/camera/core/impl/CameraControlInternal;", "Landroidx/camera/camera2/adapter/CameraControlAdapter;", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module(includes = {Camera2CameraControlCompat.Bindings.class, EvCompCompat.Bindings.class, EvCompControl.Bindings.class, FlashControl.Bindings.class, FocusMeteringControl.Bindings.class, IntrinsicZoomCalculator.Bindings.class, State3AControl.Bindings.class, StillCaptureRequestControl.Bindings.class, TorchControl.Bindings.class, LowLightBoostControl.Bindings.class, VideoUsageControl.Bindings.class, ZoomCompat.Bindings.class, ZoomControl.Bindings.class}, subcomponents = {UseCaseCameraComponent.class})
public abstract class CameraModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract CameraControlInternal bindCameraControlInternal(CameraControlAdapter adapter);

    @Binds
    public abstract CameraInfoInternal bindCameraInfoInternal(CameraInfoAdapter adapter);

    @Binds
    public abstract CameraInternal bindCameraInternal(CameraInternalAdapter adapter);

    @Binds
    public abstract CameraProperties bindCameraProperties(CameraPipeCameraProperties impl);

    /* JADX INFO: compiled from: CameraConfig.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u001a\u0010#\u001a\u00020$2\b\b\u0001\u0010%\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0007¨\u0006&"}, d2 = {"Landroidx/camera/camera2/config/CameraModule$Companion;", "", "<init>", "()V", "provideUseCaseThreads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "cameraConfig", "Landroidx/camera/camera2/config/CameraConfig;", "cameraThreadConfig", "Landroidx/camera/core/impl/CameraThreadConfig;", "provideCamera2CameraControl", "Landroidx/camera/camera2/interop/Camera2CameraControl;", "compat", "Landroidx/camera/camera2/compat/Camera2CameraControlCompat;", "threads", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "provideCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "config", "provideCameraIdString", "", "provideStreamConfigurationMap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "cameraMetadata", "provideCameraQuirksValues", "Landroidx/camera/core/impl/Quirks;", "cameraQuirks", "Landroidx/camera/camera2/compat/quirk/CameraQuirks;", "provideZslControl", "Landroidx/camera/camera2/adapter/ZslControl;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "provideEncoderProfilesProvider", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "cameraIdString", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @CameraScope
        @Provides
        public final UseCaseThreads provideUseCaseThreads(CameraConfig cameraConfig, CameraThreadConfig cameraThreadConfig) {
            Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
            Intrinsics.checkNotNullParameter(cameraThreadConfig, "cameraThreadConfig");
            Executor cameraExecutor = cameraThreadConfig.getCameraExecutor();
            Intrinsics.checkNotNullExpressionValue(cameraExecutor, "getCameraExecutor(...)");
            Executor cameraExecutor2 = cameraThreadConfig.getCameraExecutor();
            Intrinsics.checkNotNullExpressionValue(cameraExecutor2, "getCameraExecutor(...)");
            CoroutineDispatcher coroutineDispatcherFrom = ExecutorsKt.from(cameraExecutor2);
            return new UseCaseThreads(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcherFrom).plus(new CoroutineName("CXCP-UseCase-" + cameraConfig.getCameraId()))), cameraExecutor, coroutineDispatcherFrom);
        }

        @CameraScope
        @Provides
        public final Camera2CameraControl provideCamera2CameraControl(Camera2CameraControlCompat compat, UseCaseThreads threads, ComboRequestListener requestListener) {
            Intrinsics.checkNotNullParameter(compat, "compat");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            return Camera2CameraControl.INSTANCE.create(compat, threads, requestListener);
        }

        @CameraScope
        @Provides
        public final CameraMetadata provideCameraMetadata(CameraPipe cameraPipe, CameraConfig config) {
            Intrinsics.checkNotNullParameter(cameraPipe, "cameraPipe");
            Intrinsics.checkNotNullParameter(config, "config");
            try {
                return CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraPipe.cameras(), config.getCameraId(), null, 2, null);
            } catch (DoNotDisturbException unused) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Failed to inject camera metadata: Do Not Disturb mode is on.");
                }
                return null;
            }
        }

        @CameraScope
        @Provides
        @Named("CameraId")
        public final String provideCameraIdString(CameraConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return config.getCameraId();
        }

        @CameraScope
        @Provides
        public final StreamConfigurationMap provideStreamConfigurationMap(CameraMetadata cameraMetadata) {
            if (cameraMetadata == null) {
                return null;
            }
            CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
            Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
            return (StreamConfigurationMap) cameraMetadata.get(SCALER_STREAM_CONFIGURATION_MAP);
        }

        @CameraScope
        @Provides
        @Named("cameraQuirksValues")
        public final Quirks provideCameraQuirksValues(CameraQuirks cameraQuirks) {
            Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
            return cameraQuirks.getQuirks();
        }

        @CameraScope
        @Provides
        public final ZslControl provideZslControl(CameraProperties cameraProperties) {
            Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
            return new ZslControlImpl(cameraProperties);
        }

        @CameraScope
        @Provides
        public final EncoderProfilesProvider provideEncoderProfilesProvider(@Named("CameraId") String cameraIdString, CameraQuirks cameraQuirks) {
            Intrinsics.checkNotNullParameter(cameraIdString, "cameraIdString");
            Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
            return new EncoderProfilesProviderAdapter(cameraIdString, cameraQuirks.getQuirks());
        }
    }
}
