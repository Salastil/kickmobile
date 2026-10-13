package androidx.camera.camera2.pipe;

import android.util.Size;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Streams.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/CameraStream;", "", "id", "Landroidx/camera/camera2/pipe/StreamId;", "outputs", "", "Landroidx/camera/camera2/pipe/OutputStream;", "<init>", "(ILjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-ptHMqGs", "()I", "I", "getOutputs", "()Ljava/util/List;", "toString", "", "Config", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraStream {
    private final int id;
    private final List<OutputStream> outputs;

    public /* synthetic */ CameraStream(int i, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CameraStream(int i, List<? extends OutputStream> outputs) {
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        this.id = i;
        this.outputs = outputs;
    }

    /* JADX INFO: renamed from: getId-ptHMqGs, reason: not valid java name and from getter */
    public final int getId() {
        return this.id;
    }

    public final List<OutputStream> getOutputs() {
        return this.outputs;
    }

    public String toString() {
        return StreamId.m796toStringimpl(this.id);
    }

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/CameraStream$Config;", "", "outputs", "", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/ImageSourceConfig;", "<init>", "(Ljava/util/List;Landroidx/camera/camera2/pipe/ImageSourceConfig;)V", "getOutputs", "()Ljava/util/List;", "getImageSourceConfig", "()Landroidx/camera/camera2/pipe/ImageSourceConfig;", "toString", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ImageSourceConfig imageSourceConfig;
        private final List<OutputStream.Config> outputs;

        /* JADX WARN: Multi-variable type inference failed */
        public Config(List<? extends OutputStream.Config> outputs, ImageSourceConfig imageSourceConfig) {
            Intrinsics.checkNotNullParameter(outputs, "outputs");
            this.outputs = outputs;
            this.imageSourceConfig = imageSourceConfig;
            OutputStream.Config config = (OutputStream.Config) CollectionsKt.first((List) outputs);
            List<? extends OutputStream.Config> list = outputs;
            if ((list instanceof Collection) && list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!StreamFormat.m748equalsimpl0(((OutputStream.Config) it.next()).getFormat(), config.getFormat())) {
                    throw new IllegalStateException("All outputs must have the same format!".toString());
                }
            }
        }

        public /* synthetic */ Config(List list, ImageSourceConfig imageSourceConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : imageSourceConfig);
        }

        public final List<OutputStream.Config> getOutputs() {
            return this.outputs;
        }

        public final ImageSourceConfig getImageSourceConfig() {
            return this.imageSourceConfig;
        }

        public String toString() {
            return "CameraStream.Config(outputs=" + this.outputs + ", imageSourceConfig=" + this.imageSourceConfig + ')';
        }

        /* JADX INFO: compiled from: Streams.kt */
        @kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ \u0010\u0004\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/CameraStream$Config$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/CameraStream$Config;", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/ImageSourceConfig;", "create-LbzH4Vg", "(Landroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;Landroidx/camera/camera2/pipe/ImageSourceConfig;)Landroidx/camera/camera2/pipe/CameraStream$Config;", "output", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "outputs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: create-LbzH4Vg$default, reason: not valid java name */
            public static /* synthetic */ Config m459createLbzH4Vg$default(Companion companion, Size size, int i, String str, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.StreamUseHint streamUseHint, List list, ImageSourceConfig imageSourceConfig, int i2, Object obj) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                if ((i2 & 8) != 0) {
                    outputType = OutputStream.OutputType.INSTANCE.getSURFACE();
                }
                if ((i2 & 16) != 0) {
                    mirrorMode = null;
                }
                if ((i2 & 32) != 0) {
                    timestampBase = null;
                }
                if ((i2 & 64) != 0) {
                    dynamicRangeProfile = null;
                }
                if ((i2 & 128) != 0) {
                    streamUseCase = null;
                }
                if ((i2 & 256) != 0) {
                    streamUseHint = null;
                }
                if ((i2 & 512) != 0) {
                    list = CollectionsKt.emptyList();
                }
                if ((i2 & 1024) != 0) {
                    imageSourceConfig = null;
                }
                return companion.m460createLbzH4Vg(size, i, str, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list, imageSourceConfig);
            }

            /* JADX INFO: renamed from: create-LbzH4Vg, reason: not valid java name */
            public final Config m460createLbzH4Vg(Size size, int format, String camera, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.StreamUseHint streamUseHint, List<OutputStream.SensorPixelMode> sensorPixelModes, ImageSourceConfig imageSourceConfig) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(outputType, "outputType");
                Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
                return create(OutputStream.Config.INSTANCE.m609createvBYXiEU(size, format, camera, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, sensorPixelModes), imageSourceConfig);
            }

            public static /* synthetic */ Config create$default(Companion companion, OutputStream.Config config, ImageSourceConfig imageSourceConfig, int i, Object obj) {
                if ((i & 2) != 0) {
                    imageSourceConfig = null;
                }
                return companion.create(config, imageSourceConfig);
            }

            public final Config create(OutputStream.Config output, ImageSourceConfig imageSourceConfig) {
                Intrinsics.checkNotNullParameter(output, "output");
                return new Config(CollectionsKt.listOf(output), imageSourceConfig);
            }

            public static /* synthetic */ Config create$default(Companion companion, List list, ImageSourceConfig imageSourceConfig, int i, Object obj) {
                if ((i & 2) != 0) {
                    imageSourceConfig = null;
                }
                return companion.create((List<? extends OutputStream.Config>) list, imageSourceConfig);
            }

            public final Config create(List<? extends OutputStream.Config> outputs, ImageSourceConfig imageSourceConfig) {
                Intrinsics.checkNotNullParameter(outputs, "outputs");
                return new Config(outputs, imageSourceConfig);
            }
        }
    }
}
