package expo.modules.updates.loader;

import expo.modules.updates.UpdatesConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteUpdate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lexpo/modules/updates/loader/SigningInfo;", "", "easProjectId", "", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEasProjectId", "()Ljava/lang/String;", "getScopeKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SigningInfo {
    private final String easProjectId;
    private final String scopeKey;

    public static /* synthetic */ SigningInfo copy$default(SigningInfo signingInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signingInfo.easProjectId;
        }
        if ((i & 2) != 0) {
            str2 = signingInfo.scopeKey;
        }
        return signingInfo.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEasProjectId() {
        return this.easProjectId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final SigningInfo copy(String easProjectId, String scopeKey) {
        Intrinsics.checkNotNullParameter(easProjectId, "easProjectId");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        return new SigningInfo(easProjectId, scopeKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigningInfo)) {
            return false;
        }
        SigningInfo signingInfo = (SigningInfo) other;
        return Intrinsics.areEqual(this.easProjectId, signingInfo.easProjectId) && Intrinsics.areEqual(this.scopeKey, signingInfo.scopeKey);
    }

    public int hashCode() {
        return (this.easProjectId.hashCode() * 31) + this.scopeKey.hashCode();
    }

    public String toString() {
        return "SigningInfo(easProjectId=" + this.easProjectId + ", scopeKey=" + this.scopeKey + ")";
    }

    public SigningInfo(String easProjectId, String scopeKey) {
        Intrinsics.checkNotNullParameter(easProjectId, "easProjectId");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.easProjectId = easProjectId;
        this.scopeKey = scopeKey;
    }

    public final String getEasProjectId() {
        return this.easProjectId;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }
}
