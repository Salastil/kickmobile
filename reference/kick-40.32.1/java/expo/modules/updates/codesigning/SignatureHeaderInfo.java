package expo.modules.updates.codesigning;

import expo.modules.structuredheaders.ListElement;
import expo.modules.structuredheaders.Parser;
import expo.modules.structuredheaders.StringItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignatureHeaderInfo.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lexpo/modules/updates/codesigning/SignatureHeaderInfo;", "", "signature", "", "keyId", "algorithm", "Lexpo/modules/updates/codesigning/CodeSigningAlgorithm;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/updates/codesigning/CodeSigningAlgorithm;)V", "getSignature", "()Ljava/lang/String;", "getKeyId", "getAlgorithm", "()Lexpo/modules/updates/codesigning/CodeSigningAlgorithm;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SignatureHeaderInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CodeSigningAlgorithm algorithm;
    private final String keyId;
    private final String signature;

    public static /* synthetic */ SignatureHeaderInfo copy$default(SignatureHeaderInfo signatureHeaderInfo, String str, String str2, CodeSigningAlgorithm codeSigningAlgorithm, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signatureHeaderInfo.signature;
        }
        if ((i & 2) != 0) {
            str2 = signatureHeaderInfo.keyId;
        }
        if ((i & 4) != 0) {
            codeSigningAlgorithm = signatureHeaderInfo.algorithm;
        }
        return signatureHeaderInfo.copy(str, str2, codeSigningAlgorithm);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKeyId() {
        return this.keyId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CodeSigningAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public final SignatureHeaderInfo copy(String signature, String keyId, CodeSigningAlgorithm algorithm) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        return new SignatureHeaderInfo(signature, keyId, algorithm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureHeaderInfo)) {
            return false;
        }
        SignatureHeaderInfo signatureHeaderInfo = (SignatureHeaderInfo) other;
        return Intrinsics.areEqual(this.signature, signatureHeaderInfo.signature) && Intrinsics.areEqual(this.keyId, signatureHeaderInfo.keyId) && this.algorithm == signatureHeaderInfo.algorithm;
    }

    public int hashCode() {
        return (((this.signature.hashCode() * 31) + this.keyId.hashCode()) * 31) + this.algorithm.hashCode();
    }

    public String toString() {
        return "SignatureHeaderInfo(signature=" + this.signature + ", keyId=" + this.keyId + ", algorithm=" + this.algorithm + ")";
    }

    /* JADX INFO: compiled from: SignatureHeaderInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/codesigning/SignatureHeaderInfo$Companion;", "", "<init>", "()V", "parseSignatureHeader", "Lexpo/modules/updates/codesigning/SignatureHeaderInfo;", "signatureHeader", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignatureHeaderInfo parseSignatureHeader(String signatureHeader) throws Exception {
            String str;
            Intrinsics.checkNotNullParameter(signatureHeader, "signatureHeader");
            Map<String, ListElement<? extends Object>> map = new Parser(signatureHeader).parseDictionary().get();
            ListElement<? extends Object> listElement = map.get(SignatureHeaderInfoKt.CODE_SIGNING_SIGNATURE_STRUCTURED_FIELD_KEY_SIGNATURE);
            ListElement<? extends Object> listElement2 = map.get("keyid");
            ListElement<? extends Object> listElement3 = map.get("alg");
            if (listElement instanceof StringItem) {
                String str2 = ((StringItem) listElement).get();
                if (listElement2 instanceof StringItem) {
                    str = ((StringItem) listElement2).get();
                } else {
                    str = CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID;
                }
                String str3 = listElement3 instanceof StringItem ? ((StringItem) listElement3).get() : null;
                Intrinsics.checkNotNull(str2);
                Intrinsics.checkNotNull(str);
                return new SignatureHeaderInfo(str2, str, CodeSigningAlgorithm.INSTANCE.parseFromString(str3));
            }
            throw new Exception("Structured field sig not found in expo-signature header");
        }
    }

    public SignatureHeaderInfo(String signature, String keyId, CodeSigningAlgorithm algorithm) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        this.signature = signature;
        this.keyId = keyId;
        this.algorithm = algorithm;
    }

    public final CodeSigningAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final String getSignature() {
        return this.signature;
    }
}
