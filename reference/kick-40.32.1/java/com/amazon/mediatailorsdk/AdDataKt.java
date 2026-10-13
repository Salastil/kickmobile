package com.amazon.mediatailorsdk;

import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import com.amazon.mediatailorsdk.utils.DateTimeKt;
import com.amazon.mediatailorsdk.utils.DateTime_androidKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001ae\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001aI\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"tag", "", "createAdData", "Lcom/amazon/mediatailorsdk/AdData;", "adStart", "", "availId", "availAdIndex", "", "availAdCount", "availStart", "availDuration", "availMarkedDuration", "adBreakTrackingEvents", "", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "adRawData", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "(DLjava/lang/String;IILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;)Lcom/amazon/mediatailorsdk/AdData;", "createNonLinearAdsData", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "adStartDate", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "nonlinearAvail", "", "(DDLjava/lang/String;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;Z)Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AdDataKt {
    private static final String tag = "adData: ";

    /* JADX WARN: Code duplicated, block: B:113:0x021c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fd  */
    public static final AdData createAdData(double d, String availId, int i, int i2, Double d2, Double d3, Double d4, AdBreakTrackingEvent[] adBreakTrackingEventArr, AdTrackingResponse.Ad adRawData) {
        ArrayList arrayList;
        String str;
        int i3;
        String type;
        ArrayList<AdData.Icon> arrayListAdChoicesFromExtension;
        ArrayList arrayList2;
        int i4;
        int i5;
        AdData.TrackingEvent trackingEvent;
        boolean z;
        Intrinsics.checkNotNullParameter(availId, "availId");
        Intrinsics.checkNotNullParameter(adRawData, "adRawData");
        Double durationInSeconds = adRawData.getDurationInSeconds();
        double dDoubleValue = durationInSeconds != null ? durationInSeconds.doubleValue() : 0.0d;
        if (dDoubleValue <= 0.0d) {
            Logger_androidKt.getLogger().w(tag + "Invalid or missing ad duration");
            return null;
        }
        Double dIsoDateTimeStringToEpochSeconds = DateTime_androidKt.isoDateTimeStringToEpochSeconds(adRawData.getAdProgramDateTime());
        Double dIsoTimeStringToSeconds = DateTimeKt.isoTimeStringToSeconds(adRawData.getSkipOffset());
        double[] dArr = {0.0d, 0.0d, 0.0d, 0.0d};
        AdData.TrackingEvent[] trackingEvents = adRawData.getTrackingEvents();
        if (trackingEvents != null) {
            ArrayList arrayList3 = new ArrayList();
            int length = trackingEvents.length;
            str = null;
            int i6 = 0;
            while (i6 < length) {
                AdData.TrackingEvent trackingEvent2 = trackingEvents[i6];
                if (Intrinsics.areEqual(trackingEvent2.getEventType(), AdBeaconType.CLICK_THROUGH.getType())) {
                    String[] beaconUrls = trackingEvent2.getBeaconUrls();
                    if (beaconUrls != null) {
                        if (!(beaconUrls.length == 0)) {
                            str = beaconUrls[0];
                        }
                    }
                    arrayList2 = arrayList3;
                    i4 = length;
                    i5 = i6;
                    trackingEvent = trackingEvent2;
                    z = false;
                } else {
                    String eventType = trackingEvent2.getEventType();
                    if (Intrinsics.areEqual(eventType, AdBeaconType.FIRST_QUARTILE.getType())) {
                        trackingEvent = trackingEvent2;
                        i4 = length;
                        i5 = i6;
                        arrayList2 = arrayList3;
                        createAdData$setQuartileEventOffset(d, dDoubleValue, dArr, 0, trackingEvent.getStartTimeInSeconds());
                    } else {
                        arrayList2 = arrayList3;
                        i4 = length;
                        i5 = i6;
                        if (Intrinsics.areEqual(eventType, AdBeaconType.MID_POINT.getType())) {
                            trackingEvent = trackingEvent2;
                            createAdData$setQuartileEventOffset(d, dDoubleValue, dArr, 1, trackingEvent2.getStartTimeInSeconds());
                        } else if (Intrinsics.areEqual(eventType, AdBeaconType.THIRD_QUARTILE.getType())) {
                            trackingEvent = trackingEvent2;
                            createAdData$setQuartileEventOffset(d, dDoubleValue, dArr, 2, trackingEvent2.getStartTimeInSeconds());
                        } else if (Intrinsics.areEqual(eventType, AdBeaconType.COMPLETE.getType())) {
                            trackingEvent = trackingEvent2;
                            createAdData$setQuartileEventOffset(d, dDoubleValue, dArr, 3, trackingEvent2.getStartTimeInSeconds());
                        } else {
                            trackingEvent = trackingEvent2;
                        }
                    }
                    z = true;
                }
                if (z) {
                    arrayList2.add(trackingEvent);
                }
                i6 = i5 + 1;
                arrayList3 = arrayList2;
                length = i4;
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
            str = null;
        }
        double d5 = dDoubleValue;
        AdData adData = new AdData(d, dIsoDateTimeStringToEpochSeconds != null ? dIsoDateTimeStringToEpochSeconds.doubleValue() : 0.0d, d5, dIsoTimeStringToSeconds != null ? dIsoTimeStringToSeconds.doubleValue() : -1.0d, 0, availId, i, i2, d2, d3, d4, d2 != null ? Double.valueOf(d - d2.doubleValue()) : null, str, ArraysKt.toTypedArray(dArr), adRawData.getAdId(), adRawData.getAdParameters(), adRawData.getAdSystem(), adRawData.getAdTitle(), adRawData.getAdVerifications(), adRawData.getIcons(), adRawData.getCompanionAds(), adRawData.getCreativeId(), adRawData.getCreativeSequence(), adRawData.getExtensions(), arrayList != null ? (AdData.TrackingEvent[]) arrayList.toArray(new AdData.TrackingEvent[0]) : null, adBreakTrackingEventArr, adRawData.getVastAdId());
        AdData.Extension[] extensions = adData.getExtensions();
        if (extensions != null) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (AdData.Extension extension : extensions) {
                if (extension.getType() != null && extension.getContent() != null && (type = extension.getType()) != null) {
                    int iHashCode = type.hashCode();
                    if (iHashCode != -2077435339) {
                        if (iHashCode != 1620218559) {
                            if (iHashCode == 2071420489 && type.equals("IconClickFallbackImages")) {
                                String content = extension.getContent();
                                Intrinsics.checkNotNull(content);
                                arrayListAdChoicesFromExtension = AdData_androidKt.adChoicesFromExtension(content);
                                if (arrayListAdChoicesFromExtension != null) {
                                    arrayList5.addAll(arrayListAdChoicesFromExtension);
                                }
                            }
                        } else if (type.equals("companion_about_this_ad")) {
                            String content2 = extension.getContent();
                            Intrinsics.checkNotNull(content2);
                            arrayListAdChoicesFromExtension = AdData_androidKt.adChoicesFromExtension(content2);
                            if (arrayListAdChoicesFromExtension != null) {
                                arrayList5.addAll(arrayListAdChoicesFromExtension);
                            }
                        }
                    } else if (type.equals("AdVerifications")) {
                        String content3 = extension.getContent();
                        Intrinsics.checkNotNull(content3);
                        AdData.AdVerification adVerificationAdVerificationFromExtension = AdData_androidKt.adVerificationFromExtension(content3);
                        if (adVerificationAdVerificationFromExtension != null) {
                            arrayList4.add(adVerificationAdVerificationFromExtension);
                        }
                    }
                }
            }
            ArrayList arrayList6 = arrayList4;
            if (arrayList6.isEmpty()) {
                i3 = 0;
            } else {
                AdData.AdVerification[] adVerifications = adData.getAdVerifications();
                if (adVerifications != null) {
                    i3 = 0;
                    arrayList4.addAll(0, ArraysKt.toList(adVerifications));
                } else {
                    i3 = 0;
                }
                adData.setAdVerifications$MediaTailor_release((AdData.AdVerification[]) arrayList6.toArray(new AdData.AdVerification[i3]));
            }
            ArrayList arrayList7 = arrayList5;
            if (!arrayList7.isEmpty()) {
                AdData.Icon[] icons = adData.getIcons();
                if (icons != null) {
                    arrayList5.addAll(i3, ArraysKt.toList(icons));
                }
                adData.setIcons$MediaTailor_release((AdData.Icon[]) arrayList7.toArray(new AdData.Icon[i3]));
            }
        }
        Logger_androidKt.getLogger().d(tag + "New AdData (" + d5 + "s @ " + d + "s / " + dIsoDateTimeStringToEpochSeconds + ")\n=> " + adData);
        return adData;
    }

    private static final void createAdData$setQuartileEventOffset(double d, double d2, double[] dArr, int i, Double d3) {
        if (d3 != null) {
            double dDoubleValue = d3.doubleValue() - d;
            if (dDoubleValue <= 0.0d || dDoubleValue >= d2 + 0.01d) {
                return;
            }
            dArr[i] = dDoubleValue;
        }
    }

    public static final NonLinearAdsData createNonLinearAdsData(double d, double d2, String str, AdBreakTrackingEvent[] adBreakTrackingEventArr, AdTrackingResponse.NonLinearAds adRawData, boolean z) {
        Intrinsics.checkNotNullParameter(adRawData, "adRawData");
        NonLinearAdsData.NonLinearAd[] nonLinearAdList = adRawData.getNonLinearAdList();
        if (nonLinearAdList == null || nonLinearAdList.length == 0) {
            Logger_androidKt.getLogger().w(tag + "Invalid or empty nonLinearAdList");
            return null;
        }
        NonLinearAdsData.NonLinearAd[] nonLinearAdList2 = adRawData.getNonLinearAdList();
        Intrinsics.checkNotNull(nonLinearAdList2);
        double dMax = 0.0d;
        for (NonLinearAdsData.NonLinearAd nonLinearAd : nonLinearAdList2) {
            Double durationInSeconds = nonLinearAd.getDurationInSeconds();
            double dDoubleValue = durationInSeconds != null ? durationInSeconds.doubleValue() : 0.0d;
            if (dDoubleValue <= 0.0d) {
                Double dIsoTimeStringToSeconds = DateTimeKt.isoTimeStringToSeconds(nonLinearAd.getMinSuggestedDuration());
                dDoubleValue = dIsoTimeStringToSeconds != null ? dIsoTimeStringToSeconds.doubleValue() : 0.0d;
            }
            dMax = Math.max(dMax, dDoubleValue);
        }
        if (dMax <= 0.0d) {
            dMax = 5.0d;
        }
        double d3 = dMax;
        NonLinearAdsData nonLinearAdsData = new NonLinearAdsData(d, d2, d3, str, z, adRawData.getNonLinearAdList(), adRawData.getExtensions(), adRawData.getTrackingEvents(), adBreakTrackingEventArr);
        Logger_androidKt.getLogger().d(tag + "New NonLinearAdsData (" + d3 + "s @ " + d + "s / " + d2 + "s)\n=> " + nonLinearAdsData);
        return nonLinearAdsData;
    }
}
