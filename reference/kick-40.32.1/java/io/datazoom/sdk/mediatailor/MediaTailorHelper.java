package io.datazoom.sdk.mediatailor;

import com.amazon.mediatailorsdk.PlaybackEvent;
import com.amazon.mediatailorsdk.Session;
import com.amazon.mediatailorsdk.SessionCommon;
import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.logs.Logger_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/mediatailor/MediaTailorHelper;", "", "<init>", "()V", "session", "Lcom/amazon/mediatailorsdk/Session;", "setMediaSession", "", "getMediaSession", "removeMediaSession", "updateProgress", "playHeadMs", "", "livePlayHeadMs", "(DLjava/lang/Double;)V", "sendAdPlaybackEvents", "event", "Lcom/amazon/mediatailorsdk/PlaybackEvent;", "onAdClickThrough", "onAdSkip", "sendAdSession", "adSessionMetadata", "Lio/datazoom/sdk/ad/DzAdSessionMetadata;", "mediatailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class MediaTailorHelper {
    public static final MediaTailorHelper INSTANCE = new MediaTailorHelper();
    private static Session session;

    private MediaTailorHelper() {
    }

    public final void setMediaSession(Session session2) {
        Intrinsics.checkNotNullParameter(session2, "session");
        session = session2;
    }

    public final Session getMediaSession() {
        return session;
    }

    public final void removeMediaSession() {
        session = null;
    }

    public final void updateProgress(double playHeadMs, Double livePlayHeadMs) {
        if (livePlayHeadMs != null) {
            Session session2 = session;
            if (session2 != null) {
                session2.onPlayheadUpdate(livePlayHeadMs.doubleValue() / 1000.0d, Double.valueOf(livePlayHeadMs.doubleValue() / 1000.0d));
                return;
            }
            return;
        }
        Session session3 = session;
        if (session3 != null) {
            SessionCommon.onPlayheadUpdate$default(session3, playHeadMs / 1000.0d, null, 2, null);
        }
    }

    public final void sendAdPlaybackEvents(PlaybackEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Session session2 = session;
        if (session2 != null) {
            session2.onPlaybackEvent(event);
        }
    }

    public final void onAdClickThrough() {
        Session session2 = session;
        if (session2 != null) {
            session2.onAdClickthrough();
        }
    }

    public final void onAdSkip() {
        Session session2 = session;
        if (session2 != null) {
            session2.onAdSkip();
        }
    }

    public final void sendAdSession(DzAdSessionMetadata adSessionMetadata) {
        Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
        AdTrackingResponse adTrackingResponse = IvsAdTrackingInfoParser.INSTANCE.parse(adSessionMetadata);
        if (adTrackingResponse == null) {
            return;
        }
        Logger_androidKt.getLogger().v("MediaTailor sending IVS ad tracking info for ad id " + adSessionMetadata.getAdId() + ", session id " + adSessionMetadata.getSessionId());
        Session session2 = session;
        if (session2 != null) {
            session2.updateAdTrackingInfo(adTrackingResponse);
        }
    }
}
