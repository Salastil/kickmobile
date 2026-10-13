package com.iab.omid.library.amazon2.adsession.media;

import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.amazon2.adsession.AdSession;
import com.iab.omid.library.amazon2.adsession.a;
import com.iab.omid.library.amazon2.internal.i;
import com.iab.omid.library.amazon2.utils.c;
import com.iab.omid.library.amazon2.utils.g;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession) {
        a aVar = (a) adSession;
        g.a(adSession, "AdSession is null");
        g.f(aVar);
        g.c(aVar);
        g.b(aVar);
        g.h(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.d().a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        g.a(interactionType, "InteractionType is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "interactionType", interactionType);
        this.adSession.d().a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        g.a(this.adSession);
        this.adSession.d().a("bufferFinish");
    }

    public void bufferStart() {
        g.a(this.adSession);
        this.adSession.d().a("bufferStart");
    }

    public void complete() {
        g.a(this.adSession);
        this.adSession.d().a("complete");
    }

    public void firstQuartile() {
        g.a(this.adSession);
        this.adSession.d().a("firstQuartile");
    }

    public void midpoint() {
        g.a(this.adSession);
        this.adSession.d().a("midpoint");
    }

    public void pause() {
        g.a(this.adSession);
        this.adSession.d().a(PauseEvent.TYPE);
    }

    public void playerStateChange(PlayerState playerState) {
        g.a(playerState, "PlayerState is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "state", playerState);
        this.adSession.d().a("playerStateChange", jSONObject);
    }

    public void resume() {
        g.a(this.adSession);
        this.adSession.d().a("resume");
    }

    public void skipped() {
        g.a(this.adSession);
        this.adSession.d().a("skipped");
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "duration", Float.valueOf(f));
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        c.a(jSONObject, "deviceVolume", Float.valueOf(i.c().b()));
        this.adSession.d().a(ViewProps.START, jSONObject);
    }

    public void thirdQuartile() {
        g.a(this.adSession);
        this.adSession.d().a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        c.a(jSONObject, "deviceVolume", Float.valueOf(i.c().b()));
        this.adSession.d().a("volumeChange", jSONObject);
    }
}
