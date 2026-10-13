package org.bouncycastle.asn1.cms;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

/* JADX INFO: loaded from: classes10.dex */
public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256;
    public static final ASN1ObjectIdentifier id_alg;
    public static final ASN1ObjectIdentifier id_alg_cek_hkdf_sha256;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;
    public static final ASN1ObjectIdentifier id_ori;
    public static final ASN1ObjectIdentifier id_ori_kem;
    public static final ASN1ObjectIdentifier id_ri;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response;
    public static final ASN1ObjectIdentifier id_ri_scvp;
    public static final ASN1ObjectIdentifier data = PKCSObjectIdentifiers.data;
    public static final ASN1ObjectIdentifier signedData = PKCSObjectIdentifiers.signedData;
    public static final ASN1ObjectIdentifier envelopedData = PKCSObjectIdentifiers.envelopedData;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier digestedData = PKCSObjectIdentifiers.digestedData;
    public static final ASN1ObjectIdentifier encryptedData = PKCSObjectIdentifiers.encryptedData;
    public static final ASN1ObjectIdentifier authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    public static final ASN1ObjectIdentifier compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    public static final ASN1ObjectIdentifier authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    public static final ASN1ObjectIdentifier timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
    public static final ASN1ObjectIdentifier zlibCompress = PKCSObjectIdentifiers.id_alg_zlibCompress;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = X509ObjectIdentifiers.id_pkix.branch("16");
        id_ri = aSN1ObjectIdentifierBranch;
        id_ri_ocsp_response = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_ri_scvp = aSN1ObjectIdentifierBranch.branch("4");
        id_alg = X509ObjectIdentifiers.pkix_algorithms;
        id_RSASSA_PSS_SHAKE128 = X509ObjectIdentifiers.id_rsassa_pss_shake128;
        id_RSASSA_PSS_SHAKE256 = X509ObjectIdentifiers.id_rsassa_pss_shake256;
        id_ecdsa_with_shake128 = X509ObjectIdentifiers.id_ecdsa_with_shake128;
        id_ecdsa_with_shake256 = X509ObjectIdentifiers.id_ecdsa_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch2 = PKCSObjectIdentifiers.id_smime.branch("13");
        id_ori = aSN1ObjectIdentifierBranch2;
        id_ori_kem = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_alg_cek_hkdf_sha256 = PKCSObjectIdentifiers.smime_alg.branch("31");
    }
}
