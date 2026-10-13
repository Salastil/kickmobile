package io.datazoom.sdk.openmeasurement;

import android.util.Log;
import android.view.View;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.iab.omid.library.amazon2.adsession.AdEvents;
import com.iab.omid.library.amazon2.adsession.AdSession;
import com.iab.omid.library.amazon2.adsession.media.InteractionType;
import com.iab.omid.library.amazon2.adsession.media.MediaEvents;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMSessionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u000bJ\b\u0010$\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OMSessionManager;", "", "<init>", "()V", "session", "Lcom/iab/omid/library/amazon2/adsession/AdSession;", "adEvents", "Lcom/iab/omid/library/amazon2/adsession/AdEvents;", "mediaEvents", "Lcom/iab/omid/library/amazon2/adsession/media/MediaEvents;", "setSession", "", "adSession", "view", "Landroid/view/View;", "initAdEvents", "startSession", "fireImpression", "fireLoaded", "vastProperties", "Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "firstQuartile", "midpoint", "adStart", "duration", "", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "thirdQuartile", "complete", PauseEvent.TYPE, "resume", "clickThrough", "bufferStart", "bufferFinish", "skipped", "finishSession", "initMediaEvents", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OMSessionManager {
    public static final OMSessionManager INSTANCE = new OMSessionManager();
    private static AdEvents adEvents;
    private static MediaEvents mediaEvents;
    private static AdSession session;

    private OMSessionManager() {
    }

    public final void setSession(AdSession adSession, View view) throws Exception {
        Intrinsics.checkNotNullParameter(adSession, "adSession");
        Intrinsics.checkNotNullParameter(view, "view");
        session = adSession;
        initMediaEvents();
        initAdEvents();
        AdSession adSession2 = session;
        if (adSession2 != null) {
            adSession2.registerAdView(view);
        }
    }

    private final void initAdEvents() throws Exception {
        try {
            adEvents = AdEvents.createAdEvents(session);
            Log.v("OMSessionManager", "Ad events created");
        } catch (Exception e) {
            Log.e("OMSessionManager", "Unable to create ad events");
            throw e;
        }
    }

    public final void startSession() {
        AdSession adSession = session;
        if (adSession != null) {
            adSession.start();
        }
    }

    public final void fireImpression() {
        AdEvents adEvents2 = adEvents;
        if (adEvents2 != null) {
            adEvents2.impressionOccurred();
        }
    }

    public final void fireLoaded(OMVastProperties vastProperties) {
        Intrinsics.checkNotNullParameter(vastProperties, "vastProperties");
        AdEvents adEvents2 = adEvents;
        if (adEvents2 != null) {
            adEvents2.loaded(OMSessionManagerKt.toVastProperties(vastProperties));
        }
    }

    public final void firstQuartile() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.firstQuartile();
        }
    }

    public final void midpoint() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.midpoint();
        }
    }

    public final void adStart(float duration, float volume) throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.start(duration, volume);
        }
    }

    public final void thirdQuartile() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.thirdQuartile();
        }
    }

    public final void complete() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.complete();
        }
    }

    public final void pause() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.pause();
        }
    }

    public final void resume() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.resume();
        }
    }

    public final void clickThrough() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.adUserInteraction(InteractionType.CLICK);
        }
    }

    public final void bufferStart() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.bufferStart();
        }
    }

    public final void bufferFinish() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.bufferFinish();
        }
    }

    public final void skipped() throws Exception {
        if (mediaEvents == null) {
            initMediaEvents();
        }
        MediaEvents mediaEvents2 = mediaEvents;
        if (mediaEvents2 != null) {
            mediaEvents2.skipped();
        }
    }

    public final void finishSession() {
        AdSession adSession = session;
        if (adSession != null) {
            adSession.finish();
        }
        session = null;
    }

    private final void initMediaEvents() throws Exception {
        try {
            mediaEvents = MediaEvents.createMediaEvents(session);
            Log.v("OMSessionManager", "Media events created");
        } catch (Exception e) {
            Log.e("OMSessionManager", "Unable to create media events");
            throw e;
        }
    }
}
