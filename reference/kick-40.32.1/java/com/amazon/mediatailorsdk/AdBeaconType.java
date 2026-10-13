package com.amazon.mediatailorsdk;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaError;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CLOSE_LINEAR' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: AdBeaconManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/amazon/mediatailorsdk/AdBeaconType;", "", "type", "", "noninteractive", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "getNoninteractive", "()Z", "IMPRESSION", "CLICK_THROUGH", "CLICK_TRACKING", MediaError.ERROR_TYPE_ERROR, "MUTE", "UNMUTE", "PAUSE", "RESUME", "REWIND", "SKIP", "PLAYER_EXPAND", "PLAYER_COLLAPSE", "FULLSCREEN", "EXIT_FULLSCREEN", "NOT_USED", "LOADED", "START", "FIRST_QUARTILE", "MID_POINT", "THIRD_QUARTILE", "COMPLETE", "OTHER_AD_INTERACTION", "PROGRESS", "CLOSE_LINEAR", "CREATIVE_VIEW", "ACCEPT_INVITATION", "AD_EXPAND", "AD_COLLAPSE", "MINIMIZE", "CLOSE", "OVERLAY_VIEW_DURATION", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdBeaconType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdBeaconType[] $VALUES;
    public static final AdBeaconType AD_COLLAPSE;
    public static final AdBeaconType CLOSE_LINEAR;
    private final boolean noninteractive;
    private final String type;
    public static final AdBeaconType IMPRESSION = new AdBeaconType("IMPRESSION", 0, "impression", true);
    public static final AdBeaconType CLICK_THROUGH = new AdBeaconType("CLICK_THROUGH", 1, "clickThrough", false, 2, null);
    public static final AdBeaconType CLICK_TRACKING = new AdBeaconType("CLICK_TRACKING", 2, "clickTracking", false, 2, null);
    public static final AdBeaconType ERROR = new AdBeaconType(MediaError.ERROR_TYPE_ERROR, 3, "error", false, 2, null);
    public static final AdBeaconType MUTE = new AdBeaconType("MUTE", 4, "mute", false, 2, null);
    public static final AdBeaconType UNMUTE = new AdBeaconType("UNMUTE", 5, "unmute", false, 2, null);
    public static final AdBeaconType PAUSE = new AdBeaconType("PAUSE", 6, PauseEvent.TYPE, false, 2, null);
    public static final AdBeaconType RESUME = new AdBeaconType("RESUME", 7, "resume", false, 2, null);
    public static final AdBeaconType REWIND = new AdBeaconType("REWIND", 8, "rewind", false, 2, null);
    public static final AdBeaconType SKIP = new AdBeaconType("SKIP", 9, "skip", false, 2, null);
    public static final AdBeaconType PLAYER_EXPAND = new AdBeaconType("PLAYER_EXPAND", 10, "playerExpand", false, 2, null);
    public static final AdBeaconType PLAYER_COLLAPSE = new AdBeaconType("PLAYER_COLLAPSE", 11, "playerCollapse", false, 2, null);
    public static final AdBeaconType FULLSCREEN = new AdBeaconType("FULLSCREEN", 12, "fullscreen", false, 2, null);
    public static final AdBeaconType EXIT_FULLSCREEN = new AdBeaconType("EXIT_FULLSCREEN", 13, "exitFullscreen", false, 2, null);
    public static final AdBeaconType NOT_USED = new AdBeaconType("NOT_USED", 14, "notUsed", false, 2, null);
    public static final AdBeaconType LOADED = new AdBeaconType("LOADED", 15, "loaded", true);
    public static final AdBeaconType START = new AdBeaconType("START", 16, ViewProps.START, true);
    public static final AdBeaconType FIRST_QUARTILE = new AdBeaconType("FIRST_QUARTILE", 17, "firstQuartile", true);
    public static final AdBeaconType MID_POINT = new AdBeaconType("MID_POINT", 18, "midpoint", true);
    public static final AdBeaconType THIRD_QUARTILE = new AdBeaconType("THIRD_QUARTILE", 19, "thirdQuartile", true);
    public static final AdBeaconType COMPLETE = new AdBeaconType("COMPLETE", 20, "complete", true);
    public static final AdBeaconType OTHER_AD_INTERACTION = new AdBeaconType("OTHER_AD_INTERACTION", 21, "otherAdInteraction", false, 2, null);
    public static final AdBeaconType PROGRESS = new AdBeaconType("PROGRESS", 22, "progress", false, 2, null);
    public static final AdBeaconType CREATIVE_VIEW = new AdBeaconType("CREATIVE_VIEW", 24, "creativeView", true);
    public static final AdBeaconType ACCEPT_INVITATION = new AdBeaconType("ACCEPT_INVITATION", 25, "acceptInvitation", false, 2, null);
    public static final AdBeaconType AD_EXPAND = new AdBeaconType("AD_EXPAND", 26, "adExpand", false, 2, null);
    public static final AdBeaconType MINIMIZE = new AdBeaconType("MINIMIZE", 28, "minimize", false, 2, null);
    public static final AdBeaconType CLOSE = new AdBeaconType("CLOSE", 29, "close", false, 2, null);
    public static final AdBeaconType OVERLAY_VIEW_DURATION = new AdBeaconType("OVERLAY_VIEW_DURATION", 30, "overlayViewDuration", false, 2, null);

    private static final /* synthetic */ AdBeaconType[] $values() {
        return new AdBeaconType[]{IMPRESSION, CLICK_THROUGH, CLICK_TRACKING, ERROR, MUTE, UNMUTE, PAUSE, RESUME, REWIND, SKIP, PLAYER_EXPAND, PLAYER_COLLAPSE, FULLSCREEN, EXIT_FULLSCREEN, NOT_USED, LOADED, START, FIRST_QUARTILE, MID_POINT, THIRD_QUARTILE, COMPLETE, OTHER_AD_INTERACTION, PROGRESS, CLOSE_LINEAR, CREATIVE_VIEW, ACCEPT_INVITATION, AD_EXPAND, AD_COLLAPSE, MINIMIZE, CLOSE, OVERLAY_VIEW_DURATION};
    }

    public static EnumEntries<AdBeaconType> getEntries() {
        return $ENTRIES;
    }

    public static AdBeaconType valueOf(String str) {
        return (AdBeaconType) Enum.valueOf(AdBeaconType.class, str);
    }

    public static AdBeaconType[] values() {
        return (AdBeaconType[]) $VALUES.clone();
    }

    private AdBeaconType(String str, int i, String str2, boolean z) {
        super(str, i);
        this.type = str2;
        this.noninteractive = z;
    }

    /* synthetic */ AdBeaconType(String str, int i, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? false : z);
    }

    public final boolean getNoninteractive() {
        return this.noninteractive;
    }

    public final String getType() {
        return this.type;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        CLOSE_LINEAR = new AdBeaconType("CLOSE_LINEAR", 23, "closeLinear", false, 2, defaultConstructorMarker);
        AD_COLLAPSE = new AdBeaconType("AD_COLLAPSE", 27, "adCollapse", false, 2, defaultConstructorMarker);
        AdBeaconType[] adBeaconTypeArr$values = $values();
        $VALUES = adBeaconTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(adBeaconTypeArr$values);
    }
}
