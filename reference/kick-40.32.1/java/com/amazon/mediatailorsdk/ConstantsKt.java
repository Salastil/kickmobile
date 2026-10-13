package com.amazon.mediatailorsdk;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"DEFAULT_OMID_PARTNER_NAME", "", "DEFAULT_OMID_PARTNER_VERSION", "DEFAULT_SUPPORTED_API_FRAMEWORKS", "", "", "getDEFAULT_SUPPORTED_API_FRAMEWORKS", "()Ljava/util/Set;", "DEFAULT_TRACKING_REQ_INTERVAL", "", "DEFAULT_INCOMING_AD_COUNTDOWN_INTERVAL", "MAX_PLAYHEAD_CONTINUITY_GAP", "DEFAULT_NONLINEAR_AD_DURATION", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConstantsKt {
    public static final double DEFAULT_INCOMING_AD_COUNTDOWN_INTERVAL = 5.0d;
    public static final double DEFAULT_NONLINEAR_AD_DURATION = 5.0d;
    public static final String DEFAULT_OMID_PARTNER_NAME = "MediaTailor";
    public static final String DEFAULT_OMID_PARTNER_VERSION = "1.0.0";
    private static final Set<Integer> DEFAULT_SUPPORTED_API_FRAMEWORKS = SetsKt.setOf((Object[]) new Integer[]{2, 9});
    public static final double DEFAULT_TRACKING_REQ_INTERVAL = 10.0d;
    public static final double MAX_PLAYHEAD_CONTINUITY_GAP = 2.5d;

    public static final Set<Integer> getDEFAULT_SUPPORTED_API_FRAMEWORKS() {
        return DEFAULT_SUPPORTED_API_FRAMEWORKS;
    }
}
