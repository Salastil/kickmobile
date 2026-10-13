package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

/* JADX INFO: loaded from: classes10.dex */
public class PKIXCertPathValidatorSpi_8 extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi_8() {
        this(false);
    }

    public PKIXCertPathValidatorSpi_8(boolean z) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (!(x509Certificate instanceof BCX509Certificate)) {
            try {
                TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
                return;
            } catch (IllegalArgumentException e) {
                throw new AnnotatedException(e.getMessage());
            } catch (CertificateEncodingException e2) {
                throw new AnnotatedException("unable to process TBSCertificate", e2);
            }
        }
        try {
            if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() != null) {
                return;
            }
            e = null;
            throw new AnnotatedException("unable to process TBSCertificate", e);
        } catch (RuntimeException e3) {
            e = e3;
        }
    }

    @Override // java.security.cert.CertPathValidatorSpi
    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new ProvRevocationChecker(this.helper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters baseParameters;
        X500Name ca;
        PublicKey cAPublicKey;
        HashSet hashSet;
        HashSet hashSet2;
        ArrayList arrayList;
        PKIXPolicyNode pKIXPolicyNodePrepareCertB;
        int iPrepareNextCertI2;
        int iPrepareNextCertJ;
        HashSet hashSet3;
        ArrayList arrayList2;
        X500Name subjectPrincipal;
        CertPath certPath2 = certPath;
        if (certPathParameters instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            baseParameters = builder.build();
        } else if (certPathParameters instanceof PKIXExtendedBuilderParameters) {
            baseParameters = ((PKIXExtendedBuilderParameters) certPathParameters).getBaseParameters();
        } else {
            if (!(certPathParameters instanceof PKIXExtendedParameters)) {
                throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
            }
            baseParameters = (PKIXExtendedParameters) certPathParameters;
        }
        if (baseParameters.getTrustAnchors() == null) {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        List<? extends Certificate> certificates = certPath2.getCertificates();
        int size = certificates.size();
        if (certificates.isEmpty()) {
            throw new CertPathValidatorException("Certification path is empty.", null, certPath2, -1);
        }
        Date validityDate = CertPathValidatorUtilities.getValidityDate(baseParameters, new Date());
        Set initialPolicies = baseParameters.getInitialPolicies();
        try {
            TrustAnchor trustAnchorFindTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), baseParameters.getTrustAnchors(), baseParameters.getSigProvider());
            if (trustAnchorFindTrustAnchor != null) {
                checkCertificate(trustAnchorFindTrustAnchor.getTrustedCert());
                PKIXExtendedParameters pKIXExtendedParametersBuild = new PKIXExtendedParameters.Builder(baseParameters).setTrustAnchor(trustAnchorFindTrustAnchor).build();
                ArrayList arrayList3 = new ArrayList();
                PKIXCertRevocationChecker provRevocationChecker = null;
                for (PKIXCertPathChecker pKIXCertPathChecker : pKIXExtendedParametersBuild.getCertPathCheckers()) {
                    pKIXCertPathChecker.init(false);
                    if (!(pKIXCertPathChecker instanceof PKIXRevocationChecker)) {
                        arrayList3.add(pKIXCertPathChecker);
                    } else {
                        if (provRevocationChecker != null) {
                            throw new CertPathValidatorException("only one PKIXRevocationChecker allowed");
                        }
                        provRevocationChecker = pKIXCertPathChecker instanceof PKIXCertRevocationChecker ? (PKIXCertRevocationChecker) pKIXCertPathChecker : new WrappedRevocationChecker(pKIXCertPathChecker);
                    }
                }
                if (pKIXExtendedParametersBuild.isRevocationEnabled() && provRevocationChecker == null) {
                    provRevocationChecker = new ProvRevocationChecker(this.helper);
                }
                int i = size + 1;
                ArrayList[] arrayListArr = new ArrayList[i];
                for (int i2 = 0; i2 < i; i2++) {
                    arrayListArr[i2] = new ArrayList();
                }
                HashSet hashSet4 = new HashSet();
                int i3 = 1;
                hashSet4.add(RFC3280CertPathUtilities.ANY_POLICY);
                PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet4, null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                arrayListArr[0].add(pKIXPolicyNode);
                PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                HashSet hashSet5 = new HashSet();
                int i4 = pKIXExtendedParametersBuild.isExplicitPolicyRequired() ? 0 : i;
                int i5 = pKIXExtendedParametersBuild.isAnyPolicyInhibited() ? 0 : i;
                if (pKIXExtendedParametersBuild.isPolicyMappingInhibited()) {
                    i = 0;
                }
                X509Certificate trustedCert = trustAnchorFindTrustAnchor.getTrustedCert();
                try {
                    if (trustedCert != null) {
                        ca = PrincipalUtils.getSubjectPrincipal(trustedCert);
                        cAPublicKey = trustedCert.getPublicKey();
                    } else {
                        ca = PrincipalUtils.getCA(trustAnchorFindTrustAnchor);
                        cAPublicKey = trustAnchorFindTrustAnchor.getCAPublicKey();
                    }
                    try {
                        AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(cAPublicKey);
                        algorithmIdentifier.getAlgorithm();
                        algorithmIdentifier.getParameters();
                        if (pKIXExtendedParametersBuild.getTargetConstraints() != null && !pKIXExtendedParametersBuild.getTargetConstraints().match((Certificate) certificates.get(0))) {
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath2, 0);
                        }
                        int i6 = i4;
                        PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                        int iPrepareNextCertI1 = i6;
                        PublicKey publicKey = cAPublicKey;
                        ArrayList arrayList4 = arrayList3;
                        int size2 = certificates.size() - 1;
                        int i7 = i;
                        PublicKey publicKey2 = publicKey;
                        X509Certificate x509Certificate = null;
                        int iPrepareNextCertM = size;
                        while (size2 >= 0) {
                            int i8 = size - size2;
                            List<? extends Certificate> list = certificates;
                            X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                            boolean z = size2 == list.size() + (-1) ? i3 : 0;
                            try {
                                checkCertificate(x509Certificate2);
                                X509Certificate x509Certificate3 = trustedCert;
                                ArrayList[] arrayListArr2 = arrayListArr;
                                X500Name x500Name = ca;
                                int i9 = iPrepareNextCertM;
                                TrustAnchor trustAnchor = trustAnchorFindTrustAnchor;
                                int i10 = iPrepareNextCertI1;
                                certPath2 = certPath;
                                RFC3280CertPathUtilities.processCertA(certPath2, pKIXExtendedParametersBuild, validityDate, provRevocationChecker, size2, publicKey2, z, x500Name, x509Certificate3);
                                PKIXExtendedParameters pKIXExtendedParameters = pKIXExtendedParametersBuild;
                                PKIXCertRevocationChecker pKIXCertRevocationChecker = provRevocationChecker;
                                int i11 = size2;
                                Date date = validityDate;
                                PublicKey publicKey3 = publicKey2;
                                RFC3280CertPathUtilities.processCertBC(certPath2, i11, pKIXNameConstraintValidator, this.isForCRLCheck);
                                HashSet hashSet6 = hashSet5;
                                int i12 = i5;
                                PKIXPolicyNode pKIXPolicyNodeProcessCertE = RFC3280CertPathUtilities.processCertE(certPath2, i11, RFC3280CertPathUtilities.processCertD(certPath2, i11, hashSet6, pKIXPolicyNode2, arrayListArr2, i12, this.isForCRLCheck));
                                RFC3280CertPathUtilities.processCertF(certPath2, i11, pKIXPolicyNodeProcessCertE, i10);
                                if (i8 != size) {
                                    try {
                                        if (x509Certificate2 != null) {
                                            hashSet2 = hashSet6;
                                            int i13 = i3;
                                            if (x509Certificate2.getVersion() == i13) {
                                                if (i8 != i13 || !x509Certificate2.equals(trustAnchor.getTrustedCert())) {
                                                    throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath2, i11);
                                                }
                                            }
                                            hashSet5 = hashSet2;
                                            arrayList4 = arrayList;
                                            validityDate = date;
                                            x509Certificate = x509Certificate2;
                                            trustAnchorFindTrustAnchor = trustAnchor;
                                            certificates = list;
                                            provRevocationChecker = pKIXCertRevocationChecker;
                                            i3 = 1;
                                            arrayListArr = arrayListArr2;
                                            size2 = i11 - 1;
                                            pKIXExtendedParametersBuild = pKIXExtendedParameters;
                                        } else {
                                            hashSet2 = hashSet6;
                                        }
                                        PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath2.getCertificates(), i11, this.helper);
                                        AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                        algorithmIdentifier2.getAlgorithm();
                                        algorithmIdentifier2.getParameters();
                                        i5 = iPrepareNextCertJ;
                                        trustedCert = x509Certificate2;
                                        ca = subjectPrincipal;
                                        pKIXPolicyNode2 = pKIXPolicyNodePrepareCertB;
                                        publicKey2 = nextWorkingKey;
                                        i7 = iPrepareNextCertI2;
                                        arrayList = arrayList2;
                                        hashSet5 = hashSet2;
                                        arrayList4 = arrayList;
                                        validityDate = date;
                                        x509Certificate = x509Certificate2;
                                        trustAnchorFindTrustAnchor = trustAnchor;
                                        certificates = list;
                                        provRevocationChecker = pKIXCertRevocationChecker;
                                        i3 = 1;
                                        arrayListArr = arrayListArr2;
                                        size2 = i11 - 1;
                                        pKIXExtendedParametersBuild = pKIXExtendedParameters;
                                    } catch (CertPathValidatorException e) {
                                        throw new CertPathValidatorException("Next working key could not be retrieved.", e, certPath2, i11);
                                    }
                                    RFC3280CertPathUtilities.prepareNextCertA(certPath2, i11);
                                    pKIXPolicyNodePrepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i11, arrayListArr2, pKIXPolicyNodeProcessCertE, i7);
                                    RFC3280CertPathUtilities.prepareNextCertG(certPath2, i11, pKIXNameConstraintValidator);
                                    int iPrepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i11, i10);
                                    int iPrepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i11, i7);
                                    int iPrepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i11, i12);
                                    iPrepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i11, iPrepareNextCertH1);
                                    iPrepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i11, iPrepareNextCertH2);
                                    iPrepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i11, iPrepareNextCertH3);
                                    RFC3280CertPathUtilities.prepareNextCertK(certPath2, i11);
                                    iPrepareNextCertM = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i11, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i11, i9));
                                    RFC3280CertPathUtilities.prepareNextCertN(certPath2, i11);
                                    Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs != null) {
                                        hashSet3 = new HashSet(criticalExtensionOIDs);
                                        hashSet3.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet3.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet3.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet3.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet3.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet3.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet3.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet3.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet3.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet3.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    } else {
                                        hashSet3 = new HashSet();
                                    }
                                    arrayList2 = arrayList4;
                                    RFC3280CertPathUtilities.prepareNextCertO(certPath2, i11, hashSet3, arrayList2);
                                    subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                } else {
                                    hashSet2 = hashSet6;
                                }
                                iPrepareNextCertM = i9;
                                arrayList = arrayList4;
                                pKIXPolicyNode2 = pKIXPolicyNodeProcessCertE;
                                i5 = i12;
                                publicKey2 = publicKey3;
                                iPrepareNextCertI1 = i10;
                                ca = x500Name;
                                trustedCert = x509Certificate3;
                                hashSet5 = hashSet2;
                                arrayList4 = arrayList;
                                validityDate = date;
                                x509Certificate = x509Certificate2;
                                trustAnchorFindTrustAnchor = trustAnchor;
                                certificates = list;
                                provRevocationChecker = pKIXCertRevocationChecker;
                                i3 = 1;
                                arrayListArr = arrayListArr2;
                                size2 = i11 - 1;
                                pKIXExtendedParametersBuild = pKIXExtendedParameters;
                            } catch (AnnotatedException e2) {
                                throw new CertPathValidatorException(e2.getMessage(), e2.getUnderlyingException(), certPath, size2);
                            }
                        }
                        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParametersBuild;
                        int i14 = size2;
                        ArrayList[] arrayListArr3 = arrayListArr;
                        TrustAnchor trustAnchor2 = trustAnchorFindTrustAnchor;
                        HashSet hashSet7 = hashSet5;
                        ArrayList arrayList5 = arrayList4;
                        int i15 = iPrepareNextCertI1;
                        PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNode2;
                        int i16 = i14 + 1;
                        int iWrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i16, RFC3280CertPathUtilities.wrapupCertA(i15, x509Certificate));
                        Set<String> criticalExtensionOIDs2 = x509Certificate.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                            hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                            hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                            hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                            hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                            hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                            hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                            hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                            hashSet.remove(Extension.extendedKeyUsage.getId());
                        } else {
                            hashSet = new HashSet();
                        }
                        RFC3280CertPathUtilities.wrapupCertF(certPath2, i16, arrayList5, hashSet);
                        PKIXPolicyNode pKIXPolicyNodeWrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath2, pKIXExtendedParameters2, initialPolicies, i16, arrayListArr3, pKIXPolicyNode3, hashSet7);
                        if (iWrapupCertB > 0 || pKIXPolicyNodeWrapupCertG != null) {
                            return new PKIXCertPathValidatorResult(trustAnchor2, pKIXPolicyNodeWrapupCertG, x509Certificate.getPublicKey());
                        }
                        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath2, i14);
                    } catch (CertPathValidatorException e3) {
                        throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e3, certPath2, -1);
                    }
                } catch (RuntimeException e4) {
                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e4, certPath2, -1);
                }
            }
            try {
                throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath2, -1);
            } catch (AnnotatedException e5) {
                e = e5;
            }
        } catch (AnnotatedException e6) {
            e = e6;
        }
        throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, certificates.size() - 1);
    }
}
