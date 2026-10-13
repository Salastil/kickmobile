package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionUiEvent;", "", "key", "", "debugName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDebugName", "AD_START", "AD_END", "AD_PROGRESS", "AD_CLICK", "AD_CAN_SKIP", "AD_INCOMING", "NONLINEAR_AD_START", "NONLINEAR_AD_END", "AD_TRACKING_INFO_RESPONSE", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SessionUiEvent {
    AD_START("ad_start", null, 2, null),
    AD_END("ad_end", null, 2, null),
    AD_PROGRESS("ad_progress", null, 2, null),
    AD_CLICK("ad_click", null, 2, null),
    AD_CAN_SKIP("ad_can_skip", null, 2, null),
    AD_INCOMING("ad_incoming", null, 2, null),
    NONLINEAR_AD_START("nonlinear_ad_start", null, 2, null),
    NONLINEAR_AD_END("nonlinear_ad_end", null, 2, null),
    AD_TRACKING_INFO_RESPONSE("ad_tracking_info_response", null, 2, null);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String debugName;
    private final String key;

    public static EnumEntries<SessionUiEvent> getEntries() {
        return $ENTRIES;
    }

    SessionUiEvent(String str, String str2) {
        this.key = str;
        this.debugName = str2;
    }

    /* synthetic */ SessionUiEvent(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? str : str2);
    }

    public final String getDebugName() {
        return this.debugName;
    }

    public final String getKey() {
        return this.key;
    }
}
