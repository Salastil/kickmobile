package androidx.media3.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.ErrnoException;
import android.system.Os;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4OrientationData;
import com.google.common.base.Preconditions;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class MediaMuxerCompat {
    public static final int OUTPUT_FORMAT_MP4 = 0;
    private boolean closedMuxer;
    private final FileDescriptor fileDescriptor;
    private final Muxer muxer;
    private boolean startedMuxer;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputFormat {
    }

    public MediaMuxerCompat(FileDescriptor fileDescriptor, int i) throws IOException {
        try {
            FileDescriptor fileDescriptorDup = Os.dup(fileDescriptor);
            this.fileDescriptor = fileDescriptorDup;
            this.muxer = createMuxer(new FileOutputStream(fileDescriptorDup), i);
        } catch (ErrnoException e) {
            throw new IOException("Failed to create a copy of FileDescriptor", e);
        }
    }

    public MediaMuxerCompat(String str, int i) throws IOException {
        this.fileDescriptor = null;
        this.muxer = createMuxer(new FileOutputStream(str), i);
    }

    public void start() {
        Preconditions.checkState(!this.startedMuxer);
        Preconditions.checkState(!this.closedMuxer);
        this.startedMuxer = true;
    }

    public int addTrack(MediaFormat mediaFormat) {
        Preconditions.checkState(!this.startedMuxer);
        try {
            float floatFromIntOrFloat = MediaFormatUtil.getFloatFromIntOrFloat(mediaFormat, "capture-rate", -3.4028235E38f);
            if (floatFromIntOrFloat != -3.4028235E38f) {
                this.muxer.addMetadataEntry(new MdtaMetadataEntry(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS, Util.toByteArray(floatFromIntOrFloat), 23));
            }
            return this.muxer.addTrack(MediaFormatUtil.createFormatFromMediaFormat(mediaFormat));
        } catch (MuxerException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Preconditions.checkState(this.startedMuxer);
        try {
            this.muxer.writeSampleData(i, byteBuffer, MuxerUtil.getMuxerBufferInfoFromMediaCodecBufferInfo(bufferInfo));
        } catch (MuxerException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLocation(float f, float f2) {
        Preconditions.checkState(!this.startedMuxer);
        this.muxer.addMetadataEntry(new Mp4LocationData(f, f2));
    }

    public void setOrientationHint(int i) {
        Preconditions.checkState(!this.startedMuxer);
        this.muxer.addMetadataEntry(new Mp4OrientationData(i));
    }

    public void stop() {
        Preconditions.checkState(this.startedMuxer);
        closeMuxer();
    }

    public void release() {
        if (this.closedMuxer) {
            return;
        }
        closeMuxer();
    }

    private void closeMuxer() {
        try {
            this.muxer.close();
            FileDescriptor fileDescriptor = this.fileDescriptor;
            if (fileDescriptor != null) {
                Os.close(fileDescriptor);
            }
            this.closedMuxer = true;
            this.startedMuxer = false;
        } catch (ErrnoException | MuxerException e) {
            throw new RuntimeException(e);
        }
    }

    private static Muxer createMuxer(FileOutputStream fileOutputStream, int i) {
        Preconditions.checkArgument(i == 0);
        return new Mp4Muxer.Builder(SeekableMuxerOutput.of(fileOutputStream)).build();
    }
}
