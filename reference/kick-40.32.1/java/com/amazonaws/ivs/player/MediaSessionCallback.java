package com.amazonaws.ivs.player;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public class MediaSessionCallback extends MediaSession.Callback {
    private final Player player;

    public MediaSessionCallback(Player player) {
        this.player = player;
    }

    @Override // android.media.session.MediaSession.Callback
    public void onPlay() {
        this.player.play();
    }

    @Override // android.media.session.MediaSession.Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        this.player.load(uri);
        this.player.play();
    }

    @Override // android.media.session.MediaSession.Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        this.player.load(uri);
    }

    @Override // android.media.session.MediaSession.Callback
    public void onPause() {
        this.player.pause();
    }

    @Override // android.media.session.MediaSession.Callback
    public void onStop() {
        this.player.pause();
    }

    @Override // android.media.session.MediaSession.Callback
    public void onSeekTo(long j) {
        this.player.seekTo(j);
    }

    @Override // android.media.session.MediaSession.Callback
    public void onSetPlaybackSpeed(float f) {
        this.player.setPlaybackRate(f);
    }
}
