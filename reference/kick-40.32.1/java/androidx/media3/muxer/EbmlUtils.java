package androidx.media3.muxer;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class EbmlUtils {
    private EbmlUtils() {
    }

    public static ByteBuffer encodeVIntWithWidth(long j, int i) {
        Preconditions.checkArgument(i >= 1 && i <= 8);
        byte[] bArr = new byte[i];
        long j2 = j | (1 << (i * 7));
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (j2 >>> (((i - 1) - i2) * 8));
        }
        return ByteBuffer.wrap(bArr);
    }

    public static ByteBuffer encodeVInt(long j) {
        return encodeVIntWithWidth(j, calculateMinimumVIntLength(j));
    }

    public static int calculateMinimumVIntLength(long j) {
        Preconditions.checkArgument(j >= 0);
        if (j <= 126) {
            return 1;
        }
        if (j <= 16382) {
            return 2;
        }
        if (j <= 2097150) {
            return 3;
        }
        if (j <= 268435454) {
            return 4;
        }
        if (j <= 34359738366L) {
            return 5;
        }
        if (j <= 4398046511102L) {
            return 6;
        }
        if (j <= 562949953421310L) {
            return 7;
        }
        if (j <= 72057594037927934L) {
            return 8;
        }
        throw new IllegalArgumentException("Value " + j + " is too large for a VINT.");
    }
}
