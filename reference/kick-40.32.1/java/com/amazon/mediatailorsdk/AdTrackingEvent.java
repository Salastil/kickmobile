package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SessionTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "", "debugName", "", "beacons", "", "Lcom/amazon/mediatailorsdk/AdBeaconType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;[Lcom/amazon/mediatailorsdk/AdBeaconType;)V", "getDebugName", "()Ljava/lang/String;", "getBeacons", "()[Lcom/amazon/mediatailorsdk/AdBeaconType;", "[Lcom/amazon/mediatailorsdk/AdBeaconType;", "IMPRESSION", "CLICK_THROUGH", "LOADED", "START", "FIRST_QUARTILE", "MID_POINT", "THIRD_QUARTILE", "COMPLETE", "SKIP", "PAUSE", "RESUME", "MUTE", "UNMUTE", "FULLSCREEN", "EXIT_FULLSCREEN", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AdTrackingEvent {
    IMPRESSION("IMPRESSION", new AdBeaconType[]{AdBeaconType.IMPRESSION}),
    CLICK_THROUGH("CLICK_THROUGH", new AdBeaconType[]{AdBeaconType.CLICK_TRACKING}),
    LOADED("LOADED", new AdBeaconType[]{AdBeaconType.LOADED}),
    START("START", new AdBeaconType[]{AdBeaconType.START, AdBeaconType.CREATIVE_VIEW}),
    FIRST_QUARTILE("FIRST_QUARTILE", new AdBeaconType[]{AdBeaconType.FIRST_QUARTILE}),
    MID_POINT("MID_POINT", new AdBeaconType[]{AdBeaconType.MID_POINT}),
    THIRD_QUARTILE("THIRD_QUARTILE", new AdBeaconType[]{AdBeaconType.THIRD_QUARTILE}),
    COMPLETE("COMPLETE", new AdBeaconType[]{AdBeaconType.COMPLETE}),
    SKIP("SKIP", new AdBeaconType[]{AdBeaconType.SKIP}),
    PAUSE("PAUSE", new AdBeaconType[]{AdBeaconType.PAUSE}),
    RESUME("RESUME", new AdBeaconType[]{AdBeaconType.RESUME}),
    MUTE("MUTE", new AdBeaconType[]{AdBeaconType.MUTE}),
    UNMUTE("UNMUTE", new AdBeaconType[]{AdBeaconType.UNMUTE}),
    FULLSCREEN("FULLSCREEN", new AdBeaconType[]{AdBeaconType.FULLSCREEN, AdBeaconType.PLAYER_EXPAND}),
    EXIT_FULLSCREEN("EXIT_FULLSCREEN", new AdBeaconType[]{AdBeaconType.EXIT_FULLSCREEN, AdBeaconType.PLAYER_COLLAPSE});

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final AdBeaconType[] beacons;
    private final String debugName;

    public static EnumEntries<AdTrackingEvent> getEntries() {
        return $ENTRIES;
    }

    AdTrackingEvent(String str, AdBeaconType[] adBeaconTypeArr) {
        this.debugName = str;
        this.beacons = adBeaconTypeArr;
    }

    public final AdBeaconType[] getBeacons() {
        return this.beacons;
    }

    public final String getDebugName() {
        return this.debugName;
    }
}
