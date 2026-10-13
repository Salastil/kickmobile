package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdBeaconManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001av\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102d\u0010\u0011\u001a`\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001j\u0002`\u0012H\u0000*¾\u0001\u0010\u0000\"\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00012\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0001¨\u0006\u0013"}, d2 = {"OnAdBeaconResponseCallback", "Lkotlin/Function4;", "Lcom/amazon/mediatailorsdk/AdData;", "Lkotlin/ParameterName;", "name", "adData", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "beaconInfo", "", "beaconUrl", "", "status", "", "createAdBeaconManager", "Lcom/amazon/mediatailorsdk/AdBeaconManager;", "disableNoninteractiveBeacons", "", "onAdBeaconResponse", "Lcom/amazon/mediatailorsdk/OnAdBeaconResponseCallback;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AdBeaconManagerKt {
    public static final AdBeaconManager createAdBeaconManager(boolean z, Function4<? super AdData, ? super AdData.TrackingEvent, ? super String, ? super Integer, Unit> onAdBeaconResponse) {
        Intrinsics.checkNotNullParameter(onAdBeaconResponse, "onAdBeaconResponse");
        return new AdBeaconManager(z, onAdBeaconResponse);
    }
}
