package androidx.media3.muxer;

import androidx.media3.container.ObuParser;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
final class Av1ConfigUtil {
    private static final int MAX_AV1_CONFIG_RECORD_SIZE_BYTES = 4;
    private static final int MAX_HEADER_AND_LENGTH_SIZE_BYTES = 9;
    private static final int MAX_LEB128_SIZE_BYTES = 8;
    private static final int OBU_HAS_SIZE_FIELD_BYTES = 2;

    private static int lebSizeInBytes(int i) {
        int i2 = 0;
        do {
            i2++;
            i >>= 7;
        } while (i != 0);
        return i2;
    }

    private static byte obuHeader(int i) {
        return (byte) ((i << 3) | 2);
    }

    public static byte[] createAv1CodecConfigurationRecord(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBufferConcatenateBuffers = null;
        ByteBuffer configFromSeqHeader = null;
        for (ObuParser.Obu obu : ObuParser.split(byteBuffer)) {
            if (obu.type == 5) {
                arrayList.add(getConfigObuWithHeaderAndLength(obu));
            } else if (obu.type == 1 && byteBufferConcatenateBuffers == null) {
                byteBufferConcatenateBuffers = getConfigObuWithHeaderAndLength(obu);
                configFromSeqHeader = parseConfigFromSeqHeader(obu);
            }
        }
        Preconditions.checkNotNull(byteBufferConcatenateBuffers, "No sequence header available.");
        ByteBuffer byteBufferConcatenateBuffers2 = BoxUtils.concatenateBuffers((ByteBuffer[]) arrayList.toArray(new ByteBuffer[0]));
        if (byteBufferConcatenateBuffers2 != null) {
            byteBufferConcatenateBuffers = BoxUtils.concatenateBuffers(byteBufferConcatenateBuffers, byteBufferConcatenateBuffers2);
        }
        return BoxUtils.concatenateBuffers((ByteBuffer) Preconditions.checkNotNull(configFromSeqHeader, "csdHeader is null."), byteBufferConcatenateBuffers).array();
    }

    private static ByteBuffer getConfigObuWithHeaderAndLength(ObuParser.Obu obu) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(obu.payload.remaining() + 9);
        byteBufferAllocate.put(obuHeader(obu.type));
        byteBufferAllocate.put(lebEncode(obu.payload.remaining()));
        byteBufferAllocate.put(obu.payload.duplicate());
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer lebEncode(int i) {
        Preconditions.checkArgument(i > 0);
        int iLebSizeInBytes = lebSizeInBytes(i);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iLebSizeInBytes);
        Preconditions.checkState(iLebSizeInBytes < 8);
        for (int i2 = 0; i2 < iLebSizeInBytes; i2++) {
            int i3 = (byte) (i & 127);
            i >>= 7;
            if (i != 0) {
                i3 |= 128;
            }
            byteBufferAllocate.put((byte) i3);
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer parseConfigFromSeqHeader(ObuParser.Obu obu) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.put((byte) -127);
        ObuParser.SequenceHeader sequenceHeader = ObuParser.SequenceHeader.parse(obu);
        Preconditions.checkNotNull(sequenceHeader, "No sequence header available.");
        byteBufferAllocate.put((byte) ((sequenceHeader.seqProfile << 5) | sequenceHeader.seqLevelIdx0));
        byteBufferAllocate.put((byte) ((sequenceHeader.subsamplingY ? 4 : 0) | (sequenceHeader.seqTier0 > 0 ? 128 : 0) | (sequenceHeader.highBitdepth ? 64 : 0) | (sequenceHeader.twelveBit ? 32 : 0) | (sequenceHeader.monochrome ? 16 : 0) | (sequenceHeader.subsamplingX ? 8 : 0) | sequenceHeader.chromaSamplePosition));
        byteBufferAllocate.put((byte) ((sequenceHeader.initialDisplayDelayPresentFlag ? 16 : 0) | (sequenceHeader.initialDisplayDelayPresentFlag ? sequenceHeader.initialDisplayDelayMinus1 & 15 : 0)));
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private Av1ConfigUtil() {
    }
}
