package org.bouncycastle.asn1.x509.qualified;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

/* JADX INFO: loaded from: classes10.dex */
public interface RFC3739QCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_qcs;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v1;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v2;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = X509ObjectIdentifiers.id_pkix.branch("11");
        id_qcs = aSN1ObjectIdentifierBranch;
        id_qcs_pkixQCSyntax_v1 = aSN1ObjectIdentifierBranch.branch("1");
        id_qcs_pkixQCSyntax_v2 = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_2D);
    }
}
