package androidx.camera.video.internal.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.ParcelFileDescriptor;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: Muxer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u001eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Landroidx/camera/video/internal/muxer/Muxer;", "", "setOutput", "", "path", "", "format", "", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "setOrientationDegrees", "degrees", "setLocation", "latitude", "", "longitude", "setCaptureFps", "captureFps", "addTrack", "Landroid/media/MediaFormat;", ViewProps.START, "stop", "writeSampleData", "trackIndex", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "isInterruptionResilient", "", "Companion", "Format", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Muxer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MUXER_FORMAT_3GPP = 2;
    public static final int MUXER_FORMAT_MPEG_4 = 0;
    public static final int MUXER_FORMAT_WEBM = 1;

    /* JADX INFO: compiled from: Muxer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/video/internal/muxer/Muxer$Format;", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Format {
    }

    int addTrack(MediaFormat format) throws MuxerException;

    boolean isInterruptionResilient();

    void release();

    void setCaptureFps(int captureFps) throws IllegalArgumentException;

    void setLocation(double latitude, double longitude) throws IllegalArgumentException;

    void setOrientationDegrees(int degrees) throws IllegalArgumentException;

    void setOutput(ParcelFileDescriptor parcelFileDescriptor, int format) throws IOException;

    void setOutput(String path, int format) throws IOException;

    void start() throws MuxerException;

    void stop() throws MuxerException;

    void writeSampleData(int trackIndex, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws MuxerException;

    /* JADX INFO: compiled from: Muxer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/camera/video/internal/muxer/Muxer$Companion;", "", "<init>", "()V", "MUXER_FORMAT_MPEG_4", "", "MUXER_FORMAT_WEBM", "MUXER_FORMAT_3GPP", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MUXER_FORMAT_3GPP = 2;
        public static final int MUXER_FORMAT_MPEG_4 = 0;
        public static final int MUXER_FORMAT_WEBM = 1;

        private Companion() {
        }
    }
}
