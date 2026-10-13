package org.bouncycastle.pqc.crypto.ntru;

/* JADX INFO: loaded from: classes11.dex */
class OWCPADecryptResult {
    final int fail;
    final byte[] rm;

    public OWCPADecryptResult(byte[] bArr, int i) {
        this.rm = bArr;
        this.fail = i;
    }
}
