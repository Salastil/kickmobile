package org.bouncycastle.crypto;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public abstract class DefaultMultiBlockCipher implements MultiBlockCipher {
    protected DefaultMultiBlockCipher() {
    }

    @Override // org.bouncycastle.crypto.MultiBlockCipher
    public int getMultiBlockSize() {
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.MultiBlockCipher
    public int processBlocks(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalStateException, DataLengthException {
        int multiBlockSize = getMultiBlockSize();
        int i4 = i2 * multiBlockSize;
        if (bArr == bArr2 && Arrays.segmentsOverlap(i, i4, i3, i4)) {
            bArr = new byte[i4];
            System.arraycopy(bArr2, i, bArr, 0, i4);
            i = 0;
        }
        int iProcessBlock = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            iProcessBlock += processBlock(bArr, i, bArr2, i3 + iProcessBlock);
            i += multiBlockSize;
        }
        return iProcessBlock;
    }
}
