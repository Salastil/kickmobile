package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001fH\u0016¨\u0006\""}, d2 = {"Lcom/amazon/mediatailorsdk/AdObserver;", "", "<init>", "()V", "onTrackingInfoResponse", "", "failed", "", "onNewAd", "adData", "Lcom/amazon/mediatailorsdk/AdData;", "isReplacement", "onAdLoad", "onAdStart", "adElapsedTime", "", "playhead", "onAdEnd", "onAdProgress", "onAdClick", "onAdTrackingEvent", "adTrackingEvent", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "onAdBeaconResponse", "beaconInfo", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "beaconUrl", "", "status", "", "onNewNonLinearAds", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "onNonLinearAdsStart", "onNonLinearAdsEnd", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AdObserver {
    public void onAdBeaconResponse(AdData adData, AdData.TrackingEvent beaconInfo, String beaconUrl, int status) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        Intrinsics.checkNotNullParameter(beaconInfo, "beaconInfo");
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
    }

    public void onAdClick(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onAdEnd(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onAdLoad(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onAdProgress(AdData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onAdStart(AdData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onAdTrackingEvent(AdData adData, AdTrackingEvent adTrackingEvent) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        Intrinsics.checkNotNullParameter(adTrackingEvent, "adTrackingEvent");
    }

    public void onNewAd(AdData adData, boolean isReplacement) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onNewNonLinearAds(NonLinearAdsData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onNonLinearAdsEnd(NonLinearAdsData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onNonLinearAdsStart(NonLinearAdsData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
    }

    public void onTrackingInfoResponse(boolean failed) {
    }
}
