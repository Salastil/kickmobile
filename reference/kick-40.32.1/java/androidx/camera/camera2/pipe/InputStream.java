package androidx.camera.camera2.pipe;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Streams.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/InputStream;", "", "id", "Landroidx/camera/camera2/pipe/InputStreamId;", "getId-m1bwn9M", "()I", "maxImages", "", "getMaxImages", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "getFormat-8FPWQzE", "Config", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface InputStream {
    /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: not valid java name */
    int getFormat();

    /* JADX INFO: renamed from: getId-m1bwn9M, reason: not valid java name */
    int getId();

    int getMaxImages();

    /* JADX INFO: compiled from: Streams.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/InputStream$Config;", "", "stream", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "maxImages", "", "streamFormat", "Landroidx/camera/camera2/pipe/StreamFormat;", "<init>", "(Landroidx/camera/camera2/pipe/CameraStream$Config;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStream", "()Landroidx/camera/camera2/pipe/CameraStream$Config;", "getMaxImages", "()I", "getStreamFormat-8FPWQzE", "setStreamFormat-hNQ4ISI", "(I)V", "I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Config {
        private final int maxImages;
        private final CameraStream.Config stream;
        private int streamFormat;

        public /* synthetic */ Config(CameraStream.Config config, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(config, i, i2);
        }

        private Config(CameraStream.Config stream, int i, int i2) {
            Intrinsics.checkNotNullParameter(stream, "stream");
            this.stream = stream;
            this.maxImages = i;
            this.streamFormat = i2;
        }

        public final CameraStream.Config getStream() {
            return this.stream;
        }

        public final int getMaxImages() {
            return this.maxImages;
        }

        /* JADX INFO: renamed from: getStreamFormat-8FPWQzE, reason: not valid java name and from getter */
        public final int getStreamFormat() {
            return this.streamFormat;
        }

        /* JADX INFO: renamed from: setStreamFormat-hNQ4ISI, reason: not valid java name */
        public final void m550setStreamFormathNQ4ISI(int i) {
            this.streamFormat = i;
        }
    }
}
