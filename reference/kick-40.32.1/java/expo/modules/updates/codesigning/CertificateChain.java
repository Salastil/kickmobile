package expo.modules.updates.codesigning;

import expo.modules.updates.UpdatesConfiguration;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: compiled from: CertificateChain.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/codesigning/CertificateChain;", "", "certificateStrings", "", "", "<init>", "(Ljava/util/List;)V", UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE, "Ljava/security/cert/X509Certificate;", "getCodeSigningCertificate", "()Ljava/security/cert/X509Certificate;", "codeSigningCertificate$delegate", "Lkotlin/Lazy;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CertificateChain {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> certificateStrings;

    /* JADX INFO: renamed from: codeSigningCertificate$delegate, reason: from kotlin metadata */
    private final Lazy codeSigningCertificate;

    public CertificateChain(List<String> certificateStrings) {
        Intrinsics.checkNotNullParameter(certificateStrings, "certificateStrings");
        this.certificateStrings = certificateStrings;
        this.codeSigningCertificate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.codesigning.CertificateChain$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CertificateChain.codeSigningCertificate_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final X509Certificate getCodeSigningCertificate() {
        return (X509Certificate) this.codeSigningCertificate.getValue();
    }

    static final X509Certificate codeSigningCertificate_delegate$lambda$0(CertificateChain certificateChain) throws CertificateException {
        if (certificateChain.certificateStrings.isEmpty()) {
            throw new CertificateException("No code signing certificates provided");
        }
        List<String> list = certificateChain.certificateStrings;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.constructCertificate((String) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        Companion companion = INSTANCE;
        companion.validateChain(arrayList2);
        X509Certificate x509Certificate = (X509Certificate) arrayList2.get(0);
        if (companion.isCodeSigningCertificate(x509Certificate)) {
            return x509Certificate;
        }
        throw new CertificateException("First certificate in chain is not a code signing certificate. Must have X509v3 Key Usage: Digital Signature and X509v3 Extended Key Usage: Code Signing");
    }

    /* JADX INFO: compiled from: CertificateChain.kt */
    /* JADX INFO: loaded from: classes10.dex */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\f\u0010\b\u001a\u00020\t*\u00020\u0005H\u0002J\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0005J\f\u0010\f\u001a\u00020\t*\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lexpo/modules/updates/codesigning/CertificateChain$Companion;", "", "<init>", "()V", "constructCertificate", "Ljava/security/cert/X509Certificate;", "certificateString", "", "isCodeSigningCertificate", "", "expoProjectInformation", "Lexpo/modules/updates/codesigning/ExpoProjectInformation;", "isCACertificate", "validateChain", "", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final X509Certificate constructCertificate(String certificateString) throws CertificateException {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bytes = certificateString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream(bytes));
            Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
            x509Certificate.checkValidity();
            return x509Certificate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCodeSigningCertificate(X509Certificate x509Certificate) {
            if (x509Certificate.getKeyUsage() != null) {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                Intrinsics.checkNotNullExpressionValue(keyUsage, "getKeyUsage(...)");
                if (!(keyUsage.length == 0) && x509Certificate.getKeyUsage()[0] && x509Certificate.getExtendedKeyUsage() != null && x509Certificate.getExtendedKeyUsage().contains("1.3.6.1.5.5.7.3.3")) {
                    return true;
                }
            }
            return false;
        }

        public final ExpoProjectInformation expoProjectInformation(X509Certificate x509Certificate) throws CertificateException {
            ASN1Primitive aSN1PrimitiveFromByteArray;
            String strDecodeToString;
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            byte[] extensionValue = x509Certificate.getExtensionValue("1.2.840.113556.1.8000.2554.43437.254.128.102.157.7894389.20439.2.1");
            if (extensionValue != null && (aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(extensionValue)) != null) {
                if (aSN1PrimitiveFromByteArray instanceof DEROctetString) {
                    byte[] octets = ((DEROctetString) aSN1PrimitiveFromByteArray).getOctets();
                    Intrinsics.checkNotNullExpressionValue(octets, "getOctets(...)");
                    strDecodeToString = StringsKt.decodeToString(octets);
                } else {
                    strDecodeToString = null;
                }
                if (strDecodeToString != null) {
                    List listSplit$default = StringsKt.split$default((CharSequence) strDecodeToString, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
                    }
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.size() != 2) {
                        throw new CertificateException("Invalid Expo project information extension value");
                    }
                    return new ExpoProjectInformation((String) arrayList2.get(0), (String) arrayList2.get(1));
                }
            }
            return null;
        }

        private final boolean isCACertificate(X509Certificate x509Certificate) {
            if (x509Certificate.getBasicConstraints() > -1 && x509Certificate.getKeyUsage() != null) {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                Intrinsics.checkNotNullExpressionValue(keyUsage, "getKeyUsage(...)");
                if (!(keyUsage.length == 0) && x509Certificate.getKeyUsage()[5]) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateChain(List<? extends X509Certificate> list) throws CertificateException {
            int size = list.size() - 1;
            int i = 0;
            while (i < size) {
                X509Certificate x509Certificate = list.get(i);
                i++;
                X509Certificate x509Certificate2 = list.get(i);
                if (!x509Certificate.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) {
                    throw new CertificateException("Certificates do not chain");
                }
                x509Certificate.verify(x509Certificate2.getPublicKey());
            }
            if (!((X509Certificate) CollectionsKt.last((List) list)).getIssuerX500Principal().equals(((X509Certificate) CollectionsKt.last((List) list)).getSubjectX500Principal())) {
                throw new CertificateException("Root certificate not self-signed");
            }
            ((X509Certificate) CollectionsKt.last((List) list)).verify(((X509Certificate) CollectionsKt.last((List) list)).getPublicKey());
            if (list.size() > 1) {
                X509Certificate x509Certificate3 = (X509Certificate) CollectionsKt.last((List) list);
                if (!isCACertificate(x509Certificate3)) {
                    throw new CertificateException("Root certificate subject must be a Certificate Authority");
                }
                ExpoProjectInformation expoProjectInformation = expoProjectInformation(x509Certificate3);
                int basicConstraints = x509Certificate3.getBasicConstraints();
                int size2 = list.size() - 2;
                while (size2 > 0) {
                    X509Certificate x509Certificate4 = list.get(size2);
                    if (!isCACertificate(x509Certificate4)) {
                        throw new CertificateException("Non-leaf certificate subject must be a Certificate Authority");
                    }
                    ExpoProjectInformation expoProjectInformation2 = expoProjectInformation(x509Certificate4);
                    if (expoProjectInformation != null && !Intrinsics.areEqual(expoProjectInformation, expoProjectInformation2)) {
                        throw new CertificateException("Expo project information must be a subset or equal of that of parent certificates");
                    }
                    if (basicConstraints <= 0) {
                        throw new CertificateException("pathLenConstraint violated by intermediate certificate");
                    }
                    basicConstraints = Math.min(x509Certificate4.getBasicConstraints(), basicConstraints - 1);
                    size2--;
                    expoProjectInformation = expoProjectInformation2;
                }
                if (expoProjectInformation != null && !Intrinsics.areEqual(expoProjectInformation, expoProjectInformation((X509Certificate) CollectionsKt.first((List) list)))) {
                    throw new CertificateException("Expo project information must be a subset of or equal to that of parent certificates");
                }
            }
        }
    }
}
