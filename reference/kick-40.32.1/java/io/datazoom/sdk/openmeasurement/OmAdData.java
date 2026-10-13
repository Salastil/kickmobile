package io.datazoom.sdk.openmeasurement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionPayload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmAdData;", "", "adId", "", "adVerifications", "Lio/datazoom/sdk/openmeasurement/OmAdVerification;", "<init>", "(Ljava/lang/String;Lio/datazoom/sdk/openmeasurement/OmAdVerification;)V", "getAdId", "()Ljava/lang/String;", "getAdVerifications", "()Lio/datazoom/sdk/openmeasurement/OmAdVerification;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OmAdData {
    private final String adId;
    private final OmAdVerification adVerifications;

    public static /* synthetic */ OmAdData copy$default(OmAdData omAdData, String str, OmAdVerification omAdVerification, int i, Object obj) {
        if ((i & 1) != 0) {
            str = omAdData.adId;
        }
        if ((i & 2) != 0) {
            omAdVerification = omAdData.adVerifications;
        }
        return omAdData.copy(str, omAdVerification);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OmAdVerification getAdVerifications() {
        return this.adVerifications;
    }

    public final OmAdData copy(String adId, OmAdVerification adVerifications) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adVerifications, "adVerifications");
        return new OmAdData(adId, adVerifications);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OmAdData)) {
            return false;
        }
        OmAdData omAdData = (OmAdData) other;
        return Intrinsics.areEqual(this.adId, omAdData.adId) && Intrinsics.areEqual(this.adVerifications, omAdData.adVerifications);
    }

    public int hashCode() {
        return (this.adId.hashCode() * 31) + this.adVerifications.hashCode();
    }

    public String toString() {
        return "OmAdData(adId=" + this.adId + ", adVerifications=" + this.adVerifications + ')';
    }

    public OmAdData(String adId, OmAdVerification adVerifications) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adVerifications, "adVerifications");
        this.adId = adId;
        this.adVerifications = adVerifications;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final OmAdVerification getAdVerifications() {
        return this.adVerifications;
    }
}
