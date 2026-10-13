package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import com.google.common.base.Preconditions;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class AacMuxer implements Muxer {
    private boolean isTrackAdded;
    private final FileOutputStream outputStream;
    private final AacWriter writer;

    public AacMuxer(FileOutputStream fileOutputStream) {
        this.outputStream = fileOutputStream;
        this.writer = new AacWriter(fileOutputStream);
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) {
        Preconditions.checkArgument(Objects.equals(format.sampleMimeType, "audio/mp4a-latm"));
        Preconditions.checkArgument(!this.isTrackAdded, "Only one track is supported.");
        this.writer.setFormat(format);
        this.isTrackAdded = true;
        return 0;
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        try {
            Preconditions.checkArgument(this.isTrackAdded, "Track must be added before writing samples.");
            Preconditions.checkArgument(i == 0, "This track has not been added to the muxer.");
            this.writer.writeSampleData(byteBuffer, bufferInfo);
        } catch (IOException e) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + bufferInfo.presentationTimeUs + ", size=" + bufferInfo.size, e);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        throw new UnsupportedOperationException("Writing metadata is not supported for AacMuxer.");
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        try {
            this.outputStream.close();
        } catch (IOException e) {
            throw new MuxerException("Failed to close the muxer", e);
        }
    }
}
