package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B]\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/amazon/mediatailorsdk/SessionUiEventData;", "", "adObject", "Lcom/amazon/mediatailorsdk/AdObject;", "nonLinearAdsObject", "Lcom/amazon/mediatailorsdk/NonLinearAdsObject;", "adElapsedTime", "", "adCountdown", "Lcom/amazon/mediatailorsdk/AdCountdown;", "adClickthroughUrl", "", "timeToNextAd", "failedAdTrackingInfoRequest", "", "<init>", "(Lcom/amazon/mediatailorsdk/AdObject;Lcom/amazon/mediatailorsdk/NonLinearAdsObject;Ljava/lang/Double;Lcom/amazon/mediatailorsdk/AdCountdown;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getAdObject", "()Lcom/amazon/mediatailorsdk/AdObject;", "getNonLinearAdsObject", "()Lcom/amazon/mediatailorsdk/NonLinearAdsObject;", "getAdElapsedTime", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAdCountdown", "()Lcom/amazon/mediatailorsdk/AdCountdown;", "getAdClickthroughUrl", "()Ljava/lang/String;", "getTimeToNextAd", "getFailedAdTrackingInfoRequest", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionUiEventData {
    private final String adClickthroughUrl;
    private final AdCountdown adCountdown;
    private final Double adElapsedTime;
    private final AdObject adObject;
    private final Boolean failedAdTrackingInfoRequest;
    private final NonLinearAdsObject nonLinearAdsObject;
    private final Double timeToNextAd;

    public SessionUiEventData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public SessionUiEventData(AdObject adObject, NonLinearAdsObject nonLinearAdsObject, Double d, AdCountdown adCountdown, String str, Double d2, Boolean bool) {
        this.adObject = adObject;
        this.nonLinearAdsObject = nonLinearAdsObject;
        this.adElapsedTime = d;
        this.adCountdown = adCountdown;
        this.adClickthroughUrl = str;
        this.timeToNextAd = d2;
        this.failedAdTrackingInfoRequest = bool;
    }

    public /* synthetic */ SessionUiEventData(AdObject adObject, NonLinearAdsObject nonLinearAdsObject, Double d, AdCountdown adCountdown, String str, Double d2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : adObject, (i & 2) != 0 ? null : nonLinearAdsObject, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : adCountdown, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : d2, (i & 64) != 0 ? null : bool);
    }

    public final AdObject getAdObject() {
        return this.adObject;
    }

    public final NonLinearAdsObject getNonLinearAdsObject() {
        return this.nonLinearAdsObject;
    }

    public final Double getAdElapsedTime() {
        return this.adElapsedTime;
    }

    public final AdCountdown getAdCountdown() {
        return this.adCountdown;
    }

    public final String getAdClickthroughUrl() {
        return this.adClickthroughUrl;
    }

    public final Double getTimeToNextAd() {
        return this.timeToNextAd;
    }

    public final Boolean getFailedAdTrackingInfoRequest() {
        return this.failedAdTrackingInfoRequest;
    }
}
