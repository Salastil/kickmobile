package org.bouncycastle.asn1.x509;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.internal.asn1.misc.MiscObjectIdentifiers;

/* JADX INFO: loaded from: classes10.dex */
public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier attributeType;
    public static final ASN1ObjectIdentifier commonName;
    public static final ASN1ObjectIdentifier countryName;
    public static final ASN1ObjectIdentifier crlAccessMethod;
    public static final ASN1ObjectIdentifier id_PasswordBasedMac;
    public static final ASN1ObjectIdentifier id_SHA1;
    public static final ASN1ObjectIdentifier id_ad;
    public static final ASN1ObjectIdentifier id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_ad_ocsp;
    public static final ASN1ObjectIdentifier id_alg_noSignature;
    public static final ASN1ObjectIdentifier id_at_name;
    public static final ASN1ObjectIdentifier id_at_organizationIdentifier;
    public static final ASN1ObjectIdentifier id_at_telephoneNumber;
    public static final ASN1ObjectIdentifier id_ce;
    public static final ASN1ObjectIdentifier id_ea_rsa;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;
    public static final ASN1ObjectIdentifier id_pda;
    public static final ASN1ObjectIdentifier id_pe;
    public static final ASN1ObjectIdentifier id_pkix;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake128;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake256;
    public static final ASN1ObjectIdentifier localityName;
    public static final ASN1ObjectIdentifier ocspAccessMethod;
    public static final ASN1ObjectIdentifier organization;
    public static final ASN1ObjectIdentifier organizationalUnitName;
    public static final ASN1ObjectIdentifier pkix_algorithms;
    public static final ASN1ObjectIdentifier ripemd160;
    public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption;
    public static final ASN1ObjectIdentifier stateOrProvinceName;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern = new ASN1ObjectIdentifier("2.5.4").intern();
        attributeType = aSN1ObjectIdentifierIntern;
        commonName = aSN1ObjectIdentifierIntern.branch(ExifInterface.GPS_MEASUREMENT_3D).intern();
        countryName = aSN1ObjectIdentifierIntern.branch("6").intern();
        localityName = aSN1ObjectIdentifierIntern.branch("7").intern();
        stateOrProvinceName = aSN1ObjectIdentifierIntern.branch("8").intern();
        organization = aSN1ObjectIdentifierIntern.branch("10").intern();
        organizationalUnitName = aSN1ObjectIdentifierIntern.branch("11").intern();
        id_at_telephoneNumber = aSN1ObjectIdentifierIntern.branch("20").intern();
        id_at_name = aSN1ObjectIdentifierIntern.branch("41").intern();
        id_at_organizationIdentifier = aSN1ObjectIdentifierIntern.branch("97").intern();
        id_SHA1 = new ASN1ObjectIdentifier("1.3.14.3.2.26").intern();
        ripemd160 = new ASN1ObjectIdentifier("1.3.36.3.2.1").intern();
        ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2").intern();
        id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1").intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        id_pe = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = aSN1ObjectIdentifier.branch("6");
        pkix_algorithms = aSN1ObjectIdentifierBranch;
        id_rsassa_pss_shake128 = aSN1ObjectIdentifierBranch.branch("30");
        id_rsassa_pss_shake256 = aSN1ObjectIdentifierBranch.branch("31");
        id_ecdsa_with_shake128 = aSN1ObjectIdentifierBranch.branch("32");
        id_ecdsa_with_shake256 = aSN1ObjectIdentifierBranch.branch("33");
        id_alg_noSignature = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_pda = aSN1ObjectIdentifier.branch("9");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch2 = aSN1ObjectIdentifier.branch("48");
        id_ad = aSN1ObjectIdentifierBranch2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern2 = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_2D).intern();
        id_ad_caIssuers = aSN1ObjectIdentifierIntern2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierIntern3 = aSN1ObjectIdentifierBranch2.branch("1").intern();
        id_ad_ocsp = aSN1ObjectIdentifierIntern3;
        ocspAccessMethod = aSN1ObjectIdentifierIntern3;
        crlAccessMethod = aSN1ObjectIdentifierIntern2;
        id_ce = new ASN1ObjectIdentifier("2.5.29");
        id_PasswordBasedMac = MiscObjectIdentifiers.entrust.branch("66.13");
    }
}
