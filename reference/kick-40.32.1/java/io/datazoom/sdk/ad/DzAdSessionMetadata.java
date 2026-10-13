package io.datazoom.sdk.ad;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzAdSessionMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/datazoom/sdk/ad/DzAdSessionMetadata;", "", "adId", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "trackingData", "startTimeInSeconds", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getAdId", "()Ljava/lang/String;", "getSessionId", "getTrackingData", "getStartTimeInSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lio/datazoom/sdk/ad/DzAdSessionMetadata;", "equals", "", "other", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DzAdSessionMetadata {
    private final String adId;
    private final String sessionId;
    private final Double startTimeInSeconds;
    private final String trackingData;

    public static /* synthetic */ DzAdSessionMetadata copy$default(DzAdSessionMetadata dzAdSessionMetadata, String str, String str2, String str3, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dzAdSessionMetadata.adId;
        }
        if ((i & 2) != 0) {
            str2 = dzAdSessionMetadata.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = dzAdSessionMetadata.trackingData;
        }
        if ((i & 8) != 0) {
            d = dzAdSessionMetadata.startTimeInSeconds;
        }
        return dzAdSessionMetadata.copy(str, str2, str3, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTrackingData() {
        return this.trackingData;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getStartTimeInSeconds() {
        return this.startTimeInSeconds;
    }

    public final DzAdSessionMetadata copy(String adId, String sessionId, String trackingData, Double startTimeInSeconds) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(trackingData, "trackingData");
        return new DzAdSessionMetadata(adId, sessionId, trackingData, startTimeInSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DzAdSessionMetadata)) {
            return false;
        }
        DzAdSessionMetadata dzAdSessionMetadata = (DzAdSessionMetadata) other;
        return Intrinsics.areEqual(this.adId, dzAdSessionMetadata.adId) && Intrinsics.areEqual(this.sessionId, dzAdSessionMetadata.sessionId) && Intrinsics.areEqual(this.trackingData, dzAdSessionMetadata.trackingData) && Intrinsics.areEqual((Object) this.startTimeInSeconds, (Object) dzAdSessionMetadata.startTimeInSeconds);
    }

    public int hashCode() {
        int iHashCode = ((((this.adId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.trackingData.hashCode()) * 31;
        Double d = this.startTimeInSeconds;
        return iHashCode + (d == null ? 0 : d.hashCode());
    }

    public String toString() {
        return "DzAdSessionMetadata(adId=" + this.adId + ", sessionId=" + this.sessionId + ", trackingData=" + this.trackingData + ", startTimeInSeconds=" + this.startTimeInSeconds + ")";
    }

    public DzAdSessionMetadata(String adId, String sessionId, String trackingData, Double d) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(trackingData, "trackingData");
        this.adId = adId;
        this.sessionId = sessionId;
        this.trackingData = trackingData;
        this.startTimeInSeconds = d;
    }

    public /* synthetic */ DzAdSessionMetadata(String str, String str2, String str3, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : d);
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTrackingData() {
        return this.trackingData;
    }

    public final Double getStartTimeInSeconds() {
        return this.startTimeInSeconds;
    }
}
