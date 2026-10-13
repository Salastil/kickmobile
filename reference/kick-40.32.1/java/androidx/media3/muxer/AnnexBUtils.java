package androidx.media3.muxer;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class AnnexBUtils {
    private static final int THREE_BYTE_NAL_START_CODE_SIZE = 3;

    private AnnexBUtils() {
    }

    public static ImmutableList<ByteBuffer> findNalUnits(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return ImmutableList.of();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        int iSkipLeadingZerosAndFindNalStartCodeIndex = skipLeadingZerosAndFindNalStartCodeIndex(byteBufferAsReadOnlyBuffer, byteBufferAsReadOnlyBuffer.position()) + 3;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = iSkipLeadingZerosAndFindNalStartCodeIndex;
        boolean z = true;
        while (iSkipLeadingZerosAndFindNalStartCodeIndex < byteBufferAsReadOnlyBuffer.limit()) {
            if (z) {
                iSkipLeadingZerosAndFindNalStartCodeIndex = findNalEndIndex(byteBufferAsReadOnlyBuffer, iSkipLeadingZerosAndFindNalStartCodeIndex);
                builder.add(getBytes(byteBufferAsReadOnlyBuffer, i, iSkipLeadingZerosAndFindNalStartCodeIndex - i));
                z = false;
            } else {
                int iSkipLeadingZerosAndFindNalStartCodeIndex2 = skipLeadingZerosAndFindNalStartCodeIndex(byteBufferAsReadOnlyBuffer, iSkipLeadingZerosAndFindNalStartCodeIndex);
                if (iSkipLeadingZerosAndFindNalStartCodeIndex2 == byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                i = iSkipLeadingZerosAndFindNalStartCodeIndex2 + 3;
                z = true;
                iSkipLeadingZerosAndFindNalStartCodeIndex = i;
            }
        }
        return builder.build();
    }

    public static ByteBuffer stripEmulationPrevention(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
        int i = 0;
        for (int i2 = 0; i2 < byteBuffer.limit(); i2++) {
            if (byteBuffer.get(i2) != 3 || i < 2) {
                byteBufferAllocate.put(byteBuffer.get(i2));
            }
            i = byteBuffer.get(i2) == 0 ? i + 1 : 0;
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static boolean doesSampleContainAnnexBNalUnits(Format format) {
        String str = format.sampleMimeType;
        Preconditions.checkNotNull(str);
        if (str.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            return ((Integer) ((Pair) Preconditions.checkNotNull(Boxes.getDolbyVisionProfileAndLevel(format))).first).intValue() != 10;
        }
        return str.equals("video/avc") || str.equals("video/hevc");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r2 == 1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int findNalEndIndex(java.nio.ByteBuffer r4, int r5) {
        /*
        L0:
            int r0 = r4.limit()
            int r0 = r0 + (-4)
            r1 = 1
            if (r5 > r0) goto L34
            int r0 = r4.getInt(r5)
            r2 = r0 & (-256(0xffffffffffffff00, float:NaN))
            if (r2 == 0) goto L4c
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L16
            goto L4c
        L16:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r0
            if (r2 == 0) goto L32
            if (r2 != r1) goto L1f
            goto L32
        L1f:
            r1 = 65535(0xffff, float:9.1834E-41)
            r1 = r1 & r0
            if (r1 != 0) goto L28
            int r5 = r5 + 2
            goto L0
        L28:
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 != 0) goto L2f
            int r5 = r5 + 3
            goto L0
        L2f:
            int r5 = r5 + 4
            goto L0
        L32:
            int r5 = r5 + r1
            return r5
        L34:
            int r0 = r4.limit()
            int r0 = r0 + (-3)
            if (r5 != r0) goto L4d
            short r0 = r4.getShort(r5)
            int r2 = r5 + 2
            byte r2 = r4.get(r2)
            if (r0 != 0) goto L4d
            if (r2 == 0) goto L4c
            if (r2 != r1) goto L4d
        L4c:
            return r5
        L4d:
            int r4 = r4.limit()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.muxer.AnnexBUtils.findNalEndIndex(java.nio.ByteBuffer, int):int");
    }

    private static int skipLeadingZerosAndFindNalStartCodeIndex(ByteBuffer byteBuffer, int i) {
        while (true) {
            boolean z = false;
            if (i <= byteBuffer.limit() - 4) {
                int i2 = byteBuffer.getInt(i);
                int i3 = i2 & (-256);
                if (i3 == 256) {
                    break;
                }
                Preconditions.checkState(i3 == 0, "Invalid Nal units");
                int i4 = i2 & 255;
                if (i4 == 1) {
                    return i + 1;
                }
                if (i4 == 0) {
                    z = true;
                }
                Preconditions.checkState(z, "Invalid Nal units");
                i++;
            } else {
                if (i <= byteBuffer.limit() - 3) {
                    Preconditions.checkState(byteBuffer.getShort(i) == 0, "Invalid NAL units");
                    byte b = byteBuffer.get(i + 2);
                    if (b == 1) {
                        break;
                    }
                    Preconditions.checkState(b == 0, "Invalid NAL units");
                } else {
                    while (i < byteBuffer.limit()) {
                        Preconditions.checkState(byteBuffer.get(i) == 0, "Invalid NAL units");
                        i++;
                    }
                }
                return byteBuffer.limit();
            }
        }
        return i;
    }

    private static ByteBuffer getBytes(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(i + i2);
        return byteBufferDuplicate.slice();
    }
}
