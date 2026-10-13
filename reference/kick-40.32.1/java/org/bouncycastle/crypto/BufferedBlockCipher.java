package org.bouncycastle.crypto;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected boolean forEncryption;
    protected MultiBlockCipher mbCipher;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    BufferedBlockCipher() {
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        if (blockCipher instanceof MultiBlockCipher) {
            MultiBlockCipher multiBlockCipher = (MultiBlockCipher) blockCipher;
            this.mbCipher = multiBlockCipher;
            this.buf = new byte[multiBlockCipher.getMultiBlockSize()];
        } else {
            this.mbCipher = null;
            this.buf = new byte[blockCipher.getBlockSize()];
        }
        boolean z = false;
        this.bufOff = 0;
        String algorithmName = blockCipher.getAlgorithmName();
        int iIndexOf = algorithmName.indexOf(47) + 1;
        boolean z2 = iIndexOf > 0 && algorithmName.startsWith("PGP", iIndexOf);
        this.pgpCFB = z2;
        if (z2 || (blockCipher instanceof StreamCipher)) {
            this.partialBlockOkay = true;
            return;
        }
        if (iIndexOf > 0 && algorithmName.startsWith("OpenPGP", iIndexOf)) {
            z = true;
        }
        this.partialBlockOkay = z;
    }

    public int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        try {
            int i2 = this.bufOff;
            if (i + i2 > bArr.length) {
                throw new OutputLengthException("output buffer too short for doFinal()");
            }
            int i3 = 0;
            if (i2 != 0) {
                if (!this.partialBlockOkay) {
                    throw new DataLengthException("data not block size aligned");
                }
                BlockCipher blockCipher = this.cipher;
                byte[] bArr2 = this.buf;
                blockCipher.processBlock(bArr2, 0, bArr2, 0);
                int i4 = this.bufOff;
                this.bufOff = 0;
                System.arraycopy(this.buf, 0, bArr, i, i4);
                i3 = i4;
            }
            reset();
            return i3;
        } catch (Throwable th) {
            reset();
            throw th;
        }
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int i) {
        int blockSize;
        if (this.pgpCFB && this.forEncryption) {
            i += this.bufOff;
            blockSize = this.cipher.getBlockSize() + 2;
        } else {
            blockSize = this.bufOff;
        }
        return i + blockSize;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i) {
        int length;
        int length2;
        int i2 = i + this.bufOff;
        if (this.pgpCFB) {
            boolean z = this.forEncryption;
            byte[] bArr = this.buf;
            if (z) {
                length2 = (i2 % bArr.length) - (this.cipher.getBlockSize() + 2);
            } else {
                length = bArr.length;
            }
            return i2 - length2;
        }
        length = this.buf.length;
        length2 = i2 % length;
        return i2 - length2;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z;
        reset();
        this.cipher.init(z, cipherParameters);
    }

    public int processByte(byte b, byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        int i3 = i2 + 1;
        this.bufOff = i3;
        bArr2[i2] = b;
        if (i3 != bArr2.length) {
            return 0;
        }
        int iProcessBlock = this.cipher.processBlock(bArr2, 0, bArr, i);
        this.bufOff = 0;
        return iProcessBlock;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalStateException, DataLengthException {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i2);
        if (updateOutputSize > 0 && i3 + updateOutputSize > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = this.buf;
        int length = bArr3.length;
        int i9 = this.bufOff;
        int i10 = length - i9;
        if (i2 > i10) {
            System.arraycopy(bArr, i, bArr3, i9, i10);
            int i11 = i + i10;
            int i12 = i2 - i10;
            if (bArr == bArr2 && Arrays.segmentsOverlap(i11, i12, i3, updateOutputSize)) {
                bArr = new byte[i12];
                System.arraycopy(bArr2, i11, bArr, 0, i12);
                i7 = 0;
            } else {
                i7 = i11;
            }
            byte[] bArr4 = bArr;
            int iProcessBlock = this.cipher.processBlock(this.buf, 0, bArr2, i3);
            this.bufOff = 0;
            MultiBlockCipher multiBlockCipher = this.mbCipher;
            if (multiBlockCipher != null) {
                int multiBlockSize = i12 / multiBlockCipher.getMultiBlockSize();
                if (multiBlockSize > 0) {
                    iProcessBlock += this.mbCipher.processBlocks(bArr4, i7, multiBlockSize, bArr2, i3 + iProcessBlock);
                    int multiBlockSize2 = multiBlockSize * this.mbCipher.getMultiBlockSize();
                    i12 -= multiBlockSize2;
                    i7 += multiBlockSize2;
                }
                i8 = i7;
            } else {
                i8 = i7;
                while (i12 > this.buf.length) {
                    iProcessBlock += this.cipher.processBlock(bArr4, i8, bArr2, i3 + iProcessBlock);
                    i12 -= blockSize;
                    i8 += blockSize;
                }
            }
            i4 = i12;
            i5 = i8;
            i6 = iProcessBlock;
            bArr = bArr4;
        } else {
            i4 = i2;
            i5 = i;
            i6 = 0;
        }
        System.arraycopy(bArr, i5, this.buf, this.bufOff, i4);
        int i13 = this.bufOff + i4;
        this.bufOff = i13;
        byte[] bArr5 = this.buf;
        if (i13 != bArr5.length) {
            return i6;
        }
        int iProcessBlock2 = i6 + this.cipher.processBlock(bArr5, 0, bArr2, i3 + i6);
        this.bufOff = 0;
        return iProcessBlock2;
    }

    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i >= bArr.length) {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }
}
