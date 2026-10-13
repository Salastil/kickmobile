package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes11.dex */
class PK {
    final byte[] root;
    final byte[] seed;

    PK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.root = bArr2;
    }
}
