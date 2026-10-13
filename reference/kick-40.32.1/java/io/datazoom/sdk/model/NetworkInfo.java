package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkInfo.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lio/datazoom/sdk/model/NetworkInfo;", "", "isMobileConnection", "", "userAgent", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getUserAgent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NetworkInfo {
    private final boolean isMobileConnection;
    private final String userAgent;

    public static /* synthetic */ NetworkInfo copy$default(NetworkInfo networkInfo, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = networkInfo.isMobileConnection;
        }
        if ((i & 2) != 0) {
            str = networkInfo.userAgent;
        }
        return networkInfo.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMobileConnection() {
        return this.isMobileConnection;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final NetworkInfo copy(boolean isMobileConnection, String userAgent) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        return new NetworkInfo(isMobileConnection, userAgent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkInfo)) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) other;
        return this.isMobileConnection == networkInfo.isMobileConnection && Intrinsics.areEqual(this.userAgent, networkInfo.userAgent);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isMobileConnection) * 31) + this.userAgent.hashCode();
    }

    public String toString() {
        return "NetworkInfo(isMobileConnection=" + this.isMobileConnection + ", userAgent=" + this.userAgent + ")";
    }

    public NetworkInfo(boolean z, String userAgent) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        this.isMobileConnection = z;
        this.userAgent = userAgent;
    }

    public final boolean isMobileConnection() {
        return this.isMobileConnection;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }
}
