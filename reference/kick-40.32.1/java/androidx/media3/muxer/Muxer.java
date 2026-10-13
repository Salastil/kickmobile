package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface Muxer extends AutoCloseable {

    public interface Factory {
        Muxer create(String str) throws MuxerException;

        ImmutableList<String> getSupportedSampleMimeTypes(int i);

        default boolean supportsWritingNegativeTimestampsInEditList() {
            return false;
        }
    }

    void addMetadataEntry(Metadata.Entry entry);

    int addTrack(Format format) throws MuxerException;

    @Override // java.lang.AutoCloseable
    void close() throws MuxerException;

    void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException;
}
