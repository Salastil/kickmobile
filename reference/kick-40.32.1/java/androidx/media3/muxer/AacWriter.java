package androidx.media3.muxer;

import android.util.Pair;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import androidx.media3.common.Format;
import androidx.media3.common.util.CodecSpecificDataUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
final class AacWriter {
    private static final int ADTS_HEADER_LENGTH = 7;
    private static final ImmutableMap<Integer, Integer> SAMPLE_RATE_TABLE_INDEX = ImmutableMap.ofEntries(UByte$$ExternalSyntheticBackport0.m12755m((Object) Integer.valueOf(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE), (Object) 0), UByte$$ExternalSyntheticBackport0.m12755m((Object) 88200, (Object) 1), UByte$$ExternalSyntheticBackport0.m12755m((Object) 64000, (Object) 2), UByte$$ExternalSyntheticBackport0.m12755m((Object) 48000, (Object) 3), UByte$$ExternalSyntheticBackport0.m12755m((Object) 44100, (Object) 4), UByte$$ExternalSyntheticBackport0.m12755m((Object) 32000, (Object) 5), UByte$$ExternalSyntheticBackport0.m12755m((Object) 24000, (Object) 6), UByte$$ExternalSyntheticBackport0.m12755m((Object) 22050, (Object) 7), UByte$$ExternalSyntheticBackport0.m12755m((Object) 16000, (Object) 8), UByte$$ExternalSyntheticBackport0.m12755m((Object) 12000, (Object) 9), UByte$$ExternalSyntheticBackport0.m12755m((Object) 11025, (Object) 10), UByte$$ExternalSyntheticBackport0.m12755m((Object) 8000, (Object) 11), UByte$$ExternalSyntheticBackport0.m12755m((Object) 7350, (Object) 12));
    private Format format;
    private final FileChannel outputFileChannel;
    private int profileCode;
    private int sampleFreqIndex;

    public AacWriter(FileOutputStream fileOutputStream) {
        this.outputFileChannel = fileOutputStream.getChannel();
    }

    public void setFormat(Format format) {
        Preconditions.checkArgument(format.channelCount >= 1 && format.channelCount <= 7, "Channel count must be between 1 and 7, got %s", format.channelCount);
        this.profileCode = ((Integer) ((Pair) Preconditions.checkNotNull(CodecSpecificDataUtil.getCodecProfileAndLevel(format))).first).intValue();
        this.sampleFreqIndex = ((Integer) Preconditions.checkNotNull(SAMPLE_RATE_TABLE_INDEX.get(Integer.valueOf(format.sampleRate)))).intValue();
        this.format = format;
    }

    public void writeSampleData(ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        this.outputFileChannel.write(createAdtsHeader(bufferInfo.size + 7));
        this.outputFileChannel.write(byteBuffer);
    }

    private ByteBuffer createAdtsHeader(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        byteBufferAllocate.put((byte) -1);
        byteBufferAllocate.put((byte) -15);
        int i2 = ((Format) Preconditions.checkNotNull(this.format)).channelCount;
        byteBufferAllocate.put((byte) ((this.sampleFreqIndex << 2) | (this.profileCode << 6) | (i2 >> 2)));
        byteBufferAllocate.put((byte) (((i2 & 3) << 6) | ((i & 6144) >> 11)));
        byteBufferAllocate.put((byte) ((i & 2040) >> 3));
        byteBufferAllocate.put((byte) (((i & 7) << 5) | 31));
        byteBufferAllocate.put((byte) -4);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
