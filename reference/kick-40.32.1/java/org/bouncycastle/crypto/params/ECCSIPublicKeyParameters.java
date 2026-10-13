package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes10.dex */
public class ECCSIPublicKeyParameters extends AsymmetricKeyParameter {
    private final ECPoint pvt;

    public ECCSIPublicKeyParameters(ECPoint eCPoint) {
        super(false);
        this.pvt = eCPoint;
    }

    public final ECPoint getPVT() {
        return this.pvt;
    }
}
