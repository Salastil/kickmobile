package expo.modules.updates.codesigning;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodeSigningAlgorithm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lexpo/modules/updates/codesigning/CodeSigningAlgorithm;", "", "algorithmName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAlgorithmName", "()Ljava/lang/String;", "RSA_SHA256", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum CodeSigningAlgorithm {
    RSA_SHA256("rsa-v1_5-sha256");

    private final String algorithmName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<CodeSigningAlgorithm> getEntries() {
        return $ENTRIES;
    }

    CodeSigningAlgorithm(String str) {
        this.algorithmName = str;
    }

    public final String getAlgorithmName() {
        return this.algorithmName;
    }

    /* JADX INFO: compiled from: CodeSigningAlgorithm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/codesigning/CodeSigningAlgorithm$Companion;", "", "<init>", "()V", "parseFromString", "Lexpo/modules/updates/codesigning/CodeSigningAlgorithm;", "str", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeSigningAlgorithm parseFromString(String str) throws Exception {
            if (Intrinsics.areEqual(str, CodeSigningAlgorithm.RSA_SHA256.getAlgorithmName())) {
                return CodeSigningAlgorithm.RSA_SHA256;
            }
            if (str == null) {
                return CodeSigningAlgorithm.RSA_SHA256;
            }
            throw new Exception("Invalid code signing algorithm name: " + str);
        }
    }
}
