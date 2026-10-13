package io.datazoom.sdk.ad;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: DzAdEventType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b#\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lio/datazoom/sdk/ad/DzAdEventType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_ADS_COMPLETED", "AD_BREAK_FETCH_ERROR", "CLICKED", "COMPLETED", "CUEPOINTS_CHANGED", "CONTENT_PAUSE_REQUESTED", "CONTENT_RESUME_REQUESTED", "FIRST_QUARTILE", "LOG", "AD_BREAK_READY", "MIDPOINT", "PAUSED", "RESUMED", "IMPRESSION", "MUTED", "UNMUTED", "FULLSCREEN", "EXIT_FULLSCREEN", "SKIPPABLE_STATE_CHANGED", "SKIPPED", "STARTED", "TAPPED", "ICON_TAPPED", "ICON_FALLBACK_IMAGE_CLOSED", "THIRD_QUARTILE", "LOADED", "AD_PROGRESS", "AD_BUFFERING", "AD_BREAK_STARTED", "AD_BREAK_ENDED", "AD_PERIOD_STARTED", "AD_PERIOD_ENDED", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum DzAdEventType {
    ALL_ADS_COMPLETED,
    AD_BREAK_FETCH_ERROR,
    CLICKED,
    COMPLETED,
    CUEPOINTS_CHANGED,
    CONTENT_PAUSE_REQUESTED,
    CONTENT_RESUME_REQUESTED,
    FIRST_QUARTILE,
    LOG,
    AD_BREAK_READY,
    MIDPOINT,
    PAUSED,
    RESUMED,
    IMPRESSION,
    MUTED,
    UNMUTED,
    FULLSCREEN,
    EXIT_FULLSCREEN,
    SKIPPABLE_STATE_CHANGED,
    SKIPPED,
    STARTED,
    TAPPED,
    ICON_TAPPED,
    ICON_FALLBACK_IMAGE_CLOSED,
    THIRD_QUARTILE,
    LOADED,
    AD_PROGRESS,
    AD_BUFFERING,
    AD_BREAK_STARTED,
    AD_BREAK_ENDED,
    AD_PERIOD_STARTED,
    AD_PERIOD_ENDED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<DzAdEventType> getEntries() {
        return $ENTRIES;
    }
}
