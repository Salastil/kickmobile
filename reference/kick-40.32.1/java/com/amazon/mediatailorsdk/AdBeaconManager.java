package com.amazon.mediatailorsdk;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: AdBeaconManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012d\u0010\u0004\u001a`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005j\u0002`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rl\u0010\u0004\u001a`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005j\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/amazon/mediatailorsdk/AdBeaconManager;", "Lcom/amazon/mediatailorsdk/AdObserver;", "disableNoninteractiveBeacons", "", "onAdBeaconResponse", "Lkotlin/Function4;", "Lcom/amazon/mediatailorsdk/AdData;", "Lkotlin/ParameterName;", "name", "adData", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "beaconInfo", "", "beaconUrl", "", "status", "", "Lcom/amazon/mediatailorsdk/OnAdBeaconResponseCallback;", "<init>", "(ZLkotlin/jvm/functions/Function4;)V", "currentTrackingEventMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendBeacon", "beacon", "onAdLoad", "onAdEnd", "onAdTrackingEvent", "adTrackingEvent", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdBeaconManager extends AdObserver {
    private HashMap<String, AdData.TrackingEvent> currentTrackingEventMap;
    private final boolean disableNoninteractiveBeacons;
    private final Function4<AdData, AdData.TrackingEvent, String, Integer, Unit> onAdBeaconResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public AdBeaconManager(boolean z, Function4<? super AdData, ? super AdData.TrackingEvent, ? super String, ? super Integer, Unit> onAdBeaconResponse) {
        Intrinsics.checkNotNullParameter(onAdBeaconResponse, "onAdBeaconResponse");
        this.disableNoninteractiveBeacons = z;
        this.onAdBeaconResponse = onAdBeaconResponse;
    }

    private final void sendBeacon(AdData adData, AdData.TrackingEvent beacon) {
        String[] beaconUrls;
        if (beacon == null || (beaconUrls = beacon.getBeaconUrls()) == null) {
            return;
        }
        for (String str : beaconUrls) {
            if (!StringsKt.isBlank(str)) {
                BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new AdBeaconManager$sendBeacon$1$1(str, this, adData, beacon, null), 3, null);
            }
        }
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdLoad(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.currentTrackingEventMap = new HashMap<>();
        AdData.TrackingEvent[] trackingEvents = adData.getTrackingEvents();
        if (trackingEvents != null) {
            for (AdData.TrackingEvent trackingEvent : trackingEvents) {
                String eventType = trackingEvent.getEventType();
                if (eventType != null && !StringsKt.isBlank(eventType)) {
                    HashMap<String, AdData.TrackingEvent> map = this.currentTrackingEventMap;
                    Intrinsics.checkNotNull(map);
                    String eventType2 = trackingEvent.getEventType();
                    Intrinsics.checkNotNull(eventType2);
                    map.put(eventType2, trackingEvent);
                }
            }
        }
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdEnd(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.currentTrackingEventMap = null;
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdTrackingEvent(AdData adData, AdTrackingEvent adTrackingEvent) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        Intrinsics.checkNotNullParameter(adTrackingEvent, "adTrackingEvent");
        if (this.currentTrackingEventMap == null || adData.getPlayCount() != 1) {
            return;
        }
        for (AdBeaconType adBeaconType : adTrackingEvent.getBeacons()) {
            if (!this.disableNoninteractiveBeacons || !adBeaconType.getNoninteractive()) {
                HashMap<String, AdData.TrackingEvent> map = this.currentTrackingEventMap;
                Intrinsics.checkNotNull(map);
                sendBeacon(adData, map.get(adBeaconType.getType()));
            }
        }
    }
}
