package androidx.media3.muxer;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentedMp4Muxer implements Muxer {
    public static final long DEFAULT_FRAGMENT_DURATION_MS = 2000;
    private final FragmentedMp4Writer fragmentedMp4Writer;
    private final MetadataCollector metadataCollector;
    private final SparseArray<Track> trackIdToTrack;
    public static final ImmutableList<String> SUPPORTED_VIDEO_SAMPLE_MIME_TYPES = ImmutableList.of("video/av01", MimeTypes.VIDEO_H263, "video/avc", "video/hevc", MimeTypes.VIDEO_MP4V, "video/x-vnd.on2.vp9", MimeTypes.VIDEO_APV, MimeTypes.VIDEO_DOLBY_VISION);
    public static final ImmutableList<String> SUPPORTED_AUDIO_SAMPLE_MIME_TYPES = ImmutableList.of("audio/mp4a-latm", MimeTypes.AUDIO_AMR_NB, MimeTypes.AUDIO_AMR_WB, MimeTypes.AUDIO_OPUS, MimeTypes.AUDIO_VORBIS, MimeTypes.AUDIO_RAW);

    public static final class Builder {
        private long fragmentDurationMs;
        private final WritableByteChannel outputChannel;
        private boolean sampleCopyEnabled;

        @Deprecated
        public Builder(OutputStream outputStream) {
            this(Channels.newChannel(outputStream));
        }

        public Builder(WritableByteChannel writableByteChannel) {
            this.outputChannel = writableByteChannel;
            this.fragmentDurationMs = 2000L;
            this.sampleCopyEnabled = true;
        }

        public Builder setFragmentDurationMs(long j) {
            this.fragmentDurationMs = j;
            return this;
        }

        public Builder setSampleCopyingEnabled(boolean z) {
            this.sampleCopyEnabled = z;
            return this;
        }

        public FragmentedMp4Muxer build() {
            return new FragmentedMp4Muxer(this.outputChannel, this.fragmentDurationMs, this.sampleCopyEnabled);
        }
    }

    private FragmentedMp4Muxer(WritableByteChannel writableByteChannel, long j, boolean z) {
        MetadataCollector metadataCollector = new MetadataCollector();
        this.metadataCollector = metadataCollector;
        this.fragmentedMp4Writer = new FragmentedMp4Writer(writableByteChannel, metadataCollector, AnnexBToAvccConverter.DEFAULT, j, z);
        this.trackIdToTrack = new SparseArray<>();
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) {
        Track trackAddTrack = this.fragmentedMp4Writer.addTrack(1, format);
        this.trackIdToTrack.append(trackAddTrack.id, trackAddTrack);
        return trackAddTrack.id;
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        try {
            this.fragmentedMp4Writer.writeSampleData(this.trackIdToTrack.get(i), byteBuffer, bufferInfo);
        } catch (IOException e) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + bufferInfo.presentationTimeUs + ", size=" + bufferInfo.size, e);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        Preconditions.checkArgument(MuxerUtil.isMetadataSupported(entry), "Unsupported metadata");
        this.metadataCollector.addMetadata(entry);
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        try {
            this.fragmentedMp4Writer.close();
        } catch (IOException e) {
            throw new MuxerException("Failed to close the muxer", e);
        }
    }
}
