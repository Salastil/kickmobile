package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes10.dex */
abstract class AsconXofBase extends AsconBaseDigest implements Xof {
    private final byte[] buffer = new byte[this.BlockSize];
    private int bytesInBuffer;
    private boolean m_squeezing;

    AsconXofBase() {
    }

    private void ensureNoAbsorbWhileSqueezing(boolean z) {
        if (z) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public int doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        reset();
        return iDoOutput;
    }

    public int doOutput(byte[] bArr, int i, int i2) {
        int iHash;
        ensureSufficientOutputBuffer(bArr, i, i2);
        if (this.bytesInBuffer != 0) {
            int i3 = this.BlockSize;
            int i4 = this.bytesInBuffer;
            int i5 = i3 - i4;
            iHash = Math.min(i2, i4);
            System.arraycopy(this.buffer, i5, bArr, i, iHash);
            this.bytesInBuffer -= iHash;
        } else {
            iHash = 0;
        }
        int i6 = i2 - iHash;
        if (i6 >= this.BlockSize) {
            iHash += hash(bArr, i + iHash, i6 - (i6 % this.BlockSize));
        }
        if (iHash >= i2) {
            return iHash;
        }
        hash(this.buffer, 0, this.BlockSize);
        int i7 = i2 - iHash;
        System.arraycopy(this.buffer, 0, bArr, i + iHash, i7);
        this.bytesInBuffer = this.buffer.length - i7;
        return iHash + i7;
    }

    @Override // org.bouncycastle.crypto.digests.AsconBaseDigest
    protected void padAndAbsorb() {
        if (this.m_squeezing) {
            this.p.p(this.ASCON_PB_ROUNDS);
        } else {
            this.m_squeezing = true;
            super.padAndAbsorb();
        }
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        this.m_squeezing = false;
        this.bytesInBuffer = 0;
        super.reset();
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void update(byte b) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.update(b);
    }

    @Override // org.bouncycastle.crypto.digests.BufferBaseDigest, org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        ensureNoAbsorbWhileSqueezing(this.m_squeezing);
        super.update(bArr, i, i2);
    }
}
