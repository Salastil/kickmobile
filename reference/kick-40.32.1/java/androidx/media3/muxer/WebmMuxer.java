package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class WebmMuxer implements Muxer {
    private int nextTrackId;
    private final SeekableMuxerOutput seekableMuxerOutput;
    private final List<Track> trackIdToTrack;
    private final WebmWriter writer;

    public static final class Builder {
        private boolean sampleCopyEnabled = true;
        private final SeekableMuxerOutput seekableMuxerOutput;

        public Builder(SeekableMuxerOutput seekableMuxerOutput) {
            this.seekableMuxerOutput = seekableMuxerOutput;
        }

        public Builder setSampleCopyEnabled(boolean z) {
            this.sampleCopyEnabled = z;
            return this;
        }

        public WebmMuxer build() {
            return new WebmMuxer(this.seekableMuxerOutput, this.sampleCopyEnabled);
        }
    }

    private WebmMuxer(SeekableMuxerOutput seekableMuxerOutput, boolean z) {
        this.seekableMuxerOutput = seekableMuxerOutput;
        this.trackIdToTrack = new ArrayList();
        this.writer = new WebmWriter(seekableMuxerOutput, z);
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) {
        Preconditions.checkArgument(isMimeTypeSupported(format));
        WebmWriter webmWriter = this.writer;
        int i = this.nextTrackId;
        this.nextTrackId = i + 1;
        Track trackAddTrack = webmWriter.addTrack(i, format);
        this.trackIdToTrack.add(trackAddTrack);
        return trackAddTrack.id;
    }

    private boolean isMimeTypeSupported(Format format) {
        return Objects.equals(format.sampleMimeType, "video/x-vnd.on2.vp9") || Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_VP8) || Objects.equals(format.sampleMimeType, MimeTypes.AUDIO_OPUS) || Objects.equals(format.sampleMimeType, MimeTypes.AUDIO_VORBIS);
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        try {
            this.writer.writeSampleData(this.trackIdToTrack.get(i), byteBuffer, bufferInfo);
        } catch (IOException e) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + bufferInfo.presentationTimeUs + ", size=" + bufferInfo.size, e);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        try {
            this.writer.close();
            try {
                this.seekableMuxerOutput.close();
            } catch (IOException e) {
                throw new MuxerException("Failed to close the output.", e);
            }
        } catch (IOException e2) {
            throw new MuxerException("Failed to close the writer.", e2);
        }
    }
}
