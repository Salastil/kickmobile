package androidx.camera.camera2.pipe.config;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackendFactory;
import androidx.camera.camera2.pipe.CameraBackendId;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.compat.AndroidDevicePolicyManagerWrapper;
import androidx.camera.camera2.pipe.compat.DevicePolicyManagerWrapper;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.SystemTimeSource;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.internal.CameraBackendsImpl;
import androidx.camera.camera2.pipe.internal.CameraDevicesImpl;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.camera.camera2.pipe.media.ImageReaderImageSources;
import androidx.camera.camera2.pipe.media.ImageSources;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: CameraPipeComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraPipeModule;", "", "<init>", "()V", "bindCameras", "Landroidx/camera/camera2/pipe/CameraDevices;", "impl", "Landroidx/camera/camera2/pipe/internal/CameraDevicesImpl;", "bindTimeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "timeSource", "Landroidx/camera/camera2/pipe/core/SystemTimeSource;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public abstract class CameraPipeModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract CameraDevices bindCameras(CameraDevicesImpl impl);

    @Binds
    public abstract TimeSource bindTimeSource(SystemTimeSource timeSource);

    /* JADX INFO: compiled from: CameraPipeComponent.kt */
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007J\"\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007J:\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u0010*\u001a\u00020+2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007¨\u0006,"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraPipeModule$Companion;", "", "<init>", "()V", "provideContext", "Landroid/content/Context;", "config", "Landroidx/camera/camera2/pipe/CameraPipe$Config;", "provideCameraPipeJob", "Lkotlinx/coroutines/Job;", "provideCameraMetadataConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;", "provideCameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraPipeContext", "provideDevicePolicyManagerWrapper", "Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;", "provideCameraContext", "Landroidx/camera/camera2/pipe/CameraContext;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraBackends;", "providePackageManager", "Landroid/content/pm/PackageManager;", "provideCameraBackends", "defaultCameraBackend", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/CameraBackend;", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "configureImageSources", "Landroidx/camera/camera2/pipe/media/ImageSources;", "imageReaderImageSources", "Landroidx/camera/camera2/pipe/media/ImageReaderImageSources;", "cameraPipeConfig", "provideCameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "provideStrictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "flags", "Landroidx/camera/camera2/pipe/CameraPipe$Flags;", "provideCameraDeviceSetupCompatFactory", "Landroidx/camera/featurecombinationquery/CameraDeviceSetupCompatFactory;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @CameraPipeContext
        @Provides
        public final Context provideContext(CameraPipe.Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return config.getAppContext();
        }

        @Provides
        @Singleton
        @CameraPipeJob
        public final Job provideCameraPipeJob() {
            return JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        }

        @Provides
        public final CameraPipe.CameraMetadataConfig provideCameraMetadataConfig(CameraPipe.Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return config.getCameraMetadataConfig();
        }

        @Provides
        @Reusable
        public final CameraManager provideCameraManager(@CameraPipeContext Context cameraPipeContext) {
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            Object systemService = cameraPipeContext.getSystemService("camera");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return (CameraManager) systemService;
        }

        @Provides
        @Reusable
        public final DevicePolicyManagerWrapper provideDevicePolicyManagerWrapper(@CameraPipeContext Context cameraPipeContext) {
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            Object systemService = cameraPipeContext.getSystemService("device_policy");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
            return new AndroidDevicePolicyManagerWrapper((DevicePolicyManager) systemService);
        }

        @Provides
        @Singleton
        public final CameraContext provideCameraContext(@CameraPipeContext final Context cameraPipeContext, final Threads threads, final CameraBackends cameraBackends) {
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
            return new CameraContext(cameraPipeContext, threads, cameraBackends) { // from class: androidx.camera.camera2.pipe.config.CameraPipeModule$Companion$provideCameraContext$1
                private final Context appContext;
                private final CameraBackends cameraBackends;
                private final Threads threads;

                {
                    this.appContext = cameraPipeContext;
                    this.threads = threads;
                    this.cameraBackends = cameraBackends;
                }

                @Override // androidx.camera.camera2.pipe.CameraContext
                public Context getAppContext() {
                    return this.appContext;
                }

                @Override // androidx.camera.camera2.pipe.CameraContext
                public Threads getThreads() {
                    return this.threads;
                }

                @Override // androidx.camera.camera2.pipe.CameraContext
                public CameraBackends getCameraBackends() {
                    return this.cameraBackends;
                }
            };
        }

        @Provides
        @Singleton
        public final PackageManager providePackageManager(@CameraPipeContext Context cameraPipeContext) {
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            PackageManager packageManager = cameraPipeContext.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            return packageManager;
        }

        @Provides
        @Singleton
        public final CameraBackends provideCameraBackends(CameraPipe.Config config, @DefaultCameraBackend Provider<CameraBackend> defaultCameraBackend, @CameraPipeContext Context cameraPipeContext, Threads threads, CameraPipeLifetime cameraPipeLifetime) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(defaultCameraBackend, "defaultCameraBackend");
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(cameraPipeLifetime, "cameraPipeLifetime");
            final CameraBackend internalBackend = config.getCameraBackendConfig().getInternalBackend();
            if (internalBackend == null) {
                Debug debug = Debug.INSTANCE;
                try {
                    Trace.beginSection("Initialize defaultCameraBackend");
                    internalBackend = defaultCameraBackend.get();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            if (config.getCameraBackendConfig().getCameraBackends().containsKey(CameraBackendId.m235boximpl(internalBackend.mo226getIdQwmhuAM()))) {
                throw new IllegalStateException(("CameraBackendConfig#cameraBackends should not contain a backend with " + ((Object) CameraBackendId.m240toStringimpl(internalBackend.mo226getIdQwmhuAM())) + ". Use CameraBackendConfig#internalBackend field instead.").toString());
            }
            Map mapPlus = MapsKt.plus(config.getCameraBackendConfig().getCameraBackends(), TuplesKt.to(CameraBackendId.m235boximpl(internalBackend.mo226getIdQwmhuAM()), new CameraBackendFactory() { // from class: androidx.camera.camera2.pipe.config.CameraPipeModule$Companion$$ExternalSyntheticLambda0
                @Override // androidx.camera.camera2.pipe.CameraBackendFactory
                public final CameraBackend create(CameraContext cameraContext) {
                    return CameraPipeModule.Companion.provideCameraBackends$lambda$2(internalBackend, cameraContext);
                }
            }));
            String defaultBackend = config.getCameraBackendConfig().getDefaultBackend();
            if (defaultBackend == null) {
                defaultBackend = internalBackend.mo226getIdQwmhuAM();
            }
            String str = defaultBackend;
            if (!mapPlus.containsKey(CameraBackendId.m235boximpl(str))) {
                throw new IllegalStateException(("Failed to find " + ((Object) CameraBackendId.m240toStringimpl(str)) + " in the list of available CameraPipe backends! Available values are " + mapPlus.keySet()).toString());
            }
            return new CameraBackendsImpl(str, mapPlus, cameraPipeContext, threads, cameraPipeLifetime, null);
        }

        static final CameraBackend provideCameraBackends$lambda$2(CameraBackend cameraBackend, CameraContext it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Intrinsics.checkNotNull(cameraBackend);
            return cameraBackend;
        }

        @Provides
        public final ImageSources configureImageSources(ImageReaderImageSources imageReaderImageSources, CameraPipe.Config cameraPipeConfig) {
            Intrinsics.checkNotNullParameter(imageReaderImageSources, "imageReaderImageSources");
            Intrinsics.checkNotNullParameter(cameraPipeConfig, "cameraPipeConfig");
            if (cameraPipeConfig.getImageSources() != null) {
                return cameraPipeConfig.getImageSources();
            }
            return imageReaderImageSources;
        }

        @Provides
        @Singleton
        public final CameraSurfaceManager provideCameraSurfaceManager() {
            return new CameraSurfaceManager();
        }

        @Provides
        @Singleton
        public final StrictMode provideStrictMode(CameraPipe.Flags flags) {
            Intrinsics.checkNotNullParameter(flags, "flags");
            return new StrictMode(flags.getStrictModeEnabled());
        }

        @Provides
        @Singleton
        public final CameraDeviceSetupCompatFactory provideCameraDeviceSetupCompatFactory(@CameraPipeContext Context cameraPipeContext) {
            Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
            return new CameraDeviceSetupCompatFactory(cameraPipeContext);
        }
    }
}
