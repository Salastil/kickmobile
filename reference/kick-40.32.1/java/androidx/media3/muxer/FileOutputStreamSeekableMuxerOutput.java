package androidx.media3.muxer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class FileOutputStreamSeekableMuxerOutput implements SeekableMuxerOutput {
    private final FileChannel fileChannel;
    private final FileOutputStream fileOutputStream;

    public FileOutputStreamSeekableMuxerOutput(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
        this.fileChannel = fileOutputStream.getChannel();
    }

    @Override // androidx.media3.muxer.SeekableMuxerOutput
    public long getPosition() throws IOException {
        return this.fileChannel.position();
    }

    @Override // androidx.media3.muxer.SeekableMuxerOutput
    public void setPosition(long j) throws IOException {
        this.fileChannel.position(j);
    }

    @Override // androidx.media3.muxer.SeekableMuxerOutput
    public long getSize() throws IOException {
        return this.fileChannel.size();
    }

    @Override // androidx.media3.muxer.SeekableMuxerOutput
    public void truncate(long j) throws IOException {
        this.fileChannel.truncate(j);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.fileChannel.write(byteBuffer);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.fileChannel.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fileOutputStream.close();
    }
}
