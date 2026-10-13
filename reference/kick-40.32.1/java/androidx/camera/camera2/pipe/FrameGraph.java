package androidx.camera.camera2.pipe;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0004\u000f\u0010\u0011\u0012J:\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/FrameGraph;", "Landroidx/camera/camera2/pipe/CameraGraphBase;", "Landroidx/camera/camera2/pipe/FrameGraph$Session;", "Landroidx/camera/camera2/pipe/CameraControls3A;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "captureWith", "Landroidx/camera/camera2/pipe/FrameBuffer;", "streamIds", "", "Landroidx/camera/camera2/pipe/StreamId;", "parameters", "", "", "capacity", "", "Config", "ConcurrentConfig", "Session", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FrameGraph extends CameraGraphBase<Session>, CameraControls3A, UnsafeWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: FrameGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/FrameGraph$Session;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Session extends CameraGraph.Session {
    }

    @JvmStatic
    /* JADX INFO: renamed from: captureWith---NP5ps, reason: not valid java name */
    static FrameBuffer m519captureWithNP5ps(FrameGraph frameGraph, int i, Map<Object, ? extends Object> map, int i2) {
        return INSTANCE.m521captureWithNP5ps(frameGraph, i, map, i2);
    }

    FrameBuffer captureWith(Set<StreamId> streamIds, Map<Object, ? extends Object> parameters, int capacity);

    /* JADX INFO: compiled from: FrameGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/FrameGraph$Config;", "", "cameraGraphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;)V", "getCameraGraphConfig", "()Landroidx/camera/camera2/pipe/CameraGraph$Config;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {
        private final CameraGraph.Config cameraGraphConfig;

        public Config(CameraGraph.Config cameraGraphConfig) {
            Intrinsics.checkNotNullParameter(cameraGraphConfig, "cameraGraphConfig");
            this.cameraGraphConfig = cameraGraphConfig;
        }

        public final CameraGraph.Config getCameraGraphConfig() {
            return this.cameraGraphConfig;
        }
    }

    /* JADX INFO: compiled from: FrameGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/FrameGraph$ConcurrentConfig;", "", "cameraGraphConfigs", "Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;", "frameGraphConfigs", "", "Landroidx/camera/camera2/pipe/FrameGraph$Config;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;Ljava/util/List;)V", "getCameraGraphConfigs", "()Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;", "getFrameGraphConfigs", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConcurrentConfig {
        private final CameraGraph.ConcurrentConfig cameraGraphConfigs;
        private final List<Config> frameGraphConfigs;

        public ConcurrentConfig(CameraGraph.ConcurrentConfig cameraGraphConfigs, List<Config> frameGraphConfigs) {
            Intrinsics.checkNotNullParameter(cameraGraphConfigs, "cameraGraphConfigs");
            Intrinsics.checkNotNullParameter(frameGraphConfigs, "frameGraphConfigs");
            this.cameraGraphConfigs = cameraGraphConfigs;
            this.frameGraphConfigs = frameGraphConfigs;
            int size = cameraGraphConfigs.getGraphConfigs().size();
            int size2 = cameraGraphConfigs.getGraphConfigs().size();
            if (size2 != size) {
                throw new IllegalArgumentException(("Invalid FrameGraph.ConcurrentConfig! Expected " + size + " configs, but received " + size2 + " FrameGraph.Config(s).").toString());
            }
            for (Config config : frameGraphConfigs) {
                if (!this.cameraGraphConfigs.getGraphConfigs().contains(config.getCameraGraphConfig())) {
                    throw new IllegalArgumentException(("Mismatched " + config + "! Config is not present within " + this.cameraGraphConfigs.getGraphConfigs()).toString());
                }
            }
        }

        public final CameraGraph.ConcurrentConfig getCameraGraphConfigs() {
            return this.cameraGraphConfigs;
        }

        public final List<Config> getFrameGraphConfigs() {
            return this.frameGraphConfigs;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ FrameBuffer captureWith$default(FrameGraph frameGraph, Set set, Map map, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureWith");
        }
        if ((i2 & 1) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return frameGraph.captureWith(set, map, i);
    }

    /* JADX INFO: compiled from: FrameGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/FrameGraph$Companion;", "", "<init>", "()V", "DEFAULT_FRAME_BUFFER_CAPACITY", "", "captureWith", "Landroidx/camera/camera2/pipe/FrameBuffer;", "Landroidx/camera/camera2/pipe/FrameGraph;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "parameters", "", "capacity", "captureWith---NP5ps", "(Landroidx/camera/camera2/pipe/FrameGraph;ILjava/util/Map;I)Landroidx/camera/camera2/pipe/FrameBuffer;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DEFAULT_FRAME_BUFFER_CAPACITY = 1;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: captureWith---NP5ps$default, reason: not valid java name */
        public static /* synthetic */ FrameBuffer m520captureWithNP5ps$default(Companion companion, FrameGraph frameGraph, int i, Map map, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return companion.m521captureWithNP5ps(frameGraph, i, map, i2);
        }

        @JvmStatic
        /* JADX INFO: renamed from: captureWith---NP5ps, reason: not valid java name */
        public final FrameBuffer m521captureWithNP5ps(FrameGraph captureWith, int i, Map<Object, ? extends Object> parameters, int i2) {
            Intrinsics.checkNotNullParameter(captureWith, "$this$captureWith");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            return captureWith.captureWith(SetsKt.setOf(StreamId.m791boximpl(i)), parameters, i2);
        }
    }
}
