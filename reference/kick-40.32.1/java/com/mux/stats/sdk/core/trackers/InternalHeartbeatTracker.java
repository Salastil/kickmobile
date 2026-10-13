package com.mux.stats.sdk.core.trackers;

import com.google.common.base.Ascii;
import com.mux.stats.sdk.core.events.IEventDispatcher;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.AdEndedEvent;
import com.mux.stats.sdk.core.events.playback.AdPauseEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEndEvent;
import com.mux.stats.sdk.core.events.playback.InternalHeartbeatEvent;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlaybackEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.events.playback.RebufferStartEvent;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.ViewData;

/* JADX INFO: loaded from: classes8.dex */
public class InternalHeartbeatTracker extends BaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f257a;

    public InternalHeartbeatTracker(IEventDispatcher iEventDispatcher) {
        super(iEventDispatcher);
        this.f257a = false;
    }

    private void a(PlayerData playerData, ViewData viewData) {
        if (this.f257a) {
            this.f257a = false;
            InternalHeartbeatEndEvent internalHeartbeatEndEvent = new InternalHeartbeatEndEvent(playerData);
            internalHeartbeatEndEvent.setViewData(viewData);
            dispatch(internalHeartbeatEndEvent);
        }
    }

    private void b(PlayerData playerData, ViewData viewData) {
        InternalHeartbeatEvent internalHeartbeatEvent = new InternalHeartbeatEvent(playerData);
        internalHeartbeatEvent.setViewData(viewData);
        dispatch(internalHeartbeatEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mux.stats.sdk.core.trackers.BaseTracker
    protected void handlePlaybackEvent(PlaybackEvent playbackEvent) {
        String type = playbackEvent.getType();
        type.hashCode();
        byte b = -1;
        switch (type.hashCode()) {
            case -1535613269:
                if (type.equals(AdPlayingEvent.TYPE)) {
                    b = 0;
                }
                break;
            case -1422144041:
                if (type.equals(AdPlayEvent.TYPE)) {
                    b = 1;
                }
                break;
            case -1300510776:
                if (type.equals(RebufferEndEvent.TYPE)) {
                    b = 2;
                }
                break;
            case -1146889097:
                if (type.equals(AdEndedEvent.TYPE)) {
                    b = 3;
                }
                break;
            case -1137100877:
                if (type.equals(AdPauseEvent.TYPE)) {
                    b = 4;
                }
                break;
            case -906224361:
                if (type.equals(SeekedEvent.TYPE)) {
                    b = 5;
                }
                break;
            case -493563858:
                if (type.equals(PlayingEvent.TYPE)) {
                    b = 6;
                }
                break;
            case 3443508:
                if (type.equals(PlayEvent.TYPE)) {
                    b = 7;
                }
                break;
            case 57736207:
                if (type.equals(RebufferStartEvent.TYPE)) {
                    b = 8;
                }
                break;
            case 96651962:
                if (type.equals(EndedEvent.TYPE)) {
                    b = 9;
                }
                break;
            case 106440182:
                if (type.equals(PauseEvent.TYPE)) {
                    b = 10;
                }
                break;
            case 454234134:
                if (type.equals(ViewEndEvent.TYPE)) {
                    b = Ascii.VT;
                }
                break;
            case 1651552038:
                if (type.equals(AdBreakStartEvent.TYPE)) {
                    b = Ascii.FF;
                }
                break;
            case 1762557398:
                if (type.equals(TimeUpdateEvent.TYPE)) {
                    b = Ascii.CR;
                }
                break;
            case 2133546143:
                if (type.equals(AdBreakEndEvent.TYPE)) {
                    b = Ascii.SO;
                }
                break;
        }
        switch (b) {
            case 0:
            case 6:
                this.f257a = true;
                b(playbackEvent.getPlayerData(), playbackEvent.getViewData());
                break;
            case 1:
            case 7:
            case 12:
                PlayerData playerData = playbackEvent.getPlayerData();
                ViewData viewData = playbackEvent.getViewData();
                if (!this.f257a) {
                    this.f257a = true;
                    b(playerData, viewData);
                }
                break;
            case 2:
            case 8:
            case 13:
                if (this.f257a) {
                    b(playbackEvent.getPlayerData(), playbackEvent.getViewData());
                }
                break;
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
            case 14:
                a(playbackEvent.getPlayerData(), playbackEvent.getViewData());
                break;
            case 5:
                if (Boolean.TRUE.equals(playbackEvent.getPlayerData().getPlayerIsPaused())) {
                    a(playbackEvent.getPlayerData(), playbackEvent.getViewData());
                }
                break;
        }
    }
}
