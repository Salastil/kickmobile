package androidx.camera.camera2.pipe;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.os.Trace;
import androidx.camera.camera2.pipe.config.CameraPipeComponent;
import androidx.camera.camera2.pipe.config.CameraPipeConfigModule;
import androidx.camera.camera2.pipe.config.DaggerCameraPipeComponent;
import androidx.camera.camera2.pipe.config.ThreadConfigModule;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.media.ImageSources;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CameraPipe.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u0000 )2\u00020\u0001:\u0007#$%&'()J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u001bH&R\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe;", "", "create", "Landroidx/camera/camera2/pipe/CameraGraph;", "config", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "createCameraGraph", "createCameraGraphs", "", "Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;", "createFrameGraph", "Landroidx/camera/camera2/pipe/FrameGraph;", "frameGraphConfig", "Landroidx/camera/camera2/pipe/FrameGraph$Config;", "createFrameGraphs", "frameGraphConfigs", "Landroidx/camera/camera2/pipe/FrameGraph$ConcurrentConfig;", "cameras", "Landroidx/camera/camera2/pipe/CameraDevices;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "isConfigSupported", "Landroidx/camera/camera2/pipe/ConfigQueryResult;", "graphConfig", "isConfigSupported-NpXggIU", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prewarmIsConfigSupported", "", "globalAudioRestrictionMode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getGlobalAudioRestrictionMode-_b5Q8KE", "()I", "setGlobalAudioRestrictionMode-LwUUkyU", "(I)V", "shutdown", "Config", "Flags", "CameraInteropConfig", "ThreadConfig", "CameraMetadataConfig", "CameraBackendConfig", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraPipe {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    CameraSurfaceManager cameraSurfaceManager();

    CameraDevices cameras();

    @Deprecated(message = "Use createCameraGraph instead.", replaceWith = @ReplaceWith(expression = "createCameraGraph(config)", imports = {}))
    CameraGraph create(CameraGraph.Config config);

    CameraGraph createCameraGraph(CameraGraph.Config config);

    List<CameraGraph> createCameraGraphs(CameraGraph.ConcurrentConfig config);

    FrameGraph createFrameGraph(FrameGraph.Config frameGraphConfig);

    List<FrameGraph> createFrameGraphs(FrameGraph.ConcurrentConfig frameGraphConfigs);

    /* JADX INFO: renamed from: getGlobalAudioRestrictionMode-_b5Q8KE, reason: not valid java name */
    int mo450getGlobalAudioRestrictionMode_b5Q8KE();

    /* JADX INFO: renamed from: isConfigSupported-NpXggIU, reason: not valid java name */
    Object mo451isConfigSupportedNpXggIU(CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation);

    void prewarmIsConfigSupported(CameraGraph.Config graphConfig);

    /* JADX INFO: renamed from: setGlobalAudioRestrictionMode-LwUUkyU, reason: not valid java name */
    void mo452setGlobalAudioRestrictionModeLwUUkyU(int i);

    void shutdown();

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003J]\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$Config;", "", "appContext", "Landroid/content/Context;", "threadConfig", "Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;", "cameraMetadataConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;", "cameraBackendConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraBackendConfig;", "cameraInteropConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;", "imageSources", "Landroidx/camera/camera2/pipe/media/ImageSources;", "flags", "Landroidx/camera/camera2/pipe/CameraPipe$Flags;", "platformApiCompat", "Landroidx/camera/camera2/pipe/PlatformApiCompat;", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;Landroidx/camera/camera2/pipe/CameraPipe$CameraBackendConfig;Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;Landroidx/camera/camera2/pipe/media/ImageSources;Landroidx/camera/camera2/pipe/CameraPipe$Flags;Landroidx/camera/camera2/pipe/PlatformApiCompat;)V", "getAppContext", "()Landroid/content/Context;", "getThreadConfig", "()Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;", "getCameraMetadataConfig", "()Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;", "getCameraBackendConfig", "()Landroidx/camera/camera2/pipe/CameraPipe$CameraBackendConfig;", "getCameraInteropConfig", "()Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;", "getImageSources", "()Landroidx/camera/camera2/pipe/media/ImageSources;", "getFlags", "()Landroidx/camera/camera2/pipe/CameraPipe$Flags;", "getPlatformApiCompat", "()Landroidx/camera/camera2/pipe/PlatformApiCompat;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Config {
        private final Context appContext;
        private final CameraBackendConfig cameraBackendConfig;
        private final CameraInteropConfig cameraInteropConfig;
        private final CameraMetadataConfig cameraMetadataConfig;
        private final Flags flags;
        private final ImageSources imageSources;
        private final PlatformApiCompat platformApiCompat;
        private final ThreadConfig threadConfig;

        public static /* synthetic */ Config copy$default(Config config, Context context, ThreadConfig threadConfig, CameraMetadataConfig cameraMetadataConfig, CameraBackendConfig cameraBackendConfig, CameraInteropConfig cameraInteropConfig, ImageSources imageSources, Flags flags, PlatformApiCompat platformApiCompat, int i, Object obj) {
            if ((i & 1) != 0) {
                context = config.appContext;
            }
            if ((i & 2) != 0) {
                threadConfig = config.threadConfig;
            }
            if ((i & 4) != 0) {
                cameraMetadataConfig = config.cameraMetadataConfig;
            }
            if ((i & 8) != 0) {
                cameraBackendConfig = config.cameraBackendConfig;
            }
            if ((i & 16) != 0) {
                cameraInteropConfig = config.cameraInteropConfig;
            }
            if ((i & 32) != 0) {
                imageSources = config.imageSources;
            }
            if ((i & 64) != 0) {
                flags = config.flags;
            }
            if ((i & 128) != 0) {
                platformApiCompat = config.platformApiCompat;
            }
            Flags flags2 = flags;
            PlatformApiCompat platformApiCompat2 = platformApiCompat;
            CameraInteropConfig cameraInteropConfig2 = cameraInteropConfig;
            ImageSources imageSources2 = imageSources;
            return config.copy(context, threadConfig, cameraMetadataConfig, cameraBackendConfig, cameraInteropConfig2, imageSources2, flags2, platformApiCompat2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getAppContext() {
            return this.appContext;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ThreadConfig getThreadConfig() {
            return this.threadConfig;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CameraMetadataConfig getCameraMetadataConfig() {
            return this.cameraMetadataConfig;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CameraBackendConfig getCameraBackendConfig() {
            return this.cameraBackendConfig;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CameraInteropConfig getCameraInteropConfig() {
            return this.cameraInteropConfig;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ImageSources getImageSources() {
            return this.imageSources;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Flags getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final PlatformApiCompat getPlatformApiCompat() {
            return this.platformApiCompat;
        }

        public final Config copy(Context appContext, ThreadConfig threadConfig, CameraMetadataConfig cameraMetadataConfig, CameraBackendConfig cameraBackendConfig, CameraInteropConfig cameraInteropConfig, ImageSources imageSources, Flags flags, PlatformApiCompat platformApiCompat) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(threadConfig, "threadConfig");
            Intrinsics.checkNotNullParameter(cameraMetadataConfig, "cameraMetadataConfig");
            Intrinsics.checkNotNullParameter(cameraBackendConfig, "cameraBackendConfig");
            Intrinsics.checkNotNullParameter(cameraInteropConfig, "cameraInteropConfig");
            Intrinsics.checkNotNullParameter(flags, "flags");
            return new Config(appContext, threadConfig, cameraMetadataConfig, cameraBackendConfig, cameraInteropConfig, imageSources, flags, platformApiCompat);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.appContext, config.appContext) && Intrinsics.areEqual(this.threadConfig, config.threadConfig) && Intrinsics.areEqual(this.cameraMetadataConfig, config.cameraMetadataConfig) && Intrinsics.areEqual(this.cameraBackendConfig, config.cameraBackendConfig) && Intrinsics.areEqual(this.cameraInteropConfig, config.cameraInteropConfig) && Intrinsics.areEqual(this.imageSources, config.imageSources) && Intrinsics.areEqual(this.flags, config.flags) && Intrinsics.areEqual(this.platformApiCompat, config.platformApiCompat);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.appContext.hashCode() * 31) + this.threadConfig.hashCode()) * 31) + this.cameraMetadataConfig.hashCode()) * 31) + this.cameraBackendConfig.hashCode()) * 31) + this.cameraInteropConfig.hashCode()) * 31;
            ImageSources imageSources = this.imageSources;
            int iHashCode2 = (((iHashCode + (imageSources == null ? 0 : imageSources.hashCode())) * 31) + this.flags.hashCode()) * 31;
            PlatformApiCompat platformApiCompat = this.platformApiCompat;
            return iHashCode2 + (platformApiCompat != null ? platformApiCompat.hashCode() : 0);
        }

        public String toString() {
            return "Config(appContext=" + this.appContext + ", threadConfig=" + this.threadConfig + ", cameraMetadataConfig=" + this.cameraMetadataConfig + ", cameraBackendConfig=" + this.cameraBackendConfig + ", cameraInteropConfig=" + this.cameraInteropConfig + ", imageSources=" + this.imageSources + ", flags=" + this.flags + ", platformApiCompat=" + this.platformApiCompat + ')';
        }

        public Config(Context appContext, ThreadConfig threadConfig, CameraMetadataConfig cameraMetadataConfig, CameraBackendConfig cameraBackendConfig, CameraInteropConfig cameraInteropConfig, ImageSources imageSources, Flags flags, PlatformApiCompat platformApiCompat) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(threadConfig, "threadConfig");
            Intrinsics.checkNotNullParameter(cameraMetadataConfig, "cameraMetadataConfig");
            Intrinsics.checkNotNullParameter(cameraBackendConfig, "cameraBackendConfig");
            Intrinsics.checkNotNullParameter(cameraInteropConfig, "cameraInteropConfig");
            Intrinsics.checkNotNullParameter(flags, "flags");
            this.appContext = appContext;
            this.threadConfig = threadConfig;
            this.cameraMetadataConfig = cameraMetadataConfig;
            this.cameraBackendConfig = cameraBackendConfig;
            this.cameraInteropConfig = cameraInteropConfig;
            this.imageSources = imageSources;
            this.flags = flags;
            this.platformApiCompat = platformApiCompat;
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Config(Context context, ThreadConfig threadConfig, CameraMetadataConfig cameraMetadataConfig, CameraBackendConfig cameraBackendConfig, CameraInteropConfig cameraInteropConfig, ImageSources imageSources, Flags flags, PlatformApiCompat platformApiCompat, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Flags flags2;
            threadConfig = (i & 2) != 0 ? new ThreadConfig(null, null, null, null, null, null, null, 127, null) : threadConfig;
            Object[] objArr = 0;
            cameraMetadataConfig = (i & 4) != 0 ? new CameraMetadataConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : cameraMetadataConfig;
            CameraBackendConfig cameraBackendConfig2 = (i & 8) != 0 ? new CameraBackendConfig(null, null, null, 7, null) : cameraBackendConfig;
            CameraInteropConfig cameraInteropConfig2 = (i & 16) != 0 ? new CameraInteropConfig(null, null, null, 7, null) : cameraInteropConfig;
            ImageSources imageSources2 = (i & 32) != 0 ? null : imageSources;
            if ((i & 64) != 0) {
                flags2 = new Flags(false, 1, objArr == true ? 1 : 0);
            } else {
                flags2 = flags;
            }
            this(context, threadConfig, cameraMetadataConfig, cameraBackendConfig2, cameraInteropConfig2, imageSources2, flags2, (i & 128) != 0 ? null : platformApiCompat);
        }

        public final ThreadConfig getThreadConfig() {
            return this.threadConfig;
        }

        public final CameraMetadataConfig getCameraMetadataConfig() {
            return this.cameraMetadataConfig;
        }

        public final CameraBackendConfig getCameraBackendConfig() {
            return this.cameraBackendConfig;
        }

        public final CameraInteropConfig getCameraInteropConfig() {
            return this.cameraInteropConfig;
        }

        public final ImageSources getImageSources() {
            return this.imageSources;
        }

        public final Flags getFlags() {
            return this.flags;
        }

        public final PlatformApiCompat getPlatformApiCompat() {
            return this.platformApiCompat;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$Flags;", "", "strictModeEnabled", "", "<init>", "(Z)V", "getStrictModeEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Flags {
        private final boolean strictModeEnabled;

        public Flags() {
            this(false, 1, null);
        }

        public static /* synthetic */ Flags copy$default(Flags flags, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = flags.strictModeEnabled;
            }
            return flags.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getStrictModeEnabled() {
            return this.strictModeEnabled;
        }

        public final Flags copy(boolean strictModeEnabled) {
            return new Flags(strictModeEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Flags) && this.strictModeEnabled == ((Flags) other).strictModeEnabled;
        }

        public int hashCode() {
            return Boolean.hashCode(this.strictModeEnabled);
        }

        public String toString() {
            return "Flags(strictModeEnabled=" + this.strictModeEnabled + ')';
        }

        public Flags(boolean z) {
            this.strictModeEnabled = z;
        }

        public /* synthetic */ Flags(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getStrictModeEnabled() {
            return this.strictModeEnabled;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\b\u0013J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\b\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;", "", "cameraDeviceStateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "cameraCaptureSessionListener", "Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "cameraOpenRetryMaxTimeoutNs", "Landroidx/camera/camera2/pipe/core/DurationNs;", "<init>", "(Landroid/hardware/camera2/CameraDevice$StateCallback;Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;Landroidx/camera/camera2/pipe/core/DurationNs;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraDeviceStateCallback", "()Landroid/hardware/camera2/CameraDevice$StateCallback;", "getCameraCaptureSessionListener", "()Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "getCameraOpenRetryMaxTimeoutNs-QWez1Bs", "()Landroidx/camera/camera2/pipe/core/DurationNs;", "component1", "component2", "component3", "component3-QWez1Bs", "copy", "copy-ck8WKOA", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CameraInteropConfig {
        private final CameraInterop.CaptureSessionListener cameraCaptureSessionListener;
        private final CameraDevice.StateCallback cameraDeviceStateCallback;
        private final DurationNs cameraOpenRetryMaxTimeoutNs;

        public /* synthetic */ CameraInteropConfig(CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, DurationNs durationNs, DefaultConstructorMarker defaultConstructorMarker) {
            this(stateCallback, captureSessionListener, durationNs);
        }

        /* JADX INFO: renamed from: copy-ck8WKOA$default, reason: not valid java name */
        public static /* synthetic */ CameraInteropConfig m454copyck8WKOA$default(CameraInteropConfig cameraInteropConfig, CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, DurationNs durationNs, int i, Object obj) {
            if ((i & 1) != 0) {
                stateCallback = cameraInteropConfig.cameraDeviceStateCallback;
            }
            if ((i & 2) != 0) {
                captureSessionListener = cameraInteropConfig.cameraCaptureSessionListener;
            }
            if ((i & 4) != 0) {
                durationNs = cameraInteropConfig.cameraOpenRetryMaxTimeoutNs;
            }
            return cameraInteropConfig.m456copyck8WKOA(stateCallback, captureSessionListener, durationNs);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraDevice.StateCallback getCameraDeviceStateCallback() {
            return this.cameraDeviceStateCallback;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CameraInterop.CaptureSessionListener getCameraCaptureSessionListener() {
            return this.cameraCaptureSessionListener;
        }

        /* JADX INFO: renamed from: component3-QWez1Bs, reason: not valid java name and from getter */
        public final DurationNs getCameraOpenRetryMaxTimeoutNs() {
            return this.cameraOpenRetryMaxTimeoutNs;
        }

        /* JADX INFO: renamed from: copy-ck8WKOA, reason: not valid java name */
        public final CameraInteropConfig m456copyck8WKOA(CameraDevice.StateCallback cameraDeviceStateCallback, CameraInterop.CaptureSessionListener cameraCaptureSessionListener, DurationNs cameraOpenRetryMaxTimeoutNs) {
            return new CameraInteropConfig(cameraDeviceStateCallback, cameraCaptureSessionListener, cameraOpenRetryMaxTimeoutNs, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CameraInteropConfig)) {
                return false;
            }
            CameraInteropConfig cameraInteropConfig = (CameraInteropConfig) other;
            return Intrinsics.areEqual(this.cameraDeviceStateCallback, cameraInteropConfig.cameraDeviceStateCallback) && Intrinsics.areEqual(this.cameraCaptureSessionListener, cameraInteropConfig.cameraCaptureSessionListener) && Intrinsics.areEqual(this.cameraOpenRetryMaxTimeoutNs, cameraInteropConfig.cameraOpenRetryMaxTimeoutNs);
        }

        public int hashCode() {
            CameraDevice.StateCallback stateCallback = this.cameraDeviceStateCallback;
            int iHashCode = (stateCallback == null ? 0 : stateCallback.hashCode()) * 31;
            CameraInterop.CaptureSessionListener captureSessionListener = this.cameraCaptureSessionListener;
            int iHashCode2 = (iHashCode + (captureSessionListener == null ? 0 : captureSessionListener.hashCode())) * 31;
            DurationNs durationNs = this.cameraOpenRetryMaxTimeoutNs;
            return iHashCode2 + (durationNs != null ? DurationNs.m920hashCodeimpl(durationNs.m925unboximpl()) : 0);
        }

        public String toString() {
            return "CameraInteropConfig(cameraDeviceStateCallback=" + this.cameraDeviceStateCallback + ", cameraCaptureSessionListener=" + this.cameraCaptureSessionListener + ", cameraOpenRetryMaxTimeoutNs=" + this.cameraOpenRetryMaxTimeoutNs + ')';
        }

        private CameraInteropConfig(CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, DurationNs durationNs) {
            this.cameraDeviceStateCallback = stateCallback;
            this.cameraCaptureSessionListener = captureSessionListener;
            this.cameraOpenRetryMaxTimeoutNs = durationNs;
        }

        public /* synthetic */ CameraInteropConfig(CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, DurationNs durationNs, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : stateCallback, (i & 2) != 0 ? null : captureSessionListener, (i & 4) != 0 ? null : durationNs, null);
        }

        public final CameraDevice.StateCallback getCameraDeviceStateCallback() {
            return this.cameraDeviceStateCallback;
        }

        public final CameraInterop.CaptureSessionListener getCameraCaptureSessionListener() {
            return this.cameraCaptureSessionListener;
        }

        /* JADX INFO: renamed from: getCameraOpenRetryMaxTimeoutNs-QWez1Bs, reason: not valid java name */
        public final DurationNs m457getCameraOpenRetryMaxTimeoutNsQWez1Bs() {
            return this.cameraOpenRetryMaxTimeoutNs;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003Jc\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$ThreadConfig;", "", "defaultLightweightExecutor", "Ljava/util/concurrent/Executor;", "defaultBackgroundExecutor", "defaultBlockingExecutor", "defaultCameraExecutor", "defaultCameraHandler", "Landroid/os/Handler;", "defaultCameraHandlerFn", "Lkotlin/Function0;", "testOnlyScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/os/Handler;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;)V", "getDefaultLightweightExecutor", "()Ljava/util/concurrent/Executor;", "getDefaultBackgroundExecutor", "getDefaultBlockingExecutor", "getDefaultCameraExecutor", "getDefaultCameraHandler", "()Landroid/os/Handler;", "getDefaultCameraHandlerFn", "()Lkotlin/jvm/functions/Function0;", "getTestOnlyScope", "()Lkotlinx/coroutines/CoroutineScope;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ThreadConfig {
        private final Executor defaultBackgroundExecutor;
        private final Executor defaultBlockingExecutor;
        private final Executor defaultCameraExecutor;
        private final Handler defaultCameraHandler;
        private final Function0<Handler> defaultCameraHandlerFn;
        private final Executor defaultLightweightExecutor;
        private final CoroutineScope testOnlyScope;

        public ThreadConfig() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ThreadConfig copy$default(ThreadConfig threadConfig, Executor executor, Executor executor2, Executor executor3, Executor executor4, Handler handler, Function0 function0, CoroutineScope coroutineScope, int i, Object obj) {
            if ((i & 1) != 0) {
                executor = threadConfig.defaultLightweightExecutor;
            }
            if ((i & 2) != 0) {
                executor2 = threadConfig.defaultBackgroundExecutor;
            }
            if ((i & 4) != 0) {
                executor3 = threadConfig.defaultBlockingExecutor;
            }
            if ((i & 8) != 0) {
                executor4 = threadConfig.defaultCameraExecutor;
            }
            if ((i & 16) != 0) {
                handler = threadConfig.defaultCameraHandler;
            }
            if ((i & 32) != 0) {
                function0 = threadConfig.defaultCameraHandlerFn;
            }
            if ((i & 64) != 0) {
                coroutineScope = threadConfig.testOnlyScope;
            }
            Function0 function1 = function0;
            CoroutineScope coroutineScope2 = coroutineScope;
            Handler handler2 = handler;
            Executor executor5 = executor3;
            return threadConfig.copy(executor, executor2, executor5, executor4, handler2, function1, coroutineScope2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Executor getDefaultLightweightExecutor() {
            return this.defaultLightweightExecutor;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Executor getDefaultBackgroundExecutor() {
            return this.defaultBackgroundExecutor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Executor getDefaultBlockingExecutor() {
            return this.defaultBlockingExecutor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Executor getDefaultCameraExecutor() {
            return this.defaultCameraExecutor;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Handler getDefaultCameraHandler() {
            return this.defaultCameraHandler;
        }

        public final Function0<Handler> component6() {
            return this.defaultCameraHandlerFn;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final CoroutineScope getTestOnlyScope() {
            return this.testOnlyScope;
        }

        public final ThreadConfig copy(Executor defaultLightweightExecutor, Executor defaultBackgroundExecutor, Executor defaultBlockingExecutor, Executor defaultCameraExecutor, Handler defaultCameraHandler, Function0<? extends Handler> defaultCameraHandlerFn, CoroutineScope testOnlyScope) {
            return new ThreadConfig(defaultLightweightExecutor, defaultBackgroundExecutor, defaultBlockingExecutor, defaultCameraExecutor, defaultCameraHandler, defaultCameraHandlerFn, testOnlyScope);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadConfig)) {
                return false;
            }
            ThreadConfig threadConfig = (ThreadConfig) other;
            return Intrinsics.areEqual(this.defaultLightweightExecutor, threadConfig.defaultLightweightExecutor) && Intrinsics.areEqual(this.defaultBackgroundExecutor, threadConfig.defaultBackgroundExecutor) && Intrinsics.areEqual(this.defaultBlockingExecutor, threadConfig.defaultBlockingExecutor) && Intrinsics.areEqual(this.defaultCameraExecutor, threadConfig.defaultCameraExecutor) && Intrinsics.areEqual(this.defaultCameraHandler, threadConfig.defaultCameraHandler) && Intrinsics.areEqual(this.defaultCameraHandlerFn, threadConfig.defaultCameraHandlerFn) && Intrinsics.areEqual(this.testOnlyScope, threadConfig.testOnlyScope);
        }

        public int hashCode() {
            Executor executor = this.defaultLightweightExecutor;
            int iHashCode = (executor == null ? 0 : executor.hashCode()) * 31;
            Executor executor2 = this.defaultBackgroundExecutor;
            int iHashCode2 = (iHashCode + (executor2 == null ? 0 : executor2.hashCode())) * 31;
            Executor executor3 = this.defaultBlockingExecutor;
            int iHashCode3 = (iHashCode2 + (executor3 == null ? 0 : executor3.hashCode())) * 31;
            Executor executor4 = this.defaultCameraExecutor;
            int iHashCode4 = (iHashCode3 + (executor4 == null ? 0 : executor4.hashCode())) * 31;
            Handler handler = this.defaultCameraHandler;
            int iHashCode5 = (iHashCode4 + (handler == null ? 0 : handler.hashCode())) * 31;
            Function0<Handler> function0 = this.defaultCameraHandlerFn;
            int iHashCode6 = (iHashCode5 + (function0 == null ? 0 : function0.hashCode())) * 31;
            CoroutineScope coroutineScope = this.testOnlyScope;
            return iHashCode6 + (coroutineScope != null ? coroutineScope.hashCode() : 0);
        }

        public String toString() {
            return "ThreadConfig(defaultLightweightExecutor=" + this.defaultLightweightExecutor + ", defaultBackgroundExecutor=" + this.defaultBackgroundExecutor + ", defaultBlockingExecutor=" + this.defaultBlockingExecutor + ", defaultCameraExecutor=" + this.defaultCameraExecutor + ", defaultCameraHandler=" + this.defaultCameraHandler + ", defaultCameraHandlerFn=" + this.defaultCameraHandlerFn + ", testOnlyScope=" + this.testOnlyScope + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ThreadConfig(Executor executor, Executor executor2, Executor executor3, Executor executor4, Handler handler, Function0<? extends Handler> function0, CoroutineScope coroutineScope) {
            this.defaultLightweightExecutor = executor;
            this.defaultBackgroundExecutor = executor2;
            this.defaultBlockingExecutor = executor3;
            this.defaultCameraExecutor = executor4;
            this.defaultCameraHandler = handler;
            this.defaultCameraHandlerFn = function0;
            this.testOnlyScope = coroutineScope;
        }

        public /* synthetic */ ThreadConfig(Executor executor, Executor executor2, Executor executor3, Executor executor4, Handler handler, Function0 function0, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : executor, (i & 2) != 0 ? null : executor2, (i & 4) != 0 ? null : executor3, (i & 8) != 0 ? null : executor4, (i & 16) != 0 ? null : handler, (i & 32) != 0 ? null : function0, (i & 64) != 0 ? null : coroutineScope);
        }

        public final Executor getDefaultLightweightExecutor() {
            return this.defaultLightweightExecutor;
        }

        public final Executor getDefaultBackgroundExecutor() {
            return this.defaultBackgroundExecutor;
        }

        public final Executor getDefaultBlockingExecutor() {
            return this.defaultBlockingExecutor;
        }

        public final Executor getDefaultCameraExecutor() {
            return this.defaultCameraExecutor;
        }

        public final Handler getDefaultCameraHandler() {
            return this.defaultCameraHandler;
        }

        public final Function0<Handler> getDefaultCameraHandlerFn() {
            return this.defaultCameraHandlerFn;
        }

        public final CoroutineScope getTestOnlyScope() {
            return this.testOnlyScope;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u0006¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;", "", "cacheBlocklist", "", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "cameraCacheBlocklist", "", "Landroidx/camera/camera2/pipe/CameraId;", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getCacheBlocklist", "()Ljava/util/Set;", "getCameraCacheBlocklist", "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraMetadataConfig {
        private final Set<CameraCharacteristics.Key<?>> cacheBlocklist;
        private final Map<CameraId, Set<CameraCharacteristics.Key<?>>> cameraCacheBlocklist;

        /* JADX WARN: Multi-variable type inference failed */
        public CameraMetadataConfig() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CameraMetadataConfig(Set<? extends CameraCharacteristics.Key<?>> cacheBlocklist, Map<CameraId, ? extends Set<? extends CameraCharacteristics.Key<?>>> cameraCacheBlocklist) {
            Intrinsics.checkNotNullParameter(cacheBlocklist, "cacheBlocklist");
            Intrinsics.checkNotNullParameter(cameraCacheBlocklist, "cameraCacheBlocklist");
            this.cacheBlocklist = cacheBlocklist;
            this.cameraCacheBlocklist = cameraCacheBlocklist;
        }

        public /* synthetic */ CameraMetadataConfig(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Set<CameraCharacteristics.Key<?>> getCacheBlocklist() {
            return this.cacheBlocklist;
        }

        public final Map<CameraId, Set<CameraCharacteristics.Key<?>>> getCameraCacheBlocklist() {
            return this.cameraCacheBlocklist;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$CameraBackendConfig;", "", "internalBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "defaultBackend", "Landroidx/camera/camera2/pipe/CameraBackendId;", "cameraBackends", "", "Landroidx/camera/camera2/pipe/CameraBackendFactory;", "<init>", "(Landroidx/camera/camera2/pipe/CameraBackend;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInternalBackend", "()Landroidx/camera/camera2/pipe/CameraBackend;", "getDefaultBackend-AKmI2lo", "()Ljava/lang/String;", "Ljava/lang/String;", "getCameraBackends", "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraBackendConfig {
        private final Map<CameraBackendId, CameraBackendFactory> cameraBackends;
        private final String defaultBackend;
        private final CameraBackend internalBackend;

        public /* synthetic */ CameraBackendConfig(CameraBackend cameraBackend, String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(cameraBackend, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CameraBackendConfig(CameraBackend cameraBackend, String str, Map<CameraBackendId, ? extends CameraBackendFactory> cameraBackends) {
            Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
            this.internalBackend = cameraBackend;
            this.defaultBackend = str;
            this.cameraBackends = cameraBackends;
            if (str != null) {
                if (cameraBackends.containsKey(str != null ? CameraBackendId.m235boximpl(str) : null)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((Object) (str == null ? AbstractJsonLexerKt.NULL : CameraBackendId.m240toStringimpl(str)));
                sb.append(" does not exist in cameraBackends! Available backends are: ");
                sb.append(cameraBackends.keySet());
                throw new IllegalStateException(sb.toString().toString());
            }
        }

        public final CameraBackend getInternalBackend() {
            return this.internalBackend;
        }

        /* JADX INFO: renamed from: getDefaultBackend-AKmI2lo, reason: not valid java name and from getter */
        public final String getDefaultBackend() {
            return this.defaultBackend;
        }

        public /* synthetic */ CameraBackendConfig(CameraBackend cameraBackend, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : cameraBackend, (i & 2) != 0 ? null : str, (i & 4) != 0 ? MapsKt.emptyMap() : map, null);
        }

        public final Map<CameraBackendId, CameraBackendFactory> getCameraBackends() {
            return this.cameraBackends;
        }
    }

    /* JADX INFO: compiled from: CameraPipe.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipe$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/CameraPipe;", "config", "Landroidx/camera/camera2/pipe/CameraPipe$Config;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final CameraPipe create(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("CameraPipe");
                CameraPipeComponent cameraPipeComponentBuild = DaggerCameraPipeComponent.builder().cameraPipeConfigModule(new CameraPipeConfigModule(config)).threadConfigModule(new ThreadConfigModule(config.getThreadConfig())).build();
                Trace.endSection();
                Intrinsics.checkNotNull(cameraPipeComponentBuild);
                return new CameraPipeImpl(cameraPipeComponentBuild);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }
}
