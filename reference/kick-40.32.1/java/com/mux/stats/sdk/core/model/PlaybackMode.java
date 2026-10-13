package com.mux.stats.sdk.core.model;

import com.facebook.hermes.intl.Constants;

/* JADX INFO: loaded from: classes8.dex */
public enum PlaybackMode {
    STANDARD(Constants.COLLATION_STANDARD),
    PICTURE_IN_PICTURE("pip"),
    MINI_PLAYER("miniplayer"),
    BACKGROUND("background"),
    FULLSCREEN("fullscreen"),
    INLINE("inline");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f249a;

    PlaybackMode(String str) {
        this.f249a = str;
    }

    public final String getModeValue() {
        return this.f249a;
    }
}
