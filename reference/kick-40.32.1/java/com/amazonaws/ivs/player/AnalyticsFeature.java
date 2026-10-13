package com.amazonaws.ivs.player;

import org.json.JSONException;

/* JADX INFO: compiled from: NativeFeature.java */
/* JADX INFO: loaded from: classes5.dex */
class AnalyticsFeature extends NativeFeature {
    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
    }

    AnalyticsFeature() {
        super("analytics");
        this.isEnabled = true;
    }
}
