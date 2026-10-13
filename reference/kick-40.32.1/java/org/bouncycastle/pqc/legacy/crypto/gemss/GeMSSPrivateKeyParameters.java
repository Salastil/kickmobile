package org.bouncycastle.pqc.legacy.crypto.gemss;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class GeMSSPrivateKeyParameters extends GeMSSKeyParameters {
    final byte[] sk;

    public GeMSSPrivateKeyParameters(GeMSSParameters geMSSParameters, byte[] bArr) {
        super(false, geMSSParameters);
        byte[] bArr2 = new byte[bArr.length];
        this.sk = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.sk);
    }
}
