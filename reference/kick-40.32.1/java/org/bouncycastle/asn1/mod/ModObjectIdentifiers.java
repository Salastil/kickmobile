package org.bouncycastle.asn1.mod;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes10.dex */
public interface ModObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_mod;
    public static final ASN1ObjectIdentifier id_mod_algorithmInformation_02;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.0");
        id_mod = aSN1ObjectIdentifier;
        id_mod_algorithmInformation_02 = aSN1ObjectIdentifier.branch("58");
    }
}
